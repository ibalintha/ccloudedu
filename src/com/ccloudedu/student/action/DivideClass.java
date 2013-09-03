package com.ccloudedu.student.action;
import java.util.LinkedList;
import java.util.List;
/**
 * 分班算法
 * @author yiyang\sungege
 * 2013-07-8 
 */
public class DivideClass {
	private int stuOrder[];
	private int stuNum;
	private int clasNum;
	private List<StuClas> stuClas = new LinkedList<StuClas>();
	
	public DivideClass (String[] stuID, String[] clasID) {
		stuNum = stuID.length;
		clasNum = clasID.length;
		
		stuOrder = new int[stuNum];
		
		int stayFlag = 0;
		int addFlag = 1;
		int count = 1;
		
		for (int i = 0; i < stuNum; i++) {
			stuOrder[i] = count;
			
			if (count == clasNum && stayFlag == 0 && addFlag == 1) {
				stayFlag = 1;
			}
			else if (count == clasNum && stayFlag == 1 && addFlag == 1) {
				stayFlag = 0;
				addFlag = 0;
			}
			else if (count == 1 && stayFlag == 0 && addFlag == 0) {
				stayFlag = 1;
			}
			else if (count == 1 && stayFlag == 1 && addFlag == 0) {
				stayFlag = 0;
				addFlag = 1;
			}
			
			if (addFlag == 1 && stayFlag == 0) {
				count++;
			}
			else if (addFlag == 1 && stayFlag == 1) {
				continue;
			}
			else if (addFlag == 0 && stayFlag == 0) {
				count--;
			}
			else if (addFlag == 0 && stayFlag == 1) {
				continue;
			}
		}
		
		for (int i = 0; i < stuNum; i++) {
			StuClas tmp = new StuClas();
			tmp.stuID = stuID[i];
			tmp.classID = clasID[stuOrder[i]-1];
			stuClas.add(tmp);
		}
	}
	
	//Get all student's class order
	public int[] getClassOrder() {
		return stuOrder;
	}
	
	//Get the class of student n
	public int getPerStuClas(int n) {
		return stuOrder[n];
	}
	
	//Map student and class into list
	public List<StuClas> getStuClas() {
		return stuClas;
	}
}

class StuClas {
	public String stuID;
	public String classID;
}