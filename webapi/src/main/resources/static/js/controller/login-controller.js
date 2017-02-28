appCustomer.controller("loginController", function($scope, $http){
	$scope.user = {};

	$scope.authenticate = function(){
		$http.post("/authenticate", $scope.user)
			.then(function(response){
				console.log("Success: " + response);
			},
			function(response){
				console.log("Error: " + response);
			})

		console.log("Authenticate called " + $scope.user.name + " " + $scope.user.password);
	}
})