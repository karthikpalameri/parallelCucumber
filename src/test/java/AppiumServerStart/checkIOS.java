package AppiumServerStart;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobilePlatform;

public class checkIOS {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("deviceName", "All'sComcast");
		capabilities.setCapability("platformVersion", "11.4.1");
		capabilities.setCapability("udid", "5b3e9b6295566480f3ee4d1d51c206a1dcf3c686");

		capabilities.setCapability("app", "/Users/pintu/Downloads/BusinessApp.ipa");
		capabilities.setCapability("newCommandTimeout", "600000");
		capabilities.setCapability("pplatformName", MobilePlatform.IOS);
		capabilities.setCapability("automationName", "XCUITest");
		System.out.println("till");
//	IOSDriver<IOSElement> drivertemp = new IOSDriver<IOSElement>(new URL("http://127.0.0.1:4725/wd/hub"),	capabilities);
		AppiumDriver driver = new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		System.out.println("done capability set");
	}

}
