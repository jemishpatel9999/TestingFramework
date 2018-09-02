package selenium;

import org.testng.annotations.Test;


import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest {
public WebDriver driver;
LoginPage lp = new LoginPage();
DataFile df = new DataFile();
  
@BeforeMethod
public void beforeMethod() throws IOException{
lp.openBrowser(df.browserName());
lp.openGmail();
}

@AfterMethod
public void afterMethod() {
lp.closeBrowser();
}
  
@Test
public void testLoginWtihWrongPassword() throws InterruptedException {
lp.enterEmail(df.validEmail);
lp.enterPassword(df.wrongPassword);
Assert.assertEquals(df.passwordError, lp.readPasswordError());
}

@Test
public void testLoginWithIncorrectEmail() throws InterruptedException {
lp.enterEmail(df.invalidEmail);
Assert.assertEquals(df.emailError, lp.readEmailError());
}
  
}
