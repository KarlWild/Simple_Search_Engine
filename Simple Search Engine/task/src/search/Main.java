package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        People people;

        if (args[0] != null && args[0].equals("--data")) people = new People(args[1]);
        else {
            System.out.println("Enter the number of people:");
            int number_of_people = Integer.parseInt(r.readLine());
            people = new People(number_of_people);
        }
        while (true) {
            Menu menu = new Menu();
            int option = Integer.parseInt(r.readLine());
            switch (option) {
                case 1:
                    System.out.println("Select a matching strategy: ALL, ANY, NONE");
                    String strategy = r.readLine();
                    SearchEngine searchEngine;
                    if(strategy.equals("ALL")) searchEngine = new SearchEngine(new ALLSearchingMethod());
                    else if(strategy.equals("ANY"))  searchEngine = new SearchEngine(new ANYSearchingMethod());
                    else if(strategy.equals("NONE")) searchEngine = new SearchEngine(new NONESearchingMethod());
                    else break;
                    //SearchEngine.Search(people.getInvertedIndexes(), people.getPeople(), data);
                    searchEngine.Search(people.getInvertedIndexes(),people.getPeople());
                    break;
                case 2:
                    people.outputPeople();
                    break;
                case 0:
                    System.out.println("Bye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("try again");
                    break;
            }
        }
    }
}
