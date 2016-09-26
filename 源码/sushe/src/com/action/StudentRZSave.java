package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class StudentRZSave extends ActionSupport {

	//下面是Action内用于封装用户请求参数的属性
	private String Building_ID ;
    private String Domitory_ID ;
    private String Student_Username ;
	public String getBuilding_ID() {
		return Building_ID;
	}

	public void setBuilding_ID(String buildingID) {
		Building_ID = buildingID;
	}

	public String getDomitory_ID() {
		return Domitory_ID;
	}

	public void setDomitory_ID(String domitoryID) {
		Domitory_ID = domitoryID;
	}

	public String getStudent_Username() {
		return Student_Username;
	}

	public void setStudent_Username(String studentUsername) {
		Student_Username = studentUsername;
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
		
		StudentBean sbean=new StudentBean();
		//查询用户名是否存在
		List<StudentBean> list=new StudentDao().GetAllList("Student_Username='"+Student_Username+"'", "");
		if(list.size()<1)
		{
			out.print("<script language='javascript'>alert('学号不存在！');history.back(-1);</script>");
			out.flush();out.close();return null;
		}
		else
		{
			sbean=new StudentDao().GetAllFirstBean("Student_Username='"+Student_Username+"'");
			if(!(sbean.getStudent_State().equals("未入住")))
			{
				out.print("<script language='javascript'>alert('该学生处于"+sbean.getStudent_State()+"状态，禁止入住操作！');history.back(-1);</script>");
				out.flush();out.close();return null;
			}
		}
		//修改
		StudentBean cnbean=new StudentBean();
		cnbean=new StudentDao().GetAllBean(sbean.getStudent_ID());
		cnbean.setStudent_DomitoryID(Integer.parseInt(Domitory_ID));
		cnbean.setStudent_State("入住");
		new StudentDao().Update(cnbean);
		    
		//跳转
		out.print("<script language='javascript'>alert('入住操作成功！');window.location='StudentRZ.action';</script>");
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
