<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/5
  Time: 9:40
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
    <script>
        $(function () {
            //通过 getjson异步加载json数据
            $.getJSON("json/class_1.js", function(json){
                //dom对象如何转换为jquery对象  $()
                $(json).each(function(i,data){
                    $(".nav_mini ul").append('<li onmouseover="get_class2('+data.id+')" ><a href="">'+data.flmch1+'</a></li>');
                })
            });
        })

        function get_class2(class1Id){

            $(".two_nav").empty();

           $.getJSON("json/class_2_"+class1Id+".js", function(json){
                //dom对象如何转换为jquery对象  $()
                $(json).each(function(i,data){
                    console.log(data)

                    $(".two_nav").append('<a href="toListPage.do?flbh2='+data.id+'" target="_blank" >'+data.flmch2+'</a>');
                    $(".two_nav").show();
                })
            });
        }


    </script>
</head>
<body>
<div class="menu">
    <div class="nav">
        <div class="navs">
            <div class="left_nav">
                全部商品分类
                <div class="nav_mini">
                    <ul>
                        <li>
                            <a href="">家用电器</a>
                            <div class="two_nav">
                                <a href="">11111</a>
                                <a href="">11111</a>
                            </div>
                        </li>
                        <%--<li onmouseover="get_class2()"><a href="">电脑、办公</a>
                            <div class="two_nav" >
                                <a href="">11111</a>
                                <a href="">11111</a>
                                <a href="">11111</a>
                            </div>
                        </li>--%>

                       <%-- <li><a href="">手机、数码、通信</a></li>
                        <li><a href="">电脑、办公</a></li>
                        <li><a href="">家具、家居、家装</a></li>
                        <li><a href="">男装、女装、内衣</a></li>
                        <li><a href="">个户化妆</a></li>
                        <li><a href="">鞋靴</a></li>
                        <li><a href="">户外运动</a></li>
                        <li><a href="">汽车</a></li>
                        <li><a href="">母婴</a></li>
                        <li><a href="">食品</a></li>
                        <li><a href="">营养保健</a></li>
                        <li><a href="">图书</a></li>
                        <li><a href="">彩票</a></li>
                        <li><a href="">理财</a></li>--%>
                    </ul>
                </div>
            </div>
            <ul>
                <li><a href="">服装城</a></li>
                <li><a href="">美妆馆</a></li>
                <li><a href="">超市</a></li>
                <li><a href="">全球购</a></li>
                <li><a href="">闪购</a></li>
                <li><a href="">团购</a></li>
                <li><a href="">拍卖</a></li>
                <li><a href="">金融</a></li>
                <li><a href="">智能</a></li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
