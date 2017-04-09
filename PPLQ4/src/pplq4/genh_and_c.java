/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pplq4;

/**
 *
 * @author aditya
 */
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
public class genh_and_c {
    
    public void print_k_happy(couple_h_and_c [] c,int k,int w,int q){
        int i,j; double t;
        int no_of_boys=w;
        int no_of_girls=q;
        for(i=0;i<no_of_boys;i++){
            for(j=0;j<no_of_girls;j++){
                if(c[i].couple_happiness<c[j].couple_happiness){
                    t=c[i].couple_happiness;
                    c[i].couple_happiness=c[j].couple_happiness;
                    c[j].couple_happiness=t;
                }
                    
               
            }
        }
            

    
      System.out.println("The k(5)-most happy couples are(boy girl) :");
        for(i=0;i<k;i++){
            System.out.println(c[i].b_obj.get_name() + " "+ c[i].g_obj.get_name());
           // System.out.println(c[i].total_cost_of_gifts);
        }
    }
     public void print_k_comp(couple_h_and_c [] c,int k){
        int i,j,t;
        for(i=0;i<12;i++){
            for(j=i+1;j<12;j++){
                if(c[i].couple_compatibility<c[j].couple_compatibility){
                    t=c[i].couple_compatibility;
                    c[i].couple_compatibility=c[j].couple_compatibility;
                    c[j].couple_compatibility=t;
                }
            }
        }
        System.out.println("The k(5)-most compatible couples are(boy girl) :");
        for(i=0;i<k;i++){
            System.out.println(c[i].b_obj.get_name()+ " "+ c[i].g_obj.get_name());
        }
    }
}


