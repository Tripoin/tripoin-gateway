package id.co.tripoin.web.ui.view.main;

import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

import id.co.tripoin.web.constant.statics.VaadinConstant;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class MainTitleLayout extends HorizontalLayout {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8757084019303007046L;
	private final Label title = new Label(VaadinConstant.TITLE_APPS, ContentMode.HTML);
	
	public MainTitleLayout() {
		this.title.setSizeUndefined();
		this.setWidth(VaadinConstant.STYLE_100PERCENT);
		this.setDefaultComponentAlignment(Alignment.MIDDLE_LEFT);
		this.addStyleName(VaadinConstant.STYLE_VALO_MENU_TITLE);
		this.addComponent(title);
		this.setExpandRatio(title, 1);
	}

}
