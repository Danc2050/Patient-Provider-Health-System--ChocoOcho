abstract public class Node extends Utility {
  protected Node left;
  protected Node right;

  public Node() {this.left = null; this.right = null;}
  public Node go_left() {return this.left;}
  public Node go_right() {return this.right;}
  public void connect_left(Node connection) {this.left = connection;}
  public void connect_right(Node connection) {this.right = connection;}
  abstract public String get_service_name();
  abstract public int get_service_code();
  abstract public float get_service_fee();
  abstract public void set_service_name(String new_name);
  abstract public void set_service_code(int new_code);
  abstract public void set_service_fee(float new_fee);
  abstract public void DisplayAll();

  //Functions for Member class
  abstract public int get_member_id();
  abstract public String get_status();
  abstract public String get_member_name();
}
