/**
 * Created by user on 18/7/17.
 */
'use strict';

angular.module('Device_Register')

    .controller('Device_RegisterController',
        ['$scope', '$rootScope','$window', '$location', 'DeviceRegistrationService',
            function ($scope, $rootScope,$window, $location, DeviceRegistrationService) {
        	
        			
        			$scope.register = function (devices) {
                  	 console.log("hello register function is working");
                  	//var loggedIn = $rootScope.globals.currentUser;
                   
                   
                  var userName = $rootScope.globals.currentUser.email;
                  	
                  console.log(userName);
                    
                  	 
                  	 angular.forEach($scope.devices, function (devices) {
                  	 
     	                if(devices.selected){
     	                	console.log(devices.productClass);
     	                	console.log(userName);
     	                	DeviceRegistrationService.Register(devices.productClass, devices.oui,devices.serial,userName, function(response) {
                                console.log(response);
                                
                              
                                if(response == "registered"){
                                	devices.selected = false;
                                		
                                	console.log(devices.selected);
                                	
                                	$window.location.href = '/#/dashboard';
                             
                                }else{
                                	devices.selected = false;
                                	console.log(response);
                                	alert(response);
                                }
                                
                                
                                
     	                });
     	                }
                  	 
     	            });
                  	 
                  
                  
                  
                  	 
                  	/*DeviceRegistrationService.Register($scope.ecmLicenseKey, $scope.invoiceNumber,$scope.serialNum , function(response) {
                        var data= response;
                        
                        $scope.devices = data.Devices;
                        console.log(data);
                        console.log(data.Devices.length);
                        
                                   
                                     
                                                  
                        {$scope.names = response.Devices;}
                        console.log($scope.names);
                        
                       
                       
                       
                        if(response == "success"){

                        	console.log("Device registered successfully");


                        }
                  	}  */
        			}
        			 
        			
        			//this function is loaded on device_registration pafe reload
        			$scope.getdevices = function(){
        				console.log("get_devices function is calling");
        				alert("123");
        			}
        			
        			
        			//this function is called when dashoard page is called
        			$(function(){

        				   $("#hit").on("click",function(){

        				      alert("456");

        				  });

        				});
        			
        			
        			
        			
        			$scope.checkAll = function () {
        	            if (!$scope.selectedAll) {
        	                $scope.selectedAll = true;
        	            } else {
        	                $scope.selectedAll = false;
        	            }
        	            angular.forEach($scope.devices, function (devices) {
        	                devices.selected = $scope.selectedAll;
        	                console.log(devices);
        	                console.log(devices.oui);
        	            });
        	        };  
        	        
        	        
        	       /* $scope.check = function () {
        	            if (!$scope.device.selected) {
        	                $scope.device.selected = true;
        	                console.log(device.selected);
        	            } else {
        	                $scope.device.selected = false;
        	            }
        	            angular.forEach($scope.device, function (devices) {
        	                device.selected = $scope.device.selected;
        	                console.log(device);
        	                console.log(device.oui);
        	            });
        	        }; 
        			*/
        			
                
                   $scope.get = function () {
                	   console.log("hello get function is working");
                	
                	   console.log($scope.serial);
                	  
                	 
                    $scope.dataLoading = true;
                   
                    DeviceRegistrationService.Get($scope.ecmLicenseKey, $scope.invoiceNumber,$scope.serial , function(response) {
                            var data= response;
                            
                            $scope.devices = data.Devices;
                            console.log(data);
                            console.log(data.Devices.length);
                            {$scope.names = response.Devices;}
                            console.log($scope.names);
                            if(response == "success"){

                            	console.log("5");


                            }else if(response == "{ }"){
                                $scope.errormsg = 'licence key or invoiceNumber id is '+ ' '  +response;
                                alert("invalid licence key or invoiceNumber id");
                                console.log($scope.errormsg);
                                $scope.dataloading = false;

                            }
                            else{
                            	console.log("6")
                            	console.log(data.deviceModelNumber);
                            	console.log(data.oui);
                            	console.log(data.serial);
                            }
                        },
                        function(response){
                            $scope.dataloading = false;


                        });

                };
            }]);



