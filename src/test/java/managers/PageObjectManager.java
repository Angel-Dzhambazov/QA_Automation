package managers;

import com.estafet.learning.pages.bg.lillyDrogerie.*;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    private WebDriver driver;

    HomePageLilly homePage;
    LoginPageLilly loginPage;
    ShippingLilly shippingPage;
    ShoppingCartLilly shoppingCartPage;
    SelectedItemsListLilly selectedItemsPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePageLilly getHomePage() {
        return (homePage == null) ? homePage = new HomePageLilly(driver) : homePage;
    }

    public LoginPageLilly getLoginPage() {
        return (loginPage == null) ? loginPage = new LoginPageLilly(driver) : loginPage;
    }

    public ShippingLilly getShippingPage() {
        return (shippingPage == null) ? shippingPage = new ShippingLilly(driver) : shippingPage;
    }

    public ShoppingCartLilly getShoppingCartPage() {
        return (shoppingCartPage == null) ? shoppingCartPage = new ShoppingCartLilly(driver) : shoppingCartPage;
    }

    public SelectedItemsListLilly getSelectedItemsPage() {
        return (selectedItemsPage == null) ? selectedItemsPage = new SelectedItemsListLilly(driver) :
                selectedItemsPage;
    }
}
