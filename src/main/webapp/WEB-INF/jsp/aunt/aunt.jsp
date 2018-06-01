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
        <table id="searchTable">
            <tr>
                <td>
                    姓名：<input class="easyui-textbox" prompt="模糊查询..." name="auntnameSearch" id="auntnameSearch" style="width:150px;"/>
                    账号：<input class="easyui-textbox" prompt="模糊查询..." name="auntnoSearch" id="auntnoSearch" style="width:150px;"/>
                    电话号码：<input class="easyui-numberbox" prompt="模糊查询..." name="auntphonenoSearch" id="auntphonenoSearch" style="width:150px;"/>
                    管理楼号：<input class="easyui-combobox"
                                name="buildingidSearch" id="buildingidSearch"
                                data-options="
					url:'selectAllBuilding.action',
					method:'get',
					valueField:'buildingid',
					textField:'buildingno',
					panelMaxHeight:'600px',
					editable:false
			">
                </td>
            </tr>
        </table>
        <a href="#" id="findbtn" class="easyui-linkbutton" plain="true" data-options="iconCls:'icon-search'" style="width:80px">查询</a>
        <a href="#" id="clearbtn" class="easyui-linkbutton" plain="true" iconCls="icon-cancel" style="width:100px">清除查询框</a>
        <a href="#" id="editbtn" class="easyui-linkbutton" plain="true" iconCls="icon-edit" style="width:80px">修改</a>
        <a href="#" id="addbtn" class="easyui-linkbutton" plain="true" iconCls="icon-add" style="width:80px">添加</a>
        <a href="#" id="delbtn" class="easyui-linkbutton" plain="true" iconCls="icon-remove" style="width:80px">删除</a>
    </div>
        <!--学生信息展示-->
    <div data-options="region:'center'" style="padding:5px;background:#eee;width:100%;height: auto;">
            <table id="auntData"></table>
    </div>

</div>
<!--这是一个弹出窗口easyui-dialog，我在它里面放了一个datagrid-->
<div id="dlg" class="easyui-dialog" style="width: 340px; height: auto; padding: 10px 20px"
     data-options="closed:true,buttons:'#dlg-buttons'">
    <form id="fm" method="post" enctype="multipart/form-data" >
        <table id="datagrid" style="width:auto;height:200px">
            <input type="hidden" readonly="readonly" required="true" name="auntid" id="auntid" value=""/>
            <tr id="snotr">
                <td >姓名：</td>
                <td>
                    <input class="easyui-textbox"  name="auntname" id="auntname" data-options="required:true,validType:'length[1,10]'" value=""/>
                </td>
            </tr>
            <tr>
                <td >账号：</td>
                <td>
                    <input class="easyui-textbox" prompt="以AY开头，如：AY001" name="auntno" id="auntno" data-options="required:true,validType:'startAY'"/>
                </td>
            </tr>
            <tr>
                <td >密码：</td>
                <td>
                    <input class="easyui-textbox" name="auntpassword" id="auntpassword"  value="" data-options="required:true,validType:'length[4,10]'"/>
                </td>
            </tr>
            <tr>
                <td >电话号码：</td>
                <td>
                    <input class="easyui-numberbox" name="auntphoneno" id="auntphoneno"  value="" data-options="required:true"/>
                </td>
            </tr>
            <tr>
                <td >管理楼号：</td>
                <td>
                    <input class="easyui-combobox"
                           name="buildingid" id="buildingid"
                           data-options="
					url:'selectAllBuilding.action',
					method:'get',
					valueField:'buildingid',
					textField:'buildingno',
					panelMaxHeight:'600px',
					required:true,
					editable:false
			      ">
                </td>
            </tr>
        </table>
    </form>
</div>
<div id="dlg-buttons">
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="saveUser()">保存</a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="closeDialog()">关闭</a>
</div>
</body>
<script>
    $.extend($.fn.validatebox.defaults.rules, {
        startAY:{
            validator:function(value,param){
                var reg = /^[A][Y]\d+$/g;
                return reg.test(value);
            },
            message:  '必须以AY+数字形式！'
        }
    });
</script>
</html>
