package tests;

import io.qameta.allure.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HelpCenterPage;

import java.time.Duration;
import java.util.List;
import config.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Epic("Selenium using DriverFactory and extending BasePage Methods")
public class HelpCenterTest extends BaseTest {

    private static final Logger logger = LogManager.getLogger(HelpCenterTest.class);
    /*
    1. Go to https://help.salesforce.com/s/
    2. Search for term "sales" and click enter
    3. Select Documentation to filter
    4. Click on the first search result
    */
    @Severity(SeverityLevel.CRITICAL)
    @Owner("GiancarloAguado")
    @Description("This test validates the search of the term Sales, and filtering by Documentation Tab")
    @Test(groups = {"globant"})
    public void TestSalesforce(){
        logger.info("Iniciando Test de Help and Support Page de Salesforce");
        driver.get(Properties.getConfig().URL());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        HelpCenterPage helpCenterPage = new HelpCenterPage(driver);
        helpCenterPage.waitUntilElementVisible(helpCenterPage.getSearchBox());
        helpCenterPage.setText("sales");
        helpCenterPage.search();
        helpCenterPage.clickDocumentationTab();
        List<WebElement> resultList = helpCenterPage.getResultList();
        resultList.get(0).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        helpCenterPage.waitUntilElementVisible(helpCenterPage.getSearchPageTittle());
        Assert.assertTrue(helpCenterPage.isElementVisible(helpCenterPage.getSearchPageTittle()));
        Assert.assertEquals(driver.getTitle(),"Sales Engagement");
        logger.info("Finalizando Test de Help and Support Page de Salesforce");

    }
}
