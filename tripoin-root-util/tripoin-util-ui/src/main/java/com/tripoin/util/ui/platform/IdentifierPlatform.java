package com.tripoin.util.ui.platform;

import com.vaadin.server.WebBrowser;

/**
 * @author <a href="mailto:ridla.fadilah@gmail.com">Ridla Fadilah</a>
 */
public class IdentifierPlatform {
	
	private WebBrowser webBrowser;
	
	public IdentifierPlatform() {}
	
	public IdentifierPlatform(WebBrowser webBrowser) {
		this.webBrowser = webBrowser;
	}

	public String getOperatingSystem(){
		if(this.webBrowser.isIOS())
			return EUtilUIConstant.IOS.toString();
		else if(this.webBrowser.isLinux())
			return EUtilUIConstant.LINUX.toString();
		else if(this.webBrowser.isWindows())
			return EUtilUIConstant.WINDOWS.toString();
		else if(this.webBrowser.isMacOSX())
			return EUtilUIConstant.MACOSX.toString();
		else
			return EUtilUIConstant.ANDROID.toString();
	}
	
	public String getDevice(){
		if(this.webBrowser.isIPhone())
			return EUtilUIConstant.IPHONE.toString();
		else if(this.webBrowser.isIPad())
			return EUtilUIConstant.IPAD.toString();
		else if(this.webBrowser.isWindowsPhone())
			return EUtilUIConstant.WINDOWSPHONE.toString();
		else if(this.webBrowser.isTouchDevice())
			return EUtilUIConstant.TOUCH_DEVICE.toString();
		else
			return EUtilUIConstant.PERSONAL_COMPUTER.toString();
	}
	
	public String getBrowser(){
		if(this.webBrowser.isChrome())
			return EUtilUIConstant.BROWSER_CHROME.toString();
		else if(this.webBrowser.isFirefox())
			return EUtilUIConstant.BROWSER_FIREFOX.toString();
		else if(this.webBrowser.isIE())
			return EUtilUIConstant.BROWSER_IE.toString();
		else if(this.webBrowser.isOpera())
			return EUtilUIConstant.BROWSER_OPERA.toString();
		else if(this.webBrowser.isSafari())
			return EUtilUIConstant.BROWSER_SAFARI.toString();
		else
			return EUtilUIConstant.BROWSER_OTHER.toString();
	}
	
	public String getIPAddress(){
		if(EUtilUIConstant.LOCALHOSTV6.toString().equals(this.webBrowser.getAddress()))
			return EUtilUIConstant.LOCALHOSTV4.toString();
		return this.webBrowser.getAddress();
	}
	
}
