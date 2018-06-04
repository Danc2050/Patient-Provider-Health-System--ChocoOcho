import java.io.*;

public class ServiceList extends Utility{
   protected Node s_root;

   public ServiceList()
   {
      this.s_root = null;
   }

   public int read_from_file()
   {

      try {

         BufferedReader in = new BufferedReader(new FileReader("/Users/Angelic/IdeaProjects/June2Night/May30 - CS300Project 2/ServiceList.txt"));
         String line = in.readLine();

         while (line != null) {
            String[] columns = line.split(";");
            int temp_code = Integer.parseInt(columns[0]);
            String temp_name = columns[1];
            float temp_fee = Float.parseFloat(columns[2]);

            this.s_root = add_service(s_root,temp_code, temp_name, temp_fee);

            line = in.readLine();
         }

         in.close();
      } catch (FileNotFoundException e) {
         System.out.println("Service file not found.");
      } catch (IOException ex) {
         System.out.println("Error reading servicelist file.");
      }
      return 1;
   }
   public int write_to_file() {//todo implement.

   return 1;
   }

   public int email_service_list()
   {
  /* try {//todo -- write alphabetical service list to file.
      ProviderList person = new ProviderList();
      person.read_from_file();
      String name = person.find_provider(p_id);
      name.concat(".txt");*/
      return 1;
   }

   //Wrapper
   public int add_service()
   {
      System.out.print("What is the service name: ");
      String t_name = input.nextLine();
      System.out.print("\nWhat is the service code: ");
      int t_code = input.nextInt();
      System.out.print("\nWhat is the service fee: ");
      float t_fee = input.nextFloat();
      this.s_root = add_service(s_root, t_code, t_name, t_fee);
      return 1;
   }

   public int add_service(int t_code, String t_name, float t_fee)
   {
      this.s_root = add_service(s_root, t_code, t_name, t_fee);
      return 1;
   }

   protected Node add_service(Node s_root, int t_code, String t_name, float t_fee){
      if(s_root == null) {
         s_root = new Service(t_name, t_code, t_fee);
         return s_root;
      }
      else {
         if (s_root.get_service_name().compareToIgnoreCase(t_name) > 0)
            s_root.connect_left(add_service(s_root.go_left(), t_code, t_name, t_fee));
         else
            s_root.connect_right(add_service(s_root.go_right(), t_code, t_name, t_fee));
      }
      return s_root;
   }

   //Phuong's Service ID's Verification
   public boolean check_service_wrapper(int to_check)
   {
       return check_service(this.s_root, to_check);
   }

   protected boolean check_service(Node s_root, int to_check)
   {
      boolean ret = false;
      if (s_root == null)
         return false;
      if (s_root.get_service_code() == to_check)
         return true;
      ret = check_service(s_root.go_left(), to_check);
      if(ret == false)
         ret = check_service(s_root.go_right(), to_check);
      return ret;
   }


   //Wrapper
   public void display_all(){
      display_all(this.s_root);
   }

   protected void display_all(Node s_root){
      if(s_root == null)
         return;
      display_all(s_root.go_left());
      s_root.DisplayAll();
      display_all(s_root.go_right());
   }

   public void delete()
   {
      System.out.println("What is the name of the service you wish to delete?");
      String to_delete = input.nextLine();

      this.s_root = delete(this.s_root, to_delete);
   }

   public Node delete(Node s_root, String name)
   {
      if (s_root == null)
      {
         return s_root;
      }

      if (s_root.get_service_name().compareTo(name) > 0)
         s_root.connect_left(delete(s_root.go_left(), name));
      else if (s_root.get_service_name().compareTo(name) < 0)
         s_root.connect_right(delete(s_root.go_right(), name));
      else
      {
         if (s_root.go_left() == null && s_root.go_right() == null)//No children.
         {
            return null;
         } else if (s_root.go_left() == null)//No left child
         {
            System.out.println("Deleting " + name);
            return s_root.go_right();
         }
         else if (s_root.go_right() == null)//No right child
         {
            System.out.println("Deleting " + name);
            return s_root.go_left();
         }
         else//IOS condition.
         {
            String minValue = minValue(s_root.go_right());
            s_root.set_service_name(minValue);
            s_root.connect_right(delete(s_root.go_right(), minValue));
            System.out.println("Deleting " + name);
         }
      }
      return s_root;
   }

