package com.github.verhagen.mrrs.it;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = { "html:target/cucumber/report.html", "json:target/cucumber-report.json" }, 
		features = { "src/bdd/resources/" },
		tags = { "@run" })
public class RunCucumberTests {
	// No implementation required
}
