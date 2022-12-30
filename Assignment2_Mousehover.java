package week4.day2.assignments;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Assignment2_Mousehover {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.nykaa.com/");
		
		WebElement Brandsmenuitem = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions builder = new Actions(driver);
		builder.moveToElement(Brandsmenuitem).perform();
		
				
		WebElement searchbox = driver.findElement(By.xpath("//input[@id='brandSearchBox']"));
		searchbox.click();
		searchbox.sendKeys("LOreal Paris",Keys.ENTER);
		
		WebElement lorealparislink = driver.findElement(By.cssSelector("a[href*='loreal-paris']"));
		Actions builder1=new Actions(driver);
		builder1.click(lorealparislink).perform();
		String expectedTitle = "Buy L'Oreal Paris products online at best price on Nykaa | Nykaa";
		if(driver.getTitle().equalsIgnoreCase(expectedTitle))
		{
			System.out.println("Loreal paris page is opened");
		}
		else
		{
			System.out.println("Loreal paris page is not opened");
			
		}
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='sort-name']")).click();
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		driver.findElement(By.xpath("(//span[text()='Hair Care'])[2]")).click();
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		driver.findElement(By.xpath("//span[text()='Shop By Concern']")).click();
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		
		String shampoofilter = driver.findElement(By.xpath("(//span[@class='filter-value'])[1]")).getText();		
		String colorprotectionfilter = driver.findElement(By.xpath("(//span[@class='filter-value'])[2]")).getText();		
		
		if(shampoofilter.equals("Shampoo"))
		{
			System.out.println("The filter applied shows shampoo ");
		}
		
		
		if(colorprotectionfilter.equals("Color Protection"))
		{
			System.out.println("The filter applied shows colorprotection");
		}
		
		driver.findElement(By.xpath("//div[contains(text(), 'Paris Colour Protect Shampoo')]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> Winhandles = new ArrayList<String>(windowHandles);
		driver.switchTo().window(Winhandles.get(1));
		
		WebElement shampoosizedd = driver.findElement(By.xpath("//select[@title='SIZE']"));
		Select sizedropdown = new Select(shampoosizedd);
		sizedropdown.selectByVisibleText("175ml"); 
		
		String productprice = driver.findElement(By.xpath("//span[@class='css-1jczs19']")).getText();
		System.out.println("The MRP of the product is " + productprice);
		
		driver.findElement(By.xpath("//span[text()='Add to Bag']")).click();
		driver.findElement(By.xpath("//button[@class='css-g4vs13']")).click();
		
		
		WebElement cartframe = driver.findElement(By.xpath("//iframe[@class='css-acpm4k']"));
		driver.switchTo().frame(cartframe);

		String grandTotal = driver.findElement(By.xpath("//span[@class='css-1um1mkq e171rb9k3']")).getText();
		System.out.println("The Grand Total including tax is " + grandTotal);
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@class='css-guysem e8tshxd0'])[2]")).click();
		
		driver.switchTo().defaultContent();
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> winhandles2 = new ArrayList<String>(windowHandles2);
		driver.switchTo().window(winhandles2.get(1));		
		
		//I m getting "Sign in page. I m not seeing "Continue as guest" option. May be due to country restrictions????
		
		//driver.close();

		
		
		
			}

}
