package id.co.tripoin.web.ui.view.signin;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import id.co.tripoin.web.constant.statics.BeanNameConstant;
import id.co.tripoin.web.constant.statics.CommonConstant;
import id.co.tripoin.web.constant.statics.VaadinConstant;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
@Component(BeanNameConstant.SIGN_IN_LAYOUT_COMPONENT_BEAN)
@Scope(value = CommonConstant.REQUEST)
public class SignInLayout extends ASignInLayout {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4224302520980225809L;
	private FormLayout contentArea = new FormLayout();
	private CssLayout loginInformation = new CssLayout();
	
	public SignInLayout() {
        this.addStyleName(VaadinConstant.STYLE_LOGIN_SCREEN);
        this.addComponent(centeringLayout());
        this.addComponent(getInformation());
	}
	
	@Override
	public com.vaadin.ui.Component centeringLayout() {
		VerticalLayout centeringLayout = new VerticalLayout();
        centeringLayout.addStyleName(VaadinConstant.STYLE_CENTERING_LAYOUT);
        centeringLayout.addComponent(this.contentArea());
        centeringLayout.setComponentAlignment(this.contentArea(), Alignment.MIDDLE_CENTER);	
		return centeringLayout;
	}

	@Override
	public com.vaadin.ui.Component getInformation() {
		this.loginInformation.setStyleName(VaadinConstant.STYLE_LOGIN_INFORMATION);
		return this.loginInformation;
	}

	@Override
	public void setInformation(String information) {
		this.loginInformation.addComponent(new Label(information, ContentMode.HTML));
	}

	@Override
	public ComponentContainer contentArea() {
		contentArea.addStyleName(VaadinConstant.STYLE_SIGN_IN_FORM);
        contentArea.setSizeUndefined();
        contentArea.setMargin(false);
		return this.contentArea;
	}

}
