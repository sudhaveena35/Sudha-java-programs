public class Roman{
    public static int romanToInt(String s) {
        int result = 0;
        int prevValue = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int value = romanCharToInt(s.charAt(i));
            if (value >= prevValue) {
                result += value;
            } else {
                result -= value;
            }
            prevValue = value;
        }
        return result;
    }
    private static int romanCharToInt(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
    public static void main(String[] args) {
        String roman = "CX";
        int number = romanToInt(roman);
        System.out.println("Roman numeral " + roman + " is " + number);
    }
}
