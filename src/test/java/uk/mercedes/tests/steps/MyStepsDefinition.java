package uk.mercedes.tests.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import uk.mercedes.tests.drivers.Driver;
import uk.mercedes.tests.pom.CookiesPolicyPage;
import uk.mercedes.tests.pom.MercedesBenzUkPage;
import uk.mercedes.tests.pom.PassengerCarsPage;

public class MyStepsDefinition {

    MercedesBenzUkPage mercedesUk = new MercedesBenzUkPage();
    PassengerCarsPage passengerCarsPage = new PassengerCarsPage();
    CookiesPolicyPage cookiesPolicy = new CookiesPolicyPage();

    @Given("^Open Mercedes-benz United Kingdom market$")
    public void openMercedesBenzUnitedKingdomMarket() {
        mercedesUk.open();
        cookiesPolicy.acceptAll();
    }

    @And("^Under \"(.*)\" - Select Model: \"(.*)\"$")
    public void underOurModelsSelectModel(String section, String model) {
        passengerCarsPage.selectModel(section, model);

    }

    @And("^Mouse over the \"(.*)\" model available and proceed to \"(.*)\"$")
    public void mouseOverTheModelAvailableAndProceedTo(String className, String action) {
        passengerCarsPage.selectModelAction(className, action);
    }

    @And("^Filter by Fuel type \"(.*)\"$")
    public void filterByFuelType(String value) {
        passengerCarsPage.filterBy(value);
    }

    @And("^Take and save a screenshot of the results$")
    public void takeAndSaveScreenshotOfTheResults() {
        passengerCarsPage.filterResultsScreenShot();
    }

    @And("^Save the value of the highest and lowest price results in a text file$")
    public void saveTheValueOfTheHighestAndLowestPriceResultsInATextFile() {
        passengerCarsPage.saveHighestAndLowestPriceResults();
    }

    @And("^Close the browser$")
    public void closeBrowser() {
        Driver.getDriver().close();
    }
}
