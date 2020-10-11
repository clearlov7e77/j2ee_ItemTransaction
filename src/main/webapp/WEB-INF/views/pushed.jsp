<%@ page import="com.example.mizore.Bean.Order" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.mizore.Bean.Good" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" charset="utf-8"/>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<div class="panel panel-info">
    <div class="panel-heading">
        我发布的
    </div>
    <div class="panel-body">
        <%
            List<Good> list=new ArrayList<>();
            if(request.getAttribute("list")!=null)list=(List<Good>)request.getAttribute("list");
            if(list.size()!=0){
                for(Good good:list){%>
        <div class="list-group-item">
            <div class="row">
                <div class="col-md-10">
                    <div class="row detail-goods lead">
                        <span>商品名称：<%=good.getName()%></span>
                    </div>
                    <div class="row detail-goods">价格:<span class="text-danger"><%=good.getPrice()%></span>
                        <span class="detail-goods text-muted">　分类:<%=good.getType()%></span>
                        <span class="detail-goods text-muted">简介：<%=good.getDescription()%></span>
                    </div>
                    <form action="${pageContext.request.contextPath}/delete?gooid=<%=good.getId()%>" method="post">
                        <button type="submit" class="btn btn-primary">删除</button>
                    </form>
                </div>
            </div>
        </div>
        <%}}else{%>
        还没有发布过商品
        <%}%>
    </div>
</div>
</body>
</html>
