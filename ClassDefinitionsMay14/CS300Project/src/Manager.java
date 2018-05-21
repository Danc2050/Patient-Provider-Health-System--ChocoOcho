//import java.io.*;
//import java.util.Scanner;

public class Manager extends Utility {
    protected int id;
    protected summary_report report;
    protected MemberList mObj;
    protected ProviderList pObj;

    public Manager() {
        this.id = 0;
    }

    //public int addProvider(){}//Combined with below function.
    public int add()//Add a provider or a member...
    {
        System.out.println("\nAdd to member(0) or provider(1)?");
        int res = input.nextInt();
        input.nextLine();
        //TODO Thong's memberList and providerList functions can request the variables or the variables can be garnered here.
        //TODO The benefit of variables not in here are: Less code, less arguments in add() functions.
        /*System.out.println("\nEnter name.");
        String name = input.nextLine();
        input.nextLine();
        System.out.println("\nI.D. number being generated.");
        //int memNum = //TODO Random number...based off text file?
        System.out.println("\nEnter Street Address (25 Characters)");
        String street = input.nextLine();
        input.nextLine()
        System.out.println("\nEnter city");
        String city = input.nextLine();
        input.nextLine();
        System.out.println("\nEnter State)");
        String state = input.nextLine();
        input.nextLine();
        System.out.println("\nEnter zip)");
        int zip = input.nextInt();
        input.nextLine();*/
        //TODO Send in variables to write out to a file OR let MemberList and ProviderList do these.
        if(res == 0)
          mObj.add();
        if(res == 1)
          pObj.add();
    }

    public int delete() {
        System.out.println("\nDelete member(0) or provider(1)?");
        int res = input.nextInt();
        input.nextLine();
        if(res == 0)
          mObj.remove();
        if(res == 1)
          pObj.remove();
    }

    public int updateInfo() {
        System.out.println("\nUpdate member(0) or provider(1)?");
        int res = input.nextInt();
        input.nextLine();
        if(res == 0)
          mObj.update();
        if(res == 1)
          pObj.update();
    }

    public int generateReport()
    {
        System.out.println("\nGenerate member(0) or provider(1)");
        int res = input.nextInt();
        input.nextLine();
        if(res == 0)
          mObj.read_from_file();
        if(res == 1)
          pObj.read_fromFile();
        //NOTE: Summary report has moved to provider class (i.e., manager no longer has a summary report object).
    }
     public int addAddress(){}//TODO What is this function?
}
