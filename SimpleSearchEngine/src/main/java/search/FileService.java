package search;

import java.io.*;
import java.util.*;

public class FileService {
    private static final Scanner scanner = new Scanner(System.in);

    public SearchIndex getPeopleListFromFile(String path) {
        File file = new File(path);
        BufferedReader br = null;
        FileReader fr = null;
        List<String> peopleList = new ArrayList<>();
        Map<String, List<Integer>> invertedIndex = new HashMap<>();
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String line = null;
            int index = 0;
            while ((line = br.readLine()) != null) {
                peopleList.add(line);
                addToIndex(line, invertedIndex, index);
                index++;
            }
            fr.close();
            br.close();
        } catch (FileNotFoundException fe) {
            System.out.println("File does not exist");
        } catch (IOException ioe) {
            System.out.println("Error while reading from file");
        }
        SearchIndex searchIndex = new SearchIndex(peopleList, invertedIndex);
        return searchIndex;
    }

    private void addToIndex(String line, Map<String, List<Integer>> invertedIndex, int index) {
        for (String word : line.toLowerCase().split("\\s+")) {
            invertedIndex.putIfAbsent(word, new ArrayList<>());
            invertedIndex.get(word).add(index);
        }
    }
}
