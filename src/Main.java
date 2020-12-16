import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        int relations = 2;
        int culture = 3;
        int land = 3;
        boolean citizenship = false;
        int citizenshipstep = 0; // is the step that citizenship is reached at
        int score;

        Scanner scanner = new Scanner(System.in);

        // 1785, step 1
        String inp = printAskInput(scanner, "Welcome to the historically accurate game!", new String[] {"Continue"});
        
        String ask = "\nThe year is 1785. The new United States of America proposes that your tribe signs the Treaty"
                + "\nof Hopewell. The treaty establishes boundaries between your land and the United States, but promises"
                + "\nto protect your land. But the United States also regulates trade and takes prisoners who commit murder"
                + "\nor robbery. Do you sign the treaty?";
        inp = printAskInput(scanner, ask, new String[] {"sign", "don't sign"});
        if (inp.equals("sign")) {
            System.out.println("\nYou sign the treaty, but the United States breaks it soon after. At least you are on good "
                    + "\nterms with the Americans, well, for now.");
            land --;
        }
        else if (inp.equals("don't sign")) {
            System.out.println("\nThe Americans no longer respect your land rights or your tribe. You feel as if you are on the"
                    + "\nedge of war.");
            land --;
            relations --;
        }
        
        // 1787, step 2
        ask = "\nIn 1787, the framers draft the United States Constitution. They decided that you were not citizens of the United "
                + "\nStates and could not be taxed, treating your tribe as a different sovereignty. They also assign Congress as"
                + "\nthe branch responsible for indiginous relations. Do you publicly support the Constitution, protest it, or"
                + "\n stay silent?";
        inp = printAskInput(scanner, ask, new String[] {"support", "protest", "stay silent"});
        if (inp.equals("support")) {
            if (relations == 0)
                System.out.println("\nThe Americans are no longer angry at you for refusing to sign the treaty.");
            else System.out.println("\nThe Americans are glad you agree.");
            relations ++;
        }
        else if (inp.equals("protest")) {
            System.out.println("\nThe Americans are angry that you contradicted their Constitution, but they listen to your protests."
                    + "\nInstead of being treated as a seperate sovereign nation, they force you to assimilate into American culture"
                    + "\nand give up the culture of your tribe. They don't grant you citizenship, though.");
            relations --;
            culture --;
        }
        else if (inp.equals("stay silent")) {
            System.out.println("\nThe Constitution is ratified in 1789 as written.");
        }
        
        // Conclusion
        System.out.println("\nThough all Native Americans have gained citizenship, but there is still a long way to go in rights. Native "
                + "\nAmericans do not gain voting rights until the civil rights movement of the 1960s. Now, the Constitution protects all "
                + "\nrights but the journey to that protection was a struggle.");
        
        score = getScore(relations, culture, land, citizenshipstep);
        System.out.println("\nThank you for playing. Your final score is: " + score + ".");

    }

    public static String printAskInput(Scanner s, String msg, String[] responses) {
        System.out.print(msg + "\nInput (" + responsesToString(responses) + "): ");

        String inp = "";
        while (!inside(inp, responses)) {
            inp = s.nextLine();
        }

        return inp;
    }

    public static boolean inside(String a, String[] arr) {
        for (int i = 0; i < arr.length; i++)
            if (a.equals(arr[i])) {
                return true;
            }
        return false;
    }

    public static String responsesToString(String[] arr) {
        String out = "";
        for (int i = 0; i < arr.length; i++) {
            out += arr[i] + "/";
        }
        return out.substring(0, out.length()-1);
    }
    
    public static int getScore(int relations, int culture, int land, int citizenshipstep) {
        return relations * 1000 + culture * 1000 + land * 1000 + citizenshipstep * 2500;
    }

}