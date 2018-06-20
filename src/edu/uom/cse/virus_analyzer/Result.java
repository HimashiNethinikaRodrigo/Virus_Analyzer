/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.uom.cse.virus_analyzer;

import java.util.ArrayList;

/**
 *
 * @author Himashi Nethinika
 */
public class Result {
    //array list to save results 
    private final ArrayList<String> results=new ArrayList<>();
    //array list to save topic
    private final ArrayList<String> topic=new ArrayList<>();
    
    public void addString(String s,String t){
        results.add(s);
        topic.add(t);
    }

    public ArrayList<String> getResults() {
        return results;
    }

    public ArrayList<String> getTopic() {
        return topic;
    }
}
