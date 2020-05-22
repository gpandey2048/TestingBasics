package pageObjectModelPractice;

import org.testng.annotations.Test;

import com.global.Covid2020.BaseTest;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class NewTest extends BaseTest {
  
  @BeforeMethod
  public void beforeMethod() throws Exception {
	 init();
	 driver=new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.get("https://github.com/");
	// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	//init();
	 
	  
	  
  }
  
  
  @Test
  public void f() throws InterruptedException  {
	  
	  SignInPage signin= new SignInPage(driver);
	  signin.signIn();
	  
	  String Expectedmsg = "Incorrect username or password.";
	  
	  /*driver.findElement(By.xpath("//a[@class='HeaderMenu-link no-underline mr-3']")).click();
	  
	  Thread.sleep(2000);
	  driver.findElement(By.id("login_field")).sendKeys("Pandey@gmail.com");
	  driver.findElement(By.id("password")).sendKeys("password");
	  driver.findElement(By.name("commit")).click();
	 String actualmsg = driver.findElement(By.xpath("//div[@class='container-lg px-2']")).getText();
	  
	  String Expectedmsg = "Incorrect username or password.";

	  Assert.assertEquals(actualmsg, Expectedmsg);*/
	 Assert.assertEquals(signin.verifyError(), Expectedmsg);   
	  
  }
  @AfterMethod
  public void afterMethod() {
	  
	  driver.quit();
  }

}
