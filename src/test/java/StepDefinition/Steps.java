package StepDefinition;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.jcraft.jsch.Session;

import AppiumServerStart.JSchExampleSSHConnection;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class Steps {

	public static WebDriver driver;

	@Before
	public void beforeMethod() {

		System.out.println("before code executing ...");
	}

	@Given("^when i open firefox$")
	public void when_i_open_firefox() throws Throwable {

		JSchExampleSSHConnection ref1 = new JSchExampleSSHConnection();

		ref1.runOnRemoteMac("127.0.0.1 ", 4724); // give 1 space afet ip

		Thread.currentThread().setName("Thread 2");
		Thread t = Thread.currentThread();
		String name = t.getName();
		long id = Thread.currentThread().getId();

		System.out.println("Before test-method. Thread id is: " + id + "Thread name is:" + name);
		driver = new FirefoxDriver();

	}

	@Given("^when i open chrome$")
	public void when_i_open_chrome() throws Throwable {
		JSchExampleSSHConnection ref1 = new JSchExampleSSHConnection();

		ref1.runOnRemoteMac("127.0.0.1 ", 4725); // give 1 space afet ip

		Thread.currentThread().setName("Thread 1");
		Thread t = Thread.currentThread();
		String name = t.getName();
		long id = Thread.currentThread().getId();

		System.out.println("Before test-method. Thread id is: " + id + "Thread name is:" + name);
		driver = new ChromeDriver();
		// set capabilities
				
				//
	}

	@When("^i navigate to google$")
	public void i_navigate_to_google() throws Throwable {
		driver.get("http://google.com");
		
	}

	@Then("^i see the page$")
	public void i_see_the_page() throws Throwable {
		System.out.println(driver.getTitle());

		Thread t = Thread.currentThread();
		String name = t.getName();
		long id = Thread.currentThread().getId();

		System.out.println("thread done its work its info : Thread id is: " + id + "Thread name is:" + name);

		// driver.close();
	}

}
