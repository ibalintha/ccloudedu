<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>struts1 action</title>
 <link rel="stylesheet" type="text/css" href="jquery-easyui/themes/default/easyui.css">
 <link rel="stylesheet" type="text/css" href="jquery-easyui/themes/icon.css">
 <script type="text/javascript" src="jquery-easyui/jquery-1.4.2.min.js"></script>
 <script type="text/javascript" src="jquery-easyui/jquery.easyui.min.js"></script>
 <script type="text/javascript" src="jquery-easyui/easyDemo.js"></script>
 <script type="text/javascript" src="jquery-easyui/locale/easyui-lang-zh_CN.js"></script> 
 <script type="text/javascript">
 //参考http://hi.baidu.com/620734263/item/19ef9b0c802bbfe5f55ba640
 //http://www.cnblogs.com/archie2010/archive/2011/01/17/1937327.html
  $(function(){
   $('#mytab').datagrid({
    title:'datagrid小例子',
    iconCls:'icon-ok',
    width:800,
    height:350,
    pageSize:10,
    pageList:[10,15,20],
    nowrap:false,
    striped: true,
    collapsible:true,
    singleSelect:true,
    fit:true,//让DATAGRID自适应其父容器
    ,
    loadMsg:'数据加载中,请稍后...',   
    sortName:'code',
    sortOrder:'desc',
    remoteSort:false,
    frozenColumns:[[
     {field:'ck',checkbox:true}
    ]],
     columns:[[
        {title:'学号',field:'id',width:'50',rowspan:2,align:'center',hidden:'false'},
        {title:'姓名',field:'name',width:115,align:'center',
                    formatter:function(val,rec){
                        return '<a href="student.do?method=viewDetail&id='+rec.id+'">'+val+'</a>';
                    }
                  },
        {title:'性别',field:'sex',width:'50',rowspan:2,align:'center',
        formatter:function(value){
     if(value=="1")
       return "男";
     else
       return "女";
     }
        },
        {title:'年龄',field:'age',width:'100',rowspan:2,align:'center',
         formatter:function(val,rec){
                  if (eval(val)<18){
                      return '<span style="color:red;">('+val+'-未成年)</span>';
                  }else{
                      return val;
                  }
             }    
        },
        {title:'出生日期',field:'birthday',width:'120',rowspan:2,align:'center',
         formatter:function(val,rec){
     return formatTime(val);
     }
        },
        {title:'班级',field:'className',width:'100',rowspan:2,align:'center'},
        {field:'opt',title:'操作',width:100,align:'center', rowspan:2,  
                    formatter:function(value,rec){  
                      //alert(rec.id);       
                      return '<span style="color:red" mce_style="color:red"><a href="javascript:editData('+rec.id+',1)" mce_href="javascript:editData('+rec.id+',1)"><img src="jquery-easyui/themes/icons/edit.gif" align="absmiddle">修改</a> <a href="javascript:delData('+rec.id+',2)" mce_href="javascript:delData('+rec.id+',2)"><img src="jquery-easyui/themes/icons/delete.gif" align="absmiddle">删除</a></span>';  
                    }  
                 }  
    ]],
    onHeaderContextMenu: function(e, field){
     e.preventDefault();
     if (!$('#tmenu').length){
      createColumnMenu();
     }
     $('#tmenu').menu('show', {
      left:e.pageX,
      top:e.pageY
     });
 },
    pagination:true,
    rownumbers:true,
    /*onClickRow:function(){//单击事件
        var selected = $('#mytab').datagrid('getSelected');
           if (selected){
              alert("单击"+selected.id+":"+selected.className);//window.open("DataView.action?Id="+selected.ID);
            }
     },*/
     onDblClickRow:function(){//双击事件 查看、修改等操作
        var selected = $('#mytab').datagrid('getSelected');
   if(selected){
      //window.open("DataView.action?Id="+selected.ID);
    alert("双击"+selected.id+":"+selected.name+":"+selected.age+":"+selected.className);
   }
     },
     //工具栏
     toolbar:[{
          id:'btnadd',
          text:'添加',
          iconCls:'icon-add',
          handler:function(){
             $('#btnadd').linkbutton('enable');
              //alert('add')
             openNewAddWindows();
           }
        },{
           id:'btnedit',
           text:'修改',
           iconCls:'icon-edit',
           handler:function(){
               $('#btnedit').linkbutton('enable');
               //alert('cut')
               //修改层的样式，是div 显示
    //$("#editStudentMessage").css({display:'block'});
    //模态窗体显示
    openEditStutable();
            }
         },'-',{
           id:'btndel',
           text:'删除',
           disabled:false,
           iconCls:'icon-remove',
           handler:function(){
           $('#btndel').linkbutton('enable');
           //alert('save')
           //删除选择的记录
     delStudent();
         }
      }]
   });  
   
   //默认选取第一行,不管用
   //$('#mytab').datagrid('selectRow',0);
   
   /*//刷新事件
   var p = $('#mytab').datagrid('getPager');
   if (p){
      $(p).pagination({
        onBeforeRefresh:function(){
           alert('before refresh');
        }
      });
   } */  
  });
  
/**对数据列进行显示和隐藏操作*/  
function createColumnMenu(){
 var tmenu = $('<div id="tmenu" style="width:100px;"></div>').appendTo('body');
 var fields = $('#mytab').datagrid('getColumnFields');
 //获取标题列 var titles = $(".datagrid-header-inner table tr td .datagrid-cell span");
 for(var i=0; i<fields.length; i++){
  $('<div iconCls="icon-ok"/>').html(fields[i]).appendTo(tmenu);
 }
 tmenu.menu({
  onClick: function(item){
   if (item.iconCls=='icon-ok'){
    $('#mytab').datagrid('hideColumn', item.text);
    tmenu.menu('setIcon', {
      target: item.target,
     iconCls: 'icon-empty'
    });
   } else {
    $('#mytab').datagrid('showColumn', item.text);
    tmenu.menu('setIcon', {
     target: item.target,
     iconCls: 'icon-ok'
    });
   }
  }
 });  
}
  
