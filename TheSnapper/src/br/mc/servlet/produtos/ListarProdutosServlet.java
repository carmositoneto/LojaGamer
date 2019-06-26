package br.mc.servlet.produtos;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.mc.model.Produto;
import br.mc.model.ProdutoHandler;

@WebServlet("/Signedin/Produtos/ListarProdutosServlet")
public class ListarProdutosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProdutoHandler produtoHandler = new ProdutoHandler();

	public ListarProdutosServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().setAttribute("produtos", produtoHandler.consultar());

		try {
			int id = new Integer(request.getParameter("id"));
			Produto p = produtoHandler.consultar(id);
			request.getSession().setAttribute("alterarproduto", p);
		} catch (Exception e) {
			request.getSession().removeAttribute("alterarproduto");
		}

		request.getRequestDispatcher("/WEB-INF/pages/produtos.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
