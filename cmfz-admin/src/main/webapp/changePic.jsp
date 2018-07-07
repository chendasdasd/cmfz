<%--
  Created by IntelliJ IDEA.
  User: 陈少
  Date: 2018/7/6
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<form id="changePicForm" method="post">
    <br/>
    <table align="center">
        <tr>
            <td>轮播图编号：</td>
            <td><input class="easyui-textbox" name="picture_id" readonly="readonly"/></td>
        </tr>

        <tr>
            <td>轮播图描述：</td>
            <td><input class="easyui-textbox" name="picture_desc"/></td>
        </tr>

        <tr>
            <td>轮播图状态：</td>
            <td>
                <select id="cc" class="easyui-combobox" name="picture_status" style="width:100px;">
                    <option value="未展示">不展示</option>
                    <option value="展示中">去展示</option>
                </select>
            </td>
        </tr>

    </table>

</form>
