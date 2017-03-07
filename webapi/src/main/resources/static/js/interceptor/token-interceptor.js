customerApp.factory("tokenInterceptor", function($q){

	return {
		'request' : function(config){
			config.headers.authorization = "Bearer " + localStorage.getItem("userToken");

			return config;
		}
	}
});