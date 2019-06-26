package br.mc.servlet.produtos;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.mc.model.CarrinhoHandler;


@WebServlet("/Signedin/Compra/RemoverCarrinhoServelet")

public class RemoverCarrinhoServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CarrinhoHandler carrinhoHandlers =  new CarrinhoHandler();      

    public RemoverCarrinhoServelet() {
        super();
   
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			int id = new Integer(request.getParameter("id"));
			carrinhoHandlers.remover(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//
		response.sendRedirect(request.getContextPath() + "/Signedin/Compra/ListaCompracarrinhoServelet");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
