var App = angular.module('paymentApp', []);
App.controller('paymentCtrl',['$scope','$http','$q', function($scope, $http, $q) {

    $scope.showSubmitButton = false;
    $scope.productinfo = 'Online Course';
    $scope.firstname = '';
    $scope.email = '';
    $scope.phone = '';
    $scope.amount = '';
    $scope.surl = "https://example.com/success";
    $scope.furl = '';
    $scope.key = "123e4567-e89b-12d3-a456-abcdefgh12345";
    $scope.hash = "0123456789abcdef0123456789abcdef";
    $scope.txnid = "1";

    $scope.confirmPayment = function() {
        var url = 'http://localhost:8080/payment/payment-details';
        var data = {productInfo: $scope.productinfo, email: $scope.email, name: $scope.firstname, phone: $scope.phone, amount:$scope.amount};
        $http.post(url, data)
            .then(function (response) {
                    console.log(response.data);
                    $scope.txnid = response.data.txnId;
                    $scope.surl = response.data.surl;
                    $scope.furl = response.data.furl;
                    $scope.key = response.data.key;
                    $scope.hash = response.data.hash;
                    $scope.showSubmitButton = true;
                },
                function (errResponse) {
                    if (errResponse.status == -1) {
                        errResponse.status = 408;
                        errResponse.statusText = 'Server Timeout.';
                    }
                    alert(errResponse.status + ':' + errResponse.statusText);
                });
    }
}]);
function hideInputValue() {
    var input = document.getElementById("username");
    input.type = "hidden";
}