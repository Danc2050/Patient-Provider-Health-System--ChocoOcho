public class ServiceHistory extends Node{
    //protected Node s_root;
    /*protected String comments;
    protected String s_name;
    protected int s_code;
    protected float s_fee;
    protected String service_date;
    protected String log_date;
    protected String p_name;
    protected String m_name;
    protected int p_num;
    protected int m_num;
    protected Address p_ad;
    protected Address m_ad;*/
    protected Provider provider;
    protected Member member;
    protected Service service;
    protected String service_date;
    protected String log_date;
    protected String comments;

    /*public ServiceHistory(String comments, String s_name, int s_code, float s_fee, String service_date,String log_date, String p_name, String m_name, int p_num, int m_num,Address pad,Address mad) {
        this.comments = comments;
        this.s_name = s_name;
        this.s_code = s_code;
        this.s_fee = s_fee;
        this.service_date = service_date;
        this.log_date = log_date;
        this.p_name = p_name;
        this.m_name = m_name;
        this.p_num = p_num;
        this.m_num = m_num;
        /*if(this.p_ad == null)
           this.p_ad = new Address();
        this.p_ad.to_copy(pad);
        if(this.m_ad == null)
            this.m_ad = new Address();
        this.m_ad.to_copy(mad);*/
    //}

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
    public float get_week_fee(){return 0;}
    public int get_num_consultations(){return 0;}
    public void set_p_name(String newName){return;}
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
}
