<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h2>
	Carrinho
</h2>
<table class="table table-striped">
	<thead>
		<tr>
			<th>ID</th>
			<th>Nome</th>
			<th>Descricao</th>
			<th>Remover</th>
		</tr>
	</thead>
	<c:forEach items="${ carrinhos }" var="carrinhos">

		<tr>
			<td>${ carrinhos.id_carrinho }</td>
			<td>${ carrinhos.nome_produto }</td>
			<td>${ carrinhos.descricao_produto }</td>
			<td>
				<a href="<%= request.getContextPath() %>/Signedin/Compra/RemoverCarrinhoServelet?id=${ carrinhos.id_carrinho }">Remover</a>
			</td>
		</tr>

	</c:forEach>
</table>