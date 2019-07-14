package steps;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.Scenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.webdriverfactory.com.SeleniumHelper;

public class Background extends SeleniumHelper {
	
	public String AppName=null;
	public int i=0;
	public Scenario sc;
	
	@Given("I login to KiSSFLow with the username {string} and password {string}")
	public void Login(String username, String password) throws InterruptedException {
		/*startResult();
		testCaseName = "KissFlow";
		testCaseDescription ="app creation";
		category = "Smoke";
		author= "Aswin";
		startTestCase();
		startApp("chrome", "https://kissflow.com");*/
	    click(locateElement("xpath", "//a[@href='https://app.kissflow.com']"));
	    takeSnap();
		type(locateElement("id", "emailId"), username);
		type(locateElement("id", "passwd"), password);
		click(locateElement("id", "submitButton"));
		Thread.sleep(3000);
		takeSnap();
	    
	}
	
	@And("I create an App {string}")
	public void CreateApp(String string) throws InterruptedException {
	    click(locateElement("xpath", "(//li[@kf-roles='AppFullAccess'])[1]/child::a"));
	    takeSnap();
	    WaitForElementTodisplay(locateElement("xpath", "//div[@class='appImageContainer']/p"));
	    List<WebElement> app = driver.findElements(By.xpath("//div[@class='appHeading']/span"));
	    
	    for(int i=13;i<app.size();i++)
	    {
	    	if(app.get(i).getText().equals("TestApp"))
	    	{
	    		AppName="TestApp"+i;
	    	}
	    }
	    takeSnap();
	    click(locateElement("xpath", "//div[@class='appImageContainer']/p"));
	    switchToFrame("wizard");
	    type(locateElement("xpath", "//input[@id='sectionheading']"), AppName);
	    type(locateElement("xpath", "//textarea[@id='shortDesc']"), "Hi this is Aswin. This application is part of a test");
	    takeSnap();
	    click(locateElement("xpath", "//a[contains(@ng-click,'updateProcess')]"));
	    
	}
	
	@And("I create a Field of type {string} with Name {string} on {string}")
	public void FieldState(String string, String State, String TestApp) throws InterruptedException {
	
		i++;
		if(i==1)
		{
		WaitForElementTodisplay(locateElement("xpath", "//div[@title='Text']"));
		click(locateElement("xpath", "//div[@title='Text']"));
		Thread.sleep(2000);
		click(locateElement("xpath", "(//div[contains(@ng-if,'field.getValue')]/child::div)["+i+"]"));		
		Thread.sleep(2000);
		type(locateElement("id", "field_name"), State);
		Thread.sleep(2000);
		click(locateElement("xpath", "//i[@class='fa fa-save']"));
		takeSnap();
		}
		else {
			click(locateElement("xpath", "//div[@title='Text']"));
			Thread.sleep(2000);
			click(locateElement("xpath", "(//div[contains(@ng-if,'field.getValue')]/child::div)["+i+"]"));		
			Thread.sleep(2000);
			type(locateElement("id", "field_name"), State);
			Thread.sleep(2000);
			click(locateElement("xpath", "//i[@class='fa fa-save']"));
			takeSnap();
			
		}
	}
	
	
}
