package id.co.tripoin.web.ui.view.signin;

import java.io.Serializable;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public interface SignInListener extends Serializable {

	public void doLogin();
	
	public void loginSuccessful();
	
}
