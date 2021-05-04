<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <title>门票销售管理页面</title>
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

<blockquote class="layui-elem-quote layui-bg-green" id="StatusBar">
    <div id="StatusBarInfo"></div>
</blockquote>

<!-- 表单开始 -->
<div style="display: none" id="checkFormHide">
    <blockquote class="layui-elem-quote" style="border-left:0px;">
        <h2>游客购票窗口</h2>
        <hr style="background-color: #009688;">
        <form class="layui-form layui-form-pane" method="post" lay-filter="checkFrom" id="checkFrom">

            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">订单编号</label>
                    <div class="layui-input-inline">
                        <input type="text" name="orderId" id="orderId" autocomplete="off" readonly="readonly"
                               class="layui-input">
                    </div>
                </div>

                <div class="layui-inline">
                    <label class="layui-form-label">雪道名称</label>
                    <div class="layui-input-inline">
                        <input type="text" name="fieldId" id="fieldId" style="display: none">
                        <input type="text" name="fieldRoad" id="fieldRoad" autocomplete="off" readonly="readonly"
                               class="layui-input"
                               placeholder="请输入雪道名称">
                    </div>
                </div>

                <div class="layui-inline">
                    <label class="layui-form-label">门票价格</label>
                    <div class="layui-input-inline">
                        <input type="text" name="fieldPrice" id="fieldPrice" readonly="readonly" autocomplete="off"
                               class="layui-input"
                               placeholder="请输入门票价格">
                    </div>
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">游客号码</label>
                <div class="layui-input-block">
                    <input type="text" name="touristPhone" id="touristPhone" autocomplete="off"
                           lay-verify="required|number|touristPhone"
                           class="layui-input"
                           placeholder="请输入游客的手机号码">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">购票数量</label>
                <div class="layui-input-block">
                    <input type="text" name="buyTicketNumber" id="buyTicketNumber" autocomplete="off"
                           lay-verify="required|number|ticket"
                           class="layui-input" placeholder="请输入购票数量">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">支付金额</label>
                <div class="layui-input-block">
                    <input type="text" name="paymentAmount" id="paymentAmount" autocomplete="off"
                           readonly="readonly"
                           lay-verify="required|number"
                           class="layui-input" placeholder="请输入支付金额">
                </div>
            </div>

            <div class="layui-form-item">
                <label class="layui-form-label">售票员</label>
                <div class="layui-input-block">
                    <input type="text" name="conductor" id="conductor" readonly="readonly" autocomplete="off"
                           lay-verify="required"
                           class="layui-input">
                </div>
            </div>

            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">备注说明</label>
                <div class="layui-input-block">
                    <textarea placeholder="请输入订单的详细描述" lay-verify="required" name="orderInfo"
                              class="layui-textarea"></textarea>
                </div>
            </div>

            <div class="layui-form-item">
                <div class="layui-inline">
                    <div class="layui-input-label">
                        <button type="button" class="layui-btn layui-icon layui-icon-ok-circle"
                                lay-filter="doSubmit" lay-submit="" id="doSubmit">&nbsp;确认
                        </button>
                    </div>
                </div>
                <div class="layui-inline">
                    <div class="layui-input-label">
                        <button type="button" class="layui-btn layui-icon layui-icon-close-fill"
                                id="cancel">&nbsp;取消
                        </button>
                    </div>
                </div>
            </div>
        </form>
    </blockquote>
</div>
<!-- 表单结束 -->

<!-- 数据表格开始 -->
<div id="GeneralTableId" style="display: block">
    <table class="layui-hide" id="GeneralTable" lay-filter="GeneralTable"></table>
</div>

<!-- 数据表格内部操作按钮开始 -->
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="buy">购票</a>
</script>
<!-- 数据表格内部操作按钮结束 -->


