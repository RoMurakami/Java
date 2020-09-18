package servlet;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.codec.binary.Base64;
import org.apache.catalina.util.*;
import org.apache.catalina.connector.RequestFacade;

import bean.BeanUsuario;
import dao.DaoUsuario;

@WebServlet("/pages/fileUpload")
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DaoUsuario daoUsuario = new DaoUsuario();
	   
    public FileUpload() {
        super();
    }

	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
	
		try {
		//System.out.println("Carregar imagem");
			
		String acao = request.getParameter("acao");
		
		if(acao.equalsIgnoreCase("carregar")){
			RequestDispatcher view = request.getRequestDispatcher("upload.jsp");
			request.setAttribute("listaUserImagem", daoUsuario.getUsuarios());
			view.forward(request, response);
			
		}else if(acao.equalsIgnoreCase("download")){
			String iduser = request.getParameter("iduser");
			BeanUsuario imagem = daoUsuario.buscarImagem(iduser);
			
			if(imagem != null){
				
				response.setHeader("content-Disposition", "attachement;filename=arquivo." + imagem.getTipofile());
				
				/*Pega somente imagem pura sem tipo de arquivo*/
				String imagemPura = imagem.getImagem().split(",")[1];
				
				/*coverte base64 em bytes*/
				byte [] imageBytes = new Base64().decodeBase64(imagemPura);
				
				/*coloca o objeto em um objeto de entrada para processar*/
				InputStream is = new ByteArrayInputStream(imageBytes);
				
				/*INICIO - ESCREVER DADOS DA RESPOSTA*/
				
				int read = 0;
				byte[] bytes = new byte[1024];
				OutputStream os = response.getOutputStream();
				while((read = is.read(bytes)) != -1){
					os.write(bytes, 0, read);
					
					os.flush();
					os.close();
				}
				/*FIM - ESCREVER DADOS DA RESPOSTA*/
			}
		}
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		try{
			String fileUpload = request.getParameter("fileUpload");
			
			daoUsuario.gravarImagem(fileUpload);
			
			response.getWriter().write("Upload realizado com sucesso!");
			
		}catch (Exception e){
			e.printStackTrace();
			response.getWriter().write("Erro fatal ao realizar Upload!");
		}
	}

}
