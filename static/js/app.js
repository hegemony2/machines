var automobilesApp = angular.module('automobilesApp', ['ngRoute']);

function isFieldUpdatable(mode, property, data) {
	
	var editability = (mode=="read") ? false : true;
	var readOnlyFields=["id","updated","created","updatedBy","createdBy"];
	if (readOnlyFields.indexOf(property)>-1) editability=false;
	return(editability);
	
}

function getFieldType(mode, property, data) {
	
	var type = "text";
	if (data.type=="integer" && data.format=="utc-millisec") type = "datetime";
	if (data.type=="object") type="object";
	return(type);
	
}

automobilesApp.directive('dynamicNgModel', ['$compile', '$parse', function ($compile, $parse) {
    return {
        restrict: 'A',
        terminal: true,
        priority: 100000,
        link: function (scope, elem) {
            var name = $parse(elem.attr('data-dynamic-ng-model'))(scope);
            elem.removeAttr('data-dynamic-ng-model');
            elem.attr('data-ng-model', name);
            $compile(elem)(scope);
        }
    };
}]);

automobilesApp.directive('dynamicNgOptions', ['$compile', '$parse', function ($compile, $parse) {
    return {
        restrict: 'A',
        terminal: true,
        priority: 100000,
        link: function (scope, elem) {
            var name = $parse(elem.attr('data-dynamic-ng-options'))(scope);
            elem.removeAttr('data-dynamic-ng-options');
            elem.attr('data-ng-options', name);
            $compile(elem)(scope);
        }
    };
}]);