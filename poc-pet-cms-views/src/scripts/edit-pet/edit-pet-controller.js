'use strict';

angular.module('editPet')
	.controller('EditPetController', ['$http', '$scope', '$stateParams', '$state', 'toastr', 
			function ($http, $scope, $stateParams, $state, toastr) {
		
		var petId = $stateParams.petId;
		
		// load
		$http.get('/api/pet/' + petId).then(function (resp) {
			$scope.pet = resp.data;
        });
        
        // get pet types
		$http.get('/api/pettype/all').then(function (resp) {
			$scope.petTypes = resp.data;
		});
		
		$scope.editPet = function(pet) {			
			$http.put('/api/pet/update/' + petId, pet)
				.then(function success(response) {
				toastr.success(response.data.message);
				console.log("should redirect...")
				$state.go("view-pet", {petId: petId});
			}, function error(response) {
				toastr.error(response.data.message);
			});
		};
		
		var setDefaults = function() {
			$scope.pet = {};
			$scope.petForm.$setPristine();
			$scope.petForm.$setUntouched();
		}

	}]);