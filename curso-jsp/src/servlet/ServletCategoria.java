package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BeanCategoria;
import dao.DaoCategoria;
import dao.DaoProduto;

@WebServlet("/servletCategoria")
public class ServletCategoria extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DaoCategoria daoCategoria = new DaoCategoria();
	private DaoProduto daoProduto = new DaoProduto();

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String acao = request.getParameter("acao");
		String categoria = request.getParameter("categoria");

		RequestDispatcher view = request
				.getRequestDispatcher("/cadastroProduto.jsp");

		try {
			if (acao != null && acao.equalsIgnoreCase("delete")) {
				daoCategoria.delete(categoria);
				;
				request.setAttribute("categorias", daoProduto.listaCategoria());
			} 
			request.setAttribute("categorias", daoProduto.listaCategoria());
			view.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String cadCategoria = request.getParameter("cadastrocategoria");

		if (cadCategoria.trim().isEmpty() || cadCategoria == null) {
			request.setAttribute("msg", "Digite uma categoria");
		} else {
			String nome = request.getParameter("cadastrocategoria");

			BeanCategoria novaCategoria = new BeanCategoria();
			novaCategoria.setNome(nome);
			daoCategoria.salvar(novaCategoria);

			request.setAttribute("msg", "Categoria salva com sucesso!");
		}
		RequestDispatcher view = request
				.getRequestDispatcher("/cadastroProduto.jsp");
		view.forward(request, response);
	}

}
