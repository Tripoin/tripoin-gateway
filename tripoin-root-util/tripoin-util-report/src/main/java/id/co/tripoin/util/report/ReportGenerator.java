package id.co.tripoin.util.report;

import id.co.tripoin.util.report.constant.EReportUtilConstant;

import java.io.File;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRTextExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleWriterExporterOutput;

public class ReportGenerator {
	
	@Autowired
	private JasperReportCompiler jasperReportCompiler;
	
	public void printReportToFile(String reportFilename, JRDataSource dataSource, Map<String, Object> params, OutputStream outputStream, EReportUtilConstant typeFile) throws Exception {
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReportCompiler.getBaseFileReportsPath().getPath().concat(File.separator).concat(reportFilename), params, dataSource);
		if(typeFile.equals(EReportUtilConstant.REPORT_EXCEL))
			excelExporter(jasperPrint, outputStream);
		else if(typeFile.equals(EReportUtilConstant.REPORT_CSV))
			csvExporter(jasperPrint, outputStream);
		else if(typeFile.equals(EReportUtilConstant.REPORT_TEXT))
			textExporter(jasperPrint, outputStream);
		else
			pdfExporter(jasperPrint, outputStream);
	}
	
	public void printReportToFile(String reportFilename, Connection connection, Map<String, Object> params, OutputStream outputStream, EReportUtilConstant typeFile) throws Exception {
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReportCompiler.getBaseFileReportsPath().getPath().concat(File.separator).concat(reportFilename), params, connection);
		pdfExporter(jasperPrint, outputStream);        
	}
	
	private void pdfExporter(JasperPrint jasperPrint, OutputStream outputStream) throws JRException{
		JRPdfExporter exporter = new JRPdfExporter();
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
        exporter.exportReport();
	}
	
	private void excelExporter(JasperPrint jasperPrint, OutputStream outputStream) throws JRException{
		JRXlsExporter exporter = new JRXlsExporter();
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outputStream));
        exporter.exportReport();
	}
	
	private void csvExporter(JasperPrint jasperPrint, OutputStream outputStream) throws JRException{
		JRCsvExporter exporter = new JRCsvExporter();
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleWriterExporterOutput(outputStream));
        exporter.exportReport();
	}
	
	private void textExporter(JasperPrint jasperPrint, OutputStream outputStream) throws JRException{
		JRTextExporter exporter = new JRTextExporter();
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(new SimpleWriterExporterOutput(outputStream));
        exporter.exportReport();
	}

}
