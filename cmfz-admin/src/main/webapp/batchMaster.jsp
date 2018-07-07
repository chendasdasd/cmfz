<%--
  Created by IntelliJ IDEA.
  User: 陈少
  Date: 2018/7/6
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<form id="batchMasterForm" method="post" enctype="multipart/form-data">
    <br/>
    <table align="center">
        <tr>
            <td align="center" colspan="2">
                <font color="red">必须选择一个Excel表格文件!!</font>
            </td>
        </tr>
        <tr></tr>
        <tr>
            <td>Excel文件</td>
            <td><input class="easyui-filebox" style="width:140px" name="excelFile"></td>
        </tr>

    </table>

</form>
