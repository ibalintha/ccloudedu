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
import com.ccloudedu.common.entity.ChPractice;
import com.ccloudedu.student.service.PracticeService;

@Service
@Transactional
public class PracticeServiceImpl extends BaseServiceImpl<ChPractice> implements PracticeService{

	@SuppressWarnings("unchecked")
	@Override
	public List<ChPractice> getList(String chScroId) throws Exception {
		Map<String,String> paramMap = new FastMap().newHashMap()
				.set("chScroId", "%"+chScroId+"%");
		return super.findList("enrolment.findPractice",paramMap);
	}
	@SuppressWarnings("unchecked")
	@Override
	public void deletePracticeByScroIds(String[] scroIds) throws Exception {
		for(String scroId:scroIds){
			Map<String,String> paramMap = new FastMap().newHashMap()
					.set("scroId", "%"+scroId+"%");
			super.batch("enrolment.deletePracticeScroId",paramMap);
		}
	}

	@Override
	public ChPractice save(ChPractice entity) throws Exception {
		// TODO Auto-generated method stub
		return super.save(entity);
	}

	@Override
	public ChPractice saveOrUpdate(ChPractice entity) throws Exception {
		// TODO Auto-generated method stub
		return super.saveOrUpdate(entity);
	}

	@Override
	public ChPractice update(ChPractice entity) throws Exception {
		// TODO Auto-generated method stub
		return super.update(entity);
	}

	@Override
	public void delete(ChPractice entity) throws Exception {
		// TODO Auto-generated method stub
		super.delete(entity);
	}

	@Override
	public List<ChPractice> deleteByIds(Serializable[] ids) throws Exception {
		// TODO Auto-generated method stub
		return super.deleteByIds(ids);
	}

	@Override
	public boolean deleteById(Serializable id) throws Exception {
		// TODO Auto-generated method stub
		return super.deleteById(id);
	}

	@Override
	public ChPractice get(Serializable id) throws Exception {
		// TODO Auto-generated method stub
		return super.get(id);
	}

	@Override
	public int batch(HqlBuilder hqlBuilder) throws Exception {
		// TODO Auto-generated method stub
		return super.batch(hqlBuilder);
	}

	@Override
	public int batch(String queryName, Map<String, ?> paramMap)
			throws Exception {
		// TODO Auto-generated method stub
		return super.batch(queryName, paramMap);
	}

	@Override
	public int findCount(HqlBuilder hqlBuilder) throws Exception {
		// TODO Auto-generated method stub
		return super.findCount(hqlBuilder);
	}

	@Override
	public int findCount(String queryName, Map<String, ?> paramMap)
			throws Exception {
		// TODO Auto-generated method stub
		return super.findCount(queryName, paramMap);
	}

	@Override
	public ChPractice findOne(HqlBuilder hqlBuilder) throws Exception {
		// TODO Auto-generated method stub
		return super.findOne(hqlBuilder);
	}

	@Override
	public ChPractice findOne(String queryName, Map<String, ?> paramMap)
			throws Exception {
		// TODO Auto-generated method stub
		return super.findOne(queryName, paramMap);
	}

	@Override
	public Map<?, ?> findMap(HqlBuilder hqlBuilder, String keyPropertyName,
			Object clazzOrPropertyName) throws Exception {
		// TODO Auto-generated method stub
		return super.findMap(hqlBuilder, keyPropertyName, clazzOrPropertyName);
	}

	@Override
	public Map<?, ?> findMap(String queryName, String keyPropertyName,
			Object clazzOrPropertyName, Map<String, ?> paramMap)
			throws Exception {
		// TODO Auto-generated method stub
		return super.findMap(queryName, keyPropertyName, clazzOrPropertyName, paramMap);
	}

	@Override
	public List findList(HqlBuilder hqlBuilder) throws Exception {
		// TODO Auto-generated method stub
		return super.findList(hqlBuilder);
	}

	@Override
	public List findList(String queryName, Map<String, ?> paramMap)
			throws Exception {
		// TODO Auto-generated method stub
		return super.findList(queryName, paramMap);
	}

	@Override
	public Page findPage(Page page, HqlBuilder hqlBuilder) throws Exception {
		// TODO Auto-generated method stub
		return super.findPage(page, hqlBuilder);
	}

	@Override
	public Page findPage(Page page, String queryName, Map<String, ?> paramMap)
			throws Exception {
		// TODO Auto-generated method stub
		return super.findPage(page, queryName, paramMap);
	}
}
