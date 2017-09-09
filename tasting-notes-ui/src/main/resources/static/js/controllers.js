app.controller('search', function($log, $scope, tastingNotesService) {

  $scope.message = "HELLO WORLD!";

  $scope.searchClick = function() {

    if (_.isEmpty($scope.tags)) {
      // TODO: show an error somewhere on the page.
    }

    var keywords = _.map($scope.tags, function(tag) {
      return tag.text
    });


    $log.info("Keywords are: ", keywords);

    tastingNotesService.retrieveProductsByTastingNotes(keywords).then(function(products) {

      var names = [];
      _.each(products, function(product) {
        names.push(product.name);
      });

      alert("Products are: " + names);
    });
  };

});

