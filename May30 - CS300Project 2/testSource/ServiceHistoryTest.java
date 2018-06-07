import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServiceHistoryTest {
        Address a = new Address("123 Main St.", "Springfield", "OR", 97209);
        Provider p = new Provider("Joe", 12345, a, "stuff");
        Member m = new Member(12345, "Active", "Joe", a);
        Service s = new Service("Yoga Trainer", 12345, 600);
        String sdate = "05-12-2018 03:32:12";
        String ldate = "05-12-2018 05:45:34";
        ServiceHistory obj = new ServiceHistory(p,m,s,sdate, ldate, "Good");

    @Test
    void get_service_name() {
        assertEquals(obj.get_service_name(), "Yoga Trainer");
    }

    @Test
    void get_service_code() {
        assertEquals(obj.get_service_code(),12345);
    }

    @Test
    void get_service_fee() {
        assertEquals(obj.get_service_fee(), 600);
    }

    @Test
    void displayAll() {
    }

    @Test
    void set_service_name() {
    }

    @Test
    void set_service_code() {
    }

    @Test
    void set_service_fee() {
    }

    @Test
    void get_status() {
        assertNull(obj.get_status(), "String is null");
    }

    @Test
    void get_pname() {
        assertEquals(obj.get_pname(), "Joe");
    }

    @Test
    void get_pnum() {
        assertEquals(obj.get_pnum(), 12345);
    }

    @Test
    void get_sdate() {
        assertEquals(obj.get_sdate(), "05-12-2018 03:32:12");
    }

    @Test
    void get_ldate() {
        assertEquals(obj.get_ldate(), "05-12-2018 05:45:34");
    }

    @Test
    void get_comments() {
        assertEquals(obj.get_comments(), "Good");
    }

    @Test
    void get_paddress() {
       Address a = new Address();
       a.to_copy(obj.get_paddress());
        assertEquals("123 Main St.", a.street);
        assertEquals("Springfield", a.city);
        assertEquals("OR", a.state);
        assertEquals(97209, a.zip);
    }

    @Test
    void set_p_name() {
    }

    @Test
    void set_provider_id() {
    }

    @Test
    void set_provider_services() {
    }

    @Test
    void get_provider_services() {
        assertNull(obj.get_provider_services(), "String is null");
    }

    @Test
    void set_provider_address() {
    }

    @Test
    void get_address() {
        assertNull(obj.get_address(), "String is null");
    }

    @Test
    void set_member_address() {
    }

    @Test
    void get_member_name() {
        assertNull(obj.get_member_name(), "String is null");
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
    void get_member_id() {
        assertEquals(obj.get_member_id(), 12345);
    }

    @Test
    void set_m_name() {
    }

    @Test
    void get_maddress() {
        Address a = new Address();
        a.to_copy(obj.get_maddress());
        assertEquals("123 Main St.", a.street);
        assertEquals("Springfield", a.city);
        assertEquals("OR", a.state);
        assertEquals(97209, a.zip);
    }

    @Test
    void get_mname() {
        assertEquals(obj.get_mname(), "Joe");
    }
}
