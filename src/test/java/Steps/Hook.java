package Steps;

import Base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.firefox.FirefoxDriver;

//public class Hook extends BaseUtil {

public class Hook extends BaseUtil {

    private BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void InitializeTest() {

        System.out.println("Opening the browser: Firefox");

        System.setProperty("webdriver.gecko.driver","C:\\workspace\\geckodriver.exe");

        base.driver =  new FirefoxDriver();
    }

    @After
    public void TearDownTest(Scenario scenario) {

        if(scenario.isFailed()) {

            //Take screenshot
            System.out.println("Scenario name is " + scenario.getName());
        }

        base.driver.close();
    }

}
