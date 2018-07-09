<%--
  Created by IntelliJ IDEA.
  User: 陈少
  Date: 2018/7/9
  Time: 13:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>ECharts</title>
    <!-- 引入 echarts.js -->
    <script src="echarts.min.js"></script>
    <script src="../js/jquery.min.js"></script>
</head>
<body>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main" style="width: 600px;height:400px;"></div>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: 'ECharts 入门示例'
        },
        tooltip: {},
        legend: {
            data:['销量']
        },
        xAxis: {
            data: []
        },
        yAxis: {},
        series: [{
            name: '销量',
            type: 'bar',
            data: []
        }]
    };

    // 异步加载数据到图表中
    $.ajax({
        url:"data.json",
        dataType:"json",
        success:function (data) { // 响应的json数据
            // 填入数据
            myChart.setOption({
                xAxis: {
                    data: data.categories
                },
                series: [{
                    // 根据名字对应到相应的系列
                    name: '销量',
                    data: data.data
                }]
            });
        }
    });


    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
</script>
</body>
</html>