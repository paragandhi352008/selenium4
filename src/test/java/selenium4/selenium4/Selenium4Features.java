package selenium4.selenium4;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Selenium4Features {
	
	@Test
	public void screenshotTest() throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		Thread.sleep(10000);
		
		WebElement logo = driver.findElement(By.xpath("//div[@class='orangehrm-login-branding']"));
		
		File scrLogo = logo.getScreenshotAs(OutputType.FILE);
		File destFile = new File("scrLogo.png");
		FileUtils.copyFile(scrLogo, destFile);
		
		driver.quit();
		
	}

}
