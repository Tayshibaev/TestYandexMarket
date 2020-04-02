package pages;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import util.TestProperties;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BasePage {
    protected static WebDriver driver;
    protected static Properties properties = TestProperties.getINSTANCE().getProperties();
    protected static String baseUrl;

    @BeforeClass
    public static void setUp() {

        switch (properties.getProperty("browser")) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "drv/geckodriver.exe");
                driver = new ChromeDriver();
                break;
            default:
                System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
                driver = new ChromeDriver();
        }

        baseUrl = properties.getProperty("app.url");
        driver.manage().timeouts().implicitlyWait(15L, TimeUnit.SECONDS);//задаем тайм аут по умолчанию ожидания поиска
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public void fillField(By by , String val)
    {
        //клик для того, чтобы окно с выбором даты исчезло
        driver.findElement(by).click();

        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(val);
    }
}
