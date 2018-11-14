<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/6
  Time: 9:47
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
        function f() {
        }
    </script>
</head>
<body>
    <!--筛选阶段-->
    <div class="filter">
        <h2>电脑、办公 </h2>
        <span class="gt">&gt</span>
        <div class="filter_div">
            电脑整机
        </div>
        <span class="gt">&gt</span>
        <div class="filter_div">
            游戏本
        </div>
        <span class="gt">&gt</span>
        <div class="filter_div">
            游戏本
        </div>
        <div class="filter_clear">
            清空筛选
        </div>

    </div>
</body>
</html>
