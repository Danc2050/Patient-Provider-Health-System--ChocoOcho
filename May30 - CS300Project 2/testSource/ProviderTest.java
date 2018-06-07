import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProviderTest {

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
    void set_m_name() {
    }

    @Test
    void set_service_code() {
    }

    @Test
    void set_service_fee() {
    }

    @Test
    void get_service_name() {
        Member obj = new Member();
        Assertions.assertNull(obj.get_service_name(), "String is null");
    }

    @Test
    void get_service_code() {
        Member obj = new Member();
        Assertions.assertNull(obj.get_service_name(), "String is null");
    }

    @Test
    void get_service_fee() {
        Member obj = new Member();
        Assertions.assertNull(obj.get_service_name(), "String is null");
    }

    @Test
    void get_status() {
        Member obj = new Member();
        Assertions.assertNull(obj.get_service_name(), "String is null");
    }

    @Test
    void get_member_id() {
        Member obj = new Member();
        Assertions.assertNull(obj.get_service_name(), "String is null");
    }

    @Test
    void get_pname() {
        Member obj = new Member();
        Assertions.assertNull(obj.get_service_name(), "String is null");
    }

    @Test
    void get_pnum() {
        Member obj = new Member();
        Assertions.assertNull(obj.get_service_name(), "String is null");
    }

    @Test
    void get_mname() {
        Member obj = new Member();
        Assertions.assertNull(obj.get_service_name(), "String is null");
    }

    @Test
    void get_sdate() {
        Member obj = new Member();
        Assertions.assertNull(obj.get_service_name(), "String is null");
    }

    @Test
    void get_ldate() {
        Member obj = new Member();
        Assertions.assertNull(obj.get_service_name(), "String is null");
    }

    @Test
    void get_comments() {
        Member obj = new Member();
        Assertions.assertNull(obj.get_service_name(), "String is null");
    }

    @Test
    void displayAll() {
    }

    @Test
    void get_address() {
        Member obj = new Member();
        Assertions.assertNull(obj.get_service_name(), "String is null");
    }

    @Test
    void get_paddress() {
        Member obj = new Member();
        Assertions.assertNull(obj.get_service_name(), "String is null");
    }

    @Test
    void get_maddress() {
        Member obj = new Member();
        Assertions.assertNull(obj.get_service_name(), "String is null");
    }

    @Test
    void get_week_fee() {
        Member obj = new Member();
        Assertions.assertNull(obj.get_service_name(), "String is null");
    }

    @Test
    void get_num_consultations() {
        Member obj = new Member();
        Assertions.assertNull(obj.get_service_name(), "String is null");
    }
}
