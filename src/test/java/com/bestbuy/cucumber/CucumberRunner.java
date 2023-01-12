package com.bestbuy.cucumber;

import com.bestbuy.testbase.TestBase;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

/**
 * Created by Jay
 */
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/java/resources/feature/product.feature/")
//@CucumberOptions(features = "src/test/java/resources/feature/store.feature/")

public class CucumberRunner extends TestBase {



}
