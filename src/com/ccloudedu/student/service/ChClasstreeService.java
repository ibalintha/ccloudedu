package com.ccloudedu.student.service;

import java.util.List;

import com.ccloudedu.base.service.BaseService;
import com.ccloudedu.common.entity.ChClasstree;

public interface ChClasstreeService extends BaseService<ChClasstree>{
	
	public List<ChClasstree> findClasstree(String id, String parentId, String name) throws Exception;
}