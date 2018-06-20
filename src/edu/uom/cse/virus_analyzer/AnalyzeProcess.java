/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.uom.cse.virus_analyzer;

import com.jezhumble.javasysmon.JavaSysMon;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Himashi Nethinika
 */
public class AnalyzeProcess extends Thread{
   private final JavaSysMon javaSysMon;
    
    private final List<Viewer> viewers;
    
    private int pid;
    
    public AnalyzeProcess() {
        super();
        this.javaSysMon = new JavaSysMon();
        this.viewers = new ArrayList();
    }
    
    
    @Override
    public void run() {
        
        this.pid = this.javaSysMon.currentPid();
        
        while(true){
            try {
                this.viewers.add(new Viewer(this.javaSysMon.processTree()));
                Thread.sleep(150);
            } catch (InterruptedException ex) {
                Logger.getLogger(AnalyzeProcess.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public List<Viewer> getViwers(){
        return this.viewers;
    }
    
    public int getPid(){
        return this.pid;
    } 
}
