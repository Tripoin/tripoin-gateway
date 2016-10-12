package id.co.tripoin.web.ui.servlet;

import com.vaadin.navigator.View;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public interface ViewCacheContainer {
	
    public View getView(String name, String beanName, boolean cached);
    
}
