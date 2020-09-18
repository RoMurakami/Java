package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.BeanCursoJsp;
import beans.BeanTelefones;
import dao.DaoTelefones;
import dao.DaoUsuario;

@WebServlet("/salvarTelefones")
public class TelefoneServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DaoUsuario daoUsuario = new DaoUsuario();
	private DaoTelefones daoTelefones = new DaoTelefones();

	public TelefoneServlets() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {

			String acao = request.getParameter("acao");
			String user = request.getParameter("user");
			
			if (user != null){
			BeanCursoJsp usuario = daoUsuario.consultar(user);
			
			if (acao.equalsIgnoreCase("addFone")) {
				request.getSession().setAttribute("userEscolhido", usuario);
				request.setAttribute("userEscolhido", usuario);

				RequestDispatcher view = request
						.getRequestDispatcher("/telefones.jsp");
				request.setAttribute("telephone", daoTelefones.listar(usuario.getId()));
				request.setAttribute("msg", "Cadastre novo telefone!");
				view.forward(request, response);

			} else if (acao.equalsIgnoreCase("deleteFone")) {
				String foneId = request.getParameter("foneId");
				daoTelefones.deletar(foneId);

				BeanCursoJsp beanCursoJsp = (BeanCursoJsp) request.getSession()
						.getAttribute("userEscolhido");

				RequestDispatcher view = request
						.getRequestDispatcher("/telefones.jsp");
				request.setAttribute("telephone", daoTelefones.listar(beanCursoJsp.getId()));
				request.setAttribute("msg", "Removido com sucesso!");
				view.forward(request, response);
			}
		}
			else {
				RequestDispatcher view = request.getRequestDispatcher("/cadastrousuario.jsp");
				request.setAttribute("usuarios", daoUsuario.listar());
				request.setAttribute("msg", "Necessário selecionar o usuário!");
				view.forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {

			BeanCursoJsp beanCursoJsp = (BeanCursoJsp) request.getSession()
					.getAttribute("userEscolhido");

			String numero = request.getParameter("numero");
			String tipo = request.getParameter("tipo");
			String acao = request.getParameter("acao");
			
			if (acao == null || (acao != null && !acao.equalsIgnoreCase("voltar"))){
						
			if (numero == null || (numero != null && numero.isEmpty())){
				RequestDispatcher view = request.getRequestDispatcher("telefones.jsp");
				request.setAttribute("telephone", daoTelefones.listar(beanCursoJsp.getId()));
				request.setAttribute("msg", "Informe numero de telefone!!");
				view.forward(request, response);	
			} else {
				
			BeanTelefones beanTelefones = new BeanTelefones();

			beanTelefones.setNumero(numero);
			beanTelefones.setTipo(tipo);
			beanTelefones.setUsuario(beanCursoJsp.getId());

			daoTelefones.salvar(beanTelefones);
			
			request.getSession().setAttribute("userEscolhido", beanCursoJsp);
			request.setAttribute("userEscolhido", beanCursoJsp);

			RequestDispatcher view = request.getRequestDispatcher("telefones.jsp");
			request.setAttribute("telephone", daoTelefones.listar(beanCursoJsp.getId()));
			request.setAttribute("msg", "Telefone cadastrado com sucesso!");
			view.forward(request, response);

			}
			} else {
				RequestDispatcher view = request.getRequestDispatcher("/cadastrousuario.jsp");
				request.setAttribute("usuarios", daoUsuario.listar());
				view.forward(request, response);
			}

			} catch (Exception e) {
				e.printStackTrace();
		}

	}

}
