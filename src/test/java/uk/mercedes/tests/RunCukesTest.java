package uk.mercedes.tests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"uk.mercedes.tests.steps"},
        strict = true,
        tags = {"@test"},
        plugin = {
                "pretty",
                "json:target/public/report/json/cucumber-json-report.json",
                "html:target/public/report/html",
                "junit:target/public/report/junit"
        }
)
public class RunCukesTest { }
