<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<div class="panel panel-info">
<div class="panel-heading">
<%
    out.println("个人资料");
%>
</div>
    <%if(request.getAttribute("success")!=null){
        out.print("<div class=\"alert alert-success\" role=\"alert\">成功修改资料</div>");
    }%>
<div class="panel-body">
    <br />
    <form action="${pageContext.request.contextPath}/personal?tab=info&sign=1" method="post">
        <div class="form-group">
            <div class="input-group">
                <span class="input-group-addon" id="name1">用户名</span>
                <input readonly type="text" class="form-control" value="<%=user.getName()%>">
            </div>
        </div>
        <div class="form-group">
            <div class="input-group">
                <span class="input-group-addon" id="password1">密码</span>
                <input readonly type="text" class="form-control" value="<%=user.getPassword()%>">
            </div>
        </div>
        <div class="form-group">
            <div class="input-group">
                <span class="input-group-addon" id="money1">余额</span>
                <input readonly type="text" class="form-control" value="<%=user.getMoney()%>">
            </div>
        </div>
        <div class="form-group">
            <div class="input-group">
                <span class="input-group-addon" id="address1">地址</span>
                <input type="text" class="form-control" name="address" value="<%=user.getAddress()%>" maxlength="40">
            </div>
        </div>

        <button type="submit" class="btn btn-primary">更新我的资料</button>
    </form>
</div>
</div>
      
