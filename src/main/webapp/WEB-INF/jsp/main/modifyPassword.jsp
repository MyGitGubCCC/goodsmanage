<%--
  Created by IntelliJ IDEA.
  User: Liu
  Date: 2018/1/6
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<style>
    .editTable .label {
        min-width: 80px;
        width: 80px;
    }
</style>
<table class="editTable">
    <tr>
        <td class="label">工号</td>
        <td><input type="text" id="employeeno" name="employeeno" value="1"></td>
    </tr>
    <tr>
        <td class="label">姓名</td>
        <td><input type="text" id="name" name="name" value="${name}"></td>
    </tr>
    <tr>
        <td class="label">新密码</td>
        <td><input type="text" id="password" name="password">
        </td>
    </tr>
    <tr>
        <td class="label">重复新密码</td>
        <td><input type="text" id="password2" name="password2"></td>
    </tr>
</table>

<script type="text/javascript">
    $(function () {
        $('#employeeno').iTextbox({
            width: 200,
            readonly: true
        });
        $('#name').iTextbox({
            width: 200,
            readonly: true
        });
        $('#password').iPasswordbox({
            width: 200,
            required: true,
            validType: 'minLength[1]'
        });
        $('#password2').iPasswordbox({
            width: 200,
            required: true,
            validType: "equals['#password']"
        });
    });
</script>
</body>
</html>
