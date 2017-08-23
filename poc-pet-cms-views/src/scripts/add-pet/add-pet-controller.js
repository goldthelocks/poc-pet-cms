'use strict';

angular.module('addPet')
	.controller('AddPetController', ['$http', '$scope', 'toastr', function ($http, $scope, toastr) {
		
		$scope.addNewPet = function(pet) {			
			$http.post('/api/pet/new', pet)
				.then(function success(response) {
				toastr.success(response.data.message);
				setDefaults();
			}, function error(response) {
				toastr.error(response.data.message);
			});
		};
		
		// get pet types
		$http.get('/api/pettype/all').then(function (resp) {
			$scope.petTypes = resp.data;
		});
		
		var setDefaults = function() {
			$scope.pet = {};
			$scope.petForm.$setPristine();
			$scope.petForm.$setUntouched();
		}
		
	}]);

angular.module('addPet')
	.directive('uiSelectRequired', function() {
		return {
			require: 'ngModel',
	        link: function (scope, element, attr, ctrl) {
	            ctrl.$validators.uiSelectRequired = function (modelValue, viewValue) {
	                if (attr.uiSelectRequired) {
	                    var isRequired = scope.$eval(attr.uiSelectRequired)
	                    if (isRequired == false)
	                        return true;
	                }
	                var determineVal;
	                if (angular.isArray(modelValue)) {
	                    determineVal = modelValue;
	                } else if (angular.isArray(viewValue)) {
	                    determineVal = viewValue;
	                } else if (angular.isObject(modelValue)) {
	                    determineVal = angular.equals(modelValue, {}) ? [] : ['true'];
	                } else if (angular.isObject(viewValue)) {
	                    determineVal = angular.equals(viewValue, {}) ? [] : ['true'];
	                } else {
	                    return false;
	                }
	                return determineVal.length > 0;
	            };
	        }
        };
	});