<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="<%= request.getContextPath() %>/css/bootstrap.min.css" type="text/css" rel="stylesheet">
<link href="<%= request.getContextPath() %>/css/signin.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="<%= request.getContextPath() %>/js/jquery-3.4.0.min.js"></script>
<script type="text/javascript" src="<%= request.getContextPath() %>/js/bootstrap.min.js"></script>
<title>Loja GamerZC</title>
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
	<form method="post" action="<%= request.getContextPath() %>/LoginServlet" class="form-signin">
		<img class="mb-4" src="<%= request.getContextPath() %>/GetImageServlet" alt="" height="100">
		<h1 class="h3 mb-3 font-weight-normal">Entre com seu usuário</h1>
		<label for="inputCpf" class="sr-only">CPF</label>
		<input type="number" id="inputCpf" name="cpf" class="form-control" onKeyPress="if(this.value.length==11) return false;" placeholder="CPF" required autofocus>
		<label for="inputSenha" class="sr-only">Senha</label>
		<input type="password" id="inputSenha" name="senha" class="form-control" placeholder="Senha" required>
		<input class="btn btn-lg btn-primary btn-block" type="submit" value="Entrar" />
		<p>Não possui conta? Cadastre-se <a href="<%= request.getContextPath() %>/CadastroUsuarioServlet">aqui</a></p>
	</form>
</body>
</html>