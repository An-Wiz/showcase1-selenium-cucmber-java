package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OrderConfirmationPage {

    WebDriver driver;

    @FindBy(css = "p.alert.alert-success")
    WebElement alertSuccessSubmission;

    @FindBy(css = "a[title='Back to orders']") WebElement backToOrdersLink;

    public OrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void assertOrderSubmited(){
        boolean orderSubmitted = alertSuccessSubmission.isDisplayed();
        Assert.assertTrue(orderSubmitted);
    }

    public void clickBackTOOrdersLink(){
        backToOrdersLink.click();
    }
}
