package com.bestbuy.cucumber.steps;

import com.bestbuy.info.StoreSteps;
import com.bestbuy.utils.TestUtils;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

public class StoreStepdefs {

    static ValidatableResponse response;

    static int storeID;

    static String name = null;

    @Steps
    StoreSteps storeSteps;
    @When("^User sends a Get request to store endpoint$")
    public void userSendsAGetRequestToStoreEndpoint() {
        response = storeSteps.getAllStoresInfo();
            }

    @Then("^User must get back a valid status code 200$")
    public void userMustGetBackAValidStatusCode() {
        response.statusCode(200);
    }




        @When("^I create a new store by providing the information name \"([^\"]*)\" type \"([^\"]*)\" address \"([^\"]*)\" address(\\d+) \"([^\"]*)\" city \"([^\"]*)\" state \"([^\"]*)\" zip \"([^\"]*)\" lat \"([^\"]*)\" lng \"([^\"]*)\" hours \"([^\"]*)\"$")
    public void iCreateANewStoreByProvidingTheInformationNameTypeAddressAddressCityStateZipLatLngHours(String _name, String type, String address, String address2, String city, String state, String zip, double lat, double lng, String hours) {

        name = TestUtils.getRandomValue()+ _name;
        response = storeSteps.createStore(name,type,address,address2, city,state,zip,lat,lng,hours);



    }

    @Then("^I verify that the store with \"([^\"]*)\" is created$")
    public void iVerifyThatTheStoreWithIsCreated(String field)  {
        response.statusCode(201);

        HashMap<String, Object> storeMap = storeSteps.getStoreInfoByStoreName(name);
        storeID = (int) storeMap.get("id");
        Assert.assertThat(storeMap, hasValue(name));


    }
}
