package com.tastingnotes.service.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LcboProductPager
{
    @JsonProperty("records_per_page")
    private int recordsPerPage;

    @JsonProperty("total_record_count")
    private int totalRecordCount;

    @JsonProperty("current_page_record_count")
    private int currentPageRecordCount;

    @JsonProperty("is_first_page")
    private boolean isFirstPage;

    @JsonProperty("is_final_page")
    private boolean isFinalPage;

    @JsonProperty("current_page")
    private int currentPage;

    @JsonProperty("current_page_path")
    private String currentPagePath;

    @JsonProperty("next_page")
    private int nextPage;

    @JsonProperty("next_page_path")
    private String nextPagePath;

    @JsonProperty("previous_page")
    private int previousPage;

    @JsonProperty("previous_page_path")
    private String previousPagePath;

    @JsonProperty("total_pages")
    private int totalPages;

    @JsonProperty("total_pages_path")
    private String totalPagesPath;

    public int getRecordsPerPage()
    {
        return recordsPerPage;
    }

    public void setRecordsPerPage(int recordsPerPage)
    {
        this.recordsPerPage = recordsPerPage;
    }

    public int getTotalRecordCount()
    {
        return totalRecordCount;
    }

    public void setTotalRecordCount(int totalRecordCount)
    {
        this.totalRecordCount = totalRecordCount;
    }

    public int getCurrentPageRecordCount()
    {
        return currentPageRecordCount;
    }

    public void setCurrentPageRecordCount(int currentPageRecordCount)
    {
        this.currentPageRecordCount = currentPageRecordCount;
    }

    public boolean isFirstPage()
    {
        return isFirstPage;
    }

    public void setFirstPage(boolean firstPage)
    {
        isFirstPage = firstPage;
    }

    public boolean isFinalPage()
    {
        return isFinalPage;
    }

    public void setFinalPage(boolean finalPage)
    {
        isFinalPage = finalPage;
    }

    public int getCurrentPage()
    {
        return currentPage;
    }

    public void setCurrentPage(int currentPage)
    {
        this.currentPage = currentPage;
    }

    public String getCurrentPagePath()
    {
        return currentPagePath;
    }

    public void setCurrentPagePath(String currentPagePath)
    {
        this.currentPagePath = currentPagePath;
    }

    public int getNextPage()
    {
        return nextPage;
    }

    public void setNextPage(int nextPage)
    {
        this.nextPage = nextPage;
    }

    public String getNextPagePath()
    {
        return nextPagePath;
    }

    public void setNextPagePath(String nextPagePath)
    {
        this.nextPagePath = nextPagePath;
    }

    public int getPreviousPage()
    {
        return previousPage;
    }

    public void setPreviousPage(int previousPage)
    {
        this.previousPage = previousPage;
    }

    public String getPreviousPagePath()
    {
        return previousPagePath;
    }

    public void setPreviousPagePath(String previousPagePath)
    {
        this.previousPagePath = previousPagePath;
    }

    public int getTotalPages()
    {
        return totalPages;
    }

    public void setTotalPages(int totalPages)
    {
        this.totalPages = totalPages;
    }

    public String getTotalPagesPath()
    {
        return totalPagesPath;
    }

    public void setTotalPagesPath(String totalPagesPath)
    {
        this.totalPagesPath = totalPagesPath;
    }
}
