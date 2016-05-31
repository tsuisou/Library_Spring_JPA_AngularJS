angular.module('app.controller.bookReader',[])
.controller('booksReaderController', function($scope,$http,bookReaderService,$location,controllersService) {
	var refreshFunction = function(){
		bookReaderService.query(function(data){
			console.log("data",data);
			$scope.bookReaders = data;
		});
	}
	refreshFunction();
	$scope.borrow = function(bookReader){
		controllersService.setData(bookReader);
		$location.path("assignBooksPage");
	}
	$scope.remove = function(bookReader){
		bookReaderService.delete({id:bookReader.id},function(){
			refreshFunction();
		})
	}
	$scope.add = function(bookReader){
		bookReaderService.save(bookReader,function(){
			refreshFunction();
		});
	}

})