appCustomer.controller("customerDetailController", function($scope, $routeParams, $http){
	$scope.customer = {};

	$http.get("customers/" + $routeParams.customerId).then(function(response){
		$scope.customer = response.data;
	}, function(response){
		console.log(response);
	});
});