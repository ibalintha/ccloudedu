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
import com.ccloudedu.common.entity.ChSpecial;
import com.ccloudedu.student.service.SpecialService;

@Service
@Transactional
public class SpecialServiceImpl extends BaseServiceImpl<ChSpecial> implements
		SpecialService {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ChSpecial> getList(String chScroId) throws Exception {
		Map<String,String> paramMap = new FastMap().newHashMap()
				.set("chScroId", "%"+chScroId+"%");
		return super.findList("enrolment.findSpecial",paramMap);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void deleteSpecialByScroIds(String[] scroIds) throws Exception {
		for(String scroId:scroIds){
			Map<String,String> paramMap = new FastMap().newHashMap()
					.set("scroId", "%"+scroId+"%");
			super.batch("enrolment.deleteSpecialScroId",paramMap);
		}
	}

	
	@Override
	public ChSpecial save(ChSpecial entity) throws Exception {
		ChSpecial cs = super.save(entity);
		return cs;
	}

	@Override
	public ChSpecial update(ChSpecial entity) throws Exception {
		ChSpecial cs = super.update(entity);
		return cs;
	}


	@Override
	public boolean deleteById(Serializable id) throws Exception {
		boolean isDelete = super.deleteById(id);
		return isDelete;
	}
	
	@Override
	public ChSpecial saveOrUpdate(ChSpecial entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<ChSpecial> deleteByIds(Serializable[] ids) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChSpecial get(Serializable id) throws Exception {
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
	public ChSpecial findOne(HqlBuilder hqlBuilder) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChSpecial findOne(String queryName, Map<String, ?> paramMap)
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
