package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPopupPage {

    WebDriver driver;

    @FindBy(css = "span[class='ajax_block_cart_total']")
    WebElement totalPrice;
    @FindBy(xpath = "//a[@title='Proceed to checkout']") WebElement proceedToCheckoutButton;

    public ConfirmationPopupPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String saveTotalPrice(){
       String expectedPrice = totalPrice.getText();
       return expectedPrice;
    }

    public void clickProceedToCheckout(){
        proceedToCheckoutButton.click();
    }
}
