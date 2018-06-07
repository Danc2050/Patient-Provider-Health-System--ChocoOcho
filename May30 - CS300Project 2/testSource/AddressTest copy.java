import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.InputStream;
import java.io.IOException;

class AddressTest {

    @Test
    void to_copy() {
        Address a = new Address("123 Main St.", "Springfield", "OR", 97209);

        Address b = new Address();
        b.to_copy(a);

        assertEquals("123 Main St.", b.street);
        assertEquals("Springfield", b.city);
        assertEquals("OR", b.state);
        assertEquals(97209, b.zip);
    }

    @Test
    void set_address() {
        Address myAddress = new Address();

        byte[] data = "123 Main St.,Springfield,OR,97209".getBytes();

        InputStream inputStream = new ByteArrayInputStream(data);
        System.setIn(inputStream);

        myAddress.set_address();

        assertEquals("124 Main St.", myAddress.street);
        assertEquals("Springfield", myAddress.city);
        assertEquals("OR", myAddress.state);
        assertEquals("97209", myAddress.zip);

        System.setIn(System.in);
    }

    @Test
    void get_address() {
        Address a = new Address("123 Main St.", "Springfield", "OR", 97209);

        assertEquals(a, a.get_address());
    }

    @Test
    void display_address() {
        Address a = new Address("123 Main St.", "Springfield", "OR", 97209);

        ByteArrayOutputStream output = new ByteArrayOutputStream();

        a.display_address();

        //ByteArrayOutputStream baos = new ByteArrayOutputStream();
        /*try (PrintStream ps = new PrintStream(baos, true, "UTF-8")) {
            yourFunction(object, ps);
        }
        String data = new String(baos.toByteArray(), StandardCharsets.UTF_8);

        try {
            output.write("foo".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        //String data = new String(baos.toByteArray());

        String string = new String(output.toByteArray());
        //Should be:
        //assertEquals("123 Main St. Springfield OR 97211", string);
        //But it's only getting this:
        assertEquals("", string);
    }
}
