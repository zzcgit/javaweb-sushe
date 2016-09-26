package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class TBAddSave extends ActionSupport {

	//下面是Action内用于封装用户请求参数的属性
	private String TB_TeacherID ;
    private String TB_BuildingID ;
	public String getTB_TeacherID() {
		return TB_TeacherID;
	}

	public void setTB_TeacherID(String tBTeacherID) {
		TB_TeacherID = tBTeacherID;
	}

	public String getTB_BuildingID() {
		return TB_BuildingID;
	}

	public void setTB_BuildingID(String tBBuildingID) {
		TB_BuildingID = tBBuildingID;
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
		
		//查询是否存在
		List<TBBean> list=new TBDao().GetList("TB_TeacherID='"+TB_TeacherID+"' and TB_BuildingID="+TB_BuildingID, "");
		if(list.size()>0)
		{
			out.print("<script language='javascript'>alert('该管理员已经在管理本楼宇了，不要重复添加！');history.back(-1);</script>");
			out.flush();out.close();return null;
		}
		
		//添加
		TBBean cnbean=new TBBean();
		cnbean.setTB_TeacherID(Integer.parseInt(TB_TeacherID));
		cnbean.setTB_BuildingID(Integer.parseInt(TB_BuildingID));

		new TBDao().Add(cnbean);
		    
		//跳转
		out.print("<script language='javascript'>alert('添加成功！');window.location='TBManager.action?Building_ID="+TB_BuildingID+"';</script>");
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
