package calander;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class  calander{
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		// login page
		driver.get("http://localhost:8888/index.php");
		WebElement username = driver.findElement(By.name("user_name"));
		username.sendKeys("admin");
		WebElement pass = driver.findElement(By.name("user_password"));
		pass.sendKeys("manager");
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(5000);
		// click on calendar module
		driver.findElement(By.linkText("Calendar")).click();
		WebElement add = driver.findElement(By.className("calAddButton"));
		Actions act = new Actions(driver);
		act.moveToElement(add).build().perform();
		// click on call
		Thread.sleep(2000);
		driver.findElement(By.id("addcall")).click();
		// send key to subject
		WebElement event = driver.findElement(By.name("subject"));
		event.sendKeys("TEAM MEETING");
//send key to description
		WebElement description = driver.findElement(By.name("description"));
		description.sendKeys("TEAM MEETING regarding the selenium project ");
//location
		WebElement location = driver.findElement(By.name("location"));
		location.sendKeys("qspiders ");
//slecting dropdown
		WebElement priority = driver.findElement(By.id("eventstatus"));
		Select eventstatus = new Select(priority);
		eventstatus.selectByIndex(1);
// selecting time
		WebElement timedrop = driver.findElement(By.name("starthr"));
		Select time = new Select(timedrop);
		time.selectByIndex(10);

		// selecting date

		WebElement enddate = driver.findElement(By.name("due_date"));
		enddate.clear();
		enddate.sendKeys("2025-09-25");
		// start
		WebElement startdate = driver.findElement(By.name("date_start"));
		startdate.clear();
		startdate.sendKeys("2025-09-25");

		// saving the event
		driver.findElement(By.name("eventsave")).click();
		
	WebElement profilepic=	driver.findElement(By.cssSelector("img[src=\"themes/softed/images/user.PNG\""));
	Actions act1 = new Actions(driver);
	act1.moveToElement(profilepic).build().perform();
	
	driver.findElement(By.linkText("Sign Out")).click();
	
		driver.quit();
		

	}
}
