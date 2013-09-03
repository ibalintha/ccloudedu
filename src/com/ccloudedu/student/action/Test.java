package com.ccloudedu.student.action;

import java.util.List;

public class Test { 

	public static void main(String[] args) { 
		String[] chClasIdsstr =  {"2","5","3","1","11","52","511"};
		String[] chStuIdsstr =  {"Class1","Class2","Class3"};
		
		DivideClass tmpClas = new DivideClass(chClasIdsstr, chStuIdsstr);
		List<StuClas> stuClas = tmpClas.getStuClas();
		
		for (int i = 0; i < chClasIdsstr.length; i++) {
			System.out.println("Class : " + stuClas.get(i).classID + "\tStu : " + stuClas.get(i).stuID);			
		}
	}
}