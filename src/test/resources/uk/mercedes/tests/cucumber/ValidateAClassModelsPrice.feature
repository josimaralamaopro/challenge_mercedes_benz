@test
Feature: Validate A Class models price

  Scenario: Validate A Class models price are between £15,000 and £60,000
    Given Open Mercedes-benz United Kingdom market
    And Under "Our models" - Select Model: "Hatchbacks"
    And Mouse over the "A-Class" model available and proceed to "Build your car"
    And Filter by Fuel type "Diesel"
    And Take and save a screenshot of the results
    And Save the value of the highest and lowest price results in a text file
    Then Close the browser