package runner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = { "pretty: io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm", "html:target/cucumber-html-reports"},
        monochrome=true,
        features = {"src/test/resources/features"},
        glue= {"runner"},
        tags = "@ValidOptionsToSelectAFlight")
public class Runner {

}