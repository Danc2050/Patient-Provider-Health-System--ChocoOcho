import java.io.*;

public class ProviderList extends Utility {
    protected Node p_root;
    protected int tId;

    public ProviderList() {
        this.p_root = null;
    }


    public int read_from_file() {
        int temp_id = 0;
        try {

            String filename = "May30 - CS300Project 2/ProviderList.txt";
            String working_directory = System.getProperty("user.dir");
            File file = new File(working_directory, filename);
            BufferedReader in = new BufferedReader(new FileReader(file));
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

                Address ad = new Address(temp_street, temp_city, temp_state, temp_zip);
                this.p_root = add_provider(this.p_root, temp_name, temp_id, ad, temp_service);
                line = in.readLine();
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("Provider file not found.");
        } catch (IOException ex) {
            System.out.println("Error reading provider file.");
        }
        tId = temp_id++;
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
        System.out.println("\nEnter zip");
        int zip = input.nextInt();
        input.nextLine();
        System.out.println("\nAdd a single service in order to be added to the system.)");
        String service = input.nextLine();
        Address ad = new Address(street, city, state, zip);

        this.p_root = add_provider(p_root, name, id, ad, service);
        return 1;
    }

    protected Node add_provider(Node p_root, String t_name, int t_id, Address ad, String t_service){
        if(p_root == null) {
            p_root = new Provider(t_name, t_id, ad, t_service);
            return p_root;
        }
        else {
            if (p_root.get_pname().compareToIgnoreCase(t_name) > 0)
                p_root.connect_left(add_provider(p_root.go_left(), t_name, t_id, ad, t_service));
            else
                p_root.connect_right(add_provider(p_root.go_right(), t_name, t_id, ad, t_service));
        }
        return p_root;
    }
    public void delete()
    {
        System.out.println("What is the name of the Provider you wish to remove from the system?");
        String to_delete = input.nextLine();

        this.p_root = delete(this.p_root, to_delete);
    }

