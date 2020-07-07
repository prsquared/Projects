package search;

import java.util.List;
import java.util.Map;

public class SearchIndex {
    List<String> items;
    Map<String, List<Integer>> invertedIndex;

    public SearchIndex(List<String> items, Map<String, List<Integer>> invertedIndex) {
        this.items = items;
        this.invertedIndex = invertedIndex;
    }

    public List<String> getItems() {
        return items;
    }

    public Map<String, List<Integer>> getInvertedIndex() {
        return invertedIndex;
    }
}
