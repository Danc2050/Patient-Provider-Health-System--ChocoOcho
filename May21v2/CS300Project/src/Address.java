public class Address {
    protected String street;
    protected String state;
    protected String city;
    protected int zip;

    public Address(String street, String state, String city, int zip)
    {
        this.street = street;
        this.state = state;
        this.city = city;
        this.zip = zip;
    }
}
