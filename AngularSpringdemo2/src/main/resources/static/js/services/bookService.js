angular.module('app.service.book', ['ngResource'])
.factory('BookService', ['$resource', function($resource) {
	return $resource('/book/:id', {id : "@id"},
		{ 
		  'update' :{method: "PUT"} 
		  })
}])