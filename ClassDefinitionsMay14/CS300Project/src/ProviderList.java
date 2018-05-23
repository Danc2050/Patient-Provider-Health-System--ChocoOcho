import java.io.*;

public class ProviderList extends Utility{
    protected Node p_root;

    public ProviderList()
    {
        this.p_root = null;
    }

    public int read_from_file()
    {
        String file_name = "/Users/dabartagus/IdeaProjects/ChocoOcho/providerList.txt";
        try {

            FileReader file = new FileReader(file_name);
            BufferedReader in = new BufferedReader(file);

            String line = in.readLine();

            while (line != null) {
                String[] columns = line.split(";");
                String temp_name = columns[0];
                int temp_id = Integer.parseInt(columns[1]);
                float temp_week_fee = Float.parseFloat(columns[2]);
                int temp_num_consultations = Integer.parseInt(columns[3]);

                this.p_root = add_provider(this.p_root, temp_name, temp_id,  temp_week_fee, temp_num_consultations);
                line = in.readLine();
            }

        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException ex) {
            System.out.println("Error reading file.");
        }
        return 1;
    }

    public int write_to_file()
    {
        return -1;
    }

    public int add_provider() // wrapper
    {
        return -1;
    }

    protected Node add_provider(Node p_root, String t_name, int t_id, float t_week_fee, int t_num_consulations){
        if(p_root == null) {
            p_root = new Provider(t_name, t_id, t_week_fee, t_num_consulations);
            return p_root;
        }
        else {
            if (p_root.get_provider_name().compareToIgnoreCase(t_name) < 0)
                p_root.connect_left(add_provider(p_root.go_left(), t_name, t_id, t_week_fee, t_num_consulations));
            else
                p_root.connect_right(add_provider(p_root.go_left(), t_name, t_id, t_week_fee, t_num_consulations));
        }
        return p_root;
    }

    public void display_all(){
        display_all(this.p_root);
    }
    protected void display_all(Node p_root){
        if(p_root == null)
            return;
        display_all(p_root.go_left());
        p_root.DisplayAll();
        display_all(p_root.go_right());
    }
}
