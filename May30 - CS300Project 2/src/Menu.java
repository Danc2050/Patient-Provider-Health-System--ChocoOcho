//import java.io.*;
import java.util.Scanner;

public class Menu extends Utility {

    //Load in all data from Member, Provider, and Service files.
    public void load_data(MemberList list_of_members, ProviderList list_of_providers, SHistoryTree tree_of_services, ServiceList list_of_all_services) {
        if (list_of_members.read_from_file() == -1)
            System.out.println("\nCould not read from Member List file.");
        if (list_of_providers.read_from_file() == -1)
            System.out.println("\nCould not read from Provider List file.");
        if (tree_of_services.read_from_file() == -1)
            System.out.println("\nCould not read from Service History file.");
        if (list_of_all_services.read_from_file() == -1)
            System.out.println("\nCould not read from Service List file.");
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
        Scanner input = new Scanner(System.in);

        System.out.println("\n\nWhat would you like to do?");
        System.out.println("[1] - Add Member." + "\n[2] - Remove Member." +
                "\n[3] - Update Member" + "\n[4] - Display All Members." +
                "\n[5] - Return to Manager Menu.");

        while (member_response < 1 || member_response > 5) {
            System.out.println("\nEnter response: ");
            member_response = input.nextInt();
            input.nextLine();
        }

        if (member_response == 1) //Add Member
        {
            System.out.println("\nEnter a name: ");
            String name = input.nextLine();

            System.out.println("\nEnter an id: ");
            int id = input.nextInt();

            System.out.println("\nEnter a status: ");
            String m_status = input.nextLine();

            System.out.println("\nEnter a street: ");
            String street = input.nextLine();
            System.out.println("\nEnter a city: ");
            String city = input.nextLine();
            System.out.println("\nEnter a state: ");
            String state = input.nextLine();
            System.out.println("\nEnter a zip: ");
            int zip = input.nextInt();
            Address m_address = new Address(street, city, state, zip);
            
            
            if (list_of_members.add_member_wrapper(id, m_status, name, m_address) == 1)
                System.out.println("\nMember added successfully.");
            else
                System.out.println("\nCould not add member.");
        }

        else if (member_response == 2) {//Remove Member
            System.out.println("\nEnter a name: ");
            String name = input.nextLine();

            System.out.println("\nEnter an id: ");
            int id = input.nextInt();

            list_of_members.remove_member_wrapper(name, id);
        }

        //TODO Update Member.
/*
        else if (member_response == 3) //Update Member
        {
            if (list_of_members.update_member())
            {
                //Success/Fail
            }
        }
*/

        else if (member_response == 4)
            list_of_members.display_all_wrapper();

        else
            return 0;
        return 0;
    }

    public int intMode_Provider(ProviderList list_of_providers) {
        int provider_response = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("What would you like to do?");
        System.out.println("[1] - Add Provider." + "\n[2] - Remove Provider." +
                "\n[3] - Update Provider" + "\n[4] - Display All Providers." +
                "\n[5] - Return to Manager Menu.");

        while (provider_response < 1 || provider_response > 5) {
            System.out.println("\nEnter response: ");
            provider_response = input.nextInt();
            input.nextLine();
        }

        if (provider_response == 1) //Add Provider
        {
            if (list_of_providers.add_provider() == 1)
                System.out.println("\nProvider added successfully.");
            else
                System.out.println("\nCould not add provider.");
        }

        else if (provider_response == 2) //Remove Provider
            list_of_providers.delete();

        //TODO Update Provider.
/*
        else if (provider_response == 3)
        {
            if (list_of_providers.update_provider())
        }
*/

        else if (provider_response == 4)
            list_of_providers.display_all();

        else
            return 0;
        return 0;
    }

    public int intMode_Report(SHistoryTree tree_of_services)
    {
        int report_response = 0;
        int provider_id, member_id;
        Scanner input = new Scanner(System.in);

        System.out.println("\n\nWhat would you like to do?");
        System.out.println("\n[1] Print Provider Report." + "\n[2] Print Patient Report." +
                "\n[3] - Print Summary Report." + "\n[4] Return to Manager Menu.");

        while (report_response < 1 || report_response > 4) {
            System.out.println("\nEnter response:");
            report_response = input.nextInt();
            input.nextLine();
        }

        if (report_response == 1)
        {
            System.out.println("\n\nEnter the ID of the provider you'd like to email the report to: ");
            provider_id = input.nextInt();
            input.nextLine();

            if (tree_of_services.email_p_history(provider_id) == 1)
                System.out.println("\nProvider report has been sent.");
            else
                System.out.println("\nCould not send provider report.");
        }

        else if (report_response == 2)
        {
            System.out.println("\n\nEnter the ID of the member you'd like to email the report to.");
            member_id = input.nextInt();
            input.nextLine();

            if (tree_of_services.email_m_history(member_id) == 1)
                System.out.println("\nMember report has been sent.");
            else
                System.out.println("\nCould not send member report.");
        }

        else if (report_response == 3)
        {
            if (tree_of_services.email_summary_report() == 1)
                System.out.println("\nSummary report was sent.");
            else
                System.out.println("\nCould not send summary report.");
        }

        else
            return 0;
        return 0;
    }

