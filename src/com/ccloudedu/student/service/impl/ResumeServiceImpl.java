package com.ccloudedu.student.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccloudedu.base.dao.utils.builder.HqlBuilder;
import com.ccloudedu.base.entity.Page;
import com.ccloudedu.base.service.impl.BaseServiceImpl;
import com.ccloudedu.base.utils.FastMap;
import com.ccloudedu.common.entity.ChResume;
import com.ccloudedu.student.service.ResumeService;

@Service
@Transactional
public class ResumeServiceImpl extends BaseServiceImpl<ChResume> implements
		ResumeService {
	@SuppressWarnings("unchecked")
	@Override
	public List<ChResume> getList(String chScroId) throws Exception {
		Map<String,String> paramMap = new FastMap().newHashMap()
				.set("chScroId", "%"+chScroId+"%");
		return super.findList("enrolment.findResume",paramMap);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void deleteResumeByScroIds(String[] scroIds) throws Exception {
		for(String scroId:scroIds){
			Map<String,String> paramMap = new FastMap().newHashMap()
					.set("scroId", "%"+scroId+"%");
			super.batch("enrolment.deleteResumeScroId",paramMap);
		}
	}

	
	@Override
	public ChResume save(ChResume entity) throws Exception {
		ChResume cr = super.save(entity);
		return cr;
	}

	@Override
	public ChResume update(ChResume entity) throws Exception {
		ChResume cr = super.update(entity);
		return cr;
	}

	@Override
	public boolean deleteById(Serializable id) throws Exception {
		boolean isDelete = super.deleteById(id);
		return isDelete;
	}
	
	@Override
	public ChResume saveOrUpdate(ChResume entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ChResume> deleteByIds(Serializable[] ids) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChResume get(Serializable id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int batch(HqlBuilder hqlBuilder) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int batch(String queryName, Map<String, ?> paramMap)
			throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int findCount(HqlBuilder hqlBuilder) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int findCount(String queryName, Map<String, ?> paramMap)
			throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ChResume findOne(HqlBuilder hqlBuilder) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChResume findOne(String queryName, Map<String, ?> paramMap)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<?, ?> findMap(HqlBuilder hqlBuilder, String keyPropertyName,
			Object clazzOrPropertyName) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<?, ?> findMap(String queryName, String keyPropertyName,
			Object clazzOrPropertyName, Map<String, ?> paramMap)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List findList(HqlBuilder hqlBuilder) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List findList(String queryName, Map<String, ?> paramMap)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page findPage(Page page, HqlBuilder hqlBuilder) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page findPage(Page page, String queryName, Map<String, ?> paramMap)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
