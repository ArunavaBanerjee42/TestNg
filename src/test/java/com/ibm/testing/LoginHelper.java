package com.ibm.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginHelper {

    public static void login(WebDriver driver, String email, String password) throws InterruptedException {
        driver.findElement(By.linkText("Login")).click();
        WebElement loginform = driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div"));
		if(loginform.isDisplayed()) {
			driver.findElement(By.id("email")).sendKeys(email);
			driver.findElement(By.id("password")).sendKeys(password);
			driver.findElement(By.xpath("//*[@id=\"root\"]/div/main/div/div/div[2]/form/button")).click();
		}
		Thread.sleep(4000);
      
    }
}
