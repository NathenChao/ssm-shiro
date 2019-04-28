<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <jsp:include page="/WEB-INF/jsp/common.jsp"></jsp:include>
    <title>用户登陆</title>
    <link rel="stylesheet"
          href="/css/login.css"/>
    <style>
    </style>
</head>
<body>
<div class="form_login">
    <div class="form_logo">
        <h1>权限管理系统</h1>
    </div>
    <form method="post" id="formlogin" >
        <input type="hidden" name="id" value="0">
        <div class="form-group">
            <i class="fa fa-user"></i> <input type="text" class="form-control"
                                              name="username" id="username" placeholder="输入工号">
        </div>
        <div class="form-group">
            <i class="fa fa-key"></i> <input type="password"
                                             class="form-control" name="password" id="password"
                                             placeholder="输入密码">
        </div>
        <input type="hidden" name="salt" value="0">
        <!--  <div class="form-group" style="height:25px; line-height:25px; text-align:left;">
        <input type="checkbox" name="checkbox" id="checkbox">
        <span class="checkfont">记住我的帐号</span>
    </div> -->
        <div class="form-group">
            <div> </div>
            <div> </div>
            <div> </div>
            <button type="button" id="loginsubmit"
                    class="btn-sm btn-primary btn-login" onclick="mylogin()">登录
            </button>
            <button type="button" id="registerSubmit"
                    class="btn-sm btn-primary btn-login" onclick="myRegister()">注册
            </button>
        </div>
    </form>
    <div class="form_footer">
        <%--<h4>@2019 江苏万和系统工程有限公司</h4>--%>
    </div>
</div>
</body>
<script type="text/javascript">
  /* function mylogin() {
        var employeeId = $("#employeeId").val();
        var password = $("#password").val();
        if ("" == employeeId || undefined == employeeId) {
            alert("工号不能为空");
            return;
        }
        if ("" == password || undefined == password) {
            alert("密码不能为空");
            return;
        }

        var data = {};
        data.employeeId = employeeId;
        data.password = password;
        $.ajax({
            type: 'post',
            url: 'LoginServlet?method=loginCheck',
            data: data,
            cache: false,
            sync: true,
            success: function (msg) {
                var json = JSON.parse(msg);
                if (0 == json.status) {
                    alert("工号或密码错误");
                } else {
                    //alert("1");
                    $("#formlogin").submit();
                }
            },
            error: function () {
                alert("请求失败!");
            }
        });
    }*/



   function myRegister() {

       $("#formlogin").attr("action", "/login/addUser").submit();

   }

  function mylogin() {

      $("#formlogin").attr("action", "/login/login").submit();

  }
</script>
</html>
