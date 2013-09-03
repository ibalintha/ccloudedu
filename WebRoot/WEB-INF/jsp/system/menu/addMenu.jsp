<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="/mytags"  %>
<c:set var="ctx" value="<%=request.getContextPath() %>"/>
<!DOCTYPE html>
<html>
<my:head>
   <link rel="stylesheet" type="text/css" href="${ctx}/js_css_image/css/tab.css"/>
	<script type="text/javascript">
    	 $(function() {
			$("#submitBtn").submitForm({ 
				formId:"menuForm",
				
				onComplete:function(id){
					parent.addNode('contentIframe',$("#parentMenuId").val(),id,$("#${locale.language}MenuName").val(),"/system/menu_update.do?id="+id);
				}
			});
		});
	</script>
</my:head>
<body>
<div class="bodybox">
		<div>
			<table width="100%" border="0" cellpadding="0" cellspacing="0" id="tabs1" >
				<tr>
					<td>
						 <div align="center" id="uldiv">
							<ul >
								<li><a href="${ctx }/system/menu_update.do?id=${id }"><span><my:i18n zhText="菜单信息" enText="Menu Info"/></span></a></li>
								<li><a href="${ctx }/system/menu_list.do?id=${id }"><span><my:i18n zhText="下级菜单列表" enText="Sub Menu List"/></span></a></li>
								<li id="current"><a href="${ctx }/system/menu_add.do?id=${id }"><span><my:i18n zhText="新增下级菜单" enText="Add A New Menu"/></span></a></li>
							</ul>
						    </div>
						</td>
					</tr>
				</table>
		</div>
		  <form id="menuForm" action="system/menu_save.do" method="post">
		  <input type="hidden" name="sysMenu.id" id="parentMenuId" value="${sysMenu.id }">
		   <table width="100%" class="ftable">
		    <c:if test="${!empty sysMenu.menuName}">
			    <tr>
		            <th width="18%"><my:i18n zhText="上级菜单" enText="Parent Menu"/>：</th>
		            <td>
		               <my:i18n zhText="${sysMenu.menuName}" enText="${sysMenu.enMenuName}"/>
		            </td>
	          </tr>
		   </c:if>
		   <tr>
            <th width="18%"><font color="red">*</font><my:i18n zhText="中文菜单名称" enText="Chinese Menu Name"/>：</th>
                <td><input type="text" id="zhMenuName" name="menuName" value="${menuName }" class="required" rules="[{notNull:true, message:'<my:i18n zhText="请输入菜单名称" enText="Please Enter Menu Name"/>'}]"></td>
          </tr>
          <tr>
            <th width="18%"><font color="red">*</font><my:i18n zhText="英文菜单名称" enText="English Menu Name"/>：</th>
		    <td><input type="text" id="enMenuName" name="enMenuName" value="${enMenuName }" class="required" rules="[{notNull:true, message:'<my:i18n zhText="请输入菜单名称" enText="Please Enter Menu Name"/>'}]"></td>
          </tr>
          <tr>
            <th><my:i18n zhText="路径" enText="Menu Path"/>：</th>
            <td><input type="text" name="menuPath" value="${menuPath }" style="width: 50%"></td>
          </tr>
           <tr>
            <th ><my:i18n zhText="备注" enText="Remark"/>：</th>
            <td><textarea style="width: 600px;height: 60px" name="remark">${remark }</textarea></td>
          </tr>
        <tr>
			<td colspan="2" class="ftablebutton">
				<my:auth fixedValue="W" value="${auth}"><input type="button" class="button orange"  value="<my:i18n zhText="保存" enText="Save"/>" id="submitBtn"/> &nbsp; <input type="reset" class="button orange"  value="<my:i18n zhText="重置" enText="Reset"/>"/></my:auth>
			</td>
	      </tr>
        </table>
        </form>
	</div>
	</body>
</html>