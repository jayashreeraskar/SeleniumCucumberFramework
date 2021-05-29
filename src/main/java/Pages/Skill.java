package Pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class Skill 
{
	WebDriver driver;
	Logger log=Logger.getLogger(Skill.class);
	
	public Skill(WebDriver driver)
	{
		   this.driver=driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.CSS, using ="input#btnAdd")
	private WebElement addButton;

	@FindBy(how = How.CSS, using = "input.delete")
	private WebElement delete;

	@FindBy(how = How.CSS, using = "input[type=text]")
	private WebElement nameTextBox;

	@FindBy(how = How.CSS, using = "textarea#skill_description")
	private WebElement skillDescription;

	@FindBy(how = How.CSS, using = "input[name='btnSave']")
	private WebElement saveButton;

	@FindBy(how = How.CSS, using = "input#btnCancel")
	private WebElement cancelButton;

	@FindBy(how = How.CSS, using = "table#recordsListTable")
	private WebElement tableData;
	@FindBy(how = How.XPATH, using = "//a[@id='menu_admin_Qualifications']") 
	private WebElement qual;
	
	@FindBy(how=How.CSS,using="span.validation-error")
	private WebElement errorMessage;


	public WebElement getAddButton()
	{
		
		return addButton;
	}
	public void enter_name(String uname) {
		nameTextBox.clear();
		nameTextBox.sendKeys(uname);
		log.info(uname+"is added as skill name");
	}

	public void enter_Description(String pass) {
		skillDescription.clear();
		skillDescription.sendKeys(pass);
		log.info(pass+"is added as skill name");

	}

	public void clickAdd() {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", addButton);		


		


	}

	public void clickDelete() {
		delete.click();

	}

	public void clickSaveButton() {
		saveButton.click();
		log.info("skill added successfully");


	}

	public void clickCancelButton() {
		cancelButton.click();

	}
	public String getErrorMessage()
	{
		return errorMessage.getText();
	}
	public boolean displayErrorMessage()
	{
		return errorMessage.isDisplayed();

	}

	public void deleteSkill(String name) {
		List<WebElement> trs = tableData.findElements(By.xpath("//tbody/tr"));
		for (int j = 0; j <= trs.size() - 1; j++) {
			List<WebElement> tds = trs.get(j).findElements(By.tagName("td"));
			for (int i = 0; i < tds.size() - 1; i++) {
				if (tds.get(i).getText().contains(name)) {
					WebElement checkbox = trs.get(j).findElement(By.xpath("//td[@class='check']"));
					checkbox.click();
					clickDelete();
					log.info(name+"is deleted successfully");


				}

			}

		}

	}

	public void UpdateSkill(String name, String newname, String skill)
	{
		List<WebElement> trs = tableData.findElements(By.xpath("//tbody/tr"));
		for (int j = 0; j <= trs.size() - 1; j++) {
			List<WebElement> tds = trs.get(j).findElements(By.tagName("td"));
			for (int i = 0; i < tds.size() - 1; i++) {
				if (tds.get(i).getText().contains(name)) {
					tds.get(i).click();
					enter_name(newname);
					enter_Description(skill);
					log.info(name+"is updated successfully");


				}

			}

		}

	}
	
	public  void validateAddedSkill(String str)
	{
		List<WebElement> trs = tableData.findElements(By.xpath("//tbody//tr"));
		for (int j = 0; j <= trs.size() - 1; j++) {
			List<WebElement> tds = trs.get(j).findElements(By.xpath(("//td//a")));
			for (int i = 0; i < tds.size() - 1; i++)
			{
				String str1=tds.get(i).getText();
				Assert.assertEquals(str, str1);

			}

		}

	}
	
		public double getRandom()
		{
			
		
			return Math.random();
			}
	}
	


