package mailDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriveCreator {
	
	public WebDriver createBrowser(String browser) {
		WebDriver driver;

		//Different paths to your specified web driver should be here
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:/,Kodning/Selenium Webdriver/chromedriver.exe");
			driver = new ChromeDriver();
		
		}else if(browser.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", "D:/,Kodning/Selenium Webdriver/geckodriver.exe");
			driver = new FirefoxDriver();
		
		}else{
			System.setProperty("webdriver.gecko.driver", "D:/,Kodning/Selenium Webdriver/geckodriver.exe");
			driver = new EdgeDriver();
		}

		return driver;
		
	}
	
}