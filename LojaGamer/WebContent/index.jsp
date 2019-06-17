<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%-- <meta charset="ISO-8859-1" http-equiv="refresh" content="0; url=<%= request.getContextPath() %>/Signedin/Pragas/ListarPragasServlet"> --%>
<meta charset="ISO-8859-1" http-equiv="refresh" content="0; url=<%= request.getContextPath() %>/LoginServlet?login=root&senha=1">
<title>The Snapper</title>
</head>
<body>
	<h1><a href="<%= request.getContextPath() %>/Signedin/Usuarios/ListarUsuariosServlet">The Snapper</a></h1>
</body>
</html>