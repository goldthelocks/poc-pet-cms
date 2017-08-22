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