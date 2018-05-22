public class Manager extends Utility {
    protected int id;
    protected MemberList mObj;
    protected ProviderList pObj;

    public Manager() {
        this.id = 0;
    }
    
    public int add()//Add a provider or a member...
    {
        System.out.println("\nAdd to member(0) or provider(1)?");
        int res = input.nextInt();
        input.nextLine();
        if(res == 0)
          mObj.add();
        if(res == 1)
          pObj.add();
        return 0;
    }

    public int delete() {
        System.out.println("\nDelete member(0) or provider(1)?");
        int res = input.nextInt();
        input.nextLine();
        if(res == 0)
          mObj.remove();
        if(res == 1)
          pObj.remove();
        return 0;
    }

    public int updateInfo() {
        System.out.println("\nUpdate member(0) or provider(1)?");
        int res = input.nextInt();
        input.nextLine();
        if(res == 0)
          mObj.update();
        if(res == 1)
          pObj.update();
        return 0;
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
        return 0;
    }
}
