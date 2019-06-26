package br.mc.servlet.produtos;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.mc.model.CarrinhoHandler;
import br.mc.model.Produto;
import br.mc.model.ProdutoHandler;

@WebServlet("/Signedin/Compra/ListrarProdutoCompra")
public class ListrarProdutoCompra extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ProdutoHandler produtoHandler = new ProdutoHandler();
	CarrinhoHandler carrinho = new CarrinhoHandler();
	
    public ListrarProdutoCompra() {
        super();
 
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getSession().setAttribute("produtos", produtoHandler.consultar());
		request.getSession().setAttribute("itensCarrinho", carrinho.consultarNumItens());

		request.getRequestDispatcher("/WEB-INF/pages/produtos_compra.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
