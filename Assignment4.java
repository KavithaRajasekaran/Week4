package week4.day2.assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Assignment4 {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("oneplus 9 pro ",Keys.ENTER);
		
		 WebElement priceone = driver.findElement(By.xpath("(//span[@class='a-price-whole'])"));
		 //System.out.println("Phone price is " +priceone.getText());
		
		 String customerrating = driver.findElement(By.xpath("//span[@class='a-size-base s-underline-text']")).getText();
		 System.out.println("The customer rating is "+customerrating);
		 
		 driver.findElement(By.xpath("//a[@class='a-link-normal s-no-outline']")).click();
		 
		 Set<String> windowHandles = driver.getWindowHandles();
		 
		 List<String> winhandles = new ArrayList<String>(windowHandles);
		 
		 driver.switchTo().window(winhandles.get(1));
			 
		
		//Capture screenshots
		
		File source = driver.getScreenshotAs(OutputType.FILE);
		
		File target = new File("./screenshots/firstphoneimage.png");
		
		FileUtils.copyFile(source, target);
		
		//driver.findElement(By.xpath("//input[@value='Add to Cart']")).click();
		
		String phoneprice = driver.findElement(By.xpath("(//span[@class='a-color-price'])[3]")).getText();
		System.out.println("Phone price is " +phoneprice);

		
		driver.findElement(By.id("add-to-cart-button")).click();
		
		Thread.sleep(2000);
		
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> winhandles2 = new ArrayList<String>(windowHandles2);
		driver.switchTo().window(winhandles2.get(1));
		
		
		String actualcartprice = driver.findElement(By.xpath("(//div[@class='a-column a-span11 a-text-left a-spacing-top-large']/span)[2]")).getText();
		
		System.out.println("actualcartprice is " +actualcartprice);
		//The rupee symbol doesn't allow the script to be saved. So commenting it. Uncomment while running and replace the INR symbol and actualcartprice with rep on the below if block
		//String rep=actualcartprice.replace("","");
		
		if(actualcartprice.contains(phoneprice))
		{
			System.out.println("The actual and cart price is same");
		}
				
		driver.close();
		driver.switchTo().window(winhandles.get(0));
		driver.close();
		
	}

}
