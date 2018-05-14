<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8" pageEncoding="utf-8"  isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>学生信息展示</title>
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
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/student-js.js"></script>
    <!--引入EasyUI 图标文件-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.5.3/themes/icon.css" />
</head>
<body class="easyui-layout">
<div region="center" fit="true" title="学生信息展示" >
    <div id="tb">
        <%--以下table为查询条件--%>
        <table>
            <tr>
                <td>学号：</td>
                <td><input class="easyui-textbox" prompt="模糊查询..." name="sno" id="sno" style="width:150px;"/></td>
                <td>校园卡号：</td>
                <td><input class="easyui-textbox" name="cardno" id="cardno" style="width:150px;"/></td>
                <td>姓名：</td>
                <td><input class="easyui-textbox" prompt="模糊查询..." name="sname" id="sname" style="width:150px;"/></td>
            </tr>
            <tr>
                <td>性别：</td>
                <td><select class="easyui-combobox" name="ssex" id="ssex" style="width:150px;">
                    <option value="">不区分</option>
                    <option value="男">男</option>
                    <option value="女">女</option></select></td>
                <td>电话号码：</td>
                <td><input class="easyui-textbox" prompt="模糊查询..." name="sphoneno" id="sphoneno" style="width:150px;"/></td>
                <td>家庭住址：</td>
                <td><input class="easyui-textbox" prompt="模糊查询..." name="homeadress" id="homeadress" style="width:150px;"/></td>
            </tr>
            <tr>
                <td>校区：</td>
                <td><input class="easyui-combobox"
                           name="campusid" id="campusid"
                           style="width:150px;"
                           data-options="
					url:'selectAllCampus.action',
					method:'get',
					valueField:'campusid',
					textField:'campusname',
					panelHeight:'auto',
					onSelect: function(rec){
                        var url = 'selectAcademyByCampusid.action?campusid='+rec.campusid;
                        $('#academyid').combobox('reload', url);
                    }
                    "></td>
                <td>学院：</td>
                <td><input class="easyui-combobox" name="academyid" id="academyid" style="width:150px;"
                                 data-options="
					method:'get',
					valueField:'academyid',
					textField:'academyname',
					panelHeight:'auto',
					onSelect: function(rec){
                        var url = 'selectClassinfoByAcademyid.action?academyid='+rec.academyid;
                        $('#classid').combobox('reload', url);
                    }
			"></td>
                <td>班级：</td>
                <td><input class="easyui-combobox" name="classid" id="classid" style="width:150px;"
                           data-options="
					method:'get',
					valueField:'classid',
					textField:'classname',
					panelHeight:'auto'
			"></td>
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
                <td>床位号：</td>
                <td><select class="easyui-combobox" name="bedno" id="bedno" style="width:150px;">
                    <option value="">不区分</option>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                    <option value="6">6</option></select></td>
            </tr>
        </table>
        <a href="#" id="findbtn" class="easyui-linkbutton" plain="true" data-options="iconCls:'icon-search'" style="width:100px">查询</a>
        <a href="#" id="delbtn" class="easyui-linkbutton" plain="true" iconCls="icon-cancel" style="width:100px">清除查询框</a>
    </div>
        <!--学生信息展示-->
    <div data-options="region:'center'" style="padding:5px;background:#eee;width:100%;height: auto;">
            <table id="studentData"></table>
    </div>

</div>
</body>
</html>
