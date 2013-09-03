package com.ccloudedu.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ccloudedu.base.dao.hibernate.BaseHibernateDao;
import com.ccloudedu.base.service.impl.BaseServiceImpl;
import com.ccloudedu.common.entity.ChTeacher;
import com.ccloudedu.system.service.TeacherService;

@Service
@Transactional
public class TeacherServiceImpl extends BaseServiceImpl<ChTeacher> implements TeacherService {

	@Autowired
	private BaseHibernateDao<ChTeacher> chTeacherDao;
	
	@SuppressWarnings("unchecked")
    public List<ChTeacher> findTeachers() throws Exception {
	    return chTeacherDao.findList("system.findTeachers", null);
    }

}
