import java.io.*;
import java.util.Scanner;

public class Menu extends Utility {

    /*Lets a terminal user choose between Interactive Mode and a Provider/Manager mode.*/
    public static int mainMode()
    {
        int response = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("\nChoose a mode.");
        System.out.println("\n[1] - Interactive/Manager Mode" + "\n[2] - Provider Mode.");

        while (response > 2 || response < 1)
        {
            response = input.nextInt();
            input.nextLine();
        }
        return response;
    }

    /*Lets a user choose what they want to do in intMode. Note: the action (add, remove, update) is not used in this prototype*/
    public static int intMode()
    {
        //Implement a use... Example: call an add function with string "member" or "provider". Or create Member or Provider object and pass in to use Dynamic binding.
        Scanner input = new Scanner(System.in);
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
    public static int providerMenu()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Choose from the options below." + "\n[1] - Provider Directory." + "\n[2] - Create Member Report." + "\n[3] - Access ChocAn Billing Services.");
        return input.nextInt();
    }
    /*Verifies a user is in the system (print statements and if conditionals only).*/
    public static boolean verifyW()
    {
        Scanner input = new Scanner(System.in);
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
}
