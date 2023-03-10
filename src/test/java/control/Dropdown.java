package control;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class Dropdown extends MainControl{
    public Dropdown(By locator){
        super(locator);
    }
    public void selectOption(String option){
        Select dropdownField = new Select(this.findWebElement());
        dropdownField.selectByVisibleText(option);
    }
}
