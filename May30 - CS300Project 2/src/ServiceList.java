import java.io.*;

public class ServiceList extends Utility{
   protected Node s_root;
   protected int s_id;

   //Constructor
   public ServiceList()
   {
      this.s_root = null;
   }

   //Read service list from a text file using a relative path
   public int read_from_file()
   {
      int temp_code = 0;
      try {
         String filename = "May30 - CS300Project 2/ServiceList.txt";
         String working_directory = System.getProperty("user.dir");
         File file = new File(working_directory, filename);
         BufferedReader in = new BufferedReader(new FileReader(file));
         String line = in.readLine();

         while (line != null) {
            String[] columns = line.split(";");
            temp_code = Integer.parseInt(columns[0]);
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
      s_id = temp_code;
      return 1;
   }
   
   //Wrapper to write list of services to file
   public int write_to_file()
   {
      try{
         String filename = "May30 - CS300Project 2/ServiceList.txt";
         String working_directory = System.getProperty("user.dir");
         File file = new File(working_directory, filename);
         FileWriter writer = new FileWriter(file);
         this.write_to_file(s_root, writer);
         writer.close();
      }
      catch(IOException exception){
         exception.printStackTrace();
      }
      return 1;
   }

   //Writes list of services to file
   public int write_to_file(Node s_root, FileWriter file)
   {
      if (s_root == null)
         return 1;

      try {
         file.write(s_root.get_service_code() + ";");
         file.write(s_root.get_service_name() + ";");
         file.write(s_root.get_service_fee() + ";");
         file.write("\n");
      } catch (IOException e) {
         e.printStackTrace();
      }
      write_to_file(s_root.go_left(), file);
      write_to_file(s_root.go_right(), file);
      return 1;
   }

   //Wrapper to email list of service to a provider upon request
   public int email_service_list()
   {
      try {
         System.out.println("Please enter the provider ID: ");
         Integer p_id = input.nextInt();
         ProviderList person = new ProviderList();
         person.read_from_file();
         String name = person.find_provider(p_id);
         if(name == null){
            System.out.println("\nInvalid ID.\n");
            return 0;
         }
         name.concat(".txt");
         FileWriter writer = new FileWriter(name);

         this.write_to_file(s_root, writer);
         writer.close();
      }
      catch (IOException e)
      {
         e.printStackTrace();
      }
      return 1;
   }

   //Wrapper for adding service
   //Also prompt user to enter a service information to add
   public int add_service()
   {
      System.out.print("What is the service name? : ");
      String t_name = input.nextLine();
      System.out.print("Generating service code...");
      int t_code = ++s_id;
      System.out.print("\nWhat is the service fee? : ");
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

   //Service ID's Verification Wrapper
   public boolean check_service_wrapper(String to_check)
   {
       return check_service(this.s_root, to_check);
   }

   //Check for service ID, return true if service exists in list, return false if service doesn't exist
   protected boolean check_service(Node s_root, String to_check)
   {
      boolean ret = false;
      if (s_root == null)
         return false;
      if (s_root.get_service_name().compareTo(to_check) == 0)
         return true;
      ret = check_service(s_root.go_left(), to_check);
      if(!ret)
         ret = check_service(s_root.go_right(), to_check);
      return ret;
   }

   //Return a service ID based on a service name (Wrapper function)
   public int get_service_id_from_name_wrapper(String service_name)
   {
      return get_service_id_from_name(this.s_root, service_name);
   }

   //Return a service ID based on a service name
   protected int get_service_id_from_name(Node s_root, String service_name)
   {
      int ret = 0;
      if (s_root == null)
         return 0;
      if (s_root.get_service_name().compareTo(service_name) == 0)
         return s_root.get_service_code();
      ret = get_service_id_from_name(s_root.go_left(), service_name);
      if (ret == 0)
         ret = get_service_id_from_name(s_root.go_right(), service_name);
      return ret;
   }



   //Wrapper for display function
   public void display_all(){
      display_all(this.s_root);
   }

   //Display all the service in the tree
   protected void display_all(Node s_root){
      if(s_root == null)
         return;
      display_all(s_root.go_left());
      s_root.DisplayAll();
      display_all(s_root.go_right());
   }

   //Wrapper function for remove a service. Prompt user to enter a service name they want to remove
   //Added service verification.
   public void delete()
   {
      System.out.println("\nWhat is the name of the service you wish to delete?");
      String to_delete = input.nextLine();

      if (check_service_wrapper(to_delete))
         this.s_root = delete(this.s_root, to_delete);
      else
         System.out.println("\nService entered is not in directory to be deleted.");
   }

   //Function to remove a service from the tree
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

   //Find the inorder successor of the node you want to remove
   protected String minValue(Node s_root)
   {
      if (s_root.go_left() != null)
      {
         return minValue(s_root.go_left());
      }
      return s_root.get_service_name();
   }

   //Wrapper function that prompt users to enter choices
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

         if (check_service_wrapper(to_update)) //Service exists in directory.
         {
            System.out.println("\nEnter the new 6-digit service code to replace " + to_update);

            int new_sCode = input.nextInt();
            this.s_root = updateServiceCode(s_root, to_update, new_sCode);
            display_all();
            return true;
         }

         else
         {
            System.out.println("\nService entered is not in directory to be updated.");
            return false;
         }
      }

      else if (response == 2)
      {
         display_all();
         System.out.println("Type the name of the service you wish to update:");
         String to_update = input.nextLine();

         if (check_service_wrapper(to_update))
         {
            System.out.println("Enter the new service name to replace " + to_update);

            String new_sName = input.nextLine();
            this.s_root = updateServiceName(s_root, to_update, new_sName);
            add_service(s_root.get_service_code(), new_sName, s_root.get_service_fee());
            display_all();
            return true;
         }

         else
         {
            System.out.println("\nService entered is not in directory to be updated.");
            return false;
         }
      }

      else
      {
         display_all();
         System.out.println("Type the name of the service you wish to update:");
         String to_update = input.nextLine();

         if (check_service_wrapper(to_update))
         {
            System.out.println("Enter the new service fee to replace " + to_update);

            float new_sFee = input.nextFloat();
            this.s_root = updateServiceFee(s_root, to_update, new_sFee);
            display_all();
            return true;
         }

         else
         {
            System.out.println("\nService entered is not in directory to be updated.");
            return false;
         }
      }
   }

   //Update the service name
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

   //Update service ID
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

   //Update service fee
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

   //Wrapper for getting a service based on service id
   public Service get_service(int service_code){
      return get_service(this.s_root, service_code);
   }

   //Returns a service node.
   public Service get_service(Node root, int service_id) {
      Service ret = null;
      if (root == null) {
         return null;
      }
      if (root.get_service_code() == service_id) {
         Service obj = new Service();
         obj.s_name = root.get_service_name();
         obj.s_code = root.get_service_code();
         obj.s_fee = root.get_service_fee();
         //obj.toCopy((Service) root);
         return obj;
      }
      else{
         ret = get_service(root.go_left(), service_id);
         if(ret == null)
            ret = get_service(root.go_right(), service_id);
      }
      return ret;
   }
}
