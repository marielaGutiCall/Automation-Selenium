package runner;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import session.GetProperties;
import session.SessionDriver;

import java.util.concurrent.TimeUnit;

public class CommonStepDefinitions {
    @Before
    public void setup() {
        String url = GetProperties.getInstance().getHost();
        SessionDriver.getInstance().getBrowser().get(url);
        SessionDriver.getInstance().getBrowser().manage().window().maximize();
        SessionDriver.getInstance().getBrowser().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After
    public void tearDown(Scenario scenario) {
        try {
            String screenshotName = scenario.getName().replaceAll("", "_");
            if (scenario.isFailed()) {
                TakesScreenshot ts = (TakesScreenshot) SessionDriver.getInstance().getBrowser();
                byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "img/png", screenshotName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        SessionDriver.getInstance().closeBrowser();
    }
}
