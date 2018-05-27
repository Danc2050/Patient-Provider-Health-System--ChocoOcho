import java.io.*;
import java.util.Scanner;

public class ChocAn {

    public static void main(String[] args) {
        //Main.java is designed to allow providers to interact with the ChocAn data processing software system.
        //System.out.println(/**/);
        int response = 0; //Catch user's response.
        int intMode_response = 0;
        int catcher = 0;

        MemberList list_of_members = new MemberList(); //Object for MemberList
        ProviderList list_of_providers = new ProviderList(); //Object for ProviderList
        Menu object = new Menu(); //Object for the Main Menu (Provider/Manager Mode)

        response = object.mainMode(); //Essentially ask if Manager (IntMode) or Provider

        if (response == 1)
        {
            intMode_response = object.intMode(); //Ask Manager what to do

            if (intMode_response == 1)
                catcher = object.intMode_Member(list_of_members); //Mess with members

            else if (intMode_response == 2)
                catcher = object.intMode_Provider(list_of_providers); //Mess with providers

            else
                catcher = object.intMode_Report(); //Do reports

            if (catcher == -1)
                System.out.println("Error.");
        }

        else
        {
            intMode_response = object.providerMenu(); //Ask Provider what to do

            if (intMode_response == 1)
                catcher = object.
        }

        //Marko's and Angelic's
        Scanner input = new Scanner(System.in);

        ServiceList test = new ServiceList();
        test.read_from_file();
        test.display_all();
        test.add_service();
        test.display_all();
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


