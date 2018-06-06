import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.io.*;

class SHistoryTreeTest {

    @org.junit.jupiter.api.Test
    void read_from_file() {
        SHistoryTree obj = new SHistoryTree();
        Assertions.assertEquals(obj.read_from_file(), 1);
    }

    @org.junit.jupiter.api.Test
    void write_to_file() {
        SHistoryTree obj = new SHistoryTree();
        Assertions.assertEquals(obj.write_to_file(), 1);
    }

    @org.junit.jupiter.api.Test
    void write_to_file1() {
        try
        {
            SHistoryTree obj = new SHistoryTree();
            FileWriter file = new FileWriter ("ServiceHistory.txt");
            Assertions.assertEquals(obj.write_to_file(obj.h_root, file), 1);
        }
        catch (IOException e)
        {
            System.out.println("\nIO exception");
        }
    }

    @org.junit.jupiter.api.Test
    void add_history() {
        SHistoryTree obj = new SHistoryTree();
    }

    @org.junit.jupiter.api.Test
    void add_history1() {
        SHistoryTree obj = new SHistoryTree();
        Provider prov = new Provider();
        Member mem = new Member();
        Service service = new Service();

        Assertions.assertNotNull(obj.add_history(obj.h_root, prov, mem, service, "06-01-2018 03:30:30", "06-04-2018 05:25:50", "good health"));
    }

    @org.junit.jupiter.api.Test
    void email_p_history() {
        SHistoryTree obj = new SHistoryTree();
        Assertions.assertEquals(obj.email_p_history(), 1);
    }

    @org.junit.jupiter.api.Test
    void email_p_history1() {
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
    }
}