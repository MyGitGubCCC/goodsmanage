$(function (){
    //查询事件
    $("#findbtn").click(function () {
        //获取两个输入框的内容
        var sno = $("input[name='snoSearch']").val();
        $('#ff').form('load', 'selectStudent.action?sno='+sno);
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

