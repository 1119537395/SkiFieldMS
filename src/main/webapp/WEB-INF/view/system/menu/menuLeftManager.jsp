<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>菜单管理</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta http-equiv="Access-Control-Allow-Origin" content="*">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link rel="icon" href="favicon.ico">
<link rel="stylesheet" href="${Path}/static/layui/css/layui.css" media="all" />
<link rel="stylesheet" href="${Path}/static/css/public.css" media="all" />
<link rel="stylesheet" href="${Path}/static/layui_ext/dtree/dtree.css">
<link rel="stylesheet" href="${Path}/static/layui_ext/dtree/font/dtreefont.css">
</head>
<body style="margin-top: 10px">

<%-- 菜单树结构 --%>
<ul id="menuTree" class="dtree" data-id="0"></ul>

<script type="text/javascript" src="${Path}/static/layui/layui.js"></script>
<script type="text/javascript">
        var menuTree;
        layui.extend({
        dtree:'${Path}/static/layui_ext/dist/dtree'
        }).use([ 'jquery', 'layer', 'form','dtree' ], function() {
                var $ = layui.jquery;
                var layer = layui.layer;
                var form = layui.form;
                var dtree = layui.dtree;
        // 初始化树
        menuTree = dtree.render({
        elem: "#menuTree",
        dataStyle: "layuiStyle",
        response:{message:"msg",statusCode:0},
        dataFormat: "list",
        url: "${Path}/menu/loadLeftMenuTreeJson?spread=1"
        });

        //监听树的节点点击 事件
        dtree.on("node('menuTree')" ,function(obj){
          //获取到点击节点的id
          var id = obj.param.nodeId;
          //通过父窗口访问到另一个子窗口的方法并传递参数
          window.parent.right.reloadMenu(id);
          });
        });
</script>
</body>
</html>
