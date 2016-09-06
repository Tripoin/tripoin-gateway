package id.co.tripoin.test.util.mail;

import id.co.tripoin.util.mail.ICoreMailSender;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/META-INF/spring/applicationContext-mail.xml"})
public class MailTest implements ApplicationContextAware {
	
	@Autowired
	private ICoreMailSender iCoreMailSender;
	
	private ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
	
	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	
	@Test
	public void runTest() throws Exception {
		iCoreMailSender.sendMailContent("test321@gmail.com", "test123@gmail.com", "[TEST] Spring Mail", "This is mail test form java code.");
	}
	
}