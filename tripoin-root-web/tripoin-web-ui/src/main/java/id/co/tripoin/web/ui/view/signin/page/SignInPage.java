package id.co.tripoin.web.ui.view.signin.page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Component;

import com.vaadin.event.ShortcutAction;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;

import id.co.tripoin.web.constant.statics.BeanNameConstant;
import id.co.tripoin.web.constant.statics.CommonConstant;
import id.co.tripoin.web.constant.statics.NavigatorConstant;
import id.co.tripoin.web.constant.statics.VaadinConstant;
import id.co.tripoin.web.ui.servlet.VaadinView;
import id.co.tripoin.web.ui.view.signin.ASignInCompose;
import id.co.tripoin.web.ui.view.signin.SignInListener;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
@Component(BeanNameConstant.SIGN_IN_PAGE_COMPONENT_BEAN)
@Scope(value = CommonConstant.PROTOTYPE)
@VaadinView(value = NavigatorConstant.NAV_HOME, cached = true)
public class SignInPage extends ASignInCompose implements SignInListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6035382015120503593L;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	private TextField username;
    private PasswordField password;
    private Button signIn;
    private Button forgotPassword;
    
    @Override
    public void contentArea() {
        this.addComponent(username = new TextField("Username"));
        username.focus();
        username.setWidth(15, Unit.EM);
        username.setDescription("Username Or Email Or Phone Number");
        username.setMaxLength(55);
        this.addComponent(password = new PasswordField("Password"));
        password.setWidth(15, Unit.EM);
        password.setDescription("Password");
        password.setMaxLength(50);
        
        CssLayout styleButtons = new CssLayout();
        styleButtons.setStyleName(VaadinConstant.STYLE_BUTTONS);
        this.addComponent(styleButtons);
        styleButtons.addComponent(signIn = new Button("Sign In"));
        signIn.setDisableOnClick(true);
        signIn.addClickListener(new Button.ClickListener() {
            /**
			 * 
			 */
			private static final long serialVersionUID = 53728288770839955L;

			@Override
            public void buttonClick(Button.ClickEvent event) {
                try {
                	doLogin();
                } finally {
                    signIn.setEnabled(true);
                }
            }
        });
        signIn.setClickShortcut(ShortcutAction.KeyCode.ENTER);
        signIn.addStyleName(ValoTheme.BUTTON_FRIENDLY);

        styleButtons.addComponent(forgotPassword = new Button("Forgot password?"));
        
        forgotPassword.addStyleName(ValoTheme.BUTTON_LINK);    	
    }

	@Override
	public void doLogin() {
		
	}

	@Override
	public void loginSuccessful() {
		UI.getCurrent().getPage().setLocation(VaadinConstant.HOME_PATH);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		this.doLogin();
	}

	@Override
	public String getInformation() {
		return null;
	}

}
