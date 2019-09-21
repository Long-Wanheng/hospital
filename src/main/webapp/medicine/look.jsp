<%@page language="java" contentType="text/html;utf-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>查看--中软高科-2015</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="../Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="../Css/style.css" />
    <script type="text/javascript" src="../Js/jquery.js"></script>
    <script type="text/javascript" src="../Js/jquery.sorted.js"></script>
    <script type="text/javascript" src="../Js/bootstrap.js"></script>
    <script type="text/javascript" src="../Js/ckform.js"></script>
    <script type="text/javascript" src="../Js/common.js"></script>
    <script type="text/javascript" src="../Js/ckeditor/ckeditor.js"></script>
 

    <style type="text/css">
        body {
            padding-bottom: 40px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }


    </style>
    <script type="text/javascript">
    $(function () {       
		$('#backid').click(function(){
				window.location.href="/getdrugs";
		 });
    });
    </script>
</head>
<body>
<form action="index.jsp" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
    <c:forEach items="${dr}" var="dr">
        <tr>
            <td width="10%" class="tableleft">药品编号</td>
            <td><input type="text" name="drId" value="${dr.drId}" readonly/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">图片</td>
            <td><input type="file" name="drUrl" value="${dr.drUrl}" readonly/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">进价</td>
            <td><input type="text" name="drInprice" value="${dr.drInprice}" readonly/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">售价</td>
            <td><input type="text" name="drOutprice" value="${dr.drOutprice}" readonly/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">药品名称</td>
            <td><input type="text" name="drName" value="${dr.drName}" readonly/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">药品类型</td>
            <td><input type="text" name="drName" value="${dr.drType}" readonly/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">简单描述</td>
            <td><input type="text" name="drSimDesc" value="${dr.drSimDesc}" readonly/></td>
        </tr>

        <tr>
            <td width="10%" class="tableleft">保质期</td>
            <td><input type="text" name="drTime" value="${dr.drTime}" readonly/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">详细描述</td>
            <td><textarea name="drDetaDesc" readonly>${dr.drDetaDesc}</textarea></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">生产厂商</td>
            <td><textarea name="drFactory" readonly>${dr.getdrFactory()}</textarea></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">服用说明</td>
            <td><input type="text" name="drDirection" value="${dr.drDirection}" readonly/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">备注</td>
            <td><input type="text" name="drRemark" value="${dr.drRemark}" readonly/></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">库存</td>
            <td><textarea name="drNumber" readonly>${dr.drNumber}</textarea></td>
        </tr>
        <tr>
            <td width="10%" class="tableleft">销售状态</td>
            <td><textarea name="drStatusMap" readonly>${dr.drStatusMap}</textarea></td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="2">
				<button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
		</td>
    </tr>
</table>
</form>
</body>
</html>