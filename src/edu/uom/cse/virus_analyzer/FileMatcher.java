/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.uom.cse.virus_analyzer;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author Himashi Nethinika
 */
public class FileMatcher {
    public void findFileType(String pathStr){
        
        File f=new File(pathStr);
        Handler.getHandler().getResult().addString(f.getName(), "File Name is        : ");
        
        try {
            Path path=FileSystems.getDefault().getPath(pathStr);
            String contentType=Files.probeContentType(path);
            Handler.getHandler().getResult().addString(contentType, "ContentType is   : ");
        } catch (IOException ex) {
            Logger.getLogger(FileMatcher.class.getName()).log(Level.SEVERE, null, ex);
        }
        String text = FilenameUtils.getExtension(pathStr); 
        Handler.getHandler().getResult().addString(text, "Extension is     : ");
    }
}
