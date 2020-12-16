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
            land--;
            System.out.println("Ehh, at least you only lost 1 land...");
        }
        else if (inp.equals("don't sign")) {
            System.out.println("\nThe Americans no longer respect your land rights or your tribe. You feel as if you are on the"
                    + "\nedge of war.");
            land--;
            relations--;
            System.out.println("Oof, you lost 1 land and 1 relations");
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
            else System.out.println("\nThe Americans are glad you agree. Your relations has gone up 1");
            relations++;
            System.out.println("Yay! You gained 1 relations");
        }
        else if (inp.equals("protest")) {
            System.out.println("\nThe Americans are angry that you contradicted their Constitution, but they listen to your protests."
                    + "\nInstead of being treated as a seperate sovereign nation, they force you to assimilate into American culture"
                    + "\nand give up the culture of your tribe. They don't grant you citizenship, though.");
            relations --;
            culture --;
            System.out.println("Whoops! You lose 1 relations and 1 culture");
        }
        else if (inp.equals("stay silent")) {
            System.out.println("\nThe Constitution is ratified in 1789 as written.");
            System.out.println("Your relations, culture, and land stay as it was. Not good, not bad.");
        }





        // Treaty of Dancing Rabbit Creek
        // Stay: citizenship = true, culture -1, land -1
        // Go: land -1
        ask = "The year is 1831, and the Americans propose a treaty, the Treaty of Dancing Rabbit Creek." +
                "\nIf you choose to stay, you will gain citizenship, however, if you choose to decline" +
                "\nWell then, I wish you the best" +
                "\nDo you choose to ";
        inp = printAskInput(scanner, ask, new String[] {"stay", "go"});
        if (inp.equals("stay")) {
            System.out.println("The Treaty of Dancing Rabbit Creek marked the very first Native American citizens of the United States." +
                               "\nThe Treaty of Dancing Rabbit Creek was also the first treaty carried into effect under the Indian Removal Act," +
                               "\nmaking a bittersweet landmark for the rights of Native Americans in the US." +
                               "\n\nIn real life, the Choctaw tribe’s land was taken by the US under the Indian Removal Act," +
                               "\nand the Native Americans who chose to stay became US citizens.");
            culture--;
            land--;
            citizenship = true;
            citizenshipstep = 3;
            System.out.println("You still lost 1 culture and 1 land. Too bad, so sad.");
        }
        else if (inp.equals("go")) {
            System.out.println("This action was not representative of real life, and you lost your land. Hopefully it was worth it!");
            land--;
            System.out.println("Well, at least you didn't lose your culture! Minus 1 land.");
        }




        // Dawes Act
        // Accept: citizenship = true, culture -1, land -1
        // Decline: force you to choose land anyways, culture -1, land -1, relations -1
        ask = "The year is 1887, and quite a bit of time has passed since the last treaty was proposed" +
                "\nNow, the Americans propose to create the Dawes Act. The Dawes Act will break up reservations" +
                "\ninto plots of land for each individual family. In exchange for accepting a plot, you will gain citizenship." +
                "\nThe government believes that if Native Americans farm their own land, they will assimilate into American culture" +
                "\nand quite frankly, they wanted to break up tribes" +
                "\nDo you accept this act, or decline?";
        /*
        The Dawes Act broke up reservations into plots of land for each individual family.
        In exchange for accepting a plot, Native Americans would receive citizenship.
        In this act, Native tribes lost 90 million acres of land sold to non-Natives underpriced.
        The government reasoned that if Native Americans farmed their own land, they would assimilate into American culture.
        They also wanted to break up tribes.
        However, Natives were often given land unsuitable for agriculture,
        they did not know how to manage the small amount of money they received,
        and inheritors did not know how to farm.
         */
        inp = printAskInput(scanner, ask, new String[] {"accept", "decline"});
        if (inp.equals("accept")) {
            System.out.println("Well, this certainly is not very good." +
                    "\nYou were given land unsuitable for agriculture," +
                    "\nYou have absolutely no clue how to manage the small amount of money you received." +
                    "\nWorst of all, your inheritors don't know how to farm.");
            if (!citizenship)
                citizenshipstep = 4;
            citizenship = true;
            culture--;
            land--;
            System.out.println("Well, good job! You gained citizenship!\n However, you lost 1 culture, 1 land, and 1 relations." +
                                "\nDare I say, this is not going too well...");
        }
        else if (inp.equals("decline")) {
            System.out.println("Hmm, you did not receive and land. Your tribes culture has gone down because of this," +
                    "\nAnd the Americans are pissed at you, to say the least" +
                    "\nThis choice was not representative of what happened in real life.");
            culture--;
            land--;
            relations--;
            System.out.println("Well, you didn't gain citizenship...");
            System.out.println("On the bright side however, you lost 1 culture, 1 land, and 1 relations");
            System.out.println("Oh... Well it is the bright side for Americans. Cheer for capitalism!");
        }




        
        // Conclusion
        System.out.println("\nThough all Native Americans have gained citizenship, but there is still a long way to go in rights. Native "
                + "\nAmericans do not gain voting rights until the civil rights movement of the 1960s. Now, the Constitution protects all "
                + "\nrights but the journey to that protection was a struggle.");
        
        score = getScore(relations, culture, land, citizenshipstep);
        System.out.println("\nThank you for playing. Your final score is: " + score + ".");
        System.out.println("Did you gain citizenship? (" + citizenship + ")");
        if (citizenship)
            System.out.println("Great job!");
        else
            System.out.println("Better luck next time on gaining citizenship!");

    }

    public static String printAskInput(Scanner s, String msg, String[] responses) {
        System.out.print(msg + "\nInput (" + responsesToString(responses) + "): ");

        String inp = s.nextLine();
        while (!inside(inp, responses)) {
            System.out.print("Choose from (" + responsesToString(responses) + "): ");
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