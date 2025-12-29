package com.ibm.testing;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Authentication extends Setup{
  @Test (groups = {"authentication"})
  public void validLogin() throws InterruptedException {
	  driver.findElement(By.linkText("Login")).click();
	  WebElement loginform = driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div"));
	  if(loginform.isDisplayed()) {
			driver.findElement(By.id("email")).sendKeys("arunavabanerjee2018@gmail.com");
			driver.findElement(By.id("password")).sendKeys("123456");
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div/div[2]/form/button")).click();
		}
		Thread.sleep(4000);
		String expectedTitle = "Dashboard";
		String actualTitle = driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div/h1")).getText();
		assertEquals(actualTitle, expectedTitle);
  }
  
  @Test (groups = {"authentication"})
  public void validEmailInvalidPasswordFormat() throws InterruptedException {
	  driver.findElement(By.linkText("Login")).click();
	  WebElement loginform = driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div"));
	  if(loginform.isDisplayed()) {
			driver.findElement(By.id("email")).sendKeys("arunavabanerjee2018@gmail.com");
			driver.findElement(By.id("password")).sendKeys("1236");
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div/div[2]/form/button")).click();
		}
		Thread.sleep(4000);
		String expectedErrorMessage = "Password must be at least 6 characters";
		String actualErrorMessage = driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div/div[2]/form/div[2]/p")).getText();
		assertEquals(expectedErrorMessage, actualErrorMessage);
  }
  
  @Test (groups = {"authentication"})
  public void validEmailInvalidPassword() throws InterruptedException {
	  driver.findElement(By.linkText("Login")).click();
	  WebElement loginform = driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div"));
	  if(loginform.isDisplayed()) {
			driver.findElement(By.id("email")).sendKeys("arunavabanerjee2018@gmail.com");
			driver.findElement(By.id("password")).sendKeys("123@36");
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div/div[2]/form/button")).click();
		}
		Thread.sleep(4000);
		String expectedErrorMessage = "Invalid credentials";
		String actualErrorMessage = driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div/div[2]/form/p[1]")).getText();
		assertEquals(expectedErrorMessage, actualErrorMessage);
  }
  
}
