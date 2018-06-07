import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;
import java.io.IOException;

/*Read from files did not recognize a file in the specific test path. Therefore, functions that would have used the
read from file path (e.g., Update~) are tested by adding a single provider to the first node in the root. Thus, not all
test cases are tested (e.g. When traversing down the left subtree).*/

class ProviderListTest {
    ProviderList obj = new ProviderList();

    @Test
    void read_from_file() {
        Assertions.assertEquals(obj.read_from_file(), 1);
    }

    @Test
    void write_to_file() {
        Assertions.assertEquals(obj.write_to_file(), 1);
    }

    @Test
    void write_to_file1() {
        try {
            FileWriter file = new FileWriter("ProviderList.txt");
            Assertions.assertEquals(obj.write_to_file(obj.p_root, file), 1);
        } catch (IOException e) {
            System.out.println("\nIO exception.");
        }
    }

    @Test
    void add_provider() {
        String name = "Mike";
        int id = 123;
        String street = "street";
        String city = "city";
        String state = "state";
        int zip = 97045;
        String service = "service";
        Address ad = new Address(street, city, state, zip);
        Assertions.assertNotNull(obj.add_provider(obj.p_root, name, id, ad, service));
    }

    @Test
    void add_provider1() {
        //add_provider(Node p_root, String t_name, int t_id, Address ad, String t_service, float t_week_fee, int t_num_consultations)
        String name = "Roger";
        int id = 123;
        String street = "street";
        String city = "city";
        String state = "state";
        int zip = 97045;
        String service = "service";
        Address ad = new Address(street, city, state, zip);
        Assertions.assertNotNull(obj.add_provider(obj.p_root, name, id, ad, service));
    }

    @Test
    void delete() {
        Assertions.assertNull(obj.delete(obj.p_root, "david"));
    }

    @Test
    void delete1() {
        Assertions.assertNull(obj.delete(obj.p_root, "david"));
    }

    @Test
    void findIOS() {
        //Create an IOS to find.
        String nameToFind = "Barbara Johnson";
        String street = "1234 Maple Lane";
        String city = "Maple City";
        String state = "Maple";
        int zip = 97045;
        Address ad = new Address(street, city, state, zip);
        obj.p_root = obj.add_provider(obj.p_root, nameToFind, 12345, ad, "Dietian");
        Assertions.assertNotNull(obj.findIOS(obj.p_root));
    }

    @Test
    void manager_Verification() {
        int manager_ID = 3;
        Assertions.assertFalse(obj.manager_Verification(manager_ID));
    }

    @Test
    void provider_Verification() {
        int provider_id;
        //Create an ID to find.
        String nameToFind = "Barbara Johnson";
        String street = "1234 Maple Lane";
        String city = "Maple City";
        String state = "Maple";
        int zip = 97045;
        Address ad = new Address(street, city, state, zip);
        obj.p_root = obj.add_provider(obj.p_root, nameToFind, 12345, ad, "Dietian");
        provider_id = 12345;
        if (provider_id == obj.p_root.get_provider_id())
            System.out.println("\nProvider ID is a match.");
    }

    @Test
    void display_all() {
        obj.display_all();
    }

    @Test
    void display_all1() {
        obj.display_all();
    }

    @Test
    void updateProviderInfo() {//Void function.
        //fill tree for testing...
        ProviderList obj2 = new ProviderList();
        String nameToFind = "Barbara Johnson";
        String street = "1234 Maple Lane";
        String city = "Maple City";
        String state = "Maple";
        int zip = 97045;
        Address ad = new Address(street, city, state, zip);
        obj2.p_root = obj2.add_provider(obj2.p_root, nameToFind, 12345, ad, "Dietian");
        //response 1.
            updateProviderName();
            int newID = 1234;
            obj2.updateProviderId(obj2.p_root, nameToFind, newID);
        //Response 2;
            String newServices = "Dog carer";
            obj2.updateProviderServices(obj2.p_root, nameToFind, newServices);
            //Respond 3
            street = "1234 street";
            city = "city";
            state = "state";
            zip = 123;
            Address toUpdate = new Address(street, city, state, zip);
            obj2.updateProviderAddress(obj2.p_root, nameToFind, toUpdate);
    }

    @Test
    void updateProviderId() {
        String nameToFind = "Catherine Anderson";
        String street = "1234 Maple Lane";
        String city = "Maple City";
        String state = "Maple";
        int zip = 97045;
        Address ad = new Address(street, city, state, zip);
        int newID = 999999;
        obj.p_root = obj.add_provider(obj.p_root, nameToFind, 12345, ad, "Dietian");
        obj.updateProviderId(obj.p_root, nameToFind, newID);
        Assertions.assertEquals(obj.p_root.get_provider_id(), 999999);
    }

    @Test
    void updateProviderServices() {
        String nameToFind = "Catherine Anderson";
        String street = "1234 Maple Lane";
        String city = "Maple City";
        String state = "Maple";
        int zip = 97045;
        Address ad = new Address(street, city, state, zip);
        //Add into our list...
        obj.p_root = obj.add_provider(obj.p_root, nameToFind, 12345, ad, "Dietian");
        String newServices = "Bric Yoga";
        obj.updateProviderServices(obj.p_root, nameToFind, newServices);
    }

