package ru.stqa.pft.sopa;

import com.lavasoft.GeoIPService;
import com.lavasoft.GetCountryISO2ByName;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GeoIpServiceTests {

    @Test
    public void myIpTest() {
        String countryISO2ByName = new GeoIPService().getGeoIPServiceSoap12().getCountryISO2ByName("RUS");
        Assert.assertEquals(countryISO2ByName, "RUS");
    }
}
