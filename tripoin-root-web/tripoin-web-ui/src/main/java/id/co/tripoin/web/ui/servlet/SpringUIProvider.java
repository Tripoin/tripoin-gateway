package id.co.tripoin.web.ui.servlet;

import com.vaadin.server.UIClassSelectionEvent;
import com.vaadin.server.UICreateEvent;
import com.vaadin.server.UIProvider;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class SpringUIProvider extends UIProvider {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 7883633656480014199L;
	private static Logger LOGGER = LoggerFactory.getLogger(SpringUIProvider.class);

    /**
     * Servlet parameter name for UI bean
     */
    protected static final String BEAN_NAME_PARAMETER = "beanName";

    public SpringUIProvider(){}

    @Override
    public UI createInstance(UICreateEvent event) {
        return (UI) SpringApplicationContext.getApplicationContext().getBean(getUIBeanName(event.getRequest()));        
    }

    @SuppressWarnings("unchecked")
	@Override
    public Class<? extends UI> getUIClass(UIClassSelectionEvent event) {
        if (this.isSessionScopedUI(event.getRequest())){
            LOGGER.warn("You should use Prototype scope for UI only!");
        }
        return (Class<? extends UI>) SpringApplicationContext.getApplicationContext().getType(getUIBeanName(event.getRequest()));
    }

    protected boolean isSessionScopedUI(VaadinRequest request) {
        return !SpringApplicationContext.getApplicationContext().isPrototype(getUIBeanName(request));
    }

    /**
     * Returns the bean name to be retrieved from the application bean context and
     * used as the UI. The default implementation uses the servlet init property
     * {@link #BEAN_NAME_PARAMETER} or "ui" if not defined.
     *
     * @param request the current Vaadin request
     * @return the UI bean name in the application context
     */
    protected String getUIBeanName(VaadinRequest request) {
        String vaadinBeanName = "ui";
        Object uiBeanName = request.getService().getDeploymentConfiguration().getApplicationOrSystemProperty(BEAN_NAME_PARAMETER, null);
        if (uiBeanName != null && uiBeanName instanceof String) {
            vaadinBeanName = uiBeanName.toString();
        }
        return vaadinBeanName;
    }
    
}
