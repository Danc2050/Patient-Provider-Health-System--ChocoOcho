import java.io.*;

public class MemberList {
    protected Node m_root;

    /*public MemberList(){this.m_root = null;)
    public int read_from_file(){}
    public int write_to_file(){}//TODO Try catch blocks in imp.
    public int add{}
    public int update{}
    public int remove{}*/
    
    public MemberList(){this.m_root = null;}

    public int read_from_file(){return 0;}
    public int write_to_file(){return 0;}//TODO Try catch blocks in imp.
    public int add_member(){return 0;}
    public int update_member(){return 0;}
    public int remove_member(){return 0;}

    public int validate_member_wrapper(int member_id){
        return validate_member(this.m_root, member_id);
    }

    protected int validate_member(Node root, int member_id){
        if(root == null)
            return -1;
        if(root.get_member_id() == member_id)
        {
            if(root.get_status().compareToIgnoreCase("Active") == 0)
                return 1;
            else
                return 0;
        }
        if(root.get_member_id() < member_id)
            return validate_member(root.go_left(), member_id);
        else
            return validate_member(root.go_right(), member_id);
    }
    
}
