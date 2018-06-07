import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class ServiceTest {

    @Test
    void toCopy() {
        Service s = new Service("Yoga Trainer", 12345, 600);

        Service s2 = new Service();
        s2.toCopy(s);

        Assertions.assertEquals("Yoga Trainer", s2.s_name);
        Assertions.assertEquals(12345, s2.s_code);
        Assertions.assertEquals(600, s2.s_fee);
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
    void set_m_name() {
    }

    @Test
    void get_service_name() {
        Member obj = new Member();
        Assertions.assertNull(obj.get_service_name(), "String is null");
    }

    @Test
    void get_service_code() {
        Member obj = new Member();
        Assertions.assertNotNull(obj.get_service_code(), "String is null");
    }

    @Test
    void get_service_fee() {
        Member obj = new Member();
        Assertions.assertNotNull(obj.get_service_fee(), "String is null");
    }

    @Test
    void displayAll() {
    }

    @Test
    void get_status() {
        Member obj = new Member();
        Assertions.assertNull(obj.get_status(), "String is null");
    }

    @Test
    void get_member_id() {
        Member obj = new Member();
        Assertions.assertNotNull(obj.get_member_id(), "String is null");
    }

    @Test
    void get_pname() {
        Member obj = new Member();
        Assertions.assertNull(obj.get_pname(), "String is null");
    }

    @Test
    void get_pnum() {
        Member obj = new Member();
        Assertions.assertNotNull(obj.get_pnum(), "String is null");
    }

    @Test
    void get_mname() {
        Member obj = new Member();
        Assertions.assertNull(obj.get_mname(), "String is null");
    }

    @Test
    void get_sdate() {
        Member obj = new Member();
        Assertions.assertNull(obj.get_sdate(), "String is null");
    }

    @Test
    void get_ldate() {
        Member obj = new Member();
        Assertions.assertNull(obj.get_ldate(), "String is null");
    }

    @Test
    void get_comments() {
        Member obj = new Member();
        Assertions.assertNull(obj.get_comments(), "String is null");
    }

    @Test
    void get_paddress() {
        Member obj = new Member();
        Assertions.assertNull(obj.get_paddress(), "String is null");
    }

    @Test
    void get_maddress() {
        Member obj = new Member();
        Assertions.assertNull(obj.get_maddress(), "String is null");
    }
}
