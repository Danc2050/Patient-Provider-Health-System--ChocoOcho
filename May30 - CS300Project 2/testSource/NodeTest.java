import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    @Test
    void go_left() {
        Provider root = new Provider();
        Assertions.assertNull(root.go_left());

        root.connect_left(root);
        Assertions.assertNotNull(root.go_left());
    }

    @Test
    void go_right() {
        Provider root = new Provider();
        Assertions.assertNull(root.go_right());

        root.connect_right(root);
        Assertions.assertNotNull(root.go_right());
    }

    @Test
    void connect_left() {
        Provider root = new Provider();
        Provider leftChild = new Provider();
        root.connect_left(leftChild);
        Assertions.assertNotNull(root.go_left());
    }

    @Test
    void connect_right() {
        Provider root = new Provider();
        Provider rightChild = new Provider();
        root.connect_right(rightChild);
        Assertions.assertNotNull(root.go_right());
    }

    @Test
    void displayAll() {
    }

    @Test
    void get_service_name() {
         Service Test = new Service();
         Test.s_name = "Phil Knight";
         assertEquals(Test.get_service_name(), "Phil Knight");
    }

    @Test
    void get_service_code() {
        Service Test = new Service();
        Test.s_code = 123456;
        assertEquals(Test.get_service_code(), 123456);
    }

    @Test
    void get_service_fee() {
        Service Test = new Service();
        Test.s_fee = 600;
        assertEquals(Test.get_service_fee(), 600);
    }

    @Test
    void set_service_name() {
        Service Test = new Service();
        Test.s_name = "initialName";
        Test.set_service_name("finalName");
        Assertions.assertEquals(Test.s_name, "finalName");
    }

    @Test
    void set_service_code() {
        Service Test = new Service();
        Test.s_code = 1234;
        Test.set_service_code(4321);
        Assertions.assertEquals(Test.s_code, 4321);
    }

    @Test
    void set_service_fee() {
        Service Test = new Service();
        Test.s_fee = 123456;
        Test.set_service_fee(600);
        Assertions.assertEquals(Test.s_fee, 600);
    }

    @Test
    void get_member_id() {
        int id = 12345;
        String status = "Active";
        String Name = "Michael Jordan";
        Address ad = new Address("Barney", "Portland", "OR", 97236);
        Member test = new Member(id, status, Name, ad);
        Assertions.assertEquals(test.get_member_id(), 12345);
    }

    @Test
    void get_status() {
        int id = 12345;
        String status = "Active";
        String Name = "Michael Jordan";
        Address ad = new Address("Barney", "Portland", "OR", 97236);
        Member test = new Member(id, status, Name, ad);
        Assertions.assertEquals(test.get_status(), "Active");
    }

    @Test
    void get_member_name() {
        int id = 12345;
        String status = "Active";
        String Name = "Michael Jordan";
        Address ad = new Address("Barney", "Portland", "OR", 97236);
        Member test = new Member(id, status, Name, ad);
        Assertions.assertEquals(test.get_mname(), "Michael Jordan");
    }

    @Test
    void get_address() {
    }

    @Test
    void set_m_name() {
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
    void set_member_address() {
    }

    @Test
    void get_pname() {
    }

    @Test
    void get_pnum() {
    }

    @Test
    void get_mname() {
    }

    @Test
    void get_sdate() {
    }

    @Test
    void get_ldate() {
    }

    @Test
    void get_comments() {
    }

    @Test
    void get_paddress() {
    }

    @Test
    void get_maddress() {
    }

    @Test
    void set_provider_id() {
    }

    @Test
    void get_provider_id() {
    }

    @Test
    void set_provider_services() {
    }

    @Test
    void get_provider_services() {
    }

    @Test
    void set_provider_address() {
    }

    @Test
    void set_p_name() {
    }
}