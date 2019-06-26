package br.mc.servlet.produtos;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.mc.model.CarrinhoHandler;

@WebServlet("/Signedin/Compra/AdicionarCarrinhoServelet")
public class AdicionarCarrinhoServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CarrinhoHandler carrinhoHandlers =  new CarrinhoHandler();   

    public AdicionarCarrinhoServelet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id = new Integer(request.getParameter("id"));
			carrinhoHandlers.adicionar(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//
		response.sendRedirect(request.getContextPath() + "/Signedin/Compra/ListrarProdutoCompra");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
