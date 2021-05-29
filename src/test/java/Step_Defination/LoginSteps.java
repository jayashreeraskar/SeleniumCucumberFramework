package Step_Defination;

import java.util.Map;

import org.apache.log4j.Logger;

import DependencyInjection.TestContext;
import Manager.FileReaderManager;
import Pages.HomePage;
import Pages.adminTab;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps 
{
	Logger log=Logger.getLogger(LoginSteps.class);
	TestContext testcontext;
	HomePage homepage;
	adminTab admin;
	FileReaderManager frm;
	public LoginSteps(TestContext context)
	{
		testcontext=context;
		homepage=testcontext.getPageObjectManager().getHomePage();
	   frm=FileReaderManager.getInstance();
	   admin=testcontext.getPageObjectManager().getAdminPage();
		
		
	}
	
	@Given("^user is  navigated to homepage of the application$")
	public void user_is_navigated_to_homepage_of_the_application() throws Throwable 
	{
		String url=frm.getConfigReader().getApplicationUrl();
		homepage.navigate_Homepage(url);
		testcontext.getWebDriverManager().jsWaitForPageToLoad(3);

	}

	@When("^user enter the <Username> and <Password>$")
	public void user_enter_the_Username_and_Password(DataTable usercredentials) throws Throwable 
	{
		for (Map<String, String> data : usercredentials.asMaps(String.class, String.class)) 
		{
			testcontext.getWebDriverManager().elementHighlight(homepage.getUserName());

			homepage.enter_username(data.get("Username"));
			testcontext.getWebDriverManager().elementHighlight(homepage.getPassword());

			homepage.enter_Password(data.get("Password"));


		
		}
	}

	@When("^click on the Login button$")
	public void click_on_the_Login_button() throws Throwable
	{
		
		testcontext.getWebDriverManager().elementHighlight(homepage.getLoginButton());

		admin=homepage.clickLogin();
		testcontext.getWebDriverManager().jsWaitForPageToLoad(10);


	}

	@Then("^user should be redirected to dashboard page$")
	public void user_should_be_redirected_to_dashboard_page() throws Throwable 
	{
		Boolean idredirected=admin.isdisplayed();

	}

	@Then("^check the Admin message\\.$")
	public void check_the_Admin_message() throws Throwable
	{

		String str=admin.getProfile();
	}

	@Then("^Application should prompt the valid error message to user$")
	public void application_should_prompt_the_valid_error_message_to_user() throws Throwable
	{
		String message=homepage.displayError();
		testcontext.getWebDriverManager().elementHighlight(homepage.getErrorMessage());

		System.out.println(message);
	}



}
