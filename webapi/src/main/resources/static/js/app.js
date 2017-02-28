var appCustomer = angular.module("appCustomer", ['ngRoute']);

appCustomer.config(function($routeProvider, $locationProvider){
	$routeProvider
	.when("/customers", {
		templateUrl: 'view/customer.html',
		controller: 'customerController'
	})
	.when("/customers/:customerId", {
		templateUrl: 'view/customer-detail.html',
		controller: 'customerDetailController'
	})
	.when("/cities", {
		templateUrl: 'view/city.html',
		controller: 'cityController'
	})
	.when("/states", {
		templateUrl: 'view/state.html',
		controller: 'stateController'
	})
	.when("/login", {
		templateUrl: 'view/login.html',
		controller: 'loginController'
	})
	.otherwise({redirectTo: '/'
	});
	
	$locationProvider.html5Mode(true);
});