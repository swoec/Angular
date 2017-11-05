<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <head>
    <title>list.html</title>
	
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="this is my page">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    
    <link rel="stylesheet" type="text/css" href="./css/bootstrap-3.2.0/dist/css/bootstrap.min.css"/>
    <script src="http://cdn.bootcss.com/jquery/2.1.3/jquery.min.js"></script>
    <script src="http://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <script src="http://cdn.bootcss.com/angular.js/1.3.15/angular.min.js"></script>
    <style>
    	.list{
			margin:20px;
		}
		.margin80{
			margin-top:80px;
		}
    </style>
  </head>
  <body ng-app="app">
	<nav class="navbar navbar-default navbar-fixed-top">
	  <div class="container">
			<ul class="nav navbar-nav">
				<li>
					<c:if test="${name!=null}">
						<a href="###">
							欢迎${name}
						</a>
					</c:if>
				</li>
	           <li><a href="./index.do">首页</a></li>
	           <li><a href="./detail.do">类型页</a></li>
	           <li><a href="./cart.do">购物车</a></li>
	           <li><a href="./user.do">用户信息</a></li>
	         </ul>
	  </div>
	</nav>
	<div id="form" class="container margin80" ng-controller="form">
		<div class="row">
			<h1>未支付列表</h1>
			<ul class="list-group">
				<li class="list-group-item" ng-repeat="item in items" ng-if="item.pay==0">
						<p>
							<span class="glyphicon glyphicon-hand-right" aria-hidden="true"></span>
							收货人地址{{item.address}}
						</p>
						<p>
							<span class="glyphicon glyphicon-hand-right" aria-hidden="true"></span>
							收货人手机{{item.phone}}
						</p>
						<p>
							<span class="glyphicon glyphicon-hand-right" aria-hidden="true"></span>
							商品总价格{{item.totalPrice}}
						</p>
						<div parse id={{item.orderlist}}>
							<div class="list pull-left" ng-repeat="order in  orderlist">
			        			<div commodity-directive id="{{order.commodityId}}">
			        				<p>商品名{{res.name}}</p>
			        				<p>商品描述{{res.depict}}</p>
			        				<p>商品厂商{{res.manufacturer}}</p>
			        				<p>商品价格{{res.price}}</p>
			        				<p>商品logo<img ng-src={{res.img}}  width=50 height=50/></p>
				        			<p>
				        				购买的商品个数
					        			<span class="badge">
					        				{{order.commodityCount}}
										</span>
				        			</p>
			        			</div>
			        		</div>
		        		</div>
		        	
		        		<button class="btn btn-default" ng-click="pay(item.id)"> 支付 </button>
	        		<div class="clearfix"></div>
				</li>
			</ul>
			<br>
			<h1>已支付列表</h1>
			<ul>
				<li class="list-group-item" ng-repeat="item in items" ng-if="item.pay==1">
						<p>
							<span class="glyphicon glyphicon-hand-right" aria-hidden="true"></span>
							收货人地址{{item.address}}
						</p>
						<p>
							<span class="glyphicon glyphicon-hand-right" aria-hidden="true"></span>
							收货人手机{{item.phone}}
						</p>
						<p>
							<span class="glyphicon glyphicon-hand-right" aria-hidden="true"></span>
							商品总价格{{item.totalPrice}}
						</p>
						<div parse id={{item.orderlist}}>
							<div class="list pull-left" ng-repeat="order in  orderlist">
			        			<div commodity-directive id="{{order.commodityId}}">
			        				<p>商品名{{res.name}}</p>
			        				<p>商品描述{{res.depict}}</p>
			        				<p>商品厂商{{res.manufacturer}}</p>
			        				<p>商品价格{{res.price}}</p>
			        				<p>商品logo<img ng-src={{res.img}}  width=50 height=50/></p>
				        			<p>
				        				购买的商品个数
					        			<span class="badge">
					        				{{order.commodityCount}}
										</span>
				        			</p>
			        			</div>
			        		</div>
		        		</div>
	        		<div class="clearfix"></div>
				</li>
			</ul>
		</div>
	</div>
	<script>
		var userId = "${id}";
		var app = angular.module("app", []);
        app.directive("commodityDirective", function() {
        	return {
        		restrict : "EA",
        		scope : true,
	        	link : function( $scope ,$el, $iattrs) {
	        		ajaxModule.getComById($iattrs.id, function( res ) {
		        		$scope.res = res[0];
		        		$scope.$apply();
        			});
	        	}
        	}
        });
        app.directive("parse", function() {
        	return {
        		restrict : "EA",
        		scope : true,
	        	link : function( $scope ,$el, $iattrs) {
	        		$scope.orderlist = JSON.parse($iattrs.id);
	        	}
        	}
        });
        
        
		app.controller("form", function( $scope ) {
			$scope.items = [];
			$scope.pay = function( orderformId ) {
				ajaxModule.pay(userId , orderformId, function( res ) {
					if(res) {
						location.reload();
					}else{
						alert("支付失败");
					};
				});
			};
		});
		
		var ajaxModule = {
			getFormList : function( userId,  cb ) {
				$.post("getFormList.do",{userId:userId}, cb);
			},
			pay : function( userId, orderformId, cb) {
				$.post("pay.do", {userId : userId, orderformId : orderformId }, cb);
			},
			getComById : function(id , cb) {
        		$.post("./getComById.do", {id:id}, cb);
			}
		};
		
		if(userId) {
			$(function() {
				ajaxModule.getFormList(userId, function( res ) {
					$("#form").scope().items = res;
					$("#form").scope().$apply();
				});
			});
		};
	</script>
  </body>
</html>
