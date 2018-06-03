public class ServiceHistory extends Node{

    protected Provider provider;
    protected Member member;
    protected Service service;
    protected String service_date;
    protected String log_date;
    protected String comments;

    public ServiceHistory(Provider p, Member m, Service s, String sdate, String ldate, String tcomments){
        if(this.provider == null)
            this.provider = new Provider();
        this.provider.toCopy(p);
        if(this.member == null)
            this.member = new Member();
        this.member.toCopy(m);
        if(this.service == null)
            this.service = new Service();
        this.service.toCopy(s);
        this.service_date = sdate;
        this.log_date = ldate;
        this.comments = tcomments;
    }
    public String get_service_name() {
        return this.service.s_name;
    }

    public int get_service_code() {
        return this.service.s_code;
    }

    public float get_service_fee() {
        return this.service.s_fee;
    }

    public void DisplayAll() { return;}

    public int get_member_id() {
        return this.member.id;
    }

    public String get_status() {
        return null;
    }
    public String get_pname(){
        return this.provider.Name;
    }
    public int get_pnum(){
        return this.provider.id;
    }
    public String get_mname(){
        return this.member.Name;
    }
    public String get_sdate(){
        return this.service_date;
    }
    public String get_ldate(){
        return this.log_date;
    }
    public String get_comments(){
        return this.comments;
    }
    public Address get_paddress(){return this.provider.get_address();}
    public Address get_maddress(){return this.member.get_address();}
    public void set_service_name(String new_name){return;}
    public void set_service_code(int new_code){return;}
    public void set_service_fee(float new_fee){return;}
    public void set_m_name(String newName){return;}

    public void set_p_name(String newName){return;}
    public void set_provider_id(int newId) {return;}
    public int get_provider_id() {return 0;}
    public void set_provider_services(String newServices) {return;}
    public String get_provider_services() {return null;}
    public void set_provider_address(Address new_address) {return;}
    
    public Address get_address(){ return null;}
    public void set_member_address(Address address_to_set) {return;}
    public String get_member_name() { return null; }
    public void set_member_status(String status_to_set) {return;}
    public void set_member_name(String name_to_set) {return;}
    public void set_member_id(int id_to_set) {return;}
}
