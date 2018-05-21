import junit.framework.TestCase;

public class ServiceListTest extends TestCase {
    ServiceList SL = new ServiceList();

    public ServiceListTest(String name){
        super(name);
    }

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() throws Exception {
    }

    public void testRead_from_file() {
    }

    public void testWrite_to_file() {
    }

    public void testAdd_service() {
        testAdd_service1();
    }

    public void testAdd_service1() {//IDK if this is right. Seems off...
        System.out.println("Inserting a new service");
        ServiceList instance = new ServiceList();
        Service root = new Service("Pharmacist", 12345, 600);
        if(root == null)
            root = (Service) instance.add_service(root, 12345, "Pharmacist", 600);
        else
            fail("The list is not empty");
        if(root != null)
            root = (Service) instance.add_service(root, 12345, "Pharmacist", 600);
        else
            fail("The list is empty");
        root = (Service) instance.add_service(root, 12345, "Pharmacist", 600);
        System.out.println("Inserting an item that already exist");
    }

    public void testDisplay_all() {
    }

    public void testDisplay_all1() {
    }
}