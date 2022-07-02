package io.cucumber.skeleton;

import Pages.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


import static java.time.temporal.ChronoUnit.SECONDS;


public class StepDefinitions {
    public WebDriver driver;
    public WebDriverWait wait;
    public Actions a;

    public HomePage homePage;
    public GenericUtils genericUtils;

    public CartPage cartPage;


    @Before
    public void setup() throws IOException {

        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\global.properties");
        Properties prop = new Properties();
        prop.load(fis);
        if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (prop.getProperty("browser").equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\src\\test\\resources\\msedgedriver.exe");
            driver = new EdgeDriver();
        }

        a = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.of(5, SECONDS));
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        genericUtils = new GenericUtils(driver);
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);

    }

    @After
    public void teardown() {
        // closes all the browser windows opened by web driver
        driver.quit();
    }

    @Given("User is on the homepage")
    public void userIsOnTheHomepage() {
        genericUtils.loadHomePage();
    }

    @When("User adds the first item to the cart")
    public void userAddsTheFirstItemToTheCart() {
        homePage.hoverItem(a);
        homePage.clickAddToCartFirstElement();
    }

    @When("User hovers the mouse over the first item")
    public void userHoversTheMouseOverTheFirstItem() {
        homePage.hoverItem(a);
    }

    @Then("User sees add to cart button")
    public void userSeesAddToCartButton() {
        homePage.SeesElement();
    }

    @Then("User sees a Product successfully added to your shopping cart message")
    public void userSeesAProductSuccessfullyAddedToYourShoppingCartMessage() {
        homePage.getAddedToCartNotification(wait);
    }


    @Then("User sees the same price for the item in the cart")
    public void userSeesTheSamePriceForTheItemInTheCart() {

        homePage.comparePrice(wait);
    }

    @And("User clicks proceed to checkout")
    public void userClicksProceedToCheckout() {
        homePage.clickProceedToCheckOut(wait);
    }

    @Then("User is taken to the cart page")
    public void userIsTakenToTheCartPage() {
        genericUtils.VerifyCartPage();
    }

    @And("User clicks continue shopping")
    public void userClicksContinueShopping() {
        homePage.clickContinueShopping(wait);
    }

    @When("User hovers with the mouse over the Cart Button")
    public void userHoversWithTheMouseOverTheCartButton() {
        homePage.hoverCart(a);
    }

    @Then("User sees items in cart")
    public void userSeesItemsInCart() {
        homePage.checkItemsInCart(wait);
    }

    @And("User clicks remove item from the cart")
    public void userClicksRemoveItemFromTheCart() {
        homePage.clickRemoveItem(wait);
    }

    @Then("User sees no items in the cart")
    public void userSeesNoItemsInTheCart() {
        homePage.checkEmptyCart(wait);
    }
}
