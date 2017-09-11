var app = angular.module('tastingNotes', ['ngTagsInput', 'ngRoute']);

app.config(function($routeProvider) {
  $routeProvider
    .when("/", {
      templateUrl: '/html/search.html',
      controller: 'searchController'
    })
    .when("/userLogin", {
      templateUrl: '/html/user-login.html',
      controller: 'loginController'
    })
    .when("/userFavorites", {
      templateUrl: '/html/user-favorites.html',
      controller: 'favoritesController'
    })
});

