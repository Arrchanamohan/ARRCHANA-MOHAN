import org.junit.*;
import org.openqa.selenium.*;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.After;
import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;

openqa.selenium.firefox.FirefoxDriver;


/**
 * Created by ACHU on 09/01/2017.
 */
public class webDriver {
    private WebDriver driver;
    private String baseUrl="";
    private StringBuffer verificationErrors = new StringBuffer();



    @Test
    public void testSearchExportedFromIDE() throws Exception {
        driver.get("/");
        driver.findElement(By.id("sted")).clear();
        driver.findElement(By.id("sted")).sendKeys("Stockholm");
        driver.findElement(By.id("queryknapp")).click();
        driver.findElement(By.xpath("//div[@id='directories']/table/tbody/tr/td[2]/a")).click();
        driver.findElement(By.cssSelector("li")).click();
        assertEquals("Weather forecast forStockholm (Sweden)", driver.findElement(By.cssSelector("h1")).getText());
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}


}
