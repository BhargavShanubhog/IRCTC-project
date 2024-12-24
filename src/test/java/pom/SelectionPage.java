package pom;

import java.time.Duration;


import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class SelectionPage {
	private WebDriver driver;
	
	public SelectionPage(WebDriver driver) {
		driver=new ChromeDriver();
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="stationFrom") WebElement fromtab;
	@FindBy(id="stationTo") WebElement desttab;
	@FindBy(xpath="//input[@id='originDate']") WebElement departureDateField;
	
	@FindBy(xpath="//div[@class='form-in-custom3']//button[@class='btn btn-md yellow-gradient home-btn']") WebElement search;
	@FindBy(xpath="//input[@id='defenceForce']") WebElement defence;
	@FindBy(xpath="//input[@id='seniorCitizen']") WebElement citizen;
	@FindBy(xpath="//input[@id='student']")WebElement student;
	
	@FindBy(xpath="//div[@class='dropdown-menu dropdown-primary room_guest-wrap_btm show']//div[2]//div[1]//a[2]//i[1]") WebElement Cplus;
	@FindBy(xpath="//select[@id='travelClass']") WebElement tc;
	@FindBy(xpath="//div[@class='choose-class-in']//select[@class='form-control ng-valid ng-touched ng-dirty']") WebElement cc;
	@FindBy(xpath="//button[normalize-space()='Modify']") WebElement modify;
	@FindBy(xpath="//div[@class='room_guest-wrap-in']//span[contains(text(),'Infant')]//div[@class='ext-center mt-1 years-wrap']//a//span//a//i[@class='fas fa-plus']\"") WebElement Iplus;
	@FindBy(xpath="//div[@id='TravellerEconomydropdown']//div//div[@class='room_guest-wrap-in']//div//a//i[@class='fas fa-plus']") WebElement Aplus;
	@FindBy(xpath="//div[@id='Traveller-Economy']//input[@id='noOfpaxEtc']")WebElement economy;
	@FindBy(xpath="//div[@class='text-center mt-1 years-wrap']//span[contains(text(),'1')]")WebElement acount;
	@FindBy(xpath="//div[@class='text-center mt-1 years-wrap']//span[contains(text(),'0')]") WebElement ccount;
	@FindBy(xpath="//div[@class='room_guest-wrap']//div[1]//div[1]//a[1]//i[@class='fas fa-minus']") WebElement Aminus;
	@FindBy(xpath="//div[@class='room_guest-wrap']//span[contains(text(),'Child')]//div[1]//div[1]//a[1]//i[@class='fas fa-minus']") WebElement Cminus;
	@FindBy(xpath="//div[@class='room_guest-wrap']//span[contains(text(),'Infant')]//div[1]//div[1]//a[1]//i[@class=']fas fa-minus']") WebElement Iminus;
	@FindBy(xpath="//div[@class='room_guest-wrap']//div[1]//div[1]//span[1]") WebElement Icount;
	
	
	@FindBy(xpath="//div[normalize-space()='Airlines']") WebElement airlines;
	@FindBy(xpath="//div[@class='active slick-slide slick-current slick-active']//a//span") WebElement datecon;
	@FindBy(xpath="//p[normalize-space()='No flight available for this route.']") WebElement noflight;
	
	
	@FindBy(xpath="//div[@class='heading-filter']")WebElement pp;
	public void launch(String url) {
		driver.get(url);
	}
	
	
	
	public void selectPlace(String from , String to) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(fromtab)).click();
		
		Actions d=new Actions(driver);
		if(from.equals("")) {
			Alert alert=driver.switchTo().alert();
			alert.accept();
		}
		else {
			d.sendKeys(from).pause(Duration.ofSeconds(1)).sendKeys(Keys.DOWN).pause(Duration.ofMillis(500)).sendKeys(Keys.ENTER).perform();
		}
	
		
		wait.until(ExpectedConditions.elementToBeClickable(desttab)).click();
		if(to.equals("")) {
			Alert alert=driver.switchTo().alert();
			alert.accept();
		}
		else {
			d.sendKeys(to).pause(Duration.ofSeconds(1)).sendKeys(Keys.DOWN).pause(Duration.ofMillis(500)).sendKeys(Keys.ENTER).perform();
		}
		
		
	}
	
	
	public void selectDateMonth(String Date, String Month) {
		 WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='datepicker datepicker-dropdown datepicker-left datepicker-bottom rdeparturedate no-border']")));
		 departureDateField.click();
		 
		 List<WebElement> month=driver.findElements(By.xpath("//div[@class='date-table-right']//table//tr//td//span"));
	     for(WebElement r:month) {
	    	 if(r.getText().equalsIgnoreCase(Month)) {
	    		 r.click();
	    		 break;
	    	 }
	     }
	     
	     List<WebElement>yy=driver.findElements(By.xpath("//td[@class='date']//span[@class='act']"));
	     for(WebElement toi:yy) {
	    	 if(toi.getText().equals(Date)) {
	    		 JavascriptExecutor js=(JavascriptExecutor)driver;
	    		 js.executeScript("arguments[0].click();",toi);
	    		 
	    	 }
	     }
	     
	    
	     
		 
	}
	
	
	public void Search() {
		 search.click();
		 
		
	}
	
	
	public boolean checkSelectionPage() {
		boolean a=true;
		if(pp.isDisplayed()) {
			return a;
			
		}
		else {
			a=false;
			return a;
		}
	}
	
	
	 public boolean dateCheck(String Date, String Month) {
		 boolean a=true;
		 if(datecon.equals(Date+Month)) {
			 return a;
		 }
		 else {
			 a=false;
			 return a;
		 }
		 
	 }
	 
	 
	 public void TravellerOption() {
		 JavascriptExecutor js2=(JavascriptExecutor)driver;
		 js2.executeScript("arguments[0].click();",economy);
		 
	 }
	 
	 
	 public void modeSetting(String mode) {
		 
		 
		 JavascriptExecutor js3=(JavascriptExecutor)driver;
		 js3.executeScript("arguments[0].click();",tc);
		 
		 switch(mode) {
		 case "Economy": Select dd=new Select(tc);
		 dd.selectByValue(mode);
		 break;
		 
		 case "Business":Select de=new Select(tc);
		 de.selectByValue(mode);
		 break;
		 
		 case "Premium Economy":Select df=new Select(tc);
		 df.selectByValue(mode);
		 break;
		 }
	 }
	 
	 public void maxAdult() {
		 
		 int AdultCount=Integer.parseInt(acount.getText());
		 while(true) {
			 if(AdultCount==9) {
				 break;
			 }
			 JavascriptExecutor js3=(JavascriptExecutor)driver;
			 js3.executeScript("arguments[0].click();",Aplus);
			 
		 }
		 
		 
		 
	 }
	 
	 public void maxChild() {
		 
		 int ChildCount=Integer.parseInt(ccount.getText());
		 while(true) {
			 if(ChildCount==8) {
				 break;
			 }
			 JavascriptExecutor js3=(JavascriptExecutor)driver;
			 js3.executeScript("arguments[0].click();",Cplus);
			 
		 }
		 
		 
		 
	 }
	 
	 
	 public void maxInfant() {
		 
		 int InfantCount=Integer.parseInt(Icount.getText());
		 int AdultCount=Integer.parseInt(acount.getText());
		 while(true) {
			 if(AdultCount==9) {
				 break;
			 }
			 JavascriptExecutor js3=(JavascriptExecutor)driver;
			 js3.executeScript("arguments[0].click();",Aplus);
			 
		 }
		 while(true) {
			 if(InfantCount<=9) {
				 break;
			 }
			 JavascriptExecutor js3=(JavascriptExecutor)driver;
			 js3.executeScript("arguments[0].click();",Iplus);
			 
		 }
		 
		 
		 
	 }
	 
	 public boolean ChildafterAdult() {
		 
		 boolean r=true;
		 int AdultCount=Integer.parseInt(acount.getText());
		 
		 
		 while(true) {
			 if(AdultCount==9) {
				 JavascriptExecutor jsy=(JavascriptExecutor)driver;
				 jsy.executeScript("arguments[0].click();",Cplus);
				 if(ccount.getText().equals("0")) {
					 break;
				 }
				 else {
					 r=false;
				 }
				 
				 
			 }
			 JavascriptExecutor js4=(JavascriptExecutor)driver;
			 js4.executeScript("arguments[0].click();",Aplus);
			 
		 }
		 return r;
	 }
	 
	 
	 public boolean AdultafterChild() {
		 
		 boolean r=true;
		 int ChildCount=Integer.parseInt(ccount.getText());
		 
		 while(true) {
			 if(ChildCount==8) {
				 JavascriptExecutor jsy=(JavascriptExecutor)driver;
				 jsy.executeScript("arguments[0].click();",Aplus);
				 if(acount.getText().equals("1")) {
					 break;
				 }
				 else {
					 r=false;
				 }
				 
			 }
			 JavascriptExecutor js3=(JavascriptExecutor)driver;
			 js3.executeScript("arguments[0].click();",Cplus);
			 
		 }
		 return r;
	 }
	 
	 
	 
	 public boolean AdultZero() {
		 
		 boolean r=true;
		 JavascriptExecutor js3=(JavascriptExecutor)driver;
		 js3.executeScript("arguments[0].click();",Aminus);
		 int AdultCount=Integer.parseInt(acount.getText());
		 if(AdultCount!=0) {
			 return r;
		 }
		 else {
			 r=false;
			 return r;
		 }
		 
	 }
	 
	 public boolean InfantMore() {
		 
		 boolean r=true;
		 int AdultCount=Integer.parseInt(acount.getText());
		 while(true) {
			 if(AdultCount==3) {
				 JavascriptExecutor jsp=(JavascriptExecutor)driver;
				 jsp.executeScript("arguments[0].click();",Iplus);
				 int InfantCount=Integer.parseInt(Icount.getText());
				 if(InfantCount==AdultCount) {
					 break;
				 }else {
					 r=false;
					 
				 }
				 
				
			 }
			 JavascriptExecutor js3=(JavascriptExecutor)driver;
			 js3.executeScript("arguments[0].click();",Aplus);
			 
			 JavascriptExecutor jsp=(JavascriptExecutor)driver;
			 jsp.executeScript("arguments[0].click();",Iplus);
			 
			 
		 }
		 return r;
		 
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 public boolean dai(String j) {
		 
		 boolean r=true;
		 
		 while(true) {
			 int a=Integer.parseInt(j);
			 int b=Integer.parseInt(acount.getText());
			 int c=Integer.parseInt(Icount.getText());
			 if(b==a && c==a) {
				 JavascriptExecutor js3=(JavascriptExecutor)driver;
				 js3.executeScript("arguments[0].click();",Aminus);
				 if(b==c) {
					 break;
				 }else {
					 r=false;
					 
				 }
				 
			 }
			 
			 JavascriptExecutor js3=(JavascriptExecutor)driver;
			 js3.executeScript("arguments[0].click();",Aplus);
			 
			 JavascriptExecutor jsp=(JavascriptExecutor)driver;
			 jsp.executeScript("arguments[0].click();",Iplus);
			 
			 
		 }
		 
		 return r;
		 
	 }
	 
	 public boolean dia(String j) {
		 
		 boolean r=true;
		 
		 while(true) {
			 int a=Integer.parseInt(j);
			 int b=Integer.parseInt(acount.getText());
			 int c=Integer.parseInt(Icount.getText());
			 if(b==a && c==a) {
				 JavascriptExecutor js3=(JavascriptExecutor)driver;
				 js3.executeScript("arguments[0].click();",Iminus);
				 if(b!=c) {
					 break;
				 }else {
					 r=false;
					 
				 }
				 
			 }
			 
			 JavascriptExecutor js3=(JavascriptExecutor)driver;
			 js3.executeScript("arguments[0].click();",Aplus);
			 
			 JavascriptExecutor jsp=(JavascriptExecutor)driver;
			 jsp.executeScript("arguments[0].click();",Iplus);
			 
			 
		 }
		 
		 return r;
		 
	 }
	 
	 public boolean mali(String j, String k) {
		 
		 boolean r=true;
		 
		 while(true) {
			 int a=Integer.parseInt(j);
			 int d=Integer.parseInt(k);
			 int b=Integer.parseInt(acount.getText());
			 int c=Integer.parseInt(Icount.getText());
			 if(b==a && c==d) {
				 JavascriptExecutor js3=(JavascriptExecutor)driver;
				 js3.executeScript("arguments[0].click();",Aminus);
				 if(c==d) {
					 break;
				 }else {
					 r=false;
					 
				 }
				 
			 }
			 
			 JavascriptExecutor js3=(JavascriptExecutor)driver;
			 js3.executeScript("arguments[0].click();",Aplus);
			 
			 JavascriptExecutor jsp=(JavascriptExecutor)driver;
			 jsp.executeScript("arguments[0].click();",Iplus);
			 
			 
		 }
		 
		 return r;
		 
	 }
	 
	 
	 public String FlightCompany(String k) {
		 
		 String m="";
		 JavascriptExecutor jsp=(JavascriptExecutor)driver;
		 jsp.executeScript("arguments[0].click();",cc);
		 
		 Select db=new Select(cc);
		 db.selectByValue(k);
		 
		 JavascriptExecutor jsl=(JavascriptExecutor)driver;
		 jsl.executeScript("arguments[0].click();",modify);
		 
		 if(airlines.isDisplayed()) {
			  m="k is present";
		 }
		 else {
			  m=noflight.getText();
		 }
		 
		 return m;
		 
		 
		 
		 
		 
	 }
	 
	 public void Defence() {
			defence.click();
		}
	 
	 
	 public void SeniorCitizen() {
		 citizen.click();
		}
	 
	 public void Student() {
		 student.click();
	 }
	 
	 
	 
	 
	 
	 
	
		
	
	
	
	
		
	
	  
	  
	  
	 
	  
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		}
		
		
	


		
		
	


