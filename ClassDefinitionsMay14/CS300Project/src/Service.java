public class Service {
    protected String s_name;
    protected int s_code;
    protected float s_fee;

    public int Service(String service, int code, float fee)
    {
        this.s_name = service;
        this.s_code = code;
        this.s_fee = fee;
    }
}
