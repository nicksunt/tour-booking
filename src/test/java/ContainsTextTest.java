import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;
import static org.testng.AssertJUnit.assertEquals;

public class ContainsTextTest extends BaseAbstarctClass{

    @Test
    public void testMatchRegion() throws InterruptedException {
        String city = "Москва";
        String country = "Египет";
        String quantityNights = "11";
        String ageChild1 = "11 лет";
        String ageChild2 = "7 лет";
        String region ="Хургада, Египет";

        HomeTezPageObj homePage = new HomeTezPageObj(chromeDriver);
        SearchResultPageObj searchResult = new SearchResultPageObj(chromeDriver);

        homePage.openPageHome()
                .enterCityDeparture(city)
                .enterCountryArrival(country)
                .clickCheckBoxHurgada()
                .openDatePicker()
                .dateDeparture()
                .chooseQuantityNights(quantityNights)
                .chooseQuantityPerson(ageChild1)
                .chooseQuantityPerson(ageChild2)
                .clickFind();

        Assert.assertTrue(searchResult.isAnyMatchToRegion(region));
        Assert.assertTrue(searchResult.isAllMatchToRegion(region));

    }
}

