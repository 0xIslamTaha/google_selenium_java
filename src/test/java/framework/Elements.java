package framework;
import java.util.HashMap;


public class Elements {
    public HashMap<String, HashMap<String, String>> elements = new HashMap<String, HashMap<String, String>>();
    public Elements() {
        elements.put("search_box", SetInternalMap("name", "0", "q"));
        elements.put("search_suggestions", SetInternalMap("class_name", "0", "erkvQe"));
        elements.put("search_google_search", SetInternalMap("name", "1", "btnK"));
        elements.put("search_results", SetInternalMap("class_name", "-1", "g"));
    }

    private HashMap<String, String> SetInternalMap(String method, String order, String value){
        HashMap<String, String> tmp = new HashMap<String, String>();
        tmp.put("method", method);
        tmp.put("order", order);
        tmp.put("value", value);
        return tmp;
    }
}
