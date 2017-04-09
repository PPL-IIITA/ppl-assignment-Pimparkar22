/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pplq8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 *
 * @author aditya
 */
public class gifting1 extends giftgenerator {
     public void gift() throws IOException{
        // TODO code application logic here
        String name=null;
        int attractiveness=0;
        int maintenance=0;
        int intelligence=0;
        int budget=0;
        int attraction_requirement=0;
        boy x[]=new boy[10];
        girl y[]=new girl[6];
        Essential_gifts es[]=new Essential_gifts[100];
        Luxury_gift ls[]=new Luxury_gift[100];
        Utility_gift ug[]=new Utility_gift[100];
        int i=0;
         String csvFile = "../csv/boys1.csv";
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
                x[i].property=Integer.parseInt(boy[5]);
                x[i].set_status(false);
                x[i].number=i;
                i++;

            }

        }catch (IOException e) {
            e.printStackTrace();
        }
        int no_of_boys=i;
         csvFile = "../csv/girls1.csv";
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
                y[j].set_attractiveness(Integer.parseInt(girl[2]));
                y[j].set_intelligence(Integer.parseInt(girl[3]));
                y[j].property=Integer.parseInt(girl[4]);
                y[j].set_status(false);
                j++;

            }

        }catch (IOException e) {
            e.printStackTrace();
        }
        int no_of_girls=j;
        csvFile = "../csv/essential_gift.csv";
         line = "";
         cvsSplitBy = ",";
          j=0;
        try(BufferedReader br = new BufferedReader(new FileReader(csvFile))){

            while ((line = br.readLine()) != null&&j<6) {
                
                // use comma as separat
                String[] esg = line.split(cvsSplitBy);
                es[j]=new Essential_gifts();
                
                es[j].price=Integer.parseInt(esg[0]);
                es[j].value=Integer.parseInt(esg[1]);
                j++;

            }

        }catch (IOException e) {
            e.printStackTrace();
        }
        int no_es=j;
        csvFile = "../csv/luxury_gift.csv";
         line = "";
         cvsSplitBy = ",";
         j=0;
        try(BufferedReader br = new BufferedReader(new FileReader(csvFile))){

            while ((line = br.readLine()) != null&&j<6) {
                
                // use comma as separator
                String[] lsg = line.split(cvsSplitBy);
                ls[j]=new Luxury_gift();
                
                ls[j].luxury_rating=Integer.parseInt(lsg[0]);
                ls[j].diff_to_obtain_gift=Integer.parseInt(lsg[1]);
                ls[j].price=Integer.parseInt(lsg[2]);
                ls[j].value=Integer.parseInt(lsg[3]);
                
                j++;

            }

        }catch (IOException e) {
            e.printStackTrace();
        }
        int no_ls=j;
        
         csvFile = "../csv/utility_gift.csv";
         line = "";
         cvsSplitBy = ",";
         j=0;
        try(BufferedReader br = new BufferedReader(new FileReader(csvFile))){

            while ((line = br.readLine()) != null&&j<6) {
                
                // use comma as separator
                String[] usg = line.split(cvsSplitBy);
                ug[j]=new Utility_gift();
                
                ug[j].utility_value=Integer.parseInt(usg[0]);
                ug[j].utility_class=Integer.parseInt(usg[1]);
                ug[j].price=Integer.parseInt(usg[2]);
                ug[j].value=Integer.parseInt(usg[3]);
                
                j++;

            }

        }catch (IOException e) {
            e.printStackTrace();
        }
        int h=0;
         no_of_boys=i;
         no_of_girls=j;
        int p,q;
        for(p=0;p<no_of_boys;p++){
            for(q=0;q<no_of_girls;q++){
                if((x[p].girl_meets_eligibility(y[q].get_maintenance_budget(),y[q].get_attractiveness()))&&(y[q].boy_meets_eligibility(x[p].budget))){
                    if (y[q].get_status()==false&&x[p].get_status()==false) {
                        x[p].gfname = y[q].get_name();
                        y[q].bfname = x[p].get_name();
                        x[p].set_status(true);
                        y[q].set_status(true);
                        x[p].couple_number=h;
                        y[q].couple_number=h;
                        h++;
                    }
                       
            }
            }
        
        }
        
        
        
        
         File fp=new File("log8.txt");
	         Boolean check;
		check=fp.createNewFile();
        try (FileWriter fw = new FileWriter("log8.txt"); BufferedWriter bw = new BufferedWriter(fw)) {
           
            bw.newLine();
            //one essential and luxury gift is always alloted
        for(p=0;p<no_of_boys;p++){
            for(q=0;q<no_of_girls;q++){
                if(x[p].get_status()==true&&x[p].gfname == y[q].get_name()){
                    int gprop,bprop;
                    gprop=y[q].property;
                    bprop=x[p].property;
                    int balance=0;
                    int value=0;
                    
                          
                            balance=y[q].get_maintenance_budget();
                  
                            int quantity_es=0;
                           
                               
                                
                                System.out.println(x[p].get_name()+" gave "+y[q].get_name() +" an essential gift of price "+es[quantity_es].price);
                               bw.write(x[p].get_name()+" gave "+y[q].get_name() +" an essential gift of price "+es[quantity_es].price);
                                bw.newLine();
                               quantity_es++;
                                balance=balance-es[quantity_es].price;
                          
                            int quantity_ls=0;
                            
                                
                                
                               System.out.println(x[p].get_name()+" gave "+y[q].get_name()+" a luxury gift of price " +ls[quantity_ls].price);
                                bw.write(x[p].get_name()+" gave "+y[q].get_name() +" a luxury gift of price "+ls[quantity_ls].price);
                                bw.newLine(); 
                               quantity_ls++;
                                balance=balance-ls[quantity_ls].price;
                                
                                int quantity_us=0;
                                
                                System.out.println(x[p].get_name()+" gave "+y[q].get_name()+" a utility gift of price " +ug[quantity_us].price);
                                bw.write(x[p].get_name()+" gave "+y[q].get_name() +" a utility gift of price "+ug[quantity_us].price);
                                bw.newLine(); 
                               quantity_ls++;
                                balance=balance-ls[quantity_ls].price;
                             if(balance>0){
                             gifting_mechanism a=new gifting_mechanism();
                                a.gift(balance);
                             
                             }
                                
                           
                          
            
                    }
                
                
                }
                
            }
        
        }
        
         
           

            
            
        
        
        
            
            
          
     }
}



