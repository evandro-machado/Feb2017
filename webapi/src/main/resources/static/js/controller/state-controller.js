appCustomer.controller("stateController", function($scope, $http){
	$scope.states = [];

	$scope.loadStates = function() {
		$http({
			method:'GET',
			url:'http://localhost:8080/states'
		})
		.then(
			function (response){
				$scope.states = response.data;
				console.log(response.data);
				console.log(response.status);
			}, 
			function(response){
				console.log(response.data);
				console.log(response.status);
			});
	}

	$scope.loadStates();
});