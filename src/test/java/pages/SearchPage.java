package pages;

public class SearchPage extends BasePage {
    public String getTextBoxData(){
        return base_selenium.getValue("search_box");
    }

    public void searchText(String text, Boolean submit){
        base_selenium.setText("search_box", text);
        if (submit)
            base_selenium.click("search_google_search");
    }

    public void inurlSearch(String text){
        String data = "inurl:"+text;
        searchText(data, true);
    }

    public String[] getSuggestionsData(){
        return base_selenium.getText("search_suggestions").split("\n");
    }

}
