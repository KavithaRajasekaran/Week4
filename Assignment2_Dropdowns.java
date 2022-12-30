package week4.day1.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Assignment2_Dropdowns {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://leafground.com/select.xhtml;jsessionid=node01b6hhw7csjf211q4hnvqtdlyg710515.node0");
		
				
		WebElement dd1 = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
		
		Select dropdown1 = new Select(dd1);
		
		dropdown1.selectByVisibleText("Selenium");
		
		driver.findElement(By.xpath("//label[@id='j_idt87:country_label']")).click();
		driver.findElement(By.xpath("//li[@id='j_idt87:country_3']")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//label[@id='j_idt87:city_label']")).click();
		boolean displayed = driver.findElement(By.xpath("//ul[@id='j_idt87:city_items']")).isEnabled();
		
		if(displayed)
		{
			System.out.println("Cities got loaded");
		}
		else
		{
			System.out.println("Cities aren't loaded");
		}
		
		driver.findElement(By.xpath("//span[@class='ui-button-icon-primary ui-icon ui-icon-triangle-1-s']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@data-item-label='AWS']")).click();
		driver.findElement(By.xpath("//li[@data-item-label='Appium']")).click();
		
		
		driver.findElement(By.xpath("//label[@id='j_idt87:lang_label']")).click();
		driver.findElement(By.xpath("//li[@id='j_idt87:lang_2']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//label[@id='j_idt87:value_label']")).click();
		driver.findElement(By.xpath("//li[@id='j_idt87:value_1']")).click();
		
		driver.close();
						
	}

}
