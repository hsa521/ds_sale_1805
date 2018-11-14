<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/6
  Time: 9:49
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
    <div class="Sbox">

        <c:forEach items="${skuList}" var="sku">
            <div class="list">
                <div class="img"><img src="images/img_4.jpg" alt=""></div>
                <div class="price">¥${sku.jg}</div>
                <div class="title">
                    <a target="_blank" href="toItemPage.do?skuId=${sku.id}&spuId=${sku.shpId}">${sku.skuMch}</a>
                </div>
            </div>
        </c:forEach>

    </div>
</body>
</html>