//格式化时间显示 
function formatTime(val) {
 var year=parseInt(val.year)+1900;
 var month=(parseInt(val.month)+1);
 month=month>9?month:('0'+month);
 var date=parseInt(val.date);
 date=date>9?date:('0'+date);
 var hours=parseInt(val.hours);
 hours=hours>9?hours:('0'+hours);
 var minutes=parseInt(val.minutes);
 minutes=minutes>9?minutes:('0'+minutes);
 var seconds=parseInt(val.seconds);
 seconds=seconds>9?seconds:('0'+seconds);
 var time=year+'-'+month+'-'+date+' '+hours+':'+minutes+':'+seconds;
   return time;
}

//弹出选中数据
function getSelections(){
   var ids = [];
   var rows = $('#mytab').datagrid('getSelections');
   for(var i=0;i<rows.length;i++){
       ids.push(rows[i].id);
    }
    alert(ids.join(':'));
}
        
//清空选中数据
function clearSelections(){
    $('#mytab').datagrid('clearSelections');
}

      
//删除确认
//关于删除，可以通过点击删除按钮，调用删除方法来实现。删除按钮可以在拼装JSON字串的时候，赋值给OPERATION域，这样设置{field:'OPERATION',title:'操作',width:120}，就可以在页面上显示删除按钮了。删除的实现
function DelConfirm(){
   $.messager.confirm('确认','是否真的删除?',function(r){
   if (r){
     var selected = $('#mytab').datagrid('getSelected');
     if (selected){
        var index = $('#mytab').datagrid('getRowIndex', selected);
        $('#mytab').datagrid('deleteRow', index);
        DeleteSubmit(selected);
     }
   }
   });
}
//执行删除提交
function DeleteSubmit(selected){
       var url="DataDelete.action?Id="+selected.ID;
       $.post(
       url     
     );
}


//add 事件
function openNewWindows(){
      //清空控件中的的值
      $("#stuid").val("");
      $("#stuname").val("");
      $("#stuage").val("");
      $("#stusex").combobox("setValue","");
      $("#stutel").val("");
      //修改层的样式，是div 显示
      $("#editStudentMessage").css({display:'block'});
      $("#editStudentMessage").dialog({
        height: 200,
        width:300,
         modal: true,//屏蔽页面
         autoOpen: false
         });
      }
      var count=1000;
      //Ok 事件
      function addStudentMessage(){
       count++;
       var datas = new  Object();
       datas.id=count;
       datas.name=$("#stuname").val();
       datas.age=$("#stuage").val();
       datas.sex=$("#stusex").combobox('getValue');
       datas.tel=$("#stutel").val();
       var ids=$("#stuid").val();
       //得到表格中的数据
       var stuData=$("#studentTable").datagrid("getData");
       if(ids != ""){
          datas.id=ids;
        if(stuData.rows.length !=0){
         for(var i=0;i<stuData.rows.length;i++){
          //如果 表格中的Id 和要进行修改的Id 相同的话 就进行修改
          if(stuData.rows[i].id==ids){
           $('#studentTable').datagrid('getData').rows.splice(i,1,datas);
          }
         }
         }
      }else{
     stuData.total++;
     //加载行
     stuData.rows.push(datas);
      }
      $("#studentTable").datagrid("loadData",stuData); 
      //关闭窗体
      $('#editStudentMessage').dialog('close');
}


//del 事件
function delStudent(){
      //得到所有的数据
      var stuData=$("#studentTable").datagrid("getData"); 
      //得到选中的数据
      var rows=$("#studentTable").datagrid("getSelections"); 
      if(rows.length == 0){
       $.messager.alert("系统提示","请选择要删除的行！",'info');
       return ;
    }
   if(confirm('确定删除 这' + rows.length + '条记录?')){
      for(var i=0;i<rows.length;i++){
         for (var j=0;j<stuData.rows.length;j++){
     if(stuData.rows[j].id == rows[i].id){
       $("#studentTable").datagrid("deleteRow",j)
     }
      }
      }
    }
      $("#studentTable").datagrid("loadData",$("#studentTable").datagrid("getData")); 
}
      
//edit 事件
function openEditStutable(){
   var rows = $("#studentTable").datagrid('getSelections');
 if(rows == 0){
  $.messager.alert("系统提示","请选择要编辑的行！",'info');
  return ;
 }
 if(rows.length > 1){
  $.messager.alert("系统提示","对不起，该操作只能选择一行！",'error');
  return;
 }

 for(var i=0;i<rows.length;i++){
  if(rows[i].id!="" ){
    $("#stuid").val(rows[i].id);
    $("#stuname").val(rows[i].name);
    $("#stuage").val(rows[i].age);
    $("#stusex").combobox('setValue',rows[i].sex);
    $("#stutel").val(rows[i].tel);
  }
 }
 $("#editStudentMessage").dialog({
         height: 200,
         width:300,
          modal: true,//屏蔽页面
          autoOpen: false
 });
}
 </script>
  </head>
 
  <body>
      <div style="margin-bottom:10px;">
        <a href="#" onclick="getSelections()">选择项的id</a>
        <a href="#" onclick="clearSelections()">取消选择</a>
    </div>
    <h2><b>测试easyui的DataGrid</b></h2>
    <table id="mytab">
    </table>
  </body>
</html>

