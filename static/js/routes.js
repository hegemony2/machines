    // configure our routes
    automobilesApp.config(function($locationProvider, $routeProvider) {
    	$locationProvider.hashPrefix('');
    	$locationProvider.html5Mode(false);
    	$routeProvider

            // route for the home page
            .when('/', {
                templateUrl : 'views/home.html',
                controller  : 'mainController'
            })

            // route for the about page
            .when('/models', {
                templateUrl : 'views/models.html',
                controller  : 'modelsController'
            })
    });