package gm.taltech.ee.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By mainTitle = By.tagName("h1");

    private By dropdownLink = By.linkText("Dropdown");
    private By redirectLink = By.linkText("Redirect");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage open() {
        driver.get("https://the-internet.herokuapp.com/");
        return this;
    }

    public boolean isAt() {
        return driver.findElement(mainTitle).getText().equals("Welcome to the-internet");
    }

    public DropdownPage goToDropdownPage() {
        driver.findElement(dropdownLink).click();
        return new DropdownPage(driver);
    }

    public RedirectPage goToRedirectPage(){
        driver.findElement(redirectLink).click();
        return new RedirectPage(driver);
    }
}
