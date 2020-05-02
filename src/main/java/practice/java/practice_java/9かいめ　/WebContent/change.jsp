<%@ page language="java" contentType="text/html;charset=Windows-31J" %>
<%@page import="info.searchman.lesson.java_mysql.ShainBeans"%>

<html>
<body>

<%
ShainBeans shain =(ShainBeans)request.getAttribute( "shain" );
%>

<br>

以下から変更できます。<br>
<br>
<form action="/java_mysql/Edit" method="POST">

	ID: <%= shain.getId()%>（変更不可）
	<input type="hidden" name="id"  value="<%= shain.getId()%>">

	名前: <input type="text" name="name"  value="<%= shain.getName()%>">
	

	性別：<SELECT NAME="sei">
        <OPTION VALUE="<%= shain.getSei()%>" selected><%= shain.getSei()%></OPTION>
        <OPTION VALUE="男">男</OPTION>
        <OPTION VALUE="女">女</OPTION>
      </SELECT>

	入社年：<SELECT NAME="nen">
        <OPTION VALUE="<%= shain.getNen()%>" selected><%= shain.getNen()%></OPTION>
        <OPTION VALUE="2002">2002</OPTION>
        <OPTION VALUE="2003">2003</OPTION>
        <OPTION VALUE="2004">2004</OPTION>
        <OPTION VALUE="2005">2005</OPTION>
        <OPTION VALUE="2006">2006</OPTION>
      </SELECT>

	住所: <input type="text" name="address" value="<%= shain.getAddress()%>">

	<br><br>

	<input type="hidden" name="mode" value="del_add">
	<input type="submit" value="変更確定">
</form>


<br>


<a href="./index.jsp">トップに戻る</a>

</body>
</html>