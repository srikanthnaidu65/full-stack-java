var myApp = angular.module('cdApp', []);
	myApp.controller('CDController',function ($scope) {
       $scope.CD = {
         id: '',
         title: '',
		 price: '',
		          
         getAllDetails: function() {
            var cdObject = $scope.CD;
            return "CD ID: " +cdObject.id +", "+"CD Title: " + cdObject.title +", "+ "CD Price: " + cdObject.price;
         }
      };
   });