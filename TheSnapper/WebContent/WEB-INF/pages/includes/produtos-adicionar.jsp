<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="card text-center">
	<h5 class="card-header">Produtos</h5>
	<div class="card-body">
		<h5 class="card-title">Adicionar produto</h5>
		<form action="<%= request.getContextPath() %>/Signedin/Produtos/AdicionarProdutosServlet" method="post" enctype="multipart/form-data">
			<div class="form-group row">
				<label for="inputnome" class="col-sm-2 col-form-label">Nome</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="inputnome" name="nome" placeholder="Nome da Produto">
				</div>
			</div>
			<div class="form-group row">
				<label for="inputdescricao" class="col-sm-2 col-form-label">Descrição</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="inputdescricao" name="descricao" placeholder="Descrição">
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