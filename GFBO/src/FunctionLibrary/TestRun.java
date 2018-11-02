package FunctionLibrary;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.*;

public class TestRun 
{
	static File srcFile;

	public static void main(String[] args) 
	{
		try
		{
			srcFile = new File("D:\\TestData.xlsx");
			
			FileInputStream testdatafile = new FileInputStream(srcFile);
			
			XSSFWorkbook wb = new XSSFWorkbook(testdatafile);
			
			XSSFSheet sh = wb.getSheetAt(0);
			
			int rowCount = sh.getLastRowNum() - sh.getFirstRowNum();
			
			System.out.println("rowCount: "+rowCount);
			
			for(int i=1; i<=rowCount;i++)
			{
				Row rw = sh.getRow(i);
				
				String action,locator=null,input=null;
				
				String step = rw.getCell(1).getStringCellValue();
				
				System.out.println("Step: "+step);
				
				if(!step.equalsIgnoreCase("NO"))
				{
					action = rw.getCell(3).getStringCellValue();
					
					System.out.println("action: "+action);
					
					if(action!=null)
					{
						locator = rw.getCell(4).getStringCellValue();
						
						input = rw.getCell(5).getStringCellValue();
					
						System.out.println("locator: "+locator);
						
						System.out.println("input: "+input);
						
						switch(action)
						{
						case "openBrowser":
							
							ActionKeywords.openBrowser(input);
							break;
							
						case "navigate":
							ActionKeywords.navigate(input);
							break;
							
						case "Type_Text":
							ActionKeywords.Type_Text(locator, input);
							break;
							
						case "click":
							ActionKeywords.click(locator);
							break;
							
						case "wait1":
							ActionKeywords.wait1();
							break;
							
						case "close":
							ActionKeywords.close();
							break;
							
							default:
								System.out.println("Invalid Action.."+action);
						}
					
				}
				else
				{
					System.out.println("Keyword canot be empty");
					
					break;
				}

			}
				
							
				
			}
		
		}
		catch(Exception e)
		{
			System.out.println(e.getLocalizedMessage());
		}
	}

}
