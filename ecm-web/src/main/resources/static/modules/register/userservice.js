'use strict';
 
angular.module('Register')
 
.factory('UserService',
    ['Base64', '$http', '$cookieStore', '$rootScope', '$timeout',
    function (Base64, $http, $cookieStore, $rootScope, $timeout) {
        var service = {};
       	
			service.register = function ( email,fullName, password,confirmPassword,company,address,region, callback) {
            $http.post('/ecm-device/register', {email: email,fullName: fullName,password: password,confirmPassword: confirmPassword,company: company,address: address,region: region})
                .success(function (response) {
                    callback(response);
                });
        };
		
		return service;
	}]);