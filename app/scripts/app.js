'use strict';

/**
 * @ngdoc overview
 * @name udooApp
 * @description
 * # udooApp
 *
 * Main module of the application.
 */
angular
  .module('udooApp', [
    'ngResource',
    'ngRoute',
    'uiGmapgoogle-maps'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/searchablemap.html',
        controller: 'MapCtrl as MC',
        //controllerAs: 'main'
      })
      .otherwise({
        redirectTo: '/'
      });
  });
