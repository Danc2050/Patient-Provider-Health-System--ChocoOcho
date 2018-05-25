import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;

public class SHistoryTree extends Utility {
    protected Node h_root;

    public SHistoryTree(){this.h_root = null;}

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
                String temp_pname = columns[0];
                int temp_pnum = Integer.parseInt(columns[1]);
                String temp_mname = columns[2];
                int temp_mnum = Integer.parseInt(columns[3]);
                String temp_sdate = columns[4];
                String temp_ldate = columns[5];
                String temp_sname = columns[6];
                int temp_code = Integer.parseInt(columns[7]);
                float temp_fee = Float.parseFloat(columns[8]);
                String temp_comments = columns[9];

                this.h_root = add_history(this.h_root,temp_pname,temp_pnum,temp_mname,temp_mnum,temp_sdate,temp_ldate,temp_sname,temp_code,temp_fee,temp_comments);
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
        try{
            FileWriter writer = new FileWriter("ServiceHistory.txt");
            this.write_to_file(h_root, writer);
            writer.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return 1;
    }

    protected int write_to_file(Node h_root, FileWriter file){
        if(h_root == null)
            return 1;
        write_to_file(h_root.go_left(),file);
        try{
            file.write(h_root.get_pname() + ";");
            file.write(h_root.get_pnum() + ";");
            file.write(h_root.get_mname() + ";");
            file.write(h_root.get_member_id() + ";");
            file.write(h_root.get_sdate() + ";");
            file.write(h_root.get_ldate() + ";");
            file.write(h_root.get_service_name() + ";");
            file.write(h_root.get_service_code() + ";");
            file.write(h_root.get_service_fee() + ";");
            file.write(h_root.get_comments() + ";");
            file.write("\n");
        }catch(IOException e){
            e.printStackTrace();
        }
        write_to_file(h_root.go_right(),file);
        return 1;
    }



    //Wrapper
    public int add_history()
    {
        System.out.print("What is the provider name: ");
        String pname = input.next();
        System.out.print("What is the provider ID: ");
        int pnum = input.nextInt();
        System.out.print("What is the member name: ");
        String mname = input.next();
        System.out.print("What is the member ID: ");
        int mnum = input.nextInt();
        System.out.print("What is the service date: ");
        String sdate = input.next();
        System.out.print("What is the service name: ");
        String sname = input.next();
        System.out.print("\nWhat is the service code: ");
        int scode = input.nextInt();
        System.out.print("\nWhat is the service fee: ");
        float sfee = input.nextFloat();
        System.out.print("Comments:");
        String comments = input.next();
        String ldate = null; /*get current date*/
        h_root = add_history(h_root, pname,pnum,mname,mnum,sdate,ldate,sname,scode,sfee,comments);
        return 1;
    }

    protected Node add_history(Node h_root,String temp_pname,int temp_pnum,String temp_mname,int temp_mnum,String temp_sdate,String temp_ldate,String temp_sname,int temp_code,float temp_fee,String temp_comments){
        if(h_root == null) {
            h_root = new ServiceHistory(temp_comments,temp_sname,temp_code,temp_fee,temp_sdate,temp_ldate,temp_pname,temp_mname,temp_pnum,temp_mnum);
            return h_root;
        }
        else {
            if (h_root.get_service_name().compareToIgnoreCase(temp_pname) > 0)
                h_root.connect_left(add_history(h_root.go_left(), temp_pname,temp_pnum,temp_mname,temp_mnum,temp_sdate,temp_ldate,temp_sname,temp_code,temp_fee,temp_comments));
            else
                h_root.connect_right(add_history(h_root.go_right(), temp_pname,temp_pnum,temp_mname,temp_mnum,temp_sdate,temp_ldate,temp_sname,temp_code,temp_fee,temp_comments));
        }
        return h_root;
    }

    //Wrapper
    public int email_p_history(int p_id){
        try{
            FileWriter writer = new FileWriter("SummaryReport.txt");
            writer.write(h_root.get_pname() + ";");
            writer.write(h_root.get_pnum() + ";");

            email_p_history(this.h_root,writer, p_id);
            writer.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return 1;
    }

    protected void email_p_history(Node h_root,FileWriter file, int p_id){
        if(h_root == null)
            return;
        email_p_history(h_root.go_left(),file, p_id);
        if(this.h_root.get_pnum() == p_id && this.h_root.get_sdate() == null/*is within the week*/){
            try{
                file.write(h_root.get_mname() + ";");
                file.write(h_root.get_member_id() + ";");
                file.write(h_root.get_sdate() + ";");
                file.write(h_root.get_ldate() + ";");
                file.write(h_root.get_service_name() + ";");
                file.write(h_root.get_service_code() + ";");
                file.write(h_root.get_service_fee() + ";");
                file.write(h_root.get_comments() + ";");
                file.write("\n");
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        email_p_history(h_root.go_right(),file, p_id);
    }
    //Wrapper
    public int email_m_history(int m_id){
        try{
            FileWriter writer = new FileWriter("MemberHistory.txt");
            writer.write(h_root.get_mname() + ";");
            writer.write(h_root.get_member_id() + ";");
            email_m_history(this.h_root,writer, m_id);
            writer.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return 1;
    }

    protected void email_m_history(Node h_root, FileWriter file, int m_id){
        if(h_root == null)
            return;
        email_m_history(h_root.go_left(),file, m_id);
        if(this.h_root.get_member_id() == m_id){
            try{
                file.write(h_root.get_pname() + ";");
                file.write(h_root.get_pnum() + ";");
                file.write(h_root.get_sdate() + ";");
                file.write(h_root.get_ldate() + ";");
                file.write(h_root.get_service_name() + ";");
                file.write(h_root.get_service_code() + ";");
                file.write(h_root.get_service_fee() + ";");
                file.write(h_root.get_comments() + ";");
                file.write("\n");
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        email_m_history(h_root.go_right(),file, m_id);
    }
}
