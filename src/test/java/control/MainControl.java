package control;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import session.SessionDriver;

import java.time.Duration;

public class MainControl {
    protected WebElement mainControl;
    protected By locator;
    protected WebDriver driver = SessionDriver.getInstance().getBrowser();
    protected WebDriverWait wait;

    public MainControl(By locator){
        this.locator = locator;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    protected WebElement findWebElement(){
        return findWebElement(this.locator);
    }

    protected WebElement findWebElement(By locator){
        this.mainControl = driver.findElement(locator);
        return this.mainControl;
    }

    public String getAttributeOfElement(String attribute){
        return this.findWebElement().getAttribute(attribute);
    }

    public String getCSSPropertyOfElement(String attribute){
        return this.findWebElement().getCssValue(attribute);
    }

    public void mouseOver(){
        Actions action = new Actions(driver);
        action.moveToElement(this.findWebElement()).perform();
    }
    public void clickOnElement(){
        new Actions(driver)
                .moveToElement(this.findWebElement())
                .click()
                .perform();
    }

    public MainControl waitElementIsVisible(){
        return waitElementIsVisible(5);
    }

    public MainControl waitElementIsVisible(int time){
        this.findWebElement();
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOf(this.mainControl));
        return this;
    }

    public MainControl waitElementIsNotVisible(){
        return waitElementIsNotVisible(5);
    }

    public MainControl waitElementIsNotVisible(int time){
        this.findWebElement();
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.invisibilityOf(this.mainControl));
        return this;
    }

    public boolean isWebElementDisplayed(){
        try {
            this.findWebElement();
            return this.mainControl.isDisplayed();
        }catch (Exception e){
            return false;
        }
    }
}
