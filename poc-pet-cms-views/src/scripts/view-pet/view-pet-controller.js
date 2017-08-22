'use strict';

angular.module('viewPet')
	.controller('ViewPetController', ['$http', '$scope', '$stateParams', function($http, $scope, $stateParams) {
		
		$http.get('/api/pet/' + $stateParams.petId).then(function (resp) {
			var data = resp.data;
			
			$scope.petId = data.id;
			$scope.name = data.petDetails.name;
			$scope.age = data.petDetails.age;
			$scope.petType = data.petType.name;
			$scope.dateAdded = data.dateAdded;
			$scope.updateDate = data.updateDate;
			$scope.status = data.status;
		});
		
	}]);