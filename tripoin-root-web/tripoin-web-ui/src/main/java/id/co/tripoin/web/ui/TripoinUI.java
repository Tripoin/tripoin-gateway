package id.co.tripoin.web.ui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Viewport;
import com.vaadin.annotations.Widgetset;
import com.vaadin.ui.ComponentContainer;

import id.co.tripoin.web.constant.statics.BeanNameConstant;
import id.co.tripoin.web.constant.statics.CommonConstant;
import id.co.tripoin.web.constant.statics.VaadinConstant;
import id.co.tripoin.web.ui.view.main.MainLayout;
import id.co.tripoin.web.ui.view.signin.SignInLayout;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
@Viewport(VaadinConstant.VIEW_PORT)
@Widgetset(VaadinConstant.WIDGET_SET)
@Theme(VaadinConstant.THEME_BASE)
@Component(BeanNameConstant.TRIPOIN_UI)
@Scope(CommonConstant.PROTOTYPE)
@PreserveOnRefresh
public class TripoinUI extends ABaseUI {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6896042105938043430L;
	private static transient final Logger LOGGER = LoggerFactory.getLogger(TripoinUI.class);
	
	@Autowired
	private SignInLayout signInLayout;
	
	@Autowired
	private MainLayout mainLayout;

	@Override
	protected com.vaadin.ui.Component getSignInComponent() {
		return this.signInLayout;
	}

	@Override
	protected ComponentContainer getSignInContent() {
		return this.signInLayout.contentArea();
	}

	@Override
	protected com.vaadin.ui.Component getMainComponent() {
		return this.mainLayout;
	}

	@Override
	protected ComponentContainer getMainContent() {
		return this.mainLayout.contentArea();
	}

	@Override
	protected String themeSignIn() {
		return VaadinConstant.THEME_BASE;
	}

	@Override
	protected String themeMain() {
		return VaadinConstant.THEME_VALO;
	}

	@Override
	public void error(com.vaadin.server.ErrorEvent event) {
		
	}

}
