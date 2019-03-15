package steps;

import base.BaseUtil;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.*;

public class SuccessCheckoutSteps {

    private BaseUtil base;
    public String expectedPrice;

    public SuccessCheckoutSteps(BaseUtil base) {
        this.base = base;
    }

    @Given("^user is logged in$")
    public void userIsLoggedIn(){
        base.driver.navigate().to("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        LoginPage loginPage = new LoginPage(base.driver);
        loginPage.login();
    }

    @When("^user navigates to women tab$")
    public void userNavigatesToWomenTab(){
        MyAccountPage myAccountPage = new MyAccountPage(base.driver);
        myAccountPage.clickWomenLink();
    }

    @And("^user clicks on details button of a random item$")
    public void userClicksOnDetailsButtonOfARandomItem(){
        WomenCatalogPage womenCatalogPage = new WomenCatalogPage(base.driver);
        womenCatalogPage.clickRandomItem();
    }

    @And("^user adds the item to the cart$")
    public void userAddsTheItemToTheCart(){
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(base.driver);
        productDetailsPage.clickAddToCart();

    }

    @And("^user notices total item price in the popup window$")
    public void userNoticesTotalItemPriceInThePopupWindow(){
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(base.driver);
        productDetailsPage.waitForConfirmationPopup();
        ConfirmationPopupPage confirmationPopupPage = new ConfirmationPopupPage(base.driver);
        expectedPrice = confirmationPopupPage.saveTotalPrice();
    }

    @And("^user proceeds to checkout in popup window$")
    public void userProceedsToCheckoutInPopupWindow(){
        ConfirmationPopupPage confirmationPopupPage = new ConfirmationPopupPage(base.driver);
        confirmationPopupPage.clickProceedToCheckout();
    }

    @And("^user proceeds to checkout on summary page$")
    public void userProceedsToCheckoutOnSummaryPage(){
        ShoppingCartSummaryPage shoppingCartSummaryPage = new ShoppingCartSummaryPage(base.driver);
        shoppingCartSummaryPage.clickProceedToCheckout();
    }

    @And("^user checks delivery and billing addresses$")
    public void userChecksDeliveryAndBillingAddresses(){
        ShoppingCartAddressesPage shoppingCartAddressesPage = new ShoppingCartAddressesPage(base.driver);
        shoppingCartAddressesPage.assertAddressesAreMatching();
        shoppingCartAddressesPage.clickProceedToCheckout();
    }

    @And("^user agrees with terms and proceeds to checkout on shipping page$")
    public void userAgreesWithTermsAndProceedsToCheckoutOnShippingPage(){
        ShoppingCartShippingPage shoppingCartShippingPage = new ShoppingCartShippingPage(base.driver);
        shoppingCartShippingPage.agreeToTerms();
        shoppingCartShippingPage.clickProceedToCheckout();
    }

    @And("^user click on check payment option on payment page$")
    public void userClickOnCheckPaymentOptionOnPaymentPage(){
        ShoppingCartPaymentPage shoppingCartPaymentPage = new ShoppingCartPaymentPage(base.driver);
        shoppingCartPaymentPage.clickPayByCheck();
    }

    @And("^user confirms the order on order confirmation page$")
    public void userConfirmsTheOrderOnOrderConfirmationPage(){
        OrderSummaryPage orderSummaryPage = new OrderSummaryPage(base.driver);
        orderSummaryPage.clickConfirmOrder();
    }

    @And("^user verifies that oder has been submitted$")
    public void userVerifiesThatOderHasBeenSubmitted(){
        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(base.driver);
        orderConfirmationPage.assertOrderSubmited();
    }

    @And("^user navigates back to orders$")
    public void userNavigatesBackToOrders(){
        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(base.driver);
        orderConfirmationPage.clickBackTOOrdersLink();
    }

    @Then("^user verifies that the total price of placed order is right$")
    public void userVerifiesThatTheTotalPriceOfPlacedOrderIsRight(){
        OrderHistoryPage orderHistoryPage = new OrderHistoryPage(base.driver);
        String actualPrice = orderHistoryPage.getLastOrderPrice();
        Assert.assertEquals(actualPrice, expectedPrice);
    }

    @And("^user logs out$")
    public void userLogsOut(){
        OrderHistoryPage orderHistoryPage = new OrderHistoryPage(base.driver);
        orderHistoryPage.signOut();
    }
}
