<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="my" uri="/mytags"  %>
<c:set var="ctx" value="<%=request.getContextPath() %>"/>
<!DOCTYPE html>
<html>
<my:head tree2="true">
   <link rel="stylesheet" type="text/css" href="${ctx}/js_css_image/css/tab.css"/>
	<style type="text/css">.tree li a:hover {text-decoration:none;}</style>
	<script type="text/javascript">
    	 $(function() {
			$("#manualBtn").submitForm({ 
				formId:"manualBackupForm",
				onSubmit:function(){
					$("#chBaupWayManual").val("手动备份数据库");
				},
				onComplete:function(id){
					
				}
			});
			
			$("#automaticBtn").submitForm({ 
				formId:"autoBackupForm",
				onSubmit:function(){
					$("#chBaupWayAuto").val("自动备份数据库");
					$("#chBaupBegtime").val(jq_hour_start_select.val()+":"+jq_minute_start_select.val());
				},
				onComplete:function(id){
					
				}
			});
			
			var jq_hour_start_select = $('#hour_start_select');
			var jq_minute_start_select = $('#minute_start_select');
             //初始化
             jq_hour_start_select_init();
             jq_minute_start_select_init();
             
             
                 
                 //结束时间初始化
                 function jq_hour_start_select_init(){
                     jq_hour_start_select.empty();
                     jq_hour_start_select.append($('<option value="0" selected>0</option>'));
                     for(var i =1;i<24;i++ ){
                                 jq_hour_start_select.append($('<option value='+i+'>'+i+'</option>'));
                     }
                 }
                 //开始时间初始化
                 function jq_minute_start_select_init(){
                     jq_minute_start_select.empty();
                     jq_minute_start_select.append($('<option value="0" selected>0</option>'));
                     for(var i =1;i<60;i++ ){
                                 jq_minute_start_select.append($('<option value='+i+'>'+i+'</option>'));
                     }
                 }
		});
	</script>
</my:head>
<body>
    <my:select pvalue="qxsz" name="authTree" nullValue="false" style="display: none"/>
    <div class="bodybox">
		  <form id="manualBackupForm" action="system/backup_save.do" method="post" >
		   <input type="hidden" name="chBaupWay" id="chBaupWayManual" value="">
		   <table width="100%" class="ftable"id="stripe_tb">
		   <tr><td colspan="2" align="center">手动备份数据库</td></tr>
          <tr>
            <th width="18%"><font color="red">*</font><my:i18n zhText="数据库名：" enText="Chinese Role Name"/>：</th>
            <td><select name="chBaupDatabase">
                    <option value="在校学生信息库" >在校学生信息库</option>
                    <option value="毕业学生信息库" >毕业学生信息库</option>
                    <option value="图片库" >图片库</option>
                    <option value="日志库" >日志库</option>
                </select></td>
          </tr>
          <tr>
            <th width="18%"><font color="red">*</font><my:i18n zhText="磁盘路径" enText="English Role Name"/>：</th>
            <td><input type="text" name="chBaupPath" id="chBaupPath" value="c:\" rules="[{notNull:true, message:'<my:i18n zhText="请填入可访问的路径" enText="Please Insert Path"/>'}]" />
          </tr>
          <tr>
          <th width="18%"><my:i18n zhText="备份" enText="Backup"/>：</th>
          <td class="ftablebutton">
				<input type="button" class="button orange"  value="<my:i18n zhText="开始手动备份" enText="Manual Backup"/>" id="manualBtn"/>
			</td>
          </tr>
          </table>
          </form>
          
          <form id="autoBackupForm" action="system/backup_save.do" method="post" > 
          <input type="hidden" name="chBaupWay" id="chBaupWayAuto" value="">
          <table width="100%" class="ftable"id="stripe_tb">
          <tr><td colspan="2" align="center">自动备份数据库</td></tr>
          <tr>
            <th width="18%"><font color="red">*</font><my:i18n zhText="数据库名：" enText="Chinese Role Name"/>：</th>
            <td><select name="chBaupDatabase" >
                    <option value="在校学生信息库" >在校学生信息库</option>
                    <option value="毕业学生信息库" >毕业学生信息库</option>
                    <option value="图片库" >图片库</option>
                    <option value="日志库" >日志库</option>
                </select></td>
          </tr>
          <tr>
            <th ><my:i18n zhText="频率：" enText="Rate"/>：</th>
            <td><select name="chBaupRate">
                    <option value="每周" >每周</option>
                    <option value="每月" >每月</option>
                    <option value="每日" >每日</option>
                </select></td>
          </tr>
          <tr>
            <th ><my:i18n zhText="开始时间" enText="Start Time"/>：</th>
            <td>
            	<input type="hidden" name="chBaupBegtime" id="chBaupBegtime" value="">
				<select id="hour_start_select"></select>:<select id="minute_start_select"></select></td>
          </tr>
           <tr>
          <th width="18%"><my:i18n zhText="备份" enText="Backup"/>：</th>
          <td class="ftablebutton">
				<input type="button" class="button orange"  value="<my:i18n zhText="自动备份设置" enText="Automatic Backup"/>" id="automaticBtn"/>
			</td>
          </tr>
        </table>
        </form>
	</div>
	</body>
</html>