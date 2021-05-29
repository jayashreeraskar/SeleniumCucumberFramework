package DependencyInjection;

import Manager.PageObjectManager;
import Manager.WebdriverManager;

public class TestContext
{
	private WebdriverManager webDriverManager;
	private PageObjectManager pageObjectManager;
	public ScenarioContext scenarioContext;

	
	public TestContext(){
		webDriverManager = new WebdriverManager();
		// common=new commonMethods(webDriverManager.getDriver());
		 pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
		 scenarioContext=new ScenarioContext();
	}
	
	public WebdriverManager getWebDriverManager() {
		return webDriverManager;
	}
	
	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}
	
	public ScenarioContext getScenarioContext() {
		return scenarioContext;
	
/*	public commonMethods getCommonObject() {
		return common;
	}
*/
	}

}
