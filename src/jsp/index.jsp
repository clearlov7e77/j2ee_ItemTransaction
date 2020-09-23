<%--
  Created by IntelliJ IDEA.
  User: sakura
  Date: 2020/4/1
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hello</title>
    <script type="text/javascript">
        function fun1(){
            var sch=document.getElementById("sch");
            var major=document.getElementById("major");
            var s1=sch.options[sch.selectedIndex].text;
            if(s1=="计算机学院"){
                major.options[0].text="软件工程";
                major.options[1].text="网络工程";
            }
            else {
                major.options[0].text="法语";
                major.options[1].text="日语";
            }
            return;
        }
    </script>
</head>
<body>
<form action="LoginServlet" method="post">
    用户名<input type="text" name="name"><br>
    密码<input type="text" name="pwd"><br>
    验证码<input type="text" name="s1">7777<br>
    所在学院<select name="sch" id="sch" onchange="fun1()">
    <option value="computer">计算机学院</option>>
    <option value="language">外国语学院</option>
</select><br>
    所在系<select name="major" id="major">
    <option>软件工程</option>
    <option>网络工程</option>
</select><br>
    <button type="submit" >登录</button>
</form>
</body>
</html>
