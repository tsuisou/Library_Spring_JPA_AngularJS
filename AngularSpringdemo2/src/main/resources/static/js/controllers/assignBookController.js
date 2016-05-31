angular.module('app.controller.assignBook', []).controller(
		'assignBooksController',
		function($http, $scope,$location, BookService, bookReaderService,
				controllersService) {
			$scope.Reader = controllersService.getData();
			var actualBook = {};
			refreshFunction = function() {
				$http.get("/bookWithoutId").then(function(value) {
					$scope.books = value;
				}, function(reason) {

				}, function(value) {
					$scope.books = value;

				});
			}
			var orderPack = {
					bookCount : 0,
					borrowDate : new Date(),
					returnDate : new Date(),
					books : []
			}
			refreshFunction();
			$scope.assign = function(book) {
				actualBook = book;
				var borrowDate = new Date();
				borrowDate.setHours(0, 0, 0, 0);
				var returnDate = new Date(new Date(borrowDate)
						.setMonth(borrowDate.getMonth() + 1));
				returnDate.setHours(0, 0, 0, 0);
				book.available = false;
				var newBook = {
						id : book.id,
						title : book.title,
						category : book.category,
						bookBorrowDate : borrowDate,
						returnDateBook : returnDate,
						available : false
				}
				actualBook.choosed = true;
				orderPack.books.push(newBook);

			}
			$scope.confirm = function() {
				$scope.Reader.orderPacks.push(orderPack);
				bookReaderService.update($scope.Reader,function(){
					refreshFunction();
				});
			}
			$scope.clear = function() {
				angular.forEach($scope.booksAssign, function(value, key) {
					actualBook = value;
					actualBook.choosed = false;
				});
				refreshFunction();
				$scope.booksAssign = [];
				orderPack.books = [];
			}
			$scope.back = function(){
				$location.path("/showBookReader");
			}
		})