public class Member extends Node{
    protected String Name;
    protected int id;
    //protected Address m_address//TODO uncomment
    protected String status;
    //protected service_history m_history //TODO UNCOMMMENT
    public Member() {
        this.Name = null;
        this.id = 0;
    }
    public Member(String Name, int id){//TODO add Address and service history
        this.Name = Name;
        this.id = id;
    }

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


}
