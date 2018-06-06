import java.io.*;

public class MemberList extends Utility {

    protected Node m_root; //Root of BST containing members
    protected int m_id; //Stores member ID to give next member next

    /* Copy constructor to initialize root to null */
    public MemberList() {
        this.m_root = null;
    }

    /* Prompts user for user's name, ID number, and new name
       that will replace the current name.
     */
    public int updateMemberName() {

        System.out.println("Enter the name of member you wish to update: ");
        String to_find = input.nextLine();

        System.out.println("Enter new member's name to replace: ");
        String to_replace = input.nextLine();

        System.out.println("Enter the member's id you wish to update: ");
        int member_id = input.nextInt();

        Node member_to_change = new Member();
        this.m_root = find_member(m_root, to_find, to_replace, member_id, member_to_change);
        add_member(m_root, member_to_change.get_member_id(), member_to_change.get_status(),
                to_replace, member_to_change.get_address());
        display_all_wrapper();
        return 0;
    }

    /* Searches the tree of members for a name matching the value
       passed in and once the match is found, the member's object is returned
     */
    public Node find_member(Node root, String member_name_to_find, String new_member_name, int member_id, Node member_to_find) {
        /* Base Case: Root is null */
        if (root == null)
            return root;
        /* Traverse Left: name passed in < root's name */
        if (root.get_member_name().compareToIgnoreCase(member_name_to_find) > 0) {
            root.connect_left(find_member(root.go_left(), member_name_to_find, new_member_name, member_id, member_to_find));
        }
        /* Traverse Right: name passed in < root's name */
        else if(root.get_member_name().compareToIgnoreCase(member_name_to_find) < 0) {
            root.connect_right(find_member(root.go_right(), member_name_to_find, new_member_name, member_id, member_to_find));
        }
        else {
            /* Traverse the tree until finding the matching name
               then perform another check to verify that the name AND
               ID number match. Return this member to the calling routine
             */
            if (root.get_member_id() == member_id) {
                member_to_find.set_member_id(root.get_member_id());
                member_to_find.set_member_status(root.get_status());
                member_to_find.set_member_address(root.get_address());
                root.set_member_name(new_member_name);
                root = remove_member(root, new_member_name, member_id);
                return root;
            } else if (root.get_member_id() != member_id){
                root.connect_left(find_member(root.go_left(), member_name_to_find, new_member_name, member_id, member_to_find));
                root.connect_right(find_member(root.go_right(), member_name_to_find, new_member_name, member_id, member_to_find));
            } else {
                System.out.print("Name found but id does not match.\n");
                System.out.print("No change has been made.\n");
            }
        }
        return root;
    }

    /* Prompts user for member's name, their ID, and the new ID */
    public int updateMemberId_wrapper()
    {
        System.out.println("Enter member name to change id: ");
        String to_find = input.nextLine();
        System.out.println("Enter current id: ");
        int current_id = input.nextInt();
        int new_id = 0;
        do{
            System.out.println("Enter new member ID: ");
            new_id = input.nextInt();
            if(new_id <= 123456799 || new_id >= m_id)
                System.out.println("Member ID entered is or has already existed in the system! Choose a different ID.");
        } while(new_id <= 123456799 && new_id >= m_id);
        this.m_root = updateMemberId(m_root, to_find, new_id, current_id);
        display_all_wrapper();
        return 0;
    }

    /* Given the parameters from the wrapper, this function searches
       the tree of members by name and once finding the name that matches
       the value passed in, the function will change the ID of the member
       to the value passed in.
     */
    protected Node updateMemberId(Node root, String member_name_to_find, int new_id, int current_id) {
        /* Base Case: Root is null */
        if (root == null)
            return root;
        /* Traverse Left: name passed in < root's name */
        if (root.get_member_name().compareToIgnoreCase(member_name_to_find) > 0)
            root.connect_left(updateMemberId(root.go_left(), member_name_to_find, new_id, current_id));
            /* Traverse Right: name passed in > root's name */
        else if (root.get_member_name().compareToIgnoreCase(member_name_to_find) < 0)
            root.connect_right(updateMemberId(root.go_right(), member_name_to_find, new_id, current_id));
            /* Traverse until name and ID match and then update the member's ID */
        else {
            if(root.get_member_id() == current_id) {
                System.out.println("Old member id was: " + root.get_member_id());
                root.set_member_id(new_id);
                System.out.println("New member id is: " + root.get_member_id());
            }
            else if(root.get_member_id() != current_id) {
                root.connect_left(updateMemberId(root.go_left(), member_name_to_find, new_id, current_id));
                root.connect_right(updateMemberId(root.go_right(), member_name_to_find, new_id, current_id));
            }
            else {
                System.out.println("No members have been found");
                System.out.println("No changes have been made");
            }
        }
        return root;
    }

