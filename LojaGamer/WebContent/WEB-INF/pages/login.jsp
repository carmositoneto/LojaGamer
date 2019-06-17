<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="<%= request.getContextPath() %>/css/bootstrap.min.css" type="text/css" rel="stylesheet">
<link href="<%= request.getContextPath() %>/css/signin.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="<%= request.getContextPath() %>/js/jquery-3.4.0.min.js"></script>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/bootstrap.min.js"></script>
<title>The Snapper</title>
</head>
<body class="text-center">
	<form method="post" action="<%= request.getContextPath() %>/LoginServlet" class="form-signin">
		<img class="mb-4" src="<%= request.getContextPath() %>/GetImageServlet" alt="" height="100">
		<h1 class="h3 mb-3 font-weight-normal">Entre com seu usuário</h1>
		<label for="inputLogin" class="sr-only">Login</label>
		<input type="text" id="inputLogin" name="login" class="form-control" placeholder="Login" required autofocus>
		<label for="inputSenha" class="sr-only">Senha</label>
		<input type="password" id="inputSenha" name="senha" class="form-control" placeholder="Senha" required>
		<input class="btn btn-lg btn-primary btn-block" type="submit" value="Entrar" />
	</form>
</body>
</html>