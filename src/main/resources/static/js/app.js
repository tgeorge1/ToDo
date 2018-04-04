'use strict';

var myApp = angular.module('myApp', [ 'ui.router' ]);

myApp.config(function($stateProvider, $urlRouterProvider) {

	$urlRouterProvider.otherwise('/dashboard');

	$stateProvider.state('dashboard', {
		url : '/dashboard',
		templateUrl : 'dashboard.html'
	}).state('update', {
		url : '/update',
		templateUrl : 'update.html'
	}).state('add', {
		url : '/add',
		templateUrl : 'addtask.html'
	});

});

myApp.controller('mainController', [
		'$scope',
		'$state',
		'$http',
		function($scope, $state, $http) {

			$scope.statuses = [ {
				"name" : "Completed",
				"val" : true
			}, {
				"name" : "Pending",
				"val" : false
			} ];

			$scope.findAllTasks = function() {

				$http.get('/todo/findall').then(function(response) {
					$scope.toDoList = response.data;

				});
				$state.go('dashboard');

			};

			$scope.gotoAdd = function() {
				$state.go('add');
			};
			$scope.addTask = function(data) {
				console.log(data);
				if (data == null || data == '' || data == undefined) {
					alert('Please enter a  task')
				} else {
					$http({
						url : '/todo/add',
						method : "POST",
						data : {
							"taskName" : data
						}
					}).then(function(response) {
						$scope.findAllTasks();
					});
				}
			};

			$scope.editingData = {};

			$scope.editData = function(data) {
				$scope.editingData = data;
				$state.go('update');
			};

			$scope.updateTask = function(data) {
				$scope.editingData.completed = data;

				if ($scope.editingData.taskName == null
						|| $scope.editingData.taskName == ''
						|| $scope.editingData.taskName == undefined) {
					alert('Enter a valid Task');
				} else {
					$http({
						url : '/todo/add',
						method : "POST",
						data : $scope.editingData
					}).then(function(response) {
						$scope.findAllTasks();
					});
				}

			};
		} ]);
