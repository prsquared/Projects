package search.strategy;

import search.SearchIndex;

import java.util.HashSet;
import java.util.Set;

public class NoneSearchAlgorithm extends SearchAlgorithm {

    public NoneSearchAlgorithm(SearchIndex index) {
        super(index);
    }

    @Override
    public void search(String searchText) {
        String[] searchTerms = searchText.split("\\s+");
        Set<String> allRecords = new HashSet<>(index.getItems());
        for (String searchTerm : searchTerms) {
            if (index.getInvertedIndex().containsKey(searchTerm)) {
                Set<String> records = findRecordsFromIndex(searchTerm);
                allRecords.removeAll(records);
            }
        }
        if (allRecords.size() > 0) {
            printRecords(allRecords);
        } else {
            System.out.println("No matching people found.");
        }
    }
}
