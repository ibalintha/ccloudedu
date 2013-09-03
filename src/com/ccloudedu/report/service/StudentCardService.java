package com.ccloudedu.report.service;

import java.util.ArrayList;
import java.util.List;

import com.ccloudedu.common.entity.ChStudent;
import com.ccloudedu.report.entity.ChStudentCard;


public  interface StudentCardService {
	public List<ChStudent> findStudentslist(String chStudSchcode,
			String chStudName) throws Exception;
	public List<ChStudentCard> getChStudentCardList();
}
