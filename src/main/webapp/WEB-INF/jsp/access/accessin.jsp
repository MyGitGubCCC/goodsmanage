<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8" pageEncoding="utf-8"  isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>accessin</title>
    <!--引入JQuery EasyUI所需的js和css-->
    <meta charset="UTF-8" />
    <!--引入jQuery 核心库，这里采用的是2.0-->
    <script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5.3/jquery.min.js"></script>
    <!--引入jQuery EasyUI 核心库，这里采用的是1.5.3-->
    <script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5.3/jquery.easyui.min.js"></script>
    <!--引入EasyUI 中文提示信息-->
    <script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.5.3/locale/easyui-lang-zh_CN.js" ></script>
    <!--引入EasyUI 核心UI 文件CSS-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.5.3/themes/default/easyui.css" />

    <%--引入自定义的js--%>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/accessin-js.js"></script>
    <!--引入EasyUI 图标文件-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.5.3/themes/icon.css" />
</head>
<body class="easyui-layout">
<div region="center" fit="true" title="带出物品管理" >
    <div id="tb">
        <table id="searchTable">
            <tr>
                <td>学号或卡号：</td>
                <td><input class="easyui-textbox" name="sno" id="sno" style="width:150px;"/></td>
                <td>姓名：</td>
                <td><input class="easyui-textbox" name="sname" id="sname" prompt="模糊查询..." style="width:150px;"/></td>
                <td>物品名称：</td>
                <td><input class="easyui-textbox" name="goodsname" id="goodsname" prompt="模糊查询..." style="width:150px;"/></td>
            </tr>
            <tr>
                <td>楼号：</td>
                <td><input class="easyui-combobox" name="buildingid" id="buildingid"style="width:150px;"
                           data-options="
					url:'selectAllBuilding.action',
					method:'get',
					valueField:'buildingid',
					textField:'buildingno',
					panelHeight:'auto'
			"></td>
                <td>宿舍号：</td>
                <td><input class="easyui-combobox" name="dormitoryid" id="dormitoryid" style="width:150px;"
                           data-options="
					url:'selectAllDormitory.action',
					method:'get',
					valueField:'dormitoryid',
					textField:'dormitoryno',
					panelHeight:'auto'
			"></td>
                <td>出入情况：</td>
                <td><select class="easyui-combobox" name="inorout" id="inorout" style="width:150px;">
                    <option value="-1">不区分</option>
                    <option value="0">出</option>
                    <option value="1">入</option></select></td>
            </tr>
            <tr>
                <td>开始时间：</td>
                <td><input class="easyui-datetimebox" name="starttime" id="starttime"  style="width:150px"></td>
                <td>结束时间：</td>
                <td><input class="easyui-datetimebox" name="endtime" id="endtime"  style="width:150px"></td>
                <td>时间排序：</td>
                <td><select class="easyui-combobox" name="timesort" id="timesort" style="width:150px">
                    <option value="0">升序</option>
                    <option value="1">降序</option>
                </select></td>
            </tr>
        </table>
        <a href="#" id="findbtn" class="easyui-linkbutton" plain="true" data-options="iconCls:'icon-search'" style="width:100px">查询</a>
        <a href="#" id="clearbtn" class="easyui-linkbutton" plain="true" iconCls="icon-cancel" style="width:100px">清除查询框</a>
        <c:set value="${role}" var="role" property=""/>
        <c:if test="${role == '管理员'}">
            <a href="#" id="delbtn" class="easyui-linkbutton" plain="true" iconCls="icon-remove" style="width:100px">删除</a>
        </c:if>
    </div>
        <!--托运信息展示-->
    <div data-options="region:'center'" style="padding:5px;background:#eee;width:100%;height: auto;">
            <table id="datagriddata"></table>
    </div>
</div>

</body>
</html>
