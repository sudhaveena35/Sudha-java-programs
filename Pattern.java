public class Pattern {
    public static void main(String[] args) {
        int spaces = 2;
        for (int i = 1; i <= 3; i++) {
            System.out.println(" ".repeat(spaces) + "*".repeat(i));
        }
        System.out.println("***");
        for (int i = 1; i <= 2; i++) {
            System.out.println(" ".repeat(spaces) + "***");
        }
        for (int i = 2; i >= 1; i--) {
            System.out.println(" ".repeat(spaces) + "*".repeat(i));
        }
    }
}




