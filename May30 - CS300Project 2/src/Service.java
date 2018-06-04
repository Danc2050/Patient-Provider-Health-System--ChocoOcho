public class Service extends Node {
    protected String s_name;
    protected int s_code;
    protected float s_fee;

    public Service()
    {
        this.s_name = null;
        this.s_code = 0;
        this.s_fee = 0;
    }

    public Service(String service, int code, float fee)
    {
        this.s_name = service;
        this.s_code = code;
        this.s_fee = fee;
    }

    public void toCopy(Service ad){
        this.s_name = ad.s_name;
        this.s_code = ad.s_code;
        this.s_fee = ad.s_fee;
    }
    
    public void set_service_name(String new_name) { this.s_name = new_name; }
    public void set_service_code(int new_code) { this.s_code = new_code; }
    public void set_service_fee(float new_fee) { this.s_fee = new_fee; }
    public void set_m_name(String newName){return;}
    public String get_service_name()
    {
        return this.s_name;
    }

    public int get_service_code()
    {
        return this.s_code;
    }

    public float get_service_fee()
    {
        return this.s_fee;
    }

    public void DisplayAll()
    {
        System.out.println("==================================");
        System.out.println("Service Name: " + this.s_name);
        System.out.println("Service Code: " + this.s_code);
        System.out.println("Service Fee: " + this.s_fee);
        System.out.println("==================================");
    }

    public String get_status(){return null;};

    public int get_member_id(){return 0;};
    public void set_p_name(String newName) { return; }

    //More for Service history tree class
    public String get_pname(){return null;}
    public int get_pnum(){return 0;}
    public String get_mname(){return null;}
    public String get_sdate(){return null;}
    public String get_ldate(){return null;}
    public String get_comments(){return null;}
    public Address get_paddress(){return null;}
    public Address get_maddress(){return null;}

    public void set_provider_id(int newId) {return;}
    public int get_provider_id() {return 0;}
    public void set_provider_services(String newServices) {return;}
    public String get_provider_services() {return null;}
    public void set_provider_address(Address new_address) {return;}
    
    public void set_member_address(Address address_to_set) {return;}
    public String get_member_name() { return null; }
    public void set_member_status(String status_to_set) {return;}
    public void set_member_name(String name_to_set) {return;}
    public void set_member_id(int id_to_set) {return;}
    public Address get_address(){ return null; }
}
