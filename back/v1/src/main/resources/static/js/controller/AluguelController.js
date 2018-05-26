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
		
		if(!$scope.aluguel.identifier){
			$http.post(urlBase + "/aluguels/", $scope.aluguel).then(function (response) {
				$scope.listar();
				$scope.novo();
			}, function(response){
				window.alert("Erro de POST");
			});
		}else{
			$http.put(urlBase + "/aluguels/" + $scope.aluguel.identifier, $scope.aluguel).then(
					function(response){
						$scope.listar();
					}, function(response){
						window.alert("Erro de PUT!");
					}
				);
			}
		}
	
	$scope.editar = function(aluguelSel){
		$scope.aluguel = angular.copy(aluguelSel);
		$scope.aluguel.fimAnuncio = new Date($scope.aluguel.fimAnuncio);
	}
	
	$scope.excluir = function(aluguelSel){
		if(window.confirm("Tem certeza?")){
			$http.delete(urlBase + "/aluguels/" + aluguelSel.identifier).then(
					function(response){
						$scope.listar();
					}, function(response){
						window.alert("Erro de DELETE!")
					}
			);
		}
	}
	
	$scope.orderByMe = function(aluguelOrdenado){
		$scope.myOrderBy = aluguelOrdenado;
	}
	
		
});