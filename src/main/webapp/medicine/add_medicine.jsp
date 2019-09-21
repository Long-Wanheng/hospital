<%@page language="java" contentType="text/html;utf-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>添加药品--中软高科-2015</title>
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
<form action="/addnum" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
    <c:forEach items="${dr}" var="dr">
    <tr>
        <td width="10%" class="tableleft">药品编号</td>
        <td><input type="text" name="drId" value="${dr.drId}" readonly/></td>
    </tr> 
	
    <tr>
        <td width="10%" class="tableleft">药品名称</td>
        <td><input type="text" name="drName" value="${dr.drName}" readonly/></td>
    </tr>    
	<tr>
        <td width="10%" class="tableleft">余量</td>
        <td><input type="text"  value="${dr.drNumber}" readonly/></td>
    </tr>    
	
    <tr>
        <td width="10%" class="tableleft">数量</td>
        <td><input type="text" name="drNumber" value="${dr.drNumber}"/></td>
    </tr>
    </c:forEach>

    <tr>
        <td colspan="2">
				<button type="submit" class="btn btn-primary" type="button">保存</button> &nbsp;&nbsp;
            <button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
		</td>
    </tr>
</table>
</form>
</body>
</html>