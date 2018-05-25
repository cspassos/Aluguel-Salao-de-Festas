var aluguelApp = angular.module("AluguelControllers", []);

var urlBase = "http://localhost:8181";

aluguelApp.controller("AluguelController", function($scope, $http){
	
	$scope.listar = function(){
		$http.get(urlBase + "/aluguels").then(
			function(response){
				$scope.aluguels = response.data;
				
			}, function(response){
				window.alert("Erro de Get!");
			}
		);
	}
	
	$scope.listar();
	
	
	$scope.novo = function(){
		$scope.aluguel = "";
	}
	
	$scope.salvar = function(){
		
			$http.post(urlBase + "/aluguels/", $scope.aluguel).then(function (response) {
				$scope.listar();
				$scope.novo();
			}, function(response){
				window.alert("Erro de POST");
			})
	}
});