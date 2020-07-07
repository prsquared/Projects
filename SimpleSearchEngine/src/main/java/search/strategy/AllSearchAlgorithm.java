package search.strategy;

import search.SearchIndex;

import java.util.HashSet;
import java.util.Set;

public class AllSearchAlgorithm extends SearchAlgorithm {

    public AllSearchAlgorithm(SearchIndex index) {
        super(index);
    }

    @Override
    public void search(String searchText) {
        String[] searchTerms = searchText.split("\\s+");
        Set<String> allRecords = new HashSet<>();
        for (int i = 0; i < searchTerms.length; i++) {
            if (index.getInvertedIndex().containsKey(searchTerms[i])) {
                Set<String> records = findRecordsFromIndex(searchTerms[i]);
                if (i == 0) {
                    allRecords.addAll(records);
                } else {
                    allRecords.retainAll(records);
                }
            }
        }
        if (allRecords.size() > 0) {
            printRecords(allRecords);
        } else {
            System.out.println("No matching people found.");
        }
    }
}
