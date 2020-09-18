package servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.management.relation.RelationService;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoUsuario;
import entidades.Usuario;
import service.RelatorioService;

@WebServlet("/pages/ServletDownloadFile")
public class ServletDownloadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private RelatorioService relatorioService = new RelatorioService();
	private DaoUsuario daoUsuario = new DaoUsuario();
       
    public ServletDownloadFile() {
        super();
    }

	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		try{
		
		ServletContext context = request.getServletContext();	
		String tipoExportar = request.getParameter("tipoExportar");
		
		List<Usuario> usuarios = daoUsuario.getUsuarios();
		//List dados = new ArrayList();
		//dados.add(usuarios);
		
		String fileUrl = relatorioService.gerarRelatorios(usuarios, new HashMap(), 
				"rel_usuario", "rel_usuario", context, tipoExportar);
		
		/*constuir caminh completo e absoluto do arquivo*/
		File downloadFile = new File(fileUrl);
		FileInputStream inputStream = new FileInputStream(downloadFile);
		
		/*obter o tipo do arquivo*/
		String mimeType = context.getMimeType(fileUrl);
		
		if(mimeType != null){
			/*DEFINE CMO TIPO BINARIO SE MAPEAMENTO MIME NÃO FOR ENCONTRADO*/
			mimeType = "application/octet-stream";
		}
		/*define atributos para resposta*/
		response.setContentType(mimeType);
		response.setContentLength((int)downloadFile.length());
		
		/*define cabeçalho para resposta*/
		String headerKey = "Content-Disposition";
		String headerValue = String.format("attachemet; filename=\"%s\"", downloadFile.getName());
		
		response.setHeader(headerKey, headerValue);
		
		/*FLUXO DE SAIDA DA RESPOSTA*/
		
		OutputStream outputStream = response.getOutputStream();
		
		byte[] buffer = new byte[4096];
		int bytesRead = -1;
		
		/*escrever bytes lidos do fluxo de entrada para o flixo de saida*/
		
		while((bytesRead = inputStream.read(buffer)) != -1){
			outputStream.write(buffer, 0, bytesRead);
		}
		inputStream.close();
		outputStream.close();
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
	}

}
