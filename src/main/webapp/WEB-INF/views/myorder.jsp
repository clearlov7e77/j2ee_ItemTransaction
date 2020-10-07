<%@ page import="com.example.mizore.Bean.Order" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
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
        我的订单
    </div>
    <div class="panel-body">
            <%
				List<Order> list=new ArrayList<>();
				if(request.getAttribute("list")!=null)list=(List<Order>)request.getAttribute("list");
				if(list.size()!=0){
		    	for(Order order:list){%>
			    	<div class="list-group-item">
		                        <div class="row">
		                                <div class="col-md-10">
		                                <div class="row detail-goods lead">
											<span>商品名称：<%=order.getName()%></span>
		                                </div>
		                                <div class="row detail-goods">地址:<span class="text-danger"><%=order.getAddress()%></span>
		                                <span class="detail-goods text-muted">　卖家:<%=order.getSeller()%></span>
											<span class="detail-goods text-muted">总金额：<%=order.getCount()%></span>
										</div>

		                            </div>
		                        </div>
		                    </div>
			    	<%}}else{%>
			    	还没有购买过商品
			    	<%}%>
			</div>
		</div>
</body>
</html>
