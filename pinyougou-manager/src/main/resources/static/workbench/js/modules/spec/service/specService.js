/**
 * 品牌服务层代码
 */
app1.service('specService',function ($scope,$http) {
    $scope.queryList = function (page,rows) {
        return $http({method: 'post', url: baseUrl + '/api/v1/spec/queryList', data: {'page': page, 'rows': rows}});
    }
});