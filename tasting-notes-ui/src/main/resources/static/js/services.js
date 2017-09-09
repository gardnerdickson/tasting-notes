
app.service('tastingNotesService', function($q, $http) {

  var service = {};

  service.retrieveProductsByTastingNotes = function(keywords) {
    var config = {
      params: {keywords: keywords}
    };
    var defer = $q.defer();
    $http.get("./products", config).then(function(response) {
      defer.resolve(response.data);
    });
    return defer.promise;
  };

  return service;
});
