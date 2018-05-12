$(function (){
    //查询事件
     $("#findbtn").click(function () {
     //获取输入框的内容
         var sno= $("input[name='sno']").val();
         var buildingid= $("input[name='buildingid']").val();
         var dormitoryid= $("input[name='dormitoryid']").val();
         var sname= $("input[name='sname']").val();
         var leavestarttime= $("input[name='leavestarttime']").val();
         var leaveendtime= $("input[name='leaveendtime']").val();
         var homeadress= $("input[name='homeadress']").val();
         var backstarttime= $("input[name='backstarttime']").val();
         var backendtime= $("input[name='backendtime']").val();
         var notBackSchool = $('#notBackSchool').val();
         var timesort = $('#timesort').val();
     $('#lookleaveSchoolData').datagrid("load", {"sno":sno,"buildingid":buildingid,"dormitoryid":dormitoryid,
     "sname":sname,"leavestarttime":leavestarttime,"leaveendtime":leaveendtime,
     "homeadress":homeadress,"backstarttime":backstarttime,"backendtime":backendtime,"notbackschool":notBackSchool,"timesort":timesort});
     });
    //清除查询框内容
    $("#clearbtn").click(function(){
        $("#searchTable").form("clear");
    });

    $("#notBackSchool").combobox({
        onChange: function (newVal,oldVal) {
                // var index =  $("#notbackhome").combobox("getValue");
                 //alert(newVal);
                  if (newVal == 0) {
                      $('#backstarttime').datetimebox('enable');
                      $('#backendtime').datetimebox('enable');
                        } else {
                      $('#backstarttime').datetimebox('disable');
                      $('#backendtime').datetimebox('disable');
                       }
                }
       })
    $("#delbtn").click(function(){
        //返回选中多行
        var selRow = $('#lookleaveSchoolData').datagrid('getSelections')
        //判断是否选中行
        if (selRow.length==0) {
            $.messager.alert("提示", "请选择要删除的行！", "info");
            return;
        }else{
            var temID="";
            //批量获取选中行的评估模板ID
            for (i = 0; i < selRow.length;i++) {
                if (temID =="") {
                    temID = selRow[i].leaveschoolid;
                } else {
                    temID = selRow[i].leaveschoolid + "," + temID;
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
                    url: "delLeaveSchool.action",
                    data: {"temID":temID},
                    success: function (data) {
                        var data = eval('(' + data + ')'); // change the JSON string to javascript object
                        if (data.success){
                            $.messager.show({
                                title:'操作结果',
                                msg:data.msg,
                                showType:'show'
                            });
                            $.messager.progress('close');
                            $('#lookleaveSchoolData').datagrid('clearSelections');
                            $('#lookleaveSchoolData').datagrid('reload');
                        }
                    }
                });
            });

        }
    });

    $('#lookleaveSchoolData').datagrid({
        url : 'selectLeaveSchool.action',
        queryParams:{"sno":"","buildingid":0,"dormitoryid":0,
            "sname":"","leavestarttime":"","leaveendtime":"",
            "homeadress":"","backstarttime":"","backendtime":"","notbackschool":0,"timesort":0},//第一次加载时选择所有基地和所有材料
        idField:'leaveschoolid',
        iconCls : 'icon-man',
        striped : true,
        rownumbers : true,
        singleSelect : false,
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


