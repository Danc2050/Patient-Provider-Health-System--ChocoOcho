import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    @Test
    void load_data() {
        MemberList list_of_members = new MemberList();
        ProviderList list_of_providers = new ProviderList();
        SHistoryTree tree_of_services = new SHistoryTree();
        ServiceList list_of_all_services = new ServiceList();
        assertEquals(list_of_members.read_from_file(), 0);
        assertEquals(list_of_providers.read_from_file(), 1);
        assertEquals(tree_of_services.read_from_file(), 1);
        assertEquals(list_of_all_services.read_from_file(), 1);
    }

    @Test
    void mainMode() {
        int interactiveResponse = 1;
        int providerMode = 2;
        int exit = 3;
        assertEquals(interactiveResponse, 1);
        assertEquals(providerMode, 2);
        assertEquals(exit, 3);
    }

    @Test
    void write_data() {
    }

    @Test
    void intMode() {
        int member = 1;
        int provider = 2;
        int report = 3;
        int service = 4;
        int mainMenu = 5;
        assertEquals(member, 1);
        assertEquals(provider, 2);
        assertEquals(report, 3);
        assertEquals(service, 4);
        assertEquals(mainMenu, 5);
    }

    @Test
    void intMode_Member() {
    }

    @Test
    void intMode_Provider() {
    }

    @Test
    void intMode_Report() {
    }

    @Test
    void intMode_Service() {
    }

    @Test
    void providerMenu() {
    }

    @Test
    void providerMenu_directory() {
    }

    @Test
    void validate_member() {
    }

    @Test
    void create_service() {
    }
}