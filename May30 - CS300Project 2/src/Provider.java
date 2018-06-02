public class Provider extends Node {

    protected Address p_address;//TODO Implement
    protected String Name;
    protected String Service;
    protected int id;
    //protected ServiceList s_list;//History of services that a provider offers.//Replaced with service..[V]
    protected float week_fee;
    protected int num_consultations;

    public Provider() {
        this.Name = null;
        this.id = 0;
        this.week_fee = 0;
        this.num_consultations = 0;
        this.p_address = null;
        this.Service = null;
    }
    public Provider(String t_name, int t_id, Address ad, String t_service, float t_week_fee, int t_num_consultations)
    {
        this.Name = t_name;
        this.id = t_id;
        this.week_fee = t_week_fee;
        this.num_consultations = t_num_consultations;
        if(this.p_address == null)
            this.p_address = new Address();
        this.p_address.to_copy(ad);
        this.Service = t_service;
    }
    
    public void toCopy(Provider ad){
        this.Name = ad.Name;
        this.id = ad.id;
        this.week_fee = ad.week_fee;
        this.num_consultations = ad.num_consultations;
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
        System.out.println("Provider's Weekly Fee: " + this.week_fee);
        System.out.println("Provider's Number of Consultations: " + this.num_consultations);
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

    /*public void generateServiceReport(){}//TODO Implement
    public boolean generateServiceList(){};//Generates text file.
    public String verifyService(){}
    public String validateMember(){}
    public void get_history(){};//Return service history?
    public void get_address(){};*/
    public float get_week_fee(){return this.week_fee;}
    public int get_num_consultations(){return this.num_consultations;}
}
// }
