angular.module('app.controller.book',[])
.controller('booksController', function($scope,BookService) {
	var self = this;
	var isEdit = false;
	$scope.isDisabled = true;
	var edit = $scope.data = {};
	refreshMethod = function(){ 
		BookService.query(function(data) {
			$scope.books = data;
		});
	};
	refreshMethod();
	$scope.transfer = function(book){
		isEdit = true;
		edit.id = book.id;
		edit.title = book.title;
		edit.category = book.category;
		$scope.isDisabled = false;
	};
	$scope.save = function(data){
		if (isEdit){
			BookService.update(data,function(){
				refreshMethod();
				edit.title = "";
				edit.category = "";
				$scope.isDisabled = true;
			});
		}else{
			data.available = true;
			BookService.save(data,function(){
				refreshMethod();
				edit.title = "";
				edit.category = "";
				$scope.isDisabled = true;
			});
		}
	}
	
	$scope.addNew = function(){
		isEdit = false;
		$scope.data.id = "";
		$scope.data.title = "";
		$scope.data.category = "";
		$scope.isDisabled = false;
	}
	$scope.delete = function(number_id){
		BookService.delete({id:number_id},function(){
			refreshMethod();
		});
	}
})