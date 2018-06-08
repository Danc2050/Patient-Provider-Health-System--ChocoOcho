import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;

import static org.junit.jupiter.api.Assertions.*;

class SHistoryTreeTest {
    SHistoryTree obj = new SHistoryTree();

    @Test
    void read_from_file() {
        assertEquals(obj.read_from_file(), 1);
    }

    @Test
    void write_to_file() {
        assertEquals(obj.write_to_file(), 1);
    }

    @Test
    void write_to_file1() {
        assertEquals(obj.write_to_file(), 1);
    }

    @Test
    void add_history() {
        add_history1();
    }

    @Test
    void add_history1() {
        Provider prov = new Provider();
        Member mem = new Member();
        Service service = new Service();

        assertNotNull(obj.add_history(obj.h_root, prov, mem, service, "06-01-2018 03:30:30", "06-04-2018 05:25:50", "good health"));
    }

    /*
    @org.junit.jupiter.api.Test
    void email_p_history() {
        email_p_history1();
    }

    @org.junit.jupiter.api.Test
    void email_p_history1() {
        email_p_history2();
    }

    @org.junit.jupiter.api.Test
    void email_p_history2() {
    }

    @org.junit.jupiter.api.Test
    void email_m_history() {
    }

    @org.junit.jupiter.api.Test
    void email_m_history1() {
    }

    @org.junit.jupiter.api.Test
    void email_m_history2() {
    }

    @org.junit.jupiter.api.Test
    void email_summary_report() {
    }

    @org.junit.jupiter.api.Test
    void email_summary_report1() {
    }

    @org.junit.jupiter.api.Test
    void get_p_info() {
    }

    @org.junit.jupiter.api.Test
    void get_p_info1() {
    }

    @org.junit.jupiter.api.Test
    void visited() {
    }

    @org.junit.jupiter.api.Test
    void visit() {
    }*/
}