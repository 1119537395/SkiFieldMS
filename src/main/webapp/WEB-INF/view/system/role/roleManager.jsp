<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<title>角色管理页面</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta http-equiv="Access-Control-Allow-Origin" content="*">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="${Path}/static/layui/css/layui.css" media="all" />
    <link rel="stylesheet" href="${Path}/static/css/public.css" media="all" />
    <link rel="stylesheet" href="${Path}/static/layui_ext/dtree/dtree.css">
    <link rel="stylesheet" href="${Path}/static/layui_ext/dtree/font/dtreefont.css">
</head>
<body style="margin: 10px">

    <!-- 搜索条件开始 -->
    <blockquote class="layui-elem-quote">
        <i class="layui-icon layui-blue">&#xe615;</i>
        查询条件
    </blockquote>

    <form class="layui-form layui-form-pane" method="post" id="searchFrom">
        <div class="layui-form-item">

            <div class="layui-inline">
              <label class="layui-form-label">角色名称</label>
              <div class="layui-input-inline">
                  <input type="text"  name="roleName" autocomplete="off" class="layui-input" placeholder="请输入查询名称">
              </div>
            </div>

            <div class="layui-inline">
                <div class="layui-input-label">
                  <button type="button" class="layui-btn layui-icon layui-icon-search" id="doSearch">&nbsp;查询</button>
                  <button type="reset" class="layui-btn layui-icon layui-btn-danger layui-icon-refresh">&nbsp;重置</button>
                </div>
            </div>
        </div>
    </form>
    <!-- 搜索条件结束 -->

    <!--表单内嵌效果展示开始-->
    <script type="text/html" id="checkboxTpl">
        <input type="checkbox" name="lock" value="{{d.available}}" title="可用" {{ d.available==1?'checked':''}}>
    </script>
    <!--表单内嵌效果展示结束-->

    <!-- 数据表格开始 -->
    <table class="layui-hide" id="roleTable" lay-filter="roleTable"></table>

    <!-- 数据表格上方工具栏按钮 -->
    <script type="text/html" id="toolbarDemo">
     <div class="layui-btn-containe">
        <button class="layui-btn layui-btn-sm layui-btn-normal" lay-event="addRoleDataBtn">添加角色</button>
    </div>
    </script>

    <!-- 数据表格内部操作按钮 -->
    <script type="text/html" id="barDemo">
        <a class="layui-btn layui-btn-xs" lay-event="edit">修改</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="delete">删除</a>
        <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="assign">分配菜单</a>
    </script>

    <!-- 数据表格结束 -->

    <!-- 添加和修改的弹出层开始 -->
        <div style="display: none"  id="addAndEditModel" >

            <form class="layui-form layui-form-pane" action="" lay-filter="addRoleFrame" id="addRoleFrame" style="margin: 20px">
                <blockquote class="layui-elem-quote">
                <i class="layui-icon layui-blue">&#xe609;</i>
                角色管理
                </blockquote>

                <div class="layui-form-item" pane="">
                    <label class="layui-form-label">功能状态</label>
                    <div class="layui-input-block">
                        <select name="available">
                            <option value="">请选择角色的功能状态</option>
                            <option value="1">可用状态</option>
                            <option value="0">禁止状态</option>
                        </select>
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">角色名称</label>
                    <div class="layui-input-block">
                    <input type="text" name="roleId" id="roleid" style="display: none">
                    <input type="text" name="roleName"  lay-verify="required" autocomplete="off" placeholder="请输入角色名称" class="layui-input">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">权限描述</label>
                    <div class="layui-input-block">
                    <input type="text" name="roleDesc" id="roledesc" lay-verify="required" autocomplete="off" placeholder="请输入该角色名称的功能描述" class="layui-input">
                    </div>
                </div>

                <div class="layui-form-item" align="center">
                    <div class="layui-input-label">
                    <button type="button" class="layui-btn layui-icon layui-icon-ok-circle" lay-submit="" lay-filter="doAddSubmit" id="doAddSubmit">&nbsp;提交</button>
                    <button type="reset" class="layui-btn layui-icon layui-btn-danger layui-icon-refresh">&nbsp;重置</button>
                    </div>
                </div>
            </form>
        </div>
    <!-- 添加和修改的弹出层结束 -->

    <!-- 分配菜单权限弹出层开始 -->
        <div style="display: none" id="assignMenuModel">
            <div style="margin: 10px">
                <blockquote class="layui-elem-quote">
                    <i class="layui-icon layui-blue">&#xe609;</i>
                    分配权限
                </blockquote>

                <ul id="menuTree" class="dtree" data-id="0"></ul>
            </div>
        </div>
    <!-- 分配菜单权限弹出层结束 -->

