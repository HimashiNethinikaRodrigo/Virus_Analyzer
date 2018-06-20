/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.uom.cse.virus_analyzer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Himashi Nethinika
 */
public class HashChecker {
    private final ArrayList<String> hashArrayList=new ArrayList<>();
    
    HashChecker(){
        try (
            BufferedReader br = new BufferedReader(new FileReader(new File("Virus.txt")))) {
            String line;
            while ((line = br.readLine()) != null) {
               hashArrayList.add(line);
            }
        } catch (IOException ex) {
            Logger.getLogger(HashChecker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String checkForHash(String path){
        try {
            FileInputStream inputStream = new FileInputStream(new File(path));
            String md5 = org.apache.commons.codec.digest.DigestUtils.md5Hex(inputStream);
            inputStream.close();
            return md5;
            
        } catch (IOException ex) {
            Logger.getLogger(HashChecker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean isMatched(String path){
        String md5Value=checkForHash(path);
        boolean isSimilar= hashArrayList.contains(md5Value);
        if(isSimilar){
            Handler.getHandler().getResult().addString("This file recognised as virus file", "Status : ");
            Handler.getHandler().getResult().addString(md5Value, "Signature : ");
        
        }
        else{
            Handler.getHandler().getResult().addString("File is not a virus file", "Status : ");
            Handler.getHandler().getResult().addString(md5Value, "Signature : ");
        }
            
        return isSimilar;
                
    }
}
