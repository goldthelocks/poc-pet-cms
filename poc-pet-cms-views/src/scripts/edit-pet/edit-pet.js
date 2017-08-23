'use strict';

angular.module('editPet', ['ui.router', 'ui.select', 'ngAnimate', 'toastr'])
.config(['$stateProvider', function ($stateProvider) {
	$stateProvider
		.state('edit-pet', {
			parent: 'app',
			url: '/pet/:petId/edit',
			templateUrl: '/scripts/edit-pet/edit-pet-template.html',
	        controller: 'EditPetController'
		})
}]);