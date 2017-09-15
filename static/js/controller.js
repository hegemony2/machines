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

    automobilesApp.controller('listController', function($scope, $http, $route, $location) {

    	$scope.object = $route.current.params.object;
    	$scope.showField = showField;
    	$scope.getFieldDisplayType = getFieldDisplayType;
    	$scope.getFieldLabel = getFieldLabel;
    	
        var url=$location.absUrl().split('?')[0];
    	$scope.className=url.substring(url.indexOf("#/") + 2);
 	
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
    
    automobilesApp.controller('readController', function($scope, $http, $route, $parse, $location, $window) {

    	$scope.showField = showField;
    	$scope.getFieldDisplayType = getFieldDisplayType;
    	$scope.getFieldEditType = getFieldEditType;
       	$scope.getFieldLabel = getFieldLabel;
       	$scope.goBack = goBack;
    	
    	var object = $route.current.params.object;
    	var id = $route.current.params.id;
    	$scope.mode = $route.current.params.mode;
    	
        var url=$location.absUrl().split('?')[0];
    	$scope.className=url.substring(url.indexOf("#/") + 2);
 	
    	$http.get("/services/" + object + "/schema").then(getSchema, errorCallback);
    	if ($scope.mode!='create') {
    		$http.get("/services/" + object + "/read/" + id).then(getRead, errorCallback);	
    	}
    	
    	
        function getSchema(response){
        	$scope.schema = response.data;
        	for (var prop in response.data.properties) {
        		if ($scope.mode=="create" && !response.data.properties[prop].id) {
// standard field... need to intialize the scope so that the html fields can bind to it        			
        			$parse("read." + prop).assign($scope, "");
        		}
        		if (response.data.properties[prop].id) {
// we have an object... need to set up tree selector        			
        			var className = response.data.properties[prop].type;
        			var propertyName = prop;
        			var bindParentObjectDataCallback = function(response) {
        				bindParentObjectData(propertyName, response);
        			}
        			$parse("read." + prop + ".id").assign($scope, "");
        			$http.get("/services/" + className + "/list").then(bindParentObjectDataCallback, errorCallback);
        		}
        	}
        }
        
        function getRead(response){
        	$scope.read=response.data;
        }
        
        function bindParentObjectData(property, response){
 //       	var className=response.config.url.substring(response.config.url.indexOf("/services/") + 10, response.config.url.indexOf("/list"));
        	$parse("parentObject." + property + ".data").assign($scope, response.data);        	
        	console.log("writing parentObject for " + propertyName);
        }
        
        function errorCallback(error){
            //error code
        }
        
        $scope.submitForm=function() {
        	console.log("form submitted;");
        	var data = $scope.read;
        	var url = "/services/" + object + "/update/" + id;
        	console.log($scope.mode);
        	if ($scope.mode=="create") {
        		url = "/services/" + object + "/create";
        		$http.post(url, data).then(goBack, errorCallback);
        	}
        	else {
        		$http.patch(url, data).then(goBack, errorCallback);	
        	}
        }
        
        $scope.deleteObject=function() {
        	console.log("deleting object;");
        	data=null;
        	var url = "/services/" + object + "/delete/" + id;
        	console.log(url);
       		$http.delete(url, data).then(goBack, errorCallback);	
        }

        
    });
    
