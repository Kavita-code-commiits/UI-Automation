package Page_object;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class loginPage {

	public WebDriverWait wait1;
	WebDriver driver;
		
	public loginPage(WebDriver driver, WebDriverWait wait) {
	 PageFactory.initElements(driver,this);
	 this.driver=driver;
	 wait1=wait;

	}
	
	@FindBy(id="Email")
	WebElement username;
	
	@FindBy(id ="Password")
	WebElement password;
	
	@FindBy(xpath ="//button[contains(text(),'Log in')]")
	WebElement LgnBtn;
	
	@FindBy(xpath="//strong[contains(text(),'Welcome, please sign in!')]")
	public WebElement veri;
	
	
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	WebElement logout;
	
	@FindBy(xpath="//div[contains(text(),'Login was unsuccessful. Please correct the errors and try again.')]")
	WebElement erroemesg;
	
	
	public void setusername(String name) {
		wait1.until(ExpectedConditions.visibilityOf(veri));
		username.clear();
		
		username.sendKeys(name);
		
		
		
	}
	
	public void setpassword(String pass) {
		password.clear();
		password.sendKeys(pass);
		
		
	}
	
	public void loginclick() {
		//wait1.until(ExpectedConditions.visibilityOf(LgnBtn));
		
		LgnBtn.click();
		
		
	}
	
	
	public void logoutclick() throws InterruptedException {
		Thread.sleep(4000);
		logout.click();
		wait1.until(ExpectedConditions.visibilityOf(veri));
		
		Assert.assertTrue(veri.getText().contains("Welcome, please sign in!"));
		
	}
	
	public void validatemsg() {
		wait1.until(ExpectedConditions.visibilityOf(erroemesg));
		Assert.assertTrue(erroemesg.getText().contains("Login was unsuccessful"));
		
		
	}
	
	
	
}
