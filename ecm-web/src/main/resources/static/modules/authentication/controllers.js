'use strict';
 
angular.module('Authentication')
 
.controller('LoginController',
    ['$scope', '$rootScope','$window', '$location', 'AuthenticationService',
    function ($scope, $rootScope,$window, $location, AuthenticationService) {
        // reset login status
        AuthenticationService.ClearCredentials();
 
        $scope.login = function () {
            $scope.dataLoading = true;
            
            AuthenticationService.Login($scope.username, $scope.password, function(response) {
				
                if(response == "success"){
                	 AuthenticationService.SetCredentials($scope.username, $scope.password);    
                	//console.log(userData);
                	AuthenticationService.Get(function(response) {
    					var data= response;
                        
                        
                        console.log(data.groupDevices.length);
                        if((data.groupDevices.length) != 0 ){
                        	$window.location.href = '/#/networks';
                        }else{
                        	
                        	$window.location.href = '/#/home';
                        }
    					
    				});
                	
                //  $window.location.href = '/#/home';
                   
                 
                }else if(response == "invalid"){
                    $scope.errormsg = 'username or password is'  +response;
					alert("Invalid username or password");
                    console.log($scope.errormsg);
                    $scope.dataloading = false;
                   
                }
            },
                function(response){
                    $scope.dataloading = false;
                });
        
        };
        
               
    }]);


	
	

	