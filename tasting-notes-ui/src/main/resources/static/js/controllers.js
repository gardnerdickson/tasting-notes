
app.controller('search', function($log, $scope, tastingNotesService) {

  $scope.message = "HELLO WORLD!";

  $scope.searchClick = function() {

    var keywords = _.map($scope.tags, function(tag){
      return tag.text
    });

    $log.info("Keywords are: ", keywords);

    tastingNotesService.retrieveProductsByTastingNotes(keywords).then(function(products) {
      alert("Products are: " + products);
    });
  };

});

