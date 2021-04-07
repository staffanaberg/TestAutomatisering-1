package mailDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class MailDefinitions {

	private WebDriver driver;
	Random randomGenerator = new Random();  
	int randomInt = randomGenerator.nextInt(10000);
	String longUsername = "username";
	String repeated = longUsername.repeat(13);
	String hundred = "Enter a value less than 100 characters long";
	String exists = "Another user with this username already exists. Maybe it's your evil twin. Spooky.";
	String value = "Please enter a value";
	String check = "Check your email";
	
	@Before
	public void openBrowser() {
		DriveCreator creator = new DriveCreator();
		driver = creator.createBrowser("chrome");
	    driver.get("https://login.mailchimp.com/signup/");
	    driver.manage().window().maximize();
	    click(driver, By.id("onetrust-accept-btn-handler"));
	 
	}
		@Given("I have entered an {string} into the email slot")
		public void i_have_entered_an_into_the_email_slot(String email) {
		    if(email.equals("email")) {
		    	sendKeys(driver, By.id("email"), email + randomInt + "@gmail.com");
		    }
		    else if(email.equals("")) {
		    	sendKeys(driver, By.id("email"), "");
		    }
		    
		}
		@Given("I have also entered an {string} into the username slot")
		public void i_have_also_entered_an_into_the_username_slot(String username) {
			switch (username) {
				case "username":
					sendKeys(driver, By.id("new_username"), username + randomInt);
					break;
				case "longUsername":
					sendKeys(driver, By.id("new_username"), repeated);
					break;
				case "Adam653":
					sendKeys(driver, By.id("new_username"), username);
					break;
			}
		}
		@Given("I have also entered a {string} into the password slot")
		public void i_have_also_entered_a_into_the_password_slot(String password) {
			sendKeys(driver, By.id("new_password"), password);
		}
		@When("I press sign up")
		public void i_press_sign_up() {
			click(driver, By.id("create-account"));
		}
		@Then("I will {string}")
		public void i_will(String verify) throws InterruptedException {
			
			if(verify.equals(check)) {
				assertEquals(verify, driver.findElement(By.cssSelector(".\\!margin-bottom--lv3")).getText());
				Thread.sleep(2000);
				driver.quit();
			}
			else if(verify.equals(hundred)){
				assertEquals(verify, driver.findElement(By.cssSelector(".invalid-error")).getText());
				Thread.sleep(2000);
				driver.quit();
			}
			else if(verify.equals(exists)) {
				assertEquals(verify, driver.findElement(By.cssSelector(".invalid-error")).getText());
				Thread.sleep(2000);
				driver.quit();
			}
			else if(verify.equals(value)){
					assertEquals(verify, driver.findElement(By.cssSelector(".invalid-error")).getText());
					Thread.sleep(2000);
					driver.quit();
			
			}
		}

		public void click(WebDriver driver, By by) {
			(new WebDriverWait(driver,10)).until(ExpectedConditions.
		
					elementToBeClickable(by));
					driver.findElement(by).click();
			}
			public void sendKeys(WebDriver driver, By by, String keys) {
				(new WebDriverWait(driver,10)).until(ExpectedConditions.presenceOfElementLocated(by));
				
					driver.findElement(by).sendKeys(keys);

	}

}