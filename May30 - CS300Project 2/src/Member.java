public class Member extends Node{
    protected String Name;
    protected int id;
    protected Address m_address;
    protected String m_status;


    public Member() {
        this.Name = null;
        this.id = 0;
        this.m_status = null;
        this.m_address = null;
    }
    public Member(int id, String status, String Name, Address ad){//TODO add Address and service history
        this.id = id;
        this.m_status = status;
        this.Name = Name;
        if(this.m_address == null)
            this.m_address = new Address();
        this.m_address.to_copy(ad);
    }

    public void toCopy(Member ad){
        this.id = ad.id;
        this.m_address = ad.m_address;
        this.m_status = ad.m_status;
        this.Name = ad.Name;
    }
    public void set_service_name(String new_name) { return; }
    public void set_service_code(int new_code) { return; }
    public void set_service_fee(float new_fee) { return; }
    public void set_m_name(String newName){this.Name = newName; return;
    }

    public String get_service_name()
    {
        return null;
    }

    public int get_service_code()
    {
        return 0;
    }

    public float get_service_fee()
    {
        return 0;
    }

    //public void DisplayAll() { return; }

    public int get_member_id()
    {
        return id;
    }

    //public String get_status() {return status;}

    public String get_status() {return m_status;}
    public String get_pname(){return null;}
    public int get_pnum(){return 0;}
    public String get_mname() {return Name;}

    public void DisplayAll(){
        System.out.print(this.id + " " + this.m_status + " " + this.Name + " ");
        m_address.display_address();
    }
    public String get_sdate(){return null;}
    public String get_ldate(){return null;}
    public String get_comments(){return null;}
    public Address get_address(){
        return this.m_address;
    }
    public Address get_paddress(){return null;}
    public Address get_maddress(){return null;}

}
