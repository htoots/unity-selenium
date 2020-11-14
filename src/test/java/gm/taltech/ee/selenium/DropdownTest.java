package gm.taltech.ee.selenium;

import gm.taltech.ee.page_object.DropdownPage;
import gm.taltech.ee.selenium.common.SeleniumTest;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DropdownTest extends SeleniumTest {

    // Case 1
    @Test
    public void DropdownPageCase() {

        DropdownPage dropdownPage = homePage.goToDropdownPage();

        // Test 1: Page loads and contains necessary information (dropdown)
        assertThat(dropdownPage.isAt(), is(true));

        // Test 2: Dropdown holds expected information
        assertThat(dropdownPage.optionsExist(), is(true));

        // Test 3: Able to click on both dropdown options
        assertThat(dropdownPage.chooseOption("Option 1"), is("Option 1"));
        assertThat(dropdownPage.chooseOption("Option 2"), is("Option 2"));

        // Test 4: Unable to click on placeholder option, value from before is retained
        assertThat(dropdownPage.chooseOption("Please select an option"), is("Option 2"));
    }
    
}
