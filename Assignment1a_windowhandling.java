package week4.day2.assignments;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Assignment1a_windowhandling {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		driver.findElement(By.id("username")).sendKeys("demoCsr");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//Giving login credentials again on the secondary screen
		driver.findElement(By.name("USERNAME")).sendKeys("demoCsr");
		driver.findElement(By.name("PASSWORD")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@class='loginButton']")).click();
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		
		driver.findElement(By.cssSelector("a[href*='partyIdFrom']")).click();
		
		Set<String> allwindowHandles = driver.getWindowHandles();
		
		List<String> listwindowhandles = new ArrayList<String>(allwindowHandles);
		
		driver.switchTo().window(listwindowhandles.get(1));
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[@class='linktext']")).click();
		
		
		//To Contact
		driver.switchTo().window(listwindowhandles.get(0));
		driver.findElement(By.cssSelector("a[href*='partyIdTo']")).click();
		Set<String> allwindowHandles1 = driver.getWindowHandles();
		List<String> listwindowhandles1 = new ArrayList<String>(allwindowHandles1);
		driver.switchTo().window(listwindowhandles1.get(1));
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("(//a[@class='linktext'])[6]")).click();
		driver.switchTo().window(listwindowhandles.get(0));
		
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		
		driver.switchTo().alert().accept();
		
		
		String expetedtitle = "View Contact | opentaps CRM";
		String actualtitle = driver.getTitle();
		if(actualtitle.equals(expetedtitle))
		{
			System.out.println("The expected and actual page title is " +actualtitle); 
		}
		else
		{
			System.out.println("Expected and actual titles did not match");
		}
				
		driver.close();
		
	}

}
