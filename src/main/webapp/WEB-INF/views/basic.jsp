<%@ page import="com.example.mizore.Bean.Good" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Bootstrap 模板</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" charset="utf-8"/>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
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
            <form action="${pageContext.request.contextPath}/basic?ceta=7&pn=1"
                  class="navbar-form navbar-left" role="search" method="post">
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
            <%

                int ceta=0;
                if(request.getAttribute("ceta")!=null){
                    ceta=(int)request.getAttribute("ceta");
                   // System.out.println(ceta);
                }
             //   int ceta=(int)request.getAttribute("ceta");

            %>
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

<%
   // System.out.println(request.getAttribute("info"));
    if(request.getAttribute("info")!=null){
    if(request.getAttribute("info").equals("success")){
    out.print("<div class=\"alert alert-success\" role=\"alert\">购买成功</div>");
    }
    else{
        out.print("<div class=\"alert alert-danger\" role=\"alert\">余额不足，购买失败！</div>");
    }
}
%>

<div class="container">
    <div class="row">
        <div class="col-md-3">
            <div class="row">
                <div class="col-md-12">
                    <div class="list-group">
                        <span class="list-group-item list-group-item-info">分类</span> <a
                            href="${pageContext.request.contextPath}/basic?ceta=0&pn=1"
                            class="list-group-item <%=ceta == 0 ? "active" : ""%>"><span
                            class="badge"> <!-- 这里写数量，暂时搁置 -->
							</span>全部</a> <a href="${pageContext.request.contextPath}/basic?ceta=2&pn=1"
                                             class="list-group-item <%=ceta == 2 ? "active" : ""%>"><span
                            class="badge"></span>生活出行</a> <a href="${pageContext.request.contextPath}/basic?ceta=1&pn=1"
                                                             class="list-group-item <%=ceta == 1 ? "active" : ""%>"><span
                            class="badge"></span>书籍</a> <a href="${pageContext.request.contextPath}/basic?ceta=5&pn=1"
                                                           class="list-group-item <%=ceta == 5 ? "active" : ""%>"><span
                            class="badge"></span>体育运动</a> <a href="${pageContext.request.contextPath}/basic?ceta=4&pn=1"
                                                             class="list-group-item <%=ceta == 4 ? "active" : ""%>"><span
                            class="badge"></span>电子产品</a> <a href="${pageContext.request.contextPath}/basic?ceta=3&pn=1"
                                                             class="list-group-item <%=ceta == 3 ? "active" : ""%>"><span
                            class="badge"></span>衣物鞋包</a> <a href="${pageContext.request.contextPath}/basic?ceta=6&pn=1"
                                                             class="list-group-item <%=ceta == 6 ? "active" : ""%>"><span
                            class="badge"></span>其他</a>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-8">
            <div class="list-group">
                    <%
						switch (ceta) {
                            case 0:
                                out.println("<span class=\"list-group-item list-group-item-info\">分类-全部</span>");
                                break;
						case 1:
							out.println("<span class=\"list-group-item list-group-item-info\">分类-书籍</span>");
							break;
						case 2:
							out.println("<span class=\"list-group-item list-group-item-info\">分类-生活出行</span>");
							break;
						case 3:
							out.println("<span class=\"list-group-item list-group-item-info\">分类-衣物鞋包</span>");
							break;
						case 4:
							out.println("<span class=\"list-group-item list-group-item-info\">分类-电子产品</span>");
							break;
						case 5:
							out.println("<span class=\"list-group-item list-group-item-info\">分类-体育运动</span>");
							break;
						case 6:
							out.println("<span class=\"list-group-item list-group-item-info\">分类-其他</span>");
							break;
						default:
							out.println("<span class=\"list-group-item list-group-item-info\">分类-全部</span>");
							break;
						}
						%>
                <%
                    if(request.getAttribute("list")!=null){
                    List<Good> list=(List<Good>)request.getAttribute("list");
						if (list.size() != 0) {
							for (Good good : list) {%>
				<div class="list-group-item">
                <div class="row">
                    <div class="col-md-10">
                        <div class="row detail-goods lead">
                            <a href="${pageContext.request.contextPath}/good?goodid=<%=good.getId()%>"><%=good.getName()%></a>
                        </div>
                    </div>
                </div>
                </div>
                <%}
						} else {%>
                <div class="list-group-item">此分类下暂无物品或页数已经到达最大！</div>
                <%}
                    }%>
            </div>
                <%
                    int maxPage=1;
                    if(request.getAttribute("maxpage")!=null)maxPage=(int)request.getAttribute("maxpage");
				//	int maxPage = num.value % perPage == 0 ? num.value / perPage : num.value / perPage + 1;
                    int pn=1;
                    if(request.getAttribute("pn")!=null)pn=(int)request.getAttribute("pn");
				%>
            <nav>
                <ul class="pager">
                    <li class=""><a class="page-cut-btn"
                                    href="${pageContext.request.contextPath}/basic?ceta=<%=ceta%>&pn=<%=pn <= 1 ? pn : pn - 1%>"><span
                            aria-hidden="true"></span><%=pn > 1 ? "上一页" : "位于首页"%></a></li>
                    <li style=""><span style="border: 0">第<span
                            style="color: red; border: 0"><%=pn%></span>页
						</span></li>
                    <li class=""><a class="page-cut-btn"
                                    href="${pageContext.request.contextPath}/basic?ceta=<%=ceta%>&pn=<%=pn < maxPage ? pn + 1 : pn%>"><%=pn < maxPage ? "下一页" : "位于末页"%>
                        <span aria-hidden="true"></span></a></li>
                </ul>
            </nav>
        </div>
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
