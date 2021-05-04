<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html class="loginHtml">
<head>
    <meta charset="utf-8">
    <title>登录界面</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="icon" href="${Path}/static/media.png">
    <link rel="stylesheet" href="${Path}/static/layui/css/layui.css" media="all"/>
    <link rel="stylesheet" href="${Path}/static/css/public.css" media="all"/>
    <style type="text/css">
        .login_btns{
            background-color: #446fa6;
            height: 36px;
            width: 260px;
        }
    </style>
</head>
<body class="loginBody">

<form class="layui-form" lay-filter="loginForm" id="loginForm">
    <div class="login_face"><img id="userImg" src="${Path}/static/images/logo.jpg" class="userAvatar"></div>
    <div class="layui-form-item input-item">
        <label for="userAccount">账户名</label>
        <input type="text" placeholder="请输入账户名" lay-verify="required" value="" id="userAccount" autocomplete="off"
               name="userAccount"
               class="layui-input">
    </div>
    <div class="layui-form-item input-item">
        <label for="userPassword">密码</label>
        <input type="password" placeholder="请输入密码" lay-verify="required" value="" id="userPassword" autocomplete="off"
               name="userPassword"
               class="layui-input">
    </div>
    <div class="layui-form-item input-item" id="imgCode">
        <label for="code">验证码</label>
        <input type="text" placeholder="请输入验证码" name="code" lay-verify="required" autocomplete="off" id="code"
               class="layui-input">
        <img src="${Path}/login/getCaptcha" onclick="this.src=this.src+'?'">
    </div>


    <div class="layui-form-item">
        <input type="radio" name="mark" value="0" title="工作人员" checked>
        <input type="radio" name="mark" value="1" title="普通游客">
    </div>
    <div class="layui-form-item">
        <button class="layui-btn layui-block login_btns" lay-filter="login" id="login" lay-submit="">登录</button>
    </div>
    <div class="layui-form-item">
        <a class="layui-btn layui-block login_btns" id="access">注册</a>
    </div>
</form>

<script type="text/javascript" src="${Path}/static/layui/layui.js"></script>
<script type="text/javascript" src="${Path}/static/js/cache.js"></script>
<script type="text/javascript">
    layui.use(['form', 'layer', 'jquery'], function () {
        var form = layui.form,
            layer = parent.layer === undefined ? layui.layer : top.layer
        $ = layui.jquery;
        //登录按钮
        form.on("submit(login)", function (data) {
            $(this).text(" 正在登录...").attr("disabled", "disabled").addClass("layui-disabled");
            // 序列化表单数据
            var params = $("#loginForm").serialize();
            $.post("${Path}/login/userLogin", params, function (data) {
                if (data.code === 100) {
                    // 加载圈
                    layer.load(0, {shade: false});
                    setTimeout(function () {
                        location.href = "../system/toMainManager";
                    }, 500);
                } else if (data.code === 104 || data.code === 303) {
                    layer.msg(data.msg, {
                        icon: 5,
                        time: 1000,
                        shade: 0.3,
                        end: function () {
                            location.href = "../login/toLogin";
                        }
                    });
                }
            });

            return false;
        });

        //注册按钮
        $("#access").click(function () {
            var index = layui.layer.open({
                title : "注册",
                type : 2,
                content : "${Path}/system/toTouristRegister",
                success : function(layero, index){}
            });
            layui.layer.full(index);
            //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
            $(window).on("resize",function(){
                layui.layer.full(index);
            })
        });


        //表单输入效果
        $(".loginBody .input-item").click(function (e) {
            e.stopPropagation();
            $(this).addClass("layui-input-focus").find(".layui-input").focus();
        })
        $(".loginBody .layui-form-item .layui-input").focus(function () {
            $(this).parent().addClass("layui-input-focus");
        })
        $(".loginBody .layui-form-item .layui-input").blur(function () {
            $(this).parent().removeClass("layui-input-focus");
            if ($(this).val() != '') {
                $(this).parent().addClass("layui-input-active");
            } else {
                $(this).parent().removeClass("layui-input-active");
            }
        });
    });
</script>
</body>
</html>
