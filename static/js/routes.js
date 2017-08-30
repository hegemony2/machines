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

            // route for list view
            .when('/:object/list', {
                templateUrl : 'views/list.html',
                controller  : 'listController'
            })
            
            // route for read view
            .when('/:object/:mode/:id', {
                templateUrl : 'views/read.html',
                controller  : 'readController'
            })
            
    });