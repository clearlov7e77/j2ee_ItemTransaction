<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" charset="utf-8"/>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<%if(request.getAttribute("success")!=null){
    out.print("<div class=\"alert alert-success\" role=\"alert\">成功上架</div>");
}%>
<%if(request.getAttribute("error")!=null){
    out.print("<div class=\"alert alert-danger\" role=\"alert\">上架失败，该商品已存在</div>");
}%>
    <div class="row clearfix">
        <div class="col-md-1 column">
        </div>
        <div class="col-md-11 column">
            <div class="panel-body">

                <form action="${pageContext.request.contextPath}/newproduct" method="post"
                      enctype="multipart/form-data">


                    <div class="form-group">
                        <p>物品名称：</p>
                        <input class="form-control" name="name" required maxlength="30">
                    </div>
                    <div class="form-group">
                        <p>价格(元)：</p>
                        <input type="number" class="form-control" name="price" min=0 required >
                    </div>
                    <div class="form-group">
                        <p>物品简介：</p>
                        <textarea rows="3" class="form-control" name="description" maxlength="1000"></textarea>
                    </div>
                    <div class="form-group">
                        <p>选择一个分类：</p>
                        <select name="type" class="form-control">
                            <option value="book">书籍</option>
                            <option value="live">生活出行</option>
                            <option value="clothes">衣服鞋包</option>
                            <option value="electronic">电子产品</option>
                            <option value="sport">体育运动</option>
                            <option value="other">其他</option>
                        </select>
                <!--    </div>
                    <div class="form-group">
                        <p>物品图片：</p>
                        <input type="file" name="file">
                        <p class="help-block">提醒：请上传真实物品照片</p>
                    </div>
                    -->
                    <button type="submit" class="btn btn-primary">提交</button>
                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>
