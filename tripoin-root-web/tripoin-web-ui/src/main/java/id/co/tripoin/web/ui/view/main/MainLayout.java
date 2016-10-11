package id.co.tripoin.web.ui.view.main;

import org.springframework.stereotype.Component;

import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.CssLayout;

import id.co.tripoin.web.constant.statics.BeanNameConstant;
import id.co.tripoin.web.constant.statics.VaadinConstant;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
@Component(BeanNameConstant.MAIN_LAYOUT_COMPONENT_BEAN)
public class MainLayout extends AMainLayout {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5212313383710249278L;
	private CssLayout menuArea = new CssLayout();
	private CssLayout contentArea = new CssLayout();
	
	@Override
	public ComponentContainer menuArea() {
		return this.menuArea;
	}

	@Override
	public void setMenuAreaStyle() {
		this.menuArea.setPrimaryStyleName(VaadinConstant.STYLE_VALO_MENU);
	}

	@Override
	public ComponentContainer contentArea() {
		return this.contentArea;
	}

	@Override
	public void setContentAreaStyle() {
		this.contentArea.setPrimaryStyleName(VaadinConstant.STYLE_VALO_CONTENT);
		this.contentArea.addStyleName(VaadinConstant.STYLE_V_SCROLL);
        this.contentArea.addStyleName(VaadinConstant.STYLE_VIEW_CONTENT);
        this.contentArea.setSizeFull();		
	}

}