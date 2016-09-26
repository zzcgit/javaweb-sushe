package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class DomitoryAddSave extends ActionSupport {

	//下面是Action内用于封装用户请求参数的属性
	private String Domitory_BuildingID ;
    private String Domitory_Name ;
    private String Domitory_Type ;
    private String Domitory_Number ;
    private String Domitory_Tel ;


	public String getDomitory_BuildingID() {
		return Domitory_BuildingID;
	}

	public void setDomitory_BuildingID(String domitoryBuildingID) {
		Domitory_BuildingID = domitoryBuildingID;
	}

	public String getDomitory_Name() {
		return Domitory_Name;
	}

	public void setDomitory_Name(String domitoryName) {
		Domitory_Name = domitoryName;
	}

	public String getDomitory_Type() {
		return Domitory_Type;
	}

	public void setDomitory_Type(String domitoryType) {
		Domitory_Type = domitoryType;
	}

	public String getDomitory_Number() {
		return Domitory_Number;
	}

	public void setDomitory_Number(String domitoryNumber) {
		Domitory_Number = domitoryNumber;
	}

	public String getDomitory_Tel() {
		return Domitory_Tel;
	}

	public void setDomitory_Tel(String domitoryTel) {
		Domitory_Tel = domitoryTel;
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
		List<DomitoryBean> list=new DomitoryDao().GetList("Domitory_Name='"+Domitory_Name+"' and Domitory_BuildingID="+Domitory_BuildingID, "");
		if(list.size()>0)
		{
			out.print("<script language='javascript'>alert('该楼宇中已经存在该寝室号！');history.back(-1);</script>");
			out.flush();out.close();return null;
		}
		//添加
		DomitoryBean cnbean=new DomitoryBean();
		cnbean.setDomitory_BuildingID(Integer.parseInt(Domitory_BuildingID));
		cnbean.setDomitory_Name(Domitory_Name);
		cnbean.setDomitory_Type(Domitory_Type);
		cnbean.setDomitory_Number(Domitory_Number);
		cnbean.setDomitory_Tel(Domitory_Tel);
		new DomitoryDao().Add(cnbean);
		    
		//跳转
		out.print("<script language='javascript'>alert('添加成功！');window.location='DomitoryManager.action';</script>");
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
