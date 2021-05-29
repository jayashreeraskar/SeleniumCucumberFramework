package Manager;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import Enum.BrowserType;
import Enum.EnvironmentType;

public class WebdriverManager {
	private WebDriver driver;
	private static BrowserType driverType;
	private static EnvironmentType environmentType;
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";
	private static final String FF_DRIVER_PROPERTY = "webdriver.gecko.driver";
	Actions action;
	 Logger log=Logger.getLogger(WebdriverManager.class);


	public WebdriverManager() {
		driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
		environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
	}

	public WebDriver getDriver() {
		if (driver == null)
			driver = createDriver();
		return driver;
	}

	private WebDriver createDriver() {
		switch (environmentType) {
		case LOCAL:
			driver = createLocalDriver();
			break;
		case REMOTE:
			driver = createRemoteDriver();
			break;
		}
		return driver;
	}

	private WebDriver createRemoteDriver() {
		throw new RuntimeException("RemoteWebDriver is not yet implemented");
	}

	private WebDriver createLocalDriver() {
		switch (driverType) {
		case FIREFOX:
			System.setProperty(FF_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigReader().getDriverPath());
			driver = new FirefoxDriver();
			log.info("Firefox Launched");
			break;
		case CHROME:
			System.setProperty(CHROME_DRIVER_PROPERTY,
					FileReaderManager.getInstance().getConfigReader().getDriverPath());
			driver = new ChromeDriver();
			log.info("Chrome Launched");

			break;
		case INTERNETEXPLORER:
			driver = new InternetExplorerDriver();
			log.info("IE Launched");

			break;
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(),
				TimeUnit.SECONDS);
		return driver;
	}

	public void closeDriver() {
		driver.close();
		driver.quit();
	}

	public void waitForElementPresence(WebElement str, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOf(str));
	}

	public void jsWaitForPageToLoad(int timeOutInSeconds) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String jsCommand = "return document.readyState";

		// Validate readyState before doing any waits
		if (js.executeScript(jsCommand).toString().equals("complete")) {
			return;
		}

		for (int i = 0; i < timeOutInSeconds; i++) {

			if (js.executeScript(jsCommand).toString().equals("complete")) {
				break;
			}
		}
	}

	public WebElement findElementThatIsPresent(final By byLocator, int maxWaitTime) {
		FluentWait<WebDriver> wait = new FluentWait<>(driver)
				.withTimeout(maxWaitTime, java.util.concurrent.TimeUnit.SECONDS)
				.pollingEvery(200, java.util.concurrent.TimeUnit.MILLISECONDS);

		try {
			return wait.until((WebDriver webDriver) -> {
				List<WebElement> elems = driver.findElements(byLocator);
				if (elems.size() > 0) {
					return elems.get(0);
				} else {
					return null;
				}
			});
		} catch (Exception e) {
			return null;
		}
	}

	public void ClickonTab(WebElement str) {
		// action.moveToElement(str);
		action=new Actions(driver);

		waitForElementPresence(str, 5);
		elementHighlight(str);
		String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";

		((JavascriptExecutor) driver).executeScript(mouseOverScript, str);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", str);
		waitForElementPresence(str, 5);

		//((JavascriptExecutor) driver).executeScript("arguments[0].click();", str);
		action.clickAndHold(str).pause(Duration.ofSeconds(8)).perform();

	}
	public void clickOnElement(WebElement str)
	{
		action=new Actions(driver);
	action.moveToElement(str).click().build().perform();
		
	}


	public void elementHighlight(WebElement element) {
		for (int i = 0; i < 2; i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
					"color: red; border: 5px solid red;");
			js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
		}
	
		

	}
    public void init() 
    {
      String log4jConfPath="\\src\\main\\resources\\LoggerProperty\\log4j.properties";
      PropertyConfigurator.configure("System.getProperty(user.dir)"+log4jConfPath);
    }

	
}