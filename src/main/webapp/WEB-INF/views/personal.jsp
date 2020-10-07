<%@page import="org.apache.el.lang.ELSupport"%>
<%@ page import="com.example.mizore.Bean.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" charset="utf-8"/>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


    <title>用户中心</title>
</head>
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
            <ul class="nav navbar-nav navbar-right">
                <li><a href="${pageContext.request.contextPath}/basic?ceta=0&pn=1">主页面</a></li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div></nav>
<body>
<%
    User user=null;
    String tab="fuck";
    if(session.getAttribute("user")!=null) {
        user = (User) session.getAttribute("user");
    }
    if(request.getAttribute("tab")!=null) {
        tab=(String)request.getAttribute("tab");
    }
    if(user==null){
        out.println("请登录");
        return;
    }
%>

<div class="container">
    <div class="row">
        <div class="col-md-3">
            <div class="row">
                <div class="col-md-12">
                    <div class="list-group">
                        <div class="list-group-item personal-main-info">
                            <div class="row detail-goods text-muted">姓名：<%=user.getName() %></div>
                        </div>
                        <a href="${pageContext.request.contextPath}/personal?tab=info"
                           class="list-group-item <%=tab.equals("info")?"active":"" %>">
                            个人信息</a>
                        <a href="${pageContext.request.contextPath}/personal?tab=myorder"
                           class="list-group-item <%=tab.equals("history")?"active":"" %>">
                            我的订单</a>
                        <a href="${pageContext.request.contextPath}/personal?tab=pushed"
                           class="list-group-item <%=tab.equals("pushed")?"active":"" %>">
                            我发布的</a>
                        <a href="${pageContext.request.contextPath}/personal?tab=push"
                           class="list-group-item <%=tab.equals("push")?"active":"" %>">
                            发布商品</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-8">
            <%if(tab.equals("push")){%>
            <%@ include file="push.jsp"%>
            <%}%>
            <%if(tab.equals("info")){%>
            <%@ include file="info.jsp"%>
            <%}%>
            <%if(tab.equals("myorder")){%>
            <%@ include file="myorder.jsp"%>
            <%}%>
            <%if(tab.equals("pushed")){%>
            <%@ include file="pushed.jsp"%>
            <%}%>
        </div>
    </div>

</div>


</body>
</html>