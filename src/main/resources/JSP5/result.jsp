<%@ page language="java" contentType="text/html;charset=Windows-31J" %>

<html>
<head>
	<title></title>
</head>
<body>
<br>

<%
	String message = (String)request.getAttribute( "login" );
	String name = (String)request.getAttribute( "name" );
%>

<br><br>
 <%= message %> <br><br>
 
こんにちは　<%= name %> さん<br><br>

<a href="/jsp_servlet/name.jsp">次のページに行く</a>


</body>
</html>
