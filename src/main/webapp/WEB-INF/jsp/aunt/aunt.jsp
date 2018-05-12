<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8" pageEncoding="utf-8"  isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>宿管信息展示</title>
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
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/aunt-js.js"></script>
    <!--引入EasyUI 图标文件-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.5.3/themes/icon.css" />
</head>
<body class="easyui-layout">
<div region="center" fit="true" title="宿管信息展示" >
    <div id="tb">
        <%--以下为查询条件--%>
        姓名：&emsp;&emsp;<input class="easyui-textbox" name="auntname" id="auntname" style="width:150px;height:32px"/>
        账号：<input class="easyui-textbox" name="auntno" id="auntno" style="width:150px;height:32px"/>
        电话号码：<input class="easyui-textbox" name="auntphoneno" id="auntphoneno" style="width:150px;height:32px"/>
        管理楼号：<input class="easyui-combobox"
                  name="buildingid" id="buildingid"
                  data-options="
					url:'selectAllBuilding.action',
					method:'get',
					valueField:'buildingid',
					textField:'buildingno',
					panelHeight:'auto'
			">
        <a href="#" id="findbtn" class="easyui-linkbutton" plain="true" data-options="iconCls:'icon-search'" style="width:80px">查询</a>
        <a href="#" id="delbtn" class="easyui-linkbutton" plain="true" iconCls="icon-cancel" style="width:80px">清除</a>
    </div>
        <!--学生信息展示-->
    <div data-options="region:'center'" style="padding:5px;background:#eee;width:100%;height: auto;">
            <table id="auntData"></table>
    </div>

</div>
</body>
</html>
