/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boy;

/**
 *
 * @author aditya
 */
public class boy {
    private String name;
    public String gfname;
    public int budget;
    private int attractiveness;
    private int intelligence;
    private int attraction_requirement;
    private boolean relationship_status;

    
    public void set_details(String a,int b,int c,int i,int ar){
        name=a;
        budget=b;
        attractiveness=c;
        intelligence=i;
        attraction_requirement=ar;
        relationship_status=false;
    }
    public boolean girl_meets_eligiblity(int a,int m){
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
}
