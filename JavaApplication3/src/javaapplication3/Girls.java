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
public class Girls {
	String name;
	int attar;
	int expense;
	int intelligence;
	String boyf;
	String status;
	

	boolean is_eligible(int budget){
	if (this.expense <= budget) {
			return true;
		}
	else {
			return false;
		}
	}
	
}
