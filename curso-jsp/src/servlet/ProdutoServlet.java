package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BeanProduto;
import dao.DaoProduto;

@WebServlet("/salvarProduto")
public class ProdutoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DaoProduto daoProduto = new DaoProduto();

	public ProdutoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String acao = request.getParameter("acao");
			String produto = request.getParameter("produto");
			
			RequestDispatcher view = request.getRequestDispatcher("/cadastroProduto.jsp");

			if (acao != null && acao.equalsIgnoreCase("delete")) {
				daoProduto.delete(produto);
				request.setAttribute("_produtos", daoProduto.listar());
				
			} else if (acao != null && acao.equalsIgnoreCase("editar")) {
				BeanProduto beanCursoJsp = daoProduto.consultar(produto);
				request.setAttribute("produto", beanCursoJsp);
				
			} else if (acao != null && acao.equalsIgnoreCase("listartodos")) {
				request.setAttribute("_produtos", daoProduto.listar());
				
			} else {
				request.setAttribute("_produtos", daoProduto.listar());
			}
			request.setAttribute("categorias", daoProduto.listaCategoria());
			view.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String acao = request.getParameter("acao");

		if (acao != null && acao.equalsIgnoreCase("reset")) {
			try {
				RequestDispatcher view = request.getRequestDispatcher("/cadastroProduto.jsp");
				request.setAttribute("_produtos", daoProduto.listar());
				view.forward(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {

			String id = request.getParameter("id");
			String descricao = request.getParameter("descricao");
			String quantidade = request.getParameter("quantidade");
			String valor = request.getParameter("valor");
			String categoria = request.getParameter("categoria_id");

			try {

				String msg = null;
				boolean podeInserir = true;

				if (valor == null || valor.isEmpty()) {
					msg = "Valor R$ deve ser informado";
					podeInserir = false;

				} else if (quantidade == null || quantidade.isEmpty()) {
					msg = "Quantidade deve ser informado";
					podeInserir = false;

				} else if (descricao == null || descricao.isEmpty()) {
					msg = "Nome deve ser informado";
					podeInserir = false;

				} else if (id == null || id.isEmpty()
						&& !daoProduto.validarDescricao(descricao)) {// QUANDO
															// FDOR
															// PRODUTO
															// NOVO
					msg = "Produto já existe com o mesmo nome!";
					podeInserir = false;

				}

				BeanProduto produto = new BeanProduto();
				produto.setDescricao(descricao);
				produto.setId(!id.isEmpty() ? Long.parseLong(id) : null);
				produto.setCategoria_id(Long.parseLong(categoria));

				if (quantidade != null && !quantidade.isEmpty()) {
					produto.setQuantidade(Double.parseDouble(quantidade));
				}

				if (valor != null && !valor.isEmpty()){
					String valorParse = valor.replaceAll("\\.", "");// 10500,20
					valorParse = valorParse.replaceAll("\\,", ".");//10500.20
					produto.setValor(Double.parseDouble(valorParse)); 
				}
				
				if (msg != null) {
					request.setAttribute("msg", msg);
				} else if (id == null || id.isEmpty()
						&& daoProduto.validarDescricao(descricao) && podeInserir) {

					daoProduto.salvar(produto);

				} else if (id != null && !id.isEmpty() && podeInserir) {
					daoProduto.atualizar(produto);
				}

				if (!podeInserir) {
					request.setAttribute("novoProduto", produto);
				}

				RequestDispatcher view = request
						.getRequestDispatcher("/cadastroProduto.jsp");
				request.setAttribute("_produtos", daoProduto.listar());
				request.setAttribute("categorias", daoProduto.listaCategoria());
				view.forward(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

}