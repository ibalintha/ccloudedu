<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="my" uri="/mytags"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="<%=request.getContextPath() %>"/>
<!DOCTYPE html>
<html>
<my:head tree2="true">
     <script type="text/javascript">
	    var api = frameElement.api, W = api.opener, D = W.document;
	    var ctx = '${ctx}';
	    var curDeptId = '';
	    var zTree;
		var setting = {
				isSimpleData: true,
				treeNodeKey: "id",
				checkable: true,
			    checkStyle: "radio",
			    //checkRadioType: "level",
			    checkRadioType: "all",
				treeNodeParentKey: "pId"
			};
			var zNodes;
			$(function(){
				//curDeptId=  $('#deptId',DG.curDoc).val();
				curDeptId=  api.data;//取得从父窗口传过来的数值
				
				var treeNodeArray = new Array();
				<c:forEach items="${deptList}" var="dept">
				    var pId = "${dept.sysDept.id}";
				    var id = "${dept.id}";
				    var name = "${dept.deptName}";
				    var checked =false;
				    var open = false;
				    if(pId==""){open = true; }
					if(curDeptId==id){checked = true; open = true;}
				    var oneTreeNode='{id:"'+id+'",pId:"'+pId+'",name:"'+name+'",checked:'+checked+',open:'+open+'}';
				    treeNodeArray.push(oneTreeNode);
			    </c:forEach>
			    var zNodeStr = '['+treeNodeArray.join(",")+']';
	 		    var zNodes = (new Function("return " + zNodeStr))();//;eval('(' + zNodeStr + ')'); 两种方式转化成json，选其一
	 		    
				setting.expandSpeed = ($.browser.msie && parseInt($.browser.version)<=6)?"":"fast";
				zTree = $("#tree").zTree(setting, zNodes);
				
			});
 		    
 		   // var DG = frameElement.lhgDG;
           // DG.addBtn( 'ok', '确定', ok );
            function ok(){
                 var dept = zTree.getCheckedNodes(true);
                //$('#deptName',DG.curDoc).val(dept[0].name);
                 //$('#deptId',DG.curDoc).val(dept[0].id);
				//DG.cancel();
			}
            
            api.button(
				{
					name: '确定',
					callback: function(){//deptName deptId
						 var dept = zTree.getCheckedNodes(true);
	                     D.getElementById('deptName').value = dept[0].name+"";//给父窗口赋值
	                     D.getElementById('deptId').value = dept[0].id+"";
	                     //api.close();
						 return true;
					},
					focus: true
				},
				{
					name: '取消'
				}
		
	           );//.lock();
	 </script>
</my:head>
<body>
<div class="bodybox">
<div class="phead">
	<div align="center">
	     选择部门
	</div>
	<div class="clear"></div>
</div>


 <table width="100%" class="ftable">
	 <tr>
	   <td>
		 <ul id="tree" class="tree" style="margin-left: 5px"></ul>
	   </td>
	 </tr>
 </table>
   </div>
</body>
</html>