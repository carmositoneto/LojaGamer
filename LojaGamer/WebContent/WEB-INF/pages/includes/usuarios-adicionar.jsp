<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="card text-center">
	<h5 class="card-header">Usuarios</h5>
	<div class="card-body">
		<h5 class="card-title">Adicionar usuário</h5>
		<form action="<%=request.getContextPath()%>/Signedin/Usuarios/AdicionarUsuariosServlet" method="post" enctype="multipart/form-data">
			<div class="form-group row">
				<label for="inputlogin" class="col-sm-2 col-form-label">Login</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="inputlogin" name="login" placeholder="Login">
				</div>
			</div>
			<div class="form-group row">
				<label for="inputsenha" class="col-sm-2 col-form-label">Senha</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="inputsenha" name="senha" placeholder="Senha">
				</div>
			</div>
			<div class="form-group row">
				<label for="inputnome" class="col-sm-2 col-form-label">Nome</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="inputnome" name="nome" placeholder="Nome">
				</div>
			</div>
			<div class="form-group row">
				<label for="inputemail" class="col-sm-2 col-form-label">Email</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="inputemail" name="email" placeholder="Email">
				</div>
			</div>
			<div class="form-group row">
				<label for="inputfoto" class="col-sm-2 col-form-label">Foto</label>
				<div class="col-sm-10">
					<input type="file" class="form-control" id="inputfoto" name="foto" accept="image/*">
				</div>
			</div>
			<div class="form-group row">
				<div class="col">
					<input type="submit" name="Adicionar" value="Adicionar">
				</div>
			</div>
		</form>
	</div>
</div>