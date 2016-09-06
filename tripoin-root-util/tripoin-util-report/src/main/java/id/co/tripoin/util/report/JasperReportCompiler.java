package id.co.tripoin.util.report;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.ClassPathResource;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class JasperReportCompiler implements InitializingBean {

    private static Logger LOGGER = LoggerFactory.getLogger(JasperReportCompiler.class);
    public static final String CLASSPATH_REPORT = "/report";
    
    private File baseFileReportsPath = null;
    
    public JasperReportCompiler() {}
    
	@Override
	public void afterPropertiesSet() throws Exception {
		compileAllReport();
	}
	
	public void compileAllReport() throws Exception {
		try {
			baseFileReportsPath = new ClassPathResource(CLASSPATH_REPORT).getFile();
		} catch (IOException e) {
			LOGGER.error("Directory Report Failure", e);
		}		
		File[] baseFileReportsPathList = baseFileReportsPath.listFiles(new FilenameFilter() {			
			@Override
			public boolean accept(File dir, String name) {				
				if(name.endsWith(".jrxml")) 
					return true;				
				return false;
			}
		});
		for(File templateFile : baseFileReportsPathList) {
	        compileReport(templateFile);
		}		
	}

    private void compileReport(File templateFile){
		JasperDesign jasperDesign = loadTemplate(templateFile);
        try {
            JasperCompileManager.compileReportToFile(jasperDesign, new File(templateFile.getAbsolutePath().replaceAll(".jrxml", ".jasper")).getAbsolutePath());
        } catch (JRException e) {
        	LOGGER.error("Compile Report Failure : "+templateFile.getAbsolutePath(), e);
        }
    }
	
    private JasperDesign loadTemplate(File templateFile){
        JasperDesign jasperDesign = null;
        if(templateFile.exists()){
            try {
                jasperDesign = JRXmlLoader.load(templateFile);
            } catch (JRException e) {
            	LOGGER.error("Design Report Failure : "+templateFile.getAbsolutePath(), e);
            }
            System.setProperty("jasper.reports.compile.temp", templateFile.getParent());
        }
        else
        	LOGGER.error("Error, file not exists");
        return(jasperDesign);
    }

	public File getBaseFileReportsPath() {
		return baseFileReportsPath;
	}

	public void setBaseFileReportsPath(File baseFileReportsPath) {
		this.baseFileReportsPath = baseFileReportsPath;
	}

}
