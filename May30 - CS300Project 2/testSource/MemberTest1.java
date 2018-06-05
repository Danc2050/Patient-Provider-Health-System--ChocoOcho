import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest1 {

    @Test
    void toCopy() {//Can I test this?

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
}