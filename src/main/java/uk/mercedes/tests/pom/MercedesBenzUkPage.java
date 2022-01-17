package uk.mercedes.tests.pom;

import org.openqa.selenium.WebDriver;
import uk.mercedes.tests.drivers.Driver;

public class MercedesBenzUkPage {

    private static final String PAGE_URL = "https://www.mercedes-benz.co.uk";
    private WebDriver driver = Driver.getDriver();

    /**
     * Open Mercedes-benz UK page;
     */
    public void open() {
        driver.get(PAGE_URL);
        driver.manage().window().maximize();
    }

}
