package id.co.tripoin.web.ui.view.main;

import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.HorizontalLayout;

import id.co.tripoin.web.ui.view.IContentContainer;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public abstract class AMainLayout extends HorizontalLayout implements IContentContainer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5490439200246397972L;
	
	public void initializedMain() {
		this.setSizeFull();
		this.setMenuAreaStyle();
		this.addComponent(menuArea());
		this.setContentAreaStyle();
		this.addComponent(contentArea());
		this.setExpandRatio(contentArea(), 1.0f);
	}
	
	public abstract ComponentContainer menuArea();
	
	public abstract void setMenuAreaStyle();

	public abstract ComponentContainer contentArea();
	
	public abstract void setContentAreaStyle();
	
}
