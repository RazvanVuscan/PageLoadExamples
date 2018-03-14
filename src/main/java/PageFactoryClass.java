import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageFactoryClass {
    private WebDriver driver;

    @FindBy(className = "Mstart(2px)")
    private WebElement invalidMailLink;

    @FindBy(css = ".is-visible")
    private WebElement portfolio;

    public PageFactoryClass(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void executeInvalidLocatorScript() {
        driver.get("http://www.filippobello.com/");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        invalidMailLink.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void executePortfolioClickScript() {
        driver.get("http://www.filippobello.com/");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        portfolio.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
