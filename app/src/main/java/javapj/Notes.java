package javapj;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;


public class Notes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        File notesFolder = new File("NotesData");
        if (!notesFolder.exists()) {
            notesFolder.mkdir();
        }
        
        System.out.print("Select task (create, read, list, delete): ");
        String s = scanner.nextLine();
        switch (s) {
            case "create":
                System.out.println("----------------------");
                System.out.print("Enter file name: ");
                String filename = scanner.nextLine();

                File file = new File("NotesData/" + filename + ".txt");
                try {
                    file.createNewFile();
                    System.out.println("----------------------");
                    System.out.println("File created: " + file.getAbsolutePath());
                } catch (IOException e) {
                    System.out.println("----------------------");
                    System.out.println("An error occurred while creating the file: " + e.getMessage());
                    System.out.println("----------------------");
                    scanner.close();
                    return;
                }
                System.out.println("----------------------");
                System.out.print("Enter text: ");
                String text = scanner.nextLine();
    
                try (FileWriter writer = new FileWriter(file)) {
                    writer.write(text);
                    System.out.println("----------------------");
                    System.out.println("Text written to the file.");
                    System.out.println("----------------------");
                } catch (IOException e) {
                    System.out.println("----------------------");
                    System.out.println("An error occurred while writing to the file: " + e.getMessage());
                    System.out.println("----------------------");
                }
                

                break;
            case "read":
                System.out.println("----------------------");
                System.out.print("Enter file name: ");
                String filenameRead = scanner.nextLine();
                
                try {
                    File fileread = new File("NotesData/" + filenameRead + ".txt");
                    Scanner fileScanner = new Scanner(fileread);
                
                    System.out.println("----------------------");
                    System.out.println("File content:");
                    System.out.println("----------------------");
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();
                        System.out.println(line);
                    }
                    System.out.println("----------------------");
                    fileScanner.close();
                } catch (FileNotFoundException e) {
                    System.out.println("----------------------");
                    System.out.println("File not found. Please enter a valid file name.");
                    System.out.println("----------------------");
                }
                break;
            case "delete":
                System.out.println("----------------------");
                System.out.print("Enter file name: ");
                String filenamedel = scanner.nextLine();
                
                File filedel = new File("NotesData/" + filenamedel + ".txt");
                if (filedel.exists()) {
                    if (filedel.delete()) {
                        System.out.println("----------------------");
                        System.out.println("File deleted: " + filedel.getAbsolutePath());
                        System.out.println("----------------------");
                    } else {
                        System.out.println("----------------------");
                        System.out.println("Failed to delete the file.");
                        System.out.println("----------------------");
                    }
                } else {
                    System.out.println("----------------------");
                    System.out.println("File not found. Please enter a valid file name.");
                    System.out.println("----------------------");
                }
                break;
            case "list":
            File folder = new File("NotesData");

            File[] files = folder.listFiles();
    
            if (files != null) {
                System.out.println("----------------------");
                for (File filel : files) {
                    if (filel.isFile() && filel.getName().endsWith(".txt")) {
                        String filenamel = filel.getName();
                        String nameWithoutExtension = filenamel.substring(0, filenamel.lastIndexOf('.'));
                        System.out.println(nameWithoutExtension);
                        
                    }
                }
                System.out.println("----------------------");
            } else {
                System.out.println("----------------------");
                System.out.println("The folder does not exist or is not a directory. Create folder 'NotesData'.");
                System.out.println("----------------------");
            }
            default:
                break;
        }
        scanner.close();
    }
}
