package com.company.algorithms;

import java.util.Arrays;
import java.util.LinkedList;

public class Search <T extends Comparable<T>> {

    //binary search
    public T binarySearch(LinkedList<T> list, T object){
        int left=0;
        int right=list.size()-1;
        int middle=(left+right)/2;

        while ((list.get(middle).compareTo(object)!= 0 ) && (left<right)) {
            if (list.get(middle).compareTo(object) < 0) {
                left=middle+1;
            } else if (list.get(middle).compareTo(object) > 0) {
                right=middle-1;
            }
            middle=(left+right)/2;
        }

        if (list.get(middle).compareTo(object) == 0) {
            //Or return the index
            return list.get(middle);
        } else {
            return null;
        }
    }



}
