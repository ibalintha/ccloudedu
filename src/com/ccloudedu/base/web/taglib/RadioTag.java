package com.ccloudedu.base.web.taglib;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.ccloudedu.base.utils.LocaleUtils;
import com.ccloudedu.system.entity.SysDataDictionary;
/**
 * 自定义radio标签
 * @author wade
 */
public class RadioTag extends DictionaryParentTag{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//空格&nbsp;的数量，默认是3个
	private String nbspnum = "";
	private boolean br=false;

	@Override
	public String processResult() {
		
		Object value = getExValue(getValue());
		
		StringBuilder sb = new StringBuilder("");
		
		List<SysDataDictionary> list = this.getSubList(getPvalue());
		
		if(list!=null && list.size()>0){
			
			nbspnum = StringUtils.isEmpty(nbspnum)?"3":nbspnum;
			String separator = "";
			if(br){
				separator = "<br/>";
			}else{
				for(int i=0;i<Integer.parseInt(nbspnum);i++){
					separator += "&nbsp;";
				}
			}
			for(SysDataDictionary dd : list){
				sb.append("<input type=\"radio\"");
				if(dd.getDdValue().equals(value)){
					sb.append(" checked=\"checked\" ");
				}
				if(LocaleUtils.EN_US.equals(LocaleUtils.getLocale())){
					sb.append(" value=\""+dd.getDdValue()+"\" "+ getHtmlAttributes() + " />" + dd.getEnDdName()+ separator);
				}else{
					sb.append(" value=\""+dd.getDdValue()+"\" "+ getHtmlAttributes() + " />" + dd.getDdName()+ separator);
				}
				
			}
		}
		return sb.toString();
	}

	public void setNbspnum(String nbspnum) {
		this.nbspnum = nbspnum;
	}

	public boolean isBr() {
		return br;
	}

	public void setBr(boolean br) {
		this.br = br;
	}
}