    @Test
    void updateProviderAddress() {
        String nameToFind = "Catherine Anderson";
        String street = "1234 Maple Lane";
        String city = "Maple City";
        String state = "Maple";
        int zip = 97045;
        Address ad = new Address(street, city, state, zip);
        //Provider cath = new Provider(nameToFind, 12345, ad, "Dietian");
        //Add into our list...
        obj.p_root = obj.add_provider(obj.p_root, nameToFind, 12345, ad, "Dietian");
        //Create new address.
        city = "Atlantis";
        street = "1234 magic";
        state = "Decapolis";
        zip = 1234;
        Address toUpdate = new Address(street, city, state, zip);
        //Test our update function.
        obj.updateProviderAddress(obj.p_root, nameToFind, toUpdate);
        Provider newP = obj.get_provider(obj.p_root, "Catherine Anderson");
        Address newAd = newP.get_address();
        Assertions.assertEquals(newAd.street, "1234 magic");
        Assertions.assertEquals(newAd.city, "Atlantis");
        Assertions.assertEquals(newAd.state, "Decapolis");
        Assertions.assertEquals(newAd.zip, 1234);
    }

    @Test
    void updateProviderName() {
        String to_find = "Rick Matthews";
        String to_replace = "George Washingnton";
        String nameToAdd = "Rick Matthews";
        String street = "1234 Maple Lane";
        String city = "Maple City";
        String state = "Maple";
        int zip = 97045;
        Address ad = new Address(street, city, state, zip);
        //Add into our list...
        obj.p_root = obj.add_provider(obj.p_root, nameToAdd, 12345, ad, "Dietian");
        int provider_id = 12345;
        Node provider_to_change = new Provider();
        Assertions.assertNull(obj.find_provider(obj.p_root, to_find, to_replace, provider_id, provider_to_change));
        obj.display_all();
    }

    @Test
    void find_provider() {
        Node provider_to_change = new Provider();
        String nameToAdd = "Rosa Johnston";
        String street = "1234 Maple Lane";
        String city = "Maple City";
        String state = "Maple";
        int zip = 97045;
        Address ad = new Address(street, city, state, zip);
        //Add into our list...
        obj.p_root = obj.add_provider(obj.p_root, nameToAdd, 12345, ad, "Dietian");
        //Find the provider and replace with new name
        String to_find = "Rosa Johnson";
        String to_replace = "George Washingnton";
        int provider_id = 12345;
        obj.p_root = obj.find_provider(obj.p_root, to_find, to_replace, provider_id, provider_to_change);
        Assertions.assertNotNull(obj.find_provider(obj.p_root, to_find, to_replace, provider_id, provider_to_change));
    }

    @Test
    void find_provider1() {
        String nameToAdd = "Rosa Johnston";
        String street = "1234 Maple Lane";
        String city = "Maple City";
        String state = "Maple";
        int zip = 97045;
        Address ad = new Address(street, city, state, zip);
        //Add into our list...
        obj.p_root = obj.add_provider(obj.p_root, nameToAdd, 12345, ad, "Dietian");
        //Find provider.
        Assertions.assertEquals(obj.find_provider(obj.p_root, 12345), "Rosa Johnston");
    }
    @Test
    void find_provider2() {
        String nameToAdd = "Rosa Johnson";
        String street = "1234 Maple Lane";
        String city = "Maple City";
        String state = "Maple";
        int zip = 97045;
        Address ad = new Address(street, city, state, zip);
        //Add into our list...
        obj.p_root = obj.add_provider(obj.p_root, nameToAdd, 12345, ad, "Dietian");
        Assertions.assertEquals(obj.find_provider(obj.p_root, 12345), "Rosa Johnson");
    }

    @Test
    void get_provider() {
        String nameToAdd = "Rick Matthews";
        String street = "1234 Maple Lane";
        String city = "Maple City";
        String state = "Maple";
        int zip = 97045;
        Address ad = new Address(street, city, state, zip);
        //Add into our list...
        obj.p_root = obj.add_provider(obj.p_root, nameToAdd, 12345, ad, "Dietian");
        String pname = "Rick Matthews";
        Provider newP = obj.get_provider(obj.p_root, pname);
        Assertions.assertEquals(newP.get_pname(),"Rick Matthews");
    }

    @Test
    void get_provider1() {
        String nameToAdd = "Barbara Jackson";
        String street = "1234 Maple Lane";
        String city = "Maple City";
        String state = "Maple";
        int zip = 97045;
        Address ad = new Address(street, city, state, zip);
        //Add into our list...
        obj.p_root = obj.add_provider(obj.p_root, nameToAdd, 12345, ad, "Dietian");
        String pname = "Barbara Jackson";
        Provider newP = obj.get_provider(obj.p_root, pname);
        Assertions.assertEquals(newP.get_pname(),"Barbara Jackson");
    }

    @Test
    void get_ids() {
        int plist[] = new int[100];
        Assertions.assertEquals(obj.get_ids(obj.p_root, plist, 0), 0);
    }

    @Test
    void get_ids1() {
        int plist[] = new int[100];
        Assertions.assertEquals(obj.get_ids(obj.p_root, plist, 0), 0);
    }
}