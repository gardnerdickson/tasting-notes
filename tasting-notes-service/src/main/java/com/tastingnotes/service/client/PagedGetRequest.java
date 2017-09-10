package com.tastingnotes.service.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

class PagedGetRequest<T> implements Iterable<T>
{
    private final Logger logger = LoggerFactory.getLogger(PagedGetRequest.class);


    private final Function<Integer, ResponseEntity<List<T>>> requestFunction;

    public PagedGetRequest(Function<Integer, ResponseEntity<List<T>>> requestFunction)
    {
        this.requestFunction = requestFunction;
    }


    public List<T> getAll()
    {
        List<T> results = new ArrayList<>();
        for (T result : this)
        {
            results.add(result);
        }
        return results;
    }


    @Override
    public Iterator<T> iterator()
    {
        return new PageIterator();
    }


    private class PageIterator implements Iterator<T>
    {
        private boolean finished = false;
        private int nextPage = 1;
        private List<T> currentItems = new ArrayList<>();
        private int currentIndex = 0;


        @Override
        public boolean hasNext()
        {
            if (finished)
            {
                return false;
            }
            if (nextPage == 1)
            {
                return true;
            }

            if (currentIndex < currentItems.size())
            {
                return true;
            }
            else
            {
                currentItems = getNextPage();
                if (currentItems.isEmpty())
                {
                    finished = true;
                    return false;
                }
                else
                {
                    currentIndex = 0;
                    return true;
                }
            }
        }

        @Override
        public T next()
        {
            if (currentItems.isEmpty() || currentIndex >= currentItems.size())
            {
                currentItems = getNextPage();
                if (currentItems.isEmpty())
                {
                    finished = true;
                }
                currentIndex = 0;
            }
            T item = currentItems.get(currentIndex);
            currentIndex++;
            return item;
        }

        private List<T> getNextPage()
        {
            ResponseEntity<List<T>> response = requestFunction.apply(nextPage++);
            if (response.getStatusCode() != HttpStatus.OK)
            {
                throw new PagedRequestException("Failed to execute GET request. Status code is " + response.getStatusCodeValue());
            }
            List<T> items = response.getBody();
            logger.info("Got page with {} items.", items.size());
            return response.getBody();
        }

    }
}
