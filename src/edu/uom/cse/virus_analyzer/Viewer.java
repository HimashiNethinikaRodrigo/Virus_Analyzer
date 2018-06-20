/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.uom.cse.virus_analyzer;

import com.jezhumble.javasysmon.OsProcess;

/**
 *
 * @author Himashi Nethinika
 */
public class Viewer {
   private final OsProcess osProcess;
    
    public Viewer(OsProcess osProcess){
        this.osProcess = osProcess;
    }
    
    //method overloading
    public OsProcess getOsProcess(){
        return this.osProcess;
    }
    
    public OsProcess getOsProcess(int pid){
        return this.osProcess.find(pid);
    } 
}
