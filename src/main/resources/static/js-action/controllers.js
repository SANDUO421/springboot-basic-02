/*
 *控制器定义 
 * */
//定义ViewController，并注入'$routeScope','$scope','http'三个对象
actionApp.controller("View1Controller",['$rootScope','$scope','http',function($rootScope,$scope,$http){
	//监听$viewContentLoaded事件，在页面加载完成后一些操作
	$scope.$on("$viewContentLoaded",function(){
		console.log("页面加载完成");
	});
	$scope.search = function(){
		personName=$scope.personName;
		$http.get('search',{
			params:{
				personName:personName
			}
		}).success(function(data){
			$scope.person=data;
		});
	};
}]);

actionApp.controller("View2Controller",['$rootScope','$scope',function($rootScope,$scope){
	$scope.$on('$viewContentLoaded',function(){
		console.log("页面加载完成");
	})
}]);


