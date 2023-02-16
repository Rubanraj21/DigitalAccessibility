package utilities;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public static WebDriver driver; 

	public static WebDriver browsers(String browserName) {
		try {
			if(browserName.equalsIgnoreCase("chrome")) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("start-maximized");
				WebDriverManager.chromedriver().setup();
				return driver = new ChromeDriver(options);	
			}
			else if(browserName.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				return driver = new FirefoxDriver();	
			}
			else if(browserName.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				return driver = new EdgeDriver();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}

	public static void url(String url) {
		driver.get(url);

	}
	public static void quit() {
		driver.quit();
	}
	
	public void click(WebElement ele) {
		ele.click();
	}
	
	public static void commonWait(long seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}
	
	public static String retreiveText(WebElement ele) {
		return ele.getText();
		
	}
	
	public void scrollByElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

}
