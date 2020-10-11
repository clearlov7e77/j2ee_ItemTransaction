<%@ page import="com.example.mizore.Bean.Good" %>
<%@ page import="com.example.mizore.Bean.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Bootstrap 模板</title>

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

    <meta name="viewport" content="width=device-width, initial-scale=1.0" charset="utf-8"/>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
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
            <ul class="nav navbar-nav navbar-right">
                <%if(session.getAttribute("user")!=null){%>
                <li><a href="${pageContext.request.contextPath}/personal?tab=info">个人资料</a></li>
                <%}else{%>
                <li><a href="${pageContext.request.contextPath}/login">登录</a></li>
                <li><a href="${pageContext.request.contextPath}/register">注册</a></li>
                <%}%>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div></nav>



<!--主体部分-->
<div class="container">
    <div class="row">
        <div class="col-md-10 col-md-offset-1">
            <div class="panel panel-info">
                <div class="panel-heading">
                    <%
		out.println("<span style=\"text-align:center;font-size:16px;\" class=\"center-block\">物品详情</span>");
	                %>

                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-7 info-goods">
                            <p>
                            <h3 class="info-goods-name"></h3>
                            <p>
                                ${good.getName()}
                            </p>
                            <p>
                                <br />类型：${good.getType()}<br />
                                <br />
                            </p>
                            <p>
                                价格：${good.getPrice()}<br />
                                <br />
                            </p>


                            <p>
                                发布者：${good.getSeller()}<br><br>
                            </p>
                            <p class="info-goods-content">
                                <% Good good=(Good) request.getAttribute("good");
                                    User user=(User)session.getAttribute("user");
                                %>
                                物品说明：<%=good.getDescription().replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br />") %>
                            </p>
                        </div>
                    </div>
                    <div class="buy-confirm">
                        <hr />
                                    <div class="panel-body">
                                        <form action="${pageContext.request.contextPath}/buy?goodid=<%=good.getId()%>&userid=<%=user.getId()%>" method="post">
                                            <button type="submit" class="pull-left btn btn-default">确认购买</button>
                                        </form>
                                    </div>
                    </div>
                    <%if(request.getParameter("info")!=null){%>
                    <div class="alert alert-warning"><%=request.getParameter("info") %></div>
                    <%}%>

                    <hr />
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>
</html>
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