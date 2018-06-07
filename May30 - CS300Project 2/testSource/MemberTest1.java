import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest1 {

    @Test
    void toCopy() {
        Address a = new Address("123 Main St.", "Springfield", "OR", 97209);
        Member m = new Member(12345, "Active", "Joe", a);

        Member m2 = new Member();
        m2.toCopy(m);

        assertEquals(12345, m2.id);
        assertEquals("Joe", m2.Name);
        assertEquals("Active", m2.m_status);
        Address ad = m.get_maddress();
        assertEquals(a.street, ad.street);
        assertEquals(a.state, ad.state);
        assertEquals(a.city, ad.city);
        assertEquals(a.zip, ad.zip);
    }

    @Test
    void set_service_name() {
        Service test = new Service();
        test.set_service_name(null);
        Assertions.assertEquals(test.s_name, null);
    }

    @Test
    void set_service_code() {
        Service test = new Service();
        test.set_service_code(0);
        Assertions.assertEquals(test.s_code, 0);
    }

    @Test
    void set_service_fee() {
        Service test = new Service();
        test.set_service_fee(0);
        Assertions.assertEquals(test.s_fee, 0);
    }

    @Test
    void set_m_name() {
        int id = 12345;
        String status = "Active";
        String Name = "Michael Jordan";
        Address ad = new Address("Barney", "Portland", "OR", 97236);
        Member test = new Member(id, status, Name, ad);
        test.set_m_name("foo");
        Assertions.assertEquals(test.Name, "foo");
    }

    @Test
    void get_service_name() {
        Member obj = new Member();
        assertNull(obj.get_service_name(), "String is null");
    }

    @Test
    void get_service_code() {
        Member obj = new Member();
        assertNotNull(obj.get_service_code(), "String is null");
    }

    @Test
    void get_service_fee() {
        Member obj = new Member();
        assertNotNull(obj.get_service_fee(), "String is null");
    }

    @Test
    void get_member_id() {
        Member obj = new Member();
        assertNotNull(obj.get_member_id(), "String is null");
    }

    @Test
    void get_status() {
        Member obj = new Member();
        assertNull(obj.get_status(), "String is null");
    }

    @Test
    void get_pname() {
        Member obj = new Member();
        assertNull(obj.get_pname(), "String is null");
    }

    @Test
    void get_pnum() {
        Member obj = new Member();
        assertNotNull(obj.get_pnum(), "String is null");
    }

    @Test
    void get_mname() {
        Member obj = new Member();
        assertNull(obj.get_mname(), "String is null");
    }

    @Test
    void displayAll() {
    }

    @Test
    void get_sdate() {
        Member obj = new Member();
        assertNull(obj.get_sdate(), "String is null");
    }

    @Test
    void get_ldate() {
        Member obj = new Member();
        assertNull(obj.get_ldate(), "String is null");
    }

    @Test
    void get_comments() {
        Member obj = new Member();
        assertNull(obj.get_comments(), "String is null");
    }

    @Test
    void get_address() {
        Member obj = new Member();
        assertNull(obj.get_address(), "String is null");
    }

    @Test
    void get_paddress() {
        Member obj = new Member();
        assertNull(obj.get_paddress(), "String is null");
    }

    @Test
    void get_maddress() {
        Member obj = new Member();
        assertNull(obj.get_maddress(), "String is null");
    }

    @Test
    void set_member_status()
    {
        int id = 12345;
        String status = "Active";
        String Name = "Michael Jordan";
        Address ad = new Address("Barney", "Portland", "OR", 97236);
        Member test = new Member(id, status, Name, ad);
        test.set_member_status("Suspended");
        Assertions.assertEquals(test.m_status, "Suspended");
    }

    @Test
    void set_member_id()
    {
        int id = 12345;
        String status = "Active";
        String Name = "Michael Jordan";
        Address ad = new Address("Barney", "Portland", "OR", 97236);
        Member test = new Member(id, status, Name, ad);
        test.set_member_id(101010);
        Assertions.assertEquals(test.id, 101010);
    }

    @Test
    void set_member_name()
    {
        int id = 12345;
        String status = "Active";
        String Name = "Michael Jordan";
        Address ad = new Address("Barney", "Portland", "OR", 97236);
        Member test = new Member(id, status, Name, ad);
        test.set_member_name("foo");
        Assertions.assertEquals(test.Name, "foo");
    }
    @Test
    void set_member_address()
    {
        int id = 12345;
        String status = "Active";
        String Name = "Michael Jordan";
        Address ad = new Address("Barney", "Portland", "OR", 97236);
        Member test = new Member(id, status, Name, ad);
        test.set_member_address(ad);
        Assertions.assertEquals(test.m_address, ad);
    }
}
