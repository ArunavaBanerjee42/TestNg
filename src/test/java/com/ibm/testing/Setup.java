package com.ibm.testing;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Setup {
  WebDriver driver;
  
  @BeforeMethod
  public void setUp() {
	  driver = new EdgeDriver();
	  driver.get("https://prep-mate-full-stack.vercel.app/");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }
  
  @AfterMethod
  public void tearDown() throws InterruptedException {
	  Thread.sleep(4000);
	  driver.quit();
  }
}
