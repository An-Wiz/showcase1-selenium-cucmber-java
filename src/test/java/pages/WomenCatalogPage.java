package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class WomenCatalogPage {

    WebDriver driver;

    @FindBy(xpath = "//ul/li//a[contains(@class,'button lnk_view btn btn-default')]")
    List<WebElement> items;

    public WomenCatalogPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickRandomItem(){
        Random rand = new Random();
        int randomItem = rand.nextInt(items.size());
        items.get(randomItem).click();
    }
}
