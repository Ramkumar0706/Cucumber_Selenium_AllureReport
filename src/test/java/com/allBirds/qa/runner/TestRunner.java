package com.allBirds.qa.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features", 
    glue = {"com.allBirds.qa.stepDefinitions"}, 
    plugin = {"html:target/cucumber-reports.html","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}, 
    monochrome = true
//    ,tags = "@CartFeature"
//    ,tags = "@SignupFeature"
//    ,tags = "@LoginFeature"
  
)
public class TestRunner {
}

