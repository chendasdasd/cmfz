<%--
  Created by IntelliJ IDEA.
  User: 陈少
  Date: 2018/7/6
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<form id="addMasterForm" method="post" enctype="multipart/form-data">
    <br/>
    <table align="center">
        <tr>
            <td>上师姓名</td>
            <td><input class="easyui-textbox" name="master_name"/></td>
        </tr>

        <tr>
            <td>上师描述</td>
            <td>
                <input class="easyui-textbox" name="introduce"/>
            </td>
        </tr>

        <tr>
            <td>上师头像</td>
            <td><input class="easyui-filebox" style="width:160px" name="masterPhoto"></td>
        </tr>

    </table>

</form>
