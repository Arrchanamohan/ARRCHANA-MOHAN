import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by ACHU on 17/06/2016.
 */
public class LoginRegist {

    @Test
    public void testUserRegistration() throws Exception {

        WebDriver driver = new FirefoxDriver();
        driver.get("http://neighbourblog.com/londonforum.aspx?g=register");

        WebElement userName = driver.findElement(By.id("forum_ctl01_CreateUserWizard1_CreateUserStepContainer_UserName"));
        userName.sendKeys("Testinggg");
        WebElement passWord = driver.findElement(By.xpath("//*[@id=\"forum_ctl01_CreateUserWizard1_CreateUserStepContainer_Password\"]"));
        passWord.click();
        passWord.sendKeys("Testing1234");
        passWord.sendKeys(Keys.TAB);
        Thread.sleep(3000);
        WebElement confirmPassword = driver.findElement(By.id("forum_ctl01_CreateUserWizard1_CreateUserStepContainer_ConfirmPassword"));
        confirmPassword.click();
        confirmPassword.sendKeys("Testing1234");
        confirmPassword.sendKeys(Keys.TAB);
        Thread.sleep(3000);
        WebElement email = driver.findElement(By.id("forum_ctl01_CreateUserWizard1_CreateUserStepContainer_Email"));
        email.sendKeys("Testing1234@gmail.com");

        Thread.sleep(10000);
        //Now Enter the Captcha Manually

        WebElement select = driver.findElement(By.name("forum$ctl01$CreateUserWizard1$CreateUserStepContainer$hearabout"));
        Select dropDown = new Select(select);
        List<WebElement> options = dropDown.getOptions();
        options.get(2).click();

        //Submit
        WebElement register = driver.findElement(By.id("forum_ctl01_CreateUserWizard1_CreateUserStepContainer_StepNextButton"));
        register.submit();


    }

}