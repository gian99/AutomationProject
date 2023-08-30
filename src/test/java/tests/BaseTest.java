package tests;

import config.Properties;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import utils.DriverFactory;

public class BaseTest {

    private static final Logger logger = LogManager.getLogger(BaseTest.class);

    protected WebDriver driver;
    @Severity(SeverityLevel.CRITICAL)
    @Description("We set up the browser with parameters given by TestNg File")
    @BeforeMethod(alwaysRun = true)
    public void setup(){
        logger.info("Creando la Instancia del Driver usando el browser como parametro");
        DriverFactory driverFactory = DriverFactory.getInstance();
        driver = driverFactory.createDriver(Properties.getConfig().browser());
    }

    @Severity(SeverityLevel.CRITICAL)
    @Description("We close the browser")
    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        logger.info("Cerrando el browser");
        if(driver!=null){
            driver.quit();
        }
    }
}
