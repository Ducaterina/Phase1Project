package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
//		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		
		WebDriver driver = new ChromeDriver();
//		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.amazon.in");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		WebElement SearchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		SearchBox.click();
		SearchBox.sendKeys("iphone 12");
		
		WebElement SearchButton = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		SearchButton.click();
		
		List<WebElement> Names = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
		int i = 1;
		for (WebElement elm : Names) {
		System.out.print("Item " + i++ + ": ");
		System.out.println(elm.getText());
		}

		List<WebElement> Prices = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		int n = 1;
		for (WebElement prc : Prices) {
		System.out.print("Price of item " + n++ + ": ");
		System.out.println(prc.getText());
		}
		
		
		driver.close();
	}
}
