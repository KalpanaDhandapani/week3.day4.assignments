package com.week3.day4.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {

	public static void main(String[] args) throws InterruptedException {

		// Initialize ChromeDriver
		ChromeDriver driver = new ChromeDriver();
		// Load the URL (http://leaftaps.com/opentaps/control/login)
		driver.get("http://leaftaps.com/opentaps/control/login");
		// Maximize the browser window
		driver.manage().window().maximize();
		// Add an implicit wait to ensure the webpage elements are fully loaded
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Enter the username and password.
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		// Click on the Login button.
		driver.findElement(By.className("decorativeSubmit")).click();
		// Click on the CRM/SFA link.
		driver.findElement(By.linkText("CRM/SFA")).click();
		Thread.sleep(3000); // wait for 3 seconds
		// Click on the Contacts button.
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		// Click on Merge Contacts.
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		// Click on the widget of the "From Contact".
		driver.findElement(By.id("ComboBox_partyIdFrom")).sendKeys("Test");
		Thread.sleep(5000); // wait for 5 seconds
		// Click on the first resulting contact.
		WebElement firstResult = driver.findElement(By.xpath("(//div[@class='dijitMenuItem'])[3]"));
		System.out.println("firstResult "+firstResult.getText());
		firstResult.click();
		// Click on the widget of the "To Contact".
		driver.findElement(By.id("ComboBox_partyIdTo")).sendKeys("Test");
		Thread.sleep(5000); // wait for 5 seconds
		// Click on the second resulting contact.
		WebElement secondResult = driver.findElement(By.xpath("(//div[@class='dijitMenuItem'])[4]"));
		System.out.println("secondResult "+secondResult.getText());
		secondResult.click();
		Thread.sleep(5000); // wait for 5 seconds
		// Click on the Merge button.
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		Thread.sleep(5000); // wait for 5 seconds
		// Accept the alert.
		driver.switchTo().alert().accept();
		// Verify the title of the page.
		String title = driver.getTitle();
		System.out.println("Title = " + title);
		if (title.contains("Contacts | opentaps CRM")) {
			System.out.println("Merge Contacts is successful ");
		} else {
			System.out.println("Merge Contacts is not successful");
		}
		driver.close();//close the driver.
	}
}