   protected String minValue(Node s_root)
   {
      if (s_root.go_left() != null)
      {
         return minValue(s_root.go_left());
      }
      return s_root.get_service_name();
   }

   public boolean updateService()
   {
      System.out.println("Press '1' to update the service code");
      System.out.println("Press '2' to update the service name");
      System.out.println("Press '3' to update the service fee");

      int response = input.nextInt();
      input.nextLine();

      if (response == 1)
      {
         display_all();
         System.out.println("Type the name of the service you wish to update:");
         String to_update = input.nextLine();

         System.out.println("Enter the new 6-digit service code to replace " + to_update);
         int new_sCode = input.nextInt();
         this.s_root = updateServiceCode(s_root, to_update, new_sCode);
         display_all();
         return true;
      }
      if (response == 2)
      {
         display_all();
         System.out.println("Type the name of the service you wish to update:");
         String to_update = input.nextLine();

         System.out.println("Enter the new service name to replace " + to_update);
         String new_sName = input.nextLine();
         this.s_root = updateServiceName(s_root, to_update, new_sName);
         add_service(s_root.get_service_code(), new_sName, s_root.get_service_fee());
         display_all();
         return true;
      }
      if (response == 3)
      {
         display_all();
         System.out.println("Type the name of the service you wish to update:");
         String to_update = input.nextLine();

         System.out.println("Enter the new service fee to replace " + to_update);
         float new_sFee = input.nextFloat();
         this.s_root = updateServiceFee(s_root, to_update, new_sFee);
         display_all();
         return true;
      }
      return false;
   }

   public Node updateServiceName(Node s_root, String oldServiceName, String newServiceName)
   {
      if (s_root == null)
      {
         return s_root;
      }
      if (s_root.get_service_name().compareTo(oldServiceName) > 0)
         s_root.connect_left(updateServiceName(s_root.go_left(), oldServiceName, newServiceName));
      else if (s_root.get_service_name().compareTo(oldServiceName) < 0)
         s_root.connect_right(updateServiceName(s_root.go_right(), oldServiceName, newServiceName));
      else
      {
         System.out.println("The service name " + s_root.get_service_name() + " has been changed to " + newServiceName);
         s_root.set_service_name(newServiceName);
         s_root = delete(s_root, newServiceName);
         return s_root;
      }
      return s_root;
   }

   public Node updateServiceCode(Node s_root, String oldServiceName, int new_sCode)
   {
      if (s_root == null)
      {
         return s_root;
      }
      if (s_root.get_service_name().compareTo(oldServiceName) > 0)
         s_root.connect_left(updateServiceCode(s_root.go_left(), oldServiceName, new_sCode));
      else if (s_root.get_service_name().compareTo(oldServiceName) < 0)
         s_root.connect_right(updateServiceCode(s_root.go_right(), oldServiceName, new_sCode));
      else
      {
         System.out.println("The service code " + s_root.get_service_code() + " has been changed to " + new_sCode);
         s_root.set_service_code(new_sCode);
         return s_root;
      }
      return s_root;
   }


   public Node updateServiceFee(Node s_root, String oldServiceName, float new_sFee)
   {
      if (s_root == null)
      {
         return s_root;
      }
      if (s_root.get_service_name().compareTo(oldServiceName) > 0)
         s_root.connect_left(updateServiceFee(s_root.go_left(), oldServiceName, new_sFee));
      else if (s_root.get_service_name().compareTo(oldServiceName) < 0)
         s_root.connect_right(updateServiceFee(s_root.go_right(), oldServiceName, new_sFee));
      else
      {
         System.out.println("The service fee " + s_root.get_service_fee() + " has been changed to " + new_sFee);
         s_root.set_service_fee(new_sFee);
         return s_root;
      }
      return s_root;
   }

   public Node get_service(){
      System.out.print("What is the service ID? : ");
      int scode = input.nextInt();
      return get_service(this.s_root, scode);
   }

   //Returns a service node.
   public Node get_service(Node root, int service_id) {
      if (root == null)
         return root;
      if (root.get_service_code() > service_id) {
         return get_service(root.go_left(), service_id);
      }
      else if(root.get_service_code() < service_id) {
         return get_service(root.go_right(), service_id);
      }
      else {
         if (root.get_service_code() == service_id) {
            return root;
         } else if (root.get_service_code() != service_id) {
            System.out.print("Service not found.\n");
         }
      }
      return root;
   }
}
