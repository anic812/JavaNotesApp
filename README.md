# Java NotesApp

A simple command-line notes manager written in Java. You can write and read notes, which are saved to a text file.

## How to Run

1. Make sure you have Java installed (JDK 8 or above).
2. Compile the program:
   ```
   javac -d bin src/NotesApp.java
   ```
3. Run the program:
   ```
   java -cp bin NotesApp
   ```

## Features

- Write a note: Adds your note to a file.
- Read notes: Displays all your saved notes.
- Exit: Closes the app.

## File Structure

- `src/NotesApp.java` - Main Java source file.
- `notes-app.txt` - Where your notes are saved (created automatically).
- `.vscode/settings.json` - VS Code Java project settings.

## Usage

When you run the app, you'll see a menu:
1. Write Note
2. Read Notes
3. Exit

Just enter the number for the action you want!
