package servlet;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.security.util.DisabledAlgorithmConstraints;
import dao.DaoCalculaDataFinal;

@WebServlet("/pages/calculandoDataFinal")
public class CalculandoDataFinal extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static DaoCalculaDataFinal daoCalculaDataFinal = new DaoCalculaDataFinal();
       
    public CalculandoDataFinal() {
        super();
    }

	protected void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		/*08:00 - 12:00 e 13:00 - 17:00*/
		/*1 dia é igual a 8 horas*/
		
		try{
			int horaDia = 8;
			Date dataCalculada = null;
			
			String data = request.getParameter("data");
			int tempo = Integer.parseInt(request.getParameter("tempo"));
			
			if(tempo <= horaDia){
				dataCalculada = new SimpleDateFormat("dd/MM/yyyy").parse(data);
			} else {
				Double totalDeDias = 0.0;
				totalDeDias = (double) (tempo / horaDia);
				
				if(totalDeDias <= 1){
					dataCalculada = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(data);
				} else {
					Date dataInformada = new SimpleDateFormat("dd/MM/yyyy").parse(data);
					Calendar calendar = Calendar.getInstance();
					
					calendar.setTime(dataInformada);
					calendar.add(Calendar.DATE, totalDeDias.intValue());					
					
					dataCalculada = calendar.getTime();
				}
			}
			
			daoCalculaDataFinal.gravaDataFinal(new SimpleDateFormat("dd/MM/yyyy").format(dataCalculada));
			RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/datas.jsp");
			request.setAttribute("dataFinal", new SimpleDateFormat("dd/MM/yyyy").format(dataCalculada));
			dispatcher.forward(request, response);	
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
