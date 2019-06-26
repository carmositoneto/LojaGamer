<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="card text-center">
	<h5 class="card-header">Produtos</h5>
	<div class="card-body">
		<h5 class="card-title">Alterar produto</h5>
		<form action="<%= request.getContextPath() %>/Signedin/Produtos/AlterarProdutosServlet" method="post" enctype="multipart/form-data">
			<div class="form-group row">
				<label for="inputid" class="col-sm-2 col-form-label">ID</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="inputid" name="id" placeholder="id" value="${alterarproduto.id}" readonly="readonly">
				</div>
			</div>

			<div class="form-group row">
				<label for="inputnome" class="col-sm-2 col-form-label">Nome</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="inputnome" name="nome" placeholder="Nome da Produto" value="${alterarproduto.nome}">
				</div>
			</div>
			<div class="form-group row">
				<label for="inputdescricao" class="col-sm-2 col-form-label">Descrição</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="inputdescricao" name="descricao" placeholder="Descrição" value="${alterarproduto.descricao}">
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