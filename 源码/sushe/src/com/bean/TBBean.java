package com.bean;
public class TBBean {

    private int TB_ID ;
    private int TB_TeacherID ;
    private int TB_BuildingID ;
	public int getTB_ID() {
		return TB_ID;
	}
	public void setTB_ID(int tBID) {
		TB_ID = tBID;
	}
	public int getTB_TeacherID() {
		return TB_TeacherID;
	}
	public void setTB_TeacherID(int tBTeacherID) {
		TB_TeacherID = tBTeacherID;
	}
	public int getTB_BuildingID() {
		return TB_BuildingID;
	}
	public void setTB_BuildingID(int tBBuildingID) {
		TB_BuildingID = tBBuildingID;
	}
	private String Teacher_Name ;
    private String Teacher_Sex ;
    private String Teacher_Tel ;
	public String getTeacher_Name() {
		return Teacher_Name;
	}
	public void setTeacher_Name(String teacherName) {
		Teacher_Name = teacherName;
	}
	public String getTeacher_Sex() {
		return Teacher_Sex;
	}
	public void setTeacher_Sex(String teacherSex) {
		Teacher_Sex = teacherSex;
	}
	public String getTeacher_Tel() {
		return Teacher_Tel;
	}
	public void setTeacher_Tel(String teacherTel) {
		Teacher_Tel = teacherTel;
	}
	private String Teacher_Username ;
	public String getTeacher_Username() {
		return Teacher_Username;
	}
	public void setTeacher_Username(String teacherUsername) {
		Teacher_Username = teacherUsername;
	}
	private String Building_Name ;
	public String getBuilding_Name() {
		return Building_Name;
	}
	public void setBuilding_Name(String buildingName) {
		Building_Name = buildingName;
	}
}
