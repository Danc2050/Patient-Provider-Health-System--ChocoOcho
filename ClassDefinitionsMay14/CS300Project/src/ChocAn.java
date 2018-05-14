import java.util.Scanner;
public class ChocAn {

    public static void main(String[] args) {
/*
 	Main.java is designed to allow providers to interact with the ChocAn data processing software
	system.
*/
            Scanner input = new Scanner(System.in);
            /*Lets a terminal user choose between Interactive Mode and a Provider/Manager mode.*/
            public static int mainMode()
            {
                System.out.println("\nChoose a mode.");
                System.out.println("\n[1] - Interactive Mode" + "\n[2] - Provider/Manager Mode.");
                int x = input.nextInt();
                input.nextLine();//Cin.ignore
                return x;
            }
            /*Lets a user choose what they want to do in intMode. Note: the action (add, remove, update) is not used in this prototype*/
            public static int intMode() {//Implement a use... Example: call an add function with string "member" or "provider". Or create Member or Provider object and pass in to use Dynamic binding.
                System.out.println("What do you want to access?");
                System.out.println("[1] - Member mode." + "\n[2] - Provider mode." + "\n[3] - Manager mode.");
                int mode = input.nextInt();
                input.nextLine();
                //Interactive mode.
                System.out.println("Choose from the options below.");
                System.out.println("[1] - Add." + "\n[2] - Remove." + "\n[3] - Update");
                int job = input.nextInt();
                input.nextLine();
                return mode;
            }
            /*The Provider Menu.*/
            public static int providerMenu() {
                System.out.println("Choose from the options below." + "\n[1] - Provider Directory." + "\n[2] - Create Member Report." + "\n[3] - Access ChocAn Billing Services.");
                return input.nextInt();
            }
            /*Verifies a user is in the system (print statements and if conditionals only).*/
            public static boolean verifyW() {
                System.out.println("Slide member card into terminal (enter I.D. #).");
                int id = input.nextInt();
                input.nextLine();
                /*if(verify() == 1)//Member is active.
                 *{
                 * 		System.out.println("Validated");
                 * 		return true;
                 * }
                 *else if(verify() == -1)
                 *{
                 *		System.out.println("Member Suspended");
                 *		return 0;
                 *}
                 *else
                 *{
                 *		System.out.println("Invalid number")
                 *		return 0;
                 *}
                 */
                return true;
            }
            /*MAIN*/
            public static void main(String[] args) {
                int x = mainMode();
//Switch #1 -- main mode.
                switch(x)
                {
                    case 0: x = mainMode(); System.out.println("\nX: " + x); break;
                    case 1: System.out.println("You are in interactive mode.");
                        intMode();
                        break;
                    case 2: System.out.println("You are in Provider/Manager mode.");
                        if(verifyW())
                        {
                            int y = providerMenu();
                            switch(y)
                            {
                                case 1: //providerDir(); break;
                                case 2: //memReport(); break;
                                case 3: //bill(); break;
                                default: System.out.println("\nIncorrect entry");
                            }
                            break;
                        }
                        else//return to terminal
                            x = 0; break;
                    case 3: System.out.println("You are in manager mode.");
                    default: System.out.println("\nIncorrect entry.");
                        break;
                };
            }
        }

    }
}
