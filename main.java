import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class main {

    static int[] array = new int[200];
    static int size = 0;

    public static void main(String[] args) {

        readFile("A1input.txt");

        Scanner input = new Scanner(System.in);
        int choice = 0;

        while (choice != 6) {

            System.out.println("\n        MENU");
            System.out.println("1. Search for integer");
            System.out.println("2. Modify integer by index");
            System.out.println("3. Add integer to end");
            System.out.println("4. Remove integer by index");
            System.out.println("5. Display array");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            choice = input.nextInt();

            if (choice == 1) {
                System.out.print("Enter number to search: ");
                int num = input.nextInt();

                int index = search(num);

                if (index != -1)
                    System.out.println("Found at index: " + index);
                else
                    System.out.println("Number not found.");
            }

            else if (choice == 2) {
                try {
                    System.out.print("Enter index: ");
                    int index = input.nextInt();

                    System.out.print("Enter new value: ");
                    int newValue = input.nextInt();

                    modify(index, newValue);
                }
                catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Invalid index!");
                }
            }

            else if (choice == 3) {
                try {
                    System.out.print("Enter value to add: ");
                    int value = input.nextInt();
                    add(value);
                }
                catch (Exception e) {
                    System.out.println("Error adding value.");
                }
            }

            else if (choice == 4) {
                System.out.print("Enter index to remove: ");
                int index = input.nextInt();
                remove(index);
            }

            else if (choice == 5) {
                display();
            }

            else if (choice == 6) {
                System.out.println("Program ended.");
            }

            else {
                System.out.println("Invalid choice.");
            }
        }

        input.close();
    }

    // Read file into array
    public static void readFile(String filename) {
        try {
            Scanner file = new Scanner(new File(filename));

            while (file.hasNextInt()) {
                array[size] = file.nextInt();
                size++;
            }

            file.close();
            System.out.println("File loaded successfully.");

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    // Search function
    public static int search(int number) {
        for (int i = 0; i < size; i++) {
            if (array[i] == number)
                return i;
        }
        return -1;
    }

    // Modify function
    public static void modify(int index, int newValue) {
        if (index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException();

        int oldValue = array[index];
        array[index] = newValue;

        System.out.println("Old value: " + oldValue);
        System.out.println("New value: " + newValue);
    }

    // Add function
    public static void add(int value) {
        array[size] = value;
        size++;
        System.out.println("Value added.");
    }

    // Remove function
    public static void remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index.");
            return;
        }

        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }

        size--;
        System.out.println("Value removed.");
    }

    // Display array
    public static void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
