package com.company;

import com.company.models.Client;
import com.company.models.Package;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


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
            e.printStackTrace();
        }
    }


    public static void readPackagesFromCSV(String filePath,ArrayList<Package> list){
        try {
            Scanner fileReader=new Scanner(new File(filePath));
            fileReader.nextLine();
            while (fileReader.hasNext()){
                String lineInFile=fileReader.nextLine();
                String[] lineParts=lineInFile.split(";");
                int clientId = Integer.parseInt(lineParts[6]);
                int height = Integer.parseInt(lineParts[3]);
                int breadth = Integer.parseInt(lineParts[2]);
                int length = Integer.parseInt(lineParts[1]);
                int packageId = Integer.parseInt(lineParts[0]);
                double weight = Double.parseDouble(lineParts[4]);
                //Not sure about this
                Date entryDate = new SimpleDateFormat("dd-MM-yyyy").parse(lineParts[5]);
                list.add(new Package(packageId,length,breadth,height,clientId,entryDate,weight));
            }
            fileReader.close();
        } catch (FileNotFoundException|ParseException e) {
            e.printStackTrace();
        }
    }
}