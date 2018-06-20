/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.uom.cse.virus_analyzer;

/**
 *
 * @author Himashi Nethinika
 */
public class Handler {
    private static Handler handler;
    private final Result result;
    private final FileMatcher fileMatcher;
    private final HashChecker hashChecker;
    private final ProcessMatcher processMatcher;
    
    private Handler(){
        result=new Result();
        hashChecker=new HashChecker();
        fileMatcher=new FileMatcher();
        processMatcher=new ProcessMatcher();
    }
    
    public static Handler getHandler(){
        if(handler==null){
            handler=new Handler();
        }
        return handler;
    }
    
    public Result getResult(){
        return result;
    }
    
    public void checkFileEquality(String path){
        hashChecker.isMatched(path);
        fileMatcher.findFileType(path);
        processMatcher.runProcess(path);
    }
}
