import java.util.Scanner;
public class ArrayOperations {
    static int[] arr = new int[100];
    static int size = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter initial number of elements: ");
        size = sc.nextInt();
        System.out.println("Enter elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        boolean exit = false;
        while (!exit) {
            System.out.println("\n--- Array Operations Menu ---");
            System.out.println("1. Access");
            System.out.println("2. Insert");
            System.out.println("3. Delete");
            System.out.println("4. Linear Search");
            System.out.println("5. Binary Search");
            System.out.println("6. Bubble Sort");
            System.out.println("7. Display Array");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter index to access: ");
                    int index = sc.nextInt();
                    access(index);
                    break;
                case 2:
                    System.out.print("Enter element to insert: ");
                    int value = sc.nextInt();
                    System.out.print("Enter position (0 to " + size + "): ");
                    int pos = sc.nextInt();
                    insert(value, pos);
                    break;
                case 3:
                    System.out.print("Enter position to delete: ");
                    int delPos = sc.nextInt();
                    delete(delPos);
                    break;
                case 4:
                    System.out.print("Enter element to search (Linear): ");
                    int linTarget = sc.nextInt();
                    linearSearch(linTarget);
                    break;
                case 5:
                    bubbleSort();
                    System.out.print("Enter element to search (Binary): ");
                    int binTarget = sc.nextInt();
                    binarySearch(binTarget);
                    break;
                case 6:
                    bubbleSort();
                    break;
                case 7:
                    display();
                    break;
                case 8:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        sc.close();
    }

    static void access(int index) {
        if (index >= 0 && index < size) {
            System.out.println("Element at index " + index + " is: " + arr[index]);
        } else {
            System.out.println("Invalid index!");
        }
    }

    static void insert(int value, int pos) {
        if (pos < 0 || pos > size) {
            System.out.println("Invalid position!");
            return;
        }
        for (int i = size; i > pos; i--) {
            arr[i] = arr[i - 1];
        }
        arr[pos] = value;
        size++;
        System.out.println("Element inserted.");
    }

    static void delete(int pos) {
        if (pos < 0 || pos >= size) {
            System.out.println("Invalid position!");
            return;
        }
        for (int i = pos; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
        System.out.println("Element deleted.");
    }

    static void linearSearch(int target) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == target) {
                System.out.println("Element found at index: " + i);
                return;
            }
        }
        System.out.println("Element not found.");
    }

    static void binarySearch(int target) {
        int low = 0, high = size - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                System.out.println("Element found at index: " + mid);
                return;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println("Element not found.");
    }

    static void bubbleSort() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("Array sorted using Bubble Sort.");
    }

    static void display() {
        System.out.print("Array elements: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}


