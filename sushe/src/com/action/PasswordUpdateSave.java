package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class PasswordUpdateSave extends ActionSupport {

	//下面是Action内用于封装用户请求参数的属性
	private String Password;
	private String Password2;
	private String Msg;
	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getPassword2() {
		return Password2;
	}

	public void setPassword2(String password2) {
		Password2 = password2;
	}

	public String getMsg() {
		return Msg;
	}

	public void setMsg(String msg) {
		Msg = msg;
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
		String type=session.getAttribute("type").toString();
		if(type.equals("1"))//校园管理员身份
		{
			//查询原密码是否正确
			if (new AdminDao().CheckPassword(session.getAttribute("id").toString(), Password)) {
				//修改密码
				AdminBean cnbean=new AdminBean();
				cnbean=new AdminDao().GetBean(Integer.parseInt(session.getAttribute("id").toString()));
				cnbean.setAdmin_Password(Password2);
				new AdminDao().Update(cnbean);
				out.print("<script language='javascript'>alert('修改成功！');window.location='PasswordUpdate.jsp';</script>");
				out.flush();out.close();return null;
			}
			else
			{
				Msg = "用户名或者密码错误";
				return INPUT;
			}
		}
		else if(type.equals("2"))//楼宇管理员身份
		{
			//查询原密码是否正确
			if (new TeacherDao().CheckPassword(session.getAttribute("id").toString(), Password)) {
				//修改密码
				TeacherBean cnbean=new TeacherBean();
				cnbean=new TeacherDao().GetBean(Integer.parseInt(session.getAttribute("id").toString()));
				cnbean.setTeacher_Password(Password2);
				new TeacherDao().Update(cnbean);
				out.print("<script language='javascript'>alert('修改成功！');window.location='PasswordUpdate.jsp';</script>");
				out.flush();out.close();return null;
			}
			else
			{
				Msg = "用户名或者密码错误";
				return INPUT;
			}
		}
		else if(type.equals("3"))//学生身份
		{
			//查询原密码是否正确
			if (new StudentDao().CheckPassword(session.getAttribute("id").toString(), Password)) {
				//修改密码
				StudentBean cnbean=new StudentBean();
				cnbean=new StudentDao().GetBean(Integer.parseInt(session.getAttribute("id").toString()));
				cnbean.setStudent_Password(Password2);
				new StudentDao().Update(cnbean);
				out.print("<script language='javascript'>alert('修改成功！');window.location='PasswordUpdate.jsp';</script>");
				out.flush();out.close();return null;
			}
			else
			{
				Msg = "用户名或者密码错误";
				return INPUT;
			}
		}
		else
		{
			out.print("<script language='javascript'>alert('请重新登录！');window.location='Login.jsp';</script>");
			out.flush();out.close();return null;
		}
		

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
