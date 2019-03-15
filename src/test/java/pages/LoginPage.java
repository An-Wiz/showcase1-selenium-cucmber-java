package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    @FindBy(xpath = "//input[@id='email']") WebElement email;
    @FindBy(css = "input#passwd") WebElement password;
    @FindBy(xpath = "//button[@id='SubmitLogin']") WebElement loginButton;
//    @FindBy( = ) WebElement ;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void login(){
      email.sendKeys("tu1@t.com");
      password.sendKeys("password");
      loginButton.click();
    }

}

