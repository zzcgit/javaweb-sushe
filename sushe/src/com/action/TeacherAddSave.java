package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class TeacherAddSave extends ActionSupport {

	//下面是Action内用于封装用户请求参数的属性
	private String Teacher_Username ;
    private String Teacher_Password ;
    private String Teacher_Name ;
    private String Teacher_Sex ;
    private String Teacher_Tel ;
	public String getTeacher_Username() {
		return Teacher_Username;
	}

	public void setTeacher_Username(String cookUsername) {
		Teacher_Username = cookUsername;
	}

	public String getTeacher_Password() {
		return Teacher_Password;
	}

	public void setTeacher_Password(String cookPassword) {
		Teacher_Password = cookPassword;
	}

	public String getTeacher_Name() {
		return Teacher_Name;
	}

	public void setTeacher_Name(String cookName) {
		Teacher_Name = cookName;
	}

	public String getTeacher_Sex() {
		return Teacher_Sex;
	}

	public void setTeacher_Sex(String cookSex) {
		Teacher_Sex = cookSex;
	}

	public String getTeacher_Tel() {
		return Teacher_Tel;
	}

	public void setTeacher_Tel(String cookTel) {
		Teacher_Tel = cookTel;
	}

	//处理用户请求的execute方法
	public String execute() throws Exception {
		
		//解决乱码，用于页面输出
		HttpServletResponse response=null;
		response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		//创建session对象
		HttpSession session = ServletActionContext.getRequest().getSession();
		//验证是否正常登录
		if(session.getAttribute("id")==null){
			out.print("<script language='javascript'>alert('请重新登录！');window.location='Login.jsp';</script>");
			out.flush();out.close();return null;
		}
		
		//查询用户名是否存在
		List<TeacherBean> list=new TeacherDao().GetList("Teacher_Username='"+Teacher_Username+"'", "");
		if(list.size()>0)
		{
			out.print("<script language='javascript'>alert('用户名已经存在！');history.back(-1);</script>");
			out.flush();out.close();return null;
		}
		//添加
		TeacherBean cnbean=new TeacherBean();
		cnbean.setTeacher_Username(Teacher_Username);
		cnbean.setTeacher_Password(Teacher_Password);
		cnbean.setTeacher_Name(Teacher_Name);
		cnbean.setTeacher_Sex(Teacher_Sex);
		cnbean.setTeacher_Tel(Teacher_Tel);
		new TeacherDao().Add(cnbean);
		    
		//跳转
		out.print("<script language='javascript'>alert('添加成功！');window.location='TeacherManager.action';</script>");
		out.flush();out.close();return null;
		
	}
	
	//判断是否空值
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
	//测试
	public static void main(String[] args) {
		System.out.println();
	}
	
}
