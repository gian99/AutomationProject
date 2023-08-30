package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    WebDriver driver;
    public BasePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void waitUntilElementVisible(WebElement element){
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.visibilityOf(element));
        }catch(TimeoutException e){
            System.out.println("Element not visible: "+e);
        }
    }

    public boolean isElementVisible(WebElement element){
        boolean elementVisible = false;
        try{
            elementVisible = element.isDisplayed();
        }catch(NoSuchElementException e){
            System.out.println("Element not found: "+e);
        }
        return elementVisible;
    }

    public boolean elementClick(WebElement element){
        try{
            element.click();
        }catch(NoSuchElementException e){
            System.out.println("Element not found: "+e);
        }
        return false;
    }


    public void sendElementText(WebElement element, String text){
        try{
            element.click();
            element.sendKeys(text);
        }catch(NoSuchElementException e){
            System.out.println("Element not found: "+e);
        }
    }

}
