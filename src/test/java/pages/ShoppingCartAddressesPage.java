package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartAddressesPage {

    WebDriver driver;

    @FindBy(xpath = "//ul[@id='address_delivery']/li")
    List<WebElement> deliveryInfoList;

    @FindBy(xpath = "//ul[@id='address_delivery']/li")
    List<WebElement> invoiceInfoList;

    @FindBy(xpath = "//button[@name='processAddress']") WebElement proceedToCheckoutButton;



    public ShoppingCartAddressesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean DeliveryAndBillingAddressesAreMatching(){

        boolean matching = false;

        List<String> deliveryInfo = new ArrayList<String>();
        for (WebElement el: deliveryInfoList) {
            deliveryInfo.add(el.getText());
        }
        List<String> invoiceInfo = new ArrayList<String>();
        for (WebElement el: invoiceInfoList){
            invoiceInfo.add(el.getText());
        }
        for (int i = 3; i <= 5; i++) {

            if (deliveryInfo.get(i).equals(invoiceInfo.get(i))){
                i++;
            }else{
                System.out.println("Delivery and billing information do not match!");
                //matching =  false;
                break;
            }
            if ( i>5 )
                System.out.println("Delivery and billing information are matching");
            matching = true;
        }
    return matching;
    }

    public void assertAddressesAreMatching(){
        Assert.assertTrue(DeliveryAndBillingAddressesAreMatching());
    }

    public void clickProceedToCheckout(){
        proceedToCheckoutButton.click();
    }

}
