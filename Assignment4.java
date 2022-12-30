package week4.day1.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Assignment4 {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://dev110326.service-now.com/");
		
		driver.switchTo().frame("gsft_main");
		
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
		
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("India@123");
		
		driver.findElement(By.id("sysverb_login")).click();
		
		driver.close();
		
				
	}

}
