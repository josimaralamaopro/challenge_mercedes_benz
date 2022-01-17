package uk.mercedes.tests.pom;

import org.openqa.selenium.WebElement;
import uk.mercedes.tests.helpers.Config;
import uk.mercedes.tests.helpers.FileWriter;

import java.util.List;

import static uk.mercedes.tests.helpers.SeleniumHelper.*;

public class PassengerCarsPage {

    private final String h1TextSelector = "//h1[text()='%s']";
    private final String spanTextSelector = "//span[text()='%s']";
    private final String spanContainsTextSelector = "//span[contains(text(), '%s')]";
    private final String linkTextSelector = "//a[text()='%s']";
    private final String filterLabelSelector = "//label[contains(text(), '%s')]";
    private final String comparisonStatusSelector = "cc-motorization-comparison-status";
    private final String filterPricesSelector = ".cc-motorization-header__price";
    private Config config = new Config();
    private String RESULTS_PRINT_FILE = config.properties.getProperty("RESULTS_PRINT_FILE");
    private String HIGHEST_LOWEST_PRICES_FILE = config.properties.getProperty("HIGHEST_LOWEST_PRICES_FILE");

    /** Select model **/
    public void selectModel(String section, String modelName) {
        moveToElementViewPort(findShadowElementByXPath(String.format(h1TextSelector, section), MEDIUM_TIMEOUT));
        moveToElementAndClick(findShadowElementByXPath(String.format(spanTextSelector, modelName), MEDIUM_TIMEOUT));
    }

    /** Select model class and perform action **/
    public void selectModelAction(String className, String option) {
        moveToElement(findShadowElementByXPath(String.format(spanContainsTextSelector, className), MEDIUM_TIMEOUT));
        moveToElementAndClick(findShadowElementByXPath(String.format(linkTextSelector, option), MEDIUM_TIMEOUT));
    }

    /** Select filter **/
    public void filterBy(String value) {
        moveToElement(findShadowElement(comparisonStatusSelector, MEDIUM_TIMEOUT));
        findShadowElementByXPath(String.format(filterLabelSelector, value), MEDIUM_TIMEOUT).click();
    }

    /** Take and save a screenshot of the filter results **/
    public void filterResultsScreenShot() {
        moveToElementViewPort(findShadowElement(comparisonStatusSelector, MEDIUM_TIMEOUT));
        implicitlyWait(LOW_TIMEOUT);
        takeSnapShot(RESULTS_PRINT_FILE);
    }

    /** Save the value £ of the highest and lowest price results in a text file **/
    public void saveHighestAndLowestPriceResults() {
        double highest = 0;
        double lowest = 0;
        List<WebElement> pricesList = findShadowElements(filterPricesSelector);

        for(WebElement element : pricesList){
            String price = element.getText().substring(1).replace(",", ".");
            double value = Double.valueOf(price);
            highest = value > highest ? value : highest;
            lowest = (value < lowest) || (lowest == 0) ? value : lowest;
        }

        FileWriter.write(HIGHEST_LOWEST_PRICES_FILE, String.format("Highest: %s \nLowest: %s", highest, lowest));
    }

}
