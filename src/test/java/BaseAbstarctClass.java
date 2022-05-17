import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseAbstarctClass {


        WebDriver chromeDriver;

        @BeforeTest
        public  void openChrome() {
            chromeDriver = new ChromeDriver();
            chromeDriver.manage().window().maximize();
        }

        @AfterTest
        public  void closeDriver() {
            chromeDriver.quit();
        }
    }

