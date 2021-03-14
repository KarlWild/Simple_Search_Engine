package search;

import java.util.*;

interface SearchingMethod {
    Scanner sc = new Scanner(System.in);

    void Search(Map<String, List<Integer>> invertedIndexes, List<String> people);
}

class ALLSearchingMethod implements SearchingMethod {
    @Override
    public void Search(Map<String, List<Integer>> invertedIndexes, List<String> people) {
        System.out.println("Enter a name or email to search all suitable people.");
        Set<String> QueryResults = new TreeSet<>();
        String data = sc.nextLine();
        data = data.toLowerCase();
        String[] wordsData = data.split("\\s");
        for (String s : wordsData) {
            if (invertedIndexes.containsKey(s)) {
                List<Integer> list = invertedIndexes.get(s);
                for (Integer a : list) QueryResults.add(people.get(a));
            }
        }
        Set<String> uniqueQueryResults = new TreeSet<>();
        for (String s1 : QueryResults) {
            int a = 0;
            for (String s2 : wordsData) {
                if (!s1.toLowerCase().contains(s2)) a++;
            }
            if (a == 0) uniqueQueryResults.add(s1);
        }
        if (uniqueQueryResults.size() != 0) for (String s : uniqueQueryResults) System.out.println(s);
        else System.out.println("No matching people found.");
    }
}

class ANYSearchingMethod implements SearchingMethod {
    @Override
    public void Search(Map<String, List<Integer>> invertedIndexes, List<String> people) {
        System.out.println("Enter a name or email to search any suitable people.");
        String data = sc.nextLine();
        Set<String> uniqueQueryResults = new TreeSet<>();
        data = data.toLowerCase();
        String[] wordsData = data.split("\\s");
        for (String s : wordsData) {
            if (invertedIndexes.containsKey(s)) {
                List<Integer> list = invertedIndexes.get(s);
                for (Integer a : list) uniqueQueryResults.add(people.get(a));
            }
        }
        if (uniqueQueryResults.size() != 0) {
            for (String s : uniqueQueryResults) System.out.println(s);
        } else System.out.println("No matching people found.");
    }
}

class NONESearchingMethod implements SearchingMethod {
    @Override
    public void Search(Map<String, List<Integer>> invertedIndexes, List<String> people) {
        System.out.println("Enter a name or email to search none suitable people.");
        String data = sc.nextLine();
        data = data.toLowerCase();
        Set<String> uniqueQueryResults = new TreeSet<>();
        String[] dataWords = data.split("\\s");
        for (String s : dataWords) {
            if (invertedIndexes.containsKey(s)) {
                List<Integer> list = invertedIndexes.get(s);
                for (Integer a : list) uniqueQueryResults.add(people.get(a));
            }
        }
        for (String s : people) {
            int a = 0;
            for (String s1 : uniqueQueryResults) {
                if (s.equals(s1)) a++;
            }
            if(a==0) System.out.println(s);
        }
    }
}
