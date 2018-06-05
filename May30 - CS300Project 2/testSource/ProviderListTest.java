import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;

class ProviderListTest {

    @Test
    void read_from_file() {
        ProviderList obj = new ProviderList();
        Assertions.assertEquals(obj.read_from_file(), 1);
    }

    @Test
    void write_to_file() {
        ProviderList obj = new ProviderList();
        Assertions.assertEquals(obj.write_to_file(), 1);
    }

    @Test
    void write_to_file1() {
        try{
        ProviderList obj = new ProviderList();
        FileWriter file = new FileWriter("ProviderList.txt");
        Assertions.assertEquals(obj.write_to_file(obj.p_root, file), 1);
        } catch(IOException e){
            System.out.println("\nIO exception.");
        }

    }

    @Test
    void add_provider() {
        ProviderList obj = new ProviderList();
        //Assertions.assertEquals(obj.add_provider(), 1);
    }

    @Test
    void add_provider1() {
        ProviderList obj = new ProviderList();
        //add_provider(Node p_root, String t_name, int t_id, Address ad, String t_service, float t_week_fee, int t_num_consultations)
        Address ad = new Address();
        Assertions.assertNotNull(obj.add_provider(obj.p_root, "david", 2343, ad, "service"));
    }

    @Test
    void delete() {//wrapper return type void.
    }

    @Test
    void delete1() {
        ProviderList obj = new ProviderList();
        Assertions.assertNull(obj.delete(obj.p_root, "david"));
    }

    @Test
    void manager_Verification() {//todo
        /*ProviderList obj = new ProviderList();
        Assertions.assertTrue(obj.manager_Verification());*/
    }

    @Test
    void display_all() {
    }

    @Test
    void display_all1() {
    }
}