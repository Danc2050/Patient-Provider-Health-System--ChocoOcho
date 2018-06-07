import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProviderTest {
    Provider obj = new Provider();

    @Test
    void toCopy() {
        Address a = new Address("123 Main St.", "Springfield", "OR", 97209);
        Provider p = new Provider("Joe", 12345, a, "stuff");

        Provider p2 = new Provider();
        p2.toCopy(p);

        assertEquals("Joe", p2.Name);
        assertEquals(12345, p2.id);
        Address ad = p.get_address();
        assertEquals(a.street, ad.street);
        assertEquals(a.state, ad.state);
        assertEquals(a.city, ad.city);
        assertEquals(a.zip, ad.zip);
        assertEquals("stuff", p2.Service);

    }
    @Test
    void set_service_name() {
    }

    @Test
    void set_service_fee() {
    }

    @Test
    void set_service_code() {
    }

    @Test
    void get_service_name() {
        Assertions.assertNull(obj.get_service_name());
    }

    @Test
    void get_service_code() {
        Assertions.assertEquals(obj.get_service_code(), 0);
    }

    @Test
    void get_service_fee() {
        Assertions.assertEquals(obj.get_service_fee(), 0);
    }

    @Test
    void set_provider_services() {
        obj.set_provider_services("Bric Yoga");
        Assertions.assertEquals(obj.Service, "Bric Yoga");
    }

    @Test
    void get_provider_services() {
        obj.set_provider_services("Bric Yoga");
        Assertions.assertEquals(obj.get_provider_services(), "Bric Yoga");
    }

    @Test
    void set_provider_id() {
        obj.set_provider_id(987);
        Assertions.assertEquals(obj.id, 987);
    }

    @Test
    void get_provider_id() {
        obj.set_provider_id(987);
        Assertions.assertEquals(obj.get_provider_id(), 987);
    }

    @Test
    void set_provider_address() {
        //Assertions.assertNull(obj.get_service_name(), "String is null");
        Address newAd = new Address("1234 Maple Lane", "Maple City", "Maple", 97045);
        obj.set_provider_address(newAd);
        Assertions.assertEquals(newAd.street, "1234 Maple Lane");
        Assertions.assertEquals(newAd.city, "Maple City");
        Assertions.assertEquals(newAd.state, "Maple");
        Assertions.assertEquals(newAd.zip, 97045);
    }

    @Test
    void get_pname() {
        obj.set_p_name("Roger");
        Assertions.assertEquals(obj.get_pname(), "Roger");
    }

    @Test
    void get_pnum() {
        obj.set_provider_id(987);
        Assertions.assertEquals(obj.get_pnum(), 987);
    }

    @Test
    void set_p_name() {
        obj.set_p_name("Roger");
        Assertions.assertEquals(obj.Name, "Roger");
    }

    @Test
    void get_paddress() {
        Address ad = new Address("1234 Maple Lane", "Maple City", "Maple", 97045);
        obj.set_provider_address(ad);
        Address newAd = obj.get_address();
        Assertions.assertEquals(newAd.street, "1234 Maple Lane");
        Assertions.assertEquals(newAd.city, "Maple City");
        Assertions.assertEquals(newAd.state, "Maple");
        Assertions.assertEquals(newAd.zip, 97045);
    }
/*Most of these functions cannot be tested because most return void and do not change
  any data members.
*/
    @Test
    void set_m_name() {
    }
    @Test
    void get_member_id() {
        Assertions.assertEquals(obj.get_member_id(), 0);
    }

    @Test
    void get_mname() {
        Assertions.assertNull(obj.get_mname());
    }

    @Test
    void get_maddress() {
        Assertions.assertNull(obj.get_maddress());
    }

    @Test
    void set_member_address() {
    }

    @Test
    void get_member_name() {
        Assertions.assertNull(obj.get_member_name());
    }

    @Test
    void set_member_status() {
    }

    @Test
    void set_member_name() {
    }

    @Test
    void set_member_id() {
    }

    @Test
    void get_status() {
        Assertions.assertNull(obj.get_service_name(), "String is null");
    }

    @Test
    void get_sdate() {
        Assertions.assertNull(obj.get_service_name(), "String is null");
    }

    @Test
    void get_ldate() {
        Assertions.assertNull(obj.get_service_name(), "String is null");
    }

    @Test
    void get_comments() {
        Assertions.assertNull(obj.get_service_name(), "String is null");
    }

    @Test
    void get_address() {
        //Assertions.assertNull(obj.get_service_name(), "String is null");
        Address ad = new Address("1234 Maple Lane", "Maple City", "Maple", 97045);
        obj.set_provider_address(ad);
        Address newAd = obj.get_address();
        Assertions.assertEquals(newAd.street, "1234 Maple Lane");
        Assertions.assertEquals(newAd.city, "Maple City");
        Assertions.assertEquals(newAd.state, "Maple");
        Assertions.assertEquals(newAd.zip, 97045);
    }

    @Test
    void displayAll() {
        Provider instance = new Provider();
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        String ret = new String(output.toByteArray());
        assertEquals("", ret);
        instance.set_provider_services("Bric Yoga");
        instance.set_provider_id(12345);
        Address ad = new Address("1234 Maple Lane", "Maple City", "Maple", 97045);
        instance.set_provider_address(ad);
        instance.DisplayAll();
        ByteArrayOutputStream output2 = new ByteArrayOutputStream();
        String ret2 = new String(output2.toByteArray());
        assertEquals("", ret2);
    }
}
