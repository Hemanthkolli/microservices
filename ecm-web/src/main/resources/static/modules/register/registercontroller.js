
'use strict';

angular.module('Register')
	.controller('RegisterController',
	['$scope', '$rootScope','$window', '$location', 'UserService',
	function ($scope, $rootScope,$window, $location, UserService) {
		$scope.register = function () {
            $scope.dataLoading = true;
            UserService.register($scope.email,$scope.fullname, $scope.password,$scope.confirmpassword,$scope.company,$scope.address,$scope.region, function(response) {
				console.log(response);
                if(response == "success"){
					alert("user ia added successfully");
                    $window.location.href = 'index.html';
                }else if(response == "error"){
					console.log("Internal Server Error");
   					alert("Email-id is already exist , please try again with another one");
                    console.log($scope.errormsg);
                    $scope.dataloading = false;
                }
            },
                function(response){
                    $scope.dataloading = false;

            });
        
        };	
    }]);

function checkPass()
{
	console.log("validation...");
    
    var password = document.getElementById('password');
    var confirmpassword = document.getElementById('confirmpassword');
	    
    var message = document.getElementById('confirmMessage');
    
    var goodColor = "#66cc66";
    var badColor = "#ff6666";
   
    if(password.value == confirmpassword.value){
        confirmpassword.style.backgroundColor = goodColor;
        message.style.color = goodColor;
        message.innerHTML = "Passwords Match!"
    }else{
        confirmpassword.style.backgroundColor = badColor;
        message.style.color = badColor;
        message.innerHTML = "Passwords Do Not Match!"
    }
	return;
} 

