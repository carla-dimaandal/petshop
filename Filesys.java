package models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.net.CookieHandler;
import java.util.ArrayList;
import java.util.Scanner;

public class Filesys {
    public Filesys(){
        try{
            file = new File(path);
            if(!file.exists()){
                file.createNewFile();
            }
        }catch(Exception e){
            System.out.print("File does not exist.");
        }
    }

    public ArrayList<Pets> read() throws FileNotFoundException {
        ArrayList<Pets> pet = new ArrayList<>();
        Scanner sc = new Scanner(file);
            while(sc.hasNextLine()){
                String raw = sc.nextLine();
                Pets n = Pets.deserialize(raw.trim());
                pet.add(n);
            }
            sc.close();
        return pet;
    }

    public void write(ArrayList<Pets> pet){
        try{
            FileWriter writer = new FileWriter(file);
            for(Pets pets : pet){
                writer.write(pets.serialize());
            }
            writer.close();
        }catch(Exception e){
            System.out.print("Failed to update file.");
        }
    }

    File file;
    private final String path = "pets.data";
}

