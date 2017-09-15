var automobilesApp = angular.module('automobilesApp', ['ngRoute']);

function showField(mode, property, data) {
	
	var shouldShowField = true;
	
	if (data.fieldDefinition) {
		if(mode=="create" && data.fieldDefinition.showoncreate) shouldShowField=data.fieldDefinition.showoncreate=="true";
		else if(mode=="read" && data.fieldDefinition.showonread) shouldShowField=data.fieldDefinition.showonread=="true";
		else if(mode=="update" && data.fieldDefinition.showonupdate) shouldShowField=data.fieldDefinition.showonupdate=="true";
		else if(mode=="list" && data.fieldDefinition.showinlist) shouldShowField=data.fieldDefinition.showinlist=="true";	
	}
	
	return(shouldShowField);
	
}

function getFieldDisplayType(mode, property, data) {
	
	var type = "text";
	if (data.id) type="object";
	else type=data.type;
	return(type);
	
}

function getFieldEditType(mode, property, data) {
	
	var type="text";
	if (data.fieldDefinition) {
		if (data.fieldDefinition.htmltype) type=data.fieldDefinition.htmltype;
	}
	if (data.id) type="object";	
	return(type);
	
}

function getFieldLabel(mode, property, data) {
	
	var label = property;
	if (data.fieldDefinition && data.fieldDefinition.label) {
		label=data.fieldDefinition.label;
	}
	return(label);
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


automobilesApp.filter('commasplitter', function() {
	return function(input) {
		return input.split(',');
	} 
});

automobilesApp.directive('treeSelector', ['$compile', '$parse', function ($compile, $parse) {
    return {
        template: '<div class="data-tree-model"><input type="text" data-ng-model="parentObject.selected" readonly="true"></div>',
        scope: {
            levels: '@',
            binding: '='
         },        
        replace: true,
        link: function(scope, element) {
            scope.$watch('binding', function() {

                var el = angular.element('<ul/>');
                
                for (var i=0; i<scope.binding.data.length; i++) {
                	
                	var data = scope.binding.data[i];
                	el.append("<li class=\"normal\"><a href=\"\" data-ng-click=\"treeElementSelected('" + data.id + "','" + data.name + "','Manufacturer')\">" + data.name + "</a></li>");	
                }
                
                
                $compile(el)(scope);
                element.append(el);
            	
             });        	
        }
      }
}]);