package tests;

import DataProvider.Dataproviders;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import org.apache.http.HttpStatus;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;
public class FetchingWeather extends BaseUtil {
    /***
     * GET Request: /weather?q={city name}&appid={api key}
     * Response: JSON format using given- All input details
     * when-Submit the API
     * then-Validate the response
     */
String validcityname;
    int validcityId;
    @Test(dataProviderClass = Dataproviders.class ,dataProvider = "CityName")
    public void searchByCityName(String CityName) {
        validcityname=CityName;
        setUp();
        given().log().all()
                .queryParam("q", CityName)
                .queryParam("appid", API_KEY)
                .when()
                .get("/data/2.5/weather")
                .then().log().all()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("name", equalTo(CityName));
    }
//https://api.openweathermap.org/data/2.5/weather?q=Johannesburg&appid=0aa1b4fa9c363a28d8d3d146b2202196
    /**
     * GET Request: /weather?id={city id}&appid={api key}
     * Response: JSON format
     */
    
    @Test(dataProviderClass = Dataproviders.class ,dataProvider = "CityId")
    public void searchByCityID(int CityID) {
        validcityId=CityID;
        setUp();
        given()
                .accept(ContentType.JSON)
                .queryParam("id", CityID)
                .queryParam("appid", API_KEY)
                .when()
                .get("/data/2.5/weather")
                .then().log().all()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("id", equalTo(CityID));
    }
    @Test(dataProviderClass = Dataproviders.class ,dataProvider = "Coordinates")
    public void searchByGeographicalLocation(int lon, int lat) {
        setUp();
        given()
                .accept(ContentType.JSON)
                .queryParam("lon", lon)
                .queryParam("lat",lat)
                .queryParam("appid", API_KEY)
                .when()
                .get("/data/2.5/weather")
                .then().log().all()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("lon", equalTo(lat))
                .body("lat", equalTo(lon));
    }
    @Test(dataProviderClass = Dataproviders.class ,dataProvider = "ZipCode")
    public void searchByZipCode(int ZipCode,String Country) {
        setUp();
        given()
                .accept(ContentType.JSON)
                .queryParam("id", ZipCode)
                .queryParam("Country",Country)
                .queryParam("appid", API_KEY)
                .when()
                .get("/data/2.5/weather")
                .then().log().all()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("id", equalTo(ZipCode))
                .body("country", equalTo(Country));
    }

//NegativeTest
    @Test(dataProviderClass = Dataproviders.class ,dataProvider = "InvalidCityName")
    public void searchByInvalidCityName(String WrongCityName) {
        setUp();
        given().log().all()
                .queryParam("q", WrongCityName)
                .queryParam("appid", API_KEY)
                .when()
                .get("/data/2.5/weather")
                .then().log().all()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("name", equalTo(validcityname));
    }
    //NegativeTest
    @Test(dataProviderClass = Dataproviders.class ,dataProvider = "InvalidCityId")
    public void searchByInvalidCityId(String WrongCityId) {
        setUp();
        //basePath="/api";
        given().log().all()
                .queryParam("q", WrongCityId)
                .queryParam("appid", API_KEY)
                .when()
                .get("/data/2.5/weather")
                .then().log().all()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("name", equalTo(validcityId));
    }
}
