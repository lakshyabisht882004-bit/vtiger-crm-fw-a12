package organization;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrganizationTest {
	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/New Microsoft Excel Worksheet.xlsx");
	//sending value using the excell sheet
		
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet2");
		Row row = sh.getRow(7);
		Cell cell = row.getCell(0);
		String value = cell.getStringCellValue();
		System.out.println(value);
//		Open Browser 
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
//		Login
		driver.get("http://localhost:8888/");
		
		WebElement username = driver.findElement(By.name("user_name"));
		username.sendKeys("admin");
		WebElement password = driver.findElement(By.name("user_password"));
		password.sendKeys("manager");
		
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(3000);
//		Create Organization
		driver.findElement(By.linkText("Organizations")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click();
		
//		Filling data to the form
		WebElement orgField = driver.findElement(By.name("accountname"));
		//String orgName = "automationWithPiyush01";
		orgField.sendKeys(value);
		
		Thread.sleep(3000);
//		Save 
		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
		
//		Verification
		String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
		
		if (actOrgName.equals(value)) {
			System.out.println("Created Organization successfully!!!!");
		}else {
			System.out.println("Failed....");
		}
		
		WebElement profilePic = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		
		Actions act = new Actions(driver);
		act.moveToElement(profilePic).build().perform();
		
		Thread.sleep(2000);
		driver.findElement(By.linkText("Sign Out")).click();
		
		Thread.sleep(3000);
		driver.quit();
		
		
		
	}
}

