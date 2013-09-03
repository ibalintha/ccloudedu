package com.ccloudedu.base.web.taglib;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.ccloudedu.base.utils.LocaleUtils;
import com.ccloudedu.system.entity.SysDataDictionary;
/**
 * 自定义select标签
 * @author wade
 */
public class SelectTag extends DictionaryParentTag{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//第一个option
	private String firstoption = "";
	private boolean nullValue=true;//是否将第一个option设置成""值
	
	private String rules = "";//验证规则
	@Override
	public String processResult() {
		
		Object value = getExValue(getValue());
		
		StringBuilder sb = new StringBuilder("");
		
		List<SysDataDictionary> list = this.getSubList(getPvalue());
		
		if(list!=null && list.size()>0){
			
			firstoption = StringUtils.isEmpty(firstoption)?"----":firstoption;
			if(StringUtils.isNotBlank(rules)){
				rules = "rules=\""+rules+"\"";
			}
			sb.append("<select "+rules+" " + getHtmlAttributes() + ">");
			if(nullValue){
				sb.append("<option value=\"\">").append(firstoption).append("</option>");
			}
			for(SysDataDictionary dd : list){
				
				sb.append("<option value=\""+dd.getDdValue()+"\"");
				
				if(dd.getDdValue().equals(value)){
					sb.append(" selected=\"selected\" ");
				}
				
				if(LocaleUtils.EN_US.equals(LocaleUtils.getLocale())){
					sb.append(">").append(dd.getEnDdName()).append("</option>");
				}else{
					sb.append(">").append(dd.getDdName()).append("</option>");
				}
				
			}
			
			sb.append("</select>");
			
		}
		
		return sb.toString();
	}

	public void setFirstoption(String firstoption) {
		this.firstoption = firstoption;
	}

	public boolean isNullValue() {
		return nullValue;
	}

	public void setNullValue(boolean nullValue) {
		this.nullValue = nullValue;
	}

	public String getRules() {
		return rules;
	}

	public void setRules(String rules) {
		this.rules = rules;
	}

}
