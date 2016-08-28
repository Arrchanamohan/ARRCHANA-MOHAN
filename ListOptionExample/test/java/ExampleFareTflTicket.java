import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import static org.junit.Assert.assertTrue;

/**
 * Created by ACHU on 28/01/2016.
 */
public class ExampleFareTflTicket {
    @Test
    public void testSingleFareFinder() throws Exception {


        WebDriver driver = new FirefoxDriver()
;        driver.get("http://www.google.com");
        driver.get("https://tfl.gov.uk/fares-and-payments/fares/single-fare-finder");

        //Enter the From station
        String fromStation = "victoria";
        WebElement fromStationElement = driver.findElement(By.id("From"));
        fromStationElement.sendKeys(fromStation);
        Thread.sleep(3000);
        List<WebElement> optionsToSelect = driver.findElements(By.cssSelector(".tt-dataset-stop-points-search-from .tt-suggestion"));


        for(WebElement option : optionsToSelect){
            if(option.getText().trim().toLowerCase().startsWith(fromStation.toLowerCase())) {
                System.out.println("Trying to select: "+fromStation + " " +option.getText().toLowerCase());
                fromStationElement.sendKeys(Keys.ARROW_DOWN);
                fromStationElement.sendKeys(Keys.ENTER);
                break;
            }
        }


        //Enter the To Station
        String toStation = "Richmond";
        WebElement toStationElement = driver.findElement(By.id("To"));
        toStationElement.sendKeys(toStation);
        Thread.sleep(2000);

        List<WebElement> toStationOptionsToSelect = driver.findElements(
                By.cssSelector(
                        ".tt-dataset-stop-points-search-to .tt-suggestion"));

        for(WebElement option : toStationOptionsToSelect){
            if(option.getText().trim().toLowerCase().startsWith(toStation.toLowerCase())) {
                System.out.println("Trying to select: "+toStation + " " +option.getText().toLowerCase());
                toStationElement.sendKeys(Keys.ARROW_DOWN);
                toStationElement.sendKeys(Keys.ENTER);
                break;
            }
        }

        //Submit the Fare Element
        WebElement submitElement = driver.findElement(By.id("submit"));
        submitElement.submit();

        //Fares Results
        WebElement faresResults = driver.findElement(By.id("results"));
        System.out.printf("fares results "+faresResults.getText());
        assertTrue(faresResults.isDisplayed());




    }


}

