public class Provider extends Node {

    protected Address p_address;//TODO Implement
    protected String Name;
    protected String Service;
    protected int id;

    public Provider() {
        this.Name = null;
        this.id = 0;
        this.p_address = null;
        this.Service = null;
    }
    public Provider(String t_name, int t_id, Address ad, String t_service)
    {
        this.Name = t_name;
        this.id = t_id;
        if(this.p_address == null)
            this.p_address = new Address();
        this.p_address.to_copy(ad);
        this.Service = t_service;
    }
    
    public void toCopy(Provider ad){
        this.Name = ad.Name;
        this.id = ad.id;
        this.Service = ad.Service;
        this.p_address = ad.p_address;
    }



    public void set_service_name(String new_name) { return; }
    public void set_m_name(String newName){return;}
    public void set_p_name(String newName) {this.Name = newName;}
    public void set_provider_services(String newServices) {this.Service = newServices;}
    public String get_provider_services() {return this.Service;}
    public void set_provider_id(int newId) {this.id = newId;}
    public int get_provider_id() {return this.id;}
    public void set_provider_address(Address new_address) {this.p_address = new_address;}
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
    public String get_status(){return this.Name;}
    public int get_member_id(){return 0;}
    public String get_pname(){
        return this.Name;
    }
    public int get_pnum(){
        return this.id;
    }
    public String get_mname(){return null;}
    public String get_sdate(){return null;}
    public String get_ldate(){return null;}
    public String get_comments(){return null;}
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
    public Address get_address(){
        return this.p_address;
    }
    public Address get_paddress(){return this.p_address;}
    public Address get_maddress(){return null;}

    public void set_member_address(Address address_to_set) {return;}
    public String get_member_name() { return null; }
    public void set_member_status(String status_to_set) {return;}
    public void set_member_name(String name_to_set) {return;}
    public void set_member_id(int id_to_set) {return;}
}
// }
