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

import com.ccloudedu.report.entity.ChStudent_Card;
import com.ccloudedu.report.service.Student_CardService;


/**
 * 查询三个表student family 得到数据填充student_card
 * @author wade
 *
 */

public class Student_CardServiceImpl implements Student_CardService{

	@Override
	public List<ChStudent_Card> findStudentslist(String chStudSchcode,
			String chStudName) throws Exception {
		// TODO Auto-generated method stub
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); 
		Connection conn = DriverManager.getConnection(
                  "jdbc:sqlserver://10.3.30.32:1433;DatabaseName=ccloudEdu", "sa", "changhong_406");
		//执行查询，用ResultSet类的对象，返回查询的结果
        String query = "SELECT * FROM [dbo].[ch_student]";
        
        Statement sqlStatement = null;
		ResultSet result = sqlStatement.executeQuery(query);
		
		ChStudent_Card student_card = null;
		List<ChStudent_Card> student_map = new ArrayList<ChStudent_Card>();
		//对获得的查询结果进行处理，对Result类的对象进行操作
        while (result.next() ) 
        {
        	if( (chStudSchcode ==  result.getString("ch_stud_schcode")))
        	{
        		student_card.setChStudName( result.getString("ch_stud_name") );
        	
        		student_card.setChStudSchcode( result.getString("ch_stud_schcode"));
             
        		student_card.setChStudBirth(result.getString("ch_stud_birth"));
        		
        		student_map.add(student_card);
        	}
        }
		return student_map;
	}

	@Override
	public List<ChStudent_Card> getChStudent_CardList() {
		// TODO Auto-generated method stub
		List<ChStudent_Card> ChStudent_CardList = new ArrayList<ChStudent_Card>();
		ChStudent_CardList.add(new ChStudent_Card(
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
		
		return ChStudent_CardList;
	}

	
}
