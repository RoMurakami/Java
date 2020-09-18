package service;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;

import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanArrayDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.util.JRLoader;

public class RelatorioService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private static final String FOLDER_REPORTS = "/relatorios"; 
	private static final String SUBREPORT_DIR = "SUBREPORT_DIR";
	private static String SEPARATOR = File.separator;
	private String caminhoArquivoRelatorio = null;
	private JRExporter exporter = null;
	private String caminhoSubReport_Dir = "";
	private File arquivoGerado = null;

	
	public String gerarRelatorios(List<?> listaDataBeanColletion, HashMap paramentroRelatorios
			, String nomeRelatorioJasper, String nomeRelatorioSaida, ServletContext servletContext, String tipoExportar) throws Exception{
		
		/*Criar lista de collection datasource de beans para carregar os dados para relatorio*/
		
		JRBeanCollectionDataSource jrbcds = new JRBeanCollectionDataSource(listaDataBeanColletion);
		
		
		/*FORNECE O CAMINHO FISICO ATÉ A PASTA QUE CONTEM OS RELATORIOS JASPER*/
		String caminhoRelatorio = servletContext.getRealPath(FOLDER_REPORTS);
		
		File file = new File(caminhoRelatorio + SEPARATOR + nomeRelatorioJasper + ".jasper");
		
		if(caminhoRelatorio == null 
				|| (caminhoRelatorio != null && caminhoRelatorio.isEmpty())
				|| !file.exists()){
			caminhoRelatorio = this.getClass().getResource(FOLDER_REPORTS).getPath();
			SEPARATOR = "";
		}
		
		/*caminho para imagem*/
		paramentroRelatorios.put("REPORT_PARAMETERS_IMG", caminhoRelatorio);
		
		/*caminho completo até o relatorio*/
		String caminhoArquivosJasper = caminhoRelatorio + SEPARATOR + nomeRelatorioJasper + ".jasper";
		
		/*Faz o carregamento do relatorio*/
		
		JasperReport relatorioJasper = (JasperReport) JRLoader.loadObjectFromFile(caminhoArquivosJasper);
		
		/*Seta paramentros SUBREPORT_DIRcom caminho fisico para subreport */
		caminhoSubReport_Dir = caminhoRelatorio + SEPARATOR;
		paramentroRelatorios.put(SUBREPORT_DIR, caminhoSubReport_Dir);
		
		/*Carregar o arquivo*/
		
		JasperPrint impreressoraJasper = JasperFillManager.fillReport(relatorioJasper, paramentroRelatorios, jrbcds);
		
		if(tipoExportar.equalsIgnoreCase("pdf")){
			exporter = new JRPdfExporter();
		}else if(tipoExportar.equalsIgnoreCase("xls")){
			exporter = new JRXlsExporter();	
		}
		
		/*Caminho do relatorio exportado*/
		
		caminhoArquivoRelatorio = caminhoRelatorio + SEPARATOR + nomeRelatorioSaida + "."+ tipoExportar;
		
		/*criar novo arquivo exportado*/
		
		arquivoGerado = new File(caminhoArquivoRelatorio);
		
		/*Prepara a impressão*/
		exporter.setParameter(JRExporterParameter.JASPER_PRINT, impreressoraJasper);
		
		exporter.setParameter(JRExporterParameter.OUTPUT_FILE, arquivoGerado);
		
		/*Executa a exportação*/
		exporter.exportReport();
		
		/*remove o arquivo do servidor apos ser feito download*/
		arquivoGerado.deleteOnExit();
			return caminhoArquivoRelatorio;
	}

}
