import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.*;

public class SHistoryTree extends Utility {
    protected Node h_root;

    public SHistoryTree(){this.h_root = null;}

    public int read_from_file()
    {

        try {
            String filename = "May30 - CS300Project 2/ServiceHistory.txt";
            String working_directory = System.getProperty("user.dir");
            File file = new File(working_directory, filename);
            BufferedReader in = new BufferedReader(new FileReader(file));
            String line = in.readLine();

            while (line != null) {
                String[] columns = line.split(";");

                String temp_pname = columns[0];
                int temp_pnum = Integer.parseInt(columns[1]);
                String t_street = columns[2];
                String t_city = columns[3];
                String t_state = columns[4];
                int t_zip = Integer.parseInt(columns[5]);
                Address pad = new Address(t_street,t_city,t_state,t_zip);

                Provider p = new Provider(temp_pname,temp_pnum,pad,null);

                String temp_mname = columns[6];
                int temp_mnum = Integer.parseInt(columns[7]);
                t_street = columns[8];
                t_city = columns[9];
                t_state = columns[10];
                t_zip = Integer.parseInt(columns[11]);
                Address mad = new Address(t_street,t_city,t_state,t_zip);

                Member m = new Member(temp_mnum,null,temp_mname,mad);

                String temp_sdate = columns[12];

                String temp_ldate = columns[13];

                String temp_sname = columns[14];
                int temp_code = Integer.parseInt(columns[15]);
                float temp_fee = Float.parseFloat(columns[16]);

                String temp_comments = columns[17];

                Service s = new Service(temp_sname,temp_code,temp_fee);

                this.h_root = add_history(this.h_root,p,m,s,temp_sdate,temp_ldate,temp_comments);
                line = in.readLine();
            }

            in.close();
        } catch (FileNotFoundException e) {
            System.out.println("Service History not found.");
        } catch (IOException ex) {
            System.out.println("Error Service History reading file.");
        }
        return 1;
    }

