/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

/**
 *
 * @author aditya
 */
public class Boys {
	String name;
	int intelligence;
	int attractivness;
	int min_attr_req;
	int budget;
	String girlf;
	String status;
	


	boolean is_eligible(int expense,int attar){
		if (this.budget >= expense && this.min_attr_req <= attar){
			return true;
		}else{
			return false;
		}
			
		}
	}
