
app.service('tastingNotesService', function($q, $http) {

  var service = {};

  service.retrieveProductsByTastingNotes = function(keywords) {
    var query = {
      params: {keywords: keywords.join(',')}
    };
    var defer = $q.defer();
    $http.get('./products', query).then(function(response) {
      defer.resolve(response.data);
    });
    return defer.promise;
  };

  service.retrieveUserByUsername = function(username) {
    var query = {
      params: {username: username}
    };
    var defer = $q.defer();
    $http.get('./users', query).then(function(response) {
      defer.resolve(response.data);
    });
    return defer.promise;
  };

  service.loginUser = function(username, password) {
    var body = {
      username: username,
      password: password
    };
    var defer = $q.defer();
    $http.post('/login', body).then(function(response) {
      defer.resolve(response)
    });
    return defer.promise;
  };

  return service;
});


app.service('sessionService', function($q, $http) {
  var service = {};

  var currentUser;

  service.setCurrentUser = function(username) {
    currentUser = username;
  };

  service.getCurrentUser = function() {
    return currentUser;
  };

  return service;
});
