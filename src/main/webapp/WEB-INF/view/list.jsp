<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/11/6
  Time: 9:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>检索</title>
    <link rel="stylesheet" type="text/css" href="css/css.css">

    <script type="text/javascript" src='js/jquery-1.7.2.min.js'></script>

    <script>
        function listSkuByAttrAndClass2(attrId , valId){
            //保存属性

            var val = "{\"attrId\":\""+attrId+"\",\"valId\":\""+valId+"\"}";

            var str = '<input type="text" name="attr_val_id" value='+val+'>';
            $("#save_params_div").append(str)


            var flbh2 = ${flbh2};
            var param = "flbh2="+flbh2;

            //获取属性数组
            $("[name='attr_val_id']").each(function(i,json){
                var obj = jQuery.parseJSON($(json).val());

                //字符串分割
                //如何改为json对象
                param = param + "&attrValueList["+i+"].shxmId="+obj.attrId+"&attrValueList["+i+"].shxzhId="+obj.valId;
            })
            //获取到class2、属性
            //通过ajax查询
            //data：需要一个内嵌页面
            $.post("listSkuByAttrAndClass2.do",param,function(data){
                $("#listSboxInner").html(data)
            })
        }

    </script>
</head>
<body>

    <jsp:include page="top.jsp"></jsp:include>

    <jsp:include page="search.jsp"></jsp:include>


    <jsp:include page="list-filter.jsp"></jsp:include>


    <jsp:include page="list-Sscreen.jsp"></jsp:include>

    <div id="listSboxInner">
        <jsp:include page="list-sbox.jsp"></jsp:include>
    </div>

    <jsp:include page="list-footer.jsp"></jsp:include>
</body>
</html>
