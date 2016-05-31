angular.module('app.config', [])
.config(function($routeProvider, $httpProvider) {
	$routeProvider
	.when('/', {
		templateUrl : 'home.html',
		controller : 'home',
		controllerAs: 'controller'
	})
	.when('/login', {
		templateUrl : 'login.html',
		controller : 'navigation',
		controllerAs: 'controller'
	})
	.when('/tworz', {
		templateUrl : 'form.html',
		controller : 'formController',
		controllerAs: 'controller'
	})
	.when('/showAllBooks', {
		templateUrl : 'books.html',
		controller : 'booksController',
		controllerAs: 'controller'
	})
	.when('/showBookReader', {
		templateUrl : 'czytelnicy.html',
		controller : 'booksReaderController',
		controllerAs: 'controller'
	}) 
	.when('/assignBooksPage', {
		templateUrl : 'assingBooks.html',
		controller : 'assignBooksController',
		controllerAs: 'controller'
	})
	.when('/oneBookReader', {
		templateUrl : 'bookReaderSite.html',
		controller : 'oneBookReaderController',
		controllerAs: 'controller'
	})
	.when('/oneReturnBook', {
		templateUrl : 'returnBook.html',
		controller : 'returnBookController',
		controllerAs: 'controller'
	})
	.otherwise('/');

	$httpProvider.defaults.headers.common['X-Requested-With'] = 'XMLHttpRequest';

})