import java.util.Scanner;

// Node structure for each word in the dictionary
class Node {
    String word;
    String meaning;
    Node next;

    Node(String word, String meaning) {
        this.word = word;
        this.meaning = meaning;
        this.next = null;
    }
}

public class PersonalDictionary {
    private Node head = null;
    private Scanner scanner = new Scanner(System.in);

    // Insert a new word in alphabetical order
    public void insertWord() {
        System.out.print("Enter the word: ");
        String word = scanner.nextLine();
        System.out.print("Enter the meaning: ");
        String meaning = scanner.nextLine();

        Node newNode = new Node(word, meaning);

        if (head == null || word.compareToIgnoreCase(head.word) < 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null && current.next.word.compareToIgnoreCase(word) < 0) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        System.out.println("Word inserted successfully!");
    }

    // Delete a word from the dictionary
    public void deleteWord() {
        if (head == null) {
            System.out.println("Dictionary is empty!");
            return;
        }

        System.out.print("Enter the word to delete: ");
        String target = scanner.nextLine();

        Node current = head, previous = null;

        while (current != null && !current.word.equalsIgnoreCase(target)) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Word not found!");
        } else {
            if (previous == null) {
                head = current.next;
            } else {
                previous.next = current.next;
            }
            System.out.println("Word deleted successfully!");
        }
    }

    // Update the meaning of a word
    public void updateMeaning() {
        if (head == null) {
            System.out.println("Dictionary is empty!");
            return;
        }

        System.out.print("Enter the word to update: ");
        String target = scanner.nextLine();

        Node current = head;
        while (current != null && !current.word.equalsIgnoreCase(target)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Word not found!");
        } else {
            System.out.print("Enter the new meaning: ");
            current.meaning = scanner.nextLine();
            System.out.println("Meaning updated successfully!");
        }
    }

    // Display all words
    public void displayDictionary() {
        if (head == null) {
            System.out.println("Dictionary is empty!");
            return;
        }

        System.out.println("\n--- Dictionary Contents ---");
        Node current = head;
        while (current != null) {
            System.out.println("Word: " + current.word);
            System.out.println("Meaning: " + current.meaning + "\n");
            current = current.next;
        }
    }

    // Search for a word
    public void searchWord() {
        if (head == null) {
            System.out.println("Dictionary is empty!");
            return;
        }

        System.out.print("Enter the word to search for: ");
        String target = scanner.nextLine();

        Node current = head;
        while (current != null && !current.word.equalsIgnoreCase(target)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Word not found!");
        } else {
            System.out.println("Word: " + current.word);
            System.out.println("Meaning: " + current.meaning);
        }
    }

    // Display menu
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
                case 1:
                    insertWord();
                    break;
                case 2:
                    deleteWord();
                    break;
                case 3:
                    updateMeaning();
                    break;
                case 4:
                    displayDictionary();
                    break;
                case 5:
                    searchWord();
                    break;
                case 6:
                    System.out.println("Exiting the program.");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        PersonalDictionary dict = new PersonalDictionary();
        dict.run();
    }
}
