
var rootURL = "http://localhost:8080/FilmHyllan/webresources/";
function LoginCtrl($scope, $http) {
    $scope.submit = function() {
        console.log(rootURL);
        $http({
            method: 'PUT',
            data: formToJSON(),
            url: rootURL + "entity.user/login",
            headers: {'Content-Type': 'application/json'}
        }). success(function(data, status, headers, config) {
            $scope.reviewLists = data;
        }).error(function(data, status, headers, config) {
            console.log("Error ");
            // called asynchronously if an error occurs
            // or server returns response with an error status.
        });
    };
            function formToJSON() {
            return JSON.stringify({
                "userName": $scope.userName,
                "password":  $scope.password
            });
        }
};


function ReviewListCtrl($scope, $http) {
    $http({
        method: 'GET',
       // data: $scope.reviewLists,
         url: rootURL + "entity.review/reviewlist/1",
        headers: {'Content-Type': 'application/json'}
    }).
            success(function(data, status, headers, config) {
        $scope.reviewLists = data;
    }).error(function(data, status, headers, config) {
        console.log("Error");
        // called asynchronously if an error occurs
        // or server returns response with an error status.
    });
};


// ngResource を依存モジュールに指定
//angular.module("ReviewListCtrl", ["ngResource"]);
//var services = angular.module('ngdemo.services', ['ngResource']);


var app = angular.module('ngdemo.controllers', []);

app.controller('MyCtrl1', ['$scope', 'UserFactory', function($scope, UserFactory) {
        UserFactory.get({}, function(userFactory) {
            $scope.firstname = userFactory.firstName;
        })
    }]);


function  mainCtrl($scope) {
    $scope.users = [
        {"name": "taguchi", "score": 52.22},
        {"name": "tanaka", "score": 22.22},
        {"name": "yamada", "score": 62.11}
    ];
    $scope.hello = "Hello, World";
}