    public int write_to_file()
    {
        try{
            FileWriter writer = new FileWriter("ServiceHistorytest.txt");
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
            //Address file.write(h_root.get_address() + ";");
            Address ad = new Address();
            ad = h_root.get_paddress();
            file.write(ad.street + ";");
            file.write(ad.city + ";");
            file.write(ad.state + ";");
            file.write(ad.zip + ";");
            file.write(h_root.get_mname() + ";");
            file.write(h_root.get_member_id() + ";");
            Address ad2 = new Address();
            ad2 = h_root.get_maddress();
            file.write(ad2.street + ";");
            file.write(ad2.city + ";");
            file.write(ad2.state + ";");
            file.write(ad2.zip + ";");
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



    //Wrapper. Phuong added code to pass in to make sure service code is valid.
    public int add_history(int service_code)
    {
        //Get provider node
        ProviderList provider = new ProviderList();
        provider.read_from_file();
        Provider pobj = provider.get_provider();
        //Get member node.
        MemberList member = new MemberList();
        member.read_from_file();
        Member mobj = member.get_member();
        //Enter service date and then a node of service to write to our history tree.
        System.out.print("What is the service date (Enter in format - MM-dd-YYYY HH:mm:ss)? : ");
        String sdate = input.nextLine();
        ServiceList service = new ServiceList();
        service.read_from_file();
        Service sobj = service.get_service(service_code);
        System.out.print("Comments:");
        String comments = input.nextLine();
        //input.nextLine();
        SimpleDateFormat mdyhms = new SimpleDateFormat("MM-dd-YYYY HH:mm:ss");
        String ldate = mdyhms.format(new Date());
        h_root = add_history(h_root,pobj,mobj,sobj,sdate,ldate,comments);
        return 1;
    }

    protected Node add_history(Node h_root,Provider p, Member m, Service s,String temp_sdate,String temp_ldate,String temp_comments){
        if(h_root == null) {
            h_root = new ServiceHistory(p,m,s,temp_sdate,temp_ldate,temp_comments);
            return h_root;
        }
        else {
            if(h_root != null) {
            if (h_root.get_pname().compareToIgnoreCase(p.get_pname()) > 0)
                    h_root.connect_left(add_history(h_root.go_left(), p, m, s, temp_sdate, temp_ldate, temp_comments));
            else
                h_root.connect_right(add_history(h_root.go_right(), p,m,s,temp_sdate,temp_ldate,temp_comments));
            }
        }
        return h_root;
    }


    //Wrapper
    public int email_p_history(int p_id){
        try {
            ProviderList person = new ProviderList();
            person.read_from_file();
            String name = person.find_provider(p_id);
            if(name == null){
                System.out.println("\nInvalid ID.\n");
                return 0;
            }
            name.concat(".txt");

            FileWriter writer = new FileWriter(name);
            email_p_history(this.h_root, p_id, writer);
            writer.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return 1;
    }
    public int email_p_history(Node h_root, int p_id, FileWriter writer){
        if(h_root == null) {
            return 1;
        }
        if(p_id == h_root.get_pnum()) {
            try {
                SimpleDateFormat mdy = new SimpleDateFormat("MM-dd-yyyy");
                long DAY = 1000 * 60 * 60 * 24;
                String begin = mdy.format(new Date(System.currentTimeMillis() - (7 * DAY)));
                String end = mdy.format(new Date());
                Date week = mdy.parse(begin);
                Date today = mdy.parse(end);

                writer.write("Name: " + h_root.get_pname() + "\n");
                writer.write("ID: " + h_root.get_pnum() + "\n");
                Address ad = new Address();
                ad = h_root.get_paddress();
                writer.write("Address: " + ad.street + ", ");
                writer.write(ad.city + ", ");
                writer.write(ad.state + ", ");
                writer.write(ad.zip + "\n");
                writer.write("\n~~~~Provider History for the week (" + begin + " to " + end + ")~~~~\n\n");
                email_p_history(h_root, writer, p_id, week, today);
                writer.write("\n~END~\n");
            }
            catch(IOException e) {
                e.printStackTrace();
            }
            catch(ParseException e){
                e.printStackTrace();
            }
        }
        else{
            email_p_history(h_root.go_left(), p_id, writer);
            email_p_history(h_root.go_right(), p_id,writer);
        }
        return 1;
    }

    protected void email_p_history(Node h_root,FileWriter file, int p_id, Date week, Date today){
        if(h_root == null)
            return;
        try {
            SimpleDateFormat mdy = new SimpleDateFormat("MM-dd-yyyy");
            Date sdate = mdy.parse(h_root.get_sdate());

            email_p_history(h_root.go_left(), file, p_id, week, today);
            if (h_root.get_pnum() == p_id && sdate.compareTo(week) >= 0 && sdate.compareTo(today) <= 0) {
                try {
                    file.write("Service date: " + h_root.get_sdate() + "\n");
                    file.write("Log date: " + h_root.get_ldate() + "\n");

                    file.write("Member: " + h_root.get_mname() + "\n");
                    file.write("Member ID: " + h_root.get_member_id() + "\n");
                    Address ad = new Address();
                    ad = h_root.get_maddress();
                    file.write("Address: " + ad.street + ", ");
                    file.write(ad.city + ", ");
                    file.write(ad.state + ", ");
                    file.write(ad.zip + "\n");

                    file.write("Service: " + h_root.get_service_name() + "\n");
                    file.write("Service code: " + h_root.get_service_code() + "\n");
                    file.write("Service fee: " + h_root.get_service_fee() + "\n");
                    file.write("Comments: " + h_root.get_comments() + "\n");
                    file.write("\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            email_p_history(h_root.go_right(), file, p_id, week, today);
        }catch(ParseException e){
            e.printStackTrace();
        }
    }

    //Wrapper
    public int email_m_history(int m_id){
        try{
            MemberList person = new MemberList();
            person.read_from_file();
            String name = person.find_member(m_id);
            if(name == null){
                System.out.println("\nInvalid ID.\n");
                return 0;
            }
            name.concat(".txt");
            FileWriter writer = new FileWriter(name);

            email_m_history(this.h_root, m_id, writer);
            writer.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return 1;
    }
    public int email_m_history(Node h_root, int m_id,FileWriter writer){
        if(h_root == null)
            return 1;
        if(m_id == h_root.get_member_id()) {
            try {
                writer.write("Name: " + h_root.get_mname() + "\n");
                writer.write("ID: " + h_root.get_member_id() + "\n");
                Address ad = new Address();
                ad = h_root.get_maddress();
                writer.write("Address: " + ad.street + ", ");
                writer.write(ad.city + ", ");
                writer.write(ad.state + ", ");
                writer.write(ad.zip + "\n");
                writer.write("\n~~~~Member History~~~~\n\n");
                email_m_history(h_root, writer, m_id);
                writer.write("\n~END~\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            email_m_history(h_root.go_left(), m_id,writer);
            email_m_history(h_root.go_right(), m_id,writer);
        }
        return 1;
    }
    protected void email_m_history(Node h_root, FileWriter file, int m_id){
        if(h_root == null)
            return;
        email_m_history(h_root.go_left(), file, m_id);
        if(h_root.get_member_id() == m_id) {
            try {

                file.write("Service date: " + h_root.get_sdate() + "\n");
                file.write("Log date: " + h_root.get_ldate() + "\n");

                file.write("Provider: " + h_root.get_pname() + "\n");
                file.write("Provider ID: " + h_root.get_pnum() + "\n");
                Address ad = new Address();
                ad = h_root.get_paddress();
                file.write("Address: " + ad.street + ", ");
                file.write(ad.city + ", ");
                file.write(ad.state + ", ");
                file.write(ad.zip + "\n");

                file.write("Service: " + h_root.get_service_name() + "\n");
                file.write("Serevice code: " + h_root.get_service_code() + "\n");
                file.write("Service fee: " + h_root.get_service_fee() + "\n");
                file.write("Comments: " + h_root.get_comments() + "\n");
                file.write("\n");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        email_m_history(h_root.go_right(), file, m_id);
    }

    public int email_summary_report() {
        if(this.h_root == null)
            return 1;

        try{
            SimpleDateFormat mdy = new SimpleDateFormat("MM-dd-yyyy");
            long DAY = 1000 * 60 * 60 * 24;
            String begin = mdy.format(new Date(System.currentTimeMillis() - (7 * DAY)));
            String end = mdy.format(new Date());
            Date week = mdy.parse(begin);
            Date today = mdy.parse(end);

            try{
                FileWriter writer = new FileWriter("SummaryReport.txt");
                writer.write("~~~~Summary Report for the week (" + begin + " to " + end + ")~~~~\n\n");

                float fee[] = new float[1];
                fee[0] = 0;
                int consultations[] = new int[1];
                consultations[0] = 0;

                int size = 100;
                int plist[] = new int[size];
                ProviderList providers = new ProviderList();
                providers.read_from_file();
                providers.get_ids(plist, 0);

                email_summary_report(this.h_root, writer, week, today, fee, consultations, plist);
                writer.write("\nTotal number of consultations with members: " + consultations[0] + "\n");
                writer.write("Overall fee total: " + fee[0] + "\n");
                writer.write("\n~END~\n");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }catch(ParseException e){
            e.printStackTrace();
        }
        return 1;
    }
    public int email_summary_report(Node h_root,FileWriter writer, Date week, Date today, float [] tfee, int [] tcons, int [] plist){
        if(h_root == null)
            return 1;

        try{
            SimpleDateFormat mdy = new SimpleDateFormat("MM-dd-yyyy");
            Date sdate = mdy.parse(h_root.get_sdate());

            email_summary_report(h_root.go_left(), writer,week, today, tfee, tcons, plist);
            if(sdate.compareTo(week) >= 0 && sdate.compareTo(today) <= 0) {
                try{
                    if(!visited(h_root.get_pnum(), plist)) {
                        writer.write("Provider: " + h_root.get_pname() + "\n");
                        writer.write("Provider ID: " + h_root.get_pnum() + "\n");

                        float fee[] = new float[1];
                        fee[0] = 0;
                        int consultations[] = new int[1];
                        consultations[0] = 0;
                        get_p_info(fee, consultations, h_root.get_pnum());

                        writer.write("Total number of consultations: " + consultations[0] + "\n");
                        writer.write("Total fee for the week: " + fee[0] + "\n\n");

                        tfee[0] = tfee[0] + fee[0];
                        tcons[0] = tcons[0] + consultations[0];
                        visit(h_root.get_pnum(), plist);
                    }

                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            email_summary_report(h_root.go_right(), writer, week, today, tfee, tcons, plist);
        }catch(ParseException e){
            e.printStackTrace();
        }
        return 1;
    }

    public void get_p_info(float [] fee, int [] consultations, int pid){
        if(this.h_root == null)
            return;
        try {
            SimpleDateFormat mdy = new SimpleDateFormat("MM-dd-yyyy");
            long DAY = 1000 * 60 * 60 * 24;
            String begin = mdy.format(new Date(System.currentTimeMillis() - (7 * DAY)));
            String end = mdy.format(new Date());
            Date week = mdy.parse(begin);
            Date today = mdy.parse(end);

            get_p_info(this.h_root, fee, consultations, pid, week, today);
        }catch(ParseException e){
            e.printStackTrace();
        }
    }
    protected void get_p_info(Node h_root, float [] fee, int [] consultations, int pid, Date week, Date today){
        if(h_root == null)
            return;
        try {
            SimpleDateFormat mdy = new SimpleDateFormat("MM-dd-yyyy");
            Date sdate = mdy.parse(h_root.get_sdate());

            if (h_root.get_pnum() == pid && sdate.compareTo(week) >= 0 && sdate.compareTo(today) <= 0) {
                fee[0] = fee[0] + h_root.get_service_fee();
                ++consultations[0];
            }
            get_p_info(h_root.go_left(), fee, consultations, pid, week, today);
            get_p_info(h_root.go_right(), fee, consultations, pid, week, today);
        }catch (ParseException e){
            e.printStackTrace();
        }
    }
    public boolean visited(int pid, int [] plist){
        int size = plist.length;
        for(int i = 0; i < size; ++i){
            if(pid == plist[i])
                return false;
        }
        return true;
    }
    public void visit(int pid, int [] plist){
        int size = plist.length;
        for(int i = 0; i < size; ++i){
            if(pid == plist[i])
                plist[i] = 0;
        }
    }
}
