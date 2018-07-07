<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false" %>

<script type="text/javascript">
    $(function(){
        $("#pic").datagrid({
            width:1000,
            url:"${pageContext.request.contextPath}/pic/allPicture",
            columns:[[{
                title:"图片编号",
                field:"picture_id",
                width:220,
                align:"center"
            },{
                title:"文件名称",
                field:"picture_path",
                width:250,
                align:"center"
            },{
                title:"描述信息",
                field:"picture_desc",
                width:140,
                align:"center"
            },{
                title:"轮播状态",
                field:"picture_status",
                width:90,
                align:"center"
            },{
                title:"上传时间",
                field:"picture_date",
                width:170,
                align:"center"
            }]],
            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/upload/' + rowData.picture_path + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>Attribute: ' + rowData.picture_desc + '</p>' +
                    '<p>Status: ' + rowData.picture_status + '</p>' +
                    '</td>' +
                    '</tr></table>';
            },
            pagination:true,
            pageList:[2,5,10],
            pageSize:5,
            toolbar:"#tool",
            fitColumns:true,
            singleSelect:true,
        });



        $("#add").linkbutton({
            onClick:function(){
                //弹出会话窗口
                $("#addPicture").dialog({
                    width:400,
                    height:250,
                    title:"添加轮播图",
                    toolbar:[{
                        iconCls:"icon-help",
                        text:"帮助",
                        handler:function(){
                            alert("愿意为您效力");
                        }
                    }],
                    href:"${pageContext.request.contextPath}/addPic.jsp",
                    modal:true,
                    shadow:true,
                    buttons:[{
                        iconCls:"icon-table_save",
                        text:"保存",
                        handler:function(){
                            //提交表单
                            $("#addPicForm").form("submit",{
                                url:"${pageContext.request.contextPath}/pic/addPicture",
                                onSubmit:function(){
                                    //return $("#form").form("validate");//做字段验证
                                }
                            });
                            $("#addPicture").dialog("close",{
                                href:"${pageContext.request.contextPath}/carousel.jsp"
                            });

                        }
                    },{
                        iconCls:"icon-cancel",
                        text:"取消",
                        handler:function(){
                            $("#addPicture").dialog("close");
                        }
                    }],

                });
            }
        });


        $("#update").linkbutton({

            onClick:function(){

                var rowData=$("#pic").datagrid("getSelected");

                $("#updatePicture").dialog({
                    width:350,
                    height:200,
                    title:"修改轮播图信息",
                    href:"${pageContext.request.contextPath}/changePic.jsp",
                    modal:true,
                    shadow:true,
                    onLoad:function(){
                        $("#changePicForm").form("load",rowData);
                    },
                    buttons:[{
                        iconCls:"icon-table_save",
                        text:"保存",
                        handler:function(){
                            //提交表单
                            $("#changePicForm").form("submit",{
                                url:"${pageContext.request.contextPath}/pic/changePicture",
                                success:function(data){
                                    $("#updatePicture").dialog("close");
                                    $("#pic").datagrid("reload");
                                }
                            });


                        }
                    },{
                        iconCls:"icon-cancel",
                        text:"取消",
                        handler:function(){
                            $("#updatePicture").dialog("close");
                        }
                    }],
                });

            }
        });
    });
</script>



<table id="pic"></table>


<div id="tool" style="display:none">
    <a id="add" class="easyui-linkbutton" data-options="iconCls:'icon-picture',plain:true,text:'添加轮播图'"></a>

    <a id="update" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true,text:'修改信息'"></a>
</div>

<div id="addPicture"></div>
<div id="updatePicture"></div>


