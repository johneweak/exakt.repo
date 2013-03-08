package com.gsis.bom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.gsis.dao.ConnectionPoolManager;

public class Questions {
	
	//Connection con = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;
	//DBConnection dbc = new DBConnection();
	String sql;
	Statement stm;
	
	int questionID;
	String questions;

	public Questions(int questionID, String questions) {
		this.questionID = questionID;
		this.questions = questions;
	}
	public Questions() {
	}
	

	public int getQuestionID() {
		return questionID;
	}
	public void setQuestionID(int questionID) {
		this.questionID = questionID;
	}
	public String getQuestions() {
		return questions;
	}
	public void setQuestions(String questions) {
		this.questions = questions;
	}
	public ArrayList<Questions> viewAllQuestions1(){

		try{
			Connection con = ConnectionPoolManager.getConnection();
			//con = dbc.getConnection();

			sql = "SELECT questionID, question FROM tblquestions where questionID >=1 and questionID <=5";
			stm = con.createStatement();
			rs = stm.executeQuery(sql);

			ArrayList<Questions> m2 = new ArrayList<Questions>();
			while(rs.next()){				
				Questions mem = new Questions(rs.getInt("questionID"), rs.getString("question"));
				m2.add(mem);
			}		
			return m2;

		}catch(Exception ex){
			System.out.println(ex.getMessage()+"viewAllQuestions");			
			return null;
		}
		finally{
			try{
				rs.close();
				stm.close();
				//	con.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}
	
	public ArrayList<Questions> viewAllQuestions2(){

		try{
			Connection con = ConnectionPoolManager.getConnection();
			//con = dbc.getConnection();

			sql = "select questionID, question from tblquestions where questionID >=6 and questionID <=10";
			stm = con.createStatement();
			rs = stm.executeQuery(sql);

			ArrayList<Questions> m2 = new ArrayList<Questions>();
			while(rs.next()){
				Questions mem = new Questions(rs.getInt("questionID"), rs.getString("question"));
				m2.add(mem);
			}		
			return m2;

		}catch(Exception ex){
			System.out.println(ex.getMessage()+"viewAllQuestions");			
			return null;
		}
		finally{
			try{
				rs.close();
				stm.close();
				//	con.close();
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}

}