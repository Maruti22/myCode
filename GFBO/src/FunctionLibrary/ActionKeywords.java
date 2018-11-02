package FunctionLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ActionKeywords 
{
	static WebDriver driver;
	
	public static void openBrowser(String browser)
	{
		try
		{
			switch (browser) 
			{
			case "Chrome":
				System.setProperty("webdriver.chrome.driver","D:\\Tools\\Selenium 2.53.0\\IEDriverServer.exe" );
				
				driver =new ChromeDriver();
				
				driver.manage().window().maximize();
				break;
			case "Firfox":
				driver =new FirefoxDriver();
				break;
			case "IE":
				System.setProperty("webdriver.ie.driver","D:\\Tools\\Selenium 2.53.0\\IEDriverServer.exe");
				
				driver =new InternetExplorerDriver();
				driver.manage().window().maximize();
				break;

			}
		}
		
		catch(Exception E)
		{
			System.out.println(E.getLocalizedMessage());
			
		}
		
		}
		
	public static void navigate(String URL)
	{
		try
		{
			driver.get(URL);
			
		}
		catch(Exception e)
		{
			System.out.println(e.getLocalizedMessage());
		}
		
	}
	
	public static void Type_Text(String locator, String input)
	{
		try
		{
			driver.findElement(By.xpath(locator)).sendKeys(input);
			
		}
		catch(Exception e)
		{
			System.out.println(e.getLocalizedMessage());
		}
		
	}
	
	public static void click(String locator)
	{
		try
		{
			Thread.sleep(2000);
			
			driver.findElement(By.xpath(locator)).click();
			
			Thread.sleep(2000);
			
		}
		catch(Exception e)
		{
			System.out.println(e.getLocalizedMessage());
		}
	}
	
	public static void wait1()
	{
		try
		{
			Thread.sleep(2000);
		}
		
		catch(Exception e)
		{
			System.out.println(e.getLocalizedMessage());
		}
		
	}

	public static void close()
	{
		try
		{
			driver.close();
		}
		
		catch(Exception e)
		{
			System.out.println(e.getLocalizedMessage());
		}
		
	}
	
	

}
