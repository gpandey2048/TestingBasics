package pageObjectModelPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.global.Covid2020.BaseTest;

import net.bytebuddy.utility.RandomString;

public class SignInPage extends BaseTest {
@FindBy(xpath="//a[@class='HeaderMenu-link no-underline mr-3']")WebElement SignInButton;
@FindBy(id="login_field")WebElement login;
@FindBy(id="password")WebElement Password;
@FindBy(name="commit")WebElement clicking;
@FindBy(xpath="//div[@class='container-lg px-2']")WebElement errmsg;




public SignInPage(WebDriver driver) {
PageFactory.initElements(driver, this);

}
public void signIn() throws InterruptedException {
	
	SignInButton.click();
	//Thread.sleep(2000);
	
	/*WebDriverWait wait= new WebDriverWait(driver, 60);
	
	wait.until(ExpectedConditions.visibilityOf(login));*/
	
	waitForElement(60,login);
	//login.sendKeys("Pandey@gmail.com");
	
	login.sendKeys(p.getProperty("fname")+ p.getProperty("lname")+randomNum()+p.getProperty("domain"));
	String vo = login.getAttribute("value");
	System.out.println(vo);
	System.out.println(vo);

	Password.sendKeys("password");
	clicking.click();
	
	
}



public String verifyError() {
	return(errmsg.getText());
	//String axe = errmsg.getText();
	//System.out.println(axe);
	
}


}
