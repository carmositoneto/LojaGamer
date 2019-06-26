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

@WebServlet("/Signedin/Produtos/AlterarProdutosServlet")
@MultipartConfig
public class AlterarProdutosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProdutoHandler produtoHandler = new ProdutoHandler();

	public AlterarProdutosServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int id = new Integer(request.getParameter("id"));
			String nome = request.getParameter("nome");
			String descricao = request.getParameter("descricao");
			

			produtoHandler.alterar(id, nome, descricao);

			response.sendRedirect(request.getContextPath() + "/Signedin/Produtos/ListarProdutosServlet");
			
//			byte[] foto = null;
//			String fotoFileName = null;
//
//			InputStream inputStream = null;
//			Part filePart = request.getPart("foto");
//			if (filePart != null) {
//				fotoFileName = filePart.getSubmittedFileName();
//				inputStream = filePart.getInputStream();
//				foto = IOUtils.toByteArray(inputStream);
//			} else {
//				try {
//					fotoFileName = produtoHandler.consultar(id).getImagem();
//				} catch (Exception e) {
//				}
//			}
//			String filepath = getServletContext().getRealPath(File.separator) + "/imgs/produtos/" + id + "/"
//					+ fotoFileName;
//			File file = new File(filepath);
//
//			FileUtils.writeByteArrayToFile(file, foto);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
