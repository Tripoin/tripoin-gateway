package id.co.tripoin.web.ui.view.main;

import com.vaadin.server.ExternalResource;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.UI;

import id.co.tripoin.web.constant.statics.BeanNameConstant;
import id.co.tripoin.web.constant.statics.VaadinConstant;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public abstract class MainSettingsLayout extends MenuBar implements SignOutListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3668247890562809253L;
	private MenuItem menuItem;
	private ExternalResource resourceImage;
	
	public MainSettingsLayout() {
		this.addStyleName(VaadinConstant.STYLE_USER_MENU);
		this.resourceImage = new ExternalResource(urlImage());
		this.menuItem = this.addItem("", this.resourceImage, null);
		this.menuItem.addItem(VaadinConstant.MENU_ACCOUNT_SETTINGS, new Command() {
			private static final long serialVersionUID = 5031548674539118377L;
			@Override
			public void menuSelected(MenuItem selectedItem) {
				UI.getCurrent().getNavigator().navigateTo(BeanNameConstant.PROFILE_PAGE_COMPONENT_BEAN);
			}
		});
		this.menuItem.addItem(VaadinConstant.MENU_CHANGE_PASSWORD, new Command() {
			private static final long serialVersionUID = -8899749517717964753L;
			@Override
			public void menuSelected(MenuItem selectedItem) {
				UI.getCurrent().getNavigator().navigateTo(BeanNameConstant.CHANGE_PASSWORD_PAGE_COMPONENT_BEAN);
			}
		});
		this.menuItem.addItem(VaadinConstant.MENU_SIGN_OUT, FontAwesome.SIGN_OUT, new Command() {
			private static final long serialVersionUID = -8912200218801453080L;
			@Override
			public void menuSelected(MenuItem selectedItem) {
				doLogout();
			}
		});
	}
	
	public abstract String urlImage();

}