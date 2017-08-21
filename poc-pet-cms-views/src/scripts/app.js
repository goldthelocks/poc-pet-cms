'use strict';

var petListApp = angular.module('petListApp', [
	'ui.router', 'ui.select', 'petList', 'addPet']);

petListApp.config(['$stateProvider', '$urlRouterProvider', '$locationProvider', '$httpProvider', function(
		$stateProvider, $urlRouterProvider, $locationProvider, $httpProvider) {
	
	$locationProvider.html5Mode({ enabled: true, requireBase: true });
	
	$urlRouterProvider.otherwise('/');
	
	$stateProvider
		.state('app', {
			abstract: true,
			url: '',
			template: '<ui-view></ui-view>'
		})
		.state('home', {
	        parent: 'app',
	        url: '/',
	        template: '<layout-welcome>Welcome!</layout-welcome>'
	    });
}]);