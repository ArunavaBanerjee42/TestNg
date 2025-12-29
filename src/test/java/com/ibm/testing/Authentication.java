package com.ibm.testing;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Authentication extends Setup{
  @Test (groups = {"authentication"})
  public void validLogin() throws InterruptedException {
	    LoginHelper.login(driver, "arunavabanerjee2018@gmail.com", "123456");
		String expectedTitle = "Dashboard";
		String actualTitle = driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div/h1")).getText();
		assertEquals(actualTitle, expectedTitle);
  }
  
  @Test (groups = {"authentication"})
  public void validEmailInvalidPasswordFormat() throws InterruptedException {
	  	LoginHelper.login(driver, "arunavabanerjee2018@gmail.com", "1236");
		String expectedErrorMessage = "Password must be at least 6 characters";
		String actualErrorMessage = driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div/div[2]/form/div[2]/p")).getText();
		assertEquals(expectedErrorMessage, actualErrorMessage);
  }
  
  @Test (groups = {"authentication"})
  public void validEmailInvalidPassword() throws InterruptedException {
	  	LoginHelper.login(driver, "arunavabanerjee2018@gmail.com", "12@@36");
		String expectedErrorMessage = "Invalid credentials";
		String actualErrorMessage = driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div/div[2]/form/p[1]")).getText();
		assertEquals(expectedErrorMessage, actualErrorMessage);
  }
  
}
