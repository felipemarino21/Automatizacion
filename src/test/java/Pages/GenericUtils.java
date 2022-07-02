package Pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class GenericUtils {
    public WebDriver driver;

    public GenericUtils(WebDriver driver){
        this.driver = driver;
    }

    public void loadHomePage() {
        driver.get("http://automationpractice.com/index.php");
    }
    public void VerifyCartPage() {
        Assert.assertEquals("http://automationpractice.com/index.php?controller=order",driver.getCurrentUrl());
    }

}
