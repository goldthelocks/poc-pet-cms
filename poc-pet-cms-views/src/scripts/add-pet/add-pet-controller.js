'use strict';

angular.module('addPet')
	.controller('AddPetController', ['$http', '$scope', function ($http, $scope) {
		
		$scope.setDefaults = function() {
			$scope.displayError = false;
			$scope.displaySuccess = false;
			$scope.message = "";
		};
		
		$scope.setDefaults();
		
		$scope.addNewPet = function(pet) {			
			$http.post('/api/pet/new', pet)
				.then(function success(response) {
				$scope.setMessage(false, response.message);
			}, function error(response) {
				$scope.setMessage(true, response.message);
			});
		};
		
		// get pet types
		$http.get('/api/pettype/all').then(function (resp) {
			$scope.petTypes = resp.data;
		});
		
		$scope.setMessage = function(isError, message) {
			if (isError) {
				$scope.displayError = true;
			} else {
				$scope.displaySuccess = true;
			}
			
			$scope.message = message;
		};
		
	}]);