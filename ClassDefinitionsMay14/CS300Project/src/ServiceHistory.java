public class ServiceHistory extends Node{
    //protected Node s_root;
    protected String comments;
    protected String s_name;
    protected int s_code;
    protected float s_fee;
    protected String service_date;
    protected String p_name;
    protected String m_name;
    protected int p_num;
    protected int m_num;

    public ServiceHistory(String comments, String s_name, int s_code, float s_fee, String service_date, String p_name, String m_name, int p_num, int m_num) {
        this.comments = comments;
        this.s_name = s_name;
        this.s_code = s_code;
        this.s_fee = s_fee;
        this.service_date = service_date;
        this.p_name = p_name;
        this.m_name = m_name;
        this.p_num = p_num;
        this.m_num = m_num;
    }

    public String get_service_name() {
        return this.s_name;
    }

    public int get_service_code() {
        return this.s_code;
    }

    public float get_service_fee() {
        return this.s_fee;
    }

    public void DisplayAll() { return;}

    public int get_member_id() {
        return this.m_num;
    }
