package id.co.tripoin.util.ui.captcha.recaptcha.shared;

import java.io.Serializable;

/**
 * ReCaptcha options.
 * 
 * Property names are same as javascript property names.
 * See here: https://developers.google.com/recaptcha/docs/customization
 * 
 * @author <a href="mailto:tripoinstudio@gmail.com">Tripoin, inc.</a>
 */
public class ReCaptchaOptions implements Serializable {

	private static final long serialVersionUID = -8991122997551568280L;
	public String lang;
    public String theme;
    public String custom_theme_widget;
    public int tabindex;
    public CustomTranslations custom_translations;

    public static class CustomTranslations implements Serializable {

		private static final long serialVersionUID = 655163968185467795L;
		public String instructions_visual;
        public String instructions_audio;
        public String play_again;
        public String cant_hear_this;
        public String visual_challenge;
        public String audio_challenge;
        public String refresh_btn;
        public String help_btn;
        public String incorrect_try_again;
    }
}
