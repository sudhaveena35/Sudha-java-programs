import java.util.Scanner;
public class NeedleInHaystack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the haystack (main text): ");
        String haystack = scanner.nextLine();
        System.out.print("Enter the needle (text to find): ");
        String needle = scanner.nextLine();
        int position = haystack.indexOf(needle);
        if (position != -1) {
            System.out.println("Needle found at index: " + position);
        } else {
            System.out.println("Needle not found in the haystack.");
        }
        scanner.close();
    }
}
