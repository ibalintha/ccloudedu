package com.ccloudedu.oa.work.service.impl;

import java.io.File;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ccloudedu.base.dao.hibernate.BaseHibernateDao;
import com.ccloudedu.base.service.impl.BaseServiceImpl;
import com.ccloudedu.base.utils.DateUtils;
import com.ccloudedu.base.web.Sessions;
import com.ccloudedu.oa.work.entity.OaProject;
import com.ccloudedu.oa.work.entity.OaProjectParticipant;
import com.ccloudedu.oa.work.entity.OaProjectSchedule;
import com.ccloudedu.oa.work.service.OaProjectScheduleService;
import com.ccloudedu.system.entity.SysRole;
import com.ccloudedu.system.entity.SysUser;
import com.ccloudedu.upload.service.UploadFileService;

@Service
@Transactional
public class OaProjectScheduleServiceImpl extends BaseServiceImpl<OaProjectSchedule> implements OaProjectScheduleService {
	
	@Autowired
	private BaseHibernateDao<OaProjectParticipant> oaProjectParticipantDao;
	@Autowired
	private UploadFileService uploadFileService;
	
	@Transactional(propagation=Propagation.REQUIRED)
	public int save(OaProject oaProject,
			OaProjectSchedule oaProjectSchedule, List<String> roleIds,
			List<String> userIds, List<String> startDts, List<String> endDts,
			List<String> descriptions,
			String uploadPath,List<File> upload,List<String> uploadFileName, List<String> uploadContentType) throws Exception{
		
		if(StringUtils.isBlank(oaProjectSchedule.getId())){
			save(oaProjectSchedule);
		}else{
			update(oaProjectSchedule);
		}
		
		//删除旧的参与人员
		Set<OaProjectParticipant> currentP = oaProjectSchedule.getOaProjectParticipant();
		if(currentP!=null && currentP.size()>0){
			for(OaProjectParticipant cp : currentP){
				oaProjectParticipantDao.delete(cp);
			}
		}
		
		//插入新的参与人员
		if(roleIds!=null && roleIds.size()>0){
			OaProjectParticipant p = new OaProjectParticipant();
			for(int i=0;i<roleIds.size();i++){
				p = new OaProjectParticipant();
				
				p.setStartDt(startDts.get(i));
				p.setEndDt(endDts.get(i));	
				p.setDescription(descriptions.get(i));
				p.setOaProject(oaProject);
				p.setOaProjectSchedule(oaProjectSchedule);
				p.setSysRole(new SysRole(roleIds.get(i)));
				p.setSysUser(new SysUser(userIds.get(i)));
				p.setCreateTime(DateUtils.getCurrentDate());
				p.setCreator(Sessions.getSysUser());
				
				oaProjectParticipantDao.save(p);
			}
		}
		
		//上传附件到磁盘，并保持附件信息到数据库
		uploadFileService.upload(oaProjectSchedule.getId(), uploadPath, upload, uploadFileName, uploadContentType);
		return 1;
	}
}
