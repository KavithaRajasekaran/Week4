package week4.day1.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment1_Frames {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");

		//outer frame
		driver.switchTo().frame("frame1");
		driver.findElement(By.xpath("//input")).sendKeys("Testing");
		//inner frame
		driver.switchTo().frame("frame3");
		driver.findElement(By.xpath("//input")).sendKeys(Keys.SPACE);
		//switching control from both the outer/inner frames
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("frame2");
		WebElement animalsdropdown = driver.findElement(By.xpath("//select[@id='animals']"));

		Select drpdown = new Select(animalsdropdown);
		drpdown.selectByVisibleText("Baby Cat");

	}

}
