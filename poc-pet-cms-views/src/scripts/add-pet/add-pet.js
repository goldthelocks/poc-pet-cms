'use strict';

angular.module('addPet', ['ui.router', 'ui.select', 'ngAnimate', 'toastr'])
	.config(['$stateProvider', function ($stateProvider) {
		$stateProvider
			.state('add-pet', {
				parent: 'app',
				url: '/add_pet',
				templateUrl: '/scripts/add-pet/add-pet-template.html',
		        controller: 'AddPetController'
			})
	}]);