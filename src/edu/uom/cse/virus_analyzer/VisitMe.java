/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.uom.cse.virus_analyzer;

import com.jezhumble.javasysmon.OsProcess;
import com.jezhumble.javasysmon.ProcessVisitor;

/**
 *
 * @author Himashi Nethinika
 */
public class VisitMe implements ProcessVisitor{

    @Override
    public boolean visit(OsProcess osProcess, int i) {
        Handler.getHandler().getResult().addString("This is parent : "+ osProcess.processInfo().getParentPid()+" current : "+ osProcess.processInfo().getPid(), "");
        Handler.getHandler().getResult().addString("Children : "+ osProcess.children().size(), "");
        for(Object child: osProcess.children()){
            if(child != null){
                Handler.getHandler().getResult().addString("parent ID : "+ ((OsProcess)child).processInfo().getParentPid(), "");
                Handler.getHandler().getResult().addString("name : "+ ((OsProcess)child).processInfo().getName(),"");
                Handler.getHandler().getResult().addString("command : "+ ((OsProcess)child).processInfo().getCommand(), "");
                Handler.getHandler().getResult().addString("Process Id : " + ((OsProcess)child).processInfo().getPid(), "");

            }
        }
        return false;
    }
    
}
