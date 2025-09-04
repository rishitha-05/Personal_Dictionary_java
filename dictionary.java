import java.util.*;

class WordEntry {
    String word;
    String meaning;

    WordEntry(String word, String meaning) {
        this.word = word;
        this.meaning = meaning;
    }
}

public class PersonalDictionary {
    private LinkedList<WordEntry> dictionary = new LinkedList<>();
    private Scanner scanner = new Scanner(System.in);

    // Insert in alphabetical order
    public void insertWord() {
        System.out.print("Enter the word: ");
        String word = scanner.nextLine();
        System.out.print("Enter the meaning: ");
        String meaning = scanner.nextLine();

        WordEntry newEntry = new WordEntry(word, meaning);

        if (dictionary.isEmpty()) {
            dictionary.add(newEntry);
        } else {
            int i = 0;
            while (i < dictionary.size() &&
                   dictionary.get(i).word.compareToIgnoreCase(word) < 0) {
                i++;
            }
            dictionary.add(i, newEntry);
        }
        System.out.println("Word inserted successfully!");
    }

    // Delete a word
    public void deleteWord() {
        System.out.print("Enter the word to delete: ");
        String target = scanner.nextLine();

        boolean removed = dictionary.removeIf(entry -> entry.word.equalsIgnoreCase(target));
        if (removed) {
            System.out.println("Word deleted successfully!");
        } else {
            System.out.println("Word not found!");
        }
    }

    // Update meaning
    public void updateMeaning() {
        System.out.print("Enter the word to update: ");
        String target = scanner.nextLine();

        for (WordEntry entry : dictionary) {
            if (entry.word.equalsIgnoreCase(target)) {
                System.out.print("Enter the new meaning: ");
                entry.meaning = scanner.nextLine();
                System.out.println("Meaning updated successfully!");
                return;
            }
        }
        System.out.println("Word not found!");
    }

    // Display
    public void displayDictionary() {
        if (dictionary.isEmpty()) {
            System.out.println("Dictionary is empty!");
            return;
        }
        System.out.println("\n--- Dictionary Contents ---");
        for (WordEntry entry : dictionary) {
            System.out.println("Word: " + entry.word);
            System.out.println("Meaning: " + entry.meaning + "\n");
        }
    }

    // Search
    public void searchWord() {
        System.out.print("Enter the word to search for: ");
        String target = scanner.nextLine();

        for (WordEntry entry : dictionary) {
            if (entry.word.equalsIgnoreCase(target)) {
                System.out.println("Word: " + entry.word);
                System.out.println("Meaning: " + entry.meaning);
                return;
            }
        }
        System.out.println("Word not found!");
    }

    // Menu
    private void displayMenu() {
        System.out.println("\n--- Personal Dictionary Menu ---");
        System.out.println("1. Insert a new word");
        System.out.println("2. Delete a word");
        System.out.println("3. Update a word's meaning");
        System.out.println("4. Display all words");
        System.out.println("5. Search for a word");
        System.out.println("6. Exit");
    }

    public void run() {
        while (true) {
            displayMenu();
            System.out.print("Enter your choice: ");
            int choice;

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice! Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1: insertWord(); break;
                case 2: deleteWord(); break;
                case 3: updateMeaning(); break;
                case 4: displayDictionary(); break;
                case 5: searchWord(); break;
                case 6: System.out.println("Exiting..."); return;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    public static void main(String[] args) {
        new PersonalDictionary().run();
    }
}
