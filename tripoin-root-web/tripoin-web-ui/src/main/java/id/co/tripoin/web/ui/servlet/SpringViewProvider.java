package id.co.tripoin.web.ui.servlet;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class SpringViewProvider extends Navigator.ClassBasedViewProvider {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 2810439880754585214L;
	private final String beanName;
    private final boolean cached;
    private final ViewCacheContainer cacheContainer;

    /**
     * Create a new view provider which creates new view instances based on
     * a view class.
     *
     * @param viewName  name of the views to create (not null)
     * @param viewClass class to instantiate when a view is requested (not null)
     */
    public SpringViewProvider(String viewName, String beanName, Class<? extends View> viewClass, boolean cached, ViewCacheContainer cacheContainer) {
        super(viewName, viewClass);
        this.beanName = beanName;
        this.cached = cached;
        this.cacheContainer = cacheContainer;
    }

    @Override
    public View getView(String viewName) {
        if (getViewName().equals(viewName)) {
            return cacheContainer.getView(viewName, beanName, cached);
        }
        return null;
    }
    
}
