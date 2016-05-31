angular.module('app.controller.oneBookReader',[])
.controller('oneBookReaderController', function($scope,$location,$http,
		controllersService,returnBookService) {
	$http.get("bookReaderBooks/" + controllersService.getData().id).then(function(value) {
		$scope.books = value.data;
	})
	$scope.return = function(book){
		returnBookService.setData(book);
		$location.path('oneReturnBook');
	}
})