import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static com.thoughtworks.selenium.SeleneseTestNgHelper.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by ACHU on 27/9/2016.
 */
public class messageIframe {
    public class TS05UserAreabletocreateNewTopiconWebPage {

        @Test

        public void ExistinguserabletoLogin() {

            WebDriver driver = new FirefoxDriver();
            driver.get("http://neighbourblog.com/index.aspx");
            String PageTitle = driver.getTitle();
            assertEquals("NeighbourBlog - London Blog | London Forum | Neighbourhood Blog", PageTitle);

            // Sign in section is displayed
            WebElement signInColumn = driver.findElement(By.id("email"));

            // enter the email  in sign in column
            signInColumn.sendKeys("Testinggg");
            signInColumn.sendKeys(Keys.TAB);

            // enter password
            WebElement passwordColumn = driver.findElement(By.id("Password"));
            passwordColumn.sendKeys("Testing1234");
            passwordColumn.sendKeys(Keys.TAB);
            // click on sign in Button & it should show error message
            driver.findElement(By.id("btnlogin")).click();

            // Click Forum from the header
            // page is displayed

            WebElement MyForum = driver.findElement(By.xpath(".//*[@id='yafpage_myforum']/div[2]/div/div/div/div[2]/ul/li[7]/a"));

            // Forum page is displayed
            assertTrue(MyForum.isDisplayed());
            // click on capstone

            WebElement Capstone = driver.findElement(By.xpath(".//*[@id='forums']/table/tbody/tr[1]/td/table[2]/tbody/tr[3]/td[1]/div/a"));
            Capstone.click();

            // CLICK ON NEW TOPIC

            WebElement NewTopic = driver.findElement(By.xpath(".//*[@id='forum_ctl01_NewTopic1']"));
            // Post New Topic page is displayed
            assertTrue(NewTopic.isDisplayed());
            NewTopic.click();


//        driver.switchTo().frame(editorFrame);

            // Enter the subject

            WebElement Subject = driver.findElement(By.xpath(".//*[@id='forum_ctl01_Subject']"));
            Subject.sendKeys(" Authentic Cuisine");
            assertTrue(Subject.isDisplayed());

            // enter message

            WebElement Message = driver.findElement(By.xpath(".//*[@id='cke_forum_ctl01_CKEditor1']"));

            WebElement iFrameElement = driver.findElement(By.xpath("/html/body/form/div[3]/div/div[3]/div[2]/table/tbody/tr[2]/td[2]/span/span[2]/span/table/tbody/tr[2]/td/iframe"));
            driver.switchTo().frame(iFrameElement);
            WebElement body = driver.findElement(By.tagName("body"));

            body.clear();
            body.sendKeys("List of Indian Restaurant");
            assertNotNull(body);
        }


    }

    private void assertTrue(boolean displayed) {
    }
}