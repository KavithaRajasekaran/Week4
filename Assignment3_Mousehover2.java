package week4.day2.assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Assignment3_Mousehover2 {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.snapdeal.com/");
		
		WebElement mensmenu = driver.findElement(By.xpath("//span[contains(text(),'Men')]"));
		Actions builder = new Actions(driver);
		builder.doubleClick(mensmenu).perform();
		
		WebElement menssportshoesmenu = driver.findElement(By.xpath("//span[contains(text(),'Sports Shoes')]"));
		Actions builder1 = new Actions(driver);
		builder1.doubleClick(menssportshoesmenu).perform();
		
		String countofshoes = driver.findElement(By.xpath("//div[@class='child-cat-count ']")).getText();
		
		System.out.println("Total number of shoes is " + countofshoes);
		
		driver.findElement(By.cssSelector("a[href*='training-shoes']")).click();
		
		//Sort feature code
		driver.findElement(By.xpath("//span[@class='sort-label']")).click();
		driver.findElement(By.xpath("(//li[@data-index='1'])[2]")).click();
		
		//Have to work on it..
		
		/*
		//checking if the products are displayed in "Low to High" sort order -------- Not working
		List<WebElement> row1products = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		List<Integer> productprices = new ArrayList<>();
		for (int i = 0; i < row1products.size(); i++) 
		{
			System.out.println(row1products.get(i).getText());
			String r1="Rs.  ";
			String replacestring = row1products.get(i).getText().replace(r1,"");
			System.out.println("replacestring is " +replacestring);
			int finalconvertedprice = Integer.parseInt(replacestring);
			System.out.println("finalconvertedprice is" +finalconvertedprice);
			productprices.add(finalconvertedprice);
			}
		
		Collections.sort(productprices);
		
		if(productprices.get(0)<productprices.get(1))
		{
			System.out.println("Items are in sorted order");
		}
		else
		{
			System.out.println("Items are NOT in sorted order");
		}
		
		*/
		
		WebElement fromval = driver.findElement(By.xpath("//input[@name='fromVal']"));
		fromval.clear();
		fromval.sendKeys("900");
		
		WebElement toval = driver.findElement(By.xpath("//input[@name='toVal']"));
		toval.clear();
		toval.sendKeys("1200");
		toval.sendKeys(Keys.TAB);
		
	//	driver.findElement(By.xpath("(//div[@class='price-go-arrow btn btn-line btn-theme-secondary'")).click();
		
		
		Thread.sleep(2000);
		
		WebElement colorNavy = driver.findElement(By.xpath("(//a[@class='filter-name hashAdded'])[9]"));
		Actions builder2 = new Actions(driver);
		
		builder2.moveToElement(colorNavy).click().perform();
		
		String colorchoosen="Navy";
		
		String coloractual = driver.findElement(By.xpath("//a[@class='clear-filter-pill  ']")).getText();
		
		if(coloractual.equals(colorchoosen))
		{
			System.out.println("The Navy color filter is applied");
		}
		
		
		WebElement firstshoeElement = driver.findElement(By.xpath("//img[@title='TUFF 5005 Navy Training Shoes']"));
		Actions builder3 = new Actions(driver);
		builder3.moveToElement(firstshoeElement).perform();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[@class='center quick-view-bar  btn btn-theme-secondary  '] ")).click();
		Thread.sleep(2000);
		String price = driver.findElement(By.xpath("//div[@class='product-price pdp-e-i-PAY-l clearfix']//span")).getText();
		
		System.out.println("The price of navy shoe is " + price);
		String discount = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
		System.out.println("The discount for shoe is " + discount);	
		
			
		
		//Capture screenshots
		
		File source = driver.getScreenshotAs(OutputType.FILE);
		
		File target = new File("./screenshots/shoeimages.png");
		
		FileUtils.copyFile(source, target);
				
		driver.close();
		
		driver.switchTo().defaultContent();
		
		driver.close();
		
	}

}
