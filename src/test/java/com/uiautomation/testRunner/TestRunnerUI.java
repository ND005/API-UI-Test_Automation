package com.uiautomation.testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features", glue = {
		"com.uiautomation.stepDefintion" }, /*tags = "@testRun", */plugin = { "json:target/cucumber.json" })
public class TestRunnerUI {

}
