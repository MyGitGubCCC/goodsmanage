<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8" pageEncoding="utf-8"  isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <!-- 避免IE使用兼容模式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
    <meta name="renderer" content="webkit">
    <meta name="keywords" content='easyui,jui,jquery easyui,easyui demo,easyui中文'/>
    <meta name="description" content='TopJUI前端框架，基于最新版EasyUI前端框架构建，纯HTML调用功能组件，不用写JS代码的EasyUI，专注你的后端业务开发！'/>
    <title>贵重物品出入管理系统</title>
    <!-- 浏览器标签图片 -->
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/topjui/image/favicon.ico"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/plugins/font-awesome/css/font-awesome.min.css">
    <style type="text/css">
        html, body {
            height: 100%;
        }

        .box {
            background: url("${pageContext.request.contextPath}/topjui/image/loginBg.jpg") no-repeat center center;
            background-size: cover;

            margin: 0 auto;
            position: relative;
            width: 100%;
            height: 100%;
        }

        .login-box {
            width: 100%;
            max-width: 500px;
            height: 400px;
            position: absolute;
            top: 50%;

            margin-top: -200px;
            /*设置负值，为要定位子盒子的一半高度*/

        }

        @media screen and (min-width: 500px) {
            .login-box {
                left: 50%;
                /*设置负值，为要定位子盒子的一半宽度*/
                margin-left: -250px;
            }
        }

        .form {
            width: 100%;
            max-width: 500px;
            height: 275px;
            margin: 2px auto 0px auto;
        }

        .login-content {
            border-bottom-left-radius: 8px;
            border-bottom-right-radius: 8px;
            height: 250px;
            width: 100%;
            max-width: 500px;
            background-color: rgba(255, 250, 2550, .6);
            float: left;
        }

        .input-group {
            margin: 30px 0px 0px 0px !important;
        }

        .form-control,
        .input-group {
            height: 40px;
        }

        .form-actions {
            margin-top: 30px;
        }

        .form-group {
            margin-bottom: 0px !important;
        }

        .login-title {
            border-top-left-radius: 8px;
            border-top-right-radius: 8px;
            padding: 20px 10px;
            background-color: rgba(0, 0, 0, .6);
        }

        .login-title h1 {
            margin-top: 10px !important;
        }

        .login-title small {
            color: #fff;
        }

        .link p {
            line-height: 20px;
            margin-top: 30px;
        }

        .btn-sm {
            padding: 8px 24px !important;
            font-size: 16px !important;
        }

        .flag {
            position: absolute;
            top: 10px;
            right: 10px;
            color: #fff;
            font-weight: bold;
            font: 14px/normal "microsoft yahei", "Times New Roman", "宋体", Times, serif;
        }
    </style>
    <title>${config_siteConfig.cfgCompanyName}</title>
</head>
<body>
<div class="box">
    <div class="login-box">
        <div class="login-title text-center">
            <span class="flag"><i class="fa fa-user"></i> 用户登陆</span>
            <h1>
                <small>贵重物品出入管理系统</small>
            </h1>
        </div>
        <div class="login-content ">
            <div class="form">
                <form id="modifyPassword" class="form-horizontal" action="#" method="post">
                    <div class="form-group">
                        <div class="col-xs-10 col-xs-offset-1">
                            <div class="input-group">
                                <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                                <input type="text" id="username" name="username" class="form-control" placeholder="账号"
                                       value="">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-10 col-xs-offset-1">
                            <div class="input-group">
                                <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                                <input type="password" id="password" name="password" class="form-control"
                                       placeholder="密码" value="">
                            </div>
                        </div>
                    </div>
                    <div class="form-group form-actions">
                        <div class="col-xs-12 text-center">
                            <button type="button" id="login" class="btn btn-sm btn-success">
                                <span class="fa fa-check-circle"></span> 登录
                            </button>
                            <button type="button" id="reset" class="btn btn-sm btn-danger">
                                <span class="fa fa-close"></span> 重置
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog modal-sm" role="document">
        <div class="modal-content">
            <div class="modal-body">
                <span class="text-danger"><i class="fa fa-warning"></i> 账号或密码错误，请重试！</span>
            </div>
        </div>
    </div>
