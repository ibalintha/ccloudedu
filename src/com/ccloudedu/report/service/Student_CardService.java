package com.ccloudedu.report.service;

import java.util.ArrayList;
import java.util.List;

import com.ccloudedu.report.entity.ChStudent_Card;


public  interface Student_CardService {
	public List<ChStudent_Card> findStudentslist(String chStudSchcode,
			String chStudName) throws Exception;
	public List<ChStudent_Card> getChStudent_CardList();
}
