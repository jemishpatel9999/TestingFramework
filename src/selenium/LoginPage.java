package selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
public WebDriver driver;

/*
	public WebElement email = driver.findElement(By.id("identifierId"));
	public WebElement emailNext = driver.findElement(By.xpath(".//*[@id='identifierNext']/content/span"));
*/
@FindBy(id = "identifierId")
public static WebElement email;//page factory
	
@FindBy(xpath = "//input[@name='password']")
public static WebElement password;
	
@FindBy(xpath = ".//*[@id='identifierNext']/content/span")
public static WebElement emailNext;
	
@FindBy(xpath = ".//*[@id='passwordNext']/content/span")
public static WebElement passwordNext;
	
@FindBy(xpath = ".//*[@id='view_container']/div/div/div[2]/div/div[1]/div/form/content/div[1]/div/div[2]/div[2]")
public static WebElement readPassword;
	
@FindBy(xpath = "//div[@class='dEOOab RxsGPe']")
public static WebElement readEmailError;
	
public void openBrowser(String browser) throws IOException{
//driver = new FirefoxDriver();
/*FileInputStream fs = new FileInputStream("C:\\Testing\\prop.properties");
Properties prop = new Properties();
prop.load(fs);
String browser = prop.getProperty("browser");*/
		
if(browser.equals("Firefox")) {
driver = new FirefoxDriver();
}else if(browser.equals("Chrome")){
System.setProperty("webdriver.chrome.driver","C:/SeleniumJars/chromedriver.exe");
driver = new ChromeDriver();
}else {
System.setProperty("webdriver.ie.driver","C:\\SeleniumJars\\MicrosoftWebDriver.exe");
driver = new InternetExplorerDriver();
}
PageFactory.initElements(driver, this);
}
public void closeBrowser() {
driver.quit();
}
	
public void openGmail() {
driver.get("https://accounts.google.com/ServiceLogin/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=AddSession");
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}	
public void enterEmail(String a) throws InterruptedException {
driver.findElement(By.id("identifierId")).sendKeys(a);
driver.findElement(By.xpath(".//*[@id='identifierNext']/content/span")).click();	
Thread.sleep(3000);
}
	
public void enterPassword(String b) throws InterruptedException {
driver.findElement(By.xpath("//input[@name='password']")).sendKeys(b);
driver.findElement(By.xpath(".//*[@id='passwordNext']/content/span")).click();;
Thread.sleep(3000);
}
	
public String readEmailError() {
String actualErrorMsg = driver.findElement(By.xpath("//div[@class='dEOOab RxsGPe']")).getText();
//System.out.println(actualErrorMsg);
return actualErrorMsg;
}
	
public String readPasswordError() {
String actualErrorMsg = driver.findElement(By.xpath(".//*[@id='view_container']/div/div/div[2]/div/div[1]/div/form/content/div[1]/div/div[2]/div[2]")).getText();
//System.out.println(actualErrorMsg);
return actualErrorMsg;
}
	
}	
	
	
	

