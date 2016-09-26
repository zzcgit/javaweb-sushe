package com.bean;
public class OutBean {

    private int Out_ID ;
    private int Out_StudentID ;
    private String Out_Date ;
    private String Out_Remark ;
	public int getOut_ID() {
		return Out_ID;
	}
	public void setOut_ID(int outID) {
		Out_ID = outID;
	}
	public int getOut_StudentID() {
		return Out_StudentID;
	}
	public void setOut_StudentID(int outStudentID) {
		Out_StudentID = outStudentID;
	}
	public String getOut_Date() {
		return Out_Date;
	}
	public void setOut_Date(String outDate) {
		Out_Date = outDate;
	}
	public String getOut_Remark() {
		return Out_Remark;
	}
	public void setOut_Remark(String outRemark) {
		Out_Remark = outRemark;
	}
	private String Student_Username ;
    private String Student_Name ;
    private String Student_Sex ;
    private String Student_Class ;
	public String getStudent_Username() {
		return Student_Username;
	}
	public void setStudent_Username(String studentUsername) {
		Student_Username = studentUsername;
	}
	public String getStudent_Name() {
		return Student_Name;
	}
	public void setStudent_Name(String studentName) {
		Student_Name = studentName;
	}
	public String getStudent_Sex() {
		return Student_Sex;
	}
	public void setStudent_Sex(String studentSex) {
		Student_Sex = studentSex;
	}
	public String getStudent_Class() {
		return Student_Class;
	}
	public void setStudent_Class(String studentClass) {
		Student_Class = studentClass;
	}
	
}