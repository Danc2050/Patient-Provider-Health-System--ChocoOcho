import java.io.*;
import java.util.Scanner;

public class Menu extends Utility {

    //Load in all data from Member, Provider, and Service files.
    public int load_data(MemberList list_of_members, ProviderList list_of_providers, SHistoryTree tree_of_services, ServiceList list_of_all_services)
    {
        if (list_of_members.read_from_file() == -1)
            System.out.println("\nCould not read from Member List file.");
        if (list_of_providers.read_from_file() == -1)
            System.out.println("\nCould not read from Provider List file.");
        if (tree_of_services.read_from_file() == -1)
            System.out.println("\nCould not read from Service History file.");
        if (list_of_all_services.read_from_file() == -1)
            System.out.println("\nCould not read from Service List file.");
        return 0;
    }
    /*Lets a terminal user choose between Interactive Mode and a Provider/Manager mode.*/
    public int mainMode()
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

    /*********The Manager Menu.**********/
    /*Lets a user choose what they want to do in intMode. Note: the action (add, remove, update) is not used in this prototype*/
    public int intMode()
    {
        //Implement a use... Example: call an add function with string "member" or "provider". Or create Member or Provider object and pass in to use Dynamic binding.
        int response = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("\n\nWhat do you want to access?");
        System.out.println("[1] - Member." + "\n[2] - Provider." +
                "\n[3] - Report" + "\n[4] - Services");

        while (response < 1 || response > 4) {
            System.out.println("\nEnter response: ");
            response = input.nextInt();
            input.nextLine();
        }
        return response;
    }

    public int intMode_Member(MemberList list_of_members)
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

        /*if (member_response == 1) //Add Member
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
        }*/
        return 0;
    }

    public int intMode_Provider(ProviderList list_of_providers)
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

        /*if (provider_response == 1) //Add Provider
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
        }*/
        return 0;
    }

    public int intMode_Report()
    {
        int report_response = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("What would you like to do?");
        System.out.println("[1] Print Provider Report." + "\n[2] Print Patient Report.");

        while (report_response < 1 || report_response > 2)
        {
            System.out.println("\nEnter response:");
            report_response = input.nextInt();
            input.nextLine();
        }

        if (report_response == 1)
        {
            //TODO Print Provider Report
        }
        else if (report_response == 2)
        {
            //TODO Print Patient Report
        }
        return 1;
    }

    public int intMode_Service(ServiceList list_of_all_services)
    {
        int service_response = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("\nWhat would you like to do?");
        System.out.println("[1] - Add Service." + "\n[2] - Remove Service" + "\n[3] - Display Services");

        while (service_response < 1 || service_response > 3)
        {
            System.out.println("\nEnter response.");
            service_response = input.nextInt();
            input.nextLine();
        }

        if (service_response == 1)
        {
            list_of_all_services.add_service();
                System.out.println("\nService added.");
        }

        else if (service_response == 2)
        {
            /*if (list_of_all_services.remove_service())todo uncomment(test)
                System.out.println("\nService removed.");*/
        }

        else
            list_of_all_services.display_all();

        return 0;
    }



    /**********The Provider Menu.**********/
    public int providerMenu()
    {
        int response = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("\n\nChoose from the options below." +
                "\n[1] - Provider Directory." + "\n[2] - Validate Member." +
                "\n[3] - Create New Service.");

        while (response < 1 || response > 3) {
            System.out.println("\nEnter response: ");
            response = input.nextInt();
            input.nextLine();
        }

        return response;
    }

    public void providerMenu_directory(ServiceList list_of_all_services)
    {
        System.out.println("Here is a list of all the services.");
        list_of_all_services.display_all();
    }

    public int validate_member(MemberList list_of_members)
    {
        //TODO Correct parameters for validate member. Wrapper?
        //return list_of_members.validate_member();todo uncomment
        return 0;
    }

    public int create_service()
    {
        //TODO Provider add a service they have just provided to a member
        return 0;
    }



    /*Verifies a user is in the system (print statements and if conditionals only).*/
    /*public static boolean verifyW()
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
    }*/
}
