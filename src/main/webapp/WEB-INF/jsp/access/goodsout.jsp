<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8" pageEncoding="utf-8"  isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>物品外出记录</title>
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
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/goodsout-js.js"></script>
    <!--引入EasyUI 图标文件-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.5.3/themes/icon.css" />
</head>
<body class="easyui-layout">
<div region="center" fit="true" title="物品外出记录" >
    <div id="tb">
        学号或卡号：<input class="easyui-numberbox" name="snoSearch" id="snoSearch" style="width:150px;"/>
        <a href="#" id="addbtn" class="easyui-linkbutton" plain="true" iconCls="icon-add" style="width:80px">添加</a>
      <%--  <a href="#" id="findbtn" class="easyui-linkbutton" plain="true" data-options="iconCls:'icon-search'" style="width:80px">查询</a>--%>
        <a href="#" id="delbtn" class="easyui-linkbutton" plain="true" iconCls="icon-cancel" style="width:80px">清除</a>

    </div>
        <!--托运信息展示-->
    <div data-options="region:'center'" style="padding:5px;background:#eee;width:100%;height: auto;">
            <table id="goodsoutdata" data-options="rowStyler: function(index,row){
					if (index == 0){
						return 'background-color:#6293BB;color:#fff;font-weight:bold';
					}
				}"></table>
    </div>

</div>
<div id="dlg" class="easyui-dialog" style="width: 340px; height: auto; padding: 10px 20px"
     data-options="closed:true,buttons:'#dlg-buttons'">
    <form id="fm" method="post">
        <table id="datagrid" style="width:auto;height:200px">
            <tr>
                <td >姓名：</td>
                <td>
                    <input class="easyui-textbox" readonly="true" name="sname" id="sname" value=""/>
                </td>
                </td>
            </tr>
            <tr>
                <td >学号：</td>
                <td>
                    <input class="easyui-textbox" readonly="readonly" name="sno" id="sno" value=""/>
                </td>
            </tr>
            <tr>
                <td >宿舍号：</td>
                <td>
                    <input class="easyui-textbox" readonly="readonly" name="bandd" id="bandd" value=""/>
                </td>
            </tr>
            <tr>
                <td >选择物品：</td>
                <td>
                    <input id="goodsid" class="easyui-combobox" name="goodsid" required="true">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <img id="pictureImg" src="" width="300px" height="180px"/>
                </td>
            </tr>
            <tr>
                <td >备注：</td>
                <td>
                    <input class="easyui-textbox" name="remark" id="remark" data-options="prompt:'特殊情况在此备注...',multiline:true" style="height:60px">
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
</html>
