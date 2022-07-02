package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectManager {

    public WebDriver driver;
    public WebDriverWait wait;
    public Actions a;
    public HomePage homePage;
    public CartPage cartPage;
    public PageObjectManager(WebDriver driver){
        this.driver = driver;
    }
    public HomePage getLandingPage(){
        homePage = new HomePage(driver);
        return homePage;
    }
    public CartPage getCartPage(){
        cartPage = new CartPage(driver);
        return cartPage;
    }

}
