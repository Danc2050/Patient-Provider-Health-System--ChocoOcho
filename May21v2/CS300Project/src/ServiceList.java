import java.io.*;

public class ServiceList extends Utility{
   protected Node s_root;

   public ServiceList()
   {
      this.s_root = null;
   }

   public int read_from_file()
   {
      /*File directory = new File("./");
      System.out.println(directory.getAbsolutePath());

      File resource_file = new File("../ServiceList.txt");*/

      //String file_name = "ServiceList.txt";
      try {

         //FileReader file = new FileReader(file_name);
         //BufferedReader in = new BufferedReader(file);
         BufferedReader in = new BufferedReader(new FileReader("ServiceList.txt"));

         String line = in.readLine();

         while (line != null) {
            String[] columns = line.split(";");
            int temp_code = Integer.parseInt(columns[0]);
            String temp_name = columns[1];
            float temp_fee = Float.parseFloat(columns[2]);

            this.s_root = add_service(this.s_root,temp_code, temp_name, temp_fee);
            /*if (this.s_root != null) {
               this.s_root.DisplayAll();
            }*/
            line = in.readLine();
         }

         in.close();
      } catch (FileNotFoundException e) {
         System.out.println("File not found.");
      } catch (IOException ex) {
         System.out.println("Error reading file.");
      }
      return 1;
   }

   public int write_to_file()
   {
      return 1;
   }

   //Wrapper
   public int add_service()
   {
      System.out.print("What is the service name: ");
      String t_name = input.next();
      System.out.print("\nWhat is the service code: ");
      int t_code = input.nextInt();
      System.out.print("\nWhat is the service fee: ");
      float t_fee = input.nextFloat();
      s_root = add_service(s_root, t_code, t_name, t_fee);
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

   //Wrapper
   public void display_all(){
      display_all(this.s_root);
   }

   protected void display_all(Node s_root){
      if(s_root == null)
         return;
      display_all(s_root.go_left());
      s_root.DisplayAll();
      //System.out.println(s_root.get_service_name() + " " + s_root.get_service_code() + " " + s_root.get_service_fee());
      display_all(s_root.go_right());
   }
}
