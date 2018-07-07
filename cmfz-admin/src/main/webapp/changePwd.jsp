
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<script type="text/javascript">

    $(function(){
        $.extend($.fn.validatebox.defaults.rules, {
            equals: {
                validator: function(value,param){
                    return value == $(param[0]).val();
                },
                message: '两次输入一致'
            }
        });
    });

</script>

<form id="forChange" method="post">
    <table align="center">
        <br>
        <tr>
            <td>新的密码</td>
            <td><input id="pwd" name="mgr_pwd" type="password" class="easyui-validatebox" data-options="required:true,missingMessage:'请设置六位密码'" />  </td>
        <tr>
        <tr>
            <td>确认密码</td>
            <td><input id="rpwd" name="pwd" type="password" class="easyui-validatebox"
                       data-options="missingMessage:'请再次确认密码'"
                       required="required" validType="equals['#pwd']" /></td>
        <tr>

    </table>

</form>
