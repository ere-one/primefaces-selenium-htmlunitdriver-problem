package one.ere;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.BrowserVersion;

public class SeleniumTest {

    private WebDriver driver;

    private WebDriverWait wait;

    @Before
    public void setUp() {

        this.driver = new HtmlUnitDriver(BrowserVersion.CHROME, true) {
            {
                getWebClient().getOptions().setThrowExceptionOnScriptError(false);
                getWebClient().getOptions().setRedirectEnabled(true);
            }
        };

        this.wait = new WebDriverWait(this.driver, 5L);
    }

    @After
    public void tearDown() {

        if (this.driver != null) {
            this.driver.quit();
        }
    }

    @Test
    public void testPrimeFacesAjax() throws Exception {

        this.driver.get("http://localhost:8080/test/");

        this.driver.findElement(By.cssSelector("input[type=text][value=\"1\"]"));

        final WebElement button2 = this.driver.findElement(By.xpath("/html/body/form/button[2]"));
        button2.click();

        this.wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type=text][value=\"2\"]")));

        final WebElement button1 = this.driver.findElement(By.xpath("/html/body/form/button[1]"));
        button1.click();
        this.wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type=text][value=\"1\"]")));
    }
}
