import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import models.Pets;
import models.Filesys;

public class Petshop {
    void run() {
        try{
            storage = filesys.read();
        }catch(FileNotFoundException fnfe){
            println("File not found");
        }
        while(true){
            switch(prompt()){
                case ADD:
                    addPets();
                break;
                case VIEW:
                    displayPets();
                break;
                case UPDATE:
                    updatePets();
                break;
                case REMOVE:
                    removePets();
                break;
                case ORDER:
                    orderPets();
                break;
                case EXIT:
                    print("you are exiting");
                    System.exit(0);
            }
            filesys.write(storage);
        }
    }

    void orderPets(){
        displayPets();
        print("Enter index of coffee you want to order: ");
        int index = Integer.parseInt(sc.nextLine());
        Pets p = storage.get(index);
        p.order();
        storage.set(index, p);
    }

    void addPets(){
        Pets p = new Pets();
        p.initialize();
        storage.add(p);
        println("A new pet is added");
    }

    void displayPets(){         
        System.out.println();
        int index = 0;
        for(Pets pets : storage){
            pets.display(index++);
        }
    }

    void updatePets(){
        displayPets();
        print("Enter index of coffee to edit: ");
        int index = Integer.parseInt(sc.nextLine());
        Pets p = storage.get(index);
        p.update();
        storage.set(index, p);
        println("The pet record has been updated");   
    }

    int prompt(){
        println("\n\nEnter choice");
        println("1. Add new pet(s)");
        println("2. Display pets");
        println("3. Update pet record");
        println("4. Remove Pet");
        println("5. Order Pet");
        println("6. Exit");
        print("-> ");
        return Integer.parseInt(sc.nextLine());
    }

    void removePets(){
        displayPets();
        print("Enter the index to remove: ");
        int index = Integer.parseInt(sc.nextLine());
        storage.remove(index);
        println("The pet has been removed");
    }

    void print(Object o){
        System.out.print(o);
    }

    void println(Object o){
        System.out.println(o);
    }

    Filesys filesys = new Filesys();
    private ArrayList<Pets> storage = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private final int ADD = 1;
    private final int VIEW = 2;
    private final int UPDATE = 3;
    private final int REMOVE = 4;
    private final int ORDER = 5;
    private final int EXIT = 6;
}

