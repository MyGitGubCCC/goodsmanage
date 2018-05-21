$(function (){
    //查询事件
    $("#findbtn").click(function () {
        //获取输入框的内容
        var auntname = $("input[name='auntnameSearch']").val();
        var auntno = $("input[name='auntnoSearch']").val();
        var auntphoneno = $("input[name='auntphonenoSearch']").val();
        var buildingid = $("input[name='buildingidSearch']").val();

        $('#auntData').datagrid("load", {"auntname":auntname,"auntno":auntno,"auntphoneno":auntphoneno,
            "buildingid":buildingid});
    });
    //清除查询框内容
    $("#clearbtn").click(function(){
        $("#searchTable").form('clear');
    });
    //弹出框关闭事件，清空弹出框呢内容
    $("#dlg").dialog({
        onClose: function () {
            $("#fm").form('clear');
        }
    });
    //添加点击事件，打开添加的dialog
    $("#addbtn").click(function(){
        $('#dlg').dialog('open').dialog('setTitle','添加宿管');
    });

    $("#editbtn").click(function(){
        var row = $('#auntData').datagrid('getSelected');
        if (row){
                $('#dlg').dialog('open').dialog('setTitle','修改宿管信息');
                $('#fm').form('load',row);
        } else $.messager.alert("提示", "请选择要修改的行！", "info");
    });

    $("#delbtn").click(function(){
        //返回选中多行
        var row = $('#auntData').datagrid('getSelected');
        var index=$('#auntData').datagrid('getRowIndex',row);
       // alert(index);
        //判断是否选中行
        if (row==null) {
            $.messager.alert("提示", "请选择要删除的行！", "info");
            return;
        }else{
            $.messager.confirm('提示消息', '确定删除?', function(r){
                if (r){
                    $.ajax({
                        url:"deleteAunt.action",
                        type:"post",
                        data: {
                            "auntid": row.auntid
                        },
                        dataType: 'json',
                        success:function (data) {
                            $.messager.show({
                                title:'提示消息',
                                msg:data,
                                showType:'show'
                            });
                            $('#auntData').datagrid('deleteRow',index);
                        }
                    })
                }
            });

        }
    });

    $('#auntData').datagrid({
        url : 'selectAuntByExample.action',
        queryParams:{"auntname":null,"auntno":null,"auntphoneno":null,
            "buildingid":null},//第一次加载时选择所有基地和所有材料
        idField:'sid',
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
                field : 'auntid',title : '编号',halign:'center', hidden:true
            },
            {
                field:'auntname',title:'姓名', halign:'center',width:80,
            },
            {
                field:'auntno',title:'账号', halign:'center',width:140,
            },
            {
                field:'auntpassword',title:'密码', halign:'center',width:50,
            },
            {
                field:'auntphoneno',title:'电话号码', halign:'center',width:140,
            },
            {
                field:'buildingid',title:'管理楼号', halign:'center',width:80,
                formatter: function(value,row,index){
                    if (row.building){
                        return row.building.buildingno;
                    } else {
                        return value;
                    }
                }
            },
        ]]
    });

})
function saveUser() {

    $.messager.confirm('提示消息', '确定提交?', function(r){
        if (r){
            $.messager.progress();	// display the progress bar
            $('#fm').form('submit', {
                type:"post",
                url: "insertOrUpdateAunt.action",
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
                        $('#auntData').datagrid('load');
                    }
                }
            });
        }
    });
}
function closeDialog() {
    $('#fm').form('clear');
    $('#dlg').dialog('close');
}


