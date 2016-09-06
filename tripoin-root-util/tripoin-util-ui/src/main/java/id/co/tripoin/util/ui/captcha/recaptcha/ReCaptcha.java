package id.co.tripoin.util.ui.captcha.recaptcha;

import id.co.tripoin.util.ui.captcha.recaptcha.shared.ReCaptchaOptions;
import id.co.tripoin.util.ui.captcha.recaptcha.shared.ReCaptchaState;
import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;

import com.vaadin.annotations.JavaScript;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.AbstractJavaScriptComponent;
import com.vaadin.ui.JavaScriptFunction;

import elemental.json.JsonArray;

/**
 * Vaadin wrapper component for ReCaptcha javascript API. recaptcha4j wrapped too for server-side validation.
 *
 * @author <a href="mailto:tripoinstudio@gmail.com">Tripoin, inc.</a>
 */
@JavaScript("recaptcha-connector.js")
public class ReCaptcha extends AbstractJavaScriptComponent {

    private static final long serialVersionUID = 1L;

    private String challenge;
    private String response;
    private transient ReCaptchaImpl recaptcha4j;
    private final String privateKey;

    public ReCaptcha(String privateKey, String publicKey, ReCaptchaOptions options) {
        this(privateKey, publicKey, options, null);
    }

    public ReCaptcha(String privateKey, String publicKey, ReCaptchaOptions options, String customHtml) {
        super();
        getState().publicKey = publicKey;
        getState().options = options;
        getState().customHtml = customHtml;
        addFunction("responseChanged", new JavaScriptFunction() {
			private static final long serialVersionUID = 91209734622078933L;
			@Override
            public void call(JsonArray arguments) {
                challenge = arguments.getString(0);
                response = arguments.getString(1);
            }
        });
        this.privateKey = privateKey;
    }

    private ReCaptchaImpl getRecaptcha4j() {
        if (recaptcha4j == null) {
            recaptcha4j = new ReCaptchaImpl();
            recaptcha4j.setPrivateKey(privateKey);
        }
        return recaptcha4j;
    }

    @Override
    protected ReCaptchaState getState() {
        return (ReCaptchaState) super.getState();
    }

    /**
     * Validates the answer with server-side ReCaptcha api.
     * When the answer is empty returns false.
     * When the answer is valid, this method will return true for the first time only.
     * When the answer is invalid, you have to reload to get a new chance to pass.
     * This behavior comes from ReCaptcha.
     * Recaptcha4j used for handling the api.
     *
     * @return valid, or not
     */
    public boolean validate() {
        if (isEmpty()) {
            return false;
        }
        String remoteAddr = VaadinService.getCurrentRequest().getRemoteAddr();
        ReCaptchaResponse reCaptchaResponse = getRecaptcha4j().checkAnswer(remoteAddr, challenge, response);
        return reCaptchaResponse.isValid();
    }

    /**
     * Is user filled the input?
     * @return is empty
     */
    public boolean isEmpty() {
        return response == null || response.isEmpty();
    }

    /**
     * Reloads the captcha.
     */
    public void reload() {
        callFunction("reload");
    }

}
