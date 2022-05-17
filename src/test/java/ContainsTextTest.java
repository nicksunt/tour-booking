import org.testng.Assert;
import org.testng.annotations.Test;

public class ContainsTextTest extends BaseAbstarctClass{

    @Test
    public void testMatchRegion() throws InterruptedException {
        String city = "Москва";
        String country = "Египет";
        String quantityNights = "11";
        String ageChild1 = "11 лет";
        String ageChild2 = "7 лет";
        String region ="Хургада";
        String checkRegion = region + ", " + country;

        HomeTezPageObj homePage = new HomeTezPageObj(chromeDriver);
        SearchResultPageObj searchResult = new SearchResultPageObj(chromeDriver);

        homePage.openPageHome()
                .enterCityDeparture(city)
                .enterCountryArrival(country)
                .chooseRegionCheckBox(region)
                .openDatePicker()
                .dateDeparture()
                .chooseQuantityNights(quantityNights)
                .chooseQuantityPerson(ageChild1)
                .chooseQuantityPerson(ageChild2)
                .clickFind();

        Assert.assertTrue(searchResult.isAnyMatchToRegion(checkRegion));
        Assert.assertTrue(searchResult.isAllMatchToRegion(checkRegion));
    }
}
