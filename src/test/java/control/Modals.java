package control;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Modals extends MainControl{
    WebElement closeButtonWebElement;
    public Modals(By locator){
        super(locator);
    }

    public void closeModal(By closeButton){
        if(isWebElementDisplayed()){
            closeButtonWebElement = this.findWebElement(closeButton);
            closeButtonWebElement.click();
        }
    }
}
