package testCases;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TestTextSearch extends BaseTest {
    @Test
    public void test001_search_text_box_is_editable() {
        /*
          TC001: Verify that text box is editable.
            1- Get http://google.com
            2- Get data from text box, should be empty
            3- Set keyword in text box
            4- Verify that text box has this keyword"
        */
        assertEquals(search_page.getTextBoxData(), "");
        search_page.searchText("RandomSearch", false);
        assertEquals(search_page.getTextBoxData(), "RandomSearch");
    }

    @Test
    public void test002_auto_suggestions(){
        /*
        TC004: Verify that auto-suggestions features returns correct results
            1- Get http://google.com
            2- Set {} keyword
            3- Verify that there is {} in suggestions list"
         */
        search_page.searchText("face", false);
        for (String data : search_page.getSuggestionsData()){
            assertTrue(data.contains("face"));
        }
    }

    @Test
    public void test003_inurl_feature(){
        /*
         TC006: Verify that auto-suggestions features returns correct results
            1- Get http://google.com
            2- search for any word with "inurl:" feature
            3- Verify that all results url has this keyword
         */
        String data = "0xIslamTaha";
        search_page.inurlSearch(data);

        for (String result : result_page.getResultsUrls()){
            assertTrue(result.toLowerCase().contains(data.toLowerCase()));
        }
    }

}
