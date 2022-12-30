package week4.day2.assignments;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Assignment1b_windowhandling {

	public static void main(String[] args) throws IOException, InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://leafground.com/window.xhtml");


		//First button click ---------------Click and Confirm new Window Opens
		driver.findElement(By.xpath("//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only mr-2 mb-2']")).click();

		Set<String> allwindowHandles1 = driver.getWindowHandles();

		List<String> listwindowhandles1 = new ArrayList<String>(allwindowHandles1);

		driver.switchTo().window(listwindowhandles1.get(1));

		driver.manage().window().maximize();

		System.out.println("A new window is opened with title "+driver.getTitle());

		driver.close();

		//Switching to parent window
		driver.switchTo().window(listwindowhandles1.get(0));

		//Second button click ---------- Find the number of opened tabs

		driver.findElement(By.xpath("//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-button-help']")).click();

		Set<String> allwindowHandles2 = driver.getWindowHandles();

		List<String> listwindowhandles2 = new ArrayList<String>(allwindowHandles2);

		driver.switchTo().window(listwindowhandles2.get(1));

		System.out.println("Total number of windows opened is "+listwindowhandles2.size());

		driver.close();

		driver.switchTo().window(listwindowhandles2.get(2));

		driver.close();

		//Switching to parent window
		driver.switchTo().window(listwindowhandles2.get(0));

		//Third button click ---------- Close all windows except Primary

		driver.findElement(By.xpath("//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-icon-right ui-button-warning']")).click();

		Set<String> allwindowHandles3 = driver.getWindowHandles();

		List<String> listwindowhandles3 = new ArrayList<String>(allwindowHandles3);

		int j = listwindowhandles3.size();

		for (int i = 1; i < j; i++) 
		{
			driver.switchTo().window(listwindowhandles3.get(i));
			driver.close();
		}


		//Switching to parent window
		driver.switchTo().window(listwindowhandles3.get(0));

		//Fourth button click ---------- Wait for 2 new tabs to open

		driver.findElement(By.xpath("//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only ui-button-raised ui-button-success mr-2 mb-2']")).click();

		Set<String> allwindowHandles4 = driver.getWindowHandles();

		List<String> listwindowhandles4 = new ArrayList<String>(allwindowHandles4);

		int k = listwindowhandles4.size();

		if(k==3)
		{
			System.out.println("Two windows are opened");
		}
		else
		{
			System.out.println("Two windows are not opened");
		}

		for (int l = 1; l < k; l++) 
		{
			driver.switchTo().window(listwindowhandles4.get(l));
			driver.close();
		}


		//Switching to parent window
		driver.switchTo().window(listwindowhandles4.get(0));
		driver.close();



	}

}
