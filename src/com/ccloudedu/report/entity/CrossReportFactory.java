package com.ccloudedu.report.entity;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CrossReportFactory {

	public static Collection getData(){		
		 List<Map<Object, Object>> subGuestName = new ArrayList<Map<Object, Object>>();
            
		 //第一行A1
			subGuestNameInit(subGuestName, "新招生", "A1","group1", "data1");
			subGuestNameInit(subGuestName, "转入", "A1","group1", "data12");
			subGuestNameInit(subGuestName, "复学", "A1","group1", "data13");
			
			subGuestNameInit(subGuestName, "新招生", "A1","group1", "data1");
			subGuestNameInit(subGuestName, "转入", "A1","group1", "data12");
			subGuestNameInit(subGuestName, "复学", "A1","group1", "data13");
		
		//第二行A2
			subGuestNameInit(subGuestName, "新招生", "A2","group1", "data123");
			subGuestNameInit(subGuestName, "转入", "A2","group1", "data1234");
			subGuestNameInit(subGuestName, "复学", "A2","group1", "data12345");
			
			subGuestNameInit(subGuestName, "新招生", "A1","group1", "data1");
			subGuestNameInit(subGuestName, "转入", "A1","group1", "data12");
			subGuestNameInit(subGuestName, "复学", "A1","group1", "data13");
		
		//第三行还是按C1、C2、C3分3列，但却又按row2分多行
			subGuestNameInit(subGuestName, "新招生", "A3","g2","d1");	
			subGuestNameInit(subGuestName, "转入", "A3","g2", "d12");	
			subGuestNameInit(subGuestName, "复学", "A3","g2", "d123");
			subGuestNameInit(subGuestName, "新招生", "A1","group1", "data1");
			subGuestNameInit(subGuestName, "转入", "A1","group1", "data12");
			subGuestNameInit(subGuestName, "复学", "A1","group1", "data13");
		
			subGuestNameInit(subGuestName, "新招生", "A3","g3","d11");	
			subGuestNameInit(subGuestName, "转入", "A3","g3", "d22");	
			subGuestNameInit(subGuestName, "复学", "A3","g3", "d33");
			
			subGuestNameInit(subGuestName, "新招生", "A1","group1", "data1");
			subGuestNameInit(subGuestName, "转入", "A1","group1", "data12");
			subGuestNameInit(subGuestName, "复学", "A1","group1", "data13");
		
			
         return subGuestName;  
	}
	
	 public static void subGuestNameInit(List<Map<Object, Object>> subGuestName,String column,String row,String row2,String value){
		    Map<Object, Object> guestMap = new HashMap<Object, Object>();
		    guestMap.put("deptid", row);
		    guestMap.put("deptid2", row2);   //第三行继续划分使用
		    guestMap.put("degree", column);
		    guestMap.put("empid", value);
		    subGuestName.add(guestMap);
	    }
}
