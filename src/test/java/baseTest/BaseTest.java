package baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pages.MainPage;

public class BaseTest {

    public WebDriver driver;
    protected MainPage mp;


    public void initPages() {
        mp = PageFactory.initElements(driver, MainPage.class);
    }

    @BeforeMethod
    @Parameters({ "browser"})
    public void setupTest(String browser) {


        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            //            chromeOptions.addArguments("--headless=new");
            driver = new ChromeDriver(chromeOptions);

        }else if(browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            WebDriverManager.firefoxdriver().setup();
      //      firefoxOptions.setHeadless(true);
            driver = new FirefoxDriver(firefoxOptions);

        }else if(browser.equalsIgnoreCase("edge")) {
            EdgeOptions edgeOptions = new EdgeOptions();
            WebDriverManager.edgedriver().setup();
      //      edgeOptions.addArguments("--headless");
            driver = new EdgeDriver(edgeOptions);
        }
        driver.get("https://www.trustedshops.de/bewertung/info_X77B11C1B8A5ABA16DDEC0C30E7996C21.html");
        driver.manage().window().maximize();
        initPages();
    }

}
