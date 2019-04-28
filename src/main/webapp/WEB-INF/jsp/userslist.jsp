<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/25
  Time: 11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="UTF-8">
    <title>用户列表</title>
    <link rel="stylesheet" href="/css/bootstrap-3.3.4.css">

    <!--<script type="text/javascript" src="js/bootstrap.min.3.3.7.js" ></script>
    <link rel="stylesheet" href="css/bootstrap.min.3.3.7.css" />-->
    <%--<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>
    <%--<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">--%>
</head>

<body>
<div class="container">
    <table class="table">
        <tr>
            <td>ID</td>
            <td>用户</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${userPageInfo.list}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td><button class="btn btn-warning" data-toggle="modal" onclick="updateMsg(${user.id})">修改</button>
                <button class="btn btn-danger" onclick="delUser()">删除</button></td>
        </tr>
        </c:forEach>

    </table>
</div>
<div id="myModal" class="modal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header text-center">
                <h4>角色修改</h4>
            </div>
            <div class="modal-body">
                <c:forEach items="${roles}" var="role">
                <div class="checkbox">
                    <label>
                        <input type="checkbox" id="${role.roleId}" value="${role.roleId}">${role.roleName}
                    </label>
                </div>
                </c:forEach>

            </div>
            <div class="modal-footer">
                <div hidden="hidden" class="userid"></div>
                <button type="button" class="btn btn-success" data-dismiss="modal" onclick="updateConf()">确认</button>
                <button type="button" class="btn btn-warning" data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div>

<!-- 分页的导航栏 -->
<center>
    <div class="pagination-layout">

        <div class="pagination">
            <ul class="pagination">

            </ul>


        </div>

        </centerdiv>


    </div>
</center>

<script src="/js/jquery-3.3.1.js"></script>
<script src="/js/bootstrap-3.3.4.js"></script>
<script src="/js/jqPaginator.js"></script>
<script>

    var uid = {};
    window.onload = function() {
        var if_fistime = true;
        $(".pagination")
            .jqPaginator(
                {
                    totalPages : ${userPageInfo.pages},
                    visiblePages : 3,
                    currentPage : ${userPageInfo.pageNum},
                    first : '<li class="first"><a href="javascript:void(0);">第一页</a></li>',
                    prev : '<li class="prev"><a href="javascript:void(0);">上一页</a></li>',
                    next : '<li class="next"><a href="javascript:void(0);">下一页</a></li>',
                    last : '<li class="last"><a href="javascript:void(0);">最后一页</a></li>',
                    page : '<li class="page"><a href="javascript:void(0);">{{page}}</a></li>',

                    onPageChange : function(num) {

                        /* alert(num); */
                        if (if_fistime) {
                            if_fistime = false;
                        } else {
                            changePage(num);
                        }

                    }

                })

    }

    function changePage(num) {

        window.location.href = "showUser?pageNum=" + num;
    }

    function updateMsg(userId) {
        uid = userId;
        $.ajax({
            url:'/login/queryRole?userId='+userId,
            type:'get',

            async:true,
            success:function (result) {
//                console.log(result.status);
//                console.log(result.object);

                if (result.status == 200) {
                    $.each($("input:checkbox"), function (i, obj) {

                        obj.checked = false;
//                        console.log(obj.value);
//                        console.log();
                        var roleJson = JSON.stringify(result.object);
                        var roleObj =JSON.parse(roleJson);
                        for(var i=0;i<roleObj.length;i++){
//                            console.log(roleObj[i].roleId+"asdadasd");  //取json中的值
                            if (roleObj[i].roleId == obj.value) {
                                obj.checked = true;
                            }
                        }
                });
            }
                $("#myModal").modal('show');
            },
            error:function () {
                alert("访问失败");
            }
        })


    }


    function updateConf() {
        var $inputNode = $("input");

        var data = {};
        data.uid = uid;
         data.rid = [];
        $.each($inputNode, function (i, index) {
            if (index.checked == true) {
                console.log(index.value);
                data.rid.push(index.value);

            }
        });
        console.log(data);

        $.ajax({
            url: "/login/test",
            dataType: "json",
            type: "post",
            data: data,//使用这种数组方式的，得加下一句才可以，使用传统方式
            success: function (data) {
                for (var i = 0; i < data.length; i++) {
                    console.log(data[i]);
                }
            }
        })


    }

    function delUser() {

        location.href = "/login/deleteUser?uid=" + uid;

    }







</script>


</body>

</html>