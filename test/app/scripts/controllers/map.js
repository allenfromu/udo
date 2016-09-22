'use strict';

/**
 * @ngdoc function
 * @name udooApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the udooApp
 */
  angular.module('udooApp')
    .controller('MapCtrl',['$scope','$http', function ($scope, $http) {
        $scope.centerAddr = "University of Utah, Salt Lake City, Utah";
        $scope.search = "tutor";
        $scope.centerLat = 40.0;
        $scope.centerLng = 40.0;
        var vm = this;
        vm.markers = [];


        $scope.getCenter = function(centerAddr1, search1){
         // var deferred = $q.defer();

          $http.get("https://maps.googleapis.com/maps/api/geocode/json?"+
          "address="+centerAddr1+"&key=AIzaSyCUaCUctKGJFs9UJ_H9tK0RyhFowEN9Y8Y")
          .then(function(response){
          //deferred.resolve(response.data);
          var data = response.data;
          console.log(data);
            var res = data["results"];
            var centerLat1;
            var centerLng1;
            if(res != undefined && res[0] != undefined){
              centerLat1 = res[0]["geometry"]["bounds"]["northeast"]["lat"];
              centerLng1 = res[0]["geometry"]["bounds"]["northeast"]["lng"];

            }
            $scope.getMarkers(centerLat1, centerLng1, search1);
          })
        }

        $scope.getMarkers = function(centerLat1, centerLng1, search1){
           //var deferred = $q.defer();
            vm.markers = [];
            var parameter = JSON.stringify({keyTerm:$scope.search1, geolat:$scope.centerLat1, geolng:$scope.centerLng1});
            var url = "http://localhost:8084/udoo-ws/rest/job/jobs/filter"
            $http.post(url, parameter).then(
              function(response){
                //deferred.resolve(response);
                var data = response.data;
                for(var i in data){
                  var marker = {

                  id: i,
                  latitude:data[i]["geolat"],

                  longitude:data[i]["geolng"],
                            showWindow: false,

                   options: {
                              animation: 1,
                              labelContent: 'Markers id '+i,
                              labelAnchor: "22 0",
                              labelClass: "marker-labels"
                   }

                  }
                  vm.markers.push(marker);
              }
                   $scope.map.control.refresh({latitude:centerLat1, longitude: centerLng1});

                           // $scope.map.control.refresh({latitude:$scope.centerLat, longitude: $scope.centerLng});

              }
            )
        }

          $scope.map = {
                    center: {
                        latitude: $scope.centerLat,
                        longitude: $scope.centerLng
                    },
                      zoom: 8,
                      control:{},

          };

          $scope.refreshMap = function(){
                   // $scope.refreshMap($scope.centerAddr,$scope.search);

              $scope.getCenter($scope.centerAddr,$scope.search);
              //$scope.getMarkers();
              //$scope.map.control.refresh({latitude:$scope.centerLat, longitude: $scope.centerLng});

          }

          $scope.refreshMap();






    }]);
