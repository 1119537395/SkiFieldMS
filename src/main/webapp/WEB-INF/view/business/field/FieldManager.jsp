<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <title>场次管理页面</title>
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
            <label class="layui-form-label">场次</label>
            <div class="layui-input-inline">
                <select name="fieldSession">
                    <option value="">请选择场次</option>
                    <option value="早场">早场</option>
                    <option value="日场">日场</option>
                    <option value="夜场">夜场</option>
                </select>
            </div>
        </div>

        <div class="layui-inline">
            <label class="layui-form-label">时段</label>
            <div class="layui-input-inline">
                <select name="fieldPeriod">
                    <option value="">请选择时段</option>
                    <option value="06:30~09:30">06:30~09:30</option>
                    <option value="09:00~18:00">09:00~18:00</option>
                    <option value="17:30~22:00">17:30~22:00</option>
                </select>
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
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="delete">删除</a>
</script>

<!--表单内嵌效果展示开始-->
<script type="text/html" id="switchTpl">
    <input type="checkbox" name="fieldState" value="{{d.fieldState}}" lay-filter="test11" lay-skin="switch"
           lay-text="开放|关闭"
           {{ d.fieldState==1?'checked':''}}>
</script>

<!-- 数据表格结束 -->


<!-- 添加和修改的弹出层开始 -->
<div style="display: none" id="addAndEditModel">

    <form class="layui-form " action="" lay-filter="DataForm" id="DataForm" style="margin: 10px">
        <blockquote class="layui-elem-quote">
            <i class="layui-icon layui-blue">&#xe609;</i>
            场次信息管理
        </blockquote>

        <div class="layui-form-item">
            <label class="layui-form-label">雪道名称</label>
            <div class="layui-input-block">
                <input type="text" name="fieldId" id="fieldId" style="display: none">
                <input type="text" name="fieldRoad" autocomplete="off" class="layui-input" placeholder="请输入雪道名称">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">雪道等级</label>
            <div class="layui-input-block">
                <select name="fieldGrade">
                    <option value="">请选择雪道等级</option>
                    <option value="练习道">练习道</option>
                    <option value="初级道">初级道</option>
                    <option value="中级道">中级道</option>
                    <option value="高级道">高级道</option>
                </select>
            </div>
        </div>


        <div class="layui-form-item">
            <label class="layui-form-label">场次时段</label>
            <div class="layui-input-block">
                <select name="fieldSession">
                    <option value="">请选择开放场次</option>
                    <option value="早场">早场</option>
                    <option value="日场">日场</option>
                    <option value="夜场">夜场</option>
                </select>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">开放时段</label>
            <div class="layui-input-block">
                <select name="fieldPeriod">
                    <option value="">请选择时段</option>
                    <option value="06:30~09:30">06:30~09:30</option>
                    <option value="09:00~18:00">09:00~18:00</option>
                    <option value="17:30~22:00">17:30~22:00</option>
                </select>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">场次状态</label>
            <div class="layui-input-block">
                <select name="fieldState">
                    <option value="">请选择状态</option>
                    <option value="0">隐藏</option>
                    <option value="1">显示</option>
                </select>
            </div>
        </div>



        <div class="layui-form-item magb2">

            <label class="layui-form-label">门票价格</label>
            <div class="layui-input-inline">
                <input type="text" name="fieldPrice" lay-verify="required" autocomplete="off" class="layui-input"
                       placeholder="请输入门票价格">
            </div>

            <label class="layui-form-label">容纳人数</label>
            <div class="layui-input-inline">
                <input type="text" name="fieldCapacity" lay-verify="required" autocomplete="off" class="layui-input"
                       placeholder="请输入容纳人数">
            </div>

        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">备注说明</label>
            <div class="layui-input-block">
                <textarea name="fieldInfo" placeholder="请输入场次说明信息" lay-verify="required" class="layui-textarea"></textarea>
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
            , url: '${Path}/field/loadFieldInfo'
            , toolbar: '#toolbarDemo'
            , height: 'full-140'
            , cellMinWidth: 100
            , page: true
            , text: {
                none: "暂无相关数据"
            }
            , title: '场次数据表'
            , cols: [[
                {type: 'checkbox', fixed: 'left'}
                , {field: 'fieldRoad', title: '雪道', align: "center"}
                , {field: 'fieldGrade', title: '等级', align: "center"}
                , {field: 'fieldSession', title: '场次', align: "center"}
                , {field: 'fieldPeriod', title: '时间段',width:130, align: "center"}
                , {field: 'fieldPrice', title: '门票价格', align: "center"}
                , {field: 'fieldCapacity', title: '票量', align: "center"}
                , {field: 'fieldInfo', title: '说明', align: "center"}
                , {field: 'fieldState', title: '状态', align: "center", templet: '#switchTpl'}
                , {field: 'createTime', title: '创建时间', width:180,align: "center"}
                , {field: 'createUserName', title: '创建人', align: "center"}
                , {fixed: 'right', title: '操作', toolbar: '#barDemo',width:160,align: "center"}
            ]]
        });

        //给查询按钮添加单击事件
        $("#doSearch").click(function () {
            //获取表单提交的数据序列
            var parameter = $("#searchFrom").serialize();
            console.log(parameter);
            tableIns.reload({
                url: "${Path}/field/loadFieldInfo?" + parameter,
                page: {curr: 1}
            });
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
                layer.confirm('确定删除【' + tableData.fieldRoad + '】场次信息吗？', {
                    icon: 3,
                    title: "提示",
                    skin: 'layui-layer-molv',
                    btnAlign: 'c'
                }, function () {
                    $.post("${Path}/field/deleteFieldInfo?", {fieldId: tableData.fieldId}, function (returnValue) {
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
                title: "场次信息添加",
                content: $('#addAndEditModel'),
                area: ["800px", "560px"],
                anim: 5,
                skin: "layui-layer-molv",
                closeBtn: 2,
                success: function (index) {
                    // 清空表单
                    $("#DataForm")[0].reset();
                    url = "${Path}/field/addFieldInfo";
                }
            });
        }

        // 修改的模态框
        function updateInfoModel(data) {
            maxIndex = layer.open({
                type: 1,
                title: "修改场次信息",
                content: $('#addAndEditModel'),
                area: ["800px", "560px"],
                anim: 5,
                skin: "layui-layer-molv",
                closeBtn: 2,
                success: function (index) {
                    //给表单赋值
                    form.val("DataForm", data);
                    $("#fieldId").val(data.fieldId);
                    url = "${Path}/field/updateFieldInfo";
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
