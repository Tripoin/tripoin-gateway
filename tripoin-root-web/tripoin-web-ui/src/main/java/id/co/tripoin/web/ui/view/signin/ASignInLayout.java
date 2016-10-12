package id.co.tripoin.web.ui.view.signin;

import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;

import id.co.tripoin.web.ui.view.IContentContainer;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public abstract class ASignInLayout extends CssLayout implements IContentContainer {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4213067796797473282L;
	
	public abstract Component centeringLayout();
	
	public abstract Component getInformation();
	
	public abstract void setInformation(String information);

}
