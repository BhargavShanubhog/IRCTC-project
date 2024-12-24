package stepDefinition;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import Utility.ReadConfig;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import pom.SelectionPage;

public class StepDef1  extends BaseClass{

@BeforeStep(order=0)
@Given("User launch chrome browser")
public void user_launch_chrome_browser() throws IOException {
	log=LogManager.getLogger("StepDef1");
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
		
	}else {
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
		break;
		
		
		
	}
	}
	log.info("Driver has selected");
	r=new SelectionPage(driver);
    
}
@BeforeStep(order=1)
@When("User opens URL")
public void user_opens_url() {
	String browser=po.getBrowser();
	r.launch(browser);
	log.info("url has selected");
    
}
@BeforeStep(order=2)
@When("User enters origin  and destination")
public void user_enters_origin_and_destination() {
	po=new ReadConfig();
	String string=po.getOrigin();
	String string2=po.getDestination();
	r.selectPlace(string, string2);
	log.info("origin, destination has been selected");
    
}
@BeforeStep(order=3)
@When("User enters departure date")
public void user_enters_departure_date() {
	po=new ReadConfig();
	String string=po.getDate();
	String string2=po.getMonth();
	r.selectDateMonth(string, string2);
	log.info("date and month has selected");
    
    
}
@BeforeStep(order=4)
@Then("User clicks Search button")
public void user_clicks_search_button() {
	r.Search();
    boolean h=r.checkSelectionPage();
    if(h==true) {
    	Assert.assertTrue(true);
    	log.info("New page has been verified");
    }else {
    	Assert.assertFalse(false);
    	log.info("New page has not been verified");
    }
    
}
@BeforeStep(order=5)
@Then("Select Economy mode")
public void select_economy_mode() {
	po=new ReadConfig();
	String mode=po.getmode1();
	r.modeSetting(mode);
	log.info("Economy mode has been selected");
    
}

@Then("compare both the dates")
public void compare_both_the_dates() {
	po=new ReadConfig();
	String Date=po.getDate();
	String Month=po.getMonth();
	boolean Y=r.dateCheck(Date, Month);
	 if(Y==true) {
	    	Assert.assertTrue(true);
	    	log.info("Both dates are verified");
	    }else {
	    	Assert.assertFalse(false);
	    	log.info("Both dates are not verified");
	    }
	
    
}

@When("select travellers option")
public void select_travellers_option() {
   r.TravellerOption();
}

@When("Verify maximum no of adult travllers")
public void verify_maximum_no_of_adult_travllers() {
	r.maxAdult();
    log.info("Maximum adult can be added upto 9");
   
}

@When("Verify maximum no of child travllers")
public void verify_maximum_no_of_child_travllers() {
	 r.maxChild();
	 log.info("Maximum child can be added upto 8");
    
}

@When("Verify maximum no of infants travllers")
public void verify_maximum_no_of_infants_travllers() {
	r.maxInfant();
	log.info("Maximum infants can be added upto maximum adults");
    
}

@When("keep pressing + button beside child option")
public void keep_pressing_button_beside_child_option() {
	boolean j=r.ChildafterAdult();
    if(j==true) {
    	Assert.assertTrue(true);
    	log.info("It is true that child can not be added when adult count is 9");
    }else {
    	Assert.assertFalse(false);
    	log.info("It is false that child can not be added when adult count is 9");
    }
    
}

@When("keep pressing + button beside adult option")
public void keep_pressing_button_beside_adult_option() {
	boolean j=r.AdultafterChild();
    if(j==true) {
    	Assert.assertTrue(true);
    	log.info("It is true that adult can not be added when child count is 8");
    }else {
    	Assert.assertFalse(false);
    	log.info("It is false that adult can not be added when child count is 8");
    }
    
}

@When("keep pressing - button beside adult option")
public void keep_pressing_button_beside_adult_option1() {
	boolean j=r.AdultZero();
    if(j==true) {
    	Assert.assertTrue(true);
    	log.info("It is true that adult count can not be zero");
    }else {
    	Assert.assertFalse(false);
    	log.info("It is false that adult count can not be zero");
    }
    
}

@When("keep pressing + button beside infant option")
public void keep_pressing_button_beside_infant_option() {
	boolean j=r.InfantMore();
    if(j==true) {
    	Assert.assertTrue(true);
    	log.info("It is true that infant can not be added more than adults");
    }else {
    	Assert.assertFalse(false);
    	log.info("It is false that infant can not be added more than adults");
    }
    
}

@When("check by reducing adult count")
public void check_by_reducing_adult_count() {
	po=new ReadConfig();
	String f=po.getJ();
	boolean j=r.dai(f);
    if(j==true) {
    	Assert.assertTrue(true);
    	log.info("It is true that infants count can  be reduced when both adult and infants counts are same");
    }else {
    	Assert.assertFalse(false);
    	log.info("It is true that infants count can not be reduced when both adult and infants counts are same");
    }
    
}

@When("observe infant count")
public void observe_infant_count() {
	po=new ReadConfig();
	String f=po.getJ();
	boolean j=r.dia(f);
    if(j==true) {
    	Assert.assertTrue(true);
    	log.info("It is true that adults count can not be reduced when both adult and infants counts are same");
    }else {
    	Assert.assertFalse(false);
    	log.info("It is false that adults count can not be reduced when both adult and infants counts are same");
    }
    
}

@When("keep pressing - button beside infant option")
public void keep_pressing_button_beside_infant_option1() {
	po=new ReadConfig();
	String f=po.getJ();
	String l=po.K();
	boolean j=r.mali(f,l);
    if(j==true) {
    	Assert.assertTrue(true);
    	log.info("It is True that Infants can not be reduced when adults are more than infants");
    }else {
    	Assert.assertFalse(false);
    	log.info("It is False that Infants can not be reduced when adults are more than infants");
    }
    
}

@When("select  any {string}  company")
public void select_any_company(String flight) {
	String h=r.FlightCompany(flight);
	log.info(h);
    
}

@When("Click on Defence Radio button")
public void click_on_defence_radio_button() {
	r.Defence();
	log.info("Defence mode is on");
    
}

@When("Click on Senior Citizen radio button")
public void click_on_senior_citizen_radio_button() {
	r.SeniorCitizen();
	log.info("Senior Citizen mode is on");
    
}

@When("Click on Student radio button")
public void click_on_student_radio_button() {
	r.Student();
	log.info("Student mode is on");
}

@Then("Select Business mode")
public void select_business_mode() {
	po=new ReadConfig();
	String mode=po.getmode2();
	r.modeSetting(mode);
	log.info("Business mode has been selected");
}

@Then("Select Premium Economy mode")
public void select_premium_economy_mode() {
	po=new ReadConfig();
	String mode=po.getmode3();
	r.modeSetting(mode);
	log.info("Premium Economy mode has been selected");
}

@AfterStep(order=0)
public void closeBrowser() {
	CloseStep j=new CloseStep();
	j.close_browser();
}

@AfterStep(order=1)
public void addScreenshot(Scenario scenario) {
	if(scenario.isFailed()) {
		final byte[]screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", scenario.getName());
	}
	
	
}
}

