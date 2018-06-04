public class Address extends Utility{
    /* Data members composing an address */
    protected String street;
    protected String state;
    protected String city;
    protected int zip;

    /* Default constructor - initializes data members to null equivalent */
    public Address() {
        this.street = null;
        this.state = null;
        this.city = null;
        this.zip = 0;
    }

    /* Copy constructor to copy values passed in, into address object */
    public Address(String street, String city, String state, int zip) {
        this.street = street;
        this.state = state;
        this.city = city;
        this.zip = zip;
    }

    /* Copy function taking an address and setting the data members */
    public void to_copy(Address ad){
        this.street = ad.street;
        this.state = ad.state;
        this.city = ad.city;
        this.zip = ad.zip;
        return;
    }

    /* Setter function to set the address for the object being called on */
    public Address set_address(){
        System.out.println("\nEnter Street Address (25 Characters)");
        String street = input.nextLine();
        System.out.println("\nEnter city");
        String city = input.nextLine();
        System.out.println("\nEnter State");
        String state = input.nextLine();
        System.out.println("\nEnter zip");
        int zip = input.nextInt();
        input.nextLine();
        Address ad = new Address(street, city, state, zip);
        return ad;
    }

    /* Returns the address of the current object */
    public Address get_address(){
        return this;
    }

    /* Displays the contents of an address for the object being called on */
    public void display_address() {
        System.out.print(this.street + " " + this.state + " " + this.city + " " + this.zip + "\n");
    }
}
