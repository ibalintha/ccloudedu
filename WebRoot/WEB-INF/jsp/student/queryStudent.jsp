<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="my" uri="/mytags"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="<%=request.getContextPath() %>"/>
<!DOCTYPE html>
<html>
<my:head tree3="true" datePicker="true" lhgdialog="true">
     <style type="text/css">.ztree li a:hover {text-decoration:none;}</style>	
     <script type="text/javascript">
      
 
   function cancel(){
	var api = frameElement.api;
	  api.close();
	}  
	    
        var api = frameElement.api, W = api.opener,cDG;
        var addordetail = true;    
        function submita(){
        var chStudSchcode = $("#chStudSchcode").val();      
        var chStudName=$("#chStudName").val();
        chStudName = encodeURI(encodeURI(chStudName));
        //chStudName = encodeURI(chStudName);
        var chStudSex=$("#chStudSex").val();
        chStudSex = encodeURI(chStudSex);
        chStudSex = encodeURI(chStudSex);
        var chClasId=$("#chClasId").val();
        var tolisturl = "${ctx}/student/student_list.do?chStudSchcode="+chStudSchcode+"&chStudName="+chStudName+"&chClasId="+chClasId+"&chStudSex="+chStudSex;
        api.reload(W,tolisturl);
   
        }  
     
	</script>
</my:head>
<body>
<div class="bodybox">
<div class="phead">
	<div class="pheadposition"><my:i18n zhText="当前位置" enText="Current Position"/>： <my:i18n zhText="新生管理" enText="User Mgt"/> - <my:i18n zhText="查询" enText="Query"/></div>
	
	<div class="clear"></div>
</div>


	    <div id="result" align="center" style="color: red"></div>
		  <form id="studentForm" action="${ctx}/student/student_list.do" method="post">
		   <input type="hidden" id="chClasId"name="chClasId"value="1">
		  
		   <table style="width:100% "class="ltable">
		    <thead class="ltablehead">
			                <tr id="postTr" align="center">
			                		                	
			                    <th width="30%" align="center"><my:i18n zhText="查询类别" enText="chScroGrade"/></th>
			                    <th width="70%"><my:i18n zhText="具体关键字" enText="chScroGrade"/></th>
			                </tr>
			            </thead>
			            <tbody class="ltablebody">
	          <tr>
                  <td>
                                                      学号
                  </td>
	              <td>
	               <input type="text" name="chStudSchcode" id="chStudSchcode"
					value="" />
	              </td>
	          </tr>
           <tr>
                  <td>
                                                      姓名
                  </td>
	              <td>
	               <input type="text" name="chStudName" id="chStudName"
					value="" />
	              </td>
	          </tr>
	          <tr>
                  <td>
                                                      性别
                  </td>
	              <td>
	               <input type="text" name="chStudSex" id="chStudSex"
					value="" />
	              </td>
	          </tr>
	         <!--  <tr>
                  <td>
                                                      民族
                  </td>
	              <td>
	               <input type="text" name="chStudEthnic" id="chStudEthnic"
					value="" />
	              </td>
	          </tr>
	          <tr>
                  <td>
                                                      政治面貌
                  </td>
	              <td>
	               <input type="text" name="chStudPolface" id="chStudPolface"
					value="" />
	              </td>
	          </tr>
	             <tr>
                  <td>
                                                     籍贯
                  </td>
	              <td>
	               <input type="text" name="chStudHometown" id="chStudHometown"
					value="" />
	              </td>
	          </tr> 
	              <tr>
                  <td>
                                                      住址
                  </td>
	              <td>
	               <input type="text" name="chStudAddress" id="chStudAddress"
					value="" />
	              </td>
	          </tr> -->
           <tr>
                 <td colspan="3" >
                                                       注意事项：<br/>
                                                                  一、<br/>
                                                                  二、<br/>
                                                                  三、<br/>
                                                                  四、
                
                 </td>
           </tr>
      
           <tr>
			<td colspan="2" class="ftablebutton">
				
				   <input type="button" class="button orange" class="button orange"  value="<my:i18n zhText="查询" enText="Serch"/>" onclick="submita()"/> &nbsp; 
				   <input type="reset" class="button orange"  class="button orange" value="<my:i18n zhText="取消" enText="Cancel"/>"onclick="cancel()"/>
				
			</td>
	      </tr>
	      </tbody>
        </table>
        </form>
        
         <div id="menuContentDeptTree" class="menuContentDeptTree" style="display:none; position: absolute;">
			<ul id="deptTree" class="ztree" style="margin-top:0;border: 1px solid #617775;background: #f0f6e4;width:180px;height:300px;overflow-y:scroll;overflow-x:auto;"></ul>
	    </div>
	    <div id="menuContentRoleTree" class="menuContentRoleTree" style="display:none; position: absolute;">
			<ul id="roleTree" class="ztree" style="margin-top:0;border: 1px solid #617775;background: #f0f6e4;width:180px;height:200px;overflow-y:scroll;overflow-x:auto;"></ul>
	    </div>
    </div>
</body>
</html>