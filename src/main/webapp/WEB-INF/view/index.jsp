<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/5
  Time: 9:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <link rel="stylesheet" type="text/css" href="css/css.css">

    <script type="text/javascript" src='js/jquery-1.7.2.min.js'></script>
    <script type="text/javascript">
        $(function(){
            $('.nav_mini ul li').hover(function(){
                $(this).find('.two_nav').show(100);
            },function(){
                $(this).find('.two_nav').hide(100);
            })
        })
    </script>
</head>
<body>

    <jsp:include page="top.jsp"></jsp:include>

    <jsp:include page="search.jsp"></jsp:include>

    <jsp:include page="menu.jsp"></jsp:include>

    <jsp:include page="banner.jsp"></jsp:include>

</body>
</html>
