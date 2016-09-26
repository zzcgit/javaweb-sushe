package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class LogAddSave extends ActionSupport {

	//下面是Action内用于封装用户请求参数的属性
	private String Log_Date ;
    private String Log_Remark ;

	public String getLog_Date() {
		return Log_Date;
	}

	public void setLog_Date(String logDate) {
		Log_Date = logDate;
	}

	public String getLog_Remark() {
		return Log_Remark;
	}

	public void setLog_Remark(String logRemark) {
		Log_Remark = logRemark;
	}

	private String Log_StudentID;
	public String getLog_StudentID() {
		return Log_StudentID;
	}

	public void setLog_StudentID(String logStudentID) {
		Log_StudentID = logStudentID;
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
		
		//添加
		LogBean cnbean=new LogBean();
		cnbean.setLog_StudentID(Integer.parseInt(Log_StudentID));
		cnbean.setLog_TeacherID(Integer.parseInt(session.getAttribute("id").toString()));
		cnbean.setLog_Date(Log_Date);
		cnbean.setLog_Remark(Log_Remark);

		new LogDao().Add(cnbean);
		    
		//跳转
		out.print("<script language='javascript'>alert('缺寝登记成功！');window.location='Index.jsp';</script>");
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
