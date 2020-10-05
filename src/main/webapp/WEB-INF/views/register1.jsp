<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <title>Bootstrap 模板</title>
      <meta name="viewport" content="width=device-width, initial-scale=1.0" charset="utf-8"/>
      <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">     
      <link href="css/sign.css" rel="stylesheet">
      <style type=text/css>
footer {
	margin-top: 1em;
	padding: 5px;
	bottom: 2px;
	clear: both;
	display: block;
	width: 100%;
	border-top: 1px dashed #ccc;
	text-align: center
}

footer small {
	color: #aaa;
	font-size: 12px
}
</style>
   
   </head>
   <body>
   	
   	<!--头部-->
   	<nav class="navbar navbar-default">
		<div class="container">
	<!-- Brand and toggle get grouped for better mobile display -->
	<div class="navbar-header">
		<button type="button" class="navbar-toggle collapsed"
			data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
			aria-expanded="false">
			<span class="sr-only">Toggle navigation</span> 
			<span class="icon-bar"></span>
			<span class="icon-bar"></span> 
			<span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="#"
			style="font-size: 24px">兰杉物品交易平台</a>
	</div>

	<!-- Collect the nav links, forms, and other content for toggling -->
	<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		<ul class="nav navbar-nav">
		</ul>
		<form action="#"
			class="navbar-form navbar-left" role="search">
			<div class="form-group">
				<input type="text" name="key" class="form-control" placeholder="关键字">
			</div>
			<button type="submit" class="btn btn-default">查找物品</button>
		</form>

		<%--<% UserHandle userHandle=new UserHandle();
		   Boolean isLogined=LoginVerify.isLogin(request);
			User user=null;
			String email="";

				//email 是邮箱或用户名（如果存在）
		   if(isLogined){
			   user=(User)session.getAttribute("loginUser");
			   //更新信息，seesion中的user信息可能滞后！
			   user=userHandle.findById(user.getId());
			   email=(user.getName()==null || user.getName().length()==0)?user.getEmail():user.getName();
		   }
                %>--%>
		<ul class="nav navbar-nav navbar-right">
			

			<li><a href="${pageContext.request.contextPath}/login">登录</a></li>
			
		</ul>
	</div>
	<!-- /.navbar-collapse -->
</div></nav>

	<%if(request.getAttribute("error")!=null){
		out.print("<div class=\"alert alert-danger\" role=\"alert\">注册失败，用户名已被占用</div>");
	}%>
     <!--主体部分-->
      	<div class="container">
		<div class="xt_mid">

			<!--提交此form 注册 -->
			<form action="${pageContext.request.contextPath}/registercheck" method="post" class="form-horizontal">
				<h2 class="form-signin-heading">注册账号</h2>
				<div class="form-group">
					<label for="name1" class="col-sm-2 control-label">用户名</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="name1"
							name="name" placeholder="用户名">
					</div>
				</div>
				<div class="form-group">
					<label for="password" class="col-sm-2 control-label">密码</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="password"
							name="password" placeholder="密码">
					</div>
				</div>

			<%--	<div class="form-group">
					<label for="password1" class="col-sm-2 control-label">密码重复</label>
					<div class="col-sm-10">
						<input type="password" class="form-control" id="password1"
							name="password1" placeholder="">
					</div>
				</div>
				--%>

				<div class="form-group">
					<label class="col-sm-2 control-label"></label>
					<div class="col-sm-10" style="text-align: left;">
						
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label"></label>
					<div class="col-sm-10">
						<button type="submit" class="btn btn-block btn-primary">注册</button>
					</div>
				</div>
			</form>
		</div>
	</div>
    
    
    <!--尾部-->
      <footer>
<p>
	<small> LS物品交易-发布平台，Powered By
		<a href="#"
		target="_blank">LSShop</a> | <a rel="license" href="license"
		target="_blank" title="用户协议">©</a> 2020-2020 </small>
</p>
</footer>
      
      
      
      <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
      <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
   </body>
</html>
