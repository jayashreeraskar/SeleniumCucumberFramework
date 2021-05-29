package Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class adminTab
{
	WebDriver driver;
	public adminTab(WebDriver driver) {
		   this.driver=driver;
	    PageFactory.initElements(driver, this);
	}
	
	Logger log=Logger.getLogger(adminTab.class);
	
	@FindBy(how = How.CSS, using = "a#menu_admin_viewAdminModule") 
	private WebElement adminLink;
	
	@FindBy(how = How.CSS, using = "a#menu_admin_UserManagement") 
	private WebElement userManagement;
	
	@FindBy(how = How.XPATH, using = "//a[@id='menu_admin_Job']") 
	private WebElement job;
	
	@FindBy(how = How.CSS, using = "#menu_admin_Organization") 
	private WebElement org;
	
	@FindBy(how = How.XPATH, using = "//a[@id='menu_admin_Qualifications']") 
	private WebElement qual;

	@FindBy(how = How.XPATH, using = "//a[@id='menu_admin_nationality']") 
	private WebElement nationality;

	@FindBy(how = How.XPATH, using = "//a[@id='menu_admin_Configuration']") 
	private WebElement con;
	
	@FindBy(how=How.CSS,using="a#welcome")
	private WebElement userProfile;
	
	@FindBy(how=How.XPATH,using="//li[@class='current']//preceding-sibling::ul")
	private WebElement menubar;

	@FindBy(how=How.XPATH,using="//a[@id='menu_leave_viewLeaveModule']")
	private WebElement Leave;


	public void clickmenubar()
	{
		menubar.click();	
		log.info("clicked on Menubar");
	}
	
	public void clickLeave()
	{
		Leave.click();		
	}

	
	public boolean isdisplayed()
	{
		log.info(userProfile+"is displayed");

		return userProfile.isDisplayed();

		
	}
	public String getProfile()
	{
		log.info(userProfile.getText()+"is displayed");

		return userProfile.getText();
		
		
	}
	public UserManagement clickAdminLink()
	{
		
		log.info(userManagement+" clicked on admin tab");

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", userManagement);		

		return new UserManagement(driver);
	}
	public WebElement getAdminTab()
	{
		return adminLink;
		
		
	}
	
	public WebElement getUserManagementTab()
	{
		return userManagement;
		
		
	}
	

	public WebElement getQualTab()
	{
		return qual;
		
		
	}

	
	public JOBPage clickJobLink() {
		job.click();
		log.info(job+" clicked on tab");

		return new JOBPage(driver);
	}
	
	public Organization clickOrganizationLink() {
		org.click();
		log.info(org+" clicked on org tab");

		return new Organization(driver);
	}

	public Qualifications clickQualificationLink() {
		qual.click();
		log.info(qual+" clicked on qualification tab");

		return new Qualifications(driver);
	}

	public void clickNationality()
	{

		nationality.click();
		
	}
	public Configurations clickConfLink() {
		con.click();
		return new Configurations(driver);
	}


	


}
