
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
