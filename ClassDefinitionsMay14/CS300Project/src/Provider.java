public class Provider extends Node {

    protected Address p_address;//TODO Implement
    protected String Name;
    protected int id;
    //protected service_list offers//TODO
    //service_history p_history//TODO
    protected int week_fee;
    protected int num_consultations;

    public Provider() {
        this.Name = null;
        this.id = 0;
        this.week_fee = 0;
        this.num_consultations = 0;
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
    public String get_status(){return this.Name;}
    public int get_member_id(){return 0;}
    protected String get_provider_name()
    {
        return this.Name;
    }
    public void DisplayAll()
    {
        return;
    }

    /*public void generateServiceReport(){}//TODO Implement
    public boolean generateServiceList(){};//Generates text file.
    public String verifyService(){}
    public String validateMember(){}
    public void get_history(){};//Return service history?
    public void get_address(){};
    public float get_week_fee(){};
    public int get_num_consultations(){};*/
}
// }
