package control;

import org.openqa.selenium.By;

public class Label extends MainControl{
  public Label(By locator){
      super(locator);
  }
  public String getText(){
      return findWebElement().getText();
  }
}
