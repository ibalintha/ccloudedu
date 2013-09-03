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
import com.ccloudedu.common.entity.ChPosition;
import com.ccloudedu.student.service.PositionService;

@Service
@Transactional
public class PositionServiceImpl extends BaseServiceImpl<ChPosition> implements
		PositionService {


	@SuppressWarnings("unchecked")
	@Override
	public List<ChPosition> getList(String chScroId) throws Exception {
		Map<String,String> paramMap = new FastMap().newHashMap()
				.set("chScroId", "%"+chScroId+"%");
		return super.findList("enrolment.findPosition",paramMap);
	}
	@SuppressWarnings("unchecked")
	@Override
	public void deletePostionByScroIds(String[] scroIds) throws Exception {
		for(String scroId:scroIds){
			Map<String,String> paramMap = new FastMap().newHashMap()
					.set("scroId", "%"+scroId+"%");
			super.batch("enrolment.deletePositionScroId",paramMap);
		}		
	}
	
	@Override
	public ChPosition save(ChPosition entity) throws Exception {
		ChPosition cp = super.save(entity);
		return cp;
	}

	@Override
	public ChPosition update(ChPosition entity) throws Exception {
		ChPosition cp = super.update(entity);
		return cp;
	}

	@Override
	public boolean deleteById(Serializable id) throws Exception {
		boolean isDelete = super.deleteById(id);
		return isDelete;
	}
	
	@Override
	public ChPosition saveOrUpdate(ChPosition entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ChPosition> deleteByIds(Serializable[] ids) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChPosition get(Serializable id) throws Exception {
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
	public ChPosition findOne(HqlBuilder hqlBuilder) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChPosition findOne(String queryName, Map<String, ?> paramMap)
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
