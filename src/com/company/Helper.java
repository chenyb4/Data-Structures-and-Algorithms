package com.company;

import com.company.models.Client;
import com.company.models.Package;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Helper {

    /**
     * Read the CSV file and loaded to the list
     * @param filePath of teh CSV file
     * @param list to exported
     */

    public static void readClientsFromCSV(String filePath, LinkedList<Client> list){
        try {
            Scanner fileReader=new Scanner(new File(filePath));
            fileReader.nextLine();
            while (fileReader.hasNext()){
                String lineInFile=fileReader.nextLine();
                String[] lineParts=lineInFile.split(";");
                //Regex if the name or initials does contain invalid characters like %
                if (!isValidString(lineParts[1]) || !isValidString(lineParts[2])){
                    System.err.println("Invalid name or initials when reading the Client CSV file");
                    return;
                }
                //Regex to check if the address x or y or client id does contain alphabets
                if (!isNumber(lineParts[0]) || !isNumber(lineParts[3]) || !isNumber(lineParts[4])){
                    System.err.println("Invalid address x or y or client id when reading the Client CSV file");
                    return;
                }
                int clientId=Integer.parseInt(lineParts[0]);
                String name=lineParts[1];
                String initials=lineParts[2];
                int addressX=Integer.parseInt(lineParts[3]);
                int addressY=Integer.parseInt(lineParts[4]);
                Client client = new Client(clientId,name,initials,addressX,addressY);
                if (!list.contains(client)){
                    list.add(client);
                }
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Read the packages from the CSV file
     * @param filePath of the CSV file
     * @param list  to exported to
     * @param clientList that the package belongs to
     */

    public static void readPackagesFromCSV(String filePath, LinkedList<Package> list, LinkedList<Client> clientList){
        try {
            Scanner fileReader=new Scanner(new File(filePath));
            fileReader.nextLine();
            while (fileReader.hasNext()){
                String lineInFile=fileReader.nextLine();
                String[] lineParts=lineInFile.split(";");
                if (!isNumber(lineParts[6]) || !isNumber(lineParts[3]) || !isNumber(lineParts[2])
                        || !isNumber(lineParts[1]) || !isNumber(lineParts[0])){
                    System.err.println("Cannot read inputs from the CSV file when reading the CSV file in Packages");
                    return;
                }
                int clientId = Integer.parseInt(lineParts[6]);
                Client client=Client.findClientByID(clientList,clientId);
                int height = Integer.parseInt(lineParts[3]);
                int breadth = Integer.parseInt(lineParts[2]);
                int length = Integer.parseInt(lineParts[1]);
                int packageId = Integer.parseInt(lineParts[0]);
                double weight = Double.parseDouble(lineParts[4]);
                Date entryDate = new SimpleDateFormat("dd-MM-yyyy").parse(lineParts[5]);
                Package tempPackage=new Package(packageId,length,breadth,height,client,entryDate,weight);
                if (!list.contains(tempPackage)){
                    list.add(tempPackage);
                }
            }
            fileReader.close();
        } catch (FileNotFoundException fnfe) {
            System.err.println(fnfe.getMessage());
        } catch (ParseException pe){
            System.err.println(pe.getMessage());
        }
    }

    public static boolean isValidString (String input) {
        //Regex to check if the input contains any special characters
        return input.matches("^[a-zA-Z.]*$");
    }

    public static boolean isNumber (String input) {
        String regex = "^[0-9]+$";  // regex to check if string contains only digits
        Pattern pattern = Pattern.compile(regex);  // compiles the regex
        // find match between given string and pattern
        Matcher matcherNumbers = pattern.matcher(input);
        return matcherNumbers.matches();
    }
}
