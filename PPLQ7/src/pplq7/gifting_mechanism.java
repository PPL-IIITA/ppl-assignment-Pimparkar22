/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pplq7;
import java.util.Random;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Math;
/**
 *
 * @author aditya
 */
public class gifting_mechanism {
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
        
        
        
        
         File fp=new File("log7.txt");
	         Boolean check;
		check=fp.createNewFile();
        try (FileWriter fw = new FileWriter("log7.txt"); BufferedWriter bw = new BufferedWriter(fw)) {
           
            bw.newLine();
   
        for(p=0;p<no_of_boys;p++){
            for(q=0;q<no_of_girls;q++){
                if(x[p].get_status()==true&&x[p].gfname == y[q].get_name()){
                    int gprop,bprop;
                    gprop=y[q].property;
                    bprop=x[p].property;
                    int balance=0;
                    int value=0;
                    switch(bprop){
                        case 1:
                           // System.out.println("In case 1");
                            balance=y[p].get_maintenance_budget();
                             //System.out.println("In case 1 balance "+balance);
                            int quantity_es=0;
                            while(balance>0&&quantity_es<no_es){
                                if(balance-es[quantity_es].price>0){
                                balance=balance-es[quantity_es].price;
                               // System.out.println("In case 1 balance "+balance);
                                value=value+es[quantity_es].value;
                                //System.out.println(x[p].get_name()+" gave "+y[q].get_name() +" an essential gift of price "+es[quantity_es].price);
                               //bw.write(x[p].get_name()+" gave "+y[q].get_name() +" an essential gift of price "+es[quantity_es].price);
                                //bw.newLine();
                               quantity_es++;}
                                else{
                                break;
                                }
                            }
                            int quantity_ls=0;
                            while(balance>0&&quantity_ls<no_ls){
                                if(balance-ls[quantity_ls].price>0){
                                balance=balance-ls[quantity_ls].price;
                               // System.out.println("In case 1 balance "+balance);
                                value=value+(2*ls[quantity_ls].value);
                               //System.out.println(x[p].get_name()+" gave "+y[q].get_name()+" a luxury gift of price " +ls[quantity_ls].price);
                                //bw.write(x[p].get_name()+" gave "+y[q].get_name() +" a luxury gift of price "+ls[quantity_ls].price);
                                //bw.newLine(); 
                               quantity_ls++;
                                }
                                else{
                                break;
                                }
                            }
                            y[q].total_gift_price=y[q].get_maintenance_budget()-balance;
                           // System.out.println("In case 1 gift_price "+y[q].total_gift_price);
                            y[q].total_gift_value=value;
                            // System.out.println("In case 1 gift_value "+y[q].total_gift_value);
                            x[p].happiness=x[p].budget-y[q].total_gift_price;
                             
                            y[q].happiness=y[p].calc_happiness(gprop);
                            break;
                        case 2:
                            balance=x[p].budget;
                           // System.out.println("In case 2 balance "+balance);
                            quantity_ls=no_ls-1;
                            while(quantity_ls>=0&&balance-ls[quantity_ls].price>=0){
                                balance=balance-ls[quantity_ls].price;
                               // System.out.println("In case 2 balance "+balance);
                                value=value+(2*ls[quantity_ls].value);
                                //System.out.println(x[p].get_name()+" gave "+y[q].get_name() +" a luxury gift of price "+ls[quantity_ls].price);
                                // bw.write(x[p].get_name()+" gave "+y[q].get_name() +" a luxury gift of price "+ls[quantity_ls].price);
                                //bw.newLine();
                                quantity_ls--;
                            }
                            quantity_es=no_es-1;
                            while(quantity_es>=0){
                                if(balance-es[quantity_es].price>0){
                                balance=balance-es[quantity_es].price;
                               // System.out.println("In case 2 balance "+balance);
                                value=value+es[quantity_es].value;
                                //System.out.println(x[p].get_name()+" gave "+y[q].get_name() +" an essential gift of price "+es[quantity_es].price);
                                //bw.write(x[p].get_name()+" gave "+y[q].get_name() +" an essential gift of price "+es[quantity_es].price);
                                //bw.newLine();
                                quantity_es--;
                                }
                                else{
                                break;
                                }
                            }
                            y[q].total_gift_price=budget-balance;
                            y[q].total_gift_value=value;
                            x[p].happiness=y[q].calc_happiness(gprop);
                            y[q].happiness=x[p].happiness;
                            break;
                        case 3:
                            balance=y[q].get_maintenance_budget();
                           // System.out.println("In case 3 balance "+balance);
                            quantity_es=0;
                            quantity_ls=0;
                            while(balance>0&&quantity_es<no_es){
                                    if(balance-es[quantity_es].price>0){
                                       // System.out.println("In case 3 balance "+balance);
                                balance=balance-es[quantity_es].price;
                                value=value+es[quantity_es].value;
                                //System.out.println(x[p].get_name()+" gave "+y[q].get_name() +" an essential gift of price "+es[quantity_es].price);
                                // bw.write(x[p].get_name()+" gave "+y[q].get_name() +" an essential gift of price "+es[quantity_es].price);
                                //bw.newLine();
                                quantity_es++;
                                    }
                                    else{
                                    break;
                                    }
                            }
                            if(ls[quantity_ls].price+y[q].get_maintenance_budget()<=x[p].budget){
                                balance=balance-ls[quantity_ls].price;
                               // System.out.println("In case 3 balance "+balance);
                                value=value+(2*ls[quantity_ls].value);
                                
                                //System.out.println(x[p].get_name()+" gave "+y[q].get_name() +" a luxury gift of price "+ls[quantity_ls].price);
                                // bw.write(x[p].get_name()+" gave "+y[q].get_name() +" a luxury gift of price "+ls[quantity_ls].price);
                                //bw.newLine();
                            }
                            y[q].total_gift_price=y[q].get_maintenance_budget()-balance;
                            y[q].total_gift_value=value;
                            x[p].happiness=y[q].get_intelligence();
                            y[q].happiness=y[q].calc_happiness(gprop);
                            break;
                    }
            
                
                
                
                }
                
            }
        
        }
        double max_happiness;
        Random rand =new Random();
        int k=rand.nextInt(4)+1;
        //System.out.println("k:"+k);
        genh_and_c gc=new genh_and_c();
        couple_h_and_c c[]=new couple_h_and_c[100];
        j=0;
        
        for(p=0;p<no_of_boys;p++){
            for(q=0;q<no_of_girls;q++){
                if(x[p].get_status()==true&&x[p].gfname == y[q].get_name()){
                    c[j]=new couple_h_and_c();
                    c[j].couple_happiness=x[p].happiness+y[q].happiness;
                    x[p].couple_happiness=c[j].couple_happiness;
                    y[q].couple_happiness=x[p].couple_happiness;
                    c[j].couple_compatibility=((x[p].budget-y[q].get_maintenance_budget())+Math.abs(x[p].get_attractiveness()-y[q].get_attractiveness())+Math.abs(x[q].get_intelligence()-y[q].get_intelligence()));
                    c[j].couple_number=x[p].couple_number;
                     x[p].couple_compatibility=c[j].couple_compatibility;
                    y[q].couple_compatibility=x[p].couple_compatibility;
                    j++;
                }
            }
        }
          int t;
          t=rand.nextInt(2);
          System.out.println("Value of test case: " +t);
        girl z=new girl();
            //boy number is randomly generated so it can be same for two or more cases
            //array is checked on basis of boy number and it is checked whether that boy has a girlfriend or not
            int s;
            s=rand.nextInt(8)+1;
           //array of boys is sorted
           if(t==0){
               System.out.println("Case:Search in array");
            
                if(x[s].get_status()==true){
                    
                    System.out.println(x[s].get_name()+" has a girlfriend Name:" +x[s].gfname);
                
                }
                else{
                    System.out.println(x[s].get_name()+" has no girlfriend");
                }
           
            
           
           
           }
           if(t==1){
           
    int first  = 0;
    int last   = no_of_boys - 1;
    int middle = (first + last)/2;
    System.out.println("Case: Binary Search");
    while( first <= last )
    {
      if ( x[middle].number < s )
        first = middle + 1;    
      else if (x[middle].number == s ) 
      {
        System.out.println(s + " found at location " + (middle + 1) + ".");
        if(x[s].get_status()==true){
                    
                    System.out.println(x[s].get_name()+" has a girlfriend Name:" +x[s].gfname);
                
                }
                else{
                    System.out.println(x[s].get_name()+" has no girlfriend");
                }
        break;
      }
      else
         last = middle - 1;
 
      middle = (first + last)/2;
   }
           
           
           
           }
           
           if(t==2){
               int hash[]=new int[10];
               System.out.println("Case:hash function");
               for(i=0;i<no_of_boys;i++){
                   hash[i]=i+1;
               }
           if(x[hash[s-1]].get_status()==true){
                    
                    System.out.println(x[s].get_name()+" has a girlfriend Name:" +x[s].gfname);
                
                }
                else{
                    System.out.println(x[s].get_name()+" has no girlfriend");
                }
           
           }
            
            
        
        for ( i = 0; i < no_of_girls-1; i++){
            for ( j = 0; j < no_of_girls-i-1; j++){
                if(y[i].couple_happiness<y[j].couple_happiness){
                    z=y[i];
                   y[i]=y[j];
                   y[j]=z;
                }
            }
        }
             //System.out.println("The k "+k+"-most happy couples are(boy girl) :");
            //bw.write("The k "+k+"-most happy couples are(boy girl) ");
            //bw.newLine();
                    
            int u=k;
            
            for(p=0;p<no_of_boys;p++){
            for(q=0;q<no_of_girls;q++){
                if(x[p].get_status()==true&&x[p].gfname.equals(y[q].get_name())){
                        if(u>0){
                    
                 //       System.out.println("Couple "+x[q].get_name()+""+y[p].get_name());
                   //     bw.write("Couple "+x[q].get_name()+""+y[p].get_name());
            //bw.newLine();
                        u--;
                        }
                    
                }
            }
            }
            
            
        
        
        for ( i = 0; i < no_of_girls-1; i++){
            for ( j = 0; j < no_of_girls-i-1; j++){
                if(y[i].couple_compatibility<y[j].couple_compatibility){
                    z=y[i];
                    y[i]=y[j];
                    y[j]=z;
                }
            }
        }
       //System.out.println("The k "+k+"-most compatible couples are(boy girl) :");
        //bw.write("The k "+k+"-most compatible couples are(boy girl) :");
          //  bw.newLine();
            u=k;
            for(p=0;p<no_of_boys;p++){
            for(q=0;q<no_of_girls;q++){
                if(x[p].get_status()==true&&x[p].gfname == y[q].get_name()){
                        if(u>0){
                    
                //        System.out.println("Couple "+x[q].get_name()+""+y[p].get_name());
              //         bw.write("Couple "+x[q].get_name()+""+y[p].get_name());
            //bw.newLine();
                        u--;
                        }
                    
                }
            }
            }
            
          
     }
        

}
}

