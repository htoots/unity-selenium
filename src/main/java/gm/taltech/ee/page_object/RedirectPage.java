package gm.taltech.ee.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class RedirectPage {
    private WebDriver driver;
    private By header = By.tagName("h3");
    private By status200 = By.linkText("200");
    private By status404 = By.linkText("404");
    public RedirectPage(WebDriver driver) {this.driver = driver;}

    public boolean isAt()  {
        return driver.getCurrentUrl().equals("https://the-internet.herokuapp.com/status_codes");
    }

    public boolean isStatus202Correct(){
        driver.findElement(status200).click();
        return driver.getCurrentUrl().equals("https://the-internet.herokuapp.com/status_codes/200");
    }

    public boolean isStatus404Correct(){
        driver.findElement(status404).click();
        return driver.getCurrentUrl().equals("https://the-internet.herokuapp.com/status_codes/404");
    }



}
