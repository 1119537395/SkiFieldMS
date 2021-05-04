<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
    <title>游客查看场次安排页面</title>
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

<blockquote class="layui-elem-quote layui-bg-green">
    <div id="nowTime"></div>
</blockquote>

<!-- 搜索条件开始 -->
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

<script type="text/html" id="switchTpl">
    <input type="checkbox" name="fieldState" value="{{d.fieldState}}" lay-filter="test11" lay-skin="switch"
           lay-text="开放中|已关闭"
           {{ d.fieldState==1?'checked':''}}>
</script>

<!-- 数据表格结束 -->


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
                , {field: 'fieldPeriod', title: '时间段', align: "center"}
                , {field: 'fieldPrice', title: '门票价格', align: "center"}
                , {field: 'fieldCapacity', title: '票量', align: "center"}
                , {field: 'fieldInfo', title: '说明', align: "center"}
                , {field: 'fieldState', title: '状态', align: "center", templet: '#switchTpl'}
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


    });

    //获取系统时间
    var newDate = '';
    getLangDate();

    //值小于10时，在前面补0
    function dateFilter(date) {
        if (date < 10) {
            return "0" + date;
        }
        return date;
    }

    function getLangDate() {
        var dateObj = new Date(); //表示当前系统时间的Date对象
        var year = dateObj.getFullYear(); //当前系统时间的完整年份值
        var month = dateObj.getMonth() + 1; //当前系统时间的月份值
        var date = dateObj.getDate(); //当前系统时间的月份中的日
        var day = dateObj.getDay(); //当前系统时间中的星期值
        var weeks = ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"];
        var week = weeks[day]; //根据星期值，从数组中获取对应的星期字符串
        var hour = dateObj.getHours(); //当前系统时间的小时值
        var minute = dateObj.getMinutes(); //当前系统时间的分钟值
        var second = dateObj.getSeconds(); //当前系统时间的秒钟值
        var timeValue = "" + ((hour >= 12) ? (hour >= 18) ? "晚上" : "下午" : "上午");
        newDate = dateFilter(year) + "年" + dateFilter(month) + "月" + dateFilter(date) + "日 " + " " + dateFilter(hour) + ":" + dateFilter(minute) + ":" + dateFilter(second);
        document.getElementById("nowTime").innerHTML = newDate + "　" + week+"&nbsp;&nbsp;&nbsp;滑雪场场次安排明细";
        setTimeout("getLangDate()", 1000);
    }


</script>

</body>
</html>
