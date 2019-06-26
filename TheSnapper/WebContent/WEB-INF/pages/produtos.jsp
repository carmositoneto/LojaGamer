<%@ include file="/WEB-INF/pages/includes/header.jsp"%>
<body>
	<%@ include file="/WEB-INF/pages/includes/navbar.jsp"%>

	<div class="container">
		<c:if test="${alterarproduto == null}">
			<%@ include file="/WEB-INF/pages/includes/produtos-adicionar.jsp"%>
		</c:if>
		<c:if test="${alterarproduto != null}">
			<%@ include file="/WEB-INF/pages/includes/produtos-alterar.jsp"%>
		</c:if>
		<hr>
		<%@ include file="/WEB-INF/pages/includes/produtos-listar.jsp"%>
	</div>
	<%@ include file="/WEB-INF/pages/includes/footer.jsp"%>
</body>
</html>