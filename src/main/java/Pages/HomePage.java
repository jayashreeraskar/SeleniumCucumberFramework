package Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import DependencyInjection.TestContext;

public class HomePage 
{
	WebDriver driver;
	TestContext tc;
	
	public HomePage(WebDriver driver) 
	{
	   this.driver=driver;
	    PageFactory.initElements(driver, this);
	    
	}
	Logger log=Logger.getLogger(HomePage.class);

	
	
	
	@FindBy(how = How.CSS, using = "#txtUsername") 
	private WebElement userName;
	
	@FindBy(how = How.CSS, using = "input#txtPassword") 
	private WebElement password;
	
	@FindBy(how = How.CSS, using = "#btnLogin") 
	private WebElement loginButton;
	
	@FindBy(how = How.CSS, using = "#openIdProvider") 
	private WebElement alter_Login;
	
	@FindBy(how = How.CSS, using = "#openIdLogin") 
	private WebElement altLoginButton;
	
	@FindBy(how=How.CSS ,using="span#spanMessage")
	private WebElement errorMessage;

	public void enter_username(String uname) {
		userName.clear();
		userName.sendKeys(uname);
		log.info(uname+"is entered in Username field ");
	}
	
	public WebElement getUserName() {
		return userName;
	}


	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public WebElement getErrorMessage() {
		return errorMessage;
	}

	public void enter_Password(String pass) {
		password.clear();
		password.sendKeys(pass);
		log.info(pass+"is entered in Password field ");

	}
	
	public void selectalterlogin(String str)
	{
		Select sel=new Select(alter_Login);

		sel.selectByVisibleText(str);
		
	}

	public adminTab clickLogin()
	{

		loginButton.click();
		log.info("click on the login button");
		return new adminTab(driver);
		
		
	}
	public void navigate_Homepage(String url)
	{
		driver.get(url);
		
	}

	public String displayError()
	{

		return errorMessage.getText();

		
		
	}

	
}
