/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author ROHIT
 */
public class ManagerMT {

    public ManagerMT() {

    }

    private String VerifyWebURL(String str) {

        URL url;
        try {
            url = new URL(str);
            url.toURI();
        } catch (MalformedURLException ex) {

            return "Malformed WebLink link::URL Should Be Like https://google.com or use http";

        } catch (URISyntaxException ex) {
            return "Syntaxically Not Formatted WebLink::Arises Due to Extra Spaces Or wrong symbol in url";
        }
        try {
            url = new URL(str);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int code = connection.getResponseCode();
            if (code == 200) {
                return "Correct";
            } else {
                return "Change WebLink::WebLink Not Responding.May be Server Down Or Endpoint is Incorrect";
            }
        } catch (Exception ex) {
            return "Connection is Not Establish:: Check WebLink Requested Method And Net Connection";

        }

    }

    public String verifyDeletingSearchData(String Name, String Contact, String City, String CityId) {
        if (CityId.equals("") && City.equals("")) {
            if (Contact.equals("") && Name.equals((""))) {
                return "No Data Enter,Please Enter Data For Any Choice";
            }
            if (Name.equals("")) {
                return "Please Enter Name";
            }
            if (Contact.equals("")) {
                return "Please Enter Contact";
            }
            if (!Name.matches("^[^<>'\\\"/;`%+#()~@,+*()!]*$")) {
                return "Name Should Not Contain Following Symbols : !(),#<>'\"/;`%@*+/";
            }
            if (!Contact.matches("[0-9]{10}")) {
                return "Contact Number should Contain 10digits in range [0-9]";
            }
            return "success";
        } else {
            if (!CityId.equals("") && !City.equals("") && !(!Name.equals("") && !Contact.equals(""))) {
                if (!City.matches("^[A-Za-z ]*$")) {
                    return "City Name should Contain only alphabet And Spaces";
                } else if (!CityId.matches("[0-9]+")) {
                    return "City Id Should Be Digit";
                } else {
                    return "success";
                }
            }
            if (!Name.equals("") && !Contact.equals("")) {
                if (!Name.matches("^[^<>'\\\"/;`%+#()~@,+*()!-]*$")) {
                    return "Name Should Not Contain Following Symbols : !(),#<>'\"/;`%@*+-/";
                }
                if (!Contact.matches("[0-9]{10}")) {
                    return "Contact Number should Contain 10digits in range [0-9]";
                }
                return "success";
            }
            if (CityId.equals("")) {
                return "Please Enter City Id";
            }
            if (City.equals("")) {
                return "Please Enter City Name";
            }
        }
        return "success";

    }

    public String VerifyData(String Name, String City, String Contact, String Fees, String Experience, String WebLink, String Address) {
        if (Name.equals("")) {

            return "Name Is Compulsory";
        }
        if (!Name.matches("^[^<>'\\\"/;`%+#()~@,+*()!-]*$")) {

            return "Name Should Not Contain Following Symbols : !(),#<>'\"/;`%@*+-/";
        }

        if (City.equals("")) {

            //VerifyCityName()
            return "City Name is Compulsory";
        }
        if (!City.matches("^[A-Za-z ]*$")) {

            return "City Name should Contain only alphabet And Spaces";
        }

        if (!Contact.matches("[0-9]{10}")) {

            return "Contact Number should Contain 10digits in range [0-9]";
        }
        if (!Experience.matches("[0-9]*")) {

            return "Experience Should Be Positive Integer";
        }
        if (!Fees.matches("[0-9]+")) {

            return "Fees Is Compulsory,If it is Free then Enter 0 otherwise it should Contain following digit [0-9] Number";
        }
        if (!Address.matches("^[^<>'\\\"/`%#@+*!]*$")) {
            return "Address Should Not Contain : !<>'\"/`%@/";
        }
        if (WebLink.length() > 0) {
            String Status = this.VerifyWebURL(WebLink);
            if (!Status.equalsIgnoreCase("Correct")) {

                return Status;
            }
        }

        return "Successfully Added Therapist";
    }

