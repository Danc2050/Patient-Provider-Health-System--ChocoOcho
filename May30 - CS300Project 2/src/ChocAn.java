import java.io.*;
import java.util.Scanner;

public class ChocAn {

    public static void main(String[] args) {

        //Main.java is designed to allow providers to interact with the ChocAn data processing software system.
        Scanner input = new Scanner(System.in);
        int main_menu = 0;
        int manager_menu = 0;
        int provider_menu = 0;
        int response = 0; //Catch user's response in main mode
        int intMode_response = 0; //Catch user's response in manager's mode
        int catcher = 0; //Catch return value

        Menu object = new Menu(); //Object for the Main Menu (Provider/Manager Mode)

        MemberList list_of_members = new MemberList(); //Object for MemberList
        ProviderList list_of_providers = new ProviderList(); //Object for ProviderList
        SHistoryTree tree_of_services = new SHistoryTree(); //Object of tree of services
        ServiceList list_of_all_services = new ServiceList(); //Object of all the services in the Provider's Directory

        object.load_data(list_of_members, list_of_providers, tree_of_services, list_of_all_services); //Load data from files into tree data structures.

        while(main_menu != 1)
        {
            response = object.mainMode(); //Essentially ask if Manager (IntMode) or Provider

            //Manager Mode
            if (response == 1)
            {
                while (manager_menu != 1)
                {
                    intMode_response = object.intMode(); //Ask Manager what to do

                    if (intMode_response == 1)
                        catcher = object.intMode_Member(list_of_members); //Mess with members

                    else if (intMode_response == 2)
                        catcher = object.intMode_Provider(list_of_providers); //Mess with providers

                    else if (intMode_response == 3)
                        catcher = object.intMode_Report(); //Do reports

                    else if (intMode_response == 4)
                        catcher = object.intMode_Service(list_of_all_services); //Mess with services in list of all services

                    else
                        manager_menu = 1;

                    if (catcher == -1)
                        System.out.println("Error.");
                }
            }

            //Provider mode.
            else if (response == 2)
            {
                while (provider_menu != 1)
                {
                    intMode_response = object.providerMenu(); //Ask Provider what to do

                    if (intMode_response == 1) //Display list of all services
                        object.providerMenu_directory(list_of_all_services);

                    else if (intMode_response == 2) {
                        catcher = object.validate_member(list_of_members);

                        if (catcher == -1)
                            System.out.println("Invalid Member ID.");
                        else if (catcher == 0)
                            System.out.println("Member is suspended. Service withhold is advised. Send that sucker home.");
                        else
                            System.out.println("ID validated.");
                    }

                    else if (intMode_response == 3)
                    {
                        catcher = object.create_service(); //Provider wants to add a service he/she just provided

                        if (catcher == -1)
                            System.out.println("Could not add service.");
                        else
                            System.out.println("Service added successfully.");
                    }

                    else
                        provider_menu = 1;
                }
            }

            else
                main_menu = 1;
        }

        //Marko's and Angelic's

        /*ServiceList test = new ServiceList();
        test.read_from_file();
        test.display_all();
        test.add_service();
        test.add_service();
        test.display_all();*/
    }
}

/*
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
*/


