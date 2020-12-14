import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        int relations = 0;
        int culture = 0;
        int land = 0;
        boolean citizenship = false;

        Scanner scanner = new Scanner(System.in);

        String inp = printInput(scanner, "Welcome to the game! Now you've lost the game!");
    }

    public static String printInput(Scanner s, String msg) {
        System.out.println(msg + "\nInput: ");
        return s.next();
    }

}