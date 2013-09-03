package com.ccloudedu.report.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ccloudedu.base.service.impl.BaseServiceImpl;
import com.ccloudedu.base.utils.FastMap;
import com.ccloudedu.common.entity.ChStudent;
import com.ccloudedu.report.entity.ChStudentCard;
import com.ccloudedu.report.service.StudentCardService;


/**
 * 查询三个表student family 得到数据填充student_card
 * @author wade
 *
 */

public class StudentCardServiceImpl extends BaseServiceImpl<ChStudent>  implements StudentCardService{

	@SuppressWarnings("unchecked")
	public List<ChStudent> findStudentslist(String chStudSchcode,String chStudName) throws Exception  {
//		String parentDeptLevel = deptDao.get(SysDept.class, user.getSysDept().getId()).getDeptLevel(); 
		Map<String,String> paramMap = new FastMap().newHashMap()
		.set("chStudSchcode", "%"+chStudSchcode+"%")
		.set("chStudName", "%"+chStudName+"%");
//		.set("userIdList", userIdList)//userIdList !=null 时，是查看在线用户 && user.getUserRoleType()==YN.N
//		.set("parentDeptLevel", null); 
		return this.findList("student.findStudents",paramMap);
	}

	@Override
	public List<ChStudentCard> getChStudentCardList() {
		// TODO Auto-generated method stub
		List<ChStudentCard> ChStudentCardList = new ArrayList<ChStudentCard>();
		ChStudentCardList.add(new ChStudentCard(
		"2013112",
		"20131136435422","莉莉","女",
		"2011-2-2","四川绵阳","汉族",
		"党员","四川绵阳南山区","610101",
		"良好","f:/sfsfsfsfs/",
		"爸爸","黄得到","33","工人","158585858",
		"妈妈","黄得到","33","工人","158585858",
		"弟弟","黄得到","33","工人","158585858",
		"姐姐","黄得到","33","工人","158585858",
		"158585858",
		"1","33","第二学期","2013-1-1",
		"2","33","第二学期","2013-1-1",
		"3","33","第二学期","2013-1-1",
		"4","33","第二学期","2013-1-1",
		"f://fsfssf","2013-1-1",
		"5465454","绵阳中学",
		"无"	,"Mr.right"
		));
		
		return ChStudentCardList;
	}

	
}
