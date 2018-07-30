/*
 * 模块路由定义
 */
var actionApp = angular.module("actionApp",['ngRoute']);//定义actionApp模块，并依赖路由模块

actionApp.config(['$routeProvider',function($routeProvider){//配置路由并注入$routeProvider进行配置
	$routeProvider.when('/oper',{
		controller: 'View1Controller',//定义路由的控制器
		templateURl:'views/view1.html',//定义路由视图的真正地址
	}).when('/directive',{
		controller:'View2Controller',
		templateUrl:'views/views2.html',
	});
}]);