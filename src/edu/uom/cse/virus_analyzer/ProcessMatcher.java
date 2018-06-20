/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.uom.cse.virus_analyzer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Himashi Nethinika
 */
public class ProcessMatcher {
    public void runProcess(String path) {
        try {
            AnalyzeProcess analyzeProcess = new AnalyzeProcess();
            analyzeProcess.start();
            
            Process process = Runtime.getRuntime().exec(path);
            InputStream inputStream = process.getErrorStream();
            
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            //BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            
            //String line;
                        
            int i=0;
            while(i<10){
                i+=1;
                try {
                    Thread.sleep(150);
                    
                } catch (InterruptedException ex) {
                    Logger.getLogger(ProcessMatcher.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            
            analyzeProcess.stop();
            
            process.destroy();
            Viewer viewer=analyzeProcess.getViwers().get(analyzeProcess.getViwers().size()-1);
            Handler.getHandler().getResult().addString("", "--------Following shows process tree---------");
            viewer.getOsProcess(analyzeProcess.getPid()).accept(new VisitMe(), 0);
            
        } catch (IOException ex) {
            Handler.getHandler().getResult().addString("", "This is not an executable file");

        }
    }
}
