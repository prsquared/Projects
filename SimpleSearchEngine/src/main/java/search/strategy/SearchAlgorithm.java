package search.strategy;

import search.SearchIndex;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class SearchAlgorithm {
    protected SearchIndex index;

    public SearchAlgorithm(SearchIndex index) {
        this.index = index;
    }

    public abstract void search(String searchText);

    protected Set<String> findRecordsFromIndex(String searchStr) {
        List<Integer> indexList = index.getInvertedIndex().get(searchStr);
        Set<String> records = new HashSet<>();
        List<String> people = index.getItems();
        for (Integer index : indexList) {
            records.add(people.get(index));
        }
        return records;
    }

    protected void printRecords(Set<String> records) {
        System.out.println(records.size() + " persons found:");
        for (String item : records) {
            System.out.println(item);
        }
    }
}
