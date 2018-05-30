//import java.io.*;
//import java.util.Scanner;

public class Manager extends Utility {
    protected int id;
    //protected summary_report report;
    protected MemberList mObj;
    protected ProviderList pObj;

    public Manager() {
        this.id = 0;
    }

    //public int addProvider(){}//Combined with below function.
    public int add(MemberList m_root, ProviderList p_root)//Add a provider or a member...
    {
        System.out.println("\n1 - Add to member(0) \n 2 -provider(1) \n 3 - Exit");
        int res = input.nextInt();
        input.nextLine();
        if (res == 0)
            m_root.add_member_wrapper();
        if (res == 1)
            p_root.add_provider();
        else
            return 0;
        return 0;
    }

    public int delete(MemberList m_root, ProviderList p_root) {
        System.out.println("\nDelete member(0) or provider(1)?");
        System.out.println("\n1 - Add to member(0) \n 2 -provider(1) \n 3 - Exit");
        int res = input.nextInt();
        input.nextLine();
        if(res == 0)
          m_root.delete();
        if(res == 1)
          p_root.delete();
        return 0;
    }

    public int updateInfo() {//todo implement.
        System.out.println("\nUpdate member(0) or provider(1)?");
        int res = input.nextInt();
        input.nextLine();
        /*if(res == 0)
          mObj.update();
        if(res == 1)
          pObj.update();*/
        return 0;
    }

    public int generateReport()//todo implement.
    {
        System.out.println("\nGenerate member(0) or provider(1)");
        int res = input.nextInt();
        input.nextLine();
        /*if(res == 0)
          mObj.read_from_file();
        if(res == 1)
          pObj.read_fromFile();
        //NOTE: Summary report has moved to provider class (i.e., manager no longer has a summary report object).*/
        return 0;
    }
}
