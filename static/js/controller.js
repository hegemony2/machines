    // create the controller and inject Angular's $scope
    scotchApp.controller('mainController', function($scope, $http) {
        // create a message to display in our view
        $scope.message = 'Everyone come and see how good I look!';
        
        $http.get('/Manufacturer/getListManufacturer').then(getListManufacturer, errorCallback);

        function getListManufacturer(response){
        	$scope.manufacturers = response.data;
        }
        function errorCallback(error){
            //error code
        }
        
        
    });

    scotchApp.controller('aboutController', function($scope) {
        $scope.message = 'Look! I am an about page.';
    });

    scotchApp.controller('contactController', function($scope) {
        $scope.message = 'Contact us! JK. This is just a demo.';
    });