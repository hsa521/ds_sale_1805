<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/5
  Time: 9:43
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
    <title>
        用户登录
    </title>
    <link rel="shortcut icon" type="image/icon" href="images/jd.ico">
    <link rel="stylesheet" type="text/css" href="css/login.css">
    <script src="js/jquery-1.7.2.min.js"></script>
    <script>
        //登录
        function to_submit(){
            $("#login_form").submit();
        }

        function toIndexPage(){
            location.href="toMainPage.do";
        }

    </script>
    </head>
    <body>
    <div class="up">
        <img onclick="toIndexPage()" src="images/logo.jpg" height="45px;" class="hy_img"/>
        <div class="hy">
        欢迎登录
        </div>
        </div>
        <div class="middle">
        <div class="login">
        <div class="l1 ">
        <div class="l1_font_01 ">JD会员</div>
        <a class="l1_font_02 " href="<%=application.getContextPath() %>/to_regist.action">用户注册</a>
        </div>
        <div class="blank_01"></div>
        <div class="ts">
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${err}
    </div>
    <div class="blank_01"></div>
        <form action="login.do" id="login_form" method="post">
            <input type="hidden" name="loginSuccessUrl" value="${loginSuccessUrl}"/>


            <div class="input1">
            <input type="text" class="input1_01" name="userName"/>
            </div>
            <div class="blank_01"></div>
            <div class="blank_01"></div>
            <div class="input2">
            <input type="text" class="input1_01" name="password"/>
            </div>
        </form>
        <div class="blank_01"></div>
        <div class="blank_01"></div>
        <div class="box_01">
        <input type="checkbox" class="box_01_box"/>
        <div class="box_01_both">
        <div class="box_01_both_1">自动登陆</div>
        <div class="box_01_both_2">忘记密码？</div>
    </div>
    </div>
    <div class="blank_01"></div>
        <a href="#" class="aline">
        <div class="red_button" onclick="to_submit()">
        登&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;录
    </div>
    </a>
    <div class="blank_01"></div>
        <div class="blank_01"></div>
        <div class="box_down">
        <div class="box_down_1">使用合作网站账号登录京东：</div>
    <div class="box_down_1">京东钱包&nbsp;&nbsp;|&nbsp;&nbsp;QQ
    &nbsp;&nbsp;|&nbsp;&nbsp;微信
    </div>
    </div>
    </div>
    </div>

    <div class="down">
        <br />
    </div>
    </body>

    </html>