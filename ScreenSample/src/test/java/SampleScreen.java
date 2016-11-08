import javafx.scene.control.Dialog;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by ACHU on 03/11/2016.
 */
public class SampleScreen {

        private String baseUrl;
        private WebDriver driver;
        private ScreenshotHelper screenshotHelper;

        @Before
        public void openBrowser() {
            baseUrl = System.getProperty("webdriver.base.url");
            driver = new ChromeDriver();
            driver.get(baseUrl);
            screenshotHelper = new ScreenshotHelper();
        }

        @After
        public void saveScreenshotAndCloseBrowser() throws IOException {
            screenshotHelper.saveScreenshot("screenshot.png");
            driver.quit();
        }

        @Test
        public void pageTitleAfterSearchShouldBeginWithDrupal() throws IOException {
            assertEquals("The page title should equal Google at the start of the test.", "Google", driver.getTitle());
            WebElement searchField = driver.findElement(By.name("q"));
            searchField.sendKeys("Drupal!");
            searchField.submit();


            }


}



    class ScreenshotHelper {

            public void saveScreenshot(String screenshotFileName) throws IOException {
                File screenshot;
                screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(screenshot, new File(screenshotFileName));
            }
        }







