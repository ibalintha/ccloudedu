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
import com.ccloudedu.common.entity.ChComment;
import com.ccloudedu.student.service.CommentsService;

@Service
@Transactional
public class CommentsServiceImpl extends BaseServiceImpl<ChComment> implements
		CommentsService {

	@SuppressWarnings("unchecked")
	@Override
	public List<ChComment> getCommentById(String chScroId) throws Exception {
		
		Map<String,String> paramMap = new FastMap().newHashMap()
				.set("chScroId", "%"+chScroId+"%");
		return super.findList("enrolment.findComment",paramMap);
	}

	@SuppressWarnings("unchecked")
	@Override
	public int deleteCommentById(String commentId) throws Exception {
		Map<String,String> paramMap = new FastMap().newHashMap()
				.set("commentId", "%"+commentId+"%");
		return super.batch("enrolment.deleteComment",paramMap);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void deleteCommentByScroIds(String[] scroIds) throws Exception {
		for(String scroId:scroIds){
			Map<String,String> paramMap = new FastMap().newHashMap()
					.set("scroId", "%"+scroId+"%");
			super.batch("enrolment.deleteScroId",paramMap);
		}
		
	}
	
	@Override
	public ChComment save(ChComment entity) throws Exception {
		ChComment cc = super.save(entity);
		return cc;
	}

	@Override
	public ChComment update(ChComment entity) throws Exception {
		ChComment cc = super.update(entity);
		return cc;
	}

	@Override
	public ChComment saveOrUpdate(ChComment entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteById(Serializable id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ChComment> deleteByIds(Serializable[] ids) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChComment get(Serializable id) throws Exception {
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
	public ChComment findOne(HqlBuilder hqlBuilder) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ChComment findOne(String queryName, Map<String, ?> paramMap)
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
