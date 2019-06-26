<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2>
	Lista de produtos
</h2>
<table class="table table-striped">
	<thead>
		<tr>
			<th>ID</th>
			<th>Nome</th>
			<th>Descricao</th>
			<th>Alterar</th>
			<th>Remover</th>
		</tr>
	</thead>
	<c:forEach items="${ produtos }" var="produto">

		<tr>
			<td>${ produto.id }</td>
			<td>${ produto.nome }</td>
			<td>${ produto.descricao }</td>
			<td>
				<a href="<%= request.getContextPath() %>/Signedin/Produtos/ListarProdutosServlet?id=${ produto.id }">Alterar</a>
			</td>
			<td>
				<a href="<%= request.getContextPath() %>/Signedin/Produtos/ExcluirProdutosServlet?id=${ produto.id }">Excluir</a>
			</td>
		</tr>

	</c:forEach>
</table>