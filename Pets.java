package models;

import java.util.Scanner;
public class Pets{
    public Pets(String _species, String _breed, double _price, int _stock){
        species = _species;
        breed = _breed;
        price = _price;
        stock = _stock;
    }
    public Pets(){}
    public void initialize(){
        System.out.print("Enter pet species: ");
        species = sc.nextLine();
        System.out.print("Enter pet breed: ");
        breed = sc.nextLine();
        System.out.print("Enter price: ");
        price = sc.nextInt();
        System.out.print("Enter stock: ");
        price = sc.nextInt();
        sc.nextLine();
    } 

    public void display(int index){
        System.out.print(index+". ");
        System.out.println(" species: "+ species + " breed " + breed + " price: "+price+" stock: "+ stock);
    }

    //gagawan ko ng pagpipilian

    public void update(){
        System.out.print("Enter new pet specie: ");
        species = sc.nextLine();
        System.out.print("Enter updated pet breed: ");
        breed = sc.nextLine();
        System.out.print("Enter updated pet stocks: ");
        stock = sc.nextInt();
        System.out.print("Enter new pet price: ");
        price = sc.nextInt();
        sc.nextLine();
    }

    //Delete

    public void order(){
        System.out.print("How many pets would you like to order? ");
        int amount = Integer.parseInt(sc.nextLine());
        stock = stock - amount;
        System.out.println("Order completed. ");
    }

    // serialization
    String serialize(){
        return species + "/" + breed + "/" + price +"/" + stock + "\n";
    }
    // deserialization
    public static Pets deserialize(String data){
        String[] raw = data.split("/");
        return new Pets(String _species, String _breed, double _price, int _stock)(
            raw[0],
            Double.parseDouble(raw[1]),
            Integer.parseInt(raw[2])
        );
    }

    Scanner sc = new Scanner(System.in);
    private String species;
    private String breed;
    private double price;
    private int stock;
}
    

