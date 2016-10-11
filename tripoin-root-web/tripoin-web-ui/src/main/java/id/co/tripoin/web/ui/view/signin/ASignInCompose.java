package id.co.tripoin.web.ui.view.signin;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.ui.FormLayout;

import id.co.tripoin.web.ui.view.IContentArea;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public abstract class ASignInCompose extends FormLayout implements IContentArea {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8008632512742071119L;
	private static final String INFORMATION = "<h1>Sign In Information</h1>"
    		+ "Logging On is the process by which individual access to a computer system is controlled by identifying and authenticating the user through the credentials presented by the user.";
	
	@Autowired
	private SignInLayout signInLayout;
	
	@PostConstruct
    public void init() {
		this.contentArea();
    	signInLayout.setInformation(getInformation() != null? getInformation() : INFORMATION);
	}
	
	public abstract String getInformation();

}
