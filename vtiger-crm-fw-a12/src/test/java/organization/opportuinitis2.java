package organization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class opportuinitis2 {
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
		driver.findElement(By.linkText("Opportunities")).click();
		//keystosearch text
		WebElement oppsearch = driver.findElement(By.name("search_text"));
		oppsearch.sendKeys("usable-vtiger - 1000 units");
		
	// how to search
	WebElement search=	driver.findElement(By.name("search_field"));
		Select type=new Select(search);
		type.selectByIndex(1);
		
		
		Thread.sleep(2000);
		
		driver.findElement(By.name("submit")).click();
		Thread.sleep(2000);
		WebElement profilepic=	driver.findElement(By.cssSelector("img[src=\"themes/softed/images/user.PNG\""));
		Actions act1 = new Actions(driver);
		act1.moveToElement(profilepic).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Sign Out")).click();

		Thread.sleep(2000);
			//driver.quit();
}
}
