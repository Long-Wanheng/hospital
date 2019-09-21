<%@page language="java" contentType="text/html;utf-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>药品查询--中软高科-2015</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="../Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="../Css/style.css" />
    <script type="text/javascript" src="../Js/jquery.js"></script>
    <%--<script type="text/javascript" src="../Js/jquery.sorted.js"></script>--%>
    <script type="text/javascript" src="../Js/bootstrap.js"></script>
    <script type="text/javascript" src="../Js/ckform.js"></script>
    <script type="text/javascript" src="../Js/common.js"></script>

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
		$('#newNav').click(function(){
				window.location.href="medicine/add.jsp";
		 });

     });

/*

    $('#qk').click(function(){
        $('#drName').attr("drName","");
        $('#drType').attr("drType","-1");
    })
*/

/*
     $(function(){
         $("#qk").click(function(){

             //ajax方法
             $.ajax({
                 url:"/getdrugs",
                 type:"post",
                 data:"drName=&drType=-1",
                 dataType:"json",
             });

         });
*/



	
    	function checkall(){
			var alls=document.getElementsByName("check");
			var ch=document.getElementById("checkall");
			if(ch.checked){
				for(var i=0;i<alls.length;i++){
					alls[i].checked=true;	
				}	
			}else{
				for(var i=0;i<alls.length;i++){
					alls[i].checked=false;	
				}	
			}
		}

		function delAll(){
			var alls=document.getElementsByName("check");
			var ids=new Array();
			for(var i=0;i<alls.length;i++){
				if(alls[i].checked){
					ids.push(alls[i].value);
				}		
			}
			if(ids.length>0){
				if(confirm("确认操作?")){
					alert("成功!");
				}
			}else{
				alert("请选中要操作的项");
			}
		}

    </script>
    <script>
        $(function(){
            $("#daochu").click(function(){
                //获得被选中的复选框的value值
                var checks=$("[name='check']");
                var strids='';
                for(var i=0;i<checks.length;i++){
                    if(checks[i].checked==true){
                        // alert(checks[i].value);
                        strids=strids+checks[i].value+",";//1,3,5,7
                    }
                }
                strids= strids.substring(0,strids.length-1);
                // alert(strids);
                //   $.post("/findbyids","ids="+strids,null);
                location.href="findids?ids="+strids;
            });
        })
    </script>
</head>
<body>

<form action="/getdrugs" method="post" class="definewidth m20" id="myform">
    <tr><td>
        药品名称:
        <input type="text" name="drName" id="drName" class="abc input-default" placeholder="" value="${drName}">&nbsp;&nbsp;

        药品类型:
        <select id="drType" name="drType" class="form-control">
            <option value="-1" selected>请选择</option>
            <c:forEach items="${drugStatuses}" var="dr">
                <option value="${dr.drugId}" ${dr.drugId==drType?'selected':''} >${dr.statusName}</option>
            </c:forEach>
        </select>

            <button type="submit" class="btn btn-primary">查询</button>
            <button type="reset" class="btn btn-primary" >清空</button>
        </td>
    </tr>

		
</form>

<table class="table table-bordered table-hover definewidth m10" >
   <thead>
    <tr>
    	<th><input type="checkbox" id="checkall" onChange="checkall();"></th>
        <th>药品编号</th>
        <th>药品名称</th>
        <th>药品类型</th>
        <th>简单描述</th>
        <th>状态</th>
        <th>剩余量</th>
        <th>操作</th>
    </tr>
    </thead>
    <c:forEach items="${pageInfo.list}" var="drl">
	     <tr >
         	<td style="vertical-align:middle;"><input type="checkbox" name="check" value="${drl.drId}"></td>
            <td style="vertical-align:middle;">${drl.drId}</td>
            <td style="vertical-align:middle;">${drl.drName}</td>
            <td style="vertical-align:middle;">${drl.drugStatus.statusName}</td>
            <td style="vertical-align:middle;">${drl.drSimDesc}</td>
            <td style="vertical-align:middle;">${drl.drStatusMap}</td>
            <td style="vertical-align:middle;">${drl.drNumber}</td>
            <td style="vertical-align:middle;">
					<a href="/toupdate?drId=${drl.drId}">更改</a>&nbsp;&nbsp;&nbsp;
					<a href="/toaddnum?drId=${drl.drId}">添加库存</a>&nbsp;&nbsp;&nbsp;
					<a href="tolook?drId=${drl.drId}">详情>>></a>
			</td>
        </tr>
    </c:forEach>
  </table>

<table class="table table-bordered table-hover definewidth m10" >
    <tr><th colspan="5">
    <div class="inline pull-right page">
        <a href='/getdrugs?drName=${drName}&drType=${drType}' >第一页</a>
        <a href='/getdrugs?pageindex=${pageInfo.prePage==0?1:pageInfo.prePage}&drName=${drName}&drType=${drType}'>上一页</a>

        <c:forEach begin="1" end="${pageInfo.pages}" var="i">
            <c:if test="${pageInfo.pageNum==i}">
                <span class='current'>${i}</span>
            </c:if>
            <c:if test="${pageInfo.pageNum!=i}">
                <a href='/getdrugs?pageindex=${i}&drName=${drName}&drType=${drType}'>${i}</a>
            </c:if>
        </c:forEach>

        <a href='/getdrugs?pageindex=${pageInfo.nextPage==0?pageInfo.pages:pageInfo.nextPage}&drName=${drName}&drType=${drType}' >下一页</a>
        <a href='/getdrugs?pageindex=${pageInfo.pages}&drName=${drName}&drType=${drType}' >最后一页</a>
        &nbsp;&nbsp;&nbsp;共<span class='current'>${pageInfo.total}</span>条记录<span class='current'> ${pageInfo.pageNum}/${pageInfo.pages} </span>页
    </div>
        <div>
            <button type="button" class="btn btn-success" id="newNav">添加新药</button>&nbsp;&nbsp;&nbsp;
            <button type="button" class="btn btn-success" id="daochu">导出Excel</button>
        </div>

    </th></tr>
</table>


</body>
</html>
