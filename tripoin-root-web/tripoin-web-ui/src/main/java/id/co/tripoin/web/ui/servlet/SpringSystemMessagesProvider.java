package id.co.tripoin.web.ui.servlet;

import com.vaadin.server.SystemMessages;

import java.io.Serializable;
import java.util.Locale;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public interface SpringSystemMessagesProvider extends Serializable {
	
    public SystemMessages getSystemMessages(Locale locale);
    
}
