package control;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TextBox extends MainControl {
    private WebElement webElement;
    public TextBox(By locator){
        super(locator);
    }
    public void setText(String value){
        webElement = this.findWebElement();
        webElement.clear();
        webElement.sendKeys(value);
    }
}
