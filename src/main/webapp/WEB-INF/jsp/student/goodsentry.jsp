<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8" pageEncoding="utf-8"  isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>贵重物品信息录入</title>
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
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/goodsentry-js.js"></script>
    <!--引入EasyUI 图标文件-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.5.3/themes/icon.css" />
</head>
<body class="easyui-layout">
<div region="center" fit="true" title="贵重物品信息录入" >
    <div id="tb">
        <c:set value="${role}" var="role" property=""/>
        <c:if test="${role != '学生'}">
            学号或卡号：<input class="easyui-numberbox" name="snoSearch" id="snoSearch" style="width:150px;"/>
            <a href="#" id="findbtn" class="easyui-linkbutton" plain="true" data-options="iconCls:'icon-search'" style="width:80px">查询</a>
            <a href="#" id="clearbtn" class="easyui-linkbutton" plain="true" iconCls="icon-cancel" style="width:80px">清除</a>
            <a href="#" id="addbtn" class="easyui-linkbutton" plain="true" iconCls="icon-add" style="width:80px">添加</a>
            <a href="#" id="delbtn" class="easyui-linkbutton" plain="true" iconCls="icon-remove" style="width:80px">删除</a>
        </c:if>
        <a href="#" id="editbtn" class="easyui-linkbutton" plain="true" iconCls="icon-search" style="width:100px">查看图片</a>
        <a href="#" id="addPictureBtn" class="easyui-linkbutton" plain="true" iconCls="icon-add" style="width:100px">上传图片</a>
    </div>
    <%--<br>
    姓名：&emsp;&emsp;&emsp;<input class="easyui-textbox" name="sname" id="sname" style="width:150px;height:32px"/>
    &emsp;&emsp;宿舍号：<input class="easyui-textbox" name="dormitory" id="dormitory" style="width:150px;height:32px"/>
    <br>--%>
        <!--托运信息展示-->
    <div data-options="region:'center'" style="padding:5px;background:#eee;width:100%;height: auto;">
            <table id="goodsData"></table>
    </div>

</div>
<!--这是一个弹出窗口easyui-dialog，我在它里面放了一个datagrid-->
<div id="dlg" class="easyui-dialog" style="width: 340px; height: auto; padding: 10px 20px"
     data-options="closed:true,buttons:'#dlg-buttons'">
    <form id="fm" method="post" enctype="multipart/form-data" >
        <table id="datagrid" style="width:auto;height:200px">
            <input type="hidden" readonly="readonly" required="true" name="goodsid" id="goodsid" value=""/>
            <tr id="snotr">
                <td >学号或卡号：</td>
                <td>
                    <input class="easyui-numberbox"  name="sno" id="sno" data-options="required:true" value=""/>
                </td>
            </tr>
            <tr>
                <td >物品名称：</td>
                <td>
                    <input class="easyui-textbox"  name="goodsname" id="goodsname" data-options="required:true"/>
                </td>
            </tr>
            <tr>
                <td >颜色：</td>
                <td>
                    <input class="easyui-textbox" name="goodscolor" id="goodscolor"  value="" data-options="required:true"/>
                </td>
            </tr>
            <tr>
                <td >图片上传：</td>
                <td>
                    <input class="easyui-filebox" id="file_upload" name="file_upload2" data-options="prompt:'Choose another file...',
                                                                                    onChange:change_photo" style="width:100%">
                </td>
            </tr>
        </table>
    </form>
    <div id="Imgdiv">
        <img id="Img" width="300px" height="200px"/>
    </div>
</div>
<div id="dlg-buttons">
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="saveUser()">保存</a>
    <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="closeDialog()">关闭</a>
</div>

<--图片预览dialog-->
<div id="pictureDlg" class="easyui-dialog" title="图片预览" data-options="closed:true" style="width:600px;height:430px;padding:10px">
    <img id="pictureImg" src="" width="550px" height="370px"/>
</div>
</body>
<script>
    function change_photo(){
        PreviewImage($("input[name='file_upload2']")[0], 'Img', 'Imgdiv');
    }
    function PreviewImage(fileObj,imgPreviewId,divPreviewId){
        var allowExtention=".jpg,.bmp,.gif,.png";//允许上传文件的后缀名document.getElementById("hfAllowPicSuffix").value;
        var extention=fileObj.value.substring(fileObj.value.lastIndexOf(".")+1).toLowerCase();
        var browserVersion= window.navigator.userAgent.toUpperCase();
        if (extention!="" && extention!=null){
            if(allowExtention.indexOf(extention)>-1){
                if(fileObj.files){//HTML5实现预览，兼容chrome、火狐7+等
                    if(window.FileReader){
                        var reader = new FileReader();
                        reader.onload = function(e){
                            document.getElementById(imgPreviewId).setAttribute("src",e.target.result);
                        }
                        reader.readAsDataURL(fileObj.files[0]);
                    }else if(browserVersion.indexOf("SAFARI")>-1){
                        alert("不支持Safari6.0以下浏览器的图片预览!");
                    }
                }else if (browserVersion.indexOf("MSIE")>-1){
                    if(browserVersion.indexOf("MSIE 6")>-1){//ie6
                        document.getElementById(imgPreviewId).setAttribute("src",fileObj.value);
                    }else{//ie[7-9]
                        fileObj.select();
                        if(browserVersion.indexOf("MSIE 9")>-1)
                            fileObj.blur();//不加上document.selection.createRange().text在ie9会拒绝访问
                        var newPreview =document.getElementById(divPreviewId+"New");
                        if(newPreview==null){
                            newPreview =document.createElement("div");
                            newPreview.setAttribute("id",divPreviewId+"New");
                            newPreview.style.width = document.getElementById(imgPreviewId).width+"px";
                            newPreview.style.height = document.getElementById(imgPreviewId).height+"px";
                            newPreview.style.border="solid 1px #d2e2e2";
                        }
                        newPreview.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='scale',src='" + document.selection.createRange().text + "')";
                        var tempDivPreview=document.getElementById(divPreviewId);
                        tempDivPreview.parentNode.insertBefore(newPreview,tempDivPreview);
                        tempDivPreview.style.display="none";
                    }
                }else if(browserVersion.indexOf("FIREFOX")>-1){//firefox
                    var firefoxVersion= parseFloat(browserVersion.toLowerCase().match(/firefox\/([\d.]+)/)[1]);
                    if(firefoxVersion<7){//firefox7以下版本
                        document.getElementById(imgPreviewId).setAttribute("src",fileObj.files[0].getAsDataURL());
                    }else{//firefox7.0+
                        document.getElementById(imgPreviewId).setAttribute("src",window.URL.createObjectURL(fileObj.files[0]));
                    }
                }else{
                    document.getElementById(imgPreviewId).setAttribute("src",fileObj.value);
                }
            }else{
                alert("仅支持"+allowExtention+"为后缀名的文件!");
                //fileObj.value="";//清空选中文件
                $('#file_upload').filebox('clear');
                if(browserVersion.indexOf("MSIE")>-1){
                    fileObj.select();
                    document.selection.clear();
                }
                fileObj.outerHTML=fileObj.outerHTML;
            }
        }

    }
</script>
</html>
