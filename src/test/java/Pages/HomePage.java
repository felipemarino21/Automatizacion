package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.List;

public class HomePage {
    public WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    By firstItem = By.xpath("//img[@alt='Faded Short Sleeve T-shirts'][1]");
    By addToCartNotificacion = By.xpath("//i[@class='icon-ok']");

    By addToCartButton= By.xpath("//a[@title='Add to cart'][1]");
    By priceOriginal = By.xpath("//span[@itemprop='price'][1]");
    By priceCart = By.id("layer_cart_product_price");
    By proceedToCheckOut = By.xpath("//a[@class='btn btn-default button button-medium']");
    By continueShopping = By.xpath("//span[@class='continue btn btn-default button exclusive-medium']");
    By cartButton = By.xpath("//a[@title='View my shopping cart']");

    By cartItems = By.xpath("//div[@class='cart-info']");
    By removeItemCart = By.xpath("//a[@class='ajax_cart_block_remove_link']");

    public void clickAddToCartFirstElement(){
        driver.findElement(addToCartButton).click();
    }

    public void hoverItem(Actions a){
        WebElement ele = driver.findElement(firstItem);
        a.moveToElement(ele).build().perform();
    }


    public void SeesElement() {
        Assert.assertTrue(driver.findElement(addToCartButton).isDisplayed());
    }

    public void getAddedToCartNotification(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartNotificacion));
        Assert.assertTrue(driver.findElement(addToCartNotificacion).isDisplayed());
    }

    public void comparePrice(WebDriverWait wait) {
        String priceO = driver.findElement(priceOriginal).getText();
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartNotificacion));
        String priceC = driver.findElement(priceCart).getText();
        Assert.assertEquals(priceC,priceO);
    }

    public void clickProceedToCheckOut(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(proceedToCheckOut));
        driver.findElement(proceedToCheckOut).click();
    }

    public void clickContinueShopping(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(continueShopping));
        driver.findElement(continueShopping).click();
    }

    public void hoverCart(Actions a) {
        WebElement ele = driver.findElement(cartButton);
        a.moveToElement(ele).build().perform();
    }

    public void checkItemsInCart(WebDriverWait wait) {
        Assert.assertTrue(driver.findElement(cartItems).isDisplayed());
    }

    public void clickRemoveItem(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(removeItemCart));
        driver.findElement(removeItemCart).click();
    }
}
