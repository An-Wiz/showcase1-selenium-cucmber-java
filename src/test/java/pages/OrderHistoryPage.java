package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderHistoryPage {

    WebDriver driver;

    @FindBy(xpath = "//table[@id='order-list']//tr[@class='first_item ']//td[@class='history_price']") WebElement lastOrderPrice;
    @FindBy(css = "a.logout") WebElement signOut;

    public OrderHistoryPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getLastOrderPrice(){
        String actualPrice = lastOrderPrice.getText();
        return actualPrice;
    }

    public void signOut(){
        signOut.click();
    }
}
