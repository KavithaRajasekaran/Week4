package week4.day1.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Assignment3 {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://buythevalue.in/");

		driver.findElement(By.xpath("//a[contains(text(),'URBAN FIT X SMART WATCH')]")).click();
		
		WebElement chatframe = driver.findElement(By.xpath("//iframe[@title='chat widget']"));
		
		driver.switchTo().frame(chatframe);
		
		driver.findElement(By.xpath("//button[@data-test-id='initial-message-close-button']")).click();
		
		driver.switchTo().defaultContent();
		
		driver.findElement(By.xpath("//input[@name='wk_zipcode']")).sendKeys("600045",Keys.TAB);
		
		driver.findElement(By.xpath("//input[@value='Check']")).sendKeys(Keys.ENTER);
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button[@id='product-add-to-cart']")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//a[text()='View Cart'])[2]")).click();
		driver.findElement(By.id("checkout")).click();
		
		Thread.sleep(3000);
		
		driver.switchTo().alert().accept();
		
		System.out.println("Alert is handled");
		
		driver.close();
		
		
	}

}
