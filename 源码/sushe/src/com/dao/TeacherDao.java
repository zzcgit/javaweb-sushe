package com.dao;

import com.db.DBHelper;
import com.bean.TeacherBean;

import java.util.*;
import java.sql.*;

public class TeacherDao {
	
	//验证登录
	public String CheckLogin(String username, String password){
		String id = null;
		String sql="select * from Teacher where Teacher_Username='"+username+"' and Teacher_Password='"+password+"'";
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				id = rs.getString("Teacher_ID");
			}
		}
		catch(SQLException ex){}
		return id;
	}
	//验证密码
	public boolean CheckPassword(String id, String password){
		boolean ps = false;
		String sql="select * from Teacher where Teacher_ID='"+id+"' and Teacher_Password='"+password+"'";
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				ps=true;
			}
		}
		catch(SQLException ex){}
		return ps;
	}
	//获取列表
	public List<TeacherBean> GetList(String strwhere,String strorder){
		String sql="select * from Teacher";
		if(!(isInvalid(strwhere)))
		{
			sql+=" where "+strwhere;
		}
		if(!(isInvalid(strorder)))
		{
			sql+=" order by "+strorder;
		}
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		List<TeacherBean> list=new ArrayList<TeacherBean>();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				TeacherBean cnbean=new TeacherBean();
				cnbean.setTeacher_ID(rs.getInt("Teacher_ID"));
				cnbean.setTeacher_Username(rs.getString("Teacher_Username"));
				cnbean.setTeacher_Password(rs.getString("Teacher_Password"));
				cnbean.setTeacher_Name(rs.getString("Teacher_Name"));
				cnbean.setTeacher_Sex(rs.getString("Teacher_Sex"));
				cnbean.setTeacher_Tel(rs.getString("Teacher_Tel"));
				list.add(cnbean);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	//获取指定ID的实体Bean
	public TeacherBean GetBean(int id){
		String sql="select * from Teacher where Teacher_ID="+id;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		TeacherBean cnbean=new TeacherBean();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while(rs.next()){
				cnbean.setTeacher_ID(rs.getInt("Teacher_ID"));
				cnbean.setTeacher_Username(rs.getString("Teacher_Username"));
				cnbean.setTeacher_Password(rs.getString("Teacher_Password"));
				cnbean.setTeacher_Name(rs.getString("Teacher_Name"));
				cnbean.setTeacher_Sex(rs.getString("Teacher_Sex"));
				cnbean.setTeacher_Tel(rs.getString("Teacher_Tel"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnbean;
	}
	
	//添加
	public void Add(TeacherBean cnbean){
		String sql="insert into Teacher (";
		sql+="Teacher_Username,Teacher_Password,Teacher_Name,Teacher_Sex,Teacher_Tel";
		sql+=") values(";
		sql+="'"+cnbean.getTeacher_Username()+"','"+cnbean.getTeacher_Password()+"','"+cnbean.getTeacher_Name()+"','"+cnbean.getTeacher_Sex()+"','"+cnbean.getTeacher_Tel()+"'";
		sql+=")";
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		try{
			stat = conn.createStatement();
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//修改
	public void Update(TeacherBean cnbean){
		String sql="update Teacher set ";
		sql+="Teacher_Username='"+cnbean.getTeacher_Username()+"',";
		sql+="Teacher_Password='"+cnbean.getTeacher_Password()+"',";
		sql+="Teacher_Name='"+cnbean.getTeacher_Name()+"',";
		sql+="Teacher_Sex='"+cnbean.getTeacher_Sex()+"',";
		sql+="Teacher_Tel='"+cnbean.getTeacher_Tel()+"'";
		
		sql+=" where Teacher_ID='"+cnbean.getTeacher_ID()+"'";
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		try{
			stat = conn.createStatement();
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//删除
	public void Delete(String strwhere){
		String sql="delete Teacher where ";
		sql+=strwhere;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		try{
			stat = conn.createStatement();
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stat != null)
					stat.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	
	//判断是否空值
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
	//测试
	public static void main(String[] args) {
		System.out.println("");
	}
	
}

