<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/5
  Time: 9:36
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
    <script src="js/jquery-1.7.2.min.js"></script>
    <script>
        $(function(){

            var yhMch = getCookieByKey("yhMch")
            $("#yhMch_span").html(yhMch);

        })

        //通过key获取到value
        function getCookieByKey(key){

            var val = "";
            var ck = document.cookie;
            ck = ck.replace(" ","");
            var ckArr = ck.split(";");
            for (var i = 0; i<ckArr.length; i++){
                console.log(ckArr[i]);//yhMch=zs

                var arr = ckArr[i].split("=");
                if(arr[0] == key){
                    val = arr[1];
                }
            }

            return val;
        }
    </script>
</head>
<body>
    <div class="top">
        <div class="top_text">
            <c:if test="${empty user}">
                <a href="toLoginPage.do">用户登录:<span id="yhMch_span"></span></a>
                <a href="">用户注册</a>
            </c:if>
            <c:if test="${!empty user}">
                <a href="toLoginPage.do">用户名：${user.yhMch}</a>
                <a href="logout.do">注销</a>
            </c:if>
        </div>
    </div>

    <div class="top_img">
        <img src="./images/top_img.jpg" alt="">
    </div>
</body>
</html>
