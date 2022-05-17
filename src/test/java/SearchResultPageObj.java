import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultPageObj {
    WebDriver driver;

    public SearchResultPageObj(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ("//div[@class='load-more']/a"))
    WebElement btnLoadElse;

    @FindBy(xpath = ("//div[@class='overflow-line']//span"))
    List <WebElement> allSearchResult;

    public boolean isAnyMatchToRegion(String region) throws InterruptedException {
        btnLoadElse.click();
        Thread.sleep(3000);
      return allSearchResult.stream().anyMatch(x->x.getText().trim().equalsIgnoreCase(region));
    }
    public boolean isAllMatchToRegion(String region) throws InterruptedException {
        Thread.sleep(3000);
        return allSearchResult.stream().allMatch(x->x.getText().trim().equalsIgnoreCase(region));
    }


}
