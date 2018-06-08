import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;

import static org.junit.jupiter.api.Assertions.*;

class MemberListTest extends Utility{

    MemberList test_list = new MemberList();
    
    @org.junit.jupiter.api.Test
    void updateMemberName() {
        MemberList member_to_change = new MemberList();
        int result = 0;
        Assertions.assertEquals(result, 0);
    }

    @org.junit.jupiter.api.Test
    void find_member() {
        MemberList obj = new MemberList();
        Address ad = new Address("6613 SE 92nd AVE", "Portland", "OR", 97266);
        Member root = new Member(12345678, "Active", "Thong Nguyen", ad);
        Node member = new Member();
        Node ret = obj.find_member(root, "Thong Nguyen", "Dat Huynh", 12345678, member);
        ret = (Member) ret;
        assertNull(ret);
        assertEquals(root.get_member_name(), "Dat Huynh");
        Node ret2 = obj.find_member(root, "Nam Nguyen", "Tai Tran", 12345686, member);
        assertNotNull(ret2);

    }

    @org.junit.jupiter.api.Test
    void updateMemberId_wrapper() {
        updateMemberId();
    }

    @org.junit.jupiter.api.Test
    void updateMemberId() {
        MemberList obj = new MemberList();
        Address ad = new Address("6613 SE 92nd AVE", "Portland", "OR", 97266);
        Member root = new Member(12345678, "Active", "Thong Nguyen", ad);
        Node ret = obj.updateMemberId(root, "Thong Nguyen", 12345454, 12345678);
        ret = (Member) ret;
        assertNotNull(ret);
        assertEquals(root.get_member_id(), 12345454);
        Node ret2 = obj.updateMemberId(root, "Nam Nguyen", 12345645, 12345686);
        assertNotNull(ret2);
    }

    @org.junit.jupiter.api.Test
    void updateMemberInfo() {
        updateMemberName();
        updateMemberId_wrapper();
        updateMemberStatus_wrapper();
        updateMemberAddress_wrapper();

    }

    @org.junit.jupiter.api.Test
    void updateMemberStatus_wrapper() {
        updateMemberStatus();
    }

    @org.junit.jupiter.api.Test
    void updateMemberStatus() {
        MemberList obj = new MemberList();
        Address ad = new Address("6613 SE 92nd AVE", "Portland", "OR", 97266);
        Member root = new Member(12345678, "Active", "Thong Nguyen", ad);
        Node ret = obj.updateMemberStatus(root, "Thong Nguyen", "Suspended");
        ret = (Member) ret;
        assertNotNull(ret);
        assertEquals(root.get_status(), "Suspended");
        Node ret2 = obj.updateMemberStatus(root, "Nam Nguyen", "Active");
        assertNotNull(ret2);
    }

    @org.junit.jupiter.api.Test
    void updateMemberAddress_wrapper() {
        updateMemberStatus();
    }

    @org.junit.jupiter.api.Test
    void updateMemberAddress() {
        MemberList obj = new MemberList();
        Address ad = new Address("6613 SE 92nd AVE", "Portland", "OR", 97266);
        Member root = new Member(12345678, "Active", "Thong Nguyen", ad);
        Node ret = obj.updateMemberAddress(root, "Thong Nguyen", ad);
        ret = (Member) ret;
        assertNotNull(ret);
        assertEquals(root.get_address().street, ad.street);
        assertEquals(root.get_address().city, ad.city);
        assertEquals(root.get_address().state, ad.state);
        assertEquals(root.get_address().zip, ad.zip);

        Address new_ad = new Address("1234 SE 82nd AVE", "Salem", "OR", 97206);
        Node ret2 = obj.updateMemberAddress(root, "Nam Nguyen", new_ad);
        assertNotNull(ret2);


    }

    @org.junit.jupiter.api.Test
    void read_from_file() {
        assertEquals(0, test_list.read_from_file());
    }

    @org.junit.jupiter.api.Test
    void add_member_wrapper() {
        System.out.println("Inserting a new member");
        MemberList instance = new MemberList();
        Address ad = new Address("6613 SE 92nd AVE", "Portland", "OR", 97266);
        Address new_ad = new Address("3196 NE 82nd AVE", "Beaverton", "OR", 97206);
        Member root = new Member(123456, "Active", "Thong Nguyen", ad);
        Member root2 = null;

        if(root2 == null)
            root2 = (Member) instance.add_member(root, 123456, "Active", "Thong Nguyen", ad);
        if(root != null)
            root = (Member) instance.add_member(root, 123455, "Suspended", "Dat Huynh",  new_ad);
        else
            fail("The list is empty");
    }


    @org.junit.jupiter.api.Test
    void add_member() {
        Address ad = new Address("6613 SE 92nd AVE", "Portland", "OR", 97266);
        Member obj = new Member(123456, "Active", "Thong Nguyen", ad);
        //obj.add_member(obj.m_root, 123456, "Active", "Thong Nguyen", ad);

        MemberList new_obj = new MemberList();

        Node new_mem = new_obj.add_member(new_obj.m_root, 123456, "Active", "Thong Nguyen", ad);
        Assertions.assertEquals(obj.get_member_id(), new_mem.get_member_id());
        Assertions.assertEquals(obj.get_status(), new_mem.get_status());
        Assertions.assertEquals(obj.get_member_name(), new_mem.get_member_name());
        Assertions.assertEquals(obj.get_address().street, new_mem.get_address().street);
        Assertions.assertEquals(obj.get_address().city, new_mem.get_address().city);
        Assertions.assertEquals(obj.get_address().state, new_mem.get_address().state);
        Assertions.assertEquals(obj.get_address().zip, new_mem.get_address().zip);

    }