</div>

<!-- 引入jQuery -->
<script src="${pageContext.request.contextPath}/static/plugins/jquery/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/static/plugins/jquery/jquery.cookie.js"></script>
<script src="${pageContext.request.contextPath}/static/plugins/bootstrap/js/bootstrap.min.js"></script>
<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
<script src="${pageContext.request.contextPath}/static/plugins/bootstrap/plugins/html5shiv.min.js"></script>
<script src="${pageContext.request.contextPath}/static/plugins/bootstrap/plugins/respond.min.js"></script>
<![endif]-->
<script type="text/javascript">
    if (navigator.appName == "Microsoft Internet Explorer" &&
        (navigator.appVersion.split(";")[1].replace(/[ ]/g, "") == "MSIE6.0" ||
        navigator.appVersion.split(";")[1].replace(/[ ]/g, "") == "MSIE7.0" ||
        navigator.appVersion.split(";")[1].replace(/[ ]/g, "") == "MSIE8.0")
    ) {
        alert("您的浏览器版本过低，请使用360安全浏览器的极速模式或IE9.0以上版本的浏览器");
    }
</script>
<script>
    var _hmt = _hmt || [];
    (function () {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?71559c3bdac3e45bebab67a5a841c70e";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();
</script>
<script type="text/javascript">
    $(function () {

        $('#password').keyup(function (event) {
            if (event.keyCode == "13") {
                $("#login").trigger("click");
                return false;
            }
        });

        $("#login").on("click", function () {
            submitForm();
        });

        function submitForm() {
            if (navigator.appName == "Microsoft Internet Explorer" &&
                (navigator.appVersion.split(";")[1].replace(/[ ]/g, "") == "MSIE6.0" ||
                navigator.appVersion.split(";")[1].replace(/[ ]/g, "") == "MSIE7.0" ||
                navigator.appVersion.split(";")[1].replace(/[ ]/g, "") == "MSIE8.0")
            ) {
                alert("您的浏览器版本过低，请使用360安全浏览器的极速模式或IE9.0以上版本的浏览器");
            } else {
               // window.location.href = './tradeOrderMain.action';
               $.ajax({
                   url:"loginJudge.action",
                   type:"post",
                   data: {
                       "username": $('#username').val(),
                       "password": $('#password').val()
                   },
                   dataType: 'json',
                    success: function (data) {

                       //ajax提交之后还会回到原页面，用form提交就可以直接传参，实现页面跳转
                        if (data.name!= null) {
/*
                            var f  = document.createElement("form"); // 创建 HTML 表单元素，必须是form
                            document.body.appendChild(f);// 界面body元素追加一个 form
                            var input1  = document.createElement("input");// 追加一个 input 用于传递参数
                            input1.type  = "hidden";  // 等同于setAttribute("type","hidden");
                            input1.value = data.name;
                            input1.name  = "name";
                            f.appendChild(input1);
                            // 第二个input
                            var input2 = document.createElement("input");// 追加一个 input 用于传递参数
                            input2.type = "hidden";  // 等同于setAttribute("type","hidden");
                            input2.value = data.role;
                            input2.name  = "role";
                            f.appendChild(input2);

                            var input3 = document.createElement("input");// 追加一个 input 用于传递参数
                            input3.type = "hidden";  // 等同于setAttribute("type","hidden");
                            input3.value = data.number;
                            input3.name  = "number";
                            f.appendChild(input3);

                            f.action = "./goodsmanage.action";
                            f.method = "POST";
                            //f.target = "_blank";
                            f.submit();*/
                            /*$.ajax({
                                url:"tradeOrderMain.action",
                                type:"post",
                                data: {
                                    "name": data.name
                                },
                                dataType: 'json'
                            })*/
                            location.href = 'goodsmanage.action';
                        }else{
                            $('#myModal').modal();
                        }
                    },
                    error: function () {

                    }
                });
            }
        }

        $("#reset").on("click", function () {
            $("#username").val("");
            $("#password").val("");
        });
    });
</script>
</body>
</html>