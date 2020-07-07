package search;

import search.strategy.AllSearchAlgorithm;
import search.strategy.AnySearchAlgorithm;
import search.strategy.NoneSearchAlgorithm;
import search.strategy.SearchAlgorithm;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private String[] people;

    public static void main(String[] args) {
        FileService fileService = new FileService();
        if (validateArguments(args)) {
            SearchIndex searchIndex = fileService.getPeopleListFromFile(args[1]);
            int input = 0;
            boolean search = true;
            while (search) {
                displayMenu();
                input = Integer.parseInt(scanner.nextLine());
                switch (input) {
                    case 1:
                        searchSubMenu();
                        SearchAlgorithm algorithm = create(scanner.nextLine(), searchIndex);
                        System.out.println("Enter a name or email to search all suitable people.");
                        String searchStr = scanner.nextLine().toLowerCase().trim();
                        algorithm.search(searchStr);
                        break;
                    case 2:
                        printAllPeople(searchIndex.getItems());
                        break;
                    case 0:
                        search = false;
                        break;
                    default:
                        System.out.println("Incorrect option! Try again.");
                }
            }
        }
    }

    private static void searchSubMenu() {
        System.out.println("Select a matching strategy: ALL, ANY, NONE");
    }

    private static void displayMenu() {
        System.out.println("=== Menu ===");
        System.out.println("1. Find a person");
        System.out.println("2. Print all people");
        System.out.println("0. Exit");
    }

    private static boolean validateArguments(String[] args) {
        if (args.length < 2) {
            return false;
        } else if ("--data".equals(args[0])) {
            return true;
        }
        return false;
    }

    public static void printAllPeople(List<String> people) {
        System.out.println("=== List of people ===");
        for (String person : people) {
            System.out.println(person);
        }
    }

    public static SearchAlgorithm create(String algType, SearchIndex index) {
        switch (algType) {
            case "ANY": {
                return new AnySearchAlgorithm(index);
            }
            case "ALL": {
                return new AllSearchAlgorithm(index);
            }
            case "NONE": {
                return new NoneSearchAlgorithm(index);
            }
            default: {
                throw new IllegalArgumentException("Unknown algorithm type " + algType);
            }
        }
    }
}
