var appCustomer = angular.module("appCustomer", ['ngRoute']);

appCustomer.config(function($routeProvider){
	$routeProvider
	.when("/customers", {
		templateUrl: 'view/customer.html',
		controller: 'controller/customer-controller.js'
	})
	.when("/cities", {
		templateUrl: 'view/city.html'
	})
	.when("/states", {
		templateUrl: 'view/state.html'
	})
	.otherwise({redirectTo: '/'});
});