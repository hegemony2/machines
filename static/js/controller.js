    // create the controller and inject Angular's $scope
    automobilesApp.controller('mainController', function($scope, $http) {
        
        $http.get('/services/Manufacturer/getListManufacturer').then(getListManufacturer, errorCallback);

        function getListManufacturer(response){
        	$scope.manufacturers = response.data;
        }
        function errorCallback(error){
            //error code
        }
        
        
    });

    automobilesApp.controller('listController', function($scope, $http, $route) {

    	$scope.object = $route.current.params.object;
 	
    	$http.get("/services/" + $scope.object + "/schema").then(getSchema, errorCallback);
    	$http.get("/services/" + $scope.object + "/list").then(getList, errorCallback);

        function getSchema(response){
        	$scope.schema = response.data;
        }

        function getList(response){
        	$scope.list = response.data;
        }
        
        function errorCallback(error){
            //error code
        }
        
    });
    
    automobilesApp.controller('readController', function($scope, $http, $route, $parse) {

    	var object = $route.current.params.object;
    	var id = $route.current.params.id;
    	$scope.mode = $route.current.params.mode;
 	
    	$http.get("/services/" + object + "/schema").then(getSchema, errorCallback);
    	$http.get("/services/" + object + "/read/" + id).then(getRead, errorCallback);
    	
    	$scope.getFieldEditability = getFieldEditability;
    	$scope.getFieldType = getFieldType;
    	
        function getSchema(response){
        	$scope.schema = response.data;
        	for (var property in response.data.properties) {
        		if (response.data.properties[property].type=="object") {
        			var className = response.data.properties[property].id.substring(response.data.properties[property].id.lastIndexOf(":") + 1);
        			$http.get("/services/" + className + "/list").then(getSelectObject, errorCallback);
        		}
        	}
        }

        function getRead(response){
        	$scope.read = response.data;
        }
        
        function getSelectObject(response){
        	var className=response.config.url.substring(response.config.url.indexOf("/services/") + 10, response.config.url.indexOf("/list"));
        	$parse("selectObject." + className).assign($scope, response.data);
        	
        	$scope.manufacturer="Chevrolet";

        	
        	console.log("hello");
        }
        
        function errorCallback(error){
            //error code
        }
        
    });
