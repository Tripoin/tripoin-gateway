package id.co.tripoin.web.ui.servlet;

import com.vaadin.server.SystemMessages;
import com.vaadin.server.SystemMessagesInfo;
import com.vaadin.server.SystemMessagesProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;

import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class SpringVaadinSystemMessagesProvider implements SystemMessagesProvider {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -8426094060864789724L;
	public static final String DEFAULT_IMPLEMENTATION = "DEFAULT";
    private final ConcurrentMap<Locale, SystemMessages> systemMessagesCache = new ConcurrentHashMap<Locale, SystemMessages>();
    private SpringSystemMessagesProvider systemMessagesBean;

    public SpringVaadinSystemMessagesProvider(ApplicationContext applicationContext, String systemMessagesBeanName) {
        if (systemMessagesBeanName.equals(DEFAULT_IMPLEMENTATION)) {
            MessageSource messageSource = applicationContext.getBean(MessageSource.class);
            systemMessagesBean = new DefaultSpringSystemMessagesProvider();
            ((DefaultSpringSystemMessagesProvider)systemMessagesBean).setMessageSource(messageSource);
        }else{
            systemMessagesBean = applicationContext.getBean(systemMessagesBeanName, SpringSystemMessagesProvider.class);
        }
    }

    @Override
    public SystemMessages getSystemMessages(SystemMessagesInfo systemMessagesInfo){
        Locale locale = systemMessagesInfo.getLocale();
        if (systemMessagesCache.containsKey(locale)){
            return systemMessagesCache.get(locale);
        }
        SystemMessages systemMessages = systemMessagesBean.getSystemMessages(locale);
        systemMessagesCache.put(locale, systemMessages);
        return systemMessages;
    }
    
}
