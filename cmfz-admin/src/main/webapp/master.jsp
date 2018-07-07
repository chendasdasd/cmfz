<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false" %>

<script type="text/javascript">
    $(function(){

        $("#master").datagrid({
            url:"${pageContext.request.contextPath}/master/showByPage",
            columns:[[{
                title:"上师编号",
                field:"master_id",
                width:220,
                align:"center"
            },{
                title:"上师法名",
                field:"master_name",
                width:150,
                align:"center"
            },{
                title:"上师头像",
                field:"master_photo",
                width:250,
                align:"center"
            },{
                title:"上师简介",
                field:"introduce",
                width:200,
                align:"center"
            }]],
            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/upload/' + rowData.master_photo + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>Attribute: ' + rowData.master_name + '</p>' +
                    '<p>Status: ' + rowData.introduce + '</p>' +
                    '</td>' +
                    '</tr></table>';
            },
            width:1000,
            pagination:true,
            pageList:[2,5,10],
            pageSize:5,
            toolbar:"#masterTool",
            fitColumns:true,
            singleSelect:true,
        });




        $("#insertMaster").linkbutton({
            onClick:function(){
                //弹出会话窗口
                $("#addMaster").dialog({
                    width:400,
                    height:250,
                    title:"添加上师",
                    toolbar:[{
                        iconCls:"icon-help",
                        text:"帮助",
                        handler:function(){
                            alert("愿意为您效力");
                        }
                    }],
                    href:"${pageContext.request.contextPath}/addMaster.jsp",
                    modal:true,
                    shadow:true,
                    buttons:[{
                        iconCls:"icon-table_save",
                        text:"保存",
                        handler:function(){
                            //提交表单
                            $("#addMasterForm").form("submit",{
                                url:"${pageContext.request.contextPath}/master/addMaster",
                                onSubmit:function(){
                                    //return $("#form").form("validate");//做字段验证
                                }
                            });
                            $("#addMaster").dialog("close",{
                                href:"${pageContext.request.contextPath}/master.jsp"
                            });

                        }
                    },{
                        iconCls:"icon-cancel",
                        text:"取消",
                        handler:function(){
                            $("#addMaster").dialog("close");
                        }
                    }],

                });
            }
        });

        $("#updateMaster").linkbutton({

            onClick:function(){

                var rowData=$("#master").datagrid("getSelected");

                $("#changeMaster").dialog({
                    width:350,
                    height:200,
                    title:"修改上师信息",
                    href:"${pageContext.request.contextPath}/changeMaster.jsp",
                    modal:true,
                    shadow:true,
                    onLoad:function(){
                        $("#changeMasterForm").form("load",rowData);
                    },
                    buttons:[{
                        iconCls:"icon-table_save",
                        text:"保存",
                        handler:function(){
                            //提交表单
                            $("#changeMasterForm").form("submit",{
                                url:"${pageContext.request.contextPath}/master/changeMaster",
                                success:function(data){
                                    $("#changeMaster").dialog("close");
                                    $("#master").datagrid("reload");
                                }
                            });


                        }
                    },{
                        iconCls:"icon-cancel",
                        text:"取消",
                        handler:function(){
                            $("#changeMaster").dialog("close");
                        }
                    }],
                });
            }

        });



        $("#batchMaster").linkbutton({
            onClick:function(){
                //弹出会话窗口
                $("#lotSizeMaster").dialog({
                    width:350,
                    height:200,
                    title:"批量插入上师",
                    toolbar:[{
                        iconCls:"icon-help",
                        text:"帮助",
                        handler:function(){
                            alert("愿意为您效力");
                        }
                    }],
                    href:"${pageContext.request.contextPath}/batchMaster.jsp",
                    modal:true,
                    shadow:true,
                    buttons:[{
                        iconCls:"icon-table_save",
                        text:"保存",
                        handler:function(){
                            //提交表单
                            $("#batchMasterForm").form("submit",{
                                url:"${pageContext.request.contextPath}/master/batchMaster",
                                onSubmit:function(){
                                    //return $("#form").form("validate");//做字段验证
                                }
                            });
                            $("#lotSizeMaster").dialog("close",{
                                href:"${pageContext.request.contextPath}/master.jsp"
                            });

                        }
                    },{
                        iconCls:"icon-cancel",
                        text:"取消",
                        handler:function(){
                            $("#lotSizeMaster").dialog("close");
                        }
                    }],

                });
            }
        });


    });








   function word(value, name) {
        //alert(value + ":" + name);

        $("#master").datagrid("load",{
            value:value,
            name:name
        });
    }
</script>


<table id="master"></table>


<div id="masterTool" style="display:none">
    <a id="insertMaster" class="easyui-linkbutton" data-options="iconCls:'icon-picture',text:'添加上师'"></a>
    &nbsp;&nbsp;&nbsp;
    <a id="updateMaster" class="easyui-linkbutton" data-options="iconCls:'icon-edit',text:'修改上师信息'"></a>
    &nbsp;&nbsp;&nbsp;
    <a id="batchMaster" class="easyui-linkbutton" data-options="iconCls:'icon-group',text:'批量添加'"></a>

    &nbsp;&nbsp;&nbsp;
    <input id="select" class="easyui-searchbox" style="width:220px"
           data-options="searcher:word,prompt:'请输入法名进行查询',menu:'#keyWord'" align="right"></input>

</div>

<div id="keyWord" style="width:120px">
    <div data-options="name:'name',iconCls:'icon-client'">法名</div>
</div>


<div id="addMaster"></div>
<div id="changeMaster"></div>
<div id="lotSizeMaster"></div>



