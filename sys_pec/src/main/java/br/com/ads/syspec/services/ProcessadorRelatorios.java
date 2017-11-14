package br.com.ads.syspec.services;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.Exporter;
import net.sf.jasperreports.export.ExporterInput;
import net.sf.jasperreports.export.OutputStreamExporterOutput;
import net.sf.jasperreports.export.PdfExporterConfiguration;
import net.sf.jasperreports.export.PdfReportConfiguration;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

import org.hibernate.jdbc.Work;

public class ProcessadorRelatorios implements Work {
	private String pathRelatorio;
	private HttpServletResponse response;
	private Map<String, Object> parametros;
	private String arquivoPdf;
	private boolean relatorioVazio;

	public ProcessadorRelatorios(String pathRelatorio, HttpServletResponse response, 
			Map<String, Object> parametros, String arquivoPdf) {
		this.pathRelatorio = pathRelatorio;
		this.response = response;
		this.parametros = parametros;
		this.arquivoPdf = arquivoPdf;
		this.parametros.put(JRParameter.REPORT_LOCALE, new Locale("pt", "BR"));
	}

	@Override
	public void execute(Connection connection) throws SQLException {
		
		try {
			InputStream relatorioStream = this.getClass().getResourceAsStream(this.pathRelatorio);
			JasperPrint print = JasperFillManager.fillReport(relatorioStream, this.parametros, connection);
			relatorioVazio = print.getPages().size() == 0;

			if (!relatorioVazio) {
				Exporter<ExporterInput, PdfReportConfiguration, PdfExporterConfiguration,
				OutputStreamExporterOutput> exportador = new JRPdfExporter();
				exportador.setExporterInput(new SimpleExporterInput(print));
				exportador.setExporterOutput(new SimpleOutputStreamExporterOutput(response.getOutputStream()));
				response.setContentType("application/pdf");
				response.setHeader("Content-Disposition", "inline; filename=\"" + this.arquivoPdf  + "\"");
				exportador.exportReport();
			}
		} catch (Exception e) {
			System.err.println("Erro ao processar relatório " + this.pathRelatorio + " - " + e.getMessage());
			throw new SQLException("Erro ao processar relatório " + this.pathRelatorio, e);
			
		}
	}

	public boolean isRelatorioVazio() {
		return relatorioVazio;
	}
}
