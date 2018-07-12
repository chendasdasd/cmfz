<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>统计分析</title>
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
            text: '持名法洲App活跃用户'
        },
        tooltip: {},
        legend: {
            data:['时长']
        },
        xAxis: {
            data: ["7天","15天","30天","90天","半年","一年"]
        },
        yAxis: {},
        series: [{
            name: '时长',
            type: 'bar',
            data: [5, 20, 36, 28, 40, 60]
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
</script>
</body>
</html>