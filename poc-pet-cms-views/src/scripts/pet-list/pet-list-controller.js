'use strict';

angular.module('petList')
	.controller('PetListController', ['$http', '$scope', function ($http, $scope) {

		$http.get('/api/pet/all').then(function (resp) {
			$scope.pets = resp.data;
		});
		
		$('[data-toggle="petListTable"]').bootstrapTable({
			url: '/api/pet/all',
			classes: "table table-no-bordered",
			pagination: true,
			pageSize: 5,
			pageList: [5, 10, 25, 50, 100],
			columns: [{
				field: 'id',
				title: 'Pet Id',
				halign: 'center',
				formatter: function(value, row, index) {
					return '<a href="' + value + '">' + value + '</a>';
				},
				sortable: true
			}, {
				field: 'petDetails.name',
				title: 'Pet Name',
				halign: 'center',
				sortable: true
			}, {
				field: 'petDetails.age',
				title: 'Age',
				halign: 'center',
				sortable: true
			}, {
				field: 'petType.name',
				title: 'Pet Type',
				halign: 'center',
				sortable: true
			}, {
				field: 'dateAdded',
				title: 'Date Added',
				halign: 'center',
				sortable: true
			}, {
				field: 'status',
				title: 'Status',
				halign: 'center',
				sortable: true
			}]
		});
		
	}]);