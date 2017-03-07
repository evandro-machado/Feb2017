appCustomer.controller("loginController", function($scope, $http){
	$scope.user = {};

	$scope.token = "";

	$scope.authenticate = function(){
		$http.post("/authenticate", $scope.user)
			.then(function(response){
				console.log("Success: " + response);
				$scope.token = response.data.token;
				localStorage.setItem("userToken", response.data.token)
			},
			function(response){
				console.log("Error: " + response);
			})

		console.log("Authenticate called " + $scope.user.name + " " + $scope.user.password);
	}
})