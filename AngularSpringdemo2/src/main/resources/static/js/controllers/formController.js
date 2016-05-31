angular.module('app.controller.form',[])
.controller('formController', function($http,$scope,$log) {
	var self = this;
	$scope.wyslij = function(){
		console.log("name " + $scope.name + " email " + $scope.email);
		var data = 
            JSON.parse(JSON.stringify({
            	"email" : $scope.email,
                "name": $scope.name
        }));
		console.log(data);
		$http.post('/create2', data)
		.success(function(data, status, headers, config) {
			console.log("udało się");
		})
		.error(function(data, status, headers, config) {
			console.log("nie udało się");
		});
	}
});