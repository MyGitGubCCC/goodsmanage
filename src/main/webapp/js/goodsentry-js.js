$(function (){
    //查询事件
    $("#findbtn").click(function () {
        //获取两个输入框的内容
        var sno = $("input[name='snoSearch']").val();
        $('#goodsData').datagrid("load", {"sno":sno});
    });
    //清除查询框内容
    $("#clearbtn").click(function(){
        $("#snoSearch").textbox('setValue','');
    });
    //添加点击事件，打开添加的dialog
    $("#addbtn").click(function(){
        var sno = $("input[name='snoSearch']").val();
        $('#sno').textbox('setValue',sno);
        $('#dlg').dialog('open').dialog('setTitle','添加物品');
        $("#Img").attr('src',"/upload/img/noPicture.jpg");
    });

    //弹出框关闭事件，清空弹出框呢内容
    $("#dlg").dialog({
        onClose: function () {
            $('#fm').form('clear');
            //光标默认定位到搜索框
            $('#snoSearch').textbox('textbox').focus();
        }
    });

    $("#editbtn").click(function(){
        var row = $('#goodsData').datagrid('getSelected');
        if (row){
            $.ajax({
                url:"lookGoodsPicture.action",
                type:"post",
                data: {
                    "goodsid": row.goodsid
                },
                dataType: 'json',
                success:function (data) {
                    if (data!=null && data!=""){
                        $('#pictureDlg').dialog('open').dialog('setTitle','查看图片');
                        $("#pictureImg").attr('src',data);
                        /* $.messager.show({
                         title:'提示消息',
                         msg:data,
                         showType:'show'
                         });*/
                    }else{
                        $.messager.confirm('提示消息', '还未上传图片，是否上传？', function(r){
                            if (r){
                                $('#dlg').dialog('open').dialog('setTitle','上传图片');
                                $("#Img").attr('src',"/upload/img/noPicture.jpg");
                                $('#fm').form('load',{"goodsid":row.goodsid,
                                    "sno":row.student.sno,
                                    "goodsname":row.goodsname,
                                    "goodscolor":row.goodscolor});
                            }
                        });
                    }

                }
            })
        }else  $.messager.alert("提示", "请选择要查看的行！", "info");
    });

    $("#delbtn").click(function(){
        //返回选中多行
        var selRow = $('#goodsData').datagrid('getSelections');
        var index=$('#goodsData').datagrid('getRowIndex',selRow[0]);
        //判断是否选中行
        if (selRow.length==0) {
            $.messager.alert("提示", "请选择要删除的行！", "info");
            return;
        }else{
            var temID="";
            //批量获取选中行的评估模板ID
            for (i = 0; i < selRow.length;i++) {
                if (temID =="") {
                    temID = selRow[i].goodsid;
                } else {
                    temID = selRow[i].goodsid + "," + temID;
                }
            }
            $.messager.confirm('提示消息', '确定删除?', function(r){
                if (r){
                    $.ajax({
                        url:"deleteGoods.action",
                        type:"post",
                        data: {
                            "goodsid": temID
                        },
                        dataType: 'json',
                        success:function (data) {
                            $.messager.show({
                                title:'提示消息',
                                msg:data,
                                showType:'show'
                            });
                            $('#goodsData').datagrid('deleteRow',index);
                        }
                    })
                }
            });

        }
    });

    $('#goodsData').datagrid({
        url : 'selectGoodsBySno.action',
        queryParams:{"sno":""},//第一次加载时选择所有基地和所有材料
        idField:'goodsid',
        iconCls : 'icon-man',
        striped : true,
        rownumbers : true,
        singleSelect : true,
        fitColumns : false,
        pagination: true,
        pageSize:20,
        pageList:[10,20,30,40],
        loadMsg:'正在加载资源文档信息...',
        emptyMsg:'没有检索到资源文档信息',
        //下面的field要与实体类中的属性名对应，要显示那个给那个
        columns : [[
            {
                field : 'goodsid',title : '编号',halign:'center', hidden:true
            },
            {
                field:'sname',title:'学生姓名', halign:'center',width:80,
                formatter: function(value,row,index){
                    if (row.student){
                        return row.student.sname;
                    } else {
                        return value;
                    }
                }
            },
            {
                field:'sno',title:'学号', halign:'center',width:140,
                formatter: function(value,row,index){
                    if (row.student){
                        return row.student.sno;
                    } else {
                        return value;
                    }
                }
            },
            {
                field:'buildingnoAndDormitoryno',title:'宿舍号', halign:'center',width:100,
                formatter: function(value,row,index){
                    if (row.student){
                        return row.student.building.buildingno+row.student.dormitory.dormitoryno;
                    } else {
                        return value;
                    }
                }
            },
            {
                field:'goodsname',title:'物品名称', halign:'center',width:100,
            },
            {
                field:'goodscolor',title:'颜色', halign:'center',width:100,
            }/*,
            {
                field:"action",title:"操作", halign:'center',align:'center',width:160,
                formatter:function(value,row,index){
                    var e = '<a href="#" class="easyui-linkbutton" iconCls="icon-remove" onclick="lookPicture(\''+ index +'\')">查看图片</a>';
                    return e;
                }
            }*/
        ]]
    });
    $.parser.parse();

})
function closeDialog() {
    $('#fm').form('clear');
    $('#dlg').dialog('close');
}
function saveUser() {

    $.messager.confirm('提示消息', '确定提交?', function(r){
        if (r){
            $.messager.progress();	// display the progress bar
            $('#fm').form('submit', {
                type:"post",
                url: "insertOrUpdateGoods.action",
                onSubmit: function(){
                    var isValid = $(this).form('validate');
                    if (!isValid){
                        $.messager.progress('close');	// hide progress bar while the form is invalid
                    }
                    return isValid;	// return false will stop the form submission
                },
                success:function (data) {
                     /*$.messager.progress('close');
                     $.messager.alert('提示消息',data,'info');
                     $('#ff').form('clear');*/
                    var data = eval('(' + data + ')'); // change the JSON string to javascript object
                    if (data.success){
                        $.messager.show({
                            title:'操作结果',
                            msg:data.msg,
                            showType:'show'
                        });
                        $.messager.progress('close');
                        $('#dlg').dialog('close');
                        $('#fm').form('clear');
                        $('#goodsData').datagrid('load');
                    }
                }
            });
        }
    });
}
