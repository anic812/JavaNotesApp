import java.io.*;
import java.util.Scanner;

public class NotesApp {
    private static final String NOTES_FILE = "notes-app.txt";
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("\t\t\t\tSimple Notes Manager");
        System.out.println("=".repeat(30));
        
        while (true) {
            showMenu();
            int choice = getChoice();
            
            switch (choice) {
                case 1:
                    writeNote();
                    break;
                case 2:
                    readNotes();
                    break;
                case 3:
                    System.out.println("Exiting from the NotesApp...!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
                    continue;
            }
        }
    }
    
    // This method lets you write a note and saves it to a file
    private static void writeNote() {
        System.out.println("\n--- WRITE NOTE ---");
        System.out.print("Enter your note: ");
        String note = scanner.nextLine();
        
        // FileWriter is used here to add notes to the file (append mode)
        try (FileWriter writer = new FileWriter(NOTES_FILE, true)) { // true = append mode
            writer.write(note + "\n");
            writer.write("#*#\n"); // just a separator so we know where notes end
            System.out.println("Note saved successfully!");
            
        } catch (IOException e) {
            System.out.println("Error writing note: " + e.getMessage());
        }
    }
    
    // This method reads all the notes from the file and prints them
    private static void readNotes() {
        System.out.println("\n--- READ NOTES ---");
        
        File file = new File(NOTES_FILE);
        if (!file.exists()) {
            System.out.println("No notes file found. Write a note first!");
            return;
        }
        
        // BufferedReader helps us read the notes line by line
        try (BufferedReader reader = new BufferedReader(new FileReader(NOTES_FILE))) {
            String line;
            int noteNumber = 1;
            
            System.out.println("Your Notes:");
            System.out.println("===========");
            
            while ((line = reader.readLine()) != null) {
                if (line.equals("#*#")) {
                    System.out.println(); // just adds a blank line between notes
                    noteNumber++;
                } else {
                    if (noteNumber == 1) {
                        System.out.println("Note " + noteNumber + ": " + line);
                        noteNumber = 2; // move to next note after first
                    } else {
                        System.out.println("Note " + (noteNumber - 1) + ": " + line);
                    }
                }
            }
            
        } catch (IOException e) {
            System.out.println("Error reading notes: " + e.getMessage());
        }
    }
    
    // Shows the menu options to the user
    private static void showMenu() {
        System.out.println("\n1. Write Note");
        System.out.println("2. Read Notes");  
        System.out.println("3. Exit");
        System.out.print("Choose option: ");
    }
    
    private static int getChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}