    @org.junit.jupiter.api.Test
    void check_name_wrapper() {
        MemberList m_list = new MemberList();
        int should_be_0 = m_list.check_name_wrapper("Thong Nguyen");
        assertEquals(should_be_0, 0);
    }

    @org.junit.jupiter.api.Test
    void check_name() {
        MemberList m_list = new MemberList();
        Address ad = new Address("6613 SE 92nd AVE", "Portland", "OR", 97266);
        Member root = new Member(123456, "Active", "Thong Nguyen", ad);
        int should_be_1 = m_list.check_name(root, "Thong Nguyen");
        int should_be_0 = m_list.check_name(root, "Dat Huynh");
        assertEquals(should_be_1, 1);
        assertEquals(should_be_0, 0);
    }

    @org.junit.jupiter.api.Test
    void check_id_wrapper() {
        MemberList m_list = new MemberList();
        int should_be_0 = m_list.check_id_wrapper(1234567);
        Assertions.assertEquals(should_be_0, 0);
    }

    @org.junit.jupiter.api.Test
    void check_id() {
        MemberList m_list = new MemberList();
        Address ad = new Address("6613 SE 92nd AVE", "Portland", "OR", 97266);
        Member root = new Member(123456, "Active", "Thong Nguyen", ad);
        //Member fail_root = new Member(123455, "Active", "Thong Nguyen", ad);
        int [] check_value = new int[1];
        check_value[0] = -1;
        m_list.check_id(root, 123456, check_value);
        assertEquals(check_value[0], 1);
        int should_be_0 = m_list.check_id(root, 123457, check_value);
        assertEquals(should_be_0, 0);
        assertEquals(check_value[0], 1);

    }

    @org.junit.jupiter.api.Test
    void write_to_file() {
        assertEquals(1, test_list.write_to_file());
    }

    @org.junit.jupiter.api.Test
    void write_to_file1() {
        assertEquals(1, test_list.write_to_file());
    }

    @org.junit.jupiter.api.Test
    void remove_member_wrapper() {
        //remove_member();
        MemberList m_list = new MemberList();
        Address ad = new Address("6613 SE 92nd AVE", "Portland", "OR", 97266);
        Member root = new Member();
        root = null;
        root = (Member) m_list.add_member(root, 123456, "Active", "Thong Nguyen", ad);
        m_list.remove_member_wrapper("Thong Nguyen", 123456);
        assertNull(m_list.m_root);
    }

    @org.junit.jupiter.api.Test
    void remove_member() {
        MemberList m_list = new MemberList();
        Address ad = new Address("6613 SE 92nd AVE", "Portland", "OR", 97266);
        Member root = new Member();
        root = null;
        root = (Member) m_list.add_member(root, 123456, "Active", "Thong Nguyen", ad);
        root = (Member) m_list.add_member(root, 123444, "Suspended", "Dat Huynh", ad);
        root = (Member) m_list.add_member(root, 123466, "Active", "Nam Nguyen", ad);

        root = (Member) m_list.remove_member(root, "Tien Huynh", 123654);
        assertNotNull(root);

        root = (Member) m_list.remove_member(root, "Nam Nguyen", 123466);
        root = (Member) m_list.remove_member(root, "Dat Huynh", 123444);
        root = (Member) m_list.remove_member(root, "Thong Nguyen", 123456);
        assertNull(root);

        Member test_root = new Member();
        test_root = null;
        test_root = (Member) m_list.remove_member(test_root, "Dat Huynh", 123444);
        assertNull(test_root);
    }

    @org.junit.jupiter.api.Test
    void find_inorder() {
        MemberList m_list = new MemberList();
        Node test_node = new Member();
        int [] test = new int[1];
        test[0] = -1;
        Member root = new Member();
        root = null;
        Address ad = new Address("6613 SE 92nd AVE", "Portland", "OR", 97266);
        root = (Member) m_list.add_member(root, 123456, "Active", "Thong Nguyen", ad);
        root = (Member) m_list.add_member(root, 123444, "Suspended", "Dat Huynh", ad);
        root = (Member) m_list.add_member(root, 123466, "Active", "Vi Nguyen", ad);
        String ret = m_list.find_inorder(root, test, test_node);
        assertEquals(ret, "Dat Huynh");
    }

    @org.junit.jupiter.api.Test
    void validate_member_wrapper() {
    }

    @org.junit.jupiter.api.Test
    void display_all_wrapper() {
        display_all();
    }

    @org.junit.jupiter.api.Test
    void display_all() {
        MemberList m_list = new MemberList();
        Member root = new Member();

        m_list.display_all(root);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        String ret = new String(output.toByteArray());
        assertEquals(ret, "");

    }

    @org.junit.jupiter.api.Test
    void validate_member() {
        MemberList test = new MemberList();
        int value = 0;
        int [] arr = new int[0];
    }

    @org.junit.jupiter.api.Test
    void import_member_list() {
    }

    @org.junit.jupiter.api.Test
    void get_member() {
        MemberList test = new MemberList();
        test.m_root = test.get_member(test.m_root, null);
        Assertions.assertNull(test.m_root);
    }

    @org.junit.jupiter.api.Test
    void get_member1() {
        MemberList test = new MemberList();
        test.m_root = test.get_member(test.m_root, null);
        Assertions.assertNull(test.m_root);
    }

    @org.junit.jupiter.api.Test
    void find_member1() {
        MemberList test = new MemberList();
        String result = test.find_member(test.m_root, 0);
        Assertions.assertNull(result);
    }

    @org.junit.jupiter.api.Test
    void find_member2() {
        MemberList test = new MemberList();
        String result = test.find_member(test.m_root, 0);
        Assertions.assertNull(result);
    }
}
