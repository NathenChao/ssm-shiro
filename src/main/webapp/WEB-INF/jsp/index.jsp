<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Bruce陈
  Date: 2019/4/19
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--游客访问--%>
<shiro:guest>
  <button >查询学生</button>
</shiro:guest>

<%--<shiro:user>--%>
    <%--<button>增加</button>--%>
<%--</shiro:user>--%>

<%--通过认证的--%>
<%--<shiro:authenticated>--%>

    <%--<button >删除学生</button>--%>
    <%--<button >增加学生</button>--%>
<%--</shiro:authenticated>--%>

<%--<shiro:hasPermission name="operation:add">--%>
    <%--<button >asdasd</button>--%>
<%--</shiro:hasPermission>--%>

<shiro:hasRole name="admin">
    <button onclick="showUser()">用户管理</button>

    <button onclick="showRole()">角色列表</button>
    <button>修改学生</button>
</shiro:hasRole>


<script>
    function showUser() {

        location.href = "/login/showUser";

    }

    function showRole() {

        location.href = "/showRoles";

    }


</script>

</body>
</html>
