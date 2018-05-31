import java.io.*;

public class ProviderList extends Utility {
    protected Node p_root;
    protected int tId;

    public ProviderList() {
        this.p_root = null;
    }

    public int read_from_file() {
        String file_name = "/Users/thang3tron/IdeaProjects/ChocoOcho/May30 - CS300Project 2/src/ProviderList.txt";
        int temp_id = 0;
        try {

            FileReader file = new FileReader(file_name);
            BufferedReader in = new BufferedReader(file);

            String line = in.readLine();

            while (line != null) {
                String[] columns = line.split(";");
                temp_id = Integer.parseInt(columns[0]);
                String temp_name = columns[1];
                String temp_street = columns[2];
                String temp_city = columns[3];
                String temp_state = columns[4];
                int temp_zip = Integer.parseInt(columns[5]);
                String temp_service = columns[6];
                float temp_week_fee = Float.parseFloat(columns[7]);
                int temp_num_consultations = Integer.parseInt(columns[8]);

                Address ad = new Address(temp_street, temp_city, temp_state, temp_zip);
                this.p_root = add_provider(this.p_root, temp_name, temp_id, ad, temp_service, temp_week_fee, temp_num_consultations);
                line = in.readLine();
            }

        } catch (FileNotFoundException e) {
            System.out.println("Provider file not found.");
        } catch (IOException ex) {
            System.out.println("Error reading file.");
        }
        return 1;
    }

    public int write_to_file()
    {
        try {
            FileWriter writer = new FileWriter("ProviderList.txt");
            this.write_to_file(p_root, writer);
            writer.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return 1;
    }

    public int write_to_file(Node s_root, FileWriter file)
    {
        if (s_root == null)
            return 1;

        write_to_file(s_root.go_left(), file);
        try {
            file.write(s_root.get_service_code() + ";");
            file.write(s_root.get_service_name() + ";");
            file.write(s_root.get_service_fee() + ";");
            file.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        write_to_file(s_root.go_right(), file);
        return 1;
    }

    public int add_provider() // wrapper
    {
        System.out.println("\nEnter name.");
        String name = input.nextLine();
        System.out.println("\nI.D. number being generated.");
        int id = ++this.tId;
        System.out.println("\nEnter Street Address (25 Characters)");
        String street = input.nextLine();
        System.out.println("\nEnter city");
        String city = input.nextLine();
        System.out.println("\nEnter State)");
        String state = input.nextLine();
        System.out.println("\nEnter zip)");
        int zip = input.nextInt();
        input.nextLine();
        System.out.println("\nAdd a single service in order to be added to the system.)");
        String service = input.nextLine();
        Address ad = new Address(street, city, state, zip);

        this.p_root = add_provider(p_root, name, id, ad, service, 0, 0);
        return 1;
    }

    protected Node add_provider(Node p_root, String t_name, int t_id, Address ad, String t_service, float t_week_fee, int t_num_consultations){
        if(p_root == null) {
            p_root = new Provider(t_name, t_id, ad, t_service, t_week_fee, t_num_consultations);
            return p_root;
        }
        else {
            if (p_root.get_pname().compareToIgnoreCase(t_name) < 1)
                p_root.connect_left(add_provider(p_root.go_left(), t_name, t_id, ad, t_service, t_week_fee, t_num_consultations));
            else
                p_root.connect_right(add_provider(p_root.go_right(), t_name, t_id, ad, t_service, t_week_fee, t_num_consultations));
        }
        return p_root;
    }
    public void delete()
    {
        System.out.println("What is the name of the member you wish to remove from the system?");
        String to_delete = input.nextLine();

        this.p_root = delete(this.p_root, to_delete);
    }

    public Node delete(Node p_root, String name)
    {
        if (p_root == null)
        {
            return p_root;
        }

        if (p_root.get_mname().compareTo(name) > 0)
            p_root.connect_left(delete(p_root.go_left(), name));
        else if (p_root.get_mname().compareTo(name) < 0)
            p_root.connect_right(delete(p_root.go_right(), name));
        else
        {
            if (p_root.go_left() == null && p_root.go_right() == null)
            {
                return null;
            } else if (p_root.go_left() == null)
            {
                System.out.println("Deleting " + name);
                return p_root.go_right();
            }
            else if (p_root.go_right() == null)
            {
                System.out.println("Deleting " + name);
                return p_root.go_left();
            }
            else
            {
                String minValue = minValue(p_root.go_right());
                p_root.set_m_name(minValue);
                p_root.connect_right(delete(p_root.go_right(), minValue));
                System.out.println("Deleting " + name);
            }
        }
        return p_root;
    }

    protected String minValue(Node p_root)
    {
        if (p_root.go_left() != null)
        {
            return minValue(p_root.go_left());
        }
        return p_root.get_mname();
    }


    public void display_all(){
        display_all(this.p_root);
    }
    protected void display_all(Node p_root){
        if(p_root == null)
            return;
        display_all(p_root.go_left());
        p_root.DisplayAll();
        display_all(p_root.go_right());
    }
}
