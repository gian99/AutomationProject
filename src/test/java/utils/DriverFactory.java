package utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;


public class DriverFactory {

    private static DriverFactory instance;

    private DriverFactory(){}

    public static DriverFactory getInstance(){
        if(instance==null){
            synchronized (DriverFactory.class){
                if (instance==null){
                    instance= new DriverFactory();
                }
            }
        }
        return instance;
    }

    public WebDriver createDriver(String browser){
        WebDriver driver;

        switch (browser.toLowerCase()){
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-popup-blocking");
                options.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
                options.addArguments("--start-maximized");
                driver = new ChromeDriver(options);
                break;

            case "firefox":
                System.setProperty("webdriver.gecko.driver", "src/test/resources/gecko.exe");
                driver = new FirefoxDriver();
                break;

            default:
                throw new IllegalArgumentException("Invalid browser Name "+browser);
        }
        return driver;
    }
}
