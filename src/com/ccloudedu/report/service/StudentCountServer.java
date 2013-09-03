package com.ccloudedu.report.service;

import java.util.ArrayList;
import java.util.List;

import com.ccloudedu.report.entity.ChStudentCount;


public class StudentCountServer {
	public List<ChStudentCount> getAllStudentCount() {
		List<ChStudentCount> StuCountList = new ArrayList<ChStudentCount>();
		StuCountList.add(new ChStudentCount("高一10班", "1", "2", "3", "4", "2", "3", "4", "5", "6", "7", "2", "2", "6"));
		StuCountList.add(new ChStudentCount("高一20班", "5", "2", "4", "4", "4", "3", "7", "5", "0", "0", "3", "2", "0"));
		StuCountList.add(new ChStudentCount("小计", "6", "4", "7", "8", "6", "3", "5", "5", "6", "7", "5", "4", "6"));
		StuCountList.add(new ChStudentCount("合计", "6", "4", "7", "8", "6", "3", "5", "5", "6", "7", "5", "4", "6"));
		
		return StuCountList;
		
	}
}
