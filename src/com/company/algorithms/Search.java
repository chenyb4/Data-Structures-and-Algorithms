package com.company.algorithms;

import com.company.models.Client;

import java.util.LinkedList;

public class Search {

    //binary search
    public static Client binarySearchClients(LinkedList<Client> clients, int clientId){
        int left=0;
        int right=clients.size()-1;
        int middle=(left+right)/2;

        while ((clients.get(middle).getId()!=clientId)&&(left<right)){
            if(clients.get(middle).getId()<clientId){
                left=middle+1;
            }else if(clients.get(middle).getId()>clientId){
                right=middle-1;
            }
            middle=(left+right)/2;
        }

        if(clients.get(middle).getId()==clientId){
            return clients.get(middle);
        }else{
            return null;
        }
    }



}
