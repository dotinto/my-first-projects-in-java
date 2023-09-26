import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
        String fileName = "tasks.txt"; // Замените на путь к вашему файлу

        ArrayList<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Выводим содержимое массива строк
        for (String line : lines) {
            System.out.println(line);
        }
    }
}
