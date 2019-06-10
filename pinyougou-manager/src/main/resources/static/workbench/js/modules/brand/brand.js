/**
 * 品牌管理
 */
// =====================参数区域=====================
var baseUrl = 'http://localhost:8080';
var sysError = '系统异常,请联系管理员';

// =====================引入区域=====================
var app = angular.module('brandApp', ['pagination']);
 
// =====================业务区域=====================
app.controller('brandController', function ($scope, $http) {

    // =====================分页===================== //
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

    $scope.getBrandList = function (page, rows) {
        $http({
            method: 'post',
            url: baseUrl + '/api/v1/brand/queryList',
            data: {'page': page, 'rows': rows}
        }).success(function (response) {
            if (response.msg == 'success') {
                $scope.brandList = response.result.list;
                $scope.paginationConf.totalItems = response.result.totals;
            } else {
                $scope.errorMsg = sysError;
            }
        }).error(function () {
            $scope.errorMsg = sysError;
        });
    };

    // =====================保存===================== //
    $scope.saveBrand = function () {
        var requireMethod = 'add';
        if ($scope.entity.id != null) {
            requireMethod = 'update';
        }
        $http.post(baseUrl + '/api/v1/brand/' + requireMethod, $scope.entity).success(function (response) {
            if (response.msg == 'success') {
                $scope.reloadList();
            } else {
                alert(response.errorMsg);
            }
        })
    };

    // =====================查询单个===================== //
    $scope.queryOne = function (id) {
        $http.get(baseUrl + '/api/v1/brand/queryOne/' + id).success(function (response) {
            if (response.msg == 'success') {
                $scope.entity = response.result;
            } else {
                alert(response.errorMsg);
            }
        })
    };

    // =====================删除===================== //
    $scope.deleteBrand = function (){
        $http({
            method: 'post',
            url: baseUrl + '/api/v1/brand/delete',
            data: { 'ids' : $scope.selectsId },
        }).success(function (response) {
            if (response.msg == 'success') {
                $scope.reloadList();
            } else {
                alert(response.errorMsg);
            }
        })
    };

    // =====================公共方法区===================== //

    // ========== 清空表单 ===========
    $scope.clearForm = function () {
        $scope.entity = {};
    };

    // ========== 复选框 ===========
    $scope.selectsId = [];
    $scope.updateSelection = function ($event,id) {
        if($event.target.checked){
            $scope.selectsId.push(id);
        }else{
            var index = $scope.selectsId.indexOf(id);
            $scope.selectsId.splice(index,1);
        }
    };

});