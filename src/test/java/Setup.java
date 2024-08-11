import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Setup {
    AndroidDriver driver;
    @BeforeTest
    public AndroidDriver setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("platformVersion", "11");
        capabilities.setCapability("appPackage", "com.google.android.calculator");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        capabilities.setCapability("app",  System.getProperty("user.dir")+"/src/test/resources/new-cal.apk");
        capabilities.setCapability("automationName", "UiAutomator2");

        URL url = new URL("http://127.0.0.1:4723");
        driver = new AndroidDriver(url,capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        return driver;

    }
    @AfterTest
    public void closeApp(){
        driver.quit();
    }
}
