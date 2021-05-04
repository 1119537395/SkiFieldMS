<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <title>游客管理页面</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta http-equiv="Access-Control-Allow-Origin" content="*">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="${Path}/static/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="${Path}/static/css/public.css" media="all"/>
</head>
<body style="margin: 10px">

<!-- 搜索条件开始 -->
<blockquote class="layui-elem-quote">
    <i class="layui-icon layui-purple">&#xe615;</i>
    查询条件
</blockquote>
<form class="layui-form layui-form-pane" method="post" id="searchFrom">

    <div class="layui-form-item">

        <div class="layui-inline">
            <label class="layui-form-label">账号</label>
            <div class="layui-input-inline">
                <input type="text" name="touristLoginAccount" autocomplete="off" class="layui-input"
                       placeholder="请输入游客账号">
            </div>
        </div>

        <div class="layui-inline">
            <label class="layui-form-label">手机号</label>
            <div class="layui-input-inline">
                <input type="text" name="touristPhone" autocomplete="off" class="layui-input" placeholder="请输入手机号码">
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


<!-- 数据表格开始 -->
<table class="layui-hide" id="GeneralTable" lay-filter="GeneralTable"></table>

<!-- 数据表格上方工具栏按钮 -->
<script type="text/html" id="toolbarDemo">
    <div class="layui-btn-containe">
        <button class="layui-btn layui-btn-normal layui-btn-sm" lay-event="add">添加</button>
    </div>
</script>

<!-- 数据表格内部操作按钮 -->
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">修改</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="delete">注销</a>
</script>

<!--表单内嵌效果展示开始-->
<script type="text/html" id="checkboxTpl">
    <input type="checkbox" name="available" value="{{d.available}}" title="可用" {{ d.available==1?'checked':''}}>
</script>

<!-- 数据表格结束 -->


<!-- 添加和修改的弹出层开始 -->
<div style="display: none" id="addAndEditModel">

    <form class="layui-form layui-form-pane" action="" lay-filter="DataForm" id="DataForm" style="margin: 20px">
        <blockquote class="layui-elem-quote">
            <i class="layui-icon layui-blue">&#xe609;</i>
            游客信息管理
        </blockquote>

        <div class="layui-form-item">
            <label class="layui-form-label">姓名</label>
            <div class="layui-input-block">
                <input type="text" name="touristName" autocomplete="off" class="layui-input" placeholder="请输入游客姓名">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">手机号</label>
            <div class="layui-input-block">
                <input type="text" name="touristPhone" id="touristPhone" autocomplete="off"
                       lay-verify="required|touristPhone|phone" class="layui-input" placeholder="请输入游客手机号">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-block">
                <select name="touristSex">
                    <option value="">请选择性别</option>
                    <option value="1">男</option>
                    <option value="0">女</option>
                </select>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">账号</label>
            <div class="layui-input-block">
                <input type="text" id="touristId" name="touristId" style="display: none">
                <input type="text" name="touristLoginAccount" id="touristLoginAccount" readonly="readonly"
                       autocomplete="off" class="layui-input" placeholder="请输入游客账号">
            </div>
        </div>

        <div class="layui-form-item" id="password">
            <label class="layui-form-label">密码</label>
            <div class="layui-input-block">
                <input type="password" name="touristLoginPassword" lay-verify="required" autocomplete="off"
                       class="layui-input" placeholder="请输入密码">
            </div>
        </div>

        <div class="layui-form-item" align="center">
            <div class="layui-input-label">
                <button type="button" class="layui-btn layui-icon layui-icon-ok-circle" lay-submit=""
                        lay-filter="doAddSubmit" id="doAddSubmit">&nbsp;提交
                </button>
                <button type="reset"
                        class="layui-btn layui-icon layui-btn-danger layui-icon-refresh">&nbsp;重置
                </button>
            </div>
        </div>
    </form>
</div>
<!-- 添加和修改的弹出层结束 -->


