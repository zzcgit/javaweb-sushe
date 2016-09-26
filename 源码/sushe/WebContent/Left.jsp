<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<link href="Style/Style.css" rel="stylesheet" type="text/css" />
<table width="155" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td height="31" align="center" background="Images/left1.jpg"><strong>系统选项</strong></td>
            </tr>
            <tr>
              <td height="50" align="center" valign="top"><table width="150" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="Index.jsp">后台首页</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <%if(session.getAttribute("type").toString().equals("1")){%>
                <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="TeacherManager.action">楼宇管理员管理</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="StudentManager.action">学生管理</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="BuildingManager.action">楼宇管理</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="DomitoryManager.action">宿舍管理</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="StudentRZ.action">学生入住登记</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="StudentTH.jsp">学生寝室调换</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="StudentQC.jsp">学生迁出登记</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="AdminLog.action">学生缺寝记录</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="OutList.action">迁出记录</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <%}%>
                <%if(session.getAttribute("type").toString().equals("2")){%>
                <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="MyStudent.action">学生管理</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="MyLog.action">学生缺寝记录</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <%}%>
                <%if(session.getAttribute("type").toString().equals("3")){%>
                <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="StudentLog.action">我的缺寝记录</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <%}%>
                <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="PasswordUpdate.jsp">修改密码</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="Images/ic.gif" width="1" height="1"></td>
                </tr>
                <tr>
                  <td height="30" align="center" background="Images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="Quit.action" onclick="return confirm('确定要退出系统吗？')">退出系统</a></td>
                </tr>
              </table>
              </td>
            </tr>
          </table>