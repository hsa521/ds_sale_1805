<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: shentao
  Date: 2018/11/9
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <link rel="stylesheet" type="text/css" href="css/css.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<style type="text/css">
    td{vertical-align: middle !important;}
    .form-group{padding: 5px 0;}
</style>
<script src="js/jquery-1.7.2.min.js"></script>
    <script>
        //flag  是否选中
        function changeShfxz(skuId , flag){
            var shfxz = 0;
            if(flag){
                shfxz = 1;
            }
            $.post("changeShfxz.do",{"skuId":skuId,"shfxz":shfxz},function(data){
                $("#cartListInnerDiv").html(data);
            })
        }
    </script>
<body>

        <jsp:include page="top.jsp"></jsp:include>

        <jsp:include page="search.jsp"></jsp:include>

        <div id="cartListInnerDiv">
            <jsp:include page="cartListInner.jsp"></jsp:include>
        </div>




<div class="footer">
    <div class="top"></div>
    <div class="bottom"><img src="images/foot.jpg" alt=""></div>
</div>

<!-- 模态弹出窗内容 -->
<div class="modal" id="mymodal-data" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title">新添收货地址</h4>
            </div>
            <div class="modal-body" style="overflow:hidden">
                <div class="form-group">
                    <div class="col-sm-10">
                        <input type="email" class="form-control" id="inputEmail3" placeholder="请输入您的所在地区">
                    </div>
                    <br>
                </div>
                <div class="form-group">
                    <div class="col-sm-10">
                        <input type="email" class="form-control" id="inputEmail3" placeholder="请输入您的详细地址">
                    </div>
                    <br>
                </div>
                <div class="form-group">
                    <div class="col-sm-10">
                        <input type="email" class="form-control" id="inputEmail3" placeholder="请输入您的邮政编码">
                    </div>
                    <br>
                </div>
                <div class="form-group">
                    <div class="col-sm-10">
                        <input type="email" class="form-control" id="inputEmail3" placeholder="请输入您的收货人姓名">
                    </div>
                    <br>
                </div>
                <div class="form-group">
                    <div class="col-sm-10">
                        <input type="email" class="form-control" id="inputEmail3" placeholder="请输入您的手机号码">
                    </div>
                    <br>
                </div>
                <div class="form-group">
                    <div class="col-sm-10">
                        <input type="email" class="form-control" id="inputEmail3" placeholder="请输入您的电话号码">
                    </div>
                    <br>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary">保存</button>
            </div>
        </div>
    </div>
</div>
<script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>
