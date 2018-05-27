import java.io.*;
import java.util.Scanner;

public class Menu extends Utility {

    /*Lets a terminal user choose between Interactive Mode and a Provider/Manager mode.*/
    public static int mainMode()
    {
        int response = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("\n\nChoose a mode.");
        System.out.println("\n[1] - Interactive/Manager Mode" + "\n[2] - Provider Mode.");

        while (response < 1 || response > 2)
        {
            System.out.println("\nEnter response: ");
            response = input.nextInt();
            input.nextLine();
        }
        return response;
    }

    /*Lets a user choose what they want to do in intMode. Note: the action (add, remove, update) is not used in this prototype*/
    public static int intMode()
    {
        //Implement a use... Example: call an add function with string "member" or "provider". Or create Member or Provider object and pass in to use Dynamic binding.
        int response = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("\n\nWhat do you want to access?");
        System.out.println("[1] - Member." + "\n[2] - Provider.");

        while (response < 1 || response > 2) {
            System.out.println("\nEnter response: ");
            response = input.nextInt();
            input.nextLine();
        }
        return response;
    }

    public static int intMode_Member(MemberList list_of_members)
    {
        int member_response = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("\n\nWhat would you like to do?");
        System.out.println("[1] - Add Member." + "\n[2] - Remove Member." + "\n[3] - Update Member");

        while (member_response < 1 || member_response > 3)
        {
            System.out.println("\nEnter response: ");
            member_response = input.nextInt();
            input.nextLine();
        }

        if (member_response == 1) //Add Member
        {
            if (list_of_members.add_member())
            {
                //Success/Fail
            }
        }

        else if (member_response == 2) //Remove Member
        {
            if (list_of_members.remove_member())
            {
                //Success/Fail
            }
        }

        else
        {
            if (list_of_members.update_member())
            {
                //Success/Fail
            }
        }
        return 0;
    }

    public static int intMode_Provider(ProviderList list_of_providers)
    {
        int provider_response = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("What would you like to do?");
        System.out.println("[1] - Add Provider." + "\n[2] - Remove Provider." + "\n[3] - Update Provider");

        while (provider_response < 1 || provider_response > 3)
        {
            System.out.println("\nEnter response: ");
            provider_response = input.nextInt();
            input.nextLine();
        }

        if (provider_response == 1) //Add Provider
        {
            if (list_of_providers.add_provider())
                //Success/Fail
        }

        else if (provider_response == 2)
        {
            if (list_of_providers.remove_provider())
        }

        else
        {
            if (list_of_providers.update_provider())
        }
        return 0;
    }


    /*The Provider Menu.*/
    public static int providerMenu()
    {
        int response = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("\n\nChoose from the options below." +
                "\n[1] - Provider Directory." + "\n[2] - Create Member Report." +
                "\n[3] - Access ChocAn Billing Services.");

        while (response < 1 || response > 3)
        {
            System.out.println("\nEnter response: ");
            response = input.nextInt();
            input.nextLine();
        }

        if (response == 1)
        {
            //TODO Write Provider Directory to file
        }

        else if (response == 2)
        {
            //TODO Create member report
        }

        else
        {
            //TODO Access ChocAn Billing Services
        }

        return 0;
    }

    /*Verifies a user is in the system (print statements and if conditionals only).*/
    public static boolean verifyW()
    {
        int id = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("Slide member card into terminal (enter I.D. #).");
        id = input.nextInt();
        input.nextLine();

        if (verify(id) == 1)
        {
            System.out.println("Validated.");
            return true;
        }

        else if (verify(id) == -1)
            System.out.println("Member suspended.");

        else
            System.out.println("Invalid ID number.");

        return false;
    }
}
