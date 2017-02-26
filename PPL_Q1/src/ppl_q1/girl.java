/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppl_q1;

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
    
    public boolean relationship_status;

    
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
        public void set_status(){
        
        relationship_status=false;
        
        
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
}
