public class Member extends Node{
    /* Data fields that a member has */
    protected String Name;
    protected int id;
    protected Address m_address;
    protected String m_status;

    /* Default constructor to initialize data fields to their null equivalent */
    public Member() {
        this.Name = null;
        this.id = 0;
        this.m_status = null;
        this.m_address = null;
    }

    /* Copy constructor to initialize data fields to values passed in through arguments */
    public Member(int id, String status, String Name, Address ad){
        this.id = id;
        this.m_status = status;
        this.Name = Name;
        if(this.m_address == null)
            this.m_address = new Address();
        this.m_address.to_copy(ad);
    }

    /* Takes in a member object and copies all the data members pertaining to a member */
    public void toCopy(Member ad){
        this.id = ad.id;
        this.m_address = ad.m_address;
        this.m_status = ad.m_status;
        this.Name = ad.Name;
    }

    /* Setters  and Getters for service class */
    public void set_service_name(String new_name) { return; }
    public void set_service_code(int new_code) { return; }
    public void set_service_fee(float new_fee) { return; }
    public int get_service_code() { return 0; }
    public float get_service_fee() { return 0; }
    public String get_service_name() { return null; }

    /* Setters and Getters for provider class */
    public void set_p_name(String newName) {return;}
    public void set_provider_id(int newId) {return;}
    public int get_provider_id() {return 0;}
    public void set_provider_services(String newServices) {return;}
    public String get_provider_services() {return null;}
    public void set_provider_address(Address new_address) {return;}
    public int get_pnum(){return 0;}
    public String get_pname(){return null;}
    public Address get_paddress(){return null;}

    /* Setters and Getters for member class */
    public void set_m_name(String newName){this.Name = newName; return; }
    public int get_member_id() { return id; }
    public void set_member_status(String status_to_set) {this.m_status = status_to_set;}
    public void set_member_id(int id_to_change) {this.id = id_to_change;}
    public void set_member_name(String name_to_set) {this.Name = name_to_set;}
    public void set_member_address(Address address_to_set) {this.m_address = address_to_set;}
    public String get_member_name() {return this.Name;}
    public String get_mname() {return Name;}
    public String get_status() {return m_status;}
    public Address get_maddress(){return m_address;}

    /* Dynamically bound display function for member class */
    public void DisplayAll(){
        System.out.print(this.id + " " + this.m_status + " " + this.Name + " ");
        m_address.display_address();
    }

    /* Functions to get dates, comments and address of current object */
    public String get_sdate(){return null;}
    public String get_ldate(){return null;}
    public String get_comments(){return null;}
    public Address get_address(){ return this.m_address; }
}
