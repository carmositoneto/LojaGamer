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
			<th>Comprar</th>
		</tr>
	</thead>
	<c:forEach items="${ produtos }" var="produto">

		<tr>
			<td>${ produto.id }</td>
			<td>${ produto.nome }</td>
			<td>${ produto.descricao }</td>
			<td>
				<a href="<%= request.getContextPath() %>/Signedin/Compra/AdicionarCarrinhoServelet?id=${ produto.id }">Comprar</a>
			</td>
		</tr>

	</c:forEach>
</table>
<h2>
	<a href="<%= request.getContextPath() %>/Signedin/Compra/ListaCompracarrinhoServelet">${itensCarrinho}</a>
</h2>