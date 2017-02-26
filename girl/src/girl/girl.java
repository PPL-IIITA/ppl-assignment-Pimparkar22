/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package girl;

/**
 *
 * @author aditya
 */
public class girl {
    private String name;
    public String bfname;
    private int maintanence_budget;
    private int attractiveness;
    private int intelligence;
    
    private boolean relationship_status;

    
    public void set_details(String a,int b,int c,int i){
        name=a;
        maintanence_budget=b;
        attractiveness=c;
        intelligence=i;
        
        relationship_status=false;
    }
    public boolean boy_meets_eligiblity(int budget){
        if(maintanence_budget<=budget){
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
    public int maintanence_budget(){
        return maintanence_budget;
    
    }
}
