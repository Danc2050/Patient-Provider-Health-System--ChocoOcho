//Main
public class ChocAn extends Utility{

    public static void main(String[] args) {

        //Main is designed to allow ChocAn managers and providers to interact with the ChocAn data processing software system.
        int main_menu = 0;//Controls the exit from our main terminal.
        int manager_menu = 0;//Controls the entrance or exit from our manager terminal.
        int response; //Catch user's response in main mode
        int intMode_response; //Catch user's response in manager's mode
        int provider_menu; //Catch user's response in provider's mode
        int catcher = 0; //Catch return value in provider's menu.

        Menu object = new Menu(); //Object for the Main Menu (Provider/Manager Mode)
        MemberList list_of_members = new MemberList(); //Object for MemberList
        ProviderList list_of_providers = new ProviderList(); //Object for ProviderList
        SHistoryTree tree_of_services = new SHistoryTree(); //Object of tree of services (services that have been provided)
        ServiceList list_of_all_services = new ServiceList(); //Object of all the services in the Provider's Directory

        object.load_data(list_of_members, list_of_providers, tree_of_services, list_of_all_services); //Load data from files into tree data structures.

        while(main_menu != 1)
        {
            response = object.mainMode(); //Essentially ask if Manager (IntMode) or Provider
            //Manager Mode
            if (response == 1)
            {
                System.out.println("\nEnter manager I.D. # to be verified: ");
                int manager_ID = input.nextInt();
                input.nextLine();
                if(list_of_providers.manager_Verification(manager_ID))
                {
                    //Verify a manager does exist.
                    System.out.println("\nManager I.D. verification successful.");
                    manager_menu = 0;
                }

                else {
                    System.out.println("\nManager I.D. verification unsuccessful.");
                    manager_menu = 1;
                }

                while (manager_menu != 1)
                {
                    intMode_response = object.intMode(); //Ask Manager what to do

                    if (intMode_response == 1) {
                        catcher = object.intMode_Member(list_of_members); //Mess with members
                    }
                    else if (intMode_response == 2)
                        catcher = object.intMode_Provider(list_of_providers, list_of_all_services); //Mess with providers

                    else if (intMode_response == 3)
                        catcher = object.intMode_Report(tree_of_services); //Do reports

                    else if (intMode_response == 4)
                        catcher = object.intMode_Service(list_of_all_services); //Mess with services in list of all services

                    else
                        manager_menu = 1; //Break out of loop.

                    if (catcher == -1)
                        System.out.println("Error.");
                }
            }

            //Provider mode.
            else if (response == 2)
            {
                if(list_of_providers.provider_Verification())
                {
                    //Verify a provider does exist.
                    System.out.println("\nProvider I.D. verification successful.");
                    provider_menu = 0;
                }

                else {
                    System.out.println("\nProvider I.D. verification unsuccessful.");
                    provider_menu = 1;
                }

                while (provider_menu != 1)
                {
                    intMode_response = object.providerMenu(); //Ask Provider what to do

                    if (intMode_response == 1) //Display list of all services
                        object.providerMenu_directory(list_of_all_services);

                    //Provider wants an email of service list
                    else if(intMode_response == 2)
                    {
                        list_of_all_services.email_service_list();
                    }

                    //Provider wants to add a service he/she just provided
                    else if (intMode_response == 3)
                    {
                        // First validate Member's ID. Then add service to service history.
                        if (object.validate_member(list_of_members) == 1)
                            object.create_service(tree_of_services, list_of_all_services);
                    }

                    else
                        provider_menu = 1;//Break out of loop...
                }
                provider_menu = 0;//Reset provider_menu back to its default value.
            }

            else
                main_menu = 1;
        }
        
        object.write_data(list_of_members, list_of_providers, tree_of_services, list_of_all_services);//Write updated data from trees to file

    }
}
