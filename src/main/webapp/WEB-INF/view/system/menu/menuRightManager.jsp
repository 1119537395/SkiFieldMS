<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<title>菜单管理页面</title>
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
        <i class="layui-icon layui-red">&#xe615;</i>
        查询条件
    </blockquote>
    <form class="layui-form layui-form-pane" method="post" id="searchFrom">

        <div class="layui-form-item">
            <div class="layui-form-item">
            <div class="layui-inline">
              <label class="layui-form-label">菜单名称：</label>
              <div class="layui-input-inline">
                  <input type="text" id="menuNameId" name="title" autocomplete="off" class="layui-input" placeholder="请输入菜单名称">
              </div>
            </div>
            <div class="layui-inline">
                <div class="layui-input-label">
                  <button type="button" class="layui-btn layui-icon layui-btn-normal layui-icon-search" id="doSearch">&nbsp;查询</button>
                  <button type="reset" class="layui-btn layui-icon layui-btn-danger layui-icon-refresh">&nbsp;重置</button>
                </div>
            </div>
            </div>
        </div>

    </form>
    <!-- 搜索条件结束 -->

    <!--表单内嵌效果展示开始-->
    <script type="text/html" id="checkboxTpl">
        <input type="checkbox" name="lock" value="{{d.available}}" title="可用"  {{ d.available==1?"checked":''}}>
    </script>
    <script type="text/html" id="switchTpl">
        <input type="checkbox" name="Unfold" value="{{d.spread}}" lay-skin="switch" lay-text="是|否" {{ d.spread==1?'checked':''}}>
    </script>
    <!--表单内嵌效果展示结束-->

    <!-- 数据表格开始 -->
    <table class="layui-hide" id="personTable" lay-filter="personTable"></table>
    <script type="text/html" id="toolbarDemo">
     <div class="layui-btn-containe">
        <button class="layui-btn layui-btn-normal layui-btn-sm" lay-event="addMenuDataBtn">添加</button>
    </div>
    </script>
    <script type="text/html" id="barDemo">
        <a class="layui-btn layui-btn-xs" lay-event="edit">修改</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="delete">删除</a>
    </script>
    <!-- 数据表格结束 -->

    <!-- 添加和修改的弹出层开始 -->
        <div style="display: none"  id="addMenuModel" >

            <form class="layui-form layui-form-pane" action="" lay-filter="addMenuFrame" id="addMenuFrame" style="margin: 20px">
                <blockquote class="layui-elem-quote">
                <i class="layui-icon layui-red">&#xe609;</i>
                    添加新的菜单
                </blockquote>

                <div class="layui-form-item">
                <label class="layui-form-label">父级菜单</label>
                    <div class="layui-input-block">
                        <input type="text" name="id" id="id" style="display:none;">
                        <input type="text" name="pid" id="pid" style="display:none;">
                        <ul id="menuTree" class="dtree" data-id="0" ></ul>
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">菜单名称</label>
                    <div class="layui-input-block">
                    <input type="text" name="title"  lay-verify="required" autocomplete="off" placeholder="请输入菜单名称" class="layui-input">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">菜单地址</label>
                    <div class="layui-input-block">
                    <input type="text" name="href" id="hrefId" autocomplete="off" placeholder="请输入菜单地址" class="layui-input">
                    </div>
                </div>

                <div class="layui-form-item" pane="">
                    <label class="layui-form-label">菜单状态</label>
                    <div class="layui-input-block">
                        <input type="radio" name="spread" value="1" title="展开" >
                        <input type="radio" name="spread" value="0" title="不展开" checked="">
                    </div>
                </div>

                <div class="layui-form-item" pane="">
                    <label class="layui-form-label">菜单属性</label>
                    <div class="layui-input-block">
                        <input type="radio" name="available" value="1" title="可用" checked="">
                        <input type="radio" name="available" value="0" title="不可用"/>
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">TARGET</label>
                    <div class="layui-input-block">
                    <input type="text" name="target" autocomplete="off" placeholder="默认为空" class="layui-input">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">菜单图标</label>
                    <div class="layui-input-block">
                    <input type="text" name="icon"  lay-verify="required" autocomplete="off" placeholder="请输入菜单图标" class="layui-input">
                    </div>
                </div>

                <div class="layui-form-item" align="center">
                    <div class="layui-input-label">
                    <button type="button" class="layui-btn layui-icon layui-btn-normal layui-icon-ok-circle  layui-btn-radius" lay-submit="" lay-filter="doAddSubmit" id="doAddSubmit">&nbsp;提交</button>
                    <button type="reset" class="layui-btn layui-icon layui-btn-danger layui-icon-refresh   layui-btn-radius">&nbsp;重置</button>
                    </div>
                </div>
            </form>
        </div>
    <!-- 添加和修改的弹出层结束 -->

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
    elem: '#personTable'
    ,url:'${Path}/menu/loadMenuTableInfo'
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
    ,{field:'id', title:'菜单编号',fixed: 'left', width:110, unresize: true, sort: true,align:"center"}
    ,{field:'pid', title:'父级节点',width:90,align:"center"}
    ,{field:'title', title:'菜单名称',width:160,align:"center"}
    ,{field:'href', title:'菜单地址',align:"center"}
    ,{field:'spread', title:'是否展开',align:"center",templet:'#switchTpl', unresize: true}
    ,{field:'target', title:'TARGET',align:"center"}
    ,{field:'icon', title:'菜单图标',align:"center",width:90,templet:function(d){
        return "<div class='layui-icon'>"+d.icon+"</div>";
    }}
    ,{field:'available', title:'是否可用',align:"center",templet: '#checkboxTpl',unresize: true}
    ,{fixed: 'right', title:'操作', toolbar: '#barDemo', width:150}
    ]]
    });

    //给查询按钮添加单击事件
    $("#doSearch").click(function() {
        //获取表单提交的数据序列
        var parameter = $("#searchFrom").serialize();
        tableIns.reload({
            url:"${Path}/menu/loadMenuTableInfo?"+parameter,
            page:{curr:1}
        });
    });

    $("#hrefId").focus(function() {
        var that = this;
        layer.tips('输入的路由地址格式必须正确',that, {
        tips: [1, '#0FA6D8']
            });
    });

    //监听头工具栏添加按钮和删除按钮事件
    table.on('toolbar(personTable)', function(obj){
        switch(obj.event){
            case 'addMenuDataBtn':
                OpenAddMenuModel();
                break;
        };
    });
    
    //监听行工具删除和修改按钮事件
    table.on('tool(personTable)', function(obj){
        var data = obj.data;  //获取到单击行的数据
        if(obj.event === 'delete'){
        //查询要删除的菜单是否有子节点
        $.post("${Path}/menu/checkMenuHasChildren?id="+data.id,function(result) {
            if (result.code != 200){
                layer.msg("请先删除该菜单下的子节点再进行操作呀!",{
                    icon:5,
                    anim:6
                });
            }else {
                layer.confirm('你确定删除【'+data.title+'】菜单吗?', {icon:3,title:"提示",skin:'layui-layer-molv',btnAlign:'c'}, function(){
                    $.post("${Path}/menu/deleteMenuData?id="+data.id,function(index) {
                    //删除成功提示
                    layer.msg(index.msg,{
                    icon:6
                    });
                    //刷新表格
                    tableIns.reload();
                    //刷新左边的树
                    window.parent.left.menuTree.reload();
                    //刷新下拉列表的树
                    menuTree.reload();
                        });
                  });
            }
        });
    }else if(obj.event === 'edit'){
        OpenUpdateModel(data);
    }
    });


    //打开添加菜单模态框
    var maxIndex;
    var url;
    function OpenAddMenuModel(){
        maxIndex =layer.open({
        type:1,
        title:"添加菜单",
        content:$('#addMenuModel'),
        area:["700px","560px"],
        anim:5,
        skin:"layui-layer-lan",
        closeBtn:2,
        success:function (index) {
        //清空表单
        $("#addMenuFrame")[0].reset();
        url ="${Path}/menu/addMenuData";
        }
        });
    }

    //打开修改模态框
    function OpenUpdateModel(data) {
        maxIndex =layer.open({
        type:1,
        title:"修改菜单",
        content:$('#addMenuModel'),
        area:["700px","560px"],
        anim:1,                 //动画效果
        skin:"layui-layer-lan", //皮肤
        closeBtn:2,
        success:function (index) {
        form.val("addMenuFrame",data);
        //给父级菜单下拉框属性赋值
        dtree.dataInit("menuTree", data.pid);
        dtree.selectVal("menuTree");
        $("#id").val(data.id);
        url = "${Path}/menu/updateMenuData";
        }
        });
    }

    //保存添加或修改的菜单数据
    form.on('submit(doAddSubmit)',function(data){
        //序列化表单数据
        var params = $("#addMenuFrame").serialize();
        console.log(params);
        $.post(url,params,function(obj) {
        //弹出成功或失败的提示信息
        layer.msg(obj.msg);
        //关闭弹出层
        layer.close(maxIndex);
        //刷新表格
        tableIns.reload();
        //刷新左边的树
        window.parent.left.menuTree.reload();
        //刷新下拉列表的树
        menuTree.reload();
        });
    });

    //初始化添加模块的下拉树
    var menuTree = dtree.renderSelect({
        elem: "#menuTree",
        width: "100%", // 指定树的宽度
        dataStyle: "layuiStyle",  //使用layui风格的数据格式
        response:{message:"msg",statusCode:0},  //修改response中返回数据的定义
        dataFormat: "list",  //配置data的风格为list
        url: "${Path}/menu/loadLeftMenuTreeJson?spread=1",
        icon: "2",
        accordion:true,
        selectTips: "请选择添加的父级菜单"
    });
    dtree.on("node(menuTree)", function(obj){
        $("#pid").val(obj.param.nodeId);
    });

});

    //左侧菜单树点击节点查询事件
    function reloadMenu(id){
    tableIns.reload({
        url:"${Path}/menu/loadMenuTableInfo?id="+id
    });
    }

</script>

</body>
</html>