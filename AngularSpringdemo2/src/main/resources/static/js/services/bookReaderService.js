angular.module('app.service.bookReader', [])
.factory("bookReaderService", ['$resource', function($resource) {
	return  $resource('/bookReader/:id', {id : "@id"},
			{ 
		'query':  {method:'GET', isArray:true},
		'update' :{method: "PUT"} 
		  })
	
}])
.factory("controllersService",function(){
	var data = "";
	return{
		setData : function(locData){
			data = locData;
		},
		getData : function(){
			return data;
		}
	}
})