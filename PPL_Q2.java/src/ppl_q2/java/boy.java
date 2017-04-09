/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppl_q2.java;

/**
 *
 * @author aditya
 */
public class boy {
    private String name;
    public String gfname;
    public int property;// 1.miser 2.generous 3.geek
    public int budget;
    private int attractiveness;
    private int intelligence;
    private int attraction_requirement;
    public boolean relationship_status;
    public double happiness;
    public int couple_number;
    public double couple_happiness;
    public int couple_compatibility;
    public void set_name(String a){
        name=a;
       
    }
    public void set_budget(int b){
        
        budget=b;
       
    }
    public void set_attractiveness(int c){
        
        attractiveness=c;
        
    }
    public void set_intelligence(int i){
      
        intelligence=i;
       
    }
    public void set_attraction_requirement(int ar){
    
        attraction_requirement=ar;
        
    }
    public void set_status(boolean a){
        
        relationship_status=a;
    }
    
   
    public boolean girl_meets_eligibility(int a,int m){
        if(m<=budget&&a>=attraction_requirement){
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
    public int attraction_requirement(){
        return attraction_requirement;
    
    }
    public boolean get_status(){
        return relationship_status;
    }
    
}
