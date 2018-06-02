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
  abstract public void set_m_name(String newName);
  abstract public void set_p_name(String newName);
  abstract public void set_service_code(int new_code);
  abstract public void set_service_fee(float new_fee);
  abstract public void DisplayAll();

  //Functions for Member class
  abstract public int get_member_id();
  abstract public String get_status();
  abstract public String get_member_name();
  abstract public Address get_address();
  
  abstract public void set_member_status(String status_to_set);
  abstract public void set_member_name(String name_to_set);
  abstract public void set_member_id(int id_to_change);
  abstract public void set_member_address(Address address_to_set);

  //More for Service history tree class
  abstract public String get_pname();
  abstract public int get_pnum();
  abstract public String get_mname();
  abstract public String get_sdate();
  abstract public String get_ldate();
  abstract public String get_comments();
  abstract public Address get_paddress();
  abstract public Address get_maddress();
  
  //More for provider
  abstract public float get_week_fee();
  abstract public int get_num_consultations();
  abstract public void set_provider_id(int newId);
  abstract public int get_provider_id();
  abstract public void set_provider_services(String newServices);
  abstract public String get_provider_services();
  abstract public void set_provider_address(Address new_address);
}
