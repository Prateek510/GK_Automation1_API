package tests;

//import api.openweathermap.commom.Configuration;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

import java.lang.module.Configuration;

import static io.restassured.RestAssured.enableLoggingOfRequestAndResponseIfValidationFails;


public class BaseUtil {
    protected static final String API_KEY = "0aa1b4fa9c363a28d8d3d146b2202196";

    @BeforeClass
    public void setUp() {
        RestAssured.baseURI = "https://api.openweathermap.org";
        enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