    public boolean searchData(String CityId, String Name, String Contact, String City) {
        int Id = -1;
        if (!CityId.equals("")) {
            Id = Integer.parseInt(CityId);
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/utils/TherapistDataset.csv"));

            String currentLine = reader.readLine();

            while ((currentLine = reader.readLine()) != null) {
                String[] Info = currentLine.split(",");
                int id = Integer.parseInt(Info[2]);
                String Theraname = Info[3];
                String CityName = Info[1];
                Info[6] = Info[6].replaceAll("[-(+)' ']", "");
                if ((Theraname.equalsIgnoreCase(Name) && Info[6].contains(Contact)) || ((id == Id) && CityName.equalsIgnoreCase(City))) {

                    reader.close();
                    return true;
                }

            }
            reader.close();

        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return false;
    }

    private String[] ConvertJsonToStringArray(Therapist Person) {

        String[] PersonArray = new String[10];
        PersonArray[1] = Person.getCity();
        PersonArray[3] = Person.getName();
        PersonArray[4] = Person.getFees();
        PersonArray[5] = Person.getExperience();
        PersonArray[6] = "+(91)-" + Person.getContactNumber();
        PersonArray[7] = Person.getWebsite();
        PersonArray[8] = String.join(" ", Person.getAvailDay());
        PersonArray[9] = Person.getAddress();
        return PersonArray;
    }

    public void appendData(Therapist Person) {
        String[] PersonArray = ConvertJsonToStringArray(Person);
        try {
            boolean Found = searchData("-1", Person.getName(), Person.getContactNumber(), Person.getCity());
            if (!Found) {
                File InputFile = new File("src/utils/TherapistDataset.csv");
                BufferedReader reader = new BufferedReader(new FileReader("src/utils/TherapistDataset.csv"));
                File tempFile = new File("src/utils/Temp.csv");
                BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

                String currentLine = reader.readLine();
                writer.write(currentLine + System.getProperty("line.separator"));
                boolean added = false;
                String addedCity = "";
                String GlobalId = "";
                while ((currentLine = reader.readLine()) != null) {
                    String[] Info = currentLine.split(",");
                    String CityName = Info[1];
                    GlobalId = Info[0];
                    if (!added && Person.getCity().equalsIgnoreCase(CityName)) {
                        addedCity = Info[1];
                        PersonArray[0] = GlobalId;
                        PersonArray[2] = Info[2];
                        added = true;
                        currentLine = String.join(",", PersonArray);
                        writer.write(currentLine + System.getProperty("line.separator"));

                    }
                    if (added) {
                        GlobalId = Integer.toString(Integer.parseInt(Info[0]) + 1);
                        Info[0] = GlobalId;
                        if (Info[1].equals(addedCity)) {
                            Info[2] = Integer.toString(Integer.parseInt(Info[2]) + 1);
                        }
                        currentLine = String.join(",", Info);
                    }
                    writer.write(currentLine + System.getProperty("line.separator"));
                }

                if (!added) {
                    PersonArray[0] = Integer.toString(Integer.parseInt(GlobalId) + 1);
                    PersonArray[2] = "0";
                    currentLine = String.join(",", PersonArray);
                    writer.write(currentLine + System.getProperty("line.separator"));

                    System.out.println("Success Fully Added");

                }

//                System.out.println("\n00000ddd"+successful);
                writer.close();
                reader.close();
                InputFile.delete();
                boolean successful = tempFile.renameTo(InputFile);
                System.out.println("\n00000ddd" + successful);
            } else {
                System.out.println("Already Found Theapist");
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }

    }

    public void deleteData(String CityId, String Name, String Contact, String City) {
        int Id = -1;
        if (!CityId.equals("")) {
            Id = Integer.parseInt(CityId);
        }
        
        try {
            File InputFile = new File("src/utils/TherapistDataset.csv");
            BufferedReader reader = new BufferedReader(new FileReader("src/utils/TherapistDataset.csv"));
            File tempFile = new File("src/utils/Temp.csv");
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine = reader.readLine();
            writer.write(currentLine + System.getProperty("line.separator"));
            boolean Deleted = false;
            String DeletedCity = "";

            while ((currentLine = reader.readLine()) != null) {
                String[] Info = currentLine.split(",");
                // trim newline when comparing with lineToRemove
//                String trimmedLine = currentLine.trim();
                int id = Integer.parseInt(Info[2]);
                String Theraname = Info[3];
                String CityName = Info[1];
                String Cont = Info[6].replaceAll("[-(+)' ']", "");
                if ((Theraname.equalsIgnoreCase(Name) && Cont.contains(Contact)) || ((id == Id) && CityName.equalsIgnoreCase(City))) {
                    DeletedCity = CityName;
                    Deleted = true;
                    continue;

                }
                if (Deleted) {
                    String GlobalId = Integer.toString(Integer.parseInt(Info[0]) - 1);
                    Info[0] = GlobalId;
                    if (Info[1].equals(DeletedCity)) {
                        Info[2] = Integer.toString(Integer.parseInt(Info[2]) - 1);
                    }
                    currentLine = String.join(",", Info);
                }
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            writer.close();
            
            reader.close();
            InputFile.delete();
            if (Deleted) {
                boolean successful = tempFile.renameTo(InputFile);
                System.out.println(successful);
                System.out.println("Success Fully Deleted");

            } else {
                System.out.println("Not Found Any Record");
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }

    }

    public static void main(String[] args) {
        ManagerMT Obj = new ManagerMT();
    }

}
