<%--
  Created by IntelliJ IDEA.
  User: zjq
  Date: 18-6-13
  Time: 上午8:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>ECharts</title>
</head>

<body>
<span class="text-warning">
    当前登录用户：
    <c:out value="${userName}:${abc}">
    </c:out>
</span>
<!--Step:1 Prepare a dom for ECharts which (must) has size (width & hight)-->
<!--Step:1 为ECharts准备一个具备大小（宽高）的Dom-->
<div id="main" style="height:500px;border:1px solid #ccc;padding:10px;"></div>

<!--Step:2 Import echarts.js-->
<!--Step:2 引入echarts.js-->
<script src="chart/echarts.js"></script>
<script type="text/javascript">
    // Step:3 conifg ECharts's path, link to echarts.js from current page.
    // Step:3 为模块加载器配置echarts的路径，从当前页面链接到echarts.js，定义所需图表路径
    require.config({
        paths: {
            echarts: './'
        }
    });

    // Step:4 require echarts and use it in the callback.
    // Step:4 动态加载echarts然后在回调函数中开始使用，注意保持按需加载结构定义图表路径
    require(
        [
            'echarts',
            'echarts/chart/bar',
            'echarts/chart/line',
            'echarts/chart/map'
        ],
        function (ec) {
            //--- 折柱 ---
            var myChart = ec.init(document.getElementById('main'));
            myChart.setOption({
                tooltip: {
                    trigger: 'axis'
                },
                legend: {
                    data: ['工资收入', '奖金收入']
                },
                toolbox: {
                    show: true,
                    feature: {
                        mark: {show: true},
                        dataView: {show: true, readOnly: false},
                        magicType: {show: true, type: ['line', 'bar']},
                        restore: {show: true},
                        saveAsImage: {show: true}
                    }
                },
                calculable: true,
                xAxis: [
                    {
                        type: 'category',
                        data: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月']
                    }
                ],
                yAxis: [
                    {
                        type: 'value',
                        splitArea: {show: true}
                    }
                ],
                series: [
                    {
                        name: '工资收入',
                        type: 'bar',
                        data: ${basic}
                    },
                    {
                        name: '奖金收入',
                        type: 'bar',
                        data: ${more}
                    }
                ]
            });
        }
    );
</script>
</body>
</html>
