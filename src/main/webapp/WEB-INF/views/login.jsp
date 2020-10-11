<%@ page language="java" contentType="text/html; charset=UTF-8"
             pageEncoding="UTF-8"%>
<%--
<%@ page language="java"%>
<%@ page import="java.sql.*"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>--%>

<!DOCTYPE html>
<html>
<head>
    <%--<base href=" <%=basePath%>">--%>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" charset="utf-8"/>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="/login.css" rel="stylesheet">
    <title>登录界面</title>
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

                <li><a href="${pageContext.request.contextPath}/register">注册</a></li>

            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div></nav>



<%if(request.getAttribute("isRegister")!=null){
out.print("<div class=\"alert alert-success\" role=\"alert\">注册成功，现在你可以登录</div>");
}
%>
<%if(request.getAttribute("outsuccess")!=null){
    out.print("<div class=\"alert alert-success\" role=\"alert\">退出成功</div>");
}
%>
<%if(request.getAttribute("isLoginOk")!=null && request.getAttribute("isLoginOk").equals("false")){
out.print("<div class=\"alert alert-danger\" role=\"alert\">登录失败，请检查邮箱和密码</div>");
}
%>

<div class="container">
    <form class="form-signin" action="${pageContext.request.contextPath}/logincheck" Method="Post">
        <h2 class="form-signin-heading">登录网站</h2>
        <label for="name" class="sr-only">Email address</label>
        <input
            type="text" id="name" class="form-control" name="name"
            placeholder="用户名" required autofocus>
        <label
            for="password" class="sr-only">Password
        </label>
        <input
            type="password" id="password" class="form-control"
            name="password" placeholder="密码" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
    </form>
</div>
<!-- /container -->


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
