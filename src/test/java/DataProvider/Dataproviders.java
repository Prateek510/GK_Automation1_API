package DataProvider;
import org.testng.annotations.DataProvider;
public class Dataproviders {
    @DataProvider(name = "CityName")
    public static Object[][] cityName() {
        return new Object[][] {{"Johannesburg"}};
    }

    @DataProvider(name = "CityId")
    public static Object[][] cityID() {
        return new Object[][] {{993800}};
    }

    @DataProvider(name = "Coordinates")
    public static Object[][] GeographicCoordinates() {
        return new Object[][] {{31.0292, -29.8579}};
    }

    @DataProvider(name = "ZipCode")
    public static Object[][] ZipCode() {
        return new Object[][] {{993800, "ZA"}};
    }
    @DataProvider(name = "InvalidCityName")
    public static Object[][] InvalidCityName() {
        return new Object[][] {{"Job"}};
    }
    @DataProvider(name = "InvalidCityId")
    public static Object[][] InvalidCityId() {
        return new Object[][] {{93800}};
    }

}
