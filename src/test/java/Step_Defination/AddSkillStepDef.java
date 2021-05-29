package Step_Defination;

import java.util.List;
import java.util.Map;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import DependencyInjection.TestContext;
import Enum.Context;
import Manager.FileReaderManager;
import Pages.HomePage;
import Pages.Qualifications;
import Pages.Skill;
import Pages.adminTab;

public class AddSkillStepDef {

	TestContext testcontext;
	HomePage homepage;
	adminTab admin;
	FileReaderManager frm;
	Qualifications qual;
	Skill sk;

	public AddSkillStepDef(TestContext context) {
		testcontext = context;
		homepage = testcontext.getPageObjectManager().getHomePage();
		frm = FileReaderManager.getInstance();
		admin = testcontext.getPageObjectManager().getAdminPage();
		qual = testcontext.getPageObjectManager().getQualificationPage();

	}

	@Given("^User navigated to Admin tab and Qualification$")
	public void user_navigated_to_Admin_tab_and_Qualification() throws Throwable {
		Thread.sleep(3000);
		testcontext.getWebDriverManager().waitForElementPresence(admin.getAdminTab(), 5);
		testcontext.getWebDriverManager().elementHighlight(admin.getAdminTab());
		testcontext.getWebDriverManager().ClickonTab(admin.getAdminTab());
		testcontext.getWebDriverManager().waitForElementPresence(admin.getUserManagementTab(),3);

         testcontext.getWebDriverManager().elementHighlight(admin.getUserManagementTab());

		testcontext.getWebDriverManager().ClickonTab(admin.getUserManagementTab());
		testcontext.getWebDriverManager().waitForElementPresence(admin.getQualTab(),3);

		testcontext.getWebDriverManager().elementHighlight(admin.getQualTab());

		testcontext.getWebDriverManager().ClickonTab(admin.getQualTab());

	}

	@Given("^Select the Skills from the menubar$")
	public void select_the_Skills_from_the_menubar() throws Throwable {

		sk = qual.ClickSkill();

	}

	@When("^user clicks on the Add button$")
	public void user_clicks_on_the_Add_button() throws Throwable {

		testcontext.getWebDriverManager().waitForElementPresence(sk.getAddButton(), 5);
		testcontext.getWebDriverManager().elementHighlight(sk.getAddButton());
		testcontext.getWebDriverManager().ClickonTab(sk.getAddButton());
		sk.clickAdd();

	}

	@When("^User enters the valid <Skillname > and <Skill Description>$")
public void user_enters_the_valid_Skillname_and_Skill_Description(List<Skill_Data>skilldata) throws Throwable {
		for (Skill_Data skdata : skilldata) {			
		     
			sk.enter_name(skdata.getName());
			testcontext.getScenarioContext().setContext(Context.SKILLNAME, skdata.getName());
			sk.enter_Description(skdata.getDescription());

		}
	}

	@When("^user click on the Save  button$")
	public void user_click_on_the_Save_button() throws Throwable {
		sk.clickSaveButton();
		
	}

	@Then("^Newly added skill should be displayed on the viewSkill page$")
	public void newly_added_skill_should_be_displayed_on_the_viewSkill_page() throws Throwable 
	{
		
	sk.validateAddedSkill((String) testcontext.getScenarioContext().getContext(Context.SKILLNAME));	
  }

	@Then("^Verify the Added Skill name with skill name from viewskill page\\.$")
	public void verify_the_Added_Skill_name_with_skill_name_from_viewskill_page() throws Throwable 
	{
	}


	@Then("^inline error message should be displayed$")
	public void inline_error_message_should_be_displayed() throws Throwable 
	{
		sk.displayErrorMessage();

	}

	@Then("^Verify the error message$")
	public void verify_the_error_message() throws Throwable 
	{
		sk.validateAddedSkill(sk.getErrorMessage());

	}

}
