package com.ccloudedu.underlying.util;
/**
 * 字典菜单映射类
 * @author chenx
 *
 */
public class DictMenuMapper {

//	public static List<String> moduleToMenu(String module){
//		
//	}
	/**
	 * 根据字典菜单得到功能模块
	 * @param menu
	 * @return
	 */
	public static String getModule(String menu){
		if(menu.equals("政治面貌")){
			return "学籍管理";
		} else{
			return "";
		}	
	}
	
	/**
	 * 根据字典菜单得到对应表名
	 * @param menu
	 * @return
	 */
	public static String getTable(String menu){
		if(menu.equals("政治面貌")){
			return "ch_polface";
		} else{
			return "";
		}
	}
}
