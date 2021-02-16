
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Rohit Kumar Gupta //
 */
class SortCompare implements Comparator<Therapist> {

    String key;

    SortCompare(String key) {
        this.key = key;
    }

    @Override

    public int compare(Therapist a, Therapist b) {
        if (key.equals("Fees")) {
            if((Float.parseFloat(a.getFees()))<(Float.parseFloat(b.getFees())))
                 return -1;
            if(Float.parseFloat(a.getFees())>Float.parseFloat(b.getFees()))
                   return 1;
            else return 0;
            
        } else if (key.equals("Name")) {
            return a.getName().compareToIgnoreCase(b.getName());
        } else if (key.equals("Experience")) {
             if(Integer.parseInt(a.getExperience())<Integer.parseInt(b.getExperience()))
                 return -1;
            if(Integer.parseInt(a.getExperience())>Integer.parseInt(b.getExperience()))
                   return 1;
            else return 0;
        } else {
//            System.out.println(a.getCity()+" "+b.getCity()+" "+a.getCity().compareToIgnoreCase(b.getCity()));
            return a.getCity().compareToIgnoreCase(b.getCity());
        }
    }
}

public class Manager {

    private Map<String, ArrayList<Therapist>> Data;
    private ArrayList<Therapist> displayData;

    public Manager() {
        Data = new HashMap<>();

        displayData = new ArrayList<>();
        this.storeData();
        this.allData();
        this.sortData("City");
    }

  

    public void sortData(String Type) {
    
        displayData.sort(new SortCompare(Type));
    }

    public void allData() {
        displayData.clear();
        for (Map.Entry<String, ArrayList<Therapist>> P : Data.entrySet()) {
            displayData.addAll(P.getValue());
        }
    }

    public void filteredData(String City, int Budget) {
        displayData.clear();
        int size = Data.get(City.toLowerCase()).size();

        for (int i = 0; i < size; i++) {
            Therapist Person = Data.get(City.toLowerCase()).get(i);
            if (Math.round(Float.parseFloat(Person.getFees())) <= Budget) {
                displayData.add(Person);
            }
        }

    }

    public ArrayList<Therapist> getData() {

        return displayData;
    }

    public void printData(ArrayList<Therapist> A) {
        for (int i = 0; i < A.size(); i++) {
            Therapist Person = A.get(i);
            System.out.println(" City " + Person.getCity() + " Id " + Person.getId() + " Name " + Person.getName() + " Contact " + Person.getContactNumber() + " Fees " + Person.getFees()+" Exp "+Person.getExperience());
        }
    }

    public Therapist setData(String[] Info) {

        Therapist Person = new Therapist();
        Person.setCity(Info[1].toLowerCase());
        Person.setId(Integer.parseInt(Info[2]));
        Person.setName(Info[3]);
        if (Info[4].equals("")) {
            Info[4] = "Unknown";
        }
        Person.setFees(Info[4]);
        Person.setExperience(Info[5]);
        Person.setContactNumber(Info[6]);
        Person.setWebsite(Info[7]);
        String[] weeks = Info[8].split(" ");
        Person.setAvailDay(weeks);
        String TempAdd = "";
        for (int i = 9; i < Info.length; i++) {
            TempAdd += (Info[i] + ",");
        }
        Person.setAddress(TempAdd);
        return Person;

    }

    public void storeData() {
        String line = "";
        String splitBy = ",";
        Therapist Person;

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/utils/TherapistDataset.csv"));
            line = br.readLine();

            while ((line = br.readLine()) != null) //returns a Boolean value  
            {
                String[] Info = line.split(splitBy);
                Person = this.setData(Info);

                if (!Data.containsKey(Info[1].toLowerCase())) {
                    Data.put(Info[1].toLowerCase(), new ArrayList<>());
                }

                Data.get(Info[1].toLowerCase()).add(Person);
//                System.out.println(Data.get(Info[1].toLowerCase()).get(0).getContactNumber());
//                if(Data.containsKey("kolkata") && Info[1].toLowerCase().equals("kolkata")){
//                  System.out.println(" data Size "+Data.get("kolkata".toLowerCase()).size());}
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void openWebsite(String urlString) {
        try {
            Desktop.getDesktop().browse(new URL(urlString).toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Manager Obj = new Manager();

        Obj.filteredData("Pune", 10);
//        Obj.allData();
//       Obj.sortData("Fees");
        ArrayList<Therapist> p = Obj.getData();
//        assert p.size()>=0:"Data Correctly Store";
//assert p.size()>0:"Data Correctly Store";
        Obj.printData(p);
//        Obj.deleteData(1, "Dr Pradeep Kumar Saha");
    }
}
