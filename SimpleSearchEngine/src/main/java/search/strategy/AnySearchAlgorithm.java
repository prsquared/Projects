package search.strategy;

import search.SearchIndex;

import java.util.HashSet;
import java.util.Set;

public class AnySearchAlgorithm extends SearchAlgorithm {

    public AnySearchAlgorithm(SearchIndex index) {
        super(index);
    }

    @Override
    public void search(String searchText) {
        String[] searchTerms = searchText.split("\\s+");
        Set<String> allRecords = new HashSet<>();
        for (String searchTerm : searchTerms) {
            if (index.getInvertedIndex().containsKey(searchTerm)) {
                Set<String> records = findRecordsFromIndex(searchTerm);
                allRecords.addAll(records);
            }
        }
        if (allRecords.size() > 0) {
            printRecords(allRecords);
        } else {
            System.out.println("No matching people found.");
        }
    }
}