    /* Prompts user for which piece of member information the user
       wants to update and calls the respective wrapper function.
     */
    public void updateMemberInfo() {
        System.out.println("[1] - Update Member Name." + "\n[2] - Update Member ID" +
                "\n[3] - Update Member Services" + "\n[4] - Update Member Address.");
        int response = input.nextInt();
        input.nextLine();
        if (response == 1) {
            updateMemberName();
        } else if (response == 2) {
            updateMemberId_wrapper();
        } else if (response == 3) {
            updateMemberStatus_wrapper();
        } else if (response == 4) {
            updateMemberAddress_wrapper();
        }
    }

    /* Prompts the user for the members name and the new status of the member */
    public int updateMemberStatus_wrapper()
    {
        System.out.println("Enter member name to change status: ");
        String to_find = input.nextLine();
        System.out.println("Enter new member status: ");
        String new_status = input.nextLine();
        this.m_root = updateMemberStatus(m_root, to_find, new_status);
        display_all_wrapper();
        return 1;
    }

    /* Searches the tree of members until finding the name that matches
       the value passed in and changes the status of the member
       to the new value being passed as new_status.
     */
    protected Node updateMemberStatus(Node root, String member_name_to_find, String new_status) {
        if (root == null)
            return root;
        if (root.get_member_name().compareToIgnoreCase(member_name_to_find) > 0)
            root.connect_left(updateMemberStatus(root.go_left(), member_name_to_find, new_status));
        else if (root.get_member_name().compareToIgnoreCase(member_name_to_find) < 0)
            root.connect_right(updateMemberStatus(root.go_right(), member_name_to_find, new_status));
        else {
            System.out.println("Member's name: " + root.get_member_name());
            System.out.println("Old member status was: " + root.get_status());
            root.set_member_status(new_status);
            System.out.println("New status is: " + root.get_status());
        }
        return root;
    }

    /* Prompts the user for which piece of information that needs to be updated */
    public int updateMemberAddress_wrapper()
    {
        System.out.println("Enter member name to change address: ");
        String to_find = input.nextLine();
        System.out.println("Press 1 to update street");
        System.out.println("Press 2 to update city");
        System.out.println("Press 3 to update state");
        System.out.println("Press 4 to update zip");
        System.out.println("Press 5 to update everything");

        int response = input.nextInt();
        input.nextLine();
        Address new_address = new Address();
        /* Updates the Street Address */
        if(response == 1)
        {
            System.out.println("Enter new street: ");
            String new_street = input.nextLine();
            new_address.street = new_street;
            this.m_root = updateMemberAddress(m_root, to_find, new_address);
            display_all_wrapper();
            return 0;
        }
        /* Updates the City */
        if(response == 2)
        {
            System.out.println("Enter new city: ");
            String new_city = input.nextLine();
            new_address.city = new_city;
            this.m_root = updateMemberAddress(m_root, to_find, new_address);
            display_all_wrapper();
            return 0;
        }
        /* Updates the State */
        if(response == 3)
        {
            System.out.println("Enter new state: ");
            String new_state = input.nextLine();
            new_address.state = new_state;
            this.m_root = updateMemberAddress(m_root, to_find, new_address);
            display_all_wrapper();
            return 0;
        }
        /* Updates the Zip Code */
        if(response == 4)
        {
            System.out.println("Enter new zip: ");
            int new_zip = input.nextInt();
            new_address.zip = new_zip;
            this.m_root = updateMemberAddress(m_root, to_find, new_address);
            display_all_wrapper();
            return 0;
        }
        /* Updates the entire Address */
        if(response == 5)
        {
            System.out.println("Enter new street: ");
            String new_street = input.nextLine();
            System.out.println("Enter new city: ");
            String new_city = input.nextLine();
            System.out.println("Enter new state: ");
            String new_state = input.nextLine();
            input.nextLine();
            System.out.println("Enter new zip: ");
            int new_zip = input.nextInt();
            new_address.street = new_street;
            new_address.city = new_city;
            new_address.state = new_state;
            new_address.zip = new_zip;
            this.m_root = updateMemberAddress(m_root, to_find, new_address);
            display_all_wrapper();
        }
        return 0;
    }

