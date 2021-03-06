<%--
  Created by IntelliJ IDEA.
  User: tommenx
  Date: 2020/2/12
  Time: 2:00 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/font-awesome.min.css"/>
    <link rel="stylesheet" href="css/main.css">
    <title>登录</title>
</head>
<body>
<div class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <a href="#" class="navbar-brand"></a>
        </div>
    </div>
</div>
<div class="container container-small">
    <div class="alert alert-danger" role="alert">密码错误</div>
    <h1>登录
        <small>没有账号？<a href="/login/register">注册</a></small>
    </h1>
    <form id="loginInfo">
        <div class="form-group">
            <label>手机</label>
            <input name="phone" type="text" class="form-control">
        </div>
        <div class="form-group">
            <label>密码</label>
            <input name="password" type="password" class="form-control">
        </div>
    </form>
    <div class="form-group">
        <button id="login" class="btn btn-primary btn-block" type="submit">登录</button>
    </div>
</div>
<div class="footer">
    © 2017 VDSK. All Rights Reserved
</div>
</body>
</html>

<script src="javascripts/jquery-3.3.1.min.js"></script>
<script src="javascripts/bootstrap.min.js"></script>
<script>
    $('.alert').hide();
    $('#login').click(function () {
        var params = $('#loginInfo').serializeArray();
        $.ajax({
            type:'POST',
            url:'user/login',
            dataType:'json',
            data:{
                phone:params[0].value,
                password:params[1].value
            },
            success:function (res) {
                if(res.code == 0){
                    $('.alert').text('账号不存在');
                    $('.alert').show();
                }else if (res.code == 2){
                    $('.alert').text('密码错误');
                    $('.alert').show();
                }else if (res.code == 1){
                    window.location.href = "index";
                }
            }
        })
    });


</script>
