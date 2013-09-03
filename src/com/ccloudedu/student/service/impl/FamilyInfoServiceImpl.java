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
import com.ccloudedu.common.entity.ChFamily;
import com.ccloudedu.student.service.FamilyInfoService;

@Service
@Transactional
public class FamilyInfoServiceImpl extends BaseServiceImpl<ChFamily> implements
		FamilyInfoService {

	@SuppressWarnings("unchecked")
	@Override
	public List<ChFamily> getFamilyById(String chScroId)
			throws Exception {
		Map<String,String> paramMap = new FastMap().newHashMap()
				.set("chScroId", "%"+chScroId+"%");
		return super.findList("enrolment.findFamily",paramMap);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public int delFamilyById(String familyId) throws Exception {
		Map<String,String> paramMap = new FastMap().newHashMap()
				.set("familyId", "%"+familyId+"%");
				return super.batch("enrolment.deleteComment", paramMap);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void deleteFamilyByScroIds(String[] scroIds) throws Exception {
		for(String scroId:scroIds){
			Map<String,String> paramMap = new FastMap().newHashMap()
					.set("scroId", "%"+scroId+"%");
			super.batch("enrolment.deleteFamilyScroId",paramMap);
		}
	}
	
	@Override
	public ChFamily save(ChFamily entity) throws Exception {
		ChFamily family = super.save(entity);
		return family;
	}

	@Override
	public ChFamily update(ChFamily entity) throws Exception {
		ChFamily family = super.update(entity);
		return family;
	}

	@Override
	public ChFamily saveOrUpdate(ChFamily entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteById(Serializable id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ChFamily> deleteByIds(Serializable[] ids) throws Exception {
		
		return super.deleteByIds(ids);
	}

	@Override
	public ChFamily get(Serializable id) throws Exception {		
		return super.get(id);
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
	public ChFamily findOne(HqlBuilder hqlBuilder) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChFamily findOne(String queryName, Map<String, ?> paramMap)
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
