package testsuite;

/**
 * 3. Write down the following test into ‘LoginTest’ class
 * 1. userSholdLoginSuccessfullyWithValidCredentials
 * * Enter “tomsmith” username
 * * Enter “SuperSecretPassword!” password
 * * Click on ‘LOGIN’ button
 * * Verify the text “Secure Area”
 * 2. verifyTheUsernameErrorMessage
 * * Enter “tomsmith1” username
 * * Enter “SuperSecretPassword!” password
 * * Click on ‘LOGIN’ button
 * * Verify the error message “Your username
 * is invalid!”
 * 3. verifyThePasswordErrorMessage
 * * Enter “tomsmith” username
 * * Enter “SuperSecretPassword” password
 * * Click on ‘LOGIN’ button
 * * Verify the error message “Your password
 * is invalid!”
 */

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUpUrl() {

        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {

        //Find 'Username' element and enter valid username in 'Username' field
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        //Find 'Password' element and enter valid password in 'Password' field
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        //Find 'LOGIN' button element and click on 'LOGIN' button
        driver.findElement(By.xpath("//button[@type = 'submit']")).click();
        //Verify the text 'Secure Area'
        String expectedText = "Secure Area";
        String actualText = driver.findElement(By.tagName("h2")).getText();
        Assert.assertEquals("'Secure Area' text not verified", expectedText, actualText);
    }

    @Test
    public void verifyTheUserNameErrorMessage() {

        //Find 'Username' element and enter invalid username in 'Username' field
        driver.findElement(By.id("username")).sendKeys("tomsmith1");
        //Find 'Password' element and enter valid password in 'Password' field
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        //Find 'LOGIN' button element and click on 'LOGIN' button
        driver.findElement(By.xpath("//button[@type = 'submit']")).click();
        //Verify error message "Your username is invalid!"
        String expectedText = "Your username is invalid!\n" + "×";
        String actualText = driver.findElement(By.xpath("//div[1]/div/div|/text()")).getText();
        Assert.assertEquals("'Your username is invalid!' text not correct.", expectedText, actualText);
    }

    @Test
    public void verifyThePasswordErrorMessage() {

        //Find 'Username' element and enter valid username in 'Username' field
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        //Find 'Password' element and enter invalid password in 'Password' field
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");
        //Find 'LOGIN' button element and click on 'LOGIN' button
        driver.findElement(By.xpath("//button[@type = 'submit']")).click();
        //Verify error message "Your password is invalid!"
        String expectedText = "Your password is invalid!\n" +"×";
        String actualText = driver.findElement(By.xpath("//div[1]/div/div|/text()")).getText();
        Assert.assertEquals("'Your password is invalid!' text not correct.", expectedText, actualText);
    }



    @After
    public void tearDown() {

        closeBrowser();
    }


}
