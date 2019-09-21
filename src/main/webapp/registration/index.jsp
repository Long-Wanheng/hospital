<%@page language="java" contentType="text/html;utf-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>门诊查询--中软高科-2015</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="../Css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="../Css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="../Css/style.css" />
    <script type="text/javascript" src="../Js/jquery.js"></script>
    <script type="text/javascript" src="../Js/jquery.sorted.js"></script>
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
                window.location.href="add.jsp";
            });
        });

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
    <script type="text/javascript">
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
                location.href="findbyids?ids="+strids;
            });
        })
    </script>
</head>
<body>

<form action="/getregisters" method="post" class="definewidth m20">
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td width="10%" class="tableleft">病历号：</td>
        <td><input type="text" name="num" value="${num==-1?'':num}"/></td>
		
        <td width="10%" class="tableleft">主治医生：</td>
        <td><input type="text" name="dDoctorName" value="${dDoctorName}"/></td>
		
        <td width="10%" class="tableleft">科室：</td>
        <td><input type="text" name="dname" value="${dname}"/></td>
    </tr>
    <tr>
		
        <td width="10%" class="tableleft">挂号时间：</td>
		
		  <td colspan="5">
			<input type="text" name="beginTime" value="${beginTime}"/>&nbsp;至&nbsp;
              <input type="text" name="endTime" value="${endTime}"/>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <button type="submit" class="btn btn-primary" type="button">查询</button> 
            <button type="submit" class="btn btn-primary" type="button">清空</button> 
			
        </td>
    </tr>
</table>
</form>
   
<table class="table table-bordered table-hover definewidth m10" >
   <thead>
    <tr>
    	<th><input type="checkbox" id="checkall" onChange="checkall();"></th>
        <th>门诊编号</th>
        <th>主治医生</th>
        <th>挂号时间</th>
        <th>挂号科室</th>
        <th>状态</th>
        <th>操作</th>
    </tr>
    </thead>
    <c:forEach items="${pageInfo.list}" var="reg">
	     <tr >
         	<td style="vertical-align:middle;"><input type="checkbox" name="check" value="${reg.hosrId}"></td>
            <td style="vertical-align:middle;">${reg.hosrId}</td>
            <td style="vertical-align:middle;">${reg.doctor.dDoctorName}</td>
            <td style="vertical-align:middle;"><fmt:formatDate value="${reg.hosdate}" pattern="yyyy-MM-dd hh:mm:ss"></fmt:formatDate> </td>
            <td style="vertical-align:middle;">${reg.dept.dname}</td>
            <td style="vertical-align:middle;">${reg.hosrState==0?'已挂号':reg.hosrState==1?'已住院':reg.hosrState==2?'已出院':reg.hosrState==3?'已退号':''}</td>
            <td style="vertical-align:middle;"><a href="look.html">详情>>></a>&nbsp;&nbsp;&nbsp;<a href="edit.html">更改</a>&nbsp;&nbsp;&nbsp;<a href="javascript:alert('退号成功！');">退号</a></td>
        </tr>
    </c:forEach>
  </table>
  
  <table class="table table-bordered table-hover definewidth m10" >
  	<tr><th colspan="5">  <div class="inline pull-right page">
          <a href='/getregisters?num=${num}&dDoctorName=${dDoctorName}&dname=${dname}&beginTime=${beginTime}&endTime=${endTime}' >第一页</a>
        <a href='/getregisters?pageindex=${pageInfo.prePage==0?1:pageInfo.prePage}&num=${num}&dDoctorName=${dDoctorName}&dname=${dname}&beginTime=${beginTime}&endTime=${endTime}'>上一页</a>

        <c:forEach begin="1" end="${pageInfo.pages}" var="i">
           <c:if test="${pageInfo.pageNum==i}">
               <span class='current'>${i}</span>
           </c:if>
            <c:if test="${pageInfo.pageNum!=i}">
            <a href='/getregisters?pageindex=${i}&num=${num}&dDoctorName=${dDoctorName}&dname=${dname}&beginTime=${beginTime}&endTime=${endTime}'>${i}</a>
            </c:if>
        </c:forEach>

        <a href='/getregisters?pageindex=${pageInfo.nextPage==0?pageInfo.pages:pageInfo.nextPage}&num=${num}&dDoctorName=${dDoctorName}&dname=${dname}&beginTime=${beginTime}&endTime=${endTime}' >下一页</a>
        <a href='/getregisters?pageindex=${pageInfo.pages}&num=${num}&dDoctorName=${dDoctorName}&dname=${dname}&beginTime=${beginTime}&endTime=${endTime}' >最后一页</a>
		  &nbsp;&nbsp;&nbsp;共<span class='current'>32</span>条记录<span class='current'> 1/33 </span>页
		  </div>
		 <div><button type="button" class="btn btn-success" id="newNav">门诊挂号</button>&nbsp;&nbsp;&nbsp;
		 <button type="button" class="btn btn-success" id="delPro" onClick="delAll();">退号</button>&nbsp;&nbsp;&nbsp;
		 <button type="button" class="btn btn-success" id="daochu">导出Excel</button>
		
		 
		 </div>
		 
		 </th></tr>
  </table>
  
</body>
</html>
