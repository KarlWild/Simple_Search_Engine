package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Menu {
    private File menu;
    private Scanner sc;
    private int option;
    public Menu() throws FileNotFoundException {
        menu = new File("C:\\Users\\KarlWild\\IdeaProjects\\Simple Search Engine\\Simple Search Engine\\task\\src\\search\\menu.txt");
        sc = new Scanner(menu);
        output();
        sc.close();
    }
    public void output(){
        while(sc.hasNextLine()) System.out.println(sc.nextLine());
    }
    //public
}
