<%--
  Created by IntelliJ IDEA.
  User: shentao
  Date: 2018/11/12
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>订单支付</title>
    <link rel="stylesheet" type="text/css" href="css/css.css"/>
    <script src="/js/jquery-1.7.2.min.js"></script>
    <script>
        function address(id,shjr,dzMch,lxfsh){

            var addr = "寄送至 : "+dzMch+"  &nbsp;"+shjr+"（收） &nbsp;"+lxfsh;
            $("#addressIdInp").val(id);
            $("#dzMchInp").val(dzMch);
            $("#shjrInp").val(shjr);

            $(".msg_sub_adds").html(addr);

        }
        //保存订单
        function saveOrder(){
            $("#saveOrderForm").submit();

        }
    </script>
</head>
<body>

<form id="saveOrderForm" action="saveOrder.do" method="post">
    <input type="hidden" name="id" id="addressIdInp"/>
    <input type="hidden" name="dzMch" id="dzMchInp"/>
    <input type="hidden" name="shjr" id="shjrInp"/>
</form>

<jsp:include page="top.jsp"></jsp:include>

<jsp:include page="search.jsp"></jsp:include>


<div class="message">
    <div class="msg_title">
        收货人信息
    </div>

    <c:forEach items="${addressList}" var="address">
        <div class="msg_addr">
                    <span class="msg_left">
<input type="radio" onclick="address(${address.id},'${address.shjr}','${address.dzMch}',${address.lxfsh})" name="address" value="${address}">
                        姓名:  ${address.shjr}
                    </span>
            <span class="msg_right">
                        ${address.dzMch}
                        ${address.lxfsh}
                    </span>
        </div>
    </c:forEach>

    <span class="addrs">查看更多地址信息</span>
    <div class="msg_line"></div>

    <div class="msg_title">
        送货清单
    </div>

    <c:forEach items="${checkOrderList}" var="co">
        <div class="msg_list">
            <div class="msg_list_left">
                配送方式
                <div class="left_title">
                    京东快递
                </div>
            </div>
            <div class="msg_list_right">
                <div class="msg_img">
                    <img src="images/msgImg.png"/>
                </div>
                <div class="msg_name">
                    商品名称：${co.skuMch}
                </div>
                <div class="msg_price">
                    ￥${co.skuJg}
                </div>
                <div class="msg_mon">
                    *${co.tjshl}
                </div>
                <div class="msg_state">
                    有货
                </div>
            </div>
        </div>
    </c:forEach>



    <div class="msg_line"></div>

    <div class="msg_sub">
        <div class="msg_sub_tit">
            应付金额：
            <b>￥${sum}</b>
        </div>
        <div class="msg_sub_adds">
        </div>
        <button class="msg_btn" onclick="saveOrder()">提交订单</button>
    </div>

</div>

</body>
</html>
