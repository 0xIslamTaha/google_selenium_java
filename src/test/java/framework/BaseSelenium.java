package framework;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testCases.BaseTest;

import java.util.*;
import java.util.concurrent.TimeUnit;


public class BaseSelenium {
    private static final int TIMEOUT_SMALL = 5;
    private static final int TIMEOUT = 30;

    private WebDriver driver;
    WebDriverWait wait;
    public Elements elements_obj = new Elements();

    //singletone
    private static BaseSelenium INSTANCE;
    private BaseSelenium(){}

    public static BaseSelenium getINSTANCE() {
        if (INSTANCE == null){
            INSTANCE = new BaseSelenium();
        }
        return INSTANCE;
    }

    public WebDriver getDriver(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, TIMEOUT_SMALL);
        return driver;
    }

    public void quitDriver(){
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    private HashMap<String, String > getLocatorInfo(String element){
        HashMap<String, String> locator_info;
        locator_info = elements_obj.elements.get(element);
        return locator_info;
    }

    private By getLocator(String element){
        HashMap<String, String> locator_info = getLocatorInfo(element);
        By locator = null;

        if (locator_info.get("method").equals("name")) {
            locator = By.name(locator_info.get("value"));
        } else if(locator_info.get("method").equals("class_name")){
            locator = By.className(locator_info.get("value"));
        }
        return locator;
    }

    public List<WebElement> findElement(String element){
        By locator = getLocator(element);
        HashMap<String, String> locator_info = getLocatorInfo(element);

        List<WebElement> items = driver.findElements(locator);
        if (locator_info.get("order").equals("-1")) {
            return items;
        } else {
            List<WebElement> item = new ArrayList<WebElement>();
            item.add(items.get(Integer.parseInt(locator_info.get("order"))));
            return item;
        }
    }

    public WebElement waitUntilElementVisible(String element){
        By locator = getLocator(element);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public String getValue(String element){
        waitUntilElementVisible(element);
        WebElement web_element = findElement(element).get(0);
        return web_element.getAttribute("value");
    }

    public void setText(String element, String text){
        waitUntilElementVisible(element);
        WebElement web_element = findElement(element).get(0);
        web_element.sendKeys(text);
    }

    public String getText(String element){
        waitUntilElementVisible(element);
        WebElement web_element = findElement(element).get(0);
        return web_element.getText();
    }

    public void click(String element){
        WebElement web_element = findElement(element).get(0);
        web_element.click();
    }

}
