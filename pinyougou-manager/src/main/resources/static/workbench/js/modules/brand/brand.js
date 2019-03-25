/**
 * 品牌管理
 */
// =====================参数区域=====================
var baseUrl = 'http://localhost:8080';
var sysError = '系统异常,请联系管理员';

// =====================引入区域=====================
var app = angular.module('brandApp',['pagination']);

// =====================业务区域=====================
app.controller('brandController',function ($scope,$http) {

    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 10,
        itemsPerPage: 10,
        perPageOptions: [10, 20, 30, 40, 50],
        onChange: function () {
            $scope.reloadList();//重新加载
        }
    };

    $scope.reloadList = function () {
        //切换页码
        $scope.getBrandList($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
    };

    $scope.getBrandList = function(page,rows){
        $http({
            method : 'post',
            url : baseUrl+'/api/v1/brand/queryList' ,
            data :{'page':page,'rows':rows},
        }).success(function (response) {
            if(response.msg == 'success'){
                $scope.brandList = response.result.list;
                $scope.paginationConf.totalItems = response.result.totals;
            }else{
                $scope.errorMsg = sysError;
            }
        }).error(function () {
            $scope.errorMsg = sysError;
        });
    };
});