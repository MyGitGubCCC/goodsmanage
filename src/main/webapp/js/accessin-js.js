$(function (){
    //查询事件
    $("#findbtn").click(function () {
        //获取两个输入框的内容
        var sno = $("input[name='sno']").val();
        var sname = $("input[name='sname']").val();
        var goodsname = $("input[name='goodsname']").val();
        var buildingid= $("input[name='buildingid']").val();
        var dormitoryid= $("input[name='dormitoryid']").val();
        var inorout = $('#inorout').val();
        var starttime = $("input[name='starttime']").val();
        var endtime = $("input[name='endtime']").val();
        var timesort = $('#timesort').val();
        $('#datagriddata').datagrid("load", {"sno":sno,"sname":sname,"goodsname":goodsname,
            "buildingid":buildingid,"dormitoryid":dormitoryid,"inorout":inorout,
            "starttime":starttime,"endtime":endtime,"timesort":timesort});
    });
    //清除查询框内容
    $("#clearbtn").click(function(){
        $("#searchTable").form("clear");
    });

    $("#delbtn").click(function(){
        //返回选中多行
        var selRow = $('#datagriddata').datagrid('getSelections')
        //判断是否选中行
        if (selRow.length==0) {
            $.messager.alert("提示", "请选择要删除的行！", "info");
            return;
        }else{
            var temID="";
            //批量获取选中行的评估模板ID
            for (i = 0; i < selRow.length;i++) {
                if (temID =="") {
                    temID = selRow[i].accessid;
                } else {
                    temID = selRow[i].accessid + "," + temID;
                }
            }
            $.messager.confirm('提示', '是否删除选中数据?', function (r) {
                if (!r) {
                    return;
                }
                //提交
                $.ajax({
                    type: "POST",
                    async: false,
                    url: "delAccess.action?temID=" + temID,
                    data: temID,
                    success: function (data) {
                        var data = eval('(' + data + ')'); // change the JSON string to javascript object
                        if (data.success){
                            $.messager.show({
                                title:'操作结果',
                                msg:data.msg,
                                showType:'show'
                            });
                            $.messager.progress('close');
                            $('#datagriddata').datagrid('clearSelections');
                            $('#datagriddata').datagrid('reload');
                        }
                    }
                });
            });

        }
    });

    $('#datagriddata').datagrid({
        url : 'accesslist.action',
        queryParams:{"sno":"","sname":"",goodsname:"",
            "buildingid":0,"dormitoryid":0,"inorout":-1,
            "starttime":"","endtime":"","timesort":0},//第一次加载时选择所有基地和所有材料
        idField:'accessid',
        iconCls : 'icon-man',
        striped : true,
        rownumbers : true,
        singleSelect : false,
        selectOnCheck: true,//true勾选会选择行，false勾选不选择行, 1.3以后有此选项。重点在这里
        checkOnSelect: true, //true选择行勾选，false选择行不勾选, 1.3以后有此选项
        fitColumns : false,
        pagination: true,
        pageSize:20,
        pageList:[10,20,30,40],
        loadMsg:'正在加载资源文档信息...',
        emptyMsg:'没有检索到资源文档信息',
        //下面的field要与实体类中的属性名对应，要显示那个给那个
        columns : [[
            { field: 'ck', checkbox: true, width: '30' },  //复选框
            {
                field : 'accessid',title : '编号',halign:'center', hidden:true
            },
            {
                field:'sname',title:'学生姓名', halign:'center',width:80,
                formatter: function(value,row,index){
                    if (row.goods){
                        return row.goods.student.sname;
                    } else {
                        return value;
                    }
                }
            },
            {
                field:'sno',title:'学号', halign:'center',width:140,
                formatter: function(value,row,index){
                    if (row.goods){
                        return row.goods.student.sno;
                    } else {
                        return value;
                    }
                }
            },
            {
                field:'buildingnoAndDormitoryno',title:'宿舍号', halign:'center',width:100,
                formatter: function(value,row,index){
                    if (row.goods){
                        return row.goods.student.building.buildingno+row.goods.student.dormitory.dormitoryno;
                    } else {
                        return value;
                    }
                }
            },
            {
                field:'goodsname',title:'物品名称', halign:'center',width:100,
                formatter: function(value,row,index){
                    if (row.goods){
                        return row.goods.goodsname;
                    } else {
                        return value;
                    }
                }
            },
            {
                field:'goodscolor',title:'颜色', halign:'center',width:100,
                formatter: function(value,row,index){
                    if (row.goods){
                        return row.goods.goodscolor;
                    } else {
                        return value;
                    }
                }
            },
            {
                field : 'time', title : '带出时间',halign:'center',width : 160,
            },
            {
                field : 'remark', title : '备注',halign:'center',width : 200,
            }
        ]]
    });

})
