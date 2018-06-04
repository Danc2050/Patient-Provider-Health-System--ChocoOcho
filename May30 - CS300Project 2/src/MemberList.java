import java.io.*;

public class MemberList extends Utility {
    protected Node m_root;
    protected int m_id;



    public MemberList() {
        this.m_root = null;
    }

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

    //Find member and retrieve the information of that member into another object then delete that member
    public Node find_member(Node root, String member_name_to_find, String new_member_name, int member_id, Node member_to_find) {
        if (root == null)
            return root;
        if (root.get_member_name().compareToIgnoreCase(member_name_to_find) > 0) {
            root.connect_left(find_member(root.go_left(), member_name_to_find, new_member_name, member_id, member_to_find));
        }
        else if(root.get_member_name().compareToIgnoreCase(member_name_to_find) < 0) {
            root.connect_right(find_member(root.go_right(), member_name_to_find, new_member_name, member_id, member_to_find));
        }
        else {
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

    public int updateMemberId_wrapper()
    {
        System.out.println("Enter member name to change id: ");
        String to_find = input.nextLine();
        System.out.println("Enter new member ID: ");
        int new_id = input.nextInt();

        this.m_root = updateMemberId(m_root, to_find, new_id);
        display_all_wrapper();
        return 0;
    }

    protected Node updateMemberId(Node root, String member_name_to_find, int new_id) {
        if (root == null)
            return root;
        if (root.get_member_name().compareToIgnoreCase(member_name_to_find) > 0)
            root.connect_left(updateMemberId(root.go_left(), member_name_to_find, new_id, current_id));
        else if (root.get_member_name().compareToIgnoreCase(member_name_to_find) < 0)
            root.connect_right(updateMemberId(root.go_right(), member_name_to_find, new_id, current_id));
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
    
    public void updateMemberInfo() {
        System.out.println("[1] - Update Member Name." + "\n[2] - Update Member ID" +
                "\n[3] - Update Member Services" + "\n[4] - Update Member Address.");
        int response = input.nextInt();
        input.nextLine();
        if (response == 1) {
            updateMemberName();
        } else if (response == 2) {
            /*System.out.println("What is the name of the member you wish to edit?");
            String nameToFind = input.nextLine();
            System.out.println("What is their *NEW* ID");
            int newID = input.nextInt();*/
            updateMemberId_wrapper();
        } else if (response == 3) {
            /*System.out.println("What is the name of the member you wish to edit?");
            String nameToFind = input.nextLine();
            System.out.println("What are their *NEW* status?");
            String updatedStatus = input.nextLine();
            updateMemberStatus(m_root, nameToFind, updatedStatus);*/
            updateMemberStatus_wrapper();
        } else if (response == 4) {
            /*System.out.println("What is the name of the member you wish to edit?");
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
            updateMemberAddress(m_root, nameToFind, toUpdate);*/
            updateMemberAddress_wrapper();
        }
    }

    public int updateMemberStatus_wrapper()
    {
        System.out.println("Enter member name to change status: ");
        String to_find = input.nextLine();
        System.out.println("Enter new member status: ");
        String new_status = input.nextLine();

        this.m_root = updateMemberStatus(m_root, to_find, new_status);
        display_all_wrapper();
        return 0;
    }

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
        if(response == 1)
        {
            System.out.println("Enter new street: ");
            String new_street = input.nextLine();
            new_address.street = new_street;
            this.m_root = updateMemberAddress(m_root, to_find, new_address);
            display_all_wrapper();
            return 0;
        }
        if(response == 2)
        {
            System.out.println("Enter new city: ");
            String new_city = input.nextLine();
            new_address.city = new_city;
            this.m_root = updateMemberAddress(m_root, to_find, new_address);
            display_all_wrapper();
            return 0;
        }
        if(response == 3)
        {
            System.out.println("Enter new state: ");
            String new_state = input.nextLine();
            new_address.state = new_state;
            this.m_root = updateMemberAddress(m_root, to_find, new_address);
            display_all_wrapper();
            return 0;
        }
        if(response == 4)
        {
            System.out.println("Enter new zip: ");
            int new_zip = input.nextInt();
            new_address.zip = new_zip;
            this.m_root = updateMemberAddress(m_root, to_find, new_address);
            display_all_wrapper();
            return 0;
        }
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


    public int read_from_file() {
        int temp_id = 0;
        try {
            String filename = "May30 - CS300Project 2/MemberList.txt";
            String working_directory = System.getProperty("user.dir");
            File file = new File(working_directory, filename);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line = in.readLine();

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

    public Node add_member(Node root, int m_id, String m_status, String m_name, Address m_address) {
        if(root == null)
        {
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

    public int check_name_wrapper(String member_name) {
        return check_name(m_root, member_name);
    }

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

    protected int check_id(Node root, int member_id, int[] check_value) {
        if (root == null)
            return 0;

        if (root.get_member_id() == member_id)
            check_value[0] = 1;
        int return_value = check_id(root.go_left(), member_id, check_value);
        return_value = check_id(root.go_right(), member_id, check_value);
        return return_value;
    }

    public int write_to_file() {
        try{
            FileWriter writer = new FileWriter("ChocAnMemberListTest.txt");
            this.write_to_file(m_root, writer);
            writer.close();
        }
        catch(IOException exception){
            exception.printStackTrace();
        }
        return 1;
    }


    protected int write_to_file(Node root, FileWriter file)
    {
        if(root == null)
            return 1;
        write_to_file(root.go_left(), file);
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
        write_to_file(root.go_right(), file);
        return 1;
    }


    public void remove_member_wrapper(String m_name, int m_id) {
        if (m_root == null)
            return;
        this.m_root = remove_member(this.m_root, m_name, m_id);
    }

    protected Node remove_member(Node root, String name, int id) {
        if (root == null)
            return root;
        if (root.get_member_name().compareToIgnoreCase(name) > 0) {
            root.connect_left(remove_member(root.go_left(), name, id));
        }
        else if (root.get_member_name().compareToIgnoreCase(name) < 0) {
            root.connect_right(remove_member(root.go_right(), name, id));
        }
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

        public int validate_member_wrapper ( int member_id){
            int [] validate_value = new int[1];
            validate_value[0] = -2;
            int return_value = validate_member(this.m_root, member_id, validate_value);

            if(return_value == -1 && validate_value[0] == -2)
                validate_value[0] = -1; //Member doesn't exist in list
            return validate_value[0];
        }

        public void display_all_wrapper() {
            display_all(m_root);
        }

        protected void display_all(Node root) {
            if (root == null)
                return;

            display_all(root.go_left());
            root.DisplayAll();
            display_all(root.go_right());
        }

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

    public Node get_member(){
        System.out.print("What is the member ID: ");
        int mnum = input.nextInt();
        return get_member(this.m_root, mnum);
    }

    //Returns a provider so that we can write their information to file when a client is being processed.
    public Node get_member(Node root, int member_id) {
        if (root == null)
            return root;
        if (root.get_member_id() > member_id) {
            return get_member(root.go_left(), member_id);
        }
        else if(root.get_member_id() < member_id) {
            return get_member(root.go_right(), member_id);
        }
        else {
            if (root.get_member_id() == member_id) {
                return root;
            } else if (root.get_member_id() != member_id) {
                System.out.print("Person not found.\n");
            }
        }
        return root;
    }

    
        public String find_member(int mid){
        return find_member(this.m_root, mid);
    }
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
