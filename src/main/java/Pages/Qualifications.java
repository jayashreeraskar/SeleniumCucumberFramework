package Pages;

import java.util.Enumeration;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import DependencyInjection.TestContext;

public class Qualifications {
	WebDriver driver;
	TestContext context;
	public Qualifications(WebDriver driver) 
	{
		   this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	Logger log=Logger.getLogger(Qualifications.class);


	@FindBy(how = How.CSS, using = "a#menu_admin_viewSkills")
	private WebElement skills;

	@FindBy(how = How.CSS, using = "a#menu_admin_viewEducation")
	private WebElement edu;

	@FindBy(how = How.CSS, using = "a#menu_admin_viewLicenses")
	private WebElement linc;

	@FindBy(how = How.CSS, using = "a#menu_admin_viewLanguages")
	private WebElement lang;

	@FindBy(how = How.CSS, using = "a#menu_admin_membership")
	private WebElement member;
	
	@FindBy(how = How.XPATH, using = "//a[@id='menu_admin_Qualifications']") 
	private WebElement qual;


	public WebElement getSkill()
	{
		return skills;
		
		
	}
	public Skill  ClickSkill() 
	{
		skills.click();
		log.info("click on skill");
		return new Skill(this.driver);

	}

	public Education getEducation() {
		edu.click();
		return new Education(this.driver);


	}

	public Licences getLicence() {
		linc.click();
		return new Licences(this.driver);

	}

	public Languages getLanguages() {
		lang.click();
		return new Languages(this.driver);


	}

	public Membership getMember() {
		member.click();
		return new Membership(driver);
	}

}
