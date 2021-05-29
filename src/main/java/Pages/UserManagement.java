package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class UserManagement 
{
	public UserManagement(WebDriver driver)
	{
	    PageFactory.initElements(driver, this);
	    }
	@FindBy(how=How.CSS ,using="a#menu_admin_viewSystemUsers")
	private WebElement users;
	
	public void clickUsers()
	{
		users.click();
		
	}

}