    public int intMode_Service(ServiceList list_of_all_services) {
        int service_response = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("\nWhat would you like to do?");
        System.out.println("[1] - Add Service." + "\n[2] - Remove Service" +
                "\n[3] - Display Services" + "\n[4] - Update Service" +
                "\n[5] - Return to Manager Menu.");

        while (service_response < 1 || service_response > 5)
        {
            System.out.println("\nEnter response.");
            service_response = input.nextInt();
            input.nextLine();
        }

        if (service_response == 1)
        {
            if (list_of_all_services.add_service() == 1)
                System.out.println("\nService added.");
            else
                System.out.println("\nCould not add service.");
        }

        else if (service_response == 2)
        {
            list_of_all_services.delete();
            System.out.println("\nService removed.");
        }

        else if (service_response == 3)
            list_of_all_services.display_all();

        else if (service_response == 4)
        {
            if (list_of_all_services.updateService())
                System.out.println("\nService updated.");
            else
                System.out.println("\nCould not update service.");
        }

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
        int catcher = 0;
        int response = 0;
        int mem_num = 0;
        int provide_service = 0;

        System.out.println("\n\nFirst, let's validate the patient's ID.");
        System.out.println("Enter the patient's ID:");

        mem_num = input.nextInt();
        input.nextLine();

        catcher = list_of_members.validate_member_wrapper(mem_num);

        while (catcher == -1)
        {
            System.out.println("\nInvalid Member ID.");
            System.out.println("\n[1] - Try again." + "\n[2] - Return to Provider Menu.");

            while (response < 1 || response > 2)
            {
                System.out.println("\nEnter response: ");
                response = input.nextInt();
                input.nextLine();
            }

            if (response == 1)
                catcher = list_of_members.validate_member_wrapper(mem_num);
            else
                return 0;
        }

        if (catcher == 0)
        {
            System.out.println("\nMember is suspended.");
            System.out.println("\nProvide service anyway?");
            System.out.println("\n[1] - Yes." + "\n[2] - No.");

            while (provide_service < 1 || provide_service > 2)
            {
                System.out.println("\nEnter response: ");
                provide_service = input.nextInt();
                input.nextLine();
            }
        }

        else if (catcher == 1)
        {
            System.out.println("\nID validated.");
            System.out.println("\nWould you like to proceed with the service?");
            System.out.println("\n[1] - Yes." + "\n[2] - No.");

            while (provide_service < 1 || provide_service > 2)
            {
                System.out.println("\nEnter response: ");
                provide_service = input.nextInt();
                input.nextLine();
            }
        }

        if (provide_service == 1)
            return 1;
        return 0;
    }

    public void create_service(SHistoryTree tree_of_services, ServiceList list_of_all_services)
    {
        int service = 0;
        int response = 0;
        boolean catcher;

        System.out.println("\nLet's check if the service you're about to provide" +
                "is in our directory.");
        System.out.println("\nWhat is the service ID you'd like to enter into patient's history?");
        service = input.nextInt();
        input.nextLine();

        catcher = list_of_all_services.check_service_wrapper(service);

        //while loop will keep trying until catcher becomes true (there is a service match) or
        //Provider returns to main menu.
        while (!catcher)
        {
            System.out.println("\nService is NOT in directory.");
            System.out.println("\n[1] - Try again." + "\n[2] - Return to Provider Menu.");

            while (response < 1 || response > 2)
            {
                System.out.println("\nEnter response: ");
                response = input.nextInt();
                input.nextLine();
            }

            if (response == 1)
            {
                System.out.println("\nPlease enter the service ID again: ");
                service = input.nextInt();
                input.nextLine();
                catcher = list_of_all_services.check_service_wrapper(service);
            }

            else if (response == 2)
                return;
        }

        System.out.println("\nService is in directory.");

        if (tree_of_services.add_history(service) == 1)
            System.out.println("\nService added to service history.");
        else
            System.out.println("\nCould not add service.");
    }
}
