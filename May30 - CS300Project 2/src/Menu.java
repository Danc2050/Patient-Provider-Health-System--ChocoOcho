import java.io.*;
import java.util.Scanner;

public class Menu extends Utility {

    //Load in all data from Member, Provider, and Service files.
    public int load_data(MemberList list_of_members, ProviderList list_of_providers, SHistoryTree tree_of_services, ServiceList list_of_all_services) {
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
    public int mainMode() {
        int response = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("\n\nChoose a mode.");
        System.out.println("\n[1] - Interactive/Manager Mode" +
                "\n[2] - Provider Mode." + "\n[3] - Exit");

        while (response < 1 || response > 3) {
            System.out.println("\nEnter response: ");
            response = input.nextInt();
            input.nextLine();
        }
        return response;
    }

    /*********The Manager Menu.**********/
    /*Lets a user choose what they want to do in intMode. Note: the action (add, remove, update) is not used in this prototype*/
    public int intMode() {
        //Implement a use... Example: call an add function with string "member" or "provider". Or create Member or Provider object and pass in to use Dynamic binding.
        int response = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("\n\nYou are in Manager Mode." + "\nWhat would you like to access?");
        System.out.println("[1] - Member." + "\n[2] - Provider." +
                "\n[3] - Report" + "\n[4] - Services" + "\n[5] - Return to Main Menu");

        while (response < 1 || response > 5) {
            System.out.println("\nEnter response: ");
            response = input.nextInt();
            input.nextLine();
        }
        return response;
    }

    public int intMode_Member(MemberList list_of_members) {
        int member_response = 0;
        int catcher = 0; //Catch return value
        Scanner input = new Scanner(System.in);

        System.out.println("\n\nWhat would you like to do?");
        System.out.println("[1] - Add Member." + "\n[2] - Remove Member." +
                "\n[3] - Update Member" + "\n[4] - Return to Manager Menu.");

        while (member_response < 1 || member_response > 4) {
            System.out.println("\nEnter response: ");
            member_response = input.nextInt();
            input.nextLine();
        }

        if (member_response == 1) //Add Member
        {
            catcher = list_of_members.add_member_wrapper();
            if (catcher == 1)
            {
                System.out.println("\nMember added successfully.");
            }
        }

        else if (member_response == 2) //Remove Member
            list_of_members.delete();

        //TODO Update Member.
/*
        else if (member_response == 3) //Update Member
        {
            if (list_of_members.update_member())
            {
                //Success/Fail
            }
        }

        else
            return 0;
        */
        return 0;
    }

    public int intMode_Provider(ProviderList list_of_providers) {
        int provider_response = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("What would you like to do?");
        System.out.println("[1] - Add Provider." + "\n[2] - Remove Provider." +
                "\n[3] - Update Provider" + "\n[4] - Return to Manager Menu.");

        while (provider_response < 1 || provider_response > 4) {
            System.out.println("\nEnter response: ");
            provider_response = input.nextInt();
            input.nextLine();
        }

        //TODO Provider Manipulation.
        /*if (provider_response == 1) //Add Provider
        {
            if (list_of_providers.add_provider())
                //Success/Fail
        }

        else if (provider_response == 2)
        {
            if (list_of_providers.remove_provider())
        }

        else if (provider_response == 3)
        {
            if (list_of_providers.update_provider())
        }

        else
            return 0;
        */
        return 0;
    }

    public int intMode_Report() {
        int report_response = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("What would you like to do?");
        System.out.println("[1] Print Provider Report." + "\n[2] Print Patient Report." +
                "\n[3] Return to Manager Menu.");

        while (report_response < 1 || report_response > 3) {
            System.out.println("\nEnter response:");
            report_response = input.nextInt();
            input.nextLine();
        }

        if (report_response == 1) {
            //TODO Print Provider Report
        } else if (report_response == 2) {
            //TODO Print Patient Report
        } else
            return 0;
        return 0;
    }

    public int intMode_Service(ServiceList list_of_all_services) {
        int service_response = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("\nWhat would you like to do?");
        System.out.println("[1] - Add Service." + "\n[2] - Remove Service" +
                "\n[3] - Display Services" + "\n[4] - Return to Manager Menu.");

        while (service_response < 1 || service_response > 4) {
            System.out.println("\nEnter response.");
            service_response = input.nextInt();
            input.nextLine();
        }

        if (service_response == 1) {
            list_of_all_services.add_service();
            System.out.println("\nService added.");
        } else if (service_response == 2) {
            /*if (list_of_all_services.remove_service())todo uncomment(test)
                System.out.println("\nService removed.");*/
        } else if (service_response == 3)
            list_of_all_services.display_all();

        else
            return 0;

        return 0;
    }


    /**********The Provider Menu.**********/
    public int providerMenu() {
        int response = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("\n\nYou are in Provider Mode." + "\nWhat would you like to do?" +
                "\n[1] - Display Provider Directory." + "\n[2] - Provide a Service." +
                "\n[3] - Return to Main Menu.");

        while (response < 1 || response > 3) {
            System.out.println("\nEnter response: ");
            response = input.nextInt();
            input.nextLine();
        }

        return response;
    }

    public void providerMenu_directory(ServiceList list_of_all_services) {
        System.out.println("\nHere is a list of all the services.");
        list_of_all_services.display_all();
    }

    public int validate_member(MemberList list_of_members) {
        System.out.println("\n\nFirst, let's validate the patient's ID.");
        System.out.println("Enter the patient's ID:");

        int mem_num = input.nextInt();
        input.nextLine();
        return list_of_members.validate_member_wrapper(mem_num);
    }

    public int create_service() {
        //TODO Provider add a service they have just provided to a member
        return 0;
    }
}
