<%@page language="java" contentType="text/html;utf-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>枣阳市第二人民医院信息管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
    <link href="assets/css/bui-min.css" rel="stylesheet" type="text/css" />
    <link href="assets/css/main-min.css" rel="stylesheet" type="text/css" />
</head>
<body>


<!--<div class="header">

    <div class="dl-title">
        <img src="/chinapost/Public/assets/img/top.png">
    </div>

    <div class="dl-log">欢迎您，<span class="dl-log-user">张三</span><a href="/chinapost/index.php?m=Public&a=logout" title="退出系统" class="dl-log-quit">[退出]</a>
    </div>
</div>-->
<div class="content">
    <div class="dl-main-nav">
        <div class="dl-inform"><div class="dl-inform-title"><s class="dl-inform-icon dl-up"></s></div></div>
        <ul id="J_Nav"  class="nav-list ks-clear" style="float:left">
            <!--<li class="nav-item dl-selected"><div class="nav-item-inner nav-home">信息采编系统</div></li>-->
			<li style=" color:#fff; font-size:20px; margin-top:10px; margin-left:20px;">山东省第二人民医院管理平台</li>
		</ul>
		<div  style="float:right; color:#fff;">欢迎您，<span class="dl-log-user">${sessionScope.user.uTrueName}</span>
            <a href="/loginout" title="退出系统" class="dl-log-quit">[退出]</a></div>
    </div>
	
    <ul id="J_NavContent" class="dl-tab-conten">
    </ul>
</div>
<script type="text/javascript" src="assets/js/jquery-1.6.js"></script>
<script type="text/javascript" src="assets/js/bui.js"></script>
<script type="text/javascript" src="assets/js/common/main-min.js"></script>
<script type="text/javascript" src="assets/js/config-min.js"></script>


<script>
    BUI.use('common/main',function(){
        var config = [
		{id:'1',menu:[
		
		{text:'快速通道',items:[
		
		{id:'2',text:'挂号信息管理',href:'/getregisters'},
		
		{id:'5',text:'住院办理',href:'hospital/index.jsp'},
		{id:'8',text:'住院结算',href:'hospital/account.html'},
		
		{id:'7',text:'在院发药',href:'hospital/dispensing.html'},
		{id:'4',text:'药品管理',href:'/getdrugs'},
		
		{id:'16',text:'检查收费项目登记',href:'hospital/charge2.html'},
		{id:'6',text:'收费项目管理',href:'hospital/charge.html'},		
	
		/** 扩展
		{id:'9',text:'月营业额统计',href:''},
		{id:'10',text:'年营业额统计',href:''},
		**/
		{id:'3',text:'门诊医生管理',href:'doctor/index.jsp'},
		{id:'11',text:'用户管理',href:'User/index.jsp'},
		{id:'12',text:'角色管理',href:'/getroles'},
		{id:'13',text:'资源管理',href:'Resource/index.jsp'},
		{id:'13',text:'密码管理',href:'User/password.html'}
		]}
		
		]}
		
		];
        new PageUtil.MainPage({
            modulesConfig : config
        });
    });
</script>
</body>
</html>