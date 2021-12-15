package com.company.algorithms;

import com.company.models.Client;
import com.company.models.Package;

import java.util.LinkedList;

public class Sort {
    //merge sort
    public static void mergeSort(LinkedList<Package> packages){
        if(packages.size() <2) return;
        int mid =packages.size()/2;
        LinkedList<Package> left = new LinkedList<>();
        LinkedList<Package> right = new LinkedList<>();
        for(int i=0; i<mid; i++){
            left.add(packages.get(i));
        }
        for(int i=0; i<packages.size()-mid; i++){
            right.add(packages.get(mid+i));
        }
        mergeSort(left);
        mergeSort(right);
        merge(left, right, packages);
    }
// part of the merge sort for recursion
    private static void merge(LinkedList<Package> left, LinkedList<Package> right, LinkedList<Package> all){
        int i=0, j=0, k=0;
        while(i<left.size() && j< right.size()){
            if(left.get(i).getId() < right.get(j).getId()){
                all.set(k,left.get(i));
                i++;
            }else{
                all.set(k,right.get(j));
                j++;
            }
            k++;
        }
        while(i<left.size()){
            all.set(k++,left.get(i++));
        }
        while(j<right.size()){
            all.set(k++, right.get(j++));
        }
    }


    //selection sort
    public static void selectionSort(LinkedList<Client> clientList, int threshold) {
        for (int i = 0; i < threshold; i++) {
            int min_idx = i;
            for (int j = i + 1; j < clientList.size(); j++) {
                if (clientList.get(j).getNumberOfPackagesReceived() >= clientList.get(min_idx).getNumberOfPackagesReceived()) {
                    min_idx = j;
                }
            }
            Client temp = clientList.get(min_idx);
            clientList.set(min_idx, clientList.get(i));
            clientList.set(i, temp);

        }
    }

}
