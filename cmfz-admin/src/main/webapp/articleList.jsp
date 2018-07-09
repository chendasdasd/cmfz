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
        $("#article").datagrid({
            url:"${pageContext.request.contextPath}/article/showAll",
            columns:[[{
                title:"文章编号",
                field:"article_id",
                width:240,
                align:"center"
            },{
                title:"文章标题",
                field:"article_name",
                width:180,
                align:"center"
            },{
                title:"文章状态",
                field:"status",
                width:100,
                align:"center"
            },{
                title:"创作时间",
                field:"date",
                width:160,
                align:"center"
            },{
                title:"所属上师",
                field:"master_name",
                width:240,
                align:"center"
            }]],
            width:1000,
            pagination:true,
            pageList:[2,5,10],
            pageSize:5,
            toolbar:"#articleTool",
            fitColumns:true,
            singleSelect:true
        });


        $("#lookArticle").linkbutton({
           onClick:function(){
               var rowData=$("#article").datagrid("getSelected");
               //alert(rowData.introduce);
               $("#book_introduce").window({
                   width:600,
                   height:400,
                   title:"文章详情",
                   toolbar:[{
                       iconCls:"icon-help",
                       text:"帮助",
                       handler:function(){
                           alert("愿意为您效力");
                       }
                   }],
                   href:"${pageContext.request.contextPath}/articleIntroduce.jsp"
               });
           }
        });
    })

</script>




<table id="article"></table>

<div id="articleTool" style="display:none">
    <a id="lookArticle" class="easyui-linkbutton" data-options="iconCls:'icon-eye',text:'文章详情'"></a>
    &nbsp;&nbsp;&nbsp;
    <a id="updateArticle" class="easyui-linkbutton" data-options="iconCls:'icon-edit',text:'编辑文章'"></a>
</div>

<div id="book_introduce"></div>