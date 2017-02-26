/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csv_reader;

/**
 *
 * @author aditya
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Csv_reader {

    public static void main(String[] args) {

        String csvFile;
        csvFile = "/home/aditya/Desktop/h.csv";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] country = line.split(cvsSplitBy);

                System.out.println("name " + country[0] + " , attr" + country[1] + "]");

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}