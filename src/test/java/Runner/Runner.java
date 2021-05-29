package Runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import Manager.FileReaderManager;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
features = "D:\\selenium\\Cucumber_Framework\\src\\test\\resources\\Feature", 
tags = { "@Skill" },
glue = "Step_Defination",
monochrome = true, 
dryRun = false, 
plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}
)
public class Runner 
{
	@AfterClass
	public static void writeExtentReport() {
			Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
		    Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		    Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
		    Reporter.setSystemInfo("Machine", 	"Windows 10" + "64 Bit");
		    Reporter.setSystemInfo("Selenium", "3.7.0");
		    Reporter.setSystemInfo("Maven", "3.5.2");
		    Reporter.setSystemInfo("Java Version", "1.8.0_151");

		
	}
	

}
