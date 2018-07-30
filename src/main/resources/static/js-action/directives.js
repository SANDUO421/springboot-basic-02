/*自定义指令*/
actionApp.directive('datePicker',function(){ //定义一个指令datePicker
	return {
		restrict:'AC',//限制为属性指令和样式指令
		link:function(scope,elem,attrs){ //link定义指令，使用当前scope，属性，当前元素属性
			elem.datepicker();//初始化jqueryui的datepicker
		}
	}
});