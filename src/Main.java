import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        int relations = 0;
        int culture = 0;
        int land = 0;
        boolean citizenship = false;

        Scanner scanner = new Scanner(System.in);


        String inp = printAskInput(scanner, "Welcome to the historically accurate game!", new String[] {"Continue"});
    }

    public static String printAskInput(Scanner s, String msg, String[] responses) {
        System.out.print(msg + "\nInput (" + responsesToString(responses) + "): ");

        String inp = s.next();
        while (!inside(inp, responses)) {
            System.out.println();
            inp = s.next();
        }

        return s.next();
    }

    public static boolean inside(String a, String[] arr) {
        for (int i = 0; i < arr.length; i++)
            if (a.equals(arr[i]))
                return true;
        return false;
    }

    public static String responsesToString(String[] arr) {
        String out = "";
        for (int i = 0; i < arr.length; i++) {
            out += arr[i] + "/";
        }
        return out;
    }

}