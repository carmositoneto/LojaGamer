<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="card text-center">
	<h5 class="card-header">Usuarios</h5>
	<div class="card-body">
		<h5 class="card-title">Alterar usuário</h5>
		<form action="<%=request.getContextPath()%>/Signedin/Usuarios/AlterarUsuariosServlet" method="post" enctype="multipart/form-data">
			<div class="form-group row">
				<label for="inputcpf" class="col-sm-2 col-form-label">CPF</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="inputcpf" name="cpf" placeholder="CPF" value="${alterarusuario.cpf}" readonly="readonly">
				</div>
			</div>
			<div class="form-group row">
				<label for="inputsenha" class="col-sm-2 col-form-label">Senha</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="inputsenha" name="senha" placeholder="Senha" value="${alterarusuario.senha}">
				</div>
			</div>
			<div class="form-group row">
				<label for="inputnome" class="col-sm-2 col-form-label">Nome</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="inputnome" name="nome" placeholder="Nome" value="${alterarusuario.nome}">
				</div>
			</div>
			<div class="form-group row">
				<label for="inputemail" class="col-sm-2 col-form-label">Email</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="inputemail" name="email" placeholder="Email" value="${alterarusuario.email}">
				</div>
			</div>
			<div class="form-group row">
				<label for="inputimagem" class="col-sm-2 col-form-label">Imagem</label>
				<div class="col-sm-10">
					<input type="file" class="form-control" id="inputimagem" name="imagem" accept="image/*" value="${alterarusuario.imagem}">
				</div>
			</div>
			<div class="form-group row">
				<div class="col">
					<input type="submit" name="Alterar" value="Alterar">
				</div>
			</div>
		</form>
	</div>
</div>