import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class GFBO 
{
	static WebDriver driver;
	
	public static void tableValues(WebDriver driver)
	{
		
		driver.get("http://money.rediff.com/gainers/bsc/daily/groupa");
		
		String xpath = ".//*[@id='leftcontainer']/table/thead/tr/th";
		
		List <WebElement> cols = driver.findElements(By.xpath(xpath));
		
		System.out.println("Headers: "+cols.size());
		
		
		for(int i=1;i<cols.size();i++)
		{
			String text = driver.findElement(By.xpath("//*[@id='leftcontainer']/table/thead/tr/th["+i+"]")).getText();
			
			System.out.println(i+"st header: "+text);
		}
		
		List <WebElement> rows = driver.findElements(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr"));
		
		System.out.println("Total rows: "+rows.size());
		
		List <WebElement> colmuns = driver.findElements(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr[1]/td"));
		
		System.out.println("Cloumns: "+colmuns.size());
		
		for(int i=1;i<10;i++)
		{
			
			for (int j=1; j<colmuns.size();j++)
			{
				String text = driver.findElement(By.xpath(".//*[@id='leftcontainer']/table/tbody/tr["+i+"]/td["+j+"]")).getText();
				
				//*[@id="leftcontainer"]/table/tbody/tr[3]/td[1]/a
				//.//[@id='leftcontainer']/table/tbody/tr[1]/td[1]
				
				System.out.print(i+" Row "+j+" Col: "+text);
				
				System.out.print("  ");
			}
			
			System.out.println();
		}
		
		
		
	}
	
	public static void dynamicTable(WebDriver diver)
	{
		driver.get("http://demo.guru99.com/test/table.html");
		
		List <WebElement> rows = driver.findElements(By.xpath("/html/body/table/tbody/tr"));
		
		System.out.println("Total rows in tbale: "+rows.size());
		
		for(int i = 1; i<=rows.size();i++)
		{
			List <WebElement> cols = driver.findElements(By.xpath("/html/body/table/tbody/tr["+i+"]/td"));
			
			///html/body/table/tbody/tr[1]/td[1]
			
			System.out.println(cols.size()+" Cols in "+i+" st row");
			
			for(int j=1; j<=cols.size();j++)
			{
				String text = driver.findElement(By.xpath("/html/body/table/tbody/tr["+i+"]/td["+j+"]")).getText();
				
				System.out.print(i+" Row "+j+" Col: "+text);
				
				System.out.print("  ");
			}
			
			System.out.println();
			
		}
		
		
		
		
		
		
	}

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.ie.driver", "D:\\Tools\\Selenium 2.53.0\\IEDriverServer.exe");
		
		driver =  new InternetExplorerDriver();
		
		driver.manage().window().maximize();
		
		
		GFBO.dynamicTable(driver);
		
		
		driver.close();
		
		
	}

}
