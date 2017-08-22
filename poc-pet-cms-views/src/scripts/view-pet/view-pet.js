'use strict';

angular.module('viewPet', ['ui.router'])
	.config(['$stateProvider', function($stateProvider) {
		$stateProvider
			.state('view-pet', {
				parent: 'app',
				url: '/view/:petId',
				templateUrl: '/scripts/view-pet/view-pet-template.html',
				controller: 'ViewPetController'
			})
	}]);