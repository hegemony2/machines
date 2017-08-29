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

    automobilesApp.controller('modelsController', function($scope, $http) {
    	
    	$http.get('/services/AutomobileModel/schema').then(getSchema, errorCallback);
    	$http.get('/services/AutomobileModel/list').then(getList, errorCallback);

        function getSchema(response){
        	$scope.schema = response.data;
        }

        function getList(response){
        	$scope.list = response.data;
        }
        
    });
