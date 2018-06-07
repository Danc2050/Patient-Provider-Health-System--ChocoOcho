import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberListTest extends Utility{

    @Test
    void updateMemberName() {
        MemberList member_to_change = new MemberList();
        int result = 0;
        Assertions.assertEquals(result, 0);
    }

    @Test
    void find_member() {
    }

    @Test
    void updateMemberId_wrapper() {
    }

    @Test
    void updateMemberId() {
    }

    @Test
    void updateMemberInfo() {
    }

    @Test
    void updateMemberStatus_wrapper() {
    }

    @Test
    void updateMemberStatus() {
    }

    @Test
    void updateMemberAddress_wrapper() {
    }

    @Test
    void updateMemberAddress() {
    }

    @Test
    void read_from_file() {
    }

    @Test
    void add_member_wrapper() {
    }

    @Test
    void add_member() {
    }

    @Test
    void check_name_wrapper() {
    }

    @Test
    void check_name() {
    }

    @Test
    void check_id_wrapper() {
    }

    @Test
    void check_id() {
    }

    @Test
    void write_to_file() {
    }

    @Test
    void write_to_file1() {
    }

    @Test
    void remove_member_wrapper() {
    }

    @Test
    void remove_member() {
    }

    @Test
    void find_inorder() {
    }

    @Test
    void validate_member_wrapper() {
    }

    @Test
    void display_all_wrapper() {
    }

    @Test
    void display_all() {
    }

    @Test
    void validate_member() {
        MemberList test = new MemberList();
        int value = 0;
        int [] arr = new int[0];
    }

    @Test
    void import_member_list() {
    }

    @Test
    void get_member() {
        MemberList test = new MemberList();
        test.m_root = test.get_member(test.m_root, null);
        Assertions.assertNull(test.m_root);
    }

    @Test
    void get_member1() {
        MemberList test = new MemberList();
        test.m_root = test.get_member(test.m_root, null);
        Assertions.assertNull(test.m_root);
    }

    @Test
    void find_member1() {
        MemberList test = new MemberList();
        String result = test.find_member(test.m_root, 0);
        Assertions.assertNull(result);
    }

    @Test
    void find_member2() {
        MemberList test = new MemberList();
        String result = test.find_member(test.m_root, 0);
        Assertions.assertNull(result);
    }
}