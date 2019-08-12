<%--
  Created by IntelliJ IDEA.
  User: TurboNeo
  Date: 2019/8/6
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>睿乐购后台管理系统1.0</title>
    <link rel="stylesheet" href="../css/denglu.css">
</head>
<body>
<div id="wk">
    <div id="continue">
        <form action="/manage/user/login.do" id="con-form">
            <h1 style="color: black;font-size: 40px">睿乐购后台管理系统
            </h1>
            <input type="text" name="username" placeholder="输入账户" id="inp">
            <br>
            <input type="password" name="password" placeholder="输入密码" id="inp2">
            <br>
            <input type="button" value="登陆" id="cf-s">
            <p>&nbsp;</p>
            <div id="nrhz"></div>
            <div style="text-align:center;height: 40px">
                <h6 style="color:black;">Copyright(C)2019 www.com All Rights Reserved<br/>
                    张鑫粉丝后援会 版权所有 津IP备6666666号</h6>
            </div>
        </form>
    </div>
</div>
</body>
<script src="<%=request.getContextPath()%>/jq/jquery-3.3.1.js">
</script>
<script>
    $("#cf-s").click(function(){
        var un=$("#inp").val();
        var pd=$("#inp2").val();
        $.post(
            "/manage/user/login.do",
            {username:un,password:pd},
            function (dt) {
                if (dt.status!==100){
                    $("#nrhz").empty();
                    $("#nrhz").append("<p>"+dt.mag+"</p>");
                }else {
                    window.open("guanlijiemian.jsp");
                }
            })
    })
</script>
</html>
