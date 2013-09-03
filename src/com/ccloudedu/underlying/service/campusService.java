package com.ccloudedu.underlying.service;

import com.ccloudedu.base.entity.Page;
import com.ccloudedu.base.service.BaseService;
import com.ccloudedu.common.entity.ChCampus;


/**
 * @author wade
 */
public interface campusService extends BaseService<ChCampus> {
	

	/**
	 * 更新校区信息
	 * @param campus
	 * @throws Exception
	 */
//	public ChCampus update(ChCampus campus) throws Exception;
	
//	public  String findChCampName() throws Exception;
//	public  String findChCampDesc() throws Exception;
//	public  String findChCampCode() throws Exception;
//	public  String findChCampMemo() throws Exception;
//	public  String findChCampAddress() throws Exception;
//	public  String findChCampShowflag ();
	
//	public String getChCampusById(String id)throws Exception;
	
	/**
	 * 根据校区代码和校区名字查询校区信息
	 * @param menu
	 * @return
	 * @throws Exception 
	 * @throws Exception
	 */

	public Page findCampus(Page page, String chCampCode, String chCampName) throws Exception;








	

	
	

}
