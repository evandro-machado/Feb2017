appCustomer.factory("tokenInterceptor", function($q, $location){

	return {
		'request' : function(config){
			config.headers.authorization = "Bearer " + localStorage.getItem("userToken");

			return config;
		},
		'responseError' :function(rejection){
			if(rejection.status == 500){
				location.path("/login");
			}
			return $q.reject(rejection);
		}
	}
});