angular.module('market').controller('productCardController', function ($scope, $http, $localStorage, $rootScope, $location, $routeParams) {

    const contextPath = 'http://localhost:5555/core/api/v1/products'

    $scope.comment = {user: null, product: null, description: null, estimation: null};

    $scope.getEstimation = function (product = $scope.productCard) {
            $http({
               url: 'http://localhost:5555/comment/api/v1/comments/estimation/'+product.title,
               method: 'GET'
            }).then(function (response) {
                $scope.avgEstimation = response.data.value;
            });
    }

    $scope.createComment = function () {
        $http.post('http://localhost:5555/comment/api/v1/comments', $scope.comment).then(function success(response) {
                    alert(response.data.value);
                    $scope.loadComments();
                }, function error(response) {
                    let me = response;
                    console.log(me);
                    alert(me.data.message);
                });
            }

    $scope.updateComment = function () {
        $http.put('http://localhost:5555/comment/api/v1/comments/my', $scope.comment).then(function success(response) {
            alert(response.data.value);
            $scope.loadComments();
        }, function error(response) {
            let me = response;
            console.log(me);
            alert(me.data.message);
        });
    }

    $scope.getProductCardById = function () {
         $http.get(contextPath + '/card/' + $routeParams.id)
            .then(function success(response) {
                $scope.productCard = response.data;
                $scope.loadComments();
                $scope.getDataComment();
            });
    }

    $scope.isVisibleAdmin = function () {
            return $localStorage.visibleUser;
    }

    $scope.isMyCommentPresent = function (){
       for (let i=0; i< $scope.length; i++){
           if($localStorage.mstMarketUser?.username===$scope.commentsPage.content[i].user){
               return true;
           }
       }
       return false;
    }

    $scope.visibleAddCard = function () {
            const gh = $routeParams.flag
            if (gh !== undefined) return false;
            return true;
        }

    $scope.getUser = function (){
             console.log($localStorage.mstMarketUser.username)
             $scope.username = $localStorage.mstMarketUser.username;
    }

    $scope.loadComments = function (page = 1, product = $scope.productCard) {
        $http({
            url: 'http://localhost:5555/comment/api/v1/comments',
            method: 'GET',
            params: {
                p: page,
                product: product.title
            }
        }).then(function (response) {
            $scope.commentsPage = response.data;
            $scope.length = $scope.commentsPage.content.length
            $scope.generatePagesList($scope.commentsPage.totalPages);
            $scope.getEstimation();
        });
    };

    $scope.generatePagesList = function (totalPages) {
        out = [];
        for (let i = 0; i < totalPages; i++) {
            out.push(i + 1);
        }
        $scope.pagesList = out;
    }

    $scope.getDataComment = function () {
            $scope.comment.user = $localStorage.mstMarketUser?.username;
            $scope.comment.product = $scope.productCard.title;
    }

     $scope.deleteComment = function (id){
            $http({
                url: 'http://localhost:5555/comment/api/v1/comments/'+id,
                method: 'DELETE',

            }).then(function (response) {
                $scope.loadComments()
            });
     }

     $rootScope.suchAProductAlreadyExists = function (id) {
             if ($localStorage.currentCartUser) {
                 for (let i = 0; i < $localStorage.currentCartUser.items.length; i++) {
                     let product = $localStorage.currentCartUser.items[i];
                     if (product.productId === id) return false;
                 }
             }
             return true;
         }

         $rootScope.addToCart = function (id) {
             $http.get('http://localhost:5555/cart/api/v1/cart/' + $localStorage.mstMarketGuestCartId + '/add/' + id)
                 .then(function (response) {
                     $localStorage.currentCartUser = response.data;
                     $scope.getProductCardById();
                 });
         }

    $scope.getProductCardById();
});