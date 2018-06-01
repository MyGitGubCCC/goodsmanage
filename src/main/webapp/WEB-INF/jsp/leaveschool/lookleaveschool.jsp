<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8" pageEncoding="utf-8"  isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>离校管理</title>
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
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/lookleaveschool-js.js"></script>
    <!--引入EasyUI 图标文件-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.5.3/themes/icon.css" />
</head>
<body class="easyui-layout">
<div region="center" fit="true" title="离校管理" >
    <div id="tb">
        <table id="searchTable">
            <tr>
                <td>学号或卡号：</td>
                <td><input class="easyui-numberbox" name="sno" id="sno" style="width:150px"/></td>
                <td>楼号：</td>
                <td><input class="easyui-combobox" name="buildingid" id="buildingid"style="width:150px;"
                           data-options="
					url:'selectAllBuilding.action',
					method:'get',
					valueField:'buildingid',
					textField:'buildingno',
					panelHeight:'600px',
					editable:false
			"></td>
                <td>宿舍号：</td>
                <td><input class="easyui-combobox" name="dormitoryid" id="dormitoryid" style="width:150px;"
                           data-options="
					url:'selectAllDormitory.action',
					method:'get',
					valueField:'dormitoryid',
					textField:'dormitoryno',
					panelHeight:'600px',
					editable:false
			"></td>
            </tr>
            <tr>
            <td>姓名：</td>
            <td><input class="easyui-textbox" name="sname" id="sname" prompt="模糊查询..." style="width:150px;"/></td>
            <td>离校开始时间：</td>
            <td><input class="easyui-datetimebox" name="leavestarttime" editable="false" id="leavestarttime"  style="width:150px"></td>
            <td>离校结束时间：</td>
            <td><input class="easyui-datetimebox" name="leaveendtime" editable="false" id="leaveendtime"  style="width:150px"></td>
        </tr>
            <tr>
                <td>家庭住址：</td>
                <td><input class="easyui-textbox" name="homeadress" id="homeadress" prompt="模糊查询..." style="width:150px;"/></td>
                <td>返校开始时间：</td>
                <td><input class="easyui-datetimebox" name="backstarttime" editable="false" id="backstarttime"  style="width:150px"></td>
                <td>返校结束时间：</td>
                <td><input class="easyui-datetimebox" name="backendtime" editable="false" id="backendtime"  style="width:150px"></td>
            </tr>
            <tr>
                <td>是否返校：</td>
                <td><select class="easyui-combobox" name="notBackSchool" editable="false" id="notBackSchool" style="width:150px">
                    <option value="0">全部</option>
                    <option value="1">未返校</option>
                </select></td>
                <td>时间排序：</td>
                <td><select class="easyui-combobox" name="timesort" editable="false" id="timesort" style="width:150px">
                    <option value="0">升序</option>
                    <option value="1">降序</option>
                </select></td>
                <td colspan="2"> <a href="#" id="findbtn" class="easyui-linkbutton" plain="true" data-options="iconCls:'icon-search'" style="width:80px">查询</a>
                    <a href="#" id="clearbtn" class="easyui-linkbutton" plain="true" iconCls="icon-cancel" style="width:100px">清除查询框</a>
                    <c:set value="${role}" var="role" property=""/>
                    <c:if test="${role == '管理员'}">
                        <a href="#" id="delbtn" class="easyui-linkbutton" plain="true" iconCls="icon-remove" style="width:80px">删除</a>
                    </c:if>
                </td>
            </tr>
        </table>

    </div>
        <!--托运信息展示-->
    <div data-options="region:'center'" style="padding:5px;background:#eee;width:100%;height: auto;">
            <table id="lookleaveSchoolData"></table>
    </div>

</div>
</body>
</html>
