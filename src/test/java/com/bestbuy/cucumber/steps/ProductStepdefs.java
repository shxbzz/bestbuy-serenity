package com.bestbuy.cucumber.steps;

import com.bestbuy.info.ProductSteps;
import com.bestbuy.utils.TestUtils;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.ValidatableResponse;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

public class ProductStepdefs {

    static ValidatableResponse response;

    static int productID;



    @Steps
    ProductSteps productSteps;

    @When("^User sends a Get request to product endpoint$")
    public void userSendsAGetRequestToProductEndpoint() {
       // response = productSteps.getProduct(int productID);
    }

    @Then("^User must get back a valid status code 200$")
    public void userMustGetBackAValidStatusCode() {
        response.statusCode(200);
    }

    @When("^I create a new product by providing information name \"([^\"]*)\" type \"([^\"]*)\" price \"([^\"]*)\" shipping \"([^\"]*)\" upc \"([^\"]*)\" description \"([^\"]*)\" manufacture \"([^\"]*)\" model \"([^\"]*)\" url\"([^\"]*)\" image \"([^\"]*)\"$")
    public void iCreateANewProductByProvidingInformationNameTypePriceShippingUpcDescriptionManufactureModelUrlImage(String name, String type, Double price, int shipping, String upc, String description, String manufacture, String model, String url, String image)  {

        //productID = TestUtils.getRandomValue()+ productID;
       response = productSteps.createProduct(name,type,price,shipping,upc,description,manufacture,model,url,image);

    }

    @Then("^I verify that the product with \"([^\"]*)\" is created$")
    public void iVerifyThatTheProductWithIsCreated(String arg0)  {
        response.statusCode(200);

    }

    @Given("^Product Information is running$")
    public void productInformationIsRunning() {
    }

    @And("^I update the product with information productID \"([^\"]*)\"  name \"([^\"]*)\" type \"([^\"]*)\" price \"([^\"]*)\" shipping \"([^\"]*)\" upc \"([^\"]*)\" description \"([^\"]*)\" manufacture \"([^\"]*)\" model \"([^\"]*)\" url\"([^\"]*)\" image \"([^\"]*)\"$")
    public void iUpdateTheProductWithInformationProductIDNameTypePriceShippingUpcDescriptionManufactureModelUrlImage(int productID, String name, String type, Double price, int shipping, String upc, String description, String manufacture, String model, String url, String image)  {
        name =name+"_updated";
        response = productSteps.updateProduct(productID,name,type,price,shipping,upc,description,manufacture,model,url,image);
    }

    @And("^The product with productID \"([^\"]*)\" is updated successfully$")
    public void theProductWithProductIDIsUpdatedSuccessfully(String name)  {
        HashMap<String, Object> productMap = productSteps.getProductIndoByProductName(productID);
        Assert.assertThat(productMap, hasValue(productID));

    }

    @And("^I delete the product that created with productID \"([^\"]*)\"$")
    public void iDeleteTheProductThatCreatedWithProductID(String name)  {
        response = productSteps.deleteProduct(productID);

    }

    @Then("^The product deleted successfully from the product information$")
    public void theProductDeletedSuccessfullyFromTheProductInformation() {
        response.statusCode(200);
        productSteps.deleteProduct(productID).statusCode(404);
    }
}

