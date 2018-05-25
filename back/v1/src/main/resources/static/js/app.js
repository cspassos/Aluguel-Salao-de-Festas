angular.module('myApp', ['ui.router', 'myApp.controllers'])

	.config(function($stateProvider, $urlRouterProvider){
		
	$urlRouterProvider.otherwise("/inicio");
	
	$stateProvider
	
	.state('inicio', {
		url : "/inicio",
		templateUrl : "inicio.html"
	})
	
	.state('aluguels', {
		url : "/aluguels",
		templateUrl : "aluguels.html",
		controller: "AluguelController"
	})

}); 