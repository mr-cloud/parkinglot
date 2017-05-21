if (testMod == null) {
	var testMod = angular.module("testModule",[]);
}
testMod.controller("LoginController", function($scope, $log, $http){
	$scope.name="admin";
	$scope.passwd="123456";

	$scope.init = function()
	{
		$log.info($scope.name);
		$log.info($scope.passwd)
	}
	$scope.login = function(){
		$http.get('login.do')
		.success(function(data, status){
			$log.info(data)
			if ($scope.name == data.name) {
				alert('Login success.');
			}
			else{
				alert('invalid username or password:' + $scope.name);
			}
		})
		.error(function(data, status){
			alert(status);
		});
	}
});
