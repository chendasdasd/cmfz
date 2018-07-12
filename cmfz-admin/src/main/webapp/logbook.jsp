<%--
  Created by IntelliJ IDEA.
  User: 陈少
  Date: 2018/7/8
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<script type="text/javascript">
    $(function(){
        $("#logbook").datagrid({
            url:"${pageContext.request.contextPath}/logbook/showAll",
            columns:[[{
                title:"日志编号",
                field:"id",
                width:240,
                align:"center"
            },{
                title:"操作用户",
                field:"userName",
                width:120,
                align:"center"
            },{
                title:"操作时间",
                field:"actionTime",
                width:180,
                align:"center"
            },{
                title:"操作资源",
                field:"resource",
                width:120,
                align:"center"
            },{
                title:"动作详情",
                field:"action",
                width:60,
                align:"center"
            },{
                title:"操作信息",
                field:"message",
                width:280,
                align:"center"
            },{
                title:"结果",
                field:"result",
                width:60,
                align:"center"
            }]],
            width:1000,
            pagination:true,
            pageList:[2,5,10],
            pageSize:5,
            fitColumns:true,
            singleSelect:true
        });



    })

</script>




<table id="logbook"></table>