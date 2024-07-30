package MyTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Programme1 {
WebDriver driver;


	@BeforeMethod
	public void setup() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Downloads\\chromedriver_win32 (5)\\chromedriver.exe");
	
		driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	@Test
	public void verifyTitle() {
		
		String ActualTitle=driver.getTitle();
		System.out.println(ActualTitle);
		String ExpectedTitle="Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		
		Assert.assertEquals(ActualTitle, ExpectedTitle);
		
		
	}
	@Test
	public void verifyLogo()
	{
		boolean flag=driver.findElement(By.xpath("//a[@id='nav-logo-sprites']")).isDisplayed();
		
		Assert.assertTrue(flag);
	}
	

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
