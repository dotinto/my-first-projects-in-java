import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {
    public static void main(String[] args) throws IOException {
        File tasks = new File("tasks.txt");
        
        Scanner scanner = new Scanner(System.in);
        if (!tasks.exists()) {
            tasks.createNewFile();
        }
        String fileName = "tasks.txt";

        ArrayList<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("----------------------");
        System.out.println("Tasks: ");
        for (String line : lines) {
            System.out.println(line);
        }
        System.out.println("----------------------");
        System.out.print("Select task (add/remove): ");
        String task = scanner.nextLine();
        switch (task) {
            case "add":
                System.out.println("----------------------");
                System.out.print("Task title: ");
                String newTask = scanner.nextLine();
                try (FileWriter writer = new FileWriter(tasks)){
                    writer.write(newTask);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "remove":
                System.out.println("----------------------");
                System.out.print("Task title: ");
                String removeTask = scanner.nextLine();
                int index = lines.indexOf(removeTask);
                if (index < 0) {
                    System.out.println("----------------------");
                    System.out.println("Task not found.");
                    System.out.println("----------------------");
                } else {
                    
                    lines.remove(index);
                    try (FileWriter writer = new FileWriter(tasks)) {
                        for (String line : lines) {
                            writer.write(line + System.lineSeparator());
                        }
                        System.out.println("----------------------");
                        System.out.println("Task successfully removed.");
                        System.out.println("----------------------");
                    } catch (IOException e) {
                        System.out.println("----------------------");
                        System.out.println("Error while executing: " + e.getMessage());
                        System.out.println("----------------------");
                    }
                }
                
                
                break;
            default:
                break;
        }
        scanner.close();
    }
    
}