<script src="${Path}/static/layui/layui.js" charset="utf-8"></script>
<script>
    var tableIns;
    layui.use(['table', 'layer', 'form', 'jquery', 'laydate'], function () {
        var $ = layui.jquery;
        var table = layui.table;
        var layer = layui.layer;
        var form = layui.form;
        var laydate = layui.laydate;

        // 渲染表格数据
        tableIns = table.render({
            elem: '#GeneralTable'
            , url: '${Path}/tourist/loadTouristInfo'
            , toolbar: '#toolbarDemo'
            , height: 'full-190'
            , cellMinWidth: 100
            , page: true
            , text: {
                none: "暂无相关数据"
            }
            , title: '游客数据表'
            , cols: [[
                {type: 'checkbox', fixed: 'left'}
                , {field: 'touristId', title: 'ID', align: "center"}
                , {field: 'touristName', title: '姓名', align: "center"}
                , {
                    field: 'touristSex', title: '性别', align: "center", templet: function (sexData) {
                        return sexData.touristSex == '1' ? '<font color="#87cefa">男</font>' : '<font color="#ffc0cb">女</font>';
                    }
                }
                , {field: 'touristPhone', title: '手机号', align: "center"}
                , {field: 'touristLoginAccount', title: '登录账号', align: "center"}
                , {field: 'createTime', title: '创建时间',width: 200, align: "center"}
                , {
                    field: 'createUserName', title: '创建人', align: "center", templet: function (data) {
                        if (data.createUserName == null){
                            return '<font color="blue">用户注册</font>'
                        } else {
                            return '<font color="red">'+data.createUserName+'</font>'
                        }
                    }
                }
                , {fixed: 'right', title: '操作', toolbar: '#barDemo', width: 300, align: "center"}
            ]]
        });

        //给查询按钮添加单击事件
        $("#doSearch").click(function () {
            //获取表单提交的数据序列
            var parameter = $("#searchFrom").serialize();
            console.log(parameter);
            tableIns.reload({
                url: "${Path}/tourist/loadTouristInfo?" + parameter,
                page: {curr: 1}
            });
        });

        // 手机号输入框的改变事件
        $("#touristPhone").change(function () {
            $("#touristLoginAccount").val($(this).val());
        });

        //表单验证
        form.verify({
            touristPhone: function (value) {
                var touristId = $("#touristId").val();
                var formData = new FormData();
                formData.append("touristPhone", value);
                formData.append("touristId", touristId);
                var message = '';
                $.ajax({
                    url: "${Path}/tourist/checkTouristPhone",
                    type: 'POST',
                    data: formData,
                    async: false,
                    cache: false,
                    processData: false,
                    contentType: false,
                    dataType: "json",
                    success: function (data) {
                        if (data) {
                            message = "该手机号已经注册!";
                        }
                    }
                });
                if (message !== '') {
                    return message;
                }
            }
        });


        //监听头工具栏添加按钮和删除按钮事件
        table.on('toolbar(GeneralTable)', function (obj) {
            switch (obj.event) {
                case 'add':
                    addInfoModel();
            }
            ;
        });

        //监听行工具删除和修改按钮事件
        table.on('tool(GeneralTable)', function (obj) {
            var tableData = obj.data;  //获取到单击行的数据
            if (obj.event === 'delete') {
                layer.confirm('确定注销【' + tableData.touristName + '】该游客的信息吗？', {
                    icon: 3,
                    title: "提示",
                    skin: 'layui-layer-molv',
                    btnAlign: 'c'
                }, function () {
                    $.post("${Path}/tourist/deleteTouristInfo?", {touristId: tableData.touristId}, function (returnValue) {
                        if (returnValue.code === 200) {
                            layer.msg(returnValue.msg, {
                                icon: 6
                            });
                            //刷新表格
                            tableIns.reload();
                        } else {
                            layer.msg(returnValue.msg, {
                                icon: 5
                            });
                        }
                    });
                });
            } else if (obj.event === 'edit') {
                updateInfoModel(tableData);
            }
        });


        // 添加的模态框
        var maxIndex;
        var url;

        function addInfoModel() {
            maxIndex = layer.open({
                type: 1,
                title: "游客信息添加",
                content: $('#addAndEditModel'),
                area: ["700px", "470px"],
                anim: 5,
                skin: "layui-layer-molv",
                closeBtn: 2,
                success: function (index) {
                    $("#password").css("display", "block");
                    // 清空表单
                    $("#DataForm")[0].reset();
                    url = "${Path}/tourist/addTouristInfo";
                }
            });
        }

        // 修改的模态框
        function updateInfoModel(data) {
            maxIndex = layer.open({
                type: 1,
                title: "修改游客信息",
                content: $('#addAndEditModel'),
                area: ["700px", "470px"],
                anim: 5,
                skin: "layui-layer-molv",
                closeBtn: 2,
                success: function (index) {
                    $("#password").css("display", "none");
                    //给表单赋值
                    form.val("DataForm", data);
                    $("#touristId").val(data.touristId);
                    url = "${Path}/tourist/updateTouristInfo";
                }
            });
        }

        //保存添加或修改的用户数据
        form.on('submit(doAddSubmit)', function (data) {
            //序列化表单数据
            var params = $("#DataForm").serialize();

            $.post(url, params, function (obj) {
                //弹出成功或失败的提示信息
                layer.msg(obj.msg, {
                    icon: 6
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
