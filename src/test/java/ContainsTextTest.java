import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContainsTextTest extends BaseAbstarctClass{

    @DataProvider(name = "someData")
    public Object[][] someData(){
        return new Object[][]{
                {"Минск", "Египет", "11", "11 лет","7 лет", "Хургада", "Хургада, Египет" },
                {"Москва", "Турция", "8", "14 лет","5 лет", "Кемер", "Кемер, Турция"}
        };
    }

    @Test(dataProvider = "someData")
    public void testMatchRegion(String city, String country, String quantityNights, String ageChild1,
                                String ageChild2, String region, String checkRegion) throws InterruptedException {

        HomeTezPageObj homePage = new HomeTezPageObj(chromeDriver);
        SearchResultPageObj searchResult = new SearchResultPageObj(chromeDriver);

        homePage.openPageHome()
                .enterCityDeparture(city)
                .enterCountryArrival(country)
                .chooseRegionCheckBox(region)
                .openDatePicker()
                .defineDate()
                .chooseQuantityNights(quantityNights)
                .chooseQuantityPerson(ageChild1)
                .chooseQuantityPerson(ageChild2)
                .clickFind();

        Assert.assertTrue(searchResult.isAnyMatchToRegion(checkRegion));
        Assert.assertTrue(searchResult.isAllMatchToRegion(checkRegion));
    }
}