    public Node delete(Node p_root, String name)
    {
        if (p_root == null)
        {
            return p_root;
        }

        if (p_root.get_pname().compareTo(name) > 0)
            p_root.connect_left(delete(p_root.go_left(), name));
        else if (p_root.get_pname().compareTo(name) < 0)
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
                p_root.set_p_name(minValue);
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
        return p_root.get_pname();
    }
    //Verifies if a manger is in the system using the ManagerList.txt file.
    public Boolean manager_Verification(){
    String file_name = "/Users/Angelic/IdeaProjects/June2Night/May30 - CS300Project 2/ManagerList.txt";
    System.out.println("\nEnter manager I.D. # to be verified: ");
    int manager_ID = input.nextInt();
    input.nextLine();
    int temp_id = 0;//Parsed int.
    Boolean stop = false;
        try {
        FileReader file = new FileReader(file_name);
        BufferedReader in = new BufferedReader(file);
        String line = in.readLine();
        while (stop == false && line != null) {
                temp_id = Integer.parseInt(line);
                if (temp_id == manager_ID)
                    stop = true;//Stop reading...we have a match.
                line = in.readLine();
        }
    } catch (FileNotFoundException e) {
        System.out.println("Managerlist file not found.");
    } catch (IOException ex) {
        System.out.println("Error managerlist reading file.");
    }
        return stop;
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

    /* Determines which piece of info the provider wants to edit */
    public void updateProviderInfo() {
        System.out.println("[1] - Update Provider Name." + "\n[2] - Update Provider ID" +
                "\n[3] - Update Provider Services" + "\n[4] - Update Provider Address.");
        int response = input.nextInt();
        input.nextLine();
        if (response == 1) {
            updateProviderName();
        } else if (response == 2) {
            System.out.println("What is the name of the provider you wish to edit?");
            String nameToFind = input.nextLine();
            System.out.println("What is their *NEW* ID");
            int newID = input.nextInt();
            updateProviderId(p_root, nameToFind, newID);
        } else if (response == 3) {
            System.out.println("What is the name of the provider you wish to edit?");
            String nameToFind = input.nextLine();
            System.out.println("What are their *NEW* services?");
            String newServices = input.nextLine();
            updateProviderServices(p_root, nameToFind, newServices);
        } else if (response == 4) {
            System.out.println("What is the name of the provider you wish to edit?");
            String nameToFind = input.nextLine();
            System.out.println("\nEnter *NEW* Street Address (25 Characters)");
            String street = input.nextLine();
            System.out.println("\nEnter *NEW* city");
            String city = input.nextLine();
            System.out.println("\nEnter *NEW* State)");
            String state = input.nextLine();
            System.out.println("\nEnter *NEW* zip");
            int zip = input.nextInt();
            Address toUpdate = new Address(street, city, state, zip);
            updateProviderAddress(p_root, nameToFind, toUpdate);
        }
    }

    public Node updateProviderId(Node root, String provider_name_to_find, int new_id) {
        if (root == null)
            return root;
        if (root.get_pname().compareToIgnoreCase(provider_name_to_find) > 0)
            root.connect_left(updateProviderId(root.go_left(), provider_name_to_find, new_id));
        else if (root.get_pname().compareToIgnoreCase(provider_name_to_find) < 0)
            root.connect_right(updateProviderId(root.go_right(), provider_name_to_find, new_id));
        else {
            System.out.println("Old provider id was: " + root.get_provider_id());
            root.set_provider_id(new_id);
            System.out.println("New provider id is: " + root.get_provider_id());
        }
        return root;
    }

    public Node updateProviderServices(Node root, String provider_name_to_find, String new_services) {
        if (root == null)
            return root;
        if (root.get_pname().compareToIgnoreCase(provider_name_to_find) > 0)
            root.connect_left(updateProviderServices(root.go_left(), provider_name_to_find, new_services));
        else if (root.get_pname().compareToIgnoreCase(provider_name_to_find) < 0)
            root.connect_right(updateProviderServices(root.go_right(), provider_name_to_find, new_services));
        else {
            System.out.println("Provider's name: " + root.get_pname());
            System.out.println("Old provider services was: " + root.get_provider_services());
            root.set_provider_services(new_services);
            System.out.println("New service is: " + root.get_provider_services());
        }
        return root;
    }

    public Node updateProviderAddress(Node root, String provider_name_to_find, Address new_address){
        if(root == null)
            return root;
        if(root.get_pname().compareToIgnoreCase(provider_name_to_find) > 0)
            root.connect_left(updateProviderAddress(root.go_left(), provider_name_to_find, new_address));
        else if(root.get_pname().compareToIgnoreCase(provider_name_to_find) < 0)
            root.connect_right(updateProviderAddress(root.go_right(), provider_name_to_find, new_address));
        else{
            System.out.println("Provider's new address is:\n");
            System.out.println(new_address.street + " " + new_address.city + " " + new_address.state + " " + new_address.zip + "\n");
            root.set_provider_address(new_address);
        }
        return root;
    }

    public int updateProviderName() {
        //display_all_wrapper();
        System.out.println("Enter the name of provider you wish to update: ");
        String to_find = input.nextLine();

        System.out.println("Enter new provider's name to replace: ");
        String to_replace = input.nextLine();

        System.out.println("Enter the provider's id you wish to update: ");
        int provider_id = input.nextInt();

        Node provider_to_change = new Provider();
        this.p_root = find_provider(p_root, to_find, to_replace, provider_id, provider_to_change);
        //System.out.println(m_root.get_pname() + " " + m_root.get_provider_id());
        //remove_provider_wrapper(to_find, provider_id);
        this.p_root = add_provider(p_root, to_replace, provider_to_change.get_provider_id(), provider_to_change.get_paddress(), provider_to_change.get_provider_services());
        display_all();
        return 0;
    }

    public Node find_provider(Node root, String provider_name_to_find, String new_provider_name, int provider_id, Node provider_to_find) {
        if (root == null)
            return root;
        if (root.get_pname().compareToIgnoreCase(provider_name_to_find) > 0) {
            root.connect_left(find_provider(root.go_left(), provider_name_to_find, new_provider_name, provider_id, provider_to_find));
        }
        else if(root.get_pname().compareToIgnoreCase(provider_name_to_find) < 0) {
            root.connect_right(find_provider(root.go_right(), provider_name_to_find, new_provider_name, provider_id, provider_to_find));
        }
        else {
            if (root.get_provider_id() == provider_id) {
                provider_to_find.set_provider_id(root.get_provider_id());
                provider_to_find.set_provider_services(root.get_provider_services());
                provider_to_find.set_provider_address(root.get_paddress());
                root.set_p_name(new_provider_name);
                root = delete(root, new_provider_name);
                return root;
            } else if (root.get_provider_id() != provider_id) {
                System.out.print("Name found but id does not match.\n");
                System.out.print("No change has been made.\n");
            }
        }
        return root;
    }
    
   //Checks to see if a provider is in the system (error checking).
    public String find_provider(int pid){
        return find_provider(this.p_root, pid);
    }
    protected String find_provider(Node p_root, int pid){
        if(p_root == null)
            return null;
        String name = null;
        if(p_root.get_pnum() == pid){
            name = p_root.get_pname();
            return name;
        }
        else {
            name = find_provider(p_root.go_left(), pid);
            if(name == null)
                name = find_provider(p_root.go_right(), pid);
        }
        return name;
    }

    public Provider get_provider(){
        System.out.print("What is the provider ID: ");
        int pnum = input.nextInt();
        return get_provider(this.p_root, pnum);
    }

    //Returns a provider so that we can write their information to file when a client is being processed.
    public Provider get_provider(Node root, int provider_id) {
        if (root == null) {
            return null;
        }
        if (root.get_pnum() == provider_id) {
            Provider obj = new Provider();
            obj.Name = root.get_pname();
            obj.p_address = root.get_paddress();
            obj.id = root.get_pnum();
            obj.Service = root.get_service_name();
            return obj;
        }
        else if (root.get_pnum() > provider_id) {
            return get_provider(root.go_left(), provider_id);
        }
        else if(root.get_pnum() < provider_id) {
            return get_provider(root.go_right(), provider_id);
        }
        /*else {
            if (root.get_provider_id() == provider_id) {
                return root;
            } else if (root.get_pnum() != provider_id) {
                System.out.print("Person not found.\n");
            }
        }*/
        return null;
    }

    public void get_ids(int [] plist, int i){
        if(p_root == null)
            return;
        get_ids(this.p_root, plist, i);
    }
    public int get_ids(Node p_root, int [] plist, int i){
        if(p_root == null)
            return i;
        i = get_ids(p_root.go_left(), plist, i);
        plist[i++] = p_root.get_pnum();
        i = get_ids(p_root.go_right(), plist, i);
        return i;
    }

}
