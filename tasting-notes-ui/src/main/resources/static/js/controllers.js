app.controller('search', function($log, $scope, tastingNotesService) {

  $scope.message = "HELLO WORLD!";

  $scope.submit = function() {

    if (_.isEmpty($scope.tags)) {
      // TODO: show an error somewhere on the page.
    }

    var keywords = _.map($scope.tags, function(tag) {
      return tag.text
    });

    $log.info("Keywords are: ", keywords);

    tastingNotesService.retrieveProductsByTastingNotes(keywords).then(function(products) {
      $scope.products = products;
    });
  };

});

