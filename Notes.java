import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;


public class Notes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Select, what gon do (create, read, update, delete): ");
        String s = scanner.nextLine();
        switch (s) {
            case "create":
                System.out.println("----------------------");
                System.out.print("Enter file name: ");
                String filename = scanner.nextLine();
    
                // Create the file
                File file = new File("NotesData/" + filename + ".txt");
                try {
                    file.createNewFile();
                    System.out.println("----------------------");
                    System.out.println("File created: " + file.getAbsolutePath());
                } catch (IOException e) {
                    System.out.println("----------------------");
                    System.out.println("An error occurred while creating the file: " + e.getMessage());
                    System.out.println("----------------------");
                    return;
                }
                System.out.println("----------------------");
                System.out.print("Enter text: ");
                String text = scanner.nextLine();
    
                // Write the text to the file
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
                
                // Read the file content
                try {
                    File fileread = new File("NotesData/" + filenameRead + ".txt");
                    Scanner fileScanner = new Scanner(fileread);
                
                    // Log the content
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
                
                // Delete the file
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
            default:
                break;
        }
    }
}
