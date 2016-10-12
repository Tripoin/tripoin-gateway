package id.co.tripoin.web.ui;

import java.util.Locale;

import com.vaadin.server.ErrorHandler;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Component;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.UI;

import id.co.tripoin.web.constant.statics.NavigatorConstant;
import id.co.tripoin.web.constant.statics.VaadinConstant;
import id.co.tripoin.web.ui.servlet.DiscoveryNavigator;
import id.co.tripoin.web.ui.servlet.UserAuthenticationContext;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public abstract class ABaseUI extends UI implements ErrorHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3809746382702659265L;
	protected DiscoveryNavigator navigator;
	
	@Override
	protected void init(VaadinRequest request) {
		Responsive.makeResponsive(this);
		getSession().setErrorHandler(this);
		setLocale(Locale.ENGLISH);
		if(UserAuthenticationContext.getInstance().getAuthentication() == null)
			initSignIn(request);
		else
			initMain(request);
	}
	
	protected void initSignIn(VaadinRequest request){
		getPage().setTitle(VaadinConstant.TITLE_SIGN_IN);
		removeStyleName(themeMain());
		setTheme(themeSignIn());
		setContent(getSignInComponent());
		this.navigator = new DiscoveryNavigator(this, getSignInContent());
		this.navigator.navigateTo(NavigatorConstant.NAV_HOME);
	}
	
	protected void initMain(VaadinRequest request){
		getPage().setTitle(VaadinConstant.TITLE_HOME);
		removeStyleName(themeSignIn());
		setTheme(themeMain());
		setContent(getMainComponent());
		this.navigator = new DiscoveryNavigator(this, getMainContent());
		this.navigator.navigateTo(NavigatorConstant.NAV_HOME);
	}

	protected abstract Component getSignInComponent();
	protected abstract Component getMainComponent();
	protected abstract ComponentContainer getSignInContent();
	protected abstract ComponentContainer getMainContent();
	protected abstract String themeSignIn();
	protected abstract String themeMain();
	
}
