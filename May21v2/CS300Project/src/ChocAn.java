import java.io.*;
import java.util.Scanner;

public class ChocAn {

    public static void main(String[] args) {
        //Main.java is designed to allow providers to interact with the ChocAn data processing software system.
        //System.out.println(/**/);
        /*int response = 0;

        Menu object = new Menu();
        response = object.mainMode();

        if (response == 1)
            object.intMode();
        else
            object.providerMenu();*/

        //Marko's and Angelic's
        Scanner input = new Scanner(System.in);

        ServiceList test = new ServiceList();
        test.read_from_file();
        test.display_all();
        /*test.add_service();
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


