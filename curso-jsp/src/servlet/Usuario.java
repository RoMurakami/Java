package servlet;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.xml.bind.DatatypeConverter;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.codec.binary.Base64;

import beans.BeanCursoJsp;
import beans.BeanProduto;
import dao.DaoProduto;
import dao.DaoUsuario;

@WebServlet("/salvarUsuario")
@MultipartConfig
public class Usuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DaoUsuario daoUsuario = new DaoUsuario();

	public Usuario() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			String acao = request.getParameter("acao");
			String user = request.getParameter("user");

			if (acao != null && acao.equalsIgnoreCase("delete")) {
				daoUsuario.delete(user);
				request.setAttribute("msg", "Usuário deletado com sucesso!");
				RequestDispatcher view = request.getRequestDispatcher("/cadastrousuario.jsp");
				request.setAttribute("usuarios", daoUsuario.listar());
				view.forward(request, response);

			} else if (acao != null && acao.equalsIgnoreCase("editar")) {
				BeanCursoJsp beanCursoJsp = daoUsuario.consultar(user);
				RequestDispatcher view = request.getRequestDispatcher("/cadastrousuario.jsp");
				request.setAttribute("user", beanCursoJsp);
				view.forward(request, response);

			} else if (acao != null && acao.equalsIgnoreCase("listartodos")) {
				RequestDispatcher view = request.getRequestDispatcher("/cadastrousuario.jsp");
				request.setAttribute("usuarios", daoUsuario.listar());
				view.forward(request, response);
				
			} else if (acao != null && acao.equalsIgnoreCase("download")) {
				BeanCursoJsp usuario = daoUsuario.consultar(user);
				if (usuario != null) {

					String contentType = "";
					byte[] fileBytes = null;
					String tipo = request.getParameter("tipo");

					if (tipo.equalsIgnoreCase("imagem")) {
						contentType = usuario.getContentType();
						fileBytes = new Base64().decodeBase64(usuario
								.getFotoBase64());

					} else if (tipo.equalsIgnoreCase("curriculo")) {
						contentType = usuario.getContentTypeCurriculo();
						fileBytes = new Base64().decodeBase64(usuario
								.getCurriculoBase64());
					}

					response.setHeader(
							"content-Disposition",
							"attachment;filename=arquivo."
									+ contentType.split("\\/")[1]);

					/*
					 * COLOCA OS BYTES EM UM OBJETO DE ENTRADA PARA
					 * PROCESSAMENTO
					 */
					InputStream is = new ByteArrayInputStream(fileBytes);

					int read = 0;
					byte[] bytes = new byte[1024];
					OutputStream os = response.getOutputStream();

					while ((read = is.read(bytes)) != -1) {
						os.write(bytes, 0, read);
					}
					os.flush();
					os.close();
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

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String acao = request.getParameter("acao");

		if (acao != null && acao.equalsIgnoreCase("reset")) {
			try {
				RequestDispatcher view = request.getRequestDispatcher("/cadastrousuario.jsp");
				request.setAttribute("usuarios", daoUsuario.listar());
				view.forward(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {

			String id = request.getParameter("id");
			String login = request.getParameter("login");
			String senha = request.getParameter("senha");
			String nome = request.getParameter("nome");
			String telefone = request.getParameter("telefone");
			String cep = request.getParameter("cep");
			String rua = request.getParameter("rua");
			String bairro = request.getParameter("bairro");
			String cidade = request.getParameter("cidade");
			String estado = request.getParameter("estado");
			String ibge = request.getParameter("ibge");
			String sexo = request.getParameter("sexo");
			String perfil = request.getParameter("perfil");
			

			BeanCursoJsp usuario = new BeanCursoJsp();
			usuario.setId(!id.isEmpty() ? Long.parseLong(id) : 0);
			usuario.setLogin(login);
			usuario.setSenha(senha);
			usuario.setNome(nome);
			usuario.setTelefone(telefone);
			usuario.setCep(cep);
			usuario.setRua(rua);
			usuario.setBairro(bairro);
			usuario.setCidade(cidade);
			usuario.setEstado(estado);
			usuario.setIbge(ibge);
			usuario.setSexo(sexo);
			usuario.setPerfil(perfil);
			
			if(request.getParameter("ativo") != null &&
					request.getParameter("ativo").equalsIgnoreCase("on")){
				
				usuario.setAtivo(true);
			} else {
				usuario.setAtivo(false);
			}

			try {
				/* INICIO DE UPLOAD DE ARQUIVO */

				if (ServletFileUpload.isMultipartContent(request)) {

					Part imagemFoto = request.getPart("foto");

					if (imagemFoto != null && imagemFoto.getInputStream().available() > 0) {
						
						byte [] bytesImagem = convertStremParaByte(imagemFoto.getInputStream());
						
						String fotoBase64 = new Base64().encodeBase64String(bytesImagem);

						usuario.setFotoBase64(fotoBase64);
						usuario.setContentType(imagemFoto.getContentType());
						
						/*INICIO DA IMAGEM MINIATURA*/
						
						/*TRANSFORMAR A IMAGEM EM UM BUFFEREDIMAGE */
						byte [] imagemByteDescode = new Base64().decodeBase64(fotoBase64);
						BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(imagemByteDescode));
						
						/*PEGA O TIPO DA IMAGEM*/
						
						int type = bufferedImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB: bufferedImage.getType();
						
						/* cria a imagem em miniatura*/
						
						BufferedImage resizedImage = new BufferedImage(100, 100, type);
						Graphics2D graphic = resizedImage.createGraphics();
						graphic.drawImage(bufferedImage, 0, 0, 100, 100, null);
						graphic.dispose();
						
						/*ESCREVER A IMAGEM NOVAMENTE*/
						
						ByteArrayOutputStream baos = new ByteArrayOutputStream();
						ImageIO.write(resizedImage, "png", baos);
						
						String miniatruraBase64 = "data:image/png;base64," + DatatypeConverter.printBase64Binary(baos.toByteArray());
						
						usuario.setFotoBase64Miniatura(miniatruraBase64);

						/*FIM - IMAGEM MINIATURA*/
					} else {

						usuario.setAtualizarImage(false);
					}

					/* PROCESSAMENTO PDF */

					Part curriculoPdf = request.getPart("curriculo");
					if (curriculoPdf != null
							&& curriculoPdf.getInputStream().available() > 0) {
						String curriculoBase64 = new Base64()
								.encodeBase64String(convertStremParaByte(curriculoPdf
										.getInputStream()));

						usuario.setCurriculoBase64(curriculoBase64);
						usuario.setContentTypeCurriculo(curriculoPdf.getContentType());
					} else {
						usuario.setAtualizarPdf(false);
					}
				}

				/* FIM DE UPLOAD DE ARQUIVO */
				
				String msg = null;
				boolean possoInserir = true;

				if (login == null || login.isEmpty()) {
					msg = "Informe login!";
					possoInserir = false;

				} else if (senha == null || senha.isEmpty()) {
					msg = "Informe senha!";
					possoInserir = false;

				} else if (nome == null || nome.isEmpty()) {
					msg = "Informe nome!";
					possoInserir = false;

				/*} else if (telefone == null || telefone.isEmpty()) {
					msg = "Informe telefone!";
					possoInserir = false;
					
			  */} else if (cep == null || cep.isEmpty()){
					msg = "Informe cep!";
					possoInserir = false;

				} else if (id == null || id.isEmpty() && !daoUsuario.validarLogin(login)){
					request.setAttribute("msg", "Login ja existe para outro usuario");
					possoInserir = false;
				} else if(id == null || id.isEmpty()&& !daoUsuario.validarSenha(senha)){
					request.setAttribute("msg", "Senha pertence a outro login");
				}
				
				if (msg != null){
					request.setAttribute("msg", msg);
				} else if (id == null || id.isEmpty() && daoUsuario.validarLogin(login) && daoUsuario.validarSenha(senha) && possoInserir){
					daoUsuario.salvarLogin(usuario);
					request.setAttribute("msg", "Login salvo com sucesso!");
				
				} else if (id != null && !id.isEmpty() && possoInserir) {
					if (!daoUsuario.validarLoginBcoUpdate(login, id)){
						request.setAttribute("msg", "Login existente!");
					} else {
						daoUsuario.atualizar(usuario);
					}
					
					if (!daoUsuario.validarLogin(login)) {
						request.setAttribute("user", usuario);
					}
				}
				

				RequestDispatcher view = request.getRequestDispatcher("/cadastrousuario.jsp");
				request.setAttribute("usuarios", daoUsuario.listar());
				//request.setAttribute("msg", "");
				view.forward(request, response);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	/* converte a entrada de fluxo de dados da imagem para byte[] */
	private byte[] convertStremParaByte(InputStream imagem) throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int reads = imagem.read();
		while (reads != -1) {
			baos.write(reads);
			reads = imagem.read();
		}
		return baos.toByteArray();
	}

}
