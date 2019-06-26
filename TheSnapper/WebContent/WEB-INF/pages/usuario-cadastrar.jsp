<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="<%= request.getContextPath() %>/css/bootstrap.min.css" type="text/css" rel="stylesheet">
<link href="<%= request.getContextPath() %>/css/signin.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="<%= request.getContextPath() %>/js/jquery-3.4.0.min.js"></script>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/bootstrap.min.js"></script>
<title>Login Usuário</title>
<style type="text/css">
input::-webkit-outer-spin-button,
input::-webkit-inner-spin-button {
    /* display: none; <- Crashes Chrome on hover */
    -webkit-appearance: none;
    margin: 0; /* <-- Apparently some margin are still there even though it's hidden */
}

input[type=number] {
    -moz-appearance:textfield; /* Firefox */
}
</style>
</head>
<body class="text-center">
	<form action="<%= request.getContextPath() %>/CadastroUsuarioServlet" class="form-signin" method="post" enctype="multipart/form-data">
		<h1 class="h3 mb-3 font-weight-normal">Cadastrar Usuário</h1>
		<label for="inputLogin" class="sr-only">CPF</label>
		<input type="number" id="inputLogin" name="cpf" class="form-control" onKeyPress="if(this.value.length==11) return false;" placeholder="CPF" required autofocus>
		<br>
		<label for="inputsenha" class="sr-only">Senha</label>
		<input type="password" id="inputsenha" name="senha" class="form-control" placeholder="Senha" required>
		<br>
		<label for="inputnome" class="sr-only">Nome</label>
		<input type="text" id="inputnome" name="nome" class="form-control" placeholder="Nome" required autofocus>
		<br>
		<label for="inputemail" class="sr-only">Email</label>
		<input type="text" id="inputemail" name="email" class="form-control" placeholder="Email" required autofocus>
		<br>
		<label for="inputimagem" class="sr-only">Imagem</label>
		<input type="file" class="form-control" id="inputimagem" name="imagem" accept="image/*">
		<br>
		<input class="btn btn-lg btn-primary btn-block" type="submit" value="Cadastrar" />
	</form>
</body>
</html>