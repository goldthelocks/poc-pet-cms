'use strict';

angular.module('petList', ['ui.router'])
	.config(['$stateProvider', function ($stateProvider) {
		$stateProvider
			.state('pet-list', {
				parent: 'app',
				url: '/view_all',
				templateUrl: '/scripts/pet-list/pet-list-template.html',
		        controller: 'PetListController'
			})
	}]);