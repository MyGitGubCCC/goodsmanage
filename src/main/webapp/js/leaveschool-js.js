$(function (){
    /*//查询事件
     $("#findbtn").click(function () {
     //获取输入框的内容
     var snoSearch = $("input[name='snoSearch']").val();
     $('#goodsoutdata').datagrid("load", {"sno":snoSearch});
     });*/
    //清除查询框内容
    $("#delbtn").click(function(){
        $("#snoSearch").textbox('setValue','');
        //光标默认定位到搜索框
        $('#snoSearch').textbox('textbox').focus();
    });
    //添加点击事件，打开添加的dialog
    $("#addbtn").click(function(){
        addgoods();
    });

    //弹出框关闭事件，清空弹出框呢内容
    $("#dlg").dialog({
        onClose: function () {
            $('#fm').form('clear');
            //光标默认定位到搜索框
            $('#snoSearch').textbox('textbox').focus();
        }
    });

    //输入框回车事件
    $('#snoSearch').textbox('textbox').keydown(function (e) {
        if (e.keyCode == 13) {
            addgoods();
        }
    });

    //光标默认定位到搜索框
    $('#snoSearch').textbox('textbox').focus();

    $('#leaveSchoolData').datagrid({
        url : 'selectAllLeaveSchool.action',
        queryParams:{},//第一次加载时选择所有基地和所有材料
        idField:'leaveschoolid',
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
                field : 'leaveschoolid',title : '编号',halign:'center', hidden:true
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
                    if (row.student.building!=null && row.student.dormitory!=null){
                        return row.student.building.buildingno+row.student.dormitory.dormitoryno;
                    } else {
                        return value;
                    }
                }
            },
            {
                field:'homeadress',title:'家庭住址', halign:'center',width:240,
                formatter: function(value,row,index){
                    if (row.student){
                        return row.student.homeadress;
                    } else {
                        return value;
                    }
                }
            },
            {
                field : 'leavetime', title : '离校时间',halign:'center',width : 160,
            },
            {
                field : 'backtime', title : '回校时间',halign:'center',width : 160,
            },
            {
                field : 'remark', title : '备注',halign:'center',width : 200,
            }
        ]]
    });

})
function leaveSchool() {
    leaveOrBackShool("leaveSchool.action");
}
function backSchool() {
    leaveOrBackShool("backSchool.action");
}
function leaveOrBackShool(action) {

    $.messager.confirm('提示消息', '确定提交?', function(r){
        if (r){
            $.messager.progress();	// display the progress bar
            $('#fm').form('submit', {
                //加了个?inorout=1,因为用的是同一个方法addAccessForGoodsOut，但是添加的是带入的
                url:action,
                onSubmit: function(){
                    var isValid = $(this).form('validate');
                    if (!isValid){
                        $.messager.progress('close');	// hide progress bar while the form is invalid
                    }
                    return isValid;	// return false will stop the form submission
                },
                success:function (data) {
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
                        $('#leaveSchoolData').datagrid('load');
                        //光标默认定位到搜索框
                        $('#snoSearch').textbox('textbox').focus();
                    }
                }
            });
        }
    });

}
function closeDialog() {
    $('#dlg').dialog('close');
    //光标默认定位到搜索框
    $('#snoSearch').textbox('textbox').focus();
}

function addgoods() {
    //获取输入框的内容
    var snoSearch = $("input[name='snoSearch']").val();
    $('#fm').form('load', 'selectStudent.action?sno='+snoSearch);
    //清空搜索框
    $("#snoSearch").textbox('setValue','');
    $('#dlg').dialog('open').dialog('setTitle','添加离校返校记录');
}

