var appCustomer = angular.module("appCustomer", ['ngRoute']);

appCustomer.config(function($routeProvider, $locationProvider){
	$routeProvider
	.when("/customers", {
		templateUrl: 'view/customer.html',
		controller: 'customerController'
	})
	.when("/cities", {
		templateUrl: 'view/city.html',
		controller: 'cityController'
	})
	.when("/states", {
		templateUrl: 'view/state.html',
		controller: 'stateController'
	})
	.otherwise({redirectTo: '/'
	});
	
	$locationProvider.html5Mode(true);
});