package com.ccloudedu.base.web.taglib;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.ccloudedu.system.entity.SysDept;

public class DeptTag extends ParentTag{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//第一个option
	private String firstoption = "";
	private String dtype = "select";

	@SuppressWarnings("unchecked")
	public String processResult() {
		
		List<SysDept> deptList = (List<SysDept>) pageContext.getServletContext().getAttribute("deptList");
        
		Object value = getExValue(getValue());
				
		StringBuilder sb = new StringBuilder("");
		
		if(deptList!=null && deptList.size()>0){
			
			if("view".equals(dtype)){
				String deptName = "";
				for(SysDept dept : deptList){
					
					if(dept.getId().equals(value)){
						
						deptName = dept.getDeptName();
						break;
					}
				}
				return deptName;
			}else{
				firstoption = StringUtils.isEmpty(firstoption)?"----":firstoption;
				
				sb.append("<select " + getHtmlAttributes() + ">");
				
				sb.append("<option value=\"\">").append(firstoption).append("</option>");
				
				for(SysDept dept : deptList){
					
					sb.append("<option value=\""+dept.getId()+"\"");
						
					if(dept.getId().equals(value)){
						sb.append(" selected=\"selected\" ");
					}
						
					sb.append(">").append(dept.getDeptName()).append("</option>");
				}
				
				sb.append("</select>");
			}
		}
		
		return sb.toString();
	}

	public void setFirstoption(String firstoption) {
		this.firstoption = firstoption;
	}

	public void setDtype(String dtype) {
		this.dtype = dtype;
	}

}
