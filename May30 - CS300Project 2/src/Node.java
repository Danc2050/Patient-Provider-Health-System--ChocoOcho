abstract public class Node extends Utility {

  /* Left and Right data fields for BST */
  protected Node left;
  protected Node right;

  /* Copy constructor initializes left and right to null */
  public Node() {this.left = null; this.right = null;}

  /* Functions to traverse tree going right and left */
  public Node go_left() {return this.left;}
  public Node go_right() {return this.right;}

  /* Takes the value passed in and connect current object node to value passed in */
  public void connect_left(Node connection) {this.left = connection;}
  public void connect_right(Node connection) {this.right = connection;}

  /* Dynamically bound display function */
  abstract public void DisplayAll();

  /* Setters and Getters for ServiceList Class */
  abstract public String get_service_name();
  abstract public int get_service_code();
  abstract public float get_service_fee();
  abstract public void set_service_name(String new_name);
  abstract public void set_service_code(int new_code);
  abstract public void set_service_fee(float new_fee);

  /* Setters and Getters for MemberList Class */
  abstract public int get_member_id();
  abstract public String get_status();
  abstract public String get_member_name();
  abstract public Address get_address();
  abstract public void set_m_name(String newName);
  abstract public void set_member_status(String status_to_set);
  abstract public void set_member_name(String name_to_set);
  abstract public void set_member_id(int id_to_change);
  abstract public void set_member_address(Address address_to_set);

  /* Setters and Getters for ServiceHistory Class */
  abstract public String get_pname();
  abstract public int get_pnum();
  abstract public String get_mname();
  abstract public String get_sdate();
  abstract public String get_ldate();
  abstract public String get_comments();
  abstract public Address get_paddress();
  abstract public Address get_maddress();
  
  /* Setters and Getters for ProviderList Class */
  abstract public void set_provider_id(int newId);
  abstract public int get_provider_id();
  abstract public void set_provider_services(String newServices);
  abstract public String get_provider_services();
  abstract public void set_provider_address(Address new_address);
  abstract public void set_p_name(String newName);
}
