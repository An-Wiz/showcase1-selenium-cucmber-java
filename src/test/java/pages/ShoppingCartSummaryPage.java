package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartSummaryPage {

    WebDriver driver;

    @FindBy(xpath = "//div[@id='columns']//a[@title='Proceed to checkout']")
    WebElement proceedToCheckoutButton;

    public ShoppingCartSummaryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickProceedToCheckout(){
        proceedToCheckoutButton.click();
    }


}
