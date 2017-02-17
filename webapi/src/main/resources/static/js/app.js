var appCustomer = angular.module("appCustomer", []);

appCustomer.controller("indexController", function($scope, $http) {
	$scope.name = "Jhon";
	$scope.lastName = "Doe";
	$scope.customers = [];
	$scope.customer = {};

	$scope.loadCustomers = function() {
		$http({
			method:'GET',
			url:'http://localhost:8080/customers'
		})
		.then(
			function (response){
				$scope.customers = response.data;
				console.log(response.data);
				console.log(response.status);
			}, 
			function(response){
				console.log(response.data);
				console.log(response.status);
			});
	}

	$scope.cancelCustomerEdit = function() {
		$scope.customer = {};
	}

	$scope.loadCustomers();

	$scope.saveCustomer = function() {
		$http({
			method:'POST',
			url:'http://localhost:8080/customers',
			data: $scope.customer,
			headers: {
				'Content-Type': 'application/json'
			}
		})
		.then(
			function (response){
				// $scope.customers.push(response.data);
				$scope.customer = {};
				$scope.loadCustomers();
				console.log(response.data);
				console.log(response.status);
			}, 
			function(response){
				console.log(response.data);
				console.log(response.status);
			});
	}

	$scope.deleteCustomer = function(customer, position) {
		$http({
			method:'DELETE',
			url:'http://localhost:8080/customers/' + customer.id,
			headers: {
				'Content-Type': 'application/json'
			}
		})
		.then(
			function (response){
				$scope.customers.splice(position, 1);
			}, 
			function(response){
				console.log(response.data);
				console.log(response.status);
			});
	}

	$scope.editCustomer = function(customer) {
		$scope.customer = angular.copy(customer);
	}
});