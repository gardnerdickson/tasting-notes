app.controller('searchController', function($log, $scope, $location, $http, $rootScope, sessionService) {

  $scope.loading = false;
  $scope.currentUser = sessionService.getCurrentUser();

  $scope.error = {
    show: false,
    message: "Please enter search tags"
  };

  $scope.formChange = function() {
    $log.info("formChange got called");
    $scope.error.show = false;
  };

  $scope.loginOrCreateAccount = function() {
    $location.path("/userLogin")
  };

  $scope.addToFavorites = function(productId) {
    $log.info("Adding product with ID ", productId, " to favorites.");
    var body = {
      id: productId
    };
    $http.post('/favorites', body).then(
      function success(response) {
        $log.info("Added product to favorites.", response)
      },
      function error(response) {
        $log.error("Failed to add product to favorites: ", response);
      }
    );
  };

  $scope.openFavorites = function() {
    $location.path('userFavorites')
  };

  $scope.submit = function() {

    if (_.isEmpty($scope.tags)) {
      $scope.error.show = true;
      return;
    }

    var keywords = _.map($scope.tags, function(tag) {
      return tag.text
    });

    $log.info("Keywords are: ", keywords);

    $scope.loading = true;
    var query = {
      params: {keywords: keywords.join(',')}
    };
    $http.get('./products', query).then(
      function success(response) {
        $scope.products = response.data;
        // $rootScope.$broadcast('PRODUCTS_RECEIVED', response.data);
        $scope.loading = false;
      }
    );
  };
});



app.controller('loginController', function($log, $rootScope, $scope, $location, $http, sessionService) {

  $scope.login = {};
  $scope.create = {};


  $scope.loginSubmit = function() {
    var body = {
      username: $scope.login.username,
      password: $scope.login.password
    };
    $log.info("Logging in user: ", $scope.login.username);
    $http.post('/login', body).then(
      function success(response) {
        sessionService.setCurrentUser($scope.login.username);
        $location.path('/userFavorites')
      },
      function error(response) {
        $log.info("Failure: ", response)
      }
    );


  }

});


app.controller('favoritesController', function($log, $scope, $http, $location, sessionService) {

  $scope.favorites = {};

  function loadFavorites() {

    $http.get("/favorites").then(
      function success(response) {
        $log.log("Success: ", response);
        // $rootScope.$broadcast('PRODUCTS_RECEIVED', response.data)
        $scope.products = response.data;
      },
      function error(response) {
        $log.log("Error: ", response);
      }
    )

  }

  $scope.openSearch = function() {
    $location.path("/")
  };

  $scope.checkCurrentUser = function() {
    return sessionService.getCurrentUser() !== undefined
  };

  loadFavorites();

});

 