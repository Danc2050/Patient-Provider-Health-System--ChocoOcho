public class Address {
    protected String street;
    protected String state;
    protected String city;
    protected int zip;


    public Address() {
        this.street = null;
        this.state = null;
        this.city = null;
        this.zip = 0;
    }

    public Address(String street, String city, String state, int zip) {
        this.street = street;
        this.state = state;
        this.city = city;
        this.zip = zip;
    }

    public void to_copy(Address ad){
        this.street = ad.street;
        this.state = ad.state;
        this.city = ad.city;
        this.zip = ad.zip;
        return;
    }

    public Address get_address(){
        return this;
    }
    //public updateAddress(

    public void display_address() {
        System.out.print(this.street + " " + this.state + " " + this.city + " " + this.zip + "\n");
    }
}