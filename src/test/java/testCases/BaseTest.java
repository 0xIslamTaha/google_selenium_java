package testCases;

import framework.BaseSelenium;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import pages.ResultsPage;
import pages.SearchPage;


public class BaseTest {
    protected String main_page = "https://google.com";
    public WebDriver driver;

    public BaseSelenium base_selenium = BaseSelenium.getINSTANCE();
    public ResultsPage result_page = new ResultsPage();
    public SearchPage search_page = new SearchPage();

    @Before
    public void before() {
        driver = base_selenium.getDriver();
        driver.get(main_page);
    }

    @After
    public void after() {
        base_selenium.quitDriver();
    }
}