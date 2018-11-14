<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/6
  Time: 9:48
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
    <%-- 保存选择的属性的id --%>
    <div id="save_params_div">

    </div>

    <div class="Sscreen">
        <div class="title">
            平板电视 商品筛选 共1205个商品
        </div>

        <c:forEach items="${attrList}" var="attr">
            <div class="list">
                <span>${attr.shxmMch}：</span>
                <c:forEach items="${attr.valueList}" var="val">
                    <a href="javascript:listSkuByAttrAndClass2(${attr.id},${val.id})">${val.shxzh}${val.shxzhMch}</a>
                </c:forEach>

            </div>
        </c:forEach>

        <div class="list">
            <span class="list_span" id="list_beas">销量</span>
            <span class="list_span">价格</span>
            <span class="list_span">评论数</span>
            <span class="list_span">上架时间</span>
        </div>
    </div>
</body>
</html>
