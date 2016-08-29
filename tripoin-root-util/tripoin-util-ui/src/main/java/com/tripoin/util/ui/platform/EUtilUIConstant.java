package com.tripoin.util.ui.platform;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public enum EUtilUIConstant {
	
	IPHONE("IPhone"),
	IPAD("IPad"),
	WINDOWSPHONE("Windows Phone"),
	ANDROID("Android"),	
	IOS("iOS"),
	MACOSX("Mac OS X"),
	LINUX("Linux"),
	WINDOWS("Windows"),
	
	BROWSER_CHROME("Chrome"),
	BROWSER_FIREFOX("Firefox"),
	BROWSER_SAFARI("Safari"),
	BROWSER_IE("Internet Explorer"),
	BROWSER_OPERA("Opera"),
	BROWSER_OTHER("Other Browser"),
	
	TOUCH_DEVICE("Other Mobile Device"),
	
	PERSONAL_COMPUTER("Computer"),
	
	LOCALHOSTV6("0:0:0:0:0:0:0:1"),
	LOCALHOSTV4("127.0.0.1"),
	LOCALHOST("Localhost");
	
	private String operator;	
	
	private EUtilUIConstant(String operator){
		this.operator = operator ;
	}
	
	@Override
	public String toString() {
		return operator;
	}
	
}
