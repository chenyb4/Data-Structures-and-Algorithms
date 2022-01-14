package com.company;

import com.company.datastructures.AVLTree;
import com.company.models.Client;
import com.company.models.Package;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Helper {

    public static void readClientsFromCSV(String filePath, ArrayList<Client> list){
        try {
            Scanner fileReader=new Scanner(new File(filePath));
            fileReader.nextLine();
            while (fileReader.hasNext()){
                String lineInFile=fileReader.nextLine();
                String[] lineParts=lineInFile.split(";");
                int clientId=Integer.parseInt(lineParts[0]);
                String name=lineParts[1];
                String initials=lineParts[2];
                int addressX=Integer.parseInt(lineParts[3]);
                int addressY=Integer.parseInt(lineParts[4]);
                list.add(new Client(clientId,name,initials,addressX,addressY));
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void readPackagesFromCSV(String filePath, ArrayList<Package> list, ArrayList<Client> clientList){
        try {
            Scanner fileReader=new Scanner(new File(filePath));
            fileReader.nextLine();
            while (fileReader.hasNext()){
                String lineInFile=fileReader.nextLine();
                String[] lineParts=lineInFile.split(";");
                int clientId = Integer.parseInt(lineParts[6]);
                Client client=Client.findClientByID(clientList,clientId);
                int height = Integer.parseInt(lineParts[3]);
                int breadth = Integer.parseInt(lineParts[2]);
                int length = Integer.parseInt(lineParts[1]);
                int packageId = Integer.parseInt(lineParts[0]);
                double weight = Double.parseDouble(lineParts[4]);
                Date entryDate = new SimpleDateFormat("dd-MM-yyyy").parse(lineParts[5]);
                Package tempPackage=new Package(packageId,length,breadth,height,client,entryDate,weight);
                list.add(tempPackage);
            }
            fileReader.close();
        } catch (FileNotFoundException|ParseException e) {
            System.err.println(e.getMessage());
        }
    }




}
