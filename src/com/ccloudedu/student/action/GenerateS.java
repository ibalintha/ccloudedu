package com.ccloudedu.student.action;

public class GenerateS {
	private int s[];
	
	public GenerateS (int StuNum, int ClasNum) {
		s = new int[StuNum];
		
		int stayFlag = 0;
		int addFlag = 1;
		int count = 1;
		
		for (int i = 0; i < StuNum; i++) {
			s[i] = count;
			
			if (count == ClasNum && stayFlag == 0 && addFlag == 1) {
				stayFlag = 1;
			}
			else if (count == ClasNum && stayFlag == 1 && addFlag == 1) {
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
	}
	
	//Get all student's class order
	public int[] getAllStu() {
		return s;
	}
	
	//Get the class of student n
	public int getPerStu(int n) {
		return s[n];
	}
}
