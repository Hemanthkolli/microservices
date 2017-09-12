'use strict';

// declare modules
angular.module('Authentication', []);
angular.module('Home', []);
angular.module('Register', []);
angular.module('Device_Register', []);
angular.module('Dashboard', []);
angular.module('Networks', []);

angular.module('App', [
    'Authentication',
    'Home',
	'Register',
    'Device_Register',
    'Dashboard',
    'Networks',
    'ngRoute',
    'ngCookies'
])
 
.config(['$routeProvider', function ($routeProvider) {

    $routeProvider
       /* .when('/login', {
            controller: 'LoginController',
            templateUrl: 'modules/authentication/views/login.html',
            hideMenus: true
        })*/
        
        .when('/home', {
            controller: 'HomeController',
            templateUrl: 'modules/home/views/home.html',
			hideMenus: true
        })
 
  		.when('/register', {
            controller: 'RegisterController',
            templateUrl: 'modules/register/register.html',
			hideMenus: true
        })
		
		.when('/dashboard', {
            controller: 'DashboardController',
            templateUrl: 'modules/dashboard/dashboard.html',
            hideMenus: true
        })
        
        .when('/networks', {
            controller: 'NetworkController',
            templateUrl: 'modules/networks/networks.html',
            hideMenus: true
        })

        .when('/device_registration', {
            controller: 'Device_RegisterController',
            templateUrl: 'modules/Device_Register/deviceregister.html',
            hideMenus: true
        })
 
        .otherwise({ redirectTo: '/home' });
}])


 
.run(['$rootScope', '$location', '$cookieStore', '$http',
    function ($rootScope, $location, $cookieStore, $http) {
        // keep user logged in after page refresh
        $rootScope.globals = $cookieStore.get('globals') || {};
        if ($rootScope.globals.currentUser) {
            $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata; // jshint ignore:line
        }
 
        $rootScope.$on('$locationChangeStart', function (event, next, current) {
   			var restrictedPage = $.inArray($location.path(), ['/login', '/register','/home','/dashboard','/networks','/device_registration']) === -1;
            var loggedIn = $rootScope.globals.currentUser;
            //var username = loggedIn.email;
           
          //  var username = $rootScope.globals.currentUser.email;
           
            if (restrictedPage && !loggedIn) {
                $location.path('/login');
            }
        });
    }]);
	

       
 
       
            