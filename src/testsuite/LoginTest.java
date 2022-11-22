package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utility.UtilitiesMain;

public class LoginTest extends UtilitiesMain {

    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {

        sendTextToElement(By.id("username"), "tomsmith");

        sendTextToElement(By.id("password"), "SuperSecretPassword!");

        clickOnElement(By.xpath("//button[@class='radius']"));


        String expectedMessage = "Secure Area";
        String actualTextMessage = getTextFromElement(By.xpath("//h2[normalize-space()='Secure Area']"));
        //Validate actual and expected message
        Assert.assertEquals("No message found", expectedMessage, actualTextMessage);


    }

    @Test
    public void verifyTheUsernameErrorMessage() {
        sendTextToElement(By.id("username"), "tomsmith1");

        sendTextToElement(By.id("password"), "SuperSecretPassword!");

        clickOnElement(By.xpath("//button[@class='radius']"));


    }

    @Test
    public void verifyThePasswordErrorMessage() {


    }


    @After
    public void closeBrowser() {
        driver.close();


    }

}
