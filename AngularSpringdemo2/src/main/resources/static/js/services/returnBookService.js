angular.module('app.service.returnBook',[])
.factory('returnBookService',function(){
	locData="";
	return{
		setData : function(data){
			locData = data;
		},
		getData : function(){
			return locData;
		}
	}
})