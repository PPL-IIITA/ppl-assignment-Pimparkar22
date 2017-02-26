/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ppl_q1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;
import java.util.*;
/**
 *
 * @author aditya
 */
public class PPL_Q1 {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        String name=null;
        int attractiveness=0;
        int maintenance=0;
        int intelligence=0;
        int budget=0;
        int attraction_requirement=0;
        boy x[]=new boy[10];
        girl y[]=new girl[6];
        int i=0;
         String csvFile = "/home/aditya/Desktop/boy.csv";
        String line = "";
        String cvsSplitBy = ",";

        try(BufferedReader br = new BufferedReader(new FileReader(csvFile))){

            while ((line = br.readLine()) != null&&i<10) {

                // use comma as separator
                String[] boy = line.split(cvsSplitBy);
                x[i]=new boy();
               
                
                x[i].set_name(boy[0]);
                x[i].set_budget(Integer.parseInt(boy[1]));
                x[i].set_attractiveness(Integer.parseInt(boy[2]));
                x[i].set_intelligence(Integer.parseInt(boy[3]));
                x[i].set_attraction_requirement(Integer.parseInt(boy[4]));
                i++;

            }

        }catch (IOException e) {
            e.printStackTrace();
        }
        
         csvFile = "/home/aditya/Desktop/girl.csv";
         line = "";
         cvsSplitBy = ",";
         int j=0;
        try(BufferedReader br = new BufferedReader(new FileReader(csvFile))){

            while ((line = br.readLine()) != null&&j<6) {
                
                // use comma as separator
                String[] girl = line.split(cvsSplitBy);
                y[j]=new girl();
                
                y[j].set_name(girl[0]);
                y[j].set_maintenancebudget(Integer.parseInt(girl[1]));
                x[j].set_attractiveness(Integer.parseInt(girl[2]));
                x[j].set_intelligence(Integer.parseInt(girl[3]));
                
                j++;

            }

        }catch (IOException e) {
            e.printStackTrace();
        }
        	
        int no_of_boys=i;
        int no_of_girls=j;
        int p,q;
        int k=0;
        for(p=0;p<no_of_boys;p++){
            for(q=0;q<no_of_girls;q++){
                if((x[p].girl_meets_eligibility(y[q].get_maintenance_budget(),y[q].get_attractiveness()))&&(y[q].boy_meets_eligibility(x[p].budget))&&x[p].relationship_status==false&&y[q].relationship_status==false){
                    x[p].gfname = y[q].get_name();
			y[q].bfname = x[p].get_name();
			x[p].relationship_status = true;
			y[q].relationship_status = true;
                        System.out.println("Couple Alert:"+x[p].get_name()+" is committed with "+y[q].get_name());
                        k++;
                }
            }
        
        }
        File fp=new File("Output1.txt");
	         Boolean check;
		check=fp.createNewFile();
        try (FileWriter fw = new FileWriter("Output1.txt"); BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(Integer.toString(k));
            bw.newLine();
            for(p=0;p<no_of_boys;p++){
                for(q=0;q<no_of_girls;q++){
                    if(x[p].gfname==y[q].get_name()){
                        
                        
                        String s3;
                        String s2;
                        s3=x[p].get_name();
                        
                        s2=y[q].get_name();
                        bw.write(s3);
                        bw.write(" is in a relationship with ");
                        bw.write(s2);
                        bw.newLine();
                        
                    }
                }
                
            }
        }
    }
    
}


