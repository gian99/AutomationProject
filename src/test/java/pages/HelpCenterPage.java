package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class HelpCenterPage extends BasePage {

    /*
   1. Go to https://help.salesforce.com/s/
   2. Search for term "sales" and click enter
   3. Select Documentation to filter
   4. Click on the first search result

   */

    @FindBy(xpath = "//div[contains(@class,'CoveoStandaloneSearchbox')]//input")
    private WebElement searchBox;

    @FindBy(xpath = "//button[contains(@id,'documentationTab')]")
    private WebElement documentationTab;

    @FindBy(xpath = "//div[contains(@class,'CoveoResult')]//a[contains(@class,'CoveoResultLink')]")
    private List<WebElement> resultList;

    @FindBy(xpath = "//c-hc-documentation-article//div[contains(@id,'content')]//h1")
    private WebElement SearchPageTittle;

    public HelpCenterPage(WebDriver driver) {
        super(driver);
    }

    public void setText( String text){
        searchBox.sendKeys(text);
    }
    public void search(){
        searchBox.sendKeys(Keys.ENTER);
    }
    public void clickDocumentationTab(){
        documentationTab.click();
    }
    public List<WebElement> getResultList(){
        return resultList;
    }
    public WebElement getSearchPageTittle(){
        return SearchPageTittle;
    }
    public WebElement getSearchBox(){
        return searchBox;
    }
}
