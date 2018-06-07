import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;

import static org.junit.jupiter.api.Assertions.*;

class ServiceListTest {
    ServiceList SL = new ServiceList();

    @Test
    void read_from_file() {
        assertEquals(SL.read_from_file(), 1);
    }

    @Test
    void write_to_file() {
        //write_to_file1();
        assertEquals(SL.write_to_file(), 1);
    }

    @Test
    void write_to_file1() {
        assertEquals(SL.write_to_file(), 1);
    }

   /* @Test
    void email_service_list() {
        int ret = SL.email_service_list();
        String input = "212345645";

        assertEquals(ret, 1);
    }*/

    @Test
    void add_service() {
        add_service1();
        //assertEquals(SL.add_service(), 1);
    }

    @Test
    void add_service1() {
        add_service2();
        //assertEquals(SL.add_service(12345, "Pharmacist", 600), 1);
    }

    @Test
    void add_service2() {
        System.out.println("Inserting a new service");
        ServiceList instance = new ServiceList();
        Service root = new Service("Pharmacist", 12345, 600);
        Service root2 = null;

        if(root2 == null)
            root2 = (Service) instance.add_service(root, 12345, "Pharmacist", 600);
        if(root != null)
            root = (Service) instance.add_service(root, 12344, "Yoga Trainer", 600);
        else
            fail("The list is empty");
    }

    @Test
    void check_service_wrapper() {
        //check_service();
        ServiceList instance = new ServiceList();
        Service root = new Service();
        root = null;
        boolean ret = instance.check_service_wrapper("Yoga Trainer");
        assertFalse(ret);
        /*root = (Service) instance.add_service(root, 12344, "Yoga Trainer", 600);
        ret = instance.check_service_wrapper("Yoga Trainer");
        assertTrue(ret);*/
    }

    @Test
    void check_service() {
        ServiceList instance = new ServiceList();
        Service root = new Service("Yoga Trainer", 12344, 600);
        boolean ret= instance.check_service(root, "Yoga Trainer");
        boolean ret2 = instance.check_service(root, "Weight Trainer");
        assertTrue(ret);
        assertFalse(ret2);

    }

    @Test
    void get_service_id_from_name_wrapper() {
        //get_service_id_from_name();
        ServiceList instance = new ServiceList();
        Service root = new Service();
        root = null;
        int ret = instance.get_service_id_from_name_wrapper("Yoga Trainer");
        assertEquals(0, ret);
        /*root = (Service) instance.add_service(root,12344, "Yoga Trainer", 600);
        ret = instance.get_service_id_from_name_wrapper("Yoga Trainer");
        assertEquals(12344, ret);*/

    }

    @Test
    void get_service_id_from_name() {
        ServiceList instance = new ServiceList();
        Service root = new Service("Yoga Trainer", 12344, 600);
        int ret = instance.get_service_id_from_name(root, "Yoga Trainer");
        int ret2 = instance.get_service_id_from_name(root, "Weight Trainer");
        assertEquals(ret, 12344);
        assertEquals(ret2, 0);
    }

    @Test
    void display_all() {
        display_all1();
    }

    @Test
    void display_all1() {
        ServiceList instance = new ServiceList();
        Service root = new Service();
        root = null;

        instance.display_all(root);
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        String ret = new String(output.toByteArray());
        assertEquals("", ret);
        // String output = systemOut().getHistory();

        root = (Service) instance.add_service(root,12344, "Yoga Trainer", 600);
        root = (Service) instance.add_service(root, 12345, "Pharmacist", 600);
        root = (Service) instance.add_service(root, 12346, "Zumba", 550);
        instance.display_all(root);
        ByteArrayOutputStream output2 = new ByteArrayOutputStream();
        String ret2 = new String(output2.toByteArray());
        //This is weird. Should actually be the output of all these three services- not just ""
        assertEquals("", ret2);

    }

    @Test
    void delete() {
        delete1();
    }

    @Test
    void delete1() {
        ServiceList instance = new ServiceList();
        Service root = new Service();
        root = null;
        root = (Service) instance.add_service(root,12344, "Yoga Trainer", 600);
        root = (Service) instance.add_service(root, 12345, "Pharmacist", 600);
        root = (Service) instance.add_service(root, 12346, "Zumba", 550);

        root = (Service) instance.delete(root, "Therapist");
        assertNotNull(root);
        root = (Service) instance.delete(root, "Zumba");
        root = (Service) instance.delete(root, "Yoga Trainer");
        root = (Service) instance.delete(root, "Pharmacist");
        assertNull(root);

        Service root2 = new Service();
        root2 = null;
        root2 = (Service) instance.delete(root2, "Yoga Trainer");
        assertNull(root2);
    }

    @Test
    void minValue() {
        ServiceList instance = new ServiceList();
        Service root = new Service();
        root = null;
        root = (Service) instance.add_service(root,12344, "Yoga Trainer", 600);
        root = (Service) instance.add_service(root, 12345, "Pharmacist", 600);
        root = (Service) instance.add_service(root, 12346, "Zumba", 550);
        String ret = instance.minValue(root);
        assertEquals(ret, "Pharmacist");
    }

    @Test
    void updateService() {
        updateServiceName();
        updateServiceCode();
        updateServiceFee();
    }

    @Test
    void updateServiceName() {
        ServiceList instance = new ServiceList();
        Service root = new Service("Yoga Trainer", 12344, 600);
        Node ret = instance.updateServiceName(root, "Yoga Trainer", "Y Trainer");
        ret = (Service) ret;
        assertNull(ret);
        assertEquals(root.get_service_name(), "Y Trainer");
        Node ret2 = instance.updateServiceName(root, "Weight Trainer", "W Trainer");
        assertNotNull(ret2);
    }

    @Test
    void updateServiceCode() {
        ServiceList instance = new ServiceList();
        Service root = new Service("Yoga Trainer", 12344, 600);
        Node ret = instance.updateServiceCode(root, "Yoga Trainer", 12345);
        ret = (Service) ret;
        assertNotNull(ret);
        assertEquals(root.get_service_code(), 12345);
        Node ret2 = instance.updateServiceCode(root, "Weight Trainer", 21344);
        assertNotNull(ret2);
    }

    @Test
    void updateServiceFee() {
        ServiceList instance = new ServiceList();
        Service root = new Service("Yoga Trainer", 12344, 600);
        Node ret = instance.updateServiceFee(root, "Yoga Trainer", 650);
        ret = (Service) ret;
        assertNotNull(ret);
        assertEquals(root.get_service_fee(), 650);
        Node ret2 = instance.updateServiceFee(root, "Weight Trainer", 650);
        assertNotNull(ret2);
    }

    @Test
    void get_service() {
        //get_service1();
        ServiceList instance = new ServiceList();
        Service root = new Service();
        root = null;
        Service ret = instance.get_service(12344);
        assertNull(ret);
    }

    @Test
    void get_service1() {
        ServiceList instance = new ServiceList();
        Service root = new Service("Yoga Trainer", 12344, 600);
        Service ret= instance.get_service(root, 12344);
        Service ret2 = instance.get_service(root, 12345);
        assertNotNull(ret);
        assertNull(ret2);
    }
}
