package gm.taltech.ee.selenium;
import gm.taltech.ee.page_object.RedirectPage;
import gm.taltech.ee.selenium.common.SeleniumTest;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RedirectTest extends SeleniumTest {


    @Test
    public void RedirectPageCase(){
        RedirectPage redirectPage = homePage.goToRedirectPage();

        // Test 1: Is it directed correctly
        assertThat(redirectPage.isAt(), is(true));

        //Test2: Is header correct
        assertThat(redirectPage.isHeaderCorrect(), is(true));

        //Test3: Is status 200
        assertThat(redirectPage.isStatus200Correct(), is(true));

        //Test4: Is status 404
        assertThat(redirectPage.isStatus404Correct(), is(true));



    }

}
