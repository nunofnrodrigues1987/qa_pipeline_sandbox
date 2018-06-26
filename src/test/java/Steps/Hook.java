package Steps;

import Base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//public class Hook extends BaseUtil {

public class Hook extends BaseUtil {

    private BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void InitializeTest() {

        /* //Static to firefox browser

        System.setProperty("webdriver.gecko.driver","C:\\workspace\\geckodriver.exe");

        base.driver =  new FirefoxDriver();
        */

        //Support parallel execution

        String browser = System.getProperty("Browser");

        if(browser==null) {
            browser = "Chrome";
        }

        switch (browser) {
            case "Firefox": {
                System.setProperty("webdriver.gecko.driver","C:\\workspace\\geckodriver.exe");
                base.driver =  new FirefoxDriver();
                break;
            }
            case "Chrome": {
                System.setProperty("webdriver.chrome.driver","C:\\workspace\\chromedriver.exe");
                base.driver =  new ChromeDriver();
                break;
            }
            default:
                base.driver = new ChromeDriver();
                break;
        }
    }

    @After
    public void TearDownTest(Scenario scenario) {

        if(scenario.isFailed()) {

            //Take screenshot
            System.out.println("Scenario name is " + scenario.getName());
        }

       // base.driver.close();
    }

}
