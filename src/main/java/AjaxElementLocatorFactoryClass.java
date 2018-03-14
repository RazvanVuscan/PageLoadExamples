import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.perf4j.StopWatch;

import static org.junit.Assert.assertTrue;

public class AjaxElementLocatorFactoryClass {
    private WebDriver driver;

    @FindBy(className = "Mstart(2px)")
    private WebElement invalidMailLink;

    @FindBy(css = ".is-visible")
    private WebElement portfolio;

    public AjaxElementLocatorFactoryClass(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    public void executeInvalidLocatorScript() {
        driver.get("http://www.filippobello.com/");
        invalidMailLink.click();
    }

    public void executeSignInLinkClickScript() {
        StopWatch watch = new StopWatch();
        watch.start();
        driver.get("http://www.filippobello.com/");
        portfolio.click();
        watch.stop();
        try {
            Thread.sleep(10000);
            System.out.println("We are on a new page");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(watch.getElapsedTime());
    }

    public void useFindByFunction() {
        driver.get("http://www.filippobello.com/");

        System.out.println("Looking for the valid locator element");

        try {
            System.out.println("Triggering timeout");
            Thread.sleep(10000);
            System.out.println("Done!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        assertTrue("Element not displayed", driver.findElement(By.cssSelector(".is-visible")).isDisplayed());

//        assertTrue("Element not displayed", portfolio.isDisplayed());
    }

}
