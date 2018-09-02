package selenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DataFile {
	static DataFile d1 = new DataFile();
	Xls_Reader d = new Xls_Reader("C:\\Testing\\NikulTest.xlsx");
	String validEmail = d.getCellData("Data1", "UserName", 	2);
	String wrongPassword = d.getCellData("Data1", "UserName", 	3);
	String invalidEmail = d.getCellData("Data1", "UserName", 	3);
	String passwordError = d.getCellData("Data1", "Password Error", 	2);
	String emailError = d.getCellData("Data1", "Email Error", 	2);
	
	public String browserName() throws IOException {
		//WebDriver driver;
		FileInputStream fs = new FileInputStream("C:\\Testing\\prop.properties");
		Properties prop = new Properties();
		prop.load(fs);
		String browser = prop.getProperty("browser");
		return browser;
		
	}
	/* public void multipleBrowser(String browser) {
		 WebDriver driver;
		 if(browser.equals("Firefox")) {
			 driver = new FirefoxDriver();
		}else if(browser.equals("Chrome")){
			System.setProperty("webdriver.chrome.driver","C:/SeleniumJars/chromedriver.exe");
			 driver = new ChromeDriver();
		}else {
			System.setProperty("webdriver.ie.driver","C:\\SeleniumJars\\MicrosoftWebDriver.exe");
			 driver = new InternetExplorerDriver();
		}
		}*/
		 
	 }
	
	
	

