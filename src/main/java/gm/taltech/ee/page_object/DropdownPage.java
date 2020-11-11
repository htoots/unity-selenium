package gm.taltech.ee.page_object;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DropdownPage {

    private WebDriver driver;
    private By dropdown = By.id("dropdown");
    private By mainTitle = By.tagName("h3");

    public DropdownPage(WebDriver driver) {this.driver = driver;}

    public boolean isAt()  {
        return driver.findElement(mainTitle).getText().equals("Dropdown List");
    }

    public boolean optionsExist() {

        List<String> expectedList = new ArrayList<>();
        expectedList.add("Please select an option");
        expectedList.add("Option 1");
        expectedList.add("Option 2");

        return new Select(driver.findElement(dropdown))
                .getOptions()
                .stream()
                .map(e -> e.getText())
                .collect(Collectors.toList())
                .equals(expectedList);
    }

    public String chooseOption(String value) {
        Select selector = new Select(driver.findElement(dropdown));
        selector.selectByVisibleText(value);

        return selector.getFirstSelectedOption().getText();
    }
}
