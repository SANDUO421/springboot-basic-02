function getPerson(){
	$.ajax({
	type:"GET",
	dataType:"json",
	url:"http://localhost:8888/persons",
	success:function(data){
		alert(data);
	}
})
}
