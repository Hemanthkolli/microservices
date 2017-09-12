/**
 * Created by user on 18/7/17.
 */
'use strict';

angular.module('Networks')

    .controller('NetworkController',
        ['$scope', '$rootScope','$window', '$location', 'NetworkServices',
            function ($scope, $rootScope,$window, $location,NetworkServices ) {
        	
        	
        	$scope.getdevices = function(){
				console.log("get_devices function is calling");
				NetworkServices.Get(function(response) {
					var data= response;
                    console.log(data);
                    $scope.devices = data.groupDevices;
                    console.log(data);
					
				});
			};
        	
        	
			
        			
            }]);



