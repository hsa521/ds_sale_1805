<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/7
  Time: 9:54
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
    <script src="js/jquery-1.7.2.min.js"></script>
    
    <script>
        function saveCart() {
            $("#tjshlInp").val($("#numInp").val());


            $("#saveCartForm").submit();

        }

        function changeNum(flag) {
            var numObj = $("#numInp");
            if (flag ==1 ){//加
                numObj.val(parseInt(numObj.val()) + 1)
            }else if (flag == 2){//减
                if (numObj.val() > 1){
                    numObj.val(parseInt(numObj.val()) - 1)
                }
            }

        }
    </script>
    
</head>
<body>

<jsp:include page="top.jsp"></jsp:include>

<jsp:include page="search.jsp"></jsp:include>

<div class="Dbox">
    <div class="box">
        <div class="left">
            <div class="timg"><img src="images/img_5.jpg" alt=""></div>
            <div class="timg2">
                <div class="lf"><img src="images/lf.jpg" alt=""></div>
                <div class="center">
                    <span><img src="images/icon_2.jpg" alt=""></span>
                    <span><img src="images/icon_3.jpg" alt=""></span>
                    <span><img src="images/icon_2.jpg" alt=""></span>
                    <span><img src="images/icon_3.jpg" alt=""></span>
                    <span><img src="images/icon_2.jpg" alt=""></span>
                </div>
                <div class="rg"><img src="images/rg.jpg" alt=""></div>
            </div>
            <div class="goods"><img src="images/img_6.jpg" alt=""></div>
        </div>
        <div class="cent">
            <div class="title">${itemvo.skuMch}</div>
            <div class="bg">
                <p>市场价：<strong>￥${itemvo.jg}</strong></p>
                <p>促销价：<strong>￥${itemvo.jg}</strong></p>
            </div>
            <div class="clear">
                <div class="min_t">选择版本：</div>

                <c:forEach items="${skuList}" var="sku">
                    <div class="min_mx" onclick=func($(this),'0')>
                            <a href="toItemPage.do?skuId=${sku.id}&spuId=${sku.shpId}">
                                ${sku.skuMch}
                            </a>
                    </div>
                </c:forEach>

            </div>
            <div class="clear">
                <div class="min_t" onclick=func($(this),'1')>服务：</div>
                <div class="min_mx" onclick=func($(this),'1')>服务1号1</div>
                <div class="min_mx" onclick=func($(this),'1')>服务二号1112</div>
                <div class="min_mx" onclick=func($(this),'1')>55英服务二号1111寸活动中3</div>
                <div class="min_mx" onclick=func($(this),'1')>4</div>
                <div class="min_mx" onclick=func($(this),'1')>呃呃呃5</div>
                <div class="min_mx" onclick=func($(this),'1')>55英寸活动中6</div>
            </div>
            <div class="clear" style="margin-top:20px;">
                <div class="min_t" style="line-height:36px">数量：</div>
                <div class="num_box">
                    <input type="text" id="numInp" name="num" value="1" style="width:40px;height:32px;text-align:center;float:left">
                    <div class="rg">
                        <img onclick="changeNum(1)" src="images/jia.jpg" id='jia' alt="">
                        <img onclick="changeNum(2)" src="images/jian.jpg" id='jian' alt="">
                    </div>
                </div>
            </div>
            <div class="clear" style="margin-top:20px;">
                <img src="images/shop.jpg" onclick="saveCart()" alt="">
            </div>
        </div>
    </div>
</div>
<div class="Dbox1">
    <div class="boxbottom">
        <div class="top">
            <span>商品详情</span>
            <span>评价</span>
        </div>
        <div class="btm">
            <c:forEach items="${itemvo.avList}" var="av">
                ${av.shxMch}:${av.shxZh}
                <br>
            </c:forEach>
        </div>
    </div>
</div>
    <form action="saveCart.do" method="post" id="saveCartForm">



        <input type="text" name="skuMch" value="${itemvo.skuMch}">
        <input type="text" name="skuJg" value="${itemvo.jg}">
        <input type="text" name="shpId" value="${itemvo.shpId}">
        <input type="text" name="skuId" value="${itemvo.id}">
        <input type="text" name="shpTp" value="${itemvo.imgList.get(0).url}">
        <input type="text" name="tjshl" value="1" id="tjshlInp">
        <input type="text" name="shfxz" value="1">
        <%--<input type="text" name="hj" value="${itemvo.jg}">--%>
        <input type="text" name="kcdz" value="${itemvo.kcdz}">


    </form>
</body>
</html>
