package managers;

import com.estafet.learning.pages.bg.lillyDrogerie.*;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    private WebDriver driver;

    HomePage_Lilly homePage;
    LoginPage_Lilly loginPage;
    Shipping_Lilly shippingPage;
    ShoppingCart_Lilly shoppingCartPage;
    SelectedItemsList_Lilly selectedItemsPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage_Lilly getHomePage() {
        return (homePage == null) ? homePage = new HomePage_Lilly(driver) : homePage;
    }

    public LoginPage_Lilly getLoginPage() {
        return (loginPage == null) ? loginPage = new LoginPage_Lilly(driver) : loginPage;
    }

    public Shipping_Lilly getShippingPage() {
        return (shippingPage == null) ? shippingPage = new Shipping_Lilly(driver) : shippingPage;
    }

    public ShoppingCart_Lilly getShoppingCartPage() {
        return (shoppingCartPage == null) ? shoppingCartPage = new ShoppingCart_Lilly(driver) : shoppingCartPage;
    }

    public SelectedItemsList_Lilly getSelectedItemsPage() {
        return (selectedItemsPage == null) ? selectedItemsPage = new SelectedItemsList_Lilly(driver) :
                selectedItemsPage;
    }
}
