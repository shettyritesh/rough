package com.rit;
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        int count=scanner.nextInt();
        int whatdiffisgood=scanner.nextInt();
        int[] arr= new int[count];
        Map compliment= new HashMap();
        int countofdiff=0;
        Set duplicatechck = new HashSet();
        for (int item=0;item<count;item++)
        {
            arr[item]=scanner.nextInt();
            Object obj=compliment.get(arr[item]);
            int countofinds=0;
            if(obj!=null){
                countofinds=(int)obj;
                countofinds++;
            }           
             
            compliment.put(arr[item],countofinds);
        }
        for (int item=0;item<count;item++)
        {

           Object obj=compliment.get(arr[item]+whatdiffisgood);
            boolean alredyaccounted=duplicatechck.contains(String.valueOf(arr[item])+String.valueOf(arr[item]+whatdiffisgood));
            if(obj!=null && !alredyaccounted){
               int highercomp=(int)obj;
               duplicatechck.add(String.valueOf(arr[item])+String.valueOf(arr[item]+whatdiffisgood));
               countofdiff++;
           }
           obj=compliment.get(arr[item]-whatdiffisgood);
           alredyaccounted=duplicatechck.contains(String.valueOf(arr[item]-whatdiffisgood)+String.valueOf(arr[item]));
           if(obj!=null && !alredyaccounted){
               int highercomp=(int)obj;
               duplicatechck.add(String.valueOf(arr[item]-whatdiffisgood)+String.valueOf(arr[item]));
               countofdiff++;
           }
           
        }
        
        System.out.print(countofdiff);
    }
}