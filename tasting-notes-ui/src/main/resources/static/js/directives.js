
app.directive('resultsTable', function(sessionService) {
  return {
    templateUrl: 'html/results-table.html',
    restrict: 'A',
    link: function(scope, element, attrs) {
      scope.showFavoritesButton = (scope.currentUser !== undefined && attrs.enableFavoritesButton === 'true')
    }
  }
});
