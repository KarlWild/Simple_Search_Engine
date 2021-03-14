package search;

import java.io.*;
import java.util.*;

public class People {
    private int number;
    private List<String> people;
    private Map<String, List<Integer>> invertedIndexes = new HashMap<>();
    final private BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

    public People(int number) throws IOException {
        this.number = number;
        people = new ArrayList<>();
        InputInfo();
    }

    public People(String filePath) throws FileNotFoundException {
        InputInfo(filePath);
    }

    private void InputInfo() throws IOException {
        System.out.println("Enter all people:");
        int count = 0;
        while (count != number) {
            people.add(r.readLine());
            String[] words = people.get(count).split("\\s");
            for (String word : words) {
                if (invertedIndexes.containsKey(word.toLowerCase())) {
                    invertedIndexes.get(word).add(count);
                } else invertedIndexes.put(word.toLowerCase(), new ArrayList<>(count));
            }
            count++;
        }
    }

    private void InputInfo(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        int count = 0;
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                sc.nextLine();
                count++;
            }
        }
        people = new ArrayList<>();
        count = 0;
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                people.add(sc.nextLine());
                String[] words = people.get(count).split("\\s");
                for (String word : words) {
                    if (invertedIndexes.containsKey(word.toLowerCase())) {
                        invertedIndexes.get(word.toLowerCase()).add(count);
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(count);
                        invertedIndexes.put(word.toLowerCase(), list);
                    }
                }
                count++;
            }
        }
    }

    public void outputPeople() {
        System.out.println("=== List of people ===");
        for (String s : people) System.out.println(s);
    }


    public Map<String, List<Integer>> getInvertedIndexes() {
        return invertedIndexes;
    }

    public List<String> getPeople() {
        return people;
    }
}
