<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 2019/4/26
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>角色列表</title>
    <script src="/js/jquery-3.3.1.js"></script>
    <script src="/js/bootstrap-3.3.4.js"></script>
    <script src="/js/jqPaginator.js"></script>
    <script src="/js/jquery.ztree.all.js"></script>
    <link rel="stylesheet" href="/css/zTreeStyle/zTreeStyle.css">
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <table class="table">
        <tr>
            <td>ID</td>
            <td>角色</td>
            <td>操作</td>
        </tr>

        <c:forEach items="${rolePageInfo.list}" var="role">
            <tr>
                <td>${role.roleId}</td>
                <td>${role.roleName}</td>
                <td><button class="btn btn-warning" data-toggle="modal" data-target="#myModal" onclick="updatePer(${role.roleId})">修改</button>
                    <button class="btn btn-danger">删除</button>
                </td>
            </tr>
        </c:forEach>

    </table>

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


</div>
<div id="myModal" class="modal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header text-center">
                <h4>权限修改</h4>
            </div>
            <div class="modal-body">
                <div>
                    <ul id="treeDemo" class="ztree"></ul>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-success" data-dismiss="modal">确认</button>
                <button type="button" class="btn btn-warning" data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>


</div>
<script>
    window.onload = function() {
        var if_fistime = true;
        $(".pagination")
            .jqPaginator(
                {
                    totalPages : ${rolePageInfo.pages},
                    visiblePages : 3,
                    currentPage : ${rolePageInfo.pageNum},
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

        window.location.href = "showRoles?pageNum=" + num;
    }


    function updatePer(obj) {

        var rid = obj;
        console.log(obj);

        var setting = {
            treeNodeKey: "id",               //在isSimpleData格式下，当前节点id属性    
            treeNodeParentKey: "pId",        //在isSimpleData格式下，当前节点的父节点id属性    
            showLine: true,                  //是否显示节点间的连线    
            check: {
                enable: true,   //true / false 分别表示 显示 / 不显示 复选框或单选框
                autoCheckTrigger: true,   //true / false 分别表示 触发 / 不触发 事件回调函数
                chkStyle: "checkbox",   //勾选框类型(checkbox 或 radio）
                chkboxType: { "Y": "ps", "N": "ps" }   //勾选 checkbox 对于父子节点的关联关系
            },                //每个节点上是否显示 CheckBox    
            data: {
                simpleData: {
                    enable: true
                }
            }
        };
        var nodes =[];

        $.ajax({

            type: 'post',
            url: '/showPermission?rid='+rid,
            sync: true,
            dataType:'json',
            success: function (json) {

                console.log(json.allPermissions);
                $.each(json.allPermissions,function (i, index) {
//                    console.log(index)
                    nodes.push(index);
                })

                var $ul=$("#treeDemo");
                $.fn.zTree.init($ul, setting, nodes);
                var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
//                console.log(treeObj);
                $.each(json.permissionByRid,function (e, ele) {
                    console.log(ele+"eeeeeeeeee");
                    var nodes = treeObj.getNodesByParam("id", ele, null);
                    treeObj.checkNode(nodes[0], true, true);
                })

           },error:function () {
                alert("访问失败");
            }


        })


//        console.log(nodes);
    }





</script>

</body>
</html>