<script src="${Path}/static/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript">
    var tableIns;
    layui.use(['table', 'layer', 'form', 'jquery', 'upload'], function () {
        var $ = layui.jquery;
        var table = layui.table;
        var layer = layui.layer;
        var form = layui.form;
        var fieldId;

        // 渲染表格数据
        tableIns = table.render({
            elem: '#GeneralTable'
            , url: '${Path}/field/loadFieldInfoByState'
            , height: 'full-90'
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
                , {
                    field: 'fieldCapacity', title: '票量', align: "center", templet: function (data) {
                        return '<font color="red">'+data.fieldCapacity+'</font>';
                    }
                }
                , {field: 'fieldInfo', title: '说明', align: "center"}
                , {fixed: 'right', title: '操作', toolbar: '#barDemo', align: "center"}
            ]]
        });

        // 保存订单数据
        form.on("submit(doSubmit)", function () {
            // 序列化表单数据
            var params = $("#checkFrom").serialize();
            // 发送请求保存订单数据
            $.post("${Path}/order/addOrderData", params, function (value) {
                if (value.code == 200) {
                    // 显示数据表格
                    $("#GeneralTableId").css("display", "block");
                    // 隐藏订单列表
                    $("#checkFormHide").css("display", "none");
                    // 显示状态栏
                    $("#StatusBar").css("display", "block");
                    // 刷新表格
                    tableIns.reload();
                    layer.msg(value.msg, {icon: 6});
                }
            });
        });


        //监听行工具购买和浏览按钮事件
        table.on('tool(GeneralTable)', function (obj) {
            var tableData = obj.data;  //获取到单击行的数据
            var layEvent = obj.event;
            if (layEvent === 'buy') {
                buyFun(tableData);
            }
        });

        // 购买数量输入框添加事件
        $("#buyTicketNumber").change(function () {
            if ($(this).val() !== '') {
                var amount = $("#fieldPrice").val() * $(this).val();
                $("#paymentAmount").val(amount);
            }
        });

        // 取消按钮的单击事件
        $("#cancel").on("click", function () {
            // 显示鲜花的数据表格
            $("#GeneralTableId").css("display", "block");
            // 显示状态栏
            $("#StatusBar").css("display", "block");
            // 隐藏订单列表
            $("#checkFormHide").css("display", "none");
        });

        // 购买按钮的单击事件
        function buyFun(tableData) {
            // 清空表单的数据
            $("#checkFrom")[0].reset();
            // 隐藏数据表格
            $("#GeneralTableId").css("display", "none");
            // 显示订单列表
            $("#checkFormHide").css("display", "block");
            // 隐藏状态栏
            $("#StatusBar").css("display", "none");
            // 初始化订单列表
            initOrderFormData(tableData);
        }

        // 初始化订单列表
        function initOrderFormData(tableData) {
            // 发送请求获取到订单列表数据
            $.post("${Path}/order/loadOrderFormData", function (map) {
                // 给订单输入框赋值
                $("#orderId").val(map.orderNumber);
                fieldId = tableData.fieldId;
                // 给售票员输入框赋值
                $("#conductor").val(map.userName);
                $("#fieldRoad").val(tableData.fieldRoad);
                $("#fieldPrice").val(tableData.fieldPrice);
                $("#fieldId").val(tableData.fieldId);
            });
        }


        //表单验证
        form.verify({
            touristPhone: function (value) {
                var formData = new FormData();
                formData.append("touristPhone", value);
                var message = '';
                $.ajax({
                    url: "${Path}/order/checkTouristPhone",
                    type: 'POST',
                    data: formData,
                    async: false,
                    cache: false,
                    processData: false,
                    contentType: false,
                    dataType: "json",
                    success: function (data) {
                        if (data) {
                            message = "游客手机号未录入系统!";
                        }
                    }
                });
                if (message !== '') {
                    return message;
                }
            },
            ticket: function (value) {
                var formData = new FormData();
                formData.append("fieldId", fieldId);
                formData.append("ticketNumber", value);
                var message = '';
                $.ajax({
                    url: "${Path}/field/checkTicketNumber",
                    type: 'POST',
                    data: formData,
                    async: false,
                    cache: false,
                    processData: false,
                    contentType: false,
                    dataType: "json",
                    success: function (data) {
                        if (data) {
                            message = "剩余票量不足，请重新输入购票数量!";
                        }
                    }
                });
                if (message !== '') {
                    return message;
                }
            }
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
        document.getElementById("StatusBarInfo").innerHTML = newDate + "　" + week+"&nbsp;&nbsp;&nbsp;滑雪场售票窗口";
        setTimeout("getLangDate()", 1000);
    }

</script>

</body>
</html>