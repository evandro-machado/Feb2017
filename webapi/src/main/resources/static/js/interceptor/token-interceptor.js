appCustomer.factory("tokenInterceptor", function($q){

	return {
		'request' : function(config){
			config.headers.authorization = "Bearer " + localStorage.getItem("userToken");

			return config;
		},
		'response' :function(response){
			if(response.status == 500){
				location.path("/login");
			}
			return response;
		}
	}
});