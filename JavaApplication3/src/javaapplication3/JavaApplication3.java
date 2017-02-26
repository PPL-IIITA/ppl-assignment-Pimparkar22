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

import java.io.*;
public class JavaApplication3{
	public static void main(String args[]){
		int i,j;
		i=0;
		j=0;
		Boys b[] = new Boys[1000];
		String csvFile = "";
		String line = "";
		String csvSplit = ",";
		BufferedReader buff = null;
		try{
			buff = new BufferedReader(new FileReader(csvFile));
			while((line = buff.readLine() )!= null){
				String[] boy = line.split(csvSplit);
			//	System.out.println(boy[0] + boy[1] + boy[2] + boy [3]);
				b[i] = new Boys();
			    b[i].name = boy[0];
				b[i].intelligence = Integer.parseInt(boy[1]);
				b[i].attractivness = Integer.parseInt(boy[2]);
				b[i].min_attr_req = Integer.parseInt(boy[3]);
				b[i].budget = Integer.parseInt(boy[4]);
				b[i].girlf="";
				b[i].status = boy[5];
				i++;
			}
		}
		
		catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		Girls g[] = new Girls[1000];
		csvFile = "/ppl-assignment-jarvis004/girls.csv/";
		line = "";
		csvSplit = ",";
		buff = null;
		
		
		try{
			buff = new BufferedReader(new FileReader(csvFile));
			while((line = buff.readLine() )!= null){
				String[] girl = line.split(csvSplit);
			//	System.out.println(boy[0] + boy[1] + boy[2] + boy [3]);
				g[j] = new Girls();
			    g[j].name = girl[0];
				g[j].attar = Integer.parseInt(girl[1]);
				g[j].expense = Integer.parseInt(girl[2]);
				g[j].intelligence = Integer.parseInt(girl[3]);
				g[j].status = girl[4];
				g[j].boyf="";
				j++;
			}
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}finally{
				if(buff != null){
					try{
						buff.close();
					}catch(IOException e){
					e.printStackTrace();
					}
				}
		}
		
	int k,l;
	for(k=0;k<i;k++){
		for(l=0;l<j;l++){
			if(b[k].is_eligible(g[l].expense,g[l].attar) && g[l].is_eligible(b[k].budget) && g[l].status.equals("Single")  && b[k].status.equals("Single") ){
				b[k].girlf = g[l].name;
				g[l].boyf = b[k].name;
				b[k].status = "Is_Committed";
				g[l].status = "Is_Committed";
								
			}
		}
			}
/*	for(k=0;k<i;k++){
		if(b[k].status.equals("Is_Committed")){
			System.out.println(b[k].name +" is committed with "+ b[k].girlf + " "+b[k].status);}
}  */
	}
}