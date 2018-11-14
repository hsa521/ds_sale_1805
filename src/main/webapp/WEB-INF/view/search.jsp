<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/5
  Time: 9:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>标题</title>
    <script src="/js/jquery-1.7.2.min.js"></script>
    <script>
        function toIndexPage(){
            location.href="toMainPage.do";
        }

        //查看mini购物车
        function findMiniCart(){
            $.post("findMiniCart.do",function(data){
                $("#miniCartInnerDiv").html(data);

            })
            $("#miniCartInnerDiv").show();
        }

        function outMiniCart(){
            $("#miniCartInnerDiv").hide();
        }

    </script>
</head>
<body>
    <div class="search">
        <div class="logo" ><img src="./images/logo.jpg" onclick="toIndexPage()" alt=""></div>
        <div class="search_on">
            <div class="se">
                <input type="text" name="search" class="lf">
                <input type="submit" class="clik" value="搜索">
            </div>
            <div class="se">
                <a href="">取暖神奇</a>
                <a href="">1元秒杀</a>
                <a href="">吹风机</a>
                <a href="">玉兰油</a>
            </div>
        </div>
        <div class="card" onmouseover="findMiniCart()" onmouseout="outMiniCart()">
            <a href="toCartListPage.do">购物车<div class="num">0</div></a>

            <!--购物车商品-->
            <div class="cart_pro">
                <div id="miniCartInnerDiv" style="display:none;"></div>

            </div>
        </div>
    </div>
</body>
</html>
