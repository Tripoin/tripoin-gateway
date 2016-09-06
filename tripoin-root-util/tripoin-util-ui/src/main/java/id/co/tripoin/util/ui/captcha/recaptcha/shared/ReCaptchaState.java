package id.co.tripoin.util.ui.captcha.recaptcha.shared;

import com.vaadin.shared.ui.JavaScriptComponentState;

/**
 * @author <a href="mailto:tripoinstudio@gmail.com">Tripoin, inc.</a>
 */
public class ReCaptchaState extends JavaScriptComponentState {

	private static final long serialVersionUID = -868512734863455567L;

	public String publicKey;

    public String customHtml;

    public ReCaptchaOptions options;

}
