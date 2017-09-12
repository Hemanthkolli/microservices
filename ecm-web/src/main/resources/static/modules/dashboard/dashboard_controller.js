/**
 * Created by user on 18/7/17.
 */
'use strict';

angular.module('Dashboard')

    .controller('DashboardController',
        ['$scope', '$rootScope','$window', '$location', 'DashboardServices',
            function ($scope, $rootScope,$window, $location, DashboardServices) {
        	
        	
        	$scope.getdevices = function(){
				console.log("get_devices function is calling");
				DashboardServices.Get(function(response) {
					var data= response;
                    
                    $scope.devices = data.Devices;
                    console.log(data);
					
				});
			};
        	
        	
			
        			
            }]);



