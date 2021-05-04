<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <title>注册界面</title>
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
<body class="childrenBody">
<form class="layui-form" lay-filter="registerForm" id="registerForm" style="width:94%;">
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">姓名</label>
        <div class="layui-input-block">
            <input type="text" name="touristName" class="layui-input" lay-verify="required" placeholder="请输入真实姓名">
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">手机号</label>
        <div class="layui-input-block">
            <input type="text" name="touristPhone" id="touristPhone" class="layui-input"
                   lay-verify="required|phone|touristPhone" placeholder="请输入手机号">
        </div>
    </div>
    <div class="layui-row">
        <div class="magb15 layui-col-md4 layui-col-xs12">
            <label class="layui-form-label">性别</label>
            <div class="layui-input-block">
                <input type="radio" name="touristSex" value="1" title="男" checked>
                <input type="radio" name="touristSex" value="0" title="女">
            </div>
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">登录名</label>
        <div class="layui-input-block">
            <input type="text" name="touristLoginAccount" id="touristLoginAccount" readonly="readonly"
                   class="layui-input" lay-verify="required" placeholder="请输入登录名">
        </div>
    </div>
    <div class="layui-form-item layui-row layui-col-xs12">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-block">
            <input type="password" name="touristLoginPassword" class="layui-input" lay-verify="required"
                   placeholder="请输入密码">
        </div>
    </div>


    <div class="layui-form-item layui-row layui-col-xs12">
        <div class="layui-input-block">
            <a class="layui-btn layui-btn-sm" lay-submit="" lay-filter="register">立即注册</a>
        </div>
    </div>
</form>


<script src="${Path}/static/layui/layui.js" charset="utf-8"></script>
<script>
    layui.use(['table', 'layer', 'form', 'jquery', 'laydate'], function () {
        var $ = layui.jquery;
        var table = layui.table;
        layer = parent.layer === undefined ? layui.layer : top.layer;
        var form = layui.form;

        form.on("submit(register)", function () {
            var index = top.layer.msg('数据提交中，请稍候', {icon: 16, time: false, shade: 0.8});
            // 序列化表单数据
            var params = $("#registerForm").serialize();
            $.post("${Path}/tourist/touristRegister", params, function (data) {
                if (data.code === 200) {
                    setTimeout(function () {
                        top.layer.close(index);
                        top.layer.msg("注册成功！");
                        layer.closeAll("iframe");
                    }, 500);
                } else {
                    layer.msg(data.msg, {
                        icon: 5
                    });
                }
            });

            return false;
        });

        // 手机号输入框的改变事件
        $("#touristPhone").change(function () {
            $("#touristLoginAccount").val($(this).val());
        });

        //表单验证
        form.verify({
            touristPhone: function (value) {
                var formData = new FormData();
                formData.append("touristPhone", value);
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


    });

</script>

</body>
</html>
