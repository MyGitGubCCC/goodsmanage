$(function (){
    //查询事件
    $("#findbtn").click(function () {
        //获取两个输入框的内容
        var sno = $("input[name='snoSearch']").val();
        if(sno!=null && sno !=""){
            $.ajax({
                url:"selectStudent.action",
                type:"post",
                data: {
                    "sno": sno
                },
                dataType: 'json',
                success:function (data) {
                    $('#ff').form('load', data);
                },error : function() {
                    $.messager.alert('提示消息','学号输入错误！');
                },
            })
        }else{
            $.messager.alert('提示消息','请先输入学号');
        }
    });

    //输入框回车事件
    $('#snoSearch').textbox('textbox').keydown(function (e) {
        if (e.keyCode == 13) {
            $("#findbtn").click();
        }
    });

    //清除查询框内容
    $("#delbtn").click(function(){
        $("#snoSearch").textbox('setValue','');
        $('#ff').form('clear');
    });
})

function submitForm() {
    $.messager.confirm('提示消息', '确定提交?', function(r){
        if (r){
            $.messager.progress();	// display the progress bar
            $('#ff').form('submit', {
                url: "updateStudentByPrimaryKeySelective.action",
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
                    }
                }
            });
        }
    });
}
function clearForm(){
    $('#ff').form('clear');
}

