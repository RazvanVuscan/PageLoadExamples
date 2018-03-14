import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class TestExamples {
    private AjaxElementLocatorFactoryClass ajaxElementLocatorFactoryClass;
    private PageFactoryClass pageFactoryClass;

    WebDriver webDriver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/test/resources/geckodriver_mac");
        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");

        FirefoxProfile profile = new FirefoxProfile();
        profile.setAcceptUntrustedCertificates(true);
        profile.setAssumeUntrustedCertificateIssuer(true);

        FirefoxOptions options = new FirefoxOptions();
        options.setCapability(FirefoxDriver.PROFILE,profile);
        options.setCapability(FirefoxDriver.MARIONETTE,true);

        webDriver = new FirefoxDriver(options);
        webDriver.manage().window().maximize();
    }

    /**
     * Counter example illustrating how using AjaxElementLocatorFactory does NOT influence
     * elements found using the .findElement() function, unlike an Implicit Wait which
     * influences all elements, regardless of them being annotated or found using the @FindBy function.
     */
    @Test
    public void runCounterExampleTest() {
        ajaxElementLocatorFactoryClass = new AjaxElementLocatorFactoryClass(webDriver);
        ajaxElementLocatorFactoryClass.useFindByFunction();
    }

    /**
     * Test that waits up to 20 seconds before timing out in case of an invalid WebElement locator.
     */
    @Test
    public void runInvalidLocatorTest1() {
        ajaxElementLocatorFactoryClass = new AjaxElementLocatorFactoryClass(webDriver);
        ajaxElementLocatorFactoryClass.executeInvalidLocatorScript();
    }

    /**
     * Test that immediately times out in case of an invalid WebElement locator.
     */
    @Test
    public void runInvalidLocatorTest2() {
        pageFactoryClass = new PageFactoryClass(webDriver);
        pageFactoryClass.executeInvalidLocatorScript();
    }

    /**
     * Test that waits for the element to become available, and clicks the element as soon as it has appeared.
     */
    @Test
    public void runValidLocatorTest1() {
        ajaxElementLocatorFactoryClass = new AjaxElementLocatorFactoryClass(webDriver);
        ajaxElementLocatorFactoryClass.executeSignInLinkClickScript();
    }

    /**
     * Test that tries to click the element even though it is not yet available.
     */
    @Test
    public void runValidLocatorTest2() {
        pageFactoryClass = new PageFactoryClass(webDriver);
        pageFactoryClass.executeSignInLinkClickScript();
    }

    @After
    public void quit() {
        webDriver.quit();
    }


}
