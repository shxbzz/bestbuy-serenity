package com.bestbuy.bestbuyinfo;

import com.bestbuy.info.StoreSteps;
import com.bestbuy.testbase.TestBase;
import com.bestbuy.utils.TestUtils;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

//@RunWith(SerenityRunner.class)
public class StoreCRUDTestWithSteps extends TestBase {



        static String name = "Shubh" + TestUtils.getRandomValue();
        static String type = "Bum" + TestUtils.getRandomValue();
        static String address = "12003 Ridgeback";
        static String address2 ="Hunch";
        static String city = "London";
        static String state = "GB";
        static String zip = "29992";
        static double lat = 44.969658;
        static double lng = -93.449539;
        static String hours = " Mon: 10-9; Tue: 10-9; Wed: 10-9; Thurs: 10-9; Fri: 10-9; Sat: 10-9";
        static int storeID;

        @Steps
        StoreSteps storeSteps;

        @Title("This will create new product")
        @Test
        public void test001() {
            ValidatableResponse response = storeSteps.createStore(name, type, address, address2, city, state,zip,lat,lng,hours);
            response.log().all().statusCode(201);
            storeID = response.log().all().extract().path("id");

        }

        @Title("Verify if the product was added to application")
        @Test
        public void test002() {
            HashMap<String, Object> storeMap = storeSteps.getStoreInfoByStoreID(storeID);
            Assert.assertThat(storeMap, hasValue(name));
        }

        @Title("This will update product")
        @Test
        public void test003() {
            name = name + "_Updated";

            storeSteps.updateStore(storeID,name, type, address, address2, city, state,zip,lat,lng,hours);

            HashMap<String, Object> storeMap = storeSteps.getStoreInfoByStoreID(storeID);
            Assert.assertThat(storeMap, hasValue(name));
        }

        @Title("This will delete product")
        @Test
        public void test004() {

            storeSteps.deleteStoreByID(storeID).statusCode(200);
            storeSteps.getStoreById(storeID).statusCode(404);
        }


    }
