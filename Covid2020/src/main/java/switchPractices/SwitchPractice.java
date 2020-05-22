package switchPractices;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.global.Covid2020.BaseTest;

public class SwitchPractice extends BaseTest {

	public static void main(String[] args) {
//driver=new ChromeDriver();
ChromeOptions option= new ChromeOptions();
option.addArguments("user-data-dir=C:\\Users\\suraj\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 3\\default");
option.addArguments("--disabled-notifications");

driver=new ChromeDriver(option);
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
driver.get("http://www.wuv.edu/");
driver.findElement(By.className("sgpb-popup-close-button-6")).click();
driver.manage().window().maximize();
String title = driver.getTitle();
System.out.println(title);
String parentWindow = driver.getWindowHandle();
System.out.println("parent window is: "+parentWindow);
driver.findElement(By.xpath("//a[contains(text(),'my WUV')]")).click();


Set<String> multiWindows = driver.getWindowHandles();
Iterator<String> itr = multiWindows.iterator();
while (itr.hasNext()) {
	
	String currentwindow = itr.next();
	System.out.println(currentwindow);
	if(!currentwindow.equals(parentWindow)) {
driver.switchTo().window(currentwindow)	;
	}
}

String childwindowtitle = driver.getTitle();
System.out.println("current window title is: "+ childwindowtitle);


driver.findElement(By.id("id")).sendKeys("gpandey@wuv.edu");
driver.findElement(By.id("password")).sendKeys("Optio8");
driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();

driver.close();
driver.switchTo().window(parentWindow);
System.out.println("Window title is: "+driver.getTitle());
	}

}
