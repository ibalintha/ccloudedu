package com.ccloudedu.system.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccloudedu.base.service.impl.BaseServiceImpl;
import com.ccloudedu.base.utils.DateUtils;
import com.ccloudedu.base.web.Sessions;
import com.ccloudedu.common.entity.ChRecord;
import com.ccloudedu.common.entity.ChUser;
import com.ccloudedu.system.service.RecordService;

@Service
@Transactional
public class RecordServiceImpl extends BaseServiceImpl<ChRecord> implements RecordService {

	@Override
	public void saveOperLog(String chFuncModuel, String chRecdType,
			String chRecdDesc, String chRecdMemo) throws Exception {
	     	ChRecord chRecd=new ChRecord();
		//    ChUser user=Sessions.getChUser();
	     	ChUser user=Sessions.getChUser();
			chRecd.setChRecdModule(chFuncModuel);
			chRecd.setChRecdDesc(chRecdDesc);
			chRecd.setChRecdType(chRecdType);
			
			if(chRecd!=null){
				chRecd.setChUser(user);
				chRecd.setChRecdTime(DateUtils.getCurrentDate());
				save(chRecd);
			}
	}


}
