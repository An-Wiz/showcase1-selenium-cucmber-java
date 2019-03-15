package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartShippingPage {

    WebDriver driver;

    @FindBy(css = "input[id=cgv]")
    WebElement agreeToTermsCheckbox;

    @FindBy(xpath = "//button[@type='submit' and @name='processCarrier']")
    WebElement proceedToCheckoutButton;

    public ShoppingCartShippingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void agreeToTerms(){
        if (!agreeToTermsCheckbox.isSelected()) {
            agreeToTermsCheckbox.click();
        }
    }

    public void clickProceedToCheckout(){
        proceedToCheckoutButton.click();
    }


}
