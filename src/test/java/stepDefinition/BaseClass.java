package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.*;
import Utility.ReadConfig;
import pom.HomePage;
import pom.SelectionPage;

public class BaseClass {
	public static WebDriver driver;
	public ReadConfig po;
	public HomePage p;
	public SelectionPage r;
	public static Logger log;
	
	

}
