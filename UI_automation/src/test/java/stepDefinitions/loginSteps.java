package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Page_object.loginPage;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;
public class loginSteps {
	
	public  WebDriver driver;
	public  WebDriverWait wait;
	public loginPage lp;
	
	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() throws IOException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		wait= new WebDriverWait(driver,Duration.ofSeconds(30));
		lp =new loginPage(driver,wait);	
		
	}

	@When("User open web url {string}")
	public void user_open_web_url(String url) {
	   driver.get(url);
	   driver.manage().window().maximize();	   
	}

	@When("Enters email as {string} and password as {string}")
	public void enters_email_as_and_password_as(String names, String passw) {
		lp.setusername(names);
		lp.setpassword(passw);
		
	
	    
	}

	@When("Click on login button")
	public void click_on_login_button() {
		lp.loginclick();
	}

	@Then("User should be redirected to home page having url as {string}")
	public void user_should_be_redirected_to_home_page_having_url_as(String url) {
		Assert.assertEquals(url, driver.getCurrentUrl().toString());   
	}
	
	


    @And ("user click on logout button")
    public void user_click_on_logout_button() throws InterruptedException {
    	lp.logoutclick();
    	
    	
    	
    }
    
    @Then("Validate error message obtained")
    public void validate_error_message_obtained() {
        lp.validatemsg();
    }
	
	
	
}
