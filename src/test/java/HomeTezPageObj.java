import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class HomeTezPageObj {
    private final String URL_HOMEPAGE = "https://tourist.teztour.by";

    WebDriver driver;

    @FindBy(xpath = ("//div[@class='checked-place']"))
    WebElement fieldChoicePlaceDeparture;

    @FindBy(xpath = ("//div[@class='place-list-item']//div[@class='name']"))
    List <WebElement> fieldsCitiesDeparture;

    @FindBy(xpath = ("//div/label[text()='Куда:']/ancestor::div[1]//input[@class='search-field-input']"))
    WebElement fieldChoicePlaceArrival;

    @FindBy(xpath = ("//div[@class='popular-items ref-items-def category-box']//div[@class='name']"))
    List <WebElement> fieldsCountryArrival;

    @FindBy(xpath = ("//div[@class='select_container calendar-container in']/input"))
    WebElement fieldOpenDatePicker;

    @FindBy(xpath = ("//table[@class='month1']//th[@class='month-name']"))
    WebElement monthName;

    @FindBy(xpath = ("//table[@class='month2']//span[@class='next']"))
    WebElement btnForward;

    @FindBy(xpath = ("//table[@class='month1']//div[@class='day toMonth  valid']"))
    List <WebElement> allDayOfMonth;

    @FindBy(xpath =("//span[@class='nights-text']"))
    WebElement btnQuantityNights;

    @FindBy(xpath = ("//span[@class='nights-range-picker-num']"))
    List <WebElement> choiceQuantityNights;

    @FindBy(xpath =("//div[@class = 'quest ']/div[1]"))
    WebElement btnQuantityPerson;

    @FindBy(xpath =("//li[@class='add_kid']/select"))
    WebElement btnAddChildren;

    @FindBy(xpath = ("//li[@class='add_kid']/select/option"))
    List <WebElement> choiceAgeChild;

    @FindBy(xpath =("//button[@class='button progress-button']"))
    WebElement btnFind;

    @FindBy(xpath = ("//div[@class='column-content f-box']//div[@class='input-clear-box']/input"))
    WebElement fieldEnterRegion;

    @FindBy(xpath = ("//input[@name='regions[]']//ancestor::div[@class='check-field']/label"))
    List <WebElement> listRegion;

    @FindBy(xpath = ("//table[@class='month1']//div[1]/span[@class='flight-date']"))
    WebElement numberFirstValidFlightDate;


    public HomeTezPageObj (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public HomeTezPageObj openPageHome() {
        driver.get(URL_HOMEPAGE);
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions
                        .presenceOfElementLocated(By.xpath("//div[@class='checked-place']")));
        return this;
    }
    public HomeTezPageObj enterCityDeparture(String city) throws InterruptedException {
        fieldChoicePlaceDeparture.click();
        Thread.sleep(2000);
        fieldsCitiesDeparture.stream()
                .filter(x->x.getText().equalsIgnoreCase(city))
                .findFirst().get().click();
        Thread.sleep(2000);
        return this;
    }
    public HomeTezPageObj enterCountryArrival(String country) throws InterruptedException {
        fieldChoicePlaceArrival.click();
        Thread.sleep(4000);
        fieldsCountryArrival.stream()
                .filter(x->x.getText().trim().equalsIgnoreCase(country))
                .findFirst().get().click();
        Thread.sleep(2000);
        return this;
    }

    public HomeTezPageObj openDatePicker() throws InterruptedException {
        fieldOpenDatePicker.click();
        Thread.sleep(3000);
        return this;
    }

    public HomeTezPageObj chooseQuantityNights(String quantity) throws InterruptedException {
        btnQuantityNights.click();
        choiceQuantityNights.stream()
                .filter(x->x.getText().trim().equalsIgnoreCase(quantity))
                .findFirst()
                .get()
                .click();
        Thread.sleep(1000);
        return this;
    }
    public HomeTezPageObj chooseQuantityPerson(String age) throws InterruptedException {
        btnQuantityPerson.click();
        btnAddChildren.click();
        choiceAgeChild.stream()
                .filter(x->x.getText().trim().equalsIgnoreCase(age))
                .findFirst()
                .get()
                .click();
        Thread.sleep(1000);
        return this;
    }
    public HomeTezPageObj clickFind() throws InterruptedException {
        btnFind.click();
        Thread.sleep(10000);
        return this;
    }

    public HomeTezPageObj chooseRegionCheckBox(String region){
        fieldEnterRegion.click();
        fieldEnterRegion.sendKeys(region);
        listRegion.stream()
                .filter(x->x.getText().trim().equalsIgnoreCase(region))
                .findFirst()
                .get()
                .click();
        return this;
    }

    public HomeTezPageObj defineDate() throws InterruptedException {
        String[] dateString = monthName.getText().split(" ");
        int count = 0;
        DateToday dateToday = new DateToday();

        if((Integer.parseInt(dateString[1]) == dateToday.year && MonthToNumber.getNumberMonth(dateString[0]) > dateToday.monthNumber)) {
            numberFirstValidFlightDate.click();
            Thread.sleep(2000);
            return this;
        }
        else if(Integer.parseInt(dateString[1]) < dateToday.year && MonthToNumber.getNumberMonth(dateString[0]) > dateToday.monthNumber) {
            count = dateToday.monthNumber - MonthToNumber.getNumberMonth(dateString[0]) + 12;
            System.out.println(count);
            while (count != 0) {
                btnForward.click();
                Thread.sleep(3000);
                count--;
            }
        }
        else if(Integer.parseInt(dateString[1]) < dateToday.year && MonthToNumber.getNumberMonth(dateString[0]) < dateToday.monthNumber) {
            count = dateToday.monthNumber - MonthToNumber.getNumberMonth(dateString[0]) + 12;
            System.out.println(count);
            while (count != 0) {
                btnForward.click();
                Thread.sleep(3000);
                count--;
            }
        }
        else if (MonthToNumber.getNumberMonth(dateString[0]) < dateToday.monthNumber  && Integer.parseInt(dateString[1]) == dateToday.year ) {
            count = dateToday.monthNumber-MonthToNumber.getNumberMonth(dateString[0]);
            System.out.println(count);
            while (count != 0) {
                btnForward.click();
                Thread.sleep(3000);
                count--;
            }
        }
        allDayOfMonth.stream()
                .filter(x -> x.getText().equals(dateToday.numberDayNow))
                .findFirst()
                .get()
                .click();

        Thread.sleep(2000);
        return this;
    }
}
































