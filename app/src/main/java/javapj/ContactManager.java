package javapj;

import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ContactManager {
    public static void main(String[] args) throws IOException  {
        System.out.println("----------------------");
        System.out.println("Select task (add/remove): ");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        File contactFile = new File("contacts.json");
        System.out.println("Ready");
        if (!contactFile.exists()) {
            try {
                System.out.println("contacts.json");
                contactFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        switch (s) {
            case "add":
                System.out.print("Contact Number: ");
                String number = scanner.nextLine();
                System.out.print("Contact Name: ");
                String newName = scanner.nextLine();
                System.out.println("Contact number: " + number);
                System.out.println("Contact name: " + newName);
                break;
        
            default:
                System.out.println("Invalid task selected");
                break;
        }
    }
}