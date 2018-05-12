$(function (){
    //查询事件
    $("#findbtn").click(function () {
        searchStudent();
    });
    //清除查询框内容
    $("#delbtn").click(function(){
        $("#sno").textbox('setValue','');
        $("#cardno").textbox('setValue','');
        $("#sname").textbox('setValue','');
        $("#ssex").textbox('setValue','');
        $("#sphoneno").textbox('setValue','');
        $("#homeadress").textbox('setValue','');
        $("#campusid").textbox('setValue','');
        $("#academyid").textbox('setValue','');
        $("#classid").textbox('setValue','');
        $("#buildingid").textbox('setValue','');
        $("#dormitoryid").textbox('setValue','');
        $("#bedno").textbox('setValue','');
    });

    //输入框回车事件
    $('#cardno').textbox('textbox').keydown(function (e) {
        if (e.keyCode == 13) {
            searchStudent();
        }
    });

    $('#studentData').datagrid({
        url : 'selectStudentByExample.action',
        queryParams:{"sno":null,"cardno":null,"sname":null,"ssex":null,
            "sphoneno":null,"homeadress":null,"campusid":0,"academyid":0,"classid":null,
            "buildingid":null,"dormitoryid":null,"bedno":null},//第一次加载时选择所有基地和所有材料
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
                field : 'sid',title : '编号',halign:'center', hidden:true
            },
            {
                field:'sname',title:'学生姓名', halign:'center',width:80,
            },
            {
                field:'sno',title:'学号', halign:'center',width:140,
            },
            {
                field:'ssex',title:'性别', halign:'center',width:50,
            },
            {
                field:'sphoneno',title:'电话号码', halign:'center',width:110,
            },
            {
                field:'homeadress',title:'家庭住址', halign:'center',width:280,
            },
            {
                field:'classid',title:'班级', halign:'center',width:80,
                formatter: function(value,row,index){
                    if (row.classinfo){
                        return row.classinfo.classname;
                    } else {
                        return value;
                    }
                }
            },
            {
                field:'buildingnoAndDormitoryno',title:'宿舍号', halign:'center',width:80,
                formatter: function(value,row,index){
                    if (row.building&&row.dormitory){
                        return row.building.buildingno+row.dormitory.dormitoryno;
                    } else {
                        return value;
                    }
                }
            },
            {
                field:'bedno',title:'床位号', halign:'center',width:80,
            },

        ]]
    });

})

function searchStudent() {
    //获取输入框的内容
    var sno = $("input[name='sno']").val();
    var cardno = $("input[name='cardno']").val();
    var sname = $("input[name='sname']").val();
    var ssex = $('#ssex').val();
    var sphoneno = $("input[name='sphoneno']").val();
    var homeadress = $("input[name='homeadress']").val();
    var campusid = $("input[name='campusid']").val();
    var academyid = $("input[name='academyid']").val();
    var classid = $("input[name='classid']").val();
    var buildingid = $("input[name='buildingid']").val();
    var dormitoryid = $("input[name='dormitoryid']").val();
    var bedno = $('#bedno').val();
    if(campusid==""){
        campusid=0;
    }
    if(academyid==""){
        academyid=0;
    }

    $('#studentData').datagrid("load", {"sno":sno,"cardno":cardno,"sname":sname,"ssex":ssex,
        "sphoneno":sphoneno,"homeadress":homeadress,"campusid":campusid,"academyid":academyid,"classid":classid,
        "buildingid":buildingid,"dormitoryid":dormitoryid,"bedno":bedno});
}

