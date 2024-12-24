package pom;

import java.time.Duration;
import java.util.List;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
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
	
	public void launch(String url) {
		if(url!=null) {
			driver.get(url);
		}
		
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
	
	public void anyOne() {
		defence.click();
	}
	
	public void anyTwo() {
		defence.click();
		citizen.click();
	}
	
	public void allThree() {
		defence.click();
		citizen.click();
		student.click();
		
	}
	
	
	
	
	
	
	
	
	

}