<script src="${Path}/static/layui/layui.js" charset="utf-8"></script>
<script>
    var tableIns;
    layui.extend({
    dtree:'${Path}/static/layui_ext/dist/dtree'
    }).use(['table','layer','form','jquery','laydate','dtree'], function(){
    var  $      = layui.jquery;
    var table   = layui.table;
    var layer   = layui.layer;
    var form    = layui.form;
    var laydate = layui.laydate;
    var dtree   = layui.dtree;


    // 渲染表格数据
    tableIns = table.render({
    elem: '#roleTable'
    ,url:'${Path}/role/loadRoleInfo'
    ,toolbar: '#toolbarDemo'
    ,height:'full-145'
    ,cellMinWidth:100
    ,page:true
    ,text:{
    none:"暂无相关数据"
    }
    ,title: '菜单数据表'
    ,cols: [[
    {type: 'checkbox', fixed: 'left'}
    ,{field:'roleId', title:'角色编号',fixed: 'left', width:220, unresize: true, sort: true,align:"center"}
    ,{field:'roleName', title:'角色名称',width:220,align:"center"}
    ,{field:'roleDesc', title:'权限描述',width:380,align:"center"}
    ,{field:'available', title:'功能状态',width:220,align:"center",templet: '#checkboxTpl'}
    ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:220,align:"center"}
    ]]
    });

    // 给查询按钮添加单击事件
    $("#doSearch").click(function() {
        //获取表单提交的数据序列
        var parameter = $("#searchFrom").serialize();
        tableIns.reload({
            url:"${Path}/role/loadRoleInfo?"+parameter,
            page:{curr:1}
        });
    });

    //监听头工具栏添加按钮和删除按钮事件
    table.on('toolbar(roleTable)', function(obj){
        switch(obj.event){
            case 'addRoleDataBtn':
                OpenAddMenuModel();
                break;
            case 'deleteRoleDataBtn':
                deleteBatchData(obj);
        };
    });
    
    //监听行工具删除和修改和分配按钮事件
    table.on('tool(roleTable)', function(obj){
        var data = obj.data;  //获取到单击行的数据
        if(obj.event === 'delete') {
          layer.confirm('确定删除【'+data.roleName+'】的角色信息吗？',{icon:3,title:"提示",skin:'layui-layer-molv',btnAlign:'c'}, function(){
              $.post("${Path}/role/deleteRoleData?",{roleId:data.roleId},function (returnValue) {
                  if (returnValue.code == 200) {
                      layer.msg(returnValue.msg,{
                          icon:6
                      });
                      //刷新表格
                      tableIns.reload();
                  }else {
                      layer.msg(returnValue.msg,{
                          icon:5
                      });
                  }
              });
          });
        }else if(obj.event === 'edit'){
            OpenUpdateModel(data);
        }else if(obj.event === 'assign'){
            openAssignModel(data);
        }
    });


    //打开角色分配菜单权限的模态框
    function openAssignModel(data) {
        var menuTree;
        maxIndex =layer.open({
            type:1,
            title:"分配菜单权限",
            content:$('#assignMenuModel'),
            area:["620px","500px"],
            anim:4,
            skin:"layui-layer-lan",
            closeBtn:2,
            btnAlign: 'c',
            btn: ["确认", "取消"],
            yes: function(index, layero){
                // 获取选中节点的数据
                var nodes = dtree.getCheckbarNodesParam("menuTree");
                var params = "roleId="+(data.roleId);

                $.each(nodes,function (i,item) {
                   params += "&ids="+item.nodeId;
                });

                $.post("${Path}/role/assignMenuToRole",params,function (returnValue) {
                    if (returnValue.code == 200){
                        layer.msg(data.roleName+"的权限菜单"+returnValue.msg,{
                            icon:6
                        });
                        //关闭弹出层窗口
                        layer.close(maxIndex);
                    } else {
                        layer.msg(data.roleName+"的权限菜单"+returnValue.msg,{
                            icon:5,
                            anim:6
                        });
                    }
                });


            },
            success:function (index) {
                // 初始化树
                menuTree = dtree.render({
                    elem: "#menuTree",
                    dataStyle: "layuiStyle",
                    response:{message:"msg",statusCode:0},
                    dataFormat: "list",
                    checkbar:true,
                    checkbarType:"all",
                    checkbarData:"choose",
                    url:"${Path}/role/initMenuAssignTree?roleId="+data.roleId
                });
            }
        });
    }


    //打开添加角色信息模态框
    var maxIndex;
    var url;
    function OpenAddMenuModel(){
        maxIndex =layer.open({
        type:1,
        title:"添加角色信息",
        content:$('#addAndEditModel'),
        area:["700px","380px"],
        anim:4,
        skin:"layui-layer-molv",
        closeBtn:2,
        success:function (index) {
        //清空表单
        $("#addRoleFrame")[0].reset();
        url ="${Path}/role/addRoleData";
        }
        });
    }

    //打开修改角色信息模态框
    function OpenUpdateModel(data) {
        maxIndex =layer.open({
        type:1,
        title:"修改角色信息",
        content:$('#addAndEditModel'),
        area:["700px","380px"],
        anim:1,                 //动画效果
        skin:"layui-layer-molv", //皮肤
        closeBtn:2,
        success:function (index) {
        //给表单复制
        form.val("addRoleFrame",data);
        $("#roleid").val(data.roleId);
        url = "${Path}/role/updateRoleData";
        }
        });
    }

    //保存添加或修改的菜单数据
    form.on('submit(doAddSubmit)',function(data){
        //序列化表单数据
        var params = $("#addRoleFrame").serialize();
        $.post(url,params,function(obj) {
        //弹出成功或失败的提示信息
        layer.msg(obj.msg,{
            icon:6
        });
        //关闭弹出层
        layer.close(maxIndex);
        //刷新表格
        tableIns.reload();
        });
    });

});



</script>

</body>
</html>