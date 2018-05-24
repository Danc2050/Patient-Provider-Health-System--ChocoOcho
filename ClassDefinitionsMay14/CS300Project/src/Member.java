public class Member extends Node{
    protected String Name;
    protected int id;
    protected String status;
    protected Address m_address;
    protected ServiceHistory m_history;
    protected String m_status;


    public Member() {
        this.Name = null;
        this.id = 0;
        this.m_status = null;
        this.m_address = null;
        this.m_history = null;
    }
    public Member(int id, String status, String Name, Address address){//TODO add Address and service history
        this.id = id;
        this.m_status = status;
        this.Name = Name;
        this.m_address = address;
        this.m_history = new ServiceHistory();

    }

    public void set_service_name(String new_name) { return; }
    public void set_service_code(int new_code) { return; }
    public void set_service_fee(float new_fee) { return; }

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

    public void DisplayAll()
    {
        return;
    }

    public int get_member_id()
    {
        return id;
    }

    public String get_status() {return status;}
    public int get_member_id() {return id; }

    public String get_status() {return m_status;}
    public String get_provider_name(){return null);
    public String get_member_name() {return Name;}

    public void DisplayAll(){
        System.out.print(this.id + " " + this.m_status + " " + this.Name + " ");
        m_address.display_address();
    }
}
