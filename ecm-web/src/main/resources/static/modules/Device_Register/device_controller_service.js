/**
 * Created by user on 18/7/17.
 */
'use strict';

angular.module('Device_Register')

    .factory('DeviceRegistrationService',
        ['Base64', '$http', '$cookieStore', '$rootScope', '$timeout',
            function (Base64, $http, $cookieStore, $rootScope, $timeout) {
                var service = {};
                
                service.Get = function (ecmLicenseKey,invoiceNumber,serial, callback) {
                	console.log("2");
                	console.log(ecmLicenseKey);
                	console.log(invoiceNumber);
                	console.log(serial);
                    $http.post('/ecm-device/devicesCRM', { ecmLicenseKey : ecmLicenseKey,invoiceNumber :invoiceNumber,serial :serial })
                    	
                        .success(function (response) {
                        	console.log("3");
                            callback(response);
                        });

                };
                
                service.Register = function(productClass, oui,serial,userName, callback ){
                	
                	console.log("register service function is called");
                	console.log(productClass);
                	console.log(oui);
                	console.log(serial);
                	 $http.post('/ecm-device/registerDevices', { productClass : productClass, oui:oui ,serial :serial,userName :userName  })
                 	
                     .success(function (response) {
                     	
                         callback(response);
                     });
                };
                
                
                return service;
            }])