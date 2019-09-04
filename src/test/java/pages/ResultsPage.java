package pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ResultsPage extends BasePage{
    public List<String> getResultsUrls(){
        List<String> results = new ArrayList<String>();
        List<WebElement> element_items =  base_selenium.findElement("search_results");
        for ( WebElement item : element_items)
            results.add(item.findElement(By.tagName("a")).getAttribute("href"));
        return results;
    }
}
