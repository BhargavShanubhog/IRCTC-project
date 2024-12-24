package stepDefinition;

import java.io.IOException;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import Utility.ReadConfig;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.HomePage;

public class StepDef extends BaseClass{
	@Before()
	@Given("Open url \"https:\\/\\/www.air.irctc.co.in\\/\"in any driver")
	public void open_url_https_www_air_irctc_co_in_in_any_driver() throws IOException {
		log=LogManager.getLogger("StepDef");
        po=new ReadConfig();
       
        
		
		String browser=po.getBrowser();
		if(po.GetProperty().equalsIgnoreCase("remote")) {
			DesiredCapabilities capabilities=new DesiredCapabilities ();
			//os
			if(po.GetOS().equalsIgnoreCase("windows")) {
				capabilities.setPlatform(Platform.WIN11);
			}else if(po.GetOS().equalsIgnoreCase("mac")) {
				capabilities.setPlatform(Platform.MAC);
				
			}else {
				System.out.println("No matching os");
				return;
			}
			
			//browser
			switch(browser.toLowerCase()) {
			case "chrome": capabilities.setBrowserName("chrome"); break;
			case "edge": capabilities.setBrowserName("MicrosoftEdge"); break;
			
			default:System.out.println("No matching browser"); return;
			
			}
			driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
			
		}
		else {
		switch(browser) {
		case "chrome":
			
			
			driver=new ChromeDriver();
			break;
			
		case "msedge":
			
			driver=new EdgeDriver();
			break;
			
		case "firefox":
			
			driver=new FirefoxDriver();
			break;
			
		default:
			driver=null;
			return;
			
	    
	}
		}
        log.info("Driver has setup");
		
		p=new HomePage(driver);
		String url=po.getURL();
		p.launch(url);
	    
	}
	
	@Given("Type origin and Destination place")
	public void type_origin_and_destination_place() {
		String origin=po.getOrigin();
	    String Destination=po.getDestination();
	    p.selectPlace(origin, Destination);
	   
	}

	@Given("Select a particular month and date")
	public void select_a_particular_month_and_date() {
		String date=po.getDate();
		String month=po.getMonth();
		p.selectDateMonth(date, month);
	    
	}

	@Then("Click on Search button")
	public void click_on_search_button() {
		p.Search();
	    
	}
	
	@When("Select any one radio button")
	public void select_any_one_radio_button() {
	    p.anyOne();
	}
	
	@When("Select any two radio buttons")
	public void select_any_two_radio_buttons() {
	    p.anyTwo();
	}
	
	@When("Select all three radio buttons")
	public void select_all_three_radio_buttons() {
	    p.allThree();
	}
	
	@Given("Type {string} and {string} place")
	public void type_and_place(String string, String string2) {
	    p.selectPlace(string, string2);
	}

	@Given("Select a particular {string} and {string}")
	public void select_a_particular_and(String string, String string2) {
	    p.selectDateMonth(string, string2);
	}
	@After()
	public void closeBrowser() {
		CloseStep j=new CloseStep();
		j.close_browser();
	}
	
	@AfterStep()
	public void addScreenshot(Scenario scenario) {
		if(scenario.isFailed()) {
			final byte[]screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
		
		
	}




	
	
			
			
			
		
		
		
	    
    


	
	
			
			
			
		



	







	
	
	
	
	
	


}
