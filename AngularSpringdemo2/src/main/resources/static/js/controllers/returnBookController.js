angular.module('app.controller.returnBook', [])
.controller('returnBookController', function($scope,$location,returnBookService,BookService,controllersService) {
	$scope.book = returnBookService.getData();
	$scope.calc = function(){
		var returnDateBook = new Date($scope.book.returnDateBook);
		var oneDay=1000*60*60*24;
		var miliseconds= 0;
		if (($scope.todayDate.getTime() === returnDateBook.getTime()) 
				|| ($scope.todayDate.getTime() < returnDateBook)){
			$scope.fee = "Thank you for returned book before delay";
		}else{	
			miliseconds = returnDateBook - $scope.todayDate; 
			$scope.fee = "You have to pay: " + (Math.abs(Math.round(miliseconds/oneDay)) * 2);
		}
	}
	$scope.confirm = function(){
		
		$scope.book.available = 1;
		$scope.book.bookBorrowDate = null;
		$scope.book.returnDateBook = null;
		$scope.book.bookReader_id = null;
		controllersService.setData("");
		BookService.update($scope.book,function(){
			$location.path('/oneBookReader');
		})
	}
	$scope.back = function(){
		$location.path('/oneBookReader');
	}
})