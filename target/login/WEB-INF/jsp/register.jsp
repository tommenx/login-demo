<%--
  Created by IntelliJ IDEA.
  User: tommenx
  Date: 2020/2/12
  Time: 11:28 上午
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
    <title>注册</title>
</head>
<body>
<div class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <a href="/index.html" class="navbar-brand"></a>
        </div>
    </div>
</div>
<div class="container container-small">
    <div class="alert alert-danger" role="alert">该手机号已被注册</div>
    <h1>注册</h1>
    <form id="signupInfo">
        <div class="form-group">
            <label>手机</label>
            <input type="text" name="phonenum" class="form-control">
        </div>
        <div class="form-group">
            <label>昵称</label>
            <input type="text" class="form-control" name="username">
        </div>

        <div class="form-group">
            <label>密码</label>
            <input id="password" type="password" class="form-control" name="password">
        </div>
        <div class="form-group">
            <label>重复输入密码</label>
            <input id = "repassword" type="password" class="form-control" name="repassword">
            <label id="diffPwd" style="color: #c9302c;display:none">密码不一致</label>
        </div>
    </form>
    <div class="form-group">
        <button class="btn btn-primary btn-block" id="submitInfo">注册</button>
    </div>
    <div class="form-group">
        注册VDSK即代表您同意
        <a href="#">VDSK服务条款</a>
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

    $('#repassword').focus(function () {
        $('#diffPwd').css('display','none');
    });
    $('.alert').hide();
    $('#submitInfo').click(function () {
        var params = $('#signupInfo').serializeArray();
        if(params[2].value != params[3].value) {
            // $('#signupInfo')[0].reset();
            $('#repassword').val("");
            $('#diffPwd').css('display', 'inline');
        }
        else{
            $.ajax({
                type:'POST',
                url:'user/register',
                data:{
                    phone:params[0].value,
                    username:params[1].value,
                    password:params[2].value
                },
                dataType:'json',
                success:function (data) {
                    if(data.code == 0){
                        $('.alert').show();
                    }else {
                        window.location.href = "login";
                    }
                }
            })
        }
    })
</script>
