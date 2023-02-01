package mypack;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test61 {

	public static void main(String[] args)throws Exception {
	//open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//Launch site
		driver.get("https://www.amazon.com");
		Thread.sleep(5000);
		//challenge-2:element found in page source and present on page but disabled.
		//So, no reaction and no exception
		driver.switchTo().frame("IframeResult");
		driver.findElement(By.name("Iname")).click();
	}

}
