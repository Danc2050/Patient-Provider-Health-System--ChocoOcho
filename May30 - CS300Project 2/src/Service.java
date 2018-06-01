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
        System.out.println(this.s_name + " " + this.s_code + " " + this.s_fee);
    }

    public String get_status(){return null;};

    public int get_member_id(){return 0;};

    //More for Service history tree class
    public String get_pname(){return null;}
    public int get_pnum(){return 0;}
    public String get_mname(){return null;}
    public String get_sdate(){return null;}
    public String get_ldate(){return null;}
    public String get_comments(){return null;}
    public Address get_paddress(){return null;}
    public Address get_maddress(){return null;}
    public float get_week_fee(){return 0;}
    public int get_num_consultations(){return 0;}
}
