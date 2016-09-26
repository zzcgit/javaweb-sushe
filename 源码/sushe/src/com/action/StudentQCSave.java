package com.action;

import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class StudentQCSave extends ActionSupport {

	//下面是Action内用于封装用户请求参数的属性
	private String Student_ID ;
	private String Out_Remark ;
	public String getOut_Remark() {
		return Out_Remark;
	}

	public void setOut_Remark(String outRemark) {
		Out_Remark = outRemark;
	}

	public String getStudent_ID() {
		return Student_ID;
	}

	public void setStudent_ID(String studentID) {
		Student_ID = studentID;
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
		

		//修改学生状态
		StudentBean cnbean=new StudentBean();
		cnbean=new StudentDao().GetBean(Integer.parseInt(Student_ID));
		cnbean.setStudent_State("迁出");
		new StudentDao().Update(cnbean);
		
		//添加迁出记录
		OutBean outbean=new OutBean();
		outbean.setOut_StudentID(Integer.parseInt(Student_ID));
		outbean.setOut_Date(getNowdate());
		outbean.setOut_Remark(Out_Remark);

		new OutDao().Add(outbean);
		    
		//跳转
		out.print("<script language='javascript'>alert('学生迁出操作成功！');window.location='StudentTH.jsp';</script>");
		out.flush();out.close();return null;
		
	}
	//获取当前日期
	public String getNowdate(){
		Calendar c=Calendar.getInstance();
		c.add(Calendar.MONTH, 1);
		int year=c.get(Calendar.YEAR);
		int month=c.get(Calendar.MONTH);
		int date=c.get(Calendar.DATE);
		return year+"-"+month+"-"+date;
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