    /* Searches for the name matching the value passed in and updates
       the address piece passed in
     */
    protected Node updateMemberAddress(Node root, String member_name_to_find, Address new_address){
        if(root == null)
            return root;
        if(root.get_member_name().compareToIgnoreCase(member_name_to_find) > 0)
            root.connect_left(updateMemberAddress(root.go_left(), member_name_to_find, new_address));
        else if(root.get_member_name().compareToIgnoreCase(member_name_to_find) < 0)
            root.connect_right(updateMemberAddress(root.go_right(), member_name_to_find, new_address));
        else{
            System.out.println("Member's new address is:\n");
            if(new_address.street != null)
                root.get_address().street = new_address.street;
            if(new_address.city != null)
                root.get_address().city = new_address.city;
            if(new_address.state != null)
                root.get_address().state = new_address.state;
            if(new_address.zip != 0)
                root.get_address().zip = new_address.zip;
        }
        return root;
    }

    /* Reads all the information pertaining to members into a BST
       of member sorted in alphabetical order.
     */
    public int read_from_file() {
        int temp_id = 0;
        try {

            /* Creates relative file path for the Member List */
            String filename = "May30 - CS300Project 2/MemberList.txt";
            String working_directory = System.getProperty("user.dir");
            File file = new File(working_directory, filename);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line = in.readLine();

            /* Reads in from file until the end of file has been reached */
            while (line != null) {
                String[] columns = line.split(";");
                temp_id = Integer.parseInt(columns[0]);
                String temp_status = columns[1];
                String temp_name = columns[2];
                String temp_street = columns[3];
                String temp_city = columns[4];
                String temp_state = columns[5];
                int temp_zip = Integer.parseInt(columns[6]);
                Address temp_address = new Address(temp_street, temp_city, temp_state, temp_zip);
                this.m_root = import_member_list(this.m_root, temp_id, temp_status, temp_name, temp_address);
                line = in.readLine();
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("Member file not found.");
        } catch (IOException ex) {
            System.out.println("Error reading memberlist file.");
        }
        m_id = --temp_id;
        return 0;
    }

    /* Prompts user for necessary information to add a new member
       into the system. Additionally, it generates them the next
       available ID number and sets their account status to 'Active'
     */
    public int add_member_wrapper() {
        System.out.println("\nEnter a name: ");
        String name = input.nextLine();
        System.out.println("\nMember ID generated.");
        int id = this.m_id--;
        String status = "Active";
        Address address = new Address();
        address = address.set_address();
        this.m_root = add_member(m_root, id, status, name, address);
        return 1;
    }

    /* BST Insert function traverses the list by alphabetical order
       until finding the location where the new member will be
       inserted and performs the insert.
     */
    public Node add_member(Node root, int m_id, String m_status, String m_name, Address m_address) {
        if(root == null)
        {
            /* Create new member object and set the data */
            root = new Member();
            root.set_member_name(m_name);
            root.set_member_id(m_id);
            root.set_member_status(m_status);
            root.set_member_address(m_address);
            return root;
        }
        else {
            if(root.get_member_name().compareToIgnoreCase(m_name) > 0) {
                root.connect_left(add_member(root.go_left(), m_id, m_status, m_name, m_address));
            } else
                root.connect_right(add_member(root.go_right(), m_id, m_status, m_name, m_address));
        }
        return root;
    }

    /* Wrapper function to check if a name matches the one passed in */
    public int check_name_wrapper(String member_name) {
        return check_name(m_root, member_name);
    }

    /* Traverses the tree checking to see if the name passed in
       is found in the tree and returns '1' for success and '0' for failure.
     */
    protected int check_name(Node root, String member_name) {
        if (root == null)
            return 0;
        if (root.get_member_name().compareToIgnoreCase(member_name) < 0)
            return check_name(root.go_left(), member_name);
        else if (root.get_member_name().compareToIgnoreCase(member_name) > 0)
            return check_name(root.go_right(), member_name);
        else
            return 1;
    }

    /* Wrapper for checking if an ID is found */
    public int check_id_wrapper(int member_id) {
        if (m_root == null)
            return 0;
        int[] check_value = new int[1];
        check_value[0] = -1;
        int return_value = check_id(m_root, member_id, check_value);
        if (check_value[0] == 1)
            return check_value[0];
        return return_value;
    }

    /* Traverses the tree searching for a node that matches the
       ID of the member passed in. If the ID is found it will
       return '1' for success and '0' for failure.
     */
    protected int check_id(Node root, int member_id, int[] check_value) {
        if (root == null)
            return 0;
        if (root.get_member_id() == member_id)
            check_value[0] = 1;
        int return_value = check_id(root.go_left(), member_id, check_value);
        return_value = check_id(root.go_right(), member_id, check_value);
        return return_value;
    }

    /* Wrapper function that creates the file and writer object
       in a try block. If the case passes it will call the write to
       file function, otherwise it will print the stack trace.
     */
    public int write_to_file() {
        try{
            String filename = "May30 - CS300Project 2/MemberList.txt";
            String working_directory = System.getProperty("user.dir");
            File file = new File(working_directory, filename);
            FileWriter writer = new FileWriter(file);
            this.write_to_file(m_root, writer);
            writer.close();
        }
        catch(IOException exception){
            exception.printStackTrace();
        }
        return 1;
    }

    /* Traverses the list of members in alphabtetical order
       and writes the information out to the MemberList text file.
     */
    protected int write_to_file(Node root, FileWriter file)
    {
        if(root == null)
            return 1;
        write_to_file(root.go_left(), file); /* Traverses Left */

        /* Writes all the information into a single line */
        try{
            file.write(root.get_member_id() + ";");
            file.write(root.get_status() + ";");
            file.write(root.get_member_name() + ";");
            Address temp_address = new Address();
            temp_address = root.get_address();
            file.write(temp_address.street + ";");
            file.write(temp_address.city + ";");
            file.write(temp_address.state + ";");
            file.write(temp_address.zip + ";");
            file.write("\n");
        }
        catch (IOException exception){
            exception.printStackTrace();
        }
        write_to_file(root.go_right(), file); /* Traverses Right */
        return 1;
    }

    /* Wrapper function to remove a member from the list */
    public void remove_member_wrapper(String m_name, int m_id) {
        if (m_root == null)
            return;
        this.m_root = remove_member(this.m_root, m_name, m_id);
    }

    /* Searches for the member's name passed in and verifies that
       the ID matches the correct member and then performs the delete
     */
    protected Node remove_member(Node root, String name, int id) {
        /* Base Case: Deleted node is a leaf */
        if (root == null)
            return root;
        /* Left Only Child: Deleted node has a single child */
        if (root.get_member_name().compareToIgnoreCase(name) > 0) {
            root.connect_left(remove_member(root.go_left(), name, id));
        }
        /* Right Only Child: Deleted node has a single child */
        else if (root.get_member_name().compareToIgnoreCase(name) < 0) {
            root.connect_right(remove_member(root.go_right(), name, id));
        }
        /* Find the In Order Successor: Finds the IOS
           and copies the data from that node into the current
           value and deletes the name matching the value passed in.
         */
        else {
            if (root.get_member_id() == id) {
                if (root.go_left() == null && root.go_right() == null) {
                    return null;
                } else if (root.go_left() == null) {
                    return root.go_right();
                } else if (root.go_right() == null) {
                    return root.go_left();
                } else {
                    int[] inorder_id = new int[1];
                    inorder_id[0] = 0;
                    Node inorder_node = new Member();
                    String inorder = find_inorder(root.go_right(), inorder_id, inorder_node);
                    root.set_member_name(inorder);
                    root.set_member_address(inorder_node.get_address());
                    root.set_member_status(inorder_node.get_status());
                    root.set_member_id(inorder_node.get_member_id());
                    root.connect_right(remove_member(root.go_right(), inorder, inorder_id[0]));
                }
            }
        }
        return root;
    }

    /* BST function to find the IOS and set the data before returning */
    protected String find_inorder(Node root, int [] inorder_id, Node inorder_node)
    {
        if(root.go_left() != null)
            return find_inorder(root.go_left(), inorder_id, inorder_node);
        inorder_node.set_member_name(root.get_member_name());
        inorder_node.set_member_id(root.get_member_id());
        inorder_node.set_member_status(root.get_status());
        inorder_node.set_member_address(root.get_address());
        inorder_id[0] = root.get_member_id();
        return root.get_member_name();
    }

    /* Wrapper for validating member */
    public int validate_member_wrapper ( int member_id){
        int [] validate_value = new int[1];
        validate_value[0] = -2;
        int return_value = validate_member(this.m_root, member_id, validate_value);

        if(return_value == -1 && validate_value[0] == -2)
            validate_value[0] = -1; //Member doesn't exist in list
        return validate_value[0];
    }

    /* Display function wrapper */
    public void display_all_wrapper() {
        display_all(m_root);
    }

    /* Displays all the members in alphabetical order */
    protected void display_all(Node root) {
        if (root == null)
            return;

        display_all(root.go_left());
        root.DisplayAll();
        display_all(root.go_right());
    }

    /* Searches the tree of members comparing the id of each member
       to the one passed in, and if one is found, it performs a check to see
       if that member is 'Active' or 'Suspended'
     */
    protected int validate_member(Node root,int member_id, int [] validate_value) {
        if (root == null)
            return -1;

        int return_value = validate_member(root.go_left(), member_id, validate_value);
        if (root.get_member_id() == member_id) {
            if(root.get_status().compareToIgnoreCase("Active") == 0)
                validate_value[0] = 1;
            else
                validate_value[0] = 0;
        }
        return_value = validate_member(root.go_right(), member_id, validate_value);
        return return_value;
    }

    /* Recursive Insert function called when reading in the members from a text file */
    protected Node import_member_list(Node root, int m_id, String m_status, String m_name, Address m_address)
    {
        if(root == null)
        {
            root = new Member(m_id, m_status, m_name, m_address);
            return root;
        }
        else {
            if(root.get_member_name().compareToIgnoreCase(m_name) > 0)
                root.connect_left(import_member_list(root.go_left(), m_id, m_status, m_name, m_address));
            else
                root.connect_right(import_member_list(root.go_right(), m_id, m_status, m_name, m_address));
        }
        return root;
    }

    /* Wrapper function for get_member() */
    public Member get_member(){
        Member obj = null;
        do {
            System.out.print("Enter the member name: ");
            String mnum = input.nextLine();
            obj = get_member(this.m_root, mnum);
            if (obj == null)
                System.out.println("\nMember not found.");
        }while(obj == null);
        return obj;
    }

    /* Returns a member so that we can write their information to file when a client is being processed. */
    public Member get_member(Node root, String mname) {
        if (root == null) {
            return null;
        }
        if (mname.compareToIgnoreCase(root.get_member_name()) == 0) {
            Member obj = new Member();
            obj.Name = root.get_member_name();
            obj.m_address = root.get_maddress();
            obj.id = root.get_member_id();
            obj.m_status = root.get_status();
            return obj;

        }
        else if (mname.compareToIgnoreCase(root.get_member_name()) < 0) {
            return get_member(root.go_left(), mname);
        }
        else if (mname.compareToIgnoreCase(root.get_member_name()) > 0) {
            return get_member(root.go_right(), mname);
        }
        return null;
    }

    /* Wrapper function for find_member() */
    public String find_member(int mid){
        return find_member(this.m_root, mid);
    }

    /* Searches the tree of members for the ID passed in
       and returns the name of that member.
     */
    protected String find_member(Node m_root, int mid){
        if(m_root == null)
            return null;
        String name = null;
        if(m_root.get_member_id() == mid){
            name = m_root.get_mname();
            return name;
        }
        else {
            name = find_member(m_root.go_left(), mid);
            if(name == null)
                name = find_member(m_root.go_right(), mid);
        }
        return name;
    }
}
