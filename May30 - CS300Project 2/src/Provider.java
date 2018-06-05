public class Provider extends Node {

    /* Data fields that each Provider node has */
    protected Address p_address;
    protected String Name;
    protected String Service;
    protected int id;

    /* Copy Constructor to set data fields to null equivalent */
    public Provider() {
        this.Name = null;
        this.id = 0;
        this.p_address = null;
        this.Service = null;
    }

    /* Copy Constructor to set data fields equal to the values being passed in */
    public Provider(String t_name, int t_id, Address ad, String t_service)
    {
        this.Name = t_name;
        this.id = t_id;
        if(this.p_address == null)
            this.p_address = new Address();
        this.p_address.to_copy(ad);
        this.Service = t_service;
    }

    /* Copy function that takes a provider object and copies
       the data members into the objects data fields.
     */
    public void toCopy(Provider ad){
        this.Name = ad.Name;
        this.id = ad.id;
        this.Service = ad.Service;
        this.p_address = ad.p_address;
    }

    /* Setters and Getters for ServiceList Class */
    public void set_service_name(String new_name) { return; }
    public void set_service_fee(float new_fee) { return; }
    public void set_service_code(int new_code) { return; }
    public String get_service_name() { return null; }
    public int get_service_code() { return 0; }
    public float get_service_fee() { return 0; }

    /* Setters and Getters for ProviderList Class */
     public void set_provider_services(String newServices) {this.Service = newServices;}
    public String get_provider_services() {return this.Service;}
    public void set_provider_id(int newId) {this.id = newId;}
    public int get_provider_id() {return this.id;}
    public void set_provider_address(Address new_address) {this.p_address = new_address;}
    public String get_pname(){ return this.Name; }
    public int get_pnum(){ return this.id; }
    public void set_p_name(String newName) {this.Name = newName;}
    public Address get_paddress(){return this.p_address;}

    /* Setters and Getters for MemberList Class */
    public void set_m_name(String newName){return;}
    public int get_member_id(){return 0;}
    public String get_mname(){return null;}
    public Address get_maddress(){return null;}
    public void set_member_address(Address address_to_set) {return;}
    public String get_member_name() { return null; }
    public void set_member_status(String status_to_set) {return;}
    public void set_member_name(String name_to_set) {return;}
    public void set_member_id(int id_to_set) {return;}

    /* Setters and Getters for ServiceHistory Class */
    public String get_status(){return this.Name;}
    public String get_sdate(){return null;}
    public String get_ldate(){return null;}
    public String get_comments(){return null;}
    public Address get_address(){ return this.p_address; }

    /* Dynamically Bound Display function */
    public void DisplayAll()
    {
        System.out.println("=====================================");
        System.out.println("Provider Name: " + this.Name);
        System.out.println("Provider's Services: " + this.Service);
        System.out.println("Provider's ID: " + this.id);
        System.out.print("Provider's Address: ");
        this.p_address.display_address();
        System.out.println("=====================================");
        return;
    }
}
