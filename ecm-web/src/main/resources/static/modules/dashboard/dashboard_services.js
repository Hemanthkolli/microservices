/**
 * Created by user on 18/7/17.
 */
'use strict';

angular.module('Dashboard')

    .factory('DashboardServices',
        ['Base64', '$http', '$cookieStore', '$rootScope', '$timeout',
            function (Base64, $http, $cookieStore, $rootScope, $timeout) {
                var service = {};
                
                service.Get = function (callback) {
                	console.log("2");
                	console.log("service function is called");
                    $http.get('/ecm-device/devices')
                    	
                        .success(function (response) {
                        	console.log("3");
                        	console.log("response is obtained");
                            callback(response);
                        });

                };
                
                
                return service;
            }])