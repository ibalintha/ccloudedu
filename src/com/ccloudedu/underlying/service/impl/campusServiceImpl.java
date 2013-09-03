package com.ccloudedu.underlying.service.impl;

import java.io.Serializable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccloudedu.base.dao.hibernate.BaseHibernateDao;
import com.ccloudedu.base.entity.Page;
import com.ccloudedu.base.service.impl.BaseServiceImpl;
import com.ccloudedu.base.utils.FastMap;
import com.ccloudedu.common.entity.ChCampus;
import com.ccloudedu.system.entity.SysDept;
import com.ccloudedu.underlying.service.campusService;
import com.ccloudedu.upload.service.UploadFileService;

/**
 * 校区基本信息管理类
 * @author wade
 *
 */
@Service
@Transactional
public class campusServiceImpl extends BaseServiceImpl<ChCampus> implements campusService {
	@Autowired
	private BaseHibernateDao<SysDept> deptDao;
	
	@Autowired
	private UploadFileService uploadFileService;
	
	@SuppressWarnings("unchecked")
	public Page findCampus(Page page,String chCampCode,String chCampName) throws Exception {
//		String parentDeptLevel = deptDao.get(SysDept.class, user.getSysDept().getId()).getDeptLevel(); 
		Map<String,String> paramMap = new FastMap().newHashMap()
		.set("chCampCode", "%"+chCampCode+"%")
		.set("chCampName", "%"+chCampName+"%");
//		.set("userIdList", userIdList)//userIdList !=null 时，是查看在线用户 && user.getUserRoleType()==YN.N
//		.set("parentDeptLevel", null); 
		return this.findPage(page,"campus.findCampus",paramMap);
	}



	@SuppressWarnings("unchecked")
	public int updateCampCode(String id, String campuscode) throws Exception{
		Map<String,String> paramMap = new FastMap().newHashMap()
		.set("id", ""+id+"")
		.set("chCampCode", ""+campuscode+"");
		return batch("campus.updateCampCode",paramMap);
	}



	@Override
	public ChCampus save(ChCampus entity) throws Exception {
		// TODO Auto-generated method stub
		return super.save(entity);
	}



	@Override
	public ChCampus update(ChCampus entity) throws Exception {
		// TODO Auto-generated method stub
		return super.update(entity);
	}



	@Override
	public ChCampus saveOrUpdate(ChCampus entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}




@Override
public ChCampus get(Serializable id) throws Exception {
	// TODO Auto-generated method stub
	return super.get(id);
}
//	@Override
//	public String findcheckflag() {
//		// TODO Auto-generated method stub
//		return null;
//	}




//	@Override
//	public void update(ChCampus campus, String uploadPath, List<File> upload,
//			List<String> uploadFileName, List<String> uploadContentType)
//			throws Exception {
//		// TODO Auto-generated method stub
//		
//	}

}
