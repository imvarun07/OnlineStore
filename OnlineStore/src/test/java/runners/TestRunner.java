package runners;

import java.io.File;
import com.cucumber.listener.Reporter;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;

import cucumber.api.junit.Cucumber;
import dataProvider.ConfigFileReader;
import utility.BrowserFactory;
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/functionalTests",
		glue= {"stepDefinitions"},
		plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
		monochrome = true
		)
public class TestRunner {
	@AfterClass
	public static void writeExtentReport() {
		ConfigFileReader configFileReader = new ConfigFileReader();
		Reporter.loadXMLConfig(new File(configFileReader.getReportConfigPath()));
	    BrowserFactory.closeBrowser();
	}
}

