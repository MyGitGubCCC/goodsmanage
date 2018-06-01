<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8" pageEncoding="utf-8"  isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>个人信息</title>
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
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/personinfo-js.js"></script>
    <!--引入EasyUI 图标文件-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.5.3/themes/icon.css" />
</head>
<body class="easyui-layout">
<div region="center" fit="true" title="个人信息" >
    <input class="easyui-textbox" name="snoSearch" id="snoSearch" value="${number}" type="hidden" name="sid" >
    <p style="font-size: 30px;color: #6293BB" align="center">蓝色标签可修改！！！</p>
   <%-- <div id="tb" region="center">
        学号：<input class="easyui-textbox" name="snoSearch" id="snoSearch" style="width:150px;height:32px"/>
        <a href="#" id="findbtn" class="easyui-linkbutton" plain="true" data-options="iconCls:'icon-search'" style="width:80px">查询</a>
        <a href="#" id="delbtn" class="easyui-linkbutton" plain="true" iconCls="icon-cancel" style="width:80px">清除</a>
    </div>--%>
        <!--个人信息-->
    <div align="center">
        <div class="easyui-panel" title="完善个人信息"  style="width:400px;">
            <div style="padding:10px 60px 20px 60px">
                <form id="ff" class="easyui-form" method="post" >
                    <table cellpadding="5">
                        <input class="easyui-textbox" type="hidden" name="sid" >
                        <tr>
                            <td>姓名:</td>
                            <td><input class="easyui-textbox" type="text" name="sname" data-options="readonly:true"></td>
                        </tr>
                        <tr>
                            <td>学号:</td>
                            <td><input class="easyui-numberbox" type="text" name="sno" data-options="readonly:true"></td>
                        </tr>
                        <tr>
                            <td>校园卡号:</td>
                            <td><input class="easyui-numberbox" type="text" name="cardno" data-options="readonly:true"/></td>
                        </tr>
                        <tr>
                            <td>性别:</td>
                            <td><input class="easyui-textbox" type="text" name="ssex" data-options="readonly:true"></td>
                        </tr>
                        <tr>
                            <td><p style="color: #6293BB;font-weight:bold">电话:</p></td>
                            <td><input class="easyui-numberbox" type="text" name="sphoneno" data-options="required:true"></td>
                        </tr>
                        <tr>
                            <td><p style="color: #6293BB;font-weight:bold">QQ:</p></td>
                            <td><input class="easyui-numberbox" type="text" name="qq" data-options="required:true"></td>
                        </tr>
                        <tr>
                            <td>班级:</td>
                            <td><input class="easyui-combobox"  name="classid"  data-options="url:'selectAllClassinfo.action',
					                            method:'get',
					                        valueField:'classid',
				                              textField:'classname',
					                        panelHeight:'auto',

					                        readonly:true
			                                  "></td>
                        </tr>
                        <tr>
                            <td>楼号:</td>
                            <td><input class="easyui-combobox" name="buildingid" data-options="url:'selectAllBuilding.action',
					                            method:'get',
					                        valueField:'buildingid',
				                              textField:'buildingno',
					                        panelHeight:'auto',
					                        readonly:true"></td>
                        </tr>
                        <tr>
                            <td>宿舍号:</td>
                            <td><input class="easyui-combobox"
                                       name="dormitoryid"
                                       data-options="url:'selectAllDormitory.action',
					                            method:'get',
					                        valueField:'dormitoryid',
				                              textField:'dormitoryno',
					                        panelHeight:'auto',
					                        readonly:true
			                                  "></td>
                        </tr>
                        <tr>
                            <td>床位号:</td>
                            <td><select class="easyui-combobox" name="bedno" readonly="true" style="width:147px;">
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option></select></td>
                        </tr>
                        <tr>
                            <td><p style="color: #6293BB;font-weight:bold">家庭住址:</p></td>
                            <td><input class="easyui-textbox" name="homeadress" data-options="multiline:true,required:true" style="height:60px"></td>
                        </tr>
                    </table>
                </form>
                <div style="text-align:center;padding:5px">
                    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="submitForm()">提交</a>
                </div>
            </div>
        </div>
    </div>

</div>

</body>
</html>
