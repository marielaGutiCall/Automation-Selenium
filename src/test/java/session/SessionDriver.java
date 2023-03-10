package session;

import factory.FactoryBrowser;
import org.openqa.selenium.WebDriver;

public class SessionDriver {
    private static SessionDriver sessionDriver = null;
    private WebDriver browser;

    private SessionDriver(){
        browser = FactoryBrowser.make(GetProperties.getInstance().getBrowser()).create();
    }
    public static SessionDriver getInstance(){
        if(sessionDriver == null) sessionDriver = new SessionDriver();
        return sessionDriver;
    }
    public void closeBrowser(){
        browser.quit();
        sessionDriver = null;
    }
    public WebDriver getBrowser(){
        return this.browser;
    }
}
