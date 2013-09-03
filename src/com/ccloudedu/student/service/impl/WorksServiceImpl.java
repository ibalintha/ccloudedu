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
import com.ccloudedu.common.entity.ChWorks;
import com.ccloudedu.student.service.WorksService;

@Service
@Transactional
public class WorksServiceImpl extends BaseServiceImpl<ChWorks> implements
		WorksService {

	@SuppressWarnings("unchecked")
	@Override
	public List<ChWorks> getList(String chScroId) throws Exception {
		Map<String,String> paramMap = new FastMap().newHashMap()
				.set("chScroId", "%"+chScroId+"%");
		return super.findList("enrolment.findWorks",paramMap);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void deleteWorksByScroIds(String[] scroIds) throws Exception {
		for(String scroId:scroIds){
			Map<String,String> paramMap = new FastMap().newHashMap()
					.set("scroId", "%"+scroId+"%");
			super.batch("enrolment.deleteWorksScroId",paramMap);
		}	
	}
	
	@Override
	public ChWorks save(ChWorks entity) throws Exception {
		ChWorks cw = super.save(entity);
		return cw;
	}

	@Override
	public ChWorks update(ChWorks entity) throws Exception {
		ChWorks cw = super.update(entity);
		return cw;
	}	

	@Override
	public boolean deleteById(Serializable id) throws Exception {
		boolean isDelete = super.deleteById(id);
		return isDelete;
	}

	@Override
	public ChWorks saveOrUpdate(ChWorks entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<ChWorks> deleteByIds(Serializable[] ids) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChWorks get(Serializable id) throws Exception {
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
	public ChWorks findOne(HqlBuilder hqlBuilder) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChWorks findOne(String queryName, Map<String, ?> paramMap)
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
