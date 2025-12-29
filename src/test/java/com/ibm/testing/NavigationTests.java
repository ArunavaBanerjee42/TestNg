package com.ibm.testing;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NavigationTests extends Setup {
	
  @BeforeMethod
  public void loginHelper() throws InterruptedException {
	  String email = "arunavabanerjee2018@gmail.com";
	  String password = "123456";
	  LoginHelper.login(driver, email , password);
  }
  @Test (groups = {"navigations"}, priority = 1)
  public void openAdminPanel() throws InterruptedException {
	  	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    wait.until(ExpectedConditions.invisibilityOfElementLocated(
	        By.xpath("//div[contains(@class,'fixed') and contains(@class,'inset-0')]")
	    ));

	    WebElement adminLink = wait.until(
	        ExpectedConditions.elementToBeClickable(
	            By.xpath("//a[@href='/admin']")
	        )
	    );

	    js.executeScript("arguments[0].scrollIntoView({block:'center'});", adminLink);

	    try {
	        adminLink.click();
	    } catch (Exception e) {
	        js.executeScript("arguments[0].click();", adminLink);
	    }

	    String expectedUrl = "https://prep-mate-full-stack.vercel.app/admin";
	    wait.until(ExpectedConditions.urlToBe(expectedUrl));
	    String actualUrl = driver.getCurrentUrl();
	    Thread.sleep(4000);
	    assertEquals(actualUrl, expectedUrl);
  }
  
  @Test (groups = {"navigations"} , priority = 5)
  public void aboutUs() throws InterruptedException {
	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    WebElement aboutUsLink = wait.until(
	        ExpectedConditions.elementToBeClickable(
	            By.cssSelector("a[href='/about-us']")
	        )
	    );

	    js.executeScript("arguments[0].scrollIntoView({block:'center'});", aboutUsLink);
        Thread.sleep(10000);
	    try {
	        aboutUsLink.click();
	    } catch (Exception e) {
	        js.executeScript("arguments[0].click();", aboutUsLink);
	    }

	    String expectedUrl = "https://prep-mate-full-stack.vercel.app/about-us";
	    wait.until(ExpectedConditions.urlToBe(expectedUrl));

	    String actualUrl = driver.getCurrentUrl();
	    assertEquals(actualUrl, expectedUrl);
  }
  
  @Test (groups = {"navigations"}, priority = 2)
  public void openSubjectCard() {
	  driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div/div[2]/div[1]")).click();
	  String expectedTitle = "Operating Systems";
	  String actualTitle = driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div/div[1]/h1")).getText();
	  assertEquals(actualTitle, expectedTitle);
  }
  @Test (groups = {"navigations"}, priority = 3)
 
  public void addSubtopics() {

	    driver.get("https://prep-mate-full-stack.vercel.app/admin");

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    wait.until(ExpectedConditions.invisibilityOfElementLocated(
	        By.xpath("//div[contains(@class,'fixed') and contains(@class,'inset-0')]")
	    ));

	    WebElement addSubtopic = wait.until(
	        ExpectedConditions.elementToBeClickable(
	            By.xpath("//div[contains(text(),'Add Subtopic')]")
	        )
	    );

	    try {
	        addSubtopic.click();
	    } catch (ElementClickInterceptedException e) {
	        js.executeScript("arguments[0].click();", addSubtopic);
	    }


	    WebElement selectElement = wait.until(
	        ExpectedConditions.elementToBeClickable(By.tagName("select"))
	    );

	    Select select = new Select(selectElement);
	    select.selectByVisibleText("Operating Systems");

	    driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div/div[2]/form/div[2]/input")).sendKeys("test subtopic");
	    driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div/div[2]/form/button")).click();

	    WebElement alert = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//*[contains(text(),'Success')]")
	        )
	    );

	    assertEquals(alert.getText(), "✅ Success");
	}
  
  	@Test (groups = {"navigations"}, priority = 4)
    public void addSubject() {
    	driver.get("https://prep-mate-full-stack.vercel.app/admin");
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(
		        By.xpath("//div[contains(@class,'fixed') and contains(@class,'inset-0')]")
		    ));

		 WebElement addSubject = wait.until(
		       ExpectedConditions.elementToBeClickable(
		            By.xpath("//div[contains(text(),'Add Subject')]")
		       )
		 );
		 try {
		        addSubject.click();
		    } catch (ElementClickInterceptedException e) {
		        js.executeScript("arguments[0].click();", addSubject);
		    }

		 driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div/div[2]/form/div[1]/input")).sendKeys("Test Subject");
		 driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div/div[2]/form/div[2]/textarea")).sendKeys("Test description");
		 WebElement selectElement = driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div/div[2]/form/div[3]/div/select"));
		 Select select = new Select(selectElement);
		 select.selectByVisibleText("Operating Systems (Server)");
		 driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div/div[2]/form/button")).click();
		 WebElement alert = wait.until(
			        ExpectedConditions.visibilityOfElementLocated(
			            By.xpath("//*[contains(text(),'Success')]")
			        )
			    );
		 assertEquals(alert.getText(), "✅ Success");
		 
    	
    }

  
  
  
  
}
