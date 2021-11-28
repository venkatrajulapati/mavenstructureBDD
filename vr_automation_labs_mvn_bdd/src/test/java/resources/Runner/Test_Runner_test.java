package resources.Runner;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= "./src/test/java/resources/Features",
		glue= {"stepDefinitions"},
		dryRun=false,
		monochrome=true,
		plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
		format= {"pretty","html:test_output","json:target/cucumber.json"}
		)
public class Test_Runner_test {
	@AfterClass
    public static void writeExtentReport() throws IOException {
		InetAddress addr;
	    addr = InetAddress.getLocalHost();
	    String hostname = addr.getHostName();
		Reporter.setSystemInfo("Host Name", hostname);
		Reporter.setSystemInfo("User Name",System.getProperty("user.name"));
		Reporter.setSystemInfo("Platform",System.getProperty("os.name"));
        Reporter.loadXMLConfig(new File("./config/report.xml"));
        
    
    }
}
