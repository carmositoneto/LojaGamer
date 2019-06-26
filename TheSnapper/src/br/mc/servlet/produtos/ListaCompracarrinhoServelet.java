package br.mc.servlet.produtos;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.mc.model.CarrinhoHandler;


@WebServlet("/Signedin/Compra/ListaCompracarrinhoServelet")
public class ListaCompracarrinhoServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CarrinhoHandler carrinhoHandlers =  new CarrinhoHandler();   
    
    public ListaCompracarrinhoServelet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getSession().setAttribute("carrinhos", carrinhoHandlers.consultar());

		request.getRequestDispatcher("/WEB-INF/pages/carrinho_compra.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
