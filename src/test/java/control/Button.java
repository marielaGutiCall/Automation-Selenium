package control;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Button extends MainControl{
    private WebElement webElement;
    public Button(By locator){
        super(locator);
    }

    public void click(){
        webElement = this.findWebElement();
        webElement.click();
    }
    public Button waitElementIsClickable(){
        webElement = this.findWebElement();
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        return this;
    }
}
