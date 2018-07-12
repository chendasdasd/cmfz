<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false" %>
<%@taglib uri="http://shiro.apache.org/tags" prefix="shiro" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>持名法州主页</title>
<link rel="stylesheet" type="text/css" href="../themes/default/easyui.css">   
<link rel="stylesheet" type="text/css" href="../themes/icon.css">
<link rel="stylesheet" type="text/css" href="../themes/IconExtension.css">
<script type="text/javascript" src="../js/jquery.min.js"></script>   
<script type="text/javascript" src="../js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../js/datagrid-detailview.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/echarts.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/china.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/vintage.js"></script>
<script type="text/javascript" src="../js/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript">

	function addTab(menu_name,menu_url,menu_icon){
	    //创建选项卡面板
		var b=$("#tt").tabs("exists",menu_name);

		if(b){
		    $("#tt").tabs("select",menu_name);
		}else{
		    $("#tt").tabs("add",{
				title:menu_name,
				iconCls:menu_icon,
				href:"${pageContext.request.contextPath}/"+menu_url,
				closable:true,
			});
		}
	}

	$(function(){
	   $.ajax({
		   url:"${pageContext.request.contextPath}/menu/all",
		   dstaType:"json",
		   success:function(result){
		       //console.log(result);
			   //遍历响应集合
			   //参数result：代表当前遍历的集合
			   //	    index：当前遍历的下标
			   //		obj：遍历过程中的临时变量
			   $.each(result,function(index,obj){
			       //console.log(obj);
				   var content="";
				   $.each(obj.levelTwo,function(index1,obj1){
                       content += "<p style=\"text-align: center\"><a class=\"easyui-linkbutton\" data-options=\"iconCls:'"+obj1.menu_icon+"',plain:true\" onclick=\"addTab('"+obj1.menu_name+"','"+obj1.menu_url+"','"+obj1.menu_icon+"')\">"+obj1.menu_name+"</a></p>"
				   })

				   $("#aa").accordion("add",{
				       title:obj.menu_name,
					   iconCls:obj.menu_icon,
					   content:content,
					   selected:false,
				   });

			   })
           }
	   });

	   $("#changePwd").linkbutton({
			onClick:function(){
			    //弹出会话窗口
				$("#pwdForm").dialog({
					width:300,
					height:180,
					title:"修改密码",
					modal:true,
					href:"${pageContext.request.contextPath}/changePwd.jsp",
					buttons:[{
					    iconCls:"icon-accept",
						text:"保存",
						handler:function(){
							$("#forChange").form("submit",{
							     url:"${pageContext.request.contextPath}/admin/updatePwd",

							});
                            $("#pwdForm").dialog("close",{
                                href:"${pageContext.request.contextPath}/main/main.jsp"
                            });
                        }
					},{
                        iconCls:"icon-cancel",
                        text:"取消",
                        handler:function(){
                            $("#pwdForm").dialog("close");
                        }
					}],

				});
			}
	   });

	});

</script>

</head>
<body class="easyui-layout">   
    <div data-options="region:'north',split:true" style="height:60px;background-color:  #5C160C">
    	<div style="font-size: 24px;color: #FAF7F7;font-family: 楷体;font-weight: 900;width: 500px;float:left;padding-left: 20px;padding-top: 10px" >持名法州后台管理系统</div>
    	<div style="font-size: 16px;color: #FAF7F7;font-family: 楷体;width: 300px;float:right;padding-top:15px">欢迎您:   &nbsp;
			<a id="changePwd" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">修改密码</a>
			<a id="exit" class="easyui-linkbutton" data-options="iconCls:'icon-01'">退出系统</a>
		</div>
    </div>   
    <div data-options="region:'south',split:true" style="height: 40px;background: #5C160C">
    	<div style="text-align: center;font-size:15px; color: #FAF7F7;font-family: 楷体" >&copy;百知教育 gaozhy@zparkhr.com.cn</div>
    </div>   
       
    <div data-options="region:'west',title:'导航菜单',split:true" style="width:220px;">
    	<div id="aa" class="easyui-accordion" data-options="fit:true">
    		
		</div>  
    </div>   
    <div data-options="region:'center'">
    	<div id="tt" class="easyui-tabs" data-options="fit:true,narrow:true,pill:true">
		    <div title="主页" data-options="iconCls:'icon-neighbourhood',"  style="background-image:url(${pageContext.request.contextPath}/main/image/shouye.jpg);background-repeat: no-repeat;background-size:100% 100%;"></div>
		</div>  
    </div>

	<div id="pwdForm"></div>

</body> 
</html>