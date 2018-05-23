import java.io.*;

public class MemberList {
    protected Node m_root;

    //protected Member m_root;

    public MemberList() {
        this.m_root = null;
    }

    public int read_from_file () {
        String file_name = "/Users/sonynguyen/IdeaProjects/ChocoOcho/ChocAnMemberList.txt";
        try {

            FileReader file = new FileReader(file_name);
            BufferedReader in = new BufferedReader(file);

            String line = in.readLine();

            while (line != null) {
                String[] columns = line.split(";");
                int temp_id = Integer.parseInt(columns[0]);
                String temp_status = columns[1];
                String temp_name = columns[2];
                String temp_street = columns[3];
                String temp_city = columns[4];
                String temp_state = columns[5];
                int temp_zip = Integer.parseInt(columns[6]);

                Address temp_address = new Address(temp_street, temp_city, temp_state, temp_zip);

                this.m_root = import_member_list(m_root, temp_id, temp_status, temp_name, temp_address);
            /*if (this.s_root != null) {
               this.s_root.DisplayAll();
            }*/
                //System.out.println(temp_code + " " + temp_name + " " + temp_fee);
                line = in.readLine();
            }

        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException ex) {
            System.out.println("Error reading file.");
        }
        return 0;
    }

    public Node add_member_wrapper(int id, String status, String name, Address address){

        return add_member(m_root, id, status, name, address);
    }

    public Node add_member(Node root, int m_id, String m_status, String m_name, Address m_address){
        if(root == null) {
            root = new Member(m_id, m_status, m_name, m_address);
            return root;
        }
        else {
            if(root.get_member_name().compareToIgnoreCase(m_name) < 0)
                root.connect_left(add_member(root.go_left(), m_id, m_status, m_name, m_address));
            else
                root.connect_right(add_member(root.go_right(), m_id, m_status, m_name, m_address));
        }
        return root;
    }

    public int check_name_wrapper(String member_name){
        return check_name(m_root, member_name);
    }

    protected int check_name(Node root, String member_name){
        if(root == null)
            return 0;
        if(root.get_member_name().compareToIgnoreCase(member_name) < 0)
            return check_name(root.go_left(), member_name);
        else if(root.get_member_name().compareToIgnoreCase(member_name) > 0)
            return check_name(root.go_right(), member_name);
        else
            return 1;
    }

    public int check_id_wrapper(int member_id){
        if(m_root == null)
            return 0;
        int [] check_value = new int[1];
        check_value[0] = -1;
        int return_value = check_id(m_root, member_id, check_value);
        if(check_value[0] == 1)
            return check_value[0];
        return return_value;


    }
    protected int check_id(Node root, int member_id, int [] check_value){
        if(root == null)
            return 0;

        if(root.get_member_id() == member_id)
            check_value[0] = 1;
        int return_value = check_id(root.go_left(), member_id, check_value);
        return_value = check_id(root.go_right(), member_id, check_value);
        return return_value;
    }

    public int write_to_file () {
        return 0;
    }//TODO Try catch blocks in imp.

    public int update_member () {
        return 0;
    }

    public int remove_member () {
        return 0;
    }

    public int validate_member_wrapper ( int member_id){
        int [] validate_value = new int[1];
        validate_value[0] = -2;
        int return_value = validate_member(this.m_root, member_id, validate_value);

        if(return_value == -1 && validate_value[0] == -2)
            validate_value[0] = -1;
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
        /*protected int validate_member(Member root, int member_id) {
            if(root == null)
                return -1;
            if(root.get_member_id() == member_id) {
                if(root.get_status().compareToIgnoreCase("Active") == 0)
                    return 1;
                else
                    return 0;
            }

            if(root.get_member_id() < member_id)
                return validate_member(root.go_left(), member_id);
            else
                return validate_member(root.go_right(), member_id);


        }*/

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

    //Use this block of code if member list is ordered by id numbers
        /*protected int validate_member (Node root,int member_id){
            if(root == null)
                return -1;
            if (root.get_member_id() == member_id)
            {
                if (root.get_status().compareToIgnoreCase("Active") == 0)
                    return 1;
                else
                    return 0;
            }
            else if (root.get_member_id() < member_id)
                return validate_member(root.go_left(), member_id);
            else
                return validate_member(root.go_right(), member_id);
        }*/

    protected Node import_member_list(Node root, int m_id, String m_status, String m_name, Address m_address)
    {
        if(root == null)
        {
            root = new Member(m_id, m_status, m_name, m_address);
            return root;
        }
        else {
            if(root.get_member_name().compareToIgnoreCase(m_name) < 0)
                root.connect_left(import_member_list(root.go_left(), m_id, m_status, m_name, m_address));
            else
                root.connect_right(import_member_list(root.go_right(), m_id, m_status, m_name, m_address));
        }
        return root;

    }
}