import java.io.*;

public class ProviderList extends Utility {

    protected Node p_root; /* Root of Provider Tree */
    protected int tId; /* Stores ID number of next available ID */

    /* Copy Constructor initializes the root to null */
    public ProviderList() { this.p_root = null; }


    /* Reads all the contents of the ProviderList text file into the BST structure */
    public int read_from_file() {
        int temp_id = 0;
        try {
            /* Creates the file path for the ProviderList text file */
            String filename = "May30 - CS300Project 2/ProviderList.txt";
            String working_directory = System.getProperty("user.dir");
            File file = new File(working_directory, filename);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line = in.readLine();

            /* Reads up until the end of the file has been reached */
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

                /* Calls the insert function on each provider read in */
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

    /* Attempts to open the text file and if opened
       writes out all the information in the BST of providers
       out to the text file in alphabetical order.
     */
    public int write_to_file()
    {
        try {
            String filename = "May30 - CS300Project 2/ProviderList.txt";
            String working_directory = System.getProperty("user.dir");
            File file = new File(working_directory, filename);
            FileWriter writer = new FileWriter(file);
            this.write_to_file(p_root, writer);
            writer.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return 1;
    }

    /* Traverses the tree of providers writing out their information
       to the text file delimited by the ';' character.
     */
    public int write_to_file(Node s_root, FileWriter file)
    {
        if (s_root == null)
            return 1;

        /* Traverses Left */
        write_to_file(s_root.go_left(), file);

        /* Writes provider information onto a single line */
        try {
            file.write(s_root.get_pnum() + ";");
            file.write(s_root.get_pname() + ";");
            file.write(s_root.get_paddress() + ";");
            file.write(s_root.get_provider_services() + ";");
            file.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        /* Traverses Right */
        write_to_file(s_root.go_right(), file);
        return 1;
    }

    /* Prompts the user for information required to add a new
       provider and calls the insert function.
     */
    public int add_provider() // wrapper
    {
        //TODO for Phuong. Verify type of service with Service List before adding.
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

    /* Traverses the tree until finding the correct position to add
       the new provider based on alphabetical ordering.
     */
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

    /* Prompts the user what the name of the provider that
       is to be deleted and calls the delete function.
     */
    public void delete()
    {
        System.out.println("What is the name of the Provider you wish to remove from the system?");
        String to_delete = input.nextLine();

        this.p_root = delete(this.p_root, to_delete);
    }

    /* Deletes a provider based on the name passed in and considers
       the 4 cases of deletion:
           1) Leaf
           2) Left Child
           3) Right Child
           4) Find IOS
     */
    public Node delete(Node p_root, String name)
    {
        /* Deleted Node is a leaf */
        if (p_root == null)
        {
            return p_root;
        }

        /* Deleted Node has only left child */
        if (p_root.get_pname().compareTo(name) > 0)
            p_root.connect_left(delete(p_root.go_left(), name));
        /* Deleted Node has only right child */
        else if (p_root.get_pname().compareTo(name) < 0)
            p_root.connect_right(delete(p_root.go_right(), name));
        /* Deleted Node requires IOS to be found */
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
                String findIOS = findIOS(p_root.go_right());
                p_root.set_p_name(findIOS);
                p_root.connect_right(delete(p_root.go_right(), findIOS));
                System.out.println("Deleting " + name);
            }
        }
        return p_root;
    }

    /* Finds the location of the IOS and returns the name of that node */
    protected String findIOS(Node p_root)
    {
        if (p_root.go_left() != null)
        {
            return findIOS(p_root.go_left());
        }
        return p_root.get_pname();
    }

    /* Searches the text file with the value passed in performing a
       check to see that the manger's ID is in fact a valid one.
       Function will return true if the value is found and false if not.
     */
    public Boolean manager_Verification(){
    System.out.println("\nEnter manager I.D. # to be verified: ");
    int manager_ID = input.nextInt();
    input.nextLine();
    int temp_id = 0;//Parsed int.
    Boolean stop = false;
        try {
        String filename = "May30 - CS300Project 2/ManagerList.txt";
        String working_directory = System.getProperty("user.dir");
        File file = new File(working_directory, filename);
        BufferedReader in = new BufferedReader(new FileReader(file));
        /*FileReader file = new FileReader(file_name);
        BufferedReader in = new BufferedReader(file);*/
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

    /* Searches the text file of providers looking for an ID
       matching the one that is passed in. If the value is found
       the function will return true and if not it will return false
       prompting the user to either try again or exit.
     */
    public boolean provider_Verification()
    {
        int provider_id, temp_id;
        boolean stop = false;

        System.out.println("\nEnter Provider ID to be verified: ");
        provider_id = input.nextInt();
        input.nextLine();

        /* Opens the file and reads the provider IDs into a temporary
           and then checks to see if the ID matches one that is read in.
         */
        try
        {
            String filename = "May30 - CS300Project 2/ProviderID.txt";
            String working_directory = System.getProperty("user.dir");
            File file = new File (working_directory, filename);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line = in.readLine();

            while (!stop && line != null)
            {
                temp_id = Integer.parseInt(line);
                if (temp_id == provider_id)
                    stop = true;
                line = in.readLine();
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("\nProvider ID file not found.");
        }
        catch (IOException ex)
        {
            System.out.println("\nError reading Provider ID file.");
        }
        return stop;
    }

    /* Wrapper function for display all */
    public void display_all(){
        display_all(this.p_root);
    }

    /* Displays list of providers in alphabetical order */
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
        /* Updates the name of a provider */
        if (response == 1) {
            updateProviderName();
        /* Updates the ID of the provider */
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

    /* Searches the tree of providers until finding a name matching the
       one that is passed in and once finding it, it will set the ID
       of that provider to the new one passed in.
     */
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

    /* Searches the tree of providers until finding a name matching
       the one passed in and once the name has been found it sets
       the provider's services equal to the one passed in.
     */
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

    /* Searches the tree of providers until finding a name matching
       the one passed in and once the name has been found it sets
       the address of the provider equal to the new one passed in.
     */
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

    /* Prompts the user for the name of the provider they wish to update
       then prompts for their id along with the name they wish to replace
       the current on with. The function then calls the find provider
       function to find the IOS, copy the data, delete the node and
       re-insert the provider with the updated name.
     */
    public int updateProviderName() {
        System.out.println("Enter the name of provider you wish to update: ");
        String to_find = input.nextLine();

        System.out.println("Enter new provider's name to replace: ");
        String to_replace = input.nextLine();

        System.out.println("Enter the provider's id you wish to update: ");
        int provider_id = input.nextInt();

        Node provider_to_change = new Provider();
        this.p_root = find_provider(p_root, to_find, to_replace, provider_id, provider_to_change);
        this.p_root = add_provider(p_root, to_replace, provider_to_change.get_provider_id(), provider_to_change.get_paddress(), provider_to_change.get_provider_services());
        display_all();
        return 0;
    }

    /* Finds the IOS and calls setters to update the data fields
       of the node that we need to preserve before deletion.
     */
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
            /* Sets all the data fields before deleting to save the values */
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

    /* Wrapper for checking to see if a provider is in the system */
    public String find_provider(int pid){
        return find_provider(this.p_root, pid);
    }

    /* Searches the tree of providers given their ID and once
       they have been found, it returns that provider's name.
     */
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

    /* Prompts the user for the ID of a provider and
       calls the function to find that provider, ultimately
       returns the object of that provider.
     */
    public Provider get_provider(){
        Provider obj = null;
        do {
            System.out.print("Enter the provider name: ");
            String pname = input.nextLine();
            obj = get_provider(this.p_root, pname);
            if (obj == null)
                System.out.println("\nNo provider in system...");
        }while(obj == null);
        return obj;
    }

    /* Returns a Provider object so that their information can be
       written to a text file and stored for future reports.
     */
    public Provider get_provider(Node root, String pname) {
        if (root == null) {
            return null;
        }
        if (pname.compareToIgnoreCase(root.get_pname()) == 0) {
            Provider obj = new Provider();
            obj.Name = root.get_pname();
            obj.p_address = root.get_paddress();
            obj.id = root.get_pnum();
            obj.Service = root.get_service_name();
            return obj;
        }
        else if (pname.compareToIgnoreCase(root.get_pname()) < 0) {
            return get_provider(root.go_left(), pname);
        }
        else if (pname.compareToIgnoreCase(root.get_pname()) > 0) {
            return get_provider(root.go_right(), pname);
        }
        return null;
    }

    /* Wrapper function for getting a provider ID number */
    public void get_ids(int [] plist, int i){
        if(p_root == null)
            return;
        get_ids(this.p_root, plist, i);
    }

    /* Searches the tree of providers, filling an array of intergers with
       all the IDs of providers in the current tree.
     */
    public int get_ids(Node p_root, int [] plist, int i){
        if(p_root == null)
            return i;
        i = get_ids(p_root.go_left(), plist, i);
        plist[i++] = p_root.get_pnum();
        i = get_ids(p_root.go_right(), plist, i);
        return i;
    }
}
