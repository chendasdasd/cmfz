<%--
  Created by IntelliJ IDEA.
  User: 陈少
  Date: 2018/7/6
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<form id="changeMasterForm" method="post">
    <br/>
    <table align="center">
        <tr>
            <td>上师编号：</td>
            <td><input class="easyui-textbox" name="master_id" readonly="readonly"/></td>
        </tr>

        <tr>
            <td>上师头像：</td>
            <td><input class="easyui-textbox" name="master_photo" readonly="readonly"/></td>
        </tr>

        <tr>
            <td>上师法名：</td>
            <td><input class="easyui-textbox" name="master_name"/></td>
        </tr>

        <tr>
            <td>上师简介：</td>
            <td>
                <input class="easyui-textbox" name="introduce"/>
            </td>
        </tr>

    </table>

</form>
