<%--
  Created by IntelliJ IDEA.
  User: 陈少
  Date: 2018/7/8
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/wangEditor.min.js"></script>
<script type="text/javascript">
    var E = window.wangEditor;
    var editor = new E('#editor');
    // 或者 var editor = new E( document.getElementById('editor') )
    editor.customConfig.uploadImgServer = "${pageContext.request.contextPath}/article/uploadPic";
    editor.customConfig.uploadFileName = 'files'; //上传图片的名称
    var $textIn = $("#textIn");
    editor.customConfig.onchange = function (html) {
        // 监控变化，同步更新到 textarea
        $textIn.val(html)
    };
    editor.create();


    $(function(){
        $("#article_author").combobox({
            url:"${pageContext.request.contextPath}/master/allMaster",
            valueField:'master_id',
            textField:'master_name',
            limitToList:true,
        });

        $("#create").linkbutton({
            iconCls:"icon-accept",
            onClick:function(){
                $("#creatArticle").form("submit",{
                    url:"${pageContext.request.contextPath}/article/addArticle",
                    onSubmit:function(){
                        //return $("#form").form("validate");//做字段验证
                    }
                });
                alert("创建成功");

                $("#creatArticle").form("reset");
                var E = window.wangEditor;
                var editor = new E("#editor");
                editor.create();
                editor.txt.html("");

            }
        });

        $("#reset").linkbutton({
            iconCls:"icon-2012080404218",
            onClick:function(){
               var E = window.wangEditor;
               var editor = new E("#editor");
               editor.create();
               editor.txt.html("");
           }
        });
    })

    function test(){
        alert(editor.txt.text());
    }
</script>
<div id="atricleHead" style="background-color: #ffb3b3;">
<form id="creatArticle" method="post">

        <div style="padding-top: 25px;padding-left: 10px">
            文章标题：<input id="title" name="article_name" class="easyui-textbox" data-options="prompt:'请您输入文章标题',width:160"/>
            &nbsp;&nbsp;&nbsp;&nbsp;
            文章作者：<input id="article_author" name="master_id" class="easyui-combobox" data-options="width:'160'"/>
            &nbsp;&nbsp;&nbsp;&nbsp;
            文章状态：<input id="book_status" class="easyui-switchbutton" name="status" data-options="onText:'上架',offText:'不上架',width:'80'">
            <br/>
            <br/>
            文章内容：
            <br/>
        </div>
     <input id="textIn" name="introduce" value="" type="hidden"/>
     <div id="editor" style="padding-top: 10px">
         <p>请编辑文章主内容...</p>
     </div>

    <div style="padding-left: 400px;padding-top: 10px">
        <a id="create">创建文章</a>
        <a id="reset">重置内容</a>

       <%-- <button id="btn" onclick="test()">内容</button>--%>
    </div>

</form>
</div>

