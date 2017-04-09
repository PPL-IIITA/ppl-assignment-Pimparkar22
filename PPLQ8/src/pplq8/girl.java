/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pplq8;
import static java.lang.Math.*;
import java.util.*;
/**
 *
 * @author aditya
 */
public class girl {
        private String name;
    public String bfname;
    private int maintenance_budget;
    private int attractiveness;
    private int intelligence;
    public int property; //1.choosy 2.normal 3.desperate
    public boolean relationship_status;
    public int total_gift_price;
    public int total_gift_value;
    public double happiness;
    public int couple_number;
    public double couple_happiness;
    public int couple_compatibility;
    public void set_name(String a){
        name=a;
    }
     public void set_maintenancebudget(int b){
        
        maintenance_budget=b;
        
    }
      public void set_attractiveness(int c){
        
        
        attractiveness=c;
        
        
        
    }
       public void set_intelligence(int i){
        
        intelligence=i;
        
        
    }
        public void set_status(boolean a){
        
        relationship_status=a;
        
        
    }
    public boolean boy_meets_eligibility(int budget){
        if(maintenance_budget<=budget){
            return true;
        }
        
            return false;
    }
    public String get_name(){
        return name;
    
    }
    public int get_attractiveness(){
        return attractiveness;
    
    }
    public int get_intelligence(){
        return intelligence;
    
    }
    public int get_maintenance_budget(){
        return maintenance_budget;
    
    }
    public boolean get_status(){
        return relationship_status;
    
    }
    public double calc_happiness(int prop){
        int p=prop;
        double h=0;
        switch(p){
            case 1: h=log(total_gift_price);
                    break;
            case 2: h=total_gift_price-maintenance_budget;
                    break;
            case 3: h=exp(total_gift_price-maintenance_budget);
                    break;
        }
    return h;
    }
}
