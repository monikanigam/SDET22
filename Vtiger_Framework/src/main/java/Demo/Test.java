package Demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

	static {
		System.setProperty("webdriver.chrome.driver", ".\\chromedriver1.exe");
	}
	public static void main(String[] args) throws InterruptedException {
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.flipkart.com/");
	Thread.sleep(2000);
	driver.findElement(By.name("q")).sendKeys("Samsung Mobiles"+Keys.ENTER);
	
	List<WebElement> products = driver.findElements(By.xpath("//div[contains(text(),'SAMSUNG') and @class]"));
	for(int i=0;i<products.size();i++) {
		String pro = products.get(i).getText();
		System.out.println(pro);
	}
	
	}
	

}
