package br.mc.servlet.produtos;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

import br.mc.model.ProdutoHandler;

@WebServlet("/Signedin/Produtos/AdicionarProdutosServlet")
@MultipartConfig
public class AdicionarProdutosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProdutoHandler produtosHandler = new ProdutoHandler();

	public AdicionarProdutosServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String nome = request.getParameter("nome");
			String descricao = request.getParameter("descricao");

	        byte[] imagem = null;
	        String imagemTipo = null;

			InputStream inputStream = null;
	        Part filePart = request.getPart("imagem");
	        if (filePart != null) {
	        	imagemTipo = filePart.getContentType();
	            inputStream = filePart.getInputStream();
	            imagem = IOUtils.toByteArray(inputStream);
	        }
			
	        produtosHandler.adicionar(nome, descricao);
	        
	        response.sendRedirect(request.getContextPath() + "/Signedin/Produtos/ListarProdutosServlet");
	        
//			Integer id = produtosHandler.adicionar(nome, quantidade, descricao, imagem, imagemTipo);
//			
//			String filepath = getServletContext().getRealPath(File.separator)+"/imgs/produtos/"+id+"/"+imagemTipo;
//			File file = new File(filepath);
//			
//			FileUtils.writeByteArrayToFile(file, imagem);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
