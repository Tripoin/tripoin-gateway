package com.tripoin.util.mail;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public interface ICoreMailSender {
	
	public void sendMailContent(String from, String to, String subject, String content);